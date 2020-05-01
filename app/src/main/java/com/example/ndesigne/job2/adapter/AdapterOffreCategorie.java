package com.example.ndesigne.job2.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ndesigne.job2.R;
import com.example.ndesigne.job2.entities.OffreCategorie;
import com.example.ndesigne.job2.viewholder.CatOffreViewHolder;

import java.util.ArrayList;

public class AdapterOffreCategorie extends RecyclerView.Adapter<CatOffreViewHolder> {

    //la variable qui nous permettra d'inflater nous vue
    LayoutInflater inflater;
    
    //la liste des elements a afficher
    ArrayList<OffreCategorie> list ;

    public AdapterOffreCategorie(LayoutInflater inflater, ArrayList<OffreCategorie> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public CatOffreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View co = inflater.inflate(R.layout.categorie_offre, viewGroup, false);
        return new CatOffreViewHolder(co);
    }

    @Override
    public void onBindViewHolder(@NonNull CatOffreViewHolder catOffreViewHolder, int position) {
            //on recupere l'offre a afficher
            OffreCategorie oc = list.get(position);
            catOffreViewHolder.text.setText(oc.getTitre());

            //le layoutmanager permet d'afficher e recycleview a l'horizontal
            LinearLayoutManager layoutManager = new LinearLayoutManager(catOffreViewHolder.text.getContext());

            //on definit son orientation
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            catOffreViewHolder.recyclerView.setLayoutManager(layoutManager);
            catOffreViewHolder.recyclerView.setAdapter(new AdapterOffreH(oc.getData(),inflater));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
