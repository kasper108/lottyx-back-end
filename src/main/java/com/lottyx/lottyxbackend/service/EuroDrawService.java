package com.lottyx.lottyxbackend.service;

import com.lottyx.lottyxbackend.model.EuroDraw;
import com.lottyx.lottyxbackend.repository.EuroDrawRepository;
import exception.DrawNotFoundException;
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
                ("Draw with ID = " + id + " NOT found i database"));
    }
}
