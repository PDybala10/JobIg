package com.example.ndesigne.job2.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ndesigne.job2.MainActivity;
import com.example.ndesigne.job2.R;
import com.example.ndesigne.job2.adapter.AdapterOffreCategorie;
import com.example.ndesigne.job2.entities.Offre;
import com.example.ndesigne.job2.entities.OffreCategorie;
import com.example.ndesigne.job2.preferences.OffrePreference;
import com.example.ndesigne.job2.service.Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private static String BASE_URL = "https://jobs.github.com/";

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerViewOffre;
    private RecyclerView.Adapter adapter;
    private List<Offre> offreList = new ArrayList<Offre>();
    private SharedPreferences preferences;
    private Gson gson;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
      /*  final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        recyclerViewOffre = root.findViewById(R.id.recycle_view_fragment_home);

       preferences =  getContext().getSharedPreferences(OffrePreference.PREFERENCE_NAME, Context.MODE_PRIVATE);

        gson = new GsonBuilder()
                .setLenient()
                .create();
        List<Offre> listOffresPreferences = getDataPreferences();
        if(listOffresPreferences != null){

           buildRecycleView(listOffresPreferences);
        }
        else {
            MakeApiCall();
        }

        return root;
    }

    private List<Offre> getDataPreferences() {
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

    private void MakeApiCall(){

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
                    buildRecycleView(offreList);
                    Toast.makeText(MainActivity.MY_CONTEXT,"serveur good",Toast.LENGTH_SHORT).show();
                }
                else {
                    showError();
                }
            }

            @Override
            public void onFailure(Call<List<Offre>> call, Throwable t) {
                showError();
            }
        });
    }

    private void savePreferences(List<Offre> offreList) {
        String jsonString = gson.toJson(offreList);

        preferences
                .edit()
                .putString(OffrePreference.PREFERENCE_KEY, jsonString)
                .apply();

        Toast.makeText(MainActivity.MY_CONTEXT," list saved",Toast.LENGTH_SHORT).show();
    }

    private void showError() {
        Toast.makeText(MainActivity.MY_CONTEXT,"erreur serveur",Toast.LENGTH_LONG).show();
    }

    public void buildRecycleView(List<Offre> offres){
        /*   ici on contruit les recycleViews     */

        //la liste des categorie
        ArrayList<OffreCategorie> listOffres = new ArrayList<OffreCategorie>();
        //on initialise la liste

            OffreCategorie categorie = new OffreCategorie();
            categorie = createCategorie("Engineer",offres);
            listOffres.add(categorie);
            OffreCategorie categorie1 = new OffreCategorie();
            categorie1 = createCategorie("Developer",offres);
            listOffres.add(categorie1);
            OffreCategorie categorie2 = new OffreCategorie();
            categorie2 = createCategorie("Mobile",offres);
            listOffres.add(categorie2);
            OffreCategorie categorie3 = new OffreCategorie();
            ArrayList<String> stringList = new ArrayList<String>();
            stringList.add("Engineer");
            stringList.add("Developer");
            stringList.add("Mobile");
            categorie3 = createCategorieAutre(stringList,offres);
            listOffres.add(categorie3);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.MY_CONTEXT);
        recyclerViewOffre.setLayoutManager(layoutManager);
        //on ajoute a la liste son adapter
        adapter = new AdapterOffreCategorie(LayoutInflater.from(MainActivity.MY_CONTEXT),listOffres);
        recyclerViewOffre.setAdapter(adapter);

        /*   ici on contruit les recycleViews     */
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
            if(findWords(nameCategorie,offres.get(i).getTitle()) == true || findWords(nameCategorie.toLowerCase(),offres.get(i).getTitle().toLowerCase()) == true ){
                categorie.getData().add(offres.get(i));
            }
        }
        return categorie;
    }

    public OffreCategorie createCategorieAutre(ArrayList<String> nameCategorie, List<Offre> offres){
        OffreCategorie categorie = new OffreCategorie();
        boolean test = false;
        categorie.setTitre("Autres");
        for (int i=0; i<offres.size(); i++){
            test = false;
            for (int j=0; j<nameCategorie.size(); j++){
                if(findWords(nameCategorie.get(j),offres.get(i).getTitle()) == true || findWords(nameCategorie.get(j).toLowerCase(),offres.get(i).getTitle().toLowerCase()) == true){
                    test= true;
                }

            }
            if (test == false){
                categorie.getData().add(offres.get(i));
            }

        }
        return categorie;

    }

}
