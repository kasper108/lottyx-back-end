package com.lottyx.lottyxbackend.controller;

import com.lottyx.lottyxbackend.model.EuroDraw;
import com.lottyx.lottyxbackend.service.EuroDrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin( allowedHeaders = "*", origins = "*")
@RequestMapping("/api/v1/")
public class EuroDrawController {

    private final EuroDrawService euroDrawService;

    @Autowired
    public EuroDrawController( EuroDrawService euroDrawService ) {
        this.euroDrawService = euroDrawService;
    }

    @GetMapping("/euro-draw")
    public ResponseEntity<List<EuroDraw>> findAllEuroDraws(){
        List<EuroDraw> allDraws = euroDrawService.getAllEuroDraws();
        return new ResponseEntity<>(allDraws, HttpStatus.OK);
    }

    @PostMapping("/euro-draw")
    public ResponseEntity<EuroDraw> addNewEuroDraw(@RequestBody EuroDraw draw){
        EuroDraw newDraw = euroDrawService.postNewEuroDraw(draw);
        return new ResponseEntity<>(newDraw, HttpStatus.OK);
    }

    @GetMapping("/euro-draw/{id}")
    public ResponseEntity<EuroDraw> findEuroDraw(@PathVariable("id") Long id){
        EuroDraw foundedEuroDraw = euroDrawService.getEuroDraw(id);
        return new ResponseEntity<>(foundedEuroDraw,HttpStatus.OK);
    }

    @DeleteMapping("/euro-draw/{id}")
    public ResponseEntity<?> removeEuroDraw(@PathVariable("id") Long id){
        euroDrawService.deleteEuroDraw(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/euro-draw/")
    public EuroDraw editEuroDraw(@RequestBody EuroDraw euroDraw){
        return euroDrawService.updateEuroDraw(euroDraw);
    }

}
