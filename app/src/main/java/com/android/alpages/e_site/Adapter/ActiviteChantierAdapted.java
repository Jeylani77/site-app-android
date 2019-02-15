package com.android.alpages.e_site.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.alpages.e_site.Model.Activite_chantier;
import com.android.alpages.e_site.Model.Chantier;
import com.android.alpages.e_site.R;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.android.alpages.e_site.ApiRest.ApiClient.BASE_URL;

public class ActiviteChantierAdapted extends RecyclerView.Adapter<ActiviteChantierAdapted.ViewHolder> {
    //private Context context;
    private List<Activite_chantier> activite_chantiers;

    public ActiviteChantierAdapted(List<Activite_chantier> activite_chantiers) {
        //this.context = context;
        this.activite_chantiers = activite_chantiers;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activet_chantier_row, viewGroup, false);
        ActiviteChantierAdapted.ViewHolder holder = new ActiviteChantierAdapted.ViewHolder(v);

        return holder;    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Activite_chantier activite_chantier = activite_chantiers.get(i);
        viewHolder.titre_rappo.setText(activite_chantier.getNom());
        viewHolder.date_rappo.setText(activite_chantier.getDate());

        /*
        if (position == 1 || position == 3) holder.progress_chantier.setImageResource(R.drawable.progress3);
        else if (position == 0 || position == 2) holder.progress_chantier.setImageResource(R.drawable.progress);
        else if (position == 4 || position == 5) holder.progress_chantier.setImageResource(R.drawable.progress2);

        String image_url = chantier.getPic();
        String picUrl=BASE_URL+"pic/"+image_url;

        Glide.with(holder.imvchantier.getContext())
                .load(picUrl)
                .thumbnail(0.70f)
                .into(holder.imvchantier);
                */
    }

    @Override
    public int getItemCount() {
        return activite_chantiers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.titre_rappo)
        TextView titre_rappo;
        @BindView(R.id.date_rappo) TextView date_rappo;
        @BindView(R.id.ingenieur1) ImageView ingenieur1;


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
