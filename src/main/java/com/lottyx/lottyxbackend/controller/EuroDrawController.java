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

    @GetMapping("/euro-draws")
    public ResponseEntity<List<EuroDraw>> getAllEuroDraws(){
        List<EuroDraw> allDraws = euroDrawService.findAllEuroDraws();
        return new ResponseEntity<>(allDraws, HttpStatus.OK);
    }

    @PostMapping("/euro-draws")
    public ResponseEntity<EuroDraw> postNewEuroDraw(@RequestBody EuroDraw draw){
        EuroDraw newDraw = euroDrawService.addNewEuroDraw(draw);
        return new ResponseEntity<>(newDraw, HttpStatus.OK);
    }
}
