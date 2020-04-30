package com.example.ndesigne.job2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ndesigne.job2.entities.Offre;
import com.example.ndesigne.job2.ui.slideshow.SlideshowFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {


    private static TextView title_offre;
    private AppBarConfiguration mAppBarConfiguration;
    public static Context MY_CONTEXT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivity.MY_CONTEXT = this;

        setContentView(R.layout.activity_main);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.MY_CONTEXT, MakeCvActivity.class);
                startActivity(intent);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_create_cv :
                        Intent intent = new Intent(MainActivity.MY_CONTEXT, MakeCvActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_contact_us :
                        Toast.makeText(getApplicationContext(), "Igor NDE",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_share_app:
                        Toast.makeText(getApplicationContext(), "Igor NDE",Toast.LENGTH_LONG).show();
                        break;
                }
                drawer.closeDrawers();
                return false;
            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    //Cette fontion sera appeler a chaque fois qu'on voudra ouvrir une offre
    public static void openOffre(int id){
        /*title_offre = findViewById(R.id.title_offre_activity);
        title_offre.setText(offre.getTitle());*/
        Intent intent = new Intent(MainActivity.MY_CONTEXT, OffreActivity.class);
        MainActivity.MY_CONTEXT.startActivity(intent);



    }

}
