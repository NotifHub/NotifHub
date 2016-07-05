package synapsehub.cd.notifhub.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import synapsehub.cd.notifhub.R;

/**
 * Created by michelo on 7/4/16.
 */

public class AnnonceViewHolder extends RecyclerView.ViewHolder {

    TextView titleTxt, phoneTxt, descTxt, priceTxt, latTxt, longTxt;

    public AnnonceViewHolder(View itemView) {
        super(itemView);

        titleTxt=(TextView)itemView.findViewById(R.id.titleEditText);
        phoneTxt=(TextView)itemView.findViewById(R.id.phoneEditText);
        descTxt=(TextView)itemView.findViewById(R.id.descEditText);
        priceTxt=(TextView)itemView.findViewById(R.id.priceEditText);
        latTxt=(TextView)itemView.findViewById(R.id.latEditText);
        longTxt=(TextView)itemView.findViewById(R.id.longEditText);

    }

}
