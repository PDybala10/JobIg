package com.example.ndesigne.job2.viewholder;


import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ndesigne.job2.R;


public class OffreViewH extends RecyclerView.ViewHolder {

    public TextView titleOffre;
    public TextView companyOffre;
    public TextView locationOffre;
    public TextView dateOffre;
    public TextView typeOffre;

    public RelativeLayout base;

    public OffreViewH(@NonNull View itemView) {
        super(itemView);
        base = (RelativeLayout)itemView;
        titleOffre= itemView.findViewById(R.id.title_offre);
        companyOffre= itemView.findViewById(R.id.company_offre);
        locationOffre= itemView.findViewById(R.id.location_offre);
        dateOffre= itemView.findViewById(R.id.text_date_card_offre);
        typeOffre = itemView.findViewById(R.id.location_type);
    }
}
