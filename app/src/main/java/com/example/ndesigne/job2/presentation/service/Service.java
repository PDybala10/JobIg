package com.example.ndesigne.job2.presentation.service;


import com.example.ndesigne.job2.model.Offre;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;

public interface Service {
    //TODO: Definir le model des offres
    @GET("/positions.json?location=Europe")
    Call<List<Offre>> getAllOffre();



}
