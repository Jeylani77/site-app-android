package com.android.alpages.e_site.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.android.alpages.e_site.R;

public class DosierActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosier);

        ImageView img_rapport = (ImageView)findViewById(R.id.img_rapport);

        img_rapport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(DosierActivity.this, RapportActivity.class);
                startActivity(myIntent);
            }
        });


        ImageView img_pv = (ImageView)findViewById(R.id.img_pv);

        img_pv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(DosierActivity.this, PVActivity.class);
                startActivity(myIntent);
            }
        });


        ImageView imvTechnique = (ImageView)findViewById(R.id.imvTechnique);

        imvTechnique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(DosierActivity.this, TechniqueActivity.class);
                startActivity(myIntent);
            }
        });


        ImageView imvplan = (ImageView)findViewById(R.id.imvplan);

        imvplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(DosierActivity.this, PlanActivity.class);
                startActivity(myIntent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dossier, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_dossier) {
           // Intent myIntent = new Intent(ChantierSelectedActivity.this, DosierActivity.class);
            //startActivity(myIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
