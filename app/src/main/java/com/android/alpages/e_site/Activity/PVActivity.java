package com.android.alpages.e_site.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.alpages.e_site.R;

public class PVActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pv);

        ImageView button_constat = (ImageView)findViewById(R.id.button_constat);

        button_constat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(PVActivity.this, ConstatActivity.class);
                startActivity(myIntent);
            }
        });

    }
}
