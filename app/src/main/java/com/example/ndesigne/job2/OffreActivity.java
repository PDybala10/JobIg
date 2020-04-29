package com.example.ndesigne.job2;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ndesigne.job2.R;
import com.example.ndesigne.job2.adapter.AdapterOffreH;
import com.example.ndesigne.job2.entities.Offre;
import com.squareup.picasso.Picasso;

import java.util.concurrent.CopyOnWriteArraySet;


public class OffreActivity extends AppCompatActivity {

    //Offre offre;
    private ImageView imageOffre;
    private  TextView title_offre;
    private TextView description_offre;
    private TextView location_offre;
    private  TextView create_offre;
    private ImageView applyOffre;
    private ImageView shareOffre;
    private ImageView copy_offre;



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
        copy_offre = findViewById(R.id.copy_offre);

        /*modification des éléments*/
        title_offre.setText(AdapterOffreH.o.getTitle());
        description_offre.setText(CleanString(AdapterOffreH.o.getDescription()));
        location_offre.setText("Location : "+AdapterOffreH.o.getLocation());
        create_offre.setText("Date of creation : "+AdapterOffreH.o.getCreated_at());

        /*Recuperation  de l'image*/
        String url = AdapterOffreH.o.getCompany_logo();
        Picasso.with(this).load(url).resize(461,134).into(imageOffre);
        System.out.println(AdapterOffreH.o.getCompany_url());
        System.out.println(AdapterOffreH.o.getHow_to_apply());
        applyOffre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        copy_offre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("EditText", description_offre.getText().toString());
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(), "Copied",Toast.LENGTH_SHORT).show();
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

    public void arrawBack(View v){
        this.finish();

    }

    String CleanString(String chaine){
        String s="";
        int j = 0;
        char arr[]=chaine.toCharArray();
        for(int i=0;i<arr.length;i++){

            if (arr[i] == '<') {
                j = 1;
            }

            if(j == 0) {
                s = s + arr[i];
            }
            if (arr[i] == '>'){
                j = 0;
            }
        }
        return s;
    }



}
