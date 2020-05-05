package com.example.ndesigne.job2.view.ui.home;

import android.content.Context;
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

import com.example.ndesigne.job2.R;
import com.example.ndesigne.job2.controller.HomeFragmentController;
import com.example.ndesigne.job2.model.Offre;
import com.example.ndesigne.job2.model.OffreCategorie;
import com.example.ndesigne.job2.presentation.preferences.OffrePreference;
import com.example.ndesigne.job2.view.MainActivity;
import com.example.ndesigne.job2.view.adapter.AdapterOffreCategorie;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {



    private HomeViewModel homeViewModel;
    private RecyclerView recyclerViewOffre;
    private RecyclerView.Adapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewOffre = root.findViewById(R.id.recycle_view_fragment_home);

        HomeFragmentController controller = new HomeFragmentController(this,
                new GsonBuilder()
                         .setLenient()
                         .create(),
                getContext().getSharedPreferences(OffrePreference.PREFERENCE_NAME, Context.MODE_PRIVATE)
                );


        controller.onStart();

        return root;
    }


    public void showError() {
        Toast.makeText(MainActivity.MY_CONTEXT,"erreur serveur",Toast.LENGTH_LONG).show();
    }

    public void buildRecycleView(List<Offre> offres, HomeFragmentController controller){
        /*   ici on contruit les recycleViews     */

        //la liste des categorie
        ArrayList<OffreCategorie> listOffres = new ArrayList<OffreCategorie>();
        //on initialise la liste

            OffreCategorie categorie = new OffreCategorie();
            categorie = controller.createCategorie("Engineer",offres);
            listOffres.add(categorie);
            OffreCategorie categorie1 = new OffreCategorie();
            categorie1 = controller.createCategorie("Developer",offres);
            listOffres.add(categorie1);
            OffreCategorie categorie2 = new OffreCategorie();
            categorie2 = controller.createCategorie("Mobile",offres);
            listOffres.add(categorie2);
            OffreCategorie categorie3 = new OffreCategorie();
            ArrayList<String> stringList = new ArrayList<String>();
            stringList.add("Engineer");
            stringList.add("Developer");
            stringList.add("Mobile");
            categorie3 = controller.createCategorieAutre(stringList,offres);
            listOffres.add(categorie3);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.MY_CONTEXT);
        recyclerViewOffre.setLayoutManager(layoutManager);
        //on ajoute a la liste son adapter
        adapter = new AdapterOffreCategorie(LayoutInflater.from(MainActivity.MY_CONTEXT),listOffres);
        recyclerViewOffre.setAdapter(adapter);

        /*   ici on contruit les recycleViews     */
    }

}
