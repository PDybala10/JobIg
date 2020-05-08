package com.example.ndesigne.job2.view;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import com.example.ndesigne.job2.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mainActivity = null;



    @Before
    public void setUp() throws Exception {
        mainActivity = mainActivityActivityTestRule.getActivity();
    }

    @Test
    public  void  testLaunch(){
        View view = mainActivity.findViewById(R.id.nav_contact_us);
        testLaunch();

    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }
}