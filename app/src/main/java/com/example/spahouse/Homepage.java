package com.example.spahouse;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Homepage extends AppCompatActivity implements View.OnClickListener {

    public CardView cav1,cav2,cav3,cav4,cav5,cav6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        cav1 = (CardView) findViewById(R.id.spa1);
        cav1.setCardBackgroundColor(Color.WHITE);

        cav2 = (CardView) findViewById(R.id.spa2);
        cav2.setCardBackgroundColor(Color.WHITE);

        cav2 = (CardView) findViewById(R.id.spa3);
        cav2.setCardBackgroundColor(Color.WHITE);


        cav1.setOnClickListener(this);
        cav2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.spa1:
                i = new Intent(this,cal.class);
                startActivity(i);
                break;

            case R.id.spa2:
                i = new Intent(this,Payment.class);
                startActivity(i);
                break;

            case R.id.spa3:
                i = new Intent(this,Payment.class);
                startActivity(i);
                break;


        }
    }
}
