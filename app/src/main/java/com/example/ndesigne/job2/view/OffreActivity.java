package com.example.ndesigne.job2.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ndesigne.job2.R;
import com.example.ndesigne.job2.controller.OffreController;
import com.example.ndesigne.job2.presentation.network.InternetConnection;
import com.example.ndesigne.job2.view.adapter.AdapterOffreH;
import com.squareup.picasso.Picasso;


public class OffreActivity extends AppCompatActivity {

    private ImageView imageOffre;
    private  TextView title_offre;
    private TextView description_offre;
    private TextView location_offre;
    private  TextView create_offre;
    private ImageView applyOffre;
    private ImageView shareOffre;
    private ImageView web_offre;



    @SuppressLint("SetTextI18n")
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
        applyOffre = findViewById(R.id.apply_offre);
        shareOffre = findViewById(R.id.share_offre);
        web_offre = findViewById(R.id.web_offre);

        /*modification des éléments*/
        title_offre.setText(OffreController.cleanString2(AdapterOffreH.o.getTitle()));
        description_offre.setText(OffreController.cleanString(AdapterOffreH.o.getDescription()));
        location_offre.setText("Location : "+AdapterOffreH.o.getLocation());
        create_offre.setText("Date of creation : "+AdapterOffreH.o.getCreated_at());

        /*Recuperation  de l'image*/
      if(InternetConnection.checkConnection(getApplicationContext())){
            String url = AdapterOffreH.o.getCompany_logo();
            Picasso.with(this).load(url).resize(461, 134).into(imageOffre);
        }
      else {

          imageOffre.setImageResource(R.drawable.ic_signal_wifi_off_black_24dp);

      }

        final String site = AdapterOffreH.o.getCompany_url().toString();
        final String apply = OffreController.cleanString(AdapterOffreH.o.getHow_to_apply().toString());
        applyOffre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try {
                   Intent browserItem = new Intent(Intent.ACTION_VIEW, Uri.parse(apply));
                   startActivity(browserItem);
               }catch (Exception e){
                   Toast.makeText(MainActivity.MY_CONTEXT,"indisponible veillez retouvez l'offre sur le site via le bouton à gauche", Toast.LENGTH_LONG).show();
               }

            }
        });

        web_offre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent browserItem = new Intent(Intent.ACTION_VIEW, Uri.parse(site));
                    startActivity(browserItem);
                }catch (Exception e){
                    Toast.makeText(MainActivity.MY_CONTEXT," site indisponible", Toast.LENGTH_SHORT).show();
                }
            }
        });
        shareOffre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT, description_offre.getText());
                    intent.setType("text/plain");
                    intent = Intent.createChooser(intent, "Share by");
                    startActivity(intent);

            }
        });

        AdapterOffreH.o = null;
    }


}
