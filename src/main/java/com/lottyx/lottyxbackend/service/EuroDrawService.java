package com.lottyx.lottyxbackend.service;

import com.lottyx.lottyxbackend.model.EuroDraw;

import java.util.List;

public interface EuroDrawService {
    public EuroDraw postNewEuroDraw( EuroDraw euroDraw);
    public EuroDraw getEuroDrawById(Long id);
    public List<EuroDraw> getAllEuroDraws();
    public EuroDraw updateEuroDraw(EuroDraw euroDraw);
    public void deleteEuroDrawById(Long id);
}
