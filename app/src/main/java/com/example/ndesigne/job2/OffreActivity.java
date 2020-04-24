package com.example.ndesigne.job2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ndesigne.job2.R;
import com.example.ndesigne.job2.adapter.AdapterOffreH;
import com.example.ndesigne.job2.entities.Offre;
import com.squareup.picasso.Picasso;


public class OffreActivity extends AppCompatActivity {

    //Offre offre;
    private ImageView imageOffre;
    private  TextView title_offre;
    private TextView description_offre;
    private TextView location_offre;
    private  TextView create_offre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offre);

        /* Récupérations des élements */
        imageOffre = findViewById(R.id.company_logo_offre_activity);
        title_offre = findViewById(R.id.title_offre_activity);
        description_offre = findViewById(R.id.tv_description_offre_activity);
        location_offre = findViewById(R.id.location_offre_activity);
        create_offre = findViewById(R.id.create_offre_activity);

        /*modification des éléments*/
        title_offre.setText(AdapterOffreH.o.getTitle());
        description_offre.setText(AdapterOffreH.o.getDescription());
        location_offre.setText(AdapterOffreH.o.getLocation());
        create_offre.setText(AdapterOffreH.o.getCreated_at());

        /*Recuperation  de l'image*/
        String url = AdapterOffreH.o.getCompany_logo();
        Picasso.with(this).load(url).resize(451,134).into(imageOffre);


        AdapterOffreH.o = null;
    }

    public void arrawBack(View v){
        this.finish();

    }

}
