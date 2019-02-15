package com.android.alpages.e_site.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.alpages.e_site.Model.Chantier;
import com.android.alpages.e_site.R;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.android.alpages.e_site.ApiRest.ApiClient.BASE_URL;

public class ChantierListAdapter extends RecyclerView.Adapter<ChantierListAdapter.ViewHolder> {

    private Context context;
    private List<Chantier> chantiers;

    public ChantierListAdapter(List<Chantier> chantiers) {
        //this.context = context;
        this.chantiers = chantiers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chantier_row, parent, false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Chantier chantier = chantiers.get(position);
        holder.txt_nomChantier.setText(chantier.getNom());
        holder.txt_locationChantier.setText(chantier.getLocation());

        if (position == 1 || position == 3) holder.progress_chantier.setImageResource(R.drawable.progress3);
        else if (position == 0 || position == 2) holder.progress_chantier.setImageResource(R.drawable.progress);
        else if (position == 4 || position == 5) holder.progress_chantier.setImageResource(R.drawable.progress2);

        String image_url = chantier.getPic();
        String picUrl=BASE_URL+"pic/"+image_url;

        Glide.with(holder.imvchantier.getContext())
                .load(picUrl)
                .thumbnail(0.70f)
                .into(holder.imvchantier);

    }

    @Override
    public int getItemCount() {
        return chantiers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.txt_nomChantier) TextView txt_nomChantier;
        @BindView(R.id.txt_locationChantier) TextView txt_locationChantier;
        @BindView(R.id.imvchantier) ImageView imvchantier;
        @BindView(R.id.progress_chantier) ImageView progress_chantier;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {



/*
            String numCNI = tv_numCNI.getText().toString();
            String fullname = tv_fullname.getText().toString();
            String location = tv_location.getText().toString();
            String tel = tv_tel.getText().toString();
            String telurgence = tv_telurgence.getText().toString();


            Intent i = new Intent(context, UpdateActivity.class);

            i.putExtra("numCNI", numCNI);
            i.putExtra("fullname", fullname);
            i.putExtra("location", location);
            i.putExtra("tel", tel);
            i.putExtra("telurgence", telurgence);

            context.startActivity(i);

            new CustomToast().Show_Toast(context, view,
                    "En construction..");
                    */

        }
    }
}
