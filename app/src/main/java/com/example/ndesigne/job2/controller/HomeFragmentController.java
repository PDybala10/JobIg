package com.example.ndesigne.job2.controller;

import android.content.SharedPreferences;

import com.example.ndesigne.job2.model.Offre;
import com.example.ndesigne.job2.model.OffreCategorie;
import com.example.ndesigne.job2.presentation.network.InternetConnection;
import com.example.ndesigne.job2.presentation.preferences.OffrePreference;
import com.example.ndesigne.job2.presentation.service.Service;
import com.example.ndesigne.job2.view.MainActivity;
import com.example.ndesigne.job2.view.ui.home.HomeFragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragmentController {
    private SharedPreferences preferences;
    private Gson gson;
    private static String BASE_URL = "https://jobs.github.com/";
    private List<Offre> offreList = new ArrayList<Offre>();
    HomeFragment view;

    public HomeFragmentController(HomeFragment view, Gson gson, SharedPreferences preferences) {
        this.view =view;
        this.gson = gson;
        this.preferences = preferences;
    }


    public List<Offre> getDataPreferences() {
        String jsonOffre =  preferences.getString(OffrePreference.PREFERENCE_KEY,null);

        if(jsonOffre == null) {
            return null;
        }
        else {
            Type type = new TypeToken<List<Offre>>() {
            }.getType();
            return gson.fromJson(jsonOffre, type);
        }
    }

    public void makeApiCall(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        Service service = retrofit.create(Service.class);

        Call<List<Offre>> call = service.getAllOffre();
        call.enqueue(new Callback<List<Offre>>() {
            @Override
            public void onResponse(Call<List<Offre>> call, Response<List<Offre>> response) {
                if (response.isSuccessful() && response.body() != null){
                    for(int i=0; i<response.body().size(); i++) {

                        offreList.add(response.body().get(i));

                    }
                    savePreferences(offreList);
                    view.buildRecycleView(offreList,HomeFragmentController.this);
                   // Toast.makeText(MainActivity.MY_CONTEXT,"serveur good",Toast.LENGTH_SHORT).show();
                }
                else {
                    view.showError();

                }
            }

            @Override
            public void onFailure(Call<List<Offre>> call, Throwable t) {
                view.showError();
            }
        });
    }

    public void onStart(){

        List<Offre> listOffresPreferences = getDataPreferences();

        if(listOffresPreferences != null && !InternetConnection.checkConnection(view.getContext()) ){

            view.buildRecycleView(listOffresPreferences,HomeFragmentController.this);

        }
        else if(MainActivity.start == 0) {
         MainActivity.start = 1;
        makeApiCall();

        }
        else {
            view.buildRecycleView(listOffresPreferences,HomeFragmentController.this);
        }
    }

    private void savePreferences(List<Offre> offreList) {
        String jsonString = gson.toJson(offreList);

        preferences
                .edit()
                .putString(OffrePreference.PREFERENCE_KEY, jsonString)
                .apply();

     //   Toast.makeText(MainActivity.MY_CONTEXT," list saved",Toast.LENGTH_SHORT).show();
    }

    public OffreCategorie createCategorieAutre(ArrayList<String> nameCategorie, List<Offre> offres){
        OffreCategorie categorie = new OffreCategorie();
        boolean test = false;
        categorie.setTitre("Autres");
        for (int i=0; i<offres.size(); i++){
            test = false;
            for (int j=0; j<nameCategorie.size(); j++){
                if(findWords(nameCategorie.get(j), offres.get(i).getTitle()) || findWords(nameCategorie.get(j).toLowerCase(), offres.get(i).getTitle().toLowerCase())){
                    test= true;
                }

            }
            if (!test){
                categorie.getData().add(offres.get(i));
            }

        }
        return categorie;

    }

    public boolean findWords(String wordFound, String wordFind){

        int pos = wordFind.indexOf(wordFound);
        if(pos != -1){
            return true;
        }
        else {
            return false;
        }
    }

    public OffreCategorie createCategorie(String nameCategorie, List<Offre> offres){
        OffreCategorie categorie = new OffreCategorie();
        categorie.setTitre(nameCategorie);
        for (int i=0; i<offres.size(); i++){
            if(findWords(nameCategorie, offres.get(i).getTitle()) || findWords(nameCategorie.toLowerCase(), offres.get(i).getTitle().toLowerCase())){
                categorie.getData().add(offres.get(i));
            }
        }
        return categorie;
    }


}
