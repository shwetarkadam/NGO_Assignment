package com.example.hp.awaazngo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ContactUsFragment extends Fragment {

    Button button2;
    Button address;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_contact_us, container, false);
        button2=v.findViewById(R.id.button2);
        address=v.findViewById(R.id.button_address);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"theawaazthengo@gmail.com"," info@awaazngo.org"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "My Query:");
                intent.createChooser(intent, "Send email");
            startActivity(intent);
            }
        });

       address.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       Uri gmmIntentUri = Uri.parse("geo:28.4032725,77.8454314?q=AWAAZ HEAD OFFICE, 786/21, PREET VIHAR COLONY, NEAR KALA AAM, BEHIND KUCHERI, BULANDSHAHR (203001), Laxmi Nagar, Bulandshahr, Uttar Pradesh 203001");
                       Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                       mapIntent.setPackage("com.google.android.apps.maps");
                       startActivity(mapIntent);
                   }
               }, 1000);
           }

       });
        return v;
    }




}
