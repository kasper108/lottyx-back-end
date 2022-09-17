package com.lottyx.lottyxbackend.controller;

import com.lottyx.lottyxbackend.model.EuroDraw;
import com.lottyx.lottyxbackend.service.EuroDrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
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
}
