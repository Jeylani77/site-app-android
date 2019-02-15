package com.android.alpages.e_site;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.alpages.e_site.Adapter.ChantierListAdapter;
import com.android.alpages.e_site.ApiRest.ApiClient;
import com.android.alpages.e_site.ApiRest.ApiInterface;
import com.android.alpages.e_site.Model.Chantier;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {
    private static final String TAG = "TestActivity";
    private  ChantierListAdapter adapter;
    private List<Chantier> chantierList = new ArrayList<>();
    private ApiInterface apiService;
    private RecyclerView.LayoutManager mLayoutManager;
    @BindView(R.id.chantier_list) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Chantier>> call= apiService.getChantierJson();
        Log.d(TAG, call.request().url() + "");


        call.enqueue(new Callback<List<Chantier>>() {
            @Override
            public void onResponse(Call<List<Chantier>> call, Response<List<Chantier>> response) {
                List<Chantier> chantiers = response.body();
                Log.d(TAG, "onResponse: "+ chantiers);

                recyclerView.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(TestActivity.this);
                recyclerView.setLayoutManager(mLayoutManager);

                adapter = new ChantierListAdapter(chantiers);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Chantier>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());

            }
        });
    }
}
