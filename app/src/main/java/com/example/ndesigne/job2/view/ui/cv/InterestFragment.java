package com.example.ndesigne.job2.view.ui.cv;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ndesigne.job2.R;

public class InterestFragment extends Fragment {

    public InterestFragment() {
        // Required empty public constructor
    }

    EditText inerest;

    public String iCentre;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inerest, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inerest = (EditText)view.findViewById(R.id.et_interest_frag);
    }

    public String reTriveData(){
        iCentre ="";
        iCentre = inerest.getText().toString();
        return iCentre;
    }

}
