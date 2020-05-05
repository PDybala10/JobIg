package com.example.ndesigne.job2.view.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ndesigne.job2.R;

public class CatOffreViewHolder extends RecyclerView.ViewHolder {

    public TextView text;
    public RecyclerView recyclerView;


    public CatOffreViewHolder(@NonNull View itemView) {
        super(itemView);
        text = itemView.findViewById(R.id.text_titre_categorie_offre);
        recyclerView = itemView.findViewById(R.id.recycle_view_categorie_offre);
    }
}
