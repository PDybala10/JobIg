package com.example.ndesigne.job2.view;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ndesigne.job2.R;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Element adsElement = new Element();
        adsElement.setTitle("Advertise Here");

        View aboutPage = new AboutPage(this)
                        .isRTL(false)
                        .setImage(R.drawable.logo)
                        .setDescription("This is Android version")
                        .addItem(new Element().setTitle("Version 1.0"))
                        .addItem(adsElement)
                        .addGroup("connect with me")
                        .addEmail("ndesigne@et.esiea.fr")
                        .addItem(createCopyright())
                        .create();

        setContentView(aboutPage);
    }

    private Element createCopyright() {
            Element copyRight = new Element();
            final String copyRightString = String.format("CopyRight %d by Igor Nde", Calendar.getInstance().get(Calendar.YEAR));
            copyRight.setTitle(copyRightString);
            copyRight.setIcon(R.mipmap.ic_launcher);
            copyRight.setGravity(Gravity.CENTER);
            copyRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(AboutUs.this, copyRightString, Toast.LENGTH_SHORT).show();
                }
            });
            return copyRight;
    }
}
