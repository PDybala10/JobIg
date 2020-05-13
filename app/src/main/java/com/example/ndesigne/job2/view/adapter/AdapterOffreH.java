package com.example.ndesigne.job2.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ndesigne.job2.controller.OffreController;
import com.example.ndesigne.job2.view.MainActivity;
import com.example.ndesigne.job2.R;
import com.example.ndesigne.job2.model.Offre;
import com.example.ndesigne.job2.view.viewholder.OffreViewH;

import java.util.ArrayList;

/**
 * Cette classe est l'adapter qui nous permet d'afficher les card_offre a l'horizontal
 * elle possede deux attributs:
 *  -list ArrayList<Offre></Offre>: la liste des elements a afficher
 *  -inflater LayoutInflter: permet de creer la vue en fonction de l'element a afficher
 * */
public class AdapterOffreH extends RecyclerView.Adapter<OffreViewH> {

    //la liste des element a afficher
    ArrayList<Offre> list;

    //le LayoutInflater
    LayoutInflater inflater;

    //definit l'id de l'offre a la quelle on veut acceder
    public static  Offre o;

    public AdapterOffreH(ArrayList<Offre> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }

    @NonNull
    @Override
        public OffreViewH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View ov = inflater.inflate(R.layout.card_offre,viewGroup,false);
        return new OffreViewH(ov);
    }

    @Override
    public void onBindViewHolder(@NonNull final OffreViewH offreViewH, final int i) {

            o = list.get(i);

        //on met a jour les element de la vue
          offreViewH.titleOffre.setText(OffreController.cleanString2(o.getTitle()));
          offreViewH.companyOffre.setText(o.getCompany());
          offreViewH.locationOffre.setText(o.getLocation());
          offreViewH.dateOffre.setText(o.getCreated_at());
          offreViewH.typeOffre.setText(o.getType());

        offreViewH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    MainActivity.openOffre(i);
                    o = list.get(i);
                }catch (Exception e){
                    Toast.makeText(MainActivity.MY_CONTEXT,"l'offre n'est plus disponible",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
