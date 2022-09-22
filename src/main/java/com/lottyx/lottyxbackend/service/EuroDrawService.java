package com.lottyx.lottyxbackend.service;

import com.lottyx.lottyxbackend.model.EuroDraw;
import com.lottyx.lottyxbackend.repository.EuroDrawRepository;
import com.lottyx.lottyxbackend.exception.DrawNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EuroDrawService {

    private final EuroDrawRepository euroDrawRepository;

    @Autowired
    public EuroDrawService( EuroDrawRepository euroDrawRepository ) {
        this.euroDrawRepository = euroDrawRepository;
    }

    public List<EuroDraw> findAllEuroDraws(){
        return euroDrawRepository.findAll();
    }

    public EuroDraw addNewEuroDraw(EuroDraw euroDraw){
        return euroDrawRepository.save(euroDraw);
    }

    public void deleteEuroDraw(Long id){
        euroDrawRepository.deleteById(id);
    }

    public EuroDraw getEuroDraw(Long id){
        return euroDrawRepository.findById(id).orElseThrow(() -> new DrawNotFoundException
                ("LOTTYX : Draw with ID = " + id + " NOT found i database"));
    }

    public EuroDraw updateEuroDraw(EuroDraw euroDraw){
        EuroDraw euroDrawFound = euroDrawRepository.findById(euroDraw.getId()).
                orElseThrow(() -> new DrawNotFoundException("LOTTYX : Draw with ID = " + euroDraw.getId() + " NOT found i database"));

        euroDrawFound.setDrawDate(euroDraw.getDrawDate());
        euroDrawFound.setNumberOne(euroDraw.getNumberOne());
        euroDrawFound.setNumberTwo(euroDraw.getNumberTwo());
        euroDrawFound.setNumberThree(euroDraw.getNumberThree());
        euroDrawFound.setNumberFour(euroDraw.getNumberFour());
        euroDrawFound.setNumberFive(euroDraw.getNumberFive());
        euroDrawFound.setAdditionalOne(euroDraw.getAdditionalOne());
        euroDrawFound.setAdditionalTwo(euroDraw.getAdditionalTwo());

        return euroDrawRepository.save(euroDrawFound);
    }
}
