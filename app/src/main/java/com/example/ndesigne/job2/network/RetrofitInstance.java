package com.example.ndesigne.job2.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    //instance retrofit qui sera cree
    private static Retrofit retrofit = null;
    /**
     * l'adresse url de base de l'api
     * TODO: Remplacer cette adresse par l'adresse effective une deploye
     * */

    private static String BASE_URL = "https://jobs.github.com";

    /**
     * Retourne une instance retrofit a base de BASE_URL
     * */
    public static Retrofit getRetrofitInstance(){
        if (retrofit == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

}
