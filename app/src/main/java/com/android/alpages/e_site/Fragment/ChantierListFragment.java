package com.android.alpages.e_site.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.alpages.e_site.Activity.ChantierSelectedActivity;
import com.android.alpages.e_site.Activity.RecyclerItemClickListener;
import com.android.alpages.e_site.Adapter.ChantierListAdapter;
import com.android.alpages.e_site.ApiRest.ApiClient;
import com.android.alpages.e_site.ApiRest.ApiInterface;
import com.android.alpages.e_site.Model.Chantier;
import com.android.alpages.e_site.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ChantierListFragment extends Fragment  {
    private static final String TAG = "ChantierListFragment";
    private Context mContext;
    private  ChantierListAdapter adapter;
    private List<Chantier> chantierList = new ArrayList<>();
    private ApiInterface apiService;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView recyclerView;
    ProgressBar progressBar;



    //@BindView(R.id.chantier_list) RecyclerView recyclerView;
   // @BindView(R.id.progress_bar) ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chantier, container, false);
        
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

         recyclerView = (RecyclerView) view.findViewById(R.id.chantier_list);
         progressBar = (ProgressBar)view.findViewById(R.id.progress_bar);

        loadChantier();


    }

    private void loadChantier() {

        apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Chantier>> call= apiService.getChantierJson();

        call.enqueue(new Callback<List<Chantier>>() {
            @Override
            public void onResponse(Call<List<Chantier>> call, Response<List<Chantier>> response) {
                List<Chantier> chantiers = response.body();
                Log.d(TAG, "onResponse: "+ chantiers);
                progressBar.setVisibility(View.GONE);


                recyclerView.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(mContext);
                recyclerView.setLayoutManager(mLayoutManager);

                adapter = new ChantierListAdapter(chantiers);
                recyclerView.setAdapter(adapter);

                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(mContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        startActivity(new Intent(getActivity(), ChantierSelectedActivity.class));

                    }
                }));
                /*
                mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, new RecyclerItemClickListener.OnItemClickListener(){

                    @Override
                    public void onItemClick(View view, final int position) {
                        final EditText studEditText = new EditText(MainActivity.this);
                        studEditText.setText(studentRealm.get(position).getName());
                        AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Modifier Etudiant")
                                .setView(studEditText)
                                .setPositiveButton("Sauvegarder", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        updateStudentName(Integer.parseInt(studentRealm.get(position).getId().toString()),studEditText.getText().toString());
                                    }
                                })
                                .setNegativeButton("Supprimer", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        deleteStudentName(Integer.parseInt(studentRealm.get(position).getId().toString()));
                                    }
                                })
                                .create();
                        dialog.show();
                    }
                })); */
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Chantier>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        //loadDataMahasiswa();

    }

    /*

    private void loadDataMahasiswa() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface api = retrofit.create(RequestInterface.class);
        Call<Value> call = api.view();
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                progressBar.setVisibility(View.GONE);
                if (value.equals("1")) {
                    results = response.body().getResult();
                    viewAdapter = new RecyclerViewAdapter(ViewActivity.this, results);
                    recyclerView.setAdapter(viewAdapter);
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {

            }
        });
    }
    */


}
