package com.android.alpages.e_site.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.alpages.e_site.R;

public class ExecutionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_execution);

        ImageView execution_box = (ImageView)findViewById(R.id.execution_box);

        execution_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(ExecutionActivity.this, ExecutionSelectedActivity.class);
                startActivity(myIntent);
            }
        });


    }
}
