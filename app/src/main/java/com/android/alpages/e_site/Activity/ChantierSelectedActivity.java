package com.android.alpages.e_site.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.android.alpages.e_site.Adapter.ActiviteChantierAdapted;
import com.android.alpages.e_site.ApiRest.ApiClient;
import com.android.alpages.e_site.ApiRest.ApiInterface;
import com.android.alpages.e_site.Model.Activite_chantier;
import com.android.alpages.e_site.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChantierSelectedActivity extends AppCompatActivity {
    private static final String TAG = "ChantierSelectedActivity";
    private ActiviteChantierAdapted adapter;
    private List<Activite_chantier> activite_chantiers = new ArrayList<>();
    private ApiInterface apiService;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chantier_selected);

        recyclerView = findViewById(R.id.activite_list);
        progressBar =  findViewById(R.id.progress_bar);

        loadActiviteChantier();
    }

    private void loadActiviteChantier(){
        apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Activite_chantier>> call= apiService.getRapportJson();

        call.enqueue(new Callback<List<Activite_chantier>>() {
            @Override
            public void onResponse(Call<List<Activite_chantier>> call, Response<List<Activite_chantier>> response) {
                List<Activite_chantier> activite_chantiers = response.body();
                Log.d(TAG, "onResponse: "+ activite_chantiers);
                progressBar.setVisibility(View.GONE);

                recyclerView.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(ChantierSelectedActivity.this);
                recyclerView.setLayoutManager(mLayoutManager);

                adapter = new ActiviteChantierAdapted(activite_chantiers);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Activite_chantier>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());

            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent myIntent = new Intent(ChantierSelectedActivity.this, DosierActivity.class);
            startActivity(myIntent);
            return true;
        }
        if (id == R.id.action_execution) {
            Intent myIntent = new Intent(ChantierSelectedActivity.this, ExecutionActivity.class);
            startActivity(myIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
