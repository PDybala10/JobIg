package com.example.ndesigne.job2;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ndesigne.job2.R;
import com.example.ndesigne.job2.entities.Offre;


public class OffreActivity extends AppCompatActivity {

    Offre offre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offre);
    }

    public void arrawBack(View v){
        this.finish();
    }
}
