package synapsehub.cd.notifhub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import synapsehub.cd.notifhub.R;
import synapsehub.cd.notifhub.model.Annonce;

/**
 * Created by michelo on 7/5/16.
 */

public class AnnonceItemAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Annonce> annonces;

    public AnnonceItemAdapter(Context context, ArrayList<Annonce> annonces) {
        this.context = context;
        this.annonces = annonces;
    }

    public static class ViewHolder{
        public final ImageView item_image;
        public final TextView item_title;
        public final TextView item_description;

        public ViewHolder(View view) {
            item_image = (ImageView) view.findViewById(R.id.item_image);
            item_title = (TextView) view.findViewById(R.id.item_title);
            item_description = (TextView) view.findViewById(R.id.item_description);
        }
    }

    @Override
    public int getCount() {
        return annonces.size();
    }

    @Override
    public Object getItem(int position) {
        return annonces.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Annonce annonce=annonces.get(i);
        View v=view;
        final ViewHolder viewHolder;
        if(v==null){
            v= LayoutInflater.from(context).inflate(R.layout.annonce_items,viewGroup,false);
            viewHolder=new ViewHolder(v);
            v.setTag(viewHolder);

        }else{
            viewHolder=(ViewHolder)v.getTag();
        }


        viewHolder.item_title.setText(annonce.getTitle());
        viewHolder.item_description.setText(annonce.getDescription());
        //Ici mettre l'image

        return v;
    }
}
