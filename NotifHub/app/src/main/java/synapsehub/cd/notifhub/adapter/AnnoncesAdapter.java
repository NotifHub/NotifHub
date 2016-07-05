package synapsehub.cd.notifhub.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import synapsehub.cd.notifhub.R;
import synapsehub.cd.notifhub.model.Annonce;

/**
 * Created by michelo on 7/4/16.
 * 1. Layout inflation
 * 2. Receive announces
 * 3. Perform binding
 */

public class AnnoncesAdapter extends RecyclerView.Adapter<AnnonceViewHolder>{

    Context c;
    ArrayList<Annonce> annonces;

    public AnnoncesAdapter(Context c, ArrayList<Annonce> annonces) {
        this.c = c;
        this.annonces = annonces;
    }

    @Override
    public AnnonceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(c).inflate(R.layout.annonce_model,parent,false);
        return new AnnonceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AnnonceViewHolder holder, int position) {
        holder.titleTxt.setText(annonces.get(position).getTitle());
        holder.phoneTxt.setText(annonces.get(position).getPhone());
        holder.descTxt.setText(annonces.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return annonces.size();
    }
}
