package synapsehub.cd.notifhub.fragment;

import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import synapsehub.cd.notifhub.R;
import synapsehub.cd.notifhub.adapter.AnnoncesAdapter;
import synapsehub.cd.notifhub.adapter.FirebaseHelper;
import synapsehub.cd.notifhub.model.Annonce;

/**
 * Created by Michelo on 13/01/16.
 */
public class AnnoncesFragment extends Fragment {

    DatabaseReference db;
    FirebaseHelper helper;
    AnnoncesAdapter adapter;
    RecyclerView rv;
    EditText titleTxt, phoneTxt, descTxt, priceTxt, latTxt, longTxt;


    public AnnoncesFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_annonce , container, false);
        rv=(RecyclerView)rootView.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Initialize Database
        db= FirebaseDatabase.getInstance().getReference();

        helper=new FirebaseHelper(db);

        //Adapter
        adapter=new AnnoncesAdapter(getActivity(),helper.retrieve_Annonces());
        rv.setAdapter(adapter);
        rv.setItemAnimator(new DefaultItemAnimator());


        FloatingActionButton fab=(FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInputAnnonceDialog();
            }
        });

        return rootView;
    }

    //Display Input dialog
    private void displayInputAnnonceDialog(){

        Dialog d=new Dialog(getActivity());
        d.setTitle("Nouvel annonce");
        d.setContentView(R.layout.add_annonce_layout);

        titleTxt=(EditText)d.findViewById(R.id.titleEditText);
        phoneTxt=(EditText)d.findViewById(R.id.phoneEditText);
        descTxt=(EditText)d.findViewById(R.id.descEditText);
        priceTxt=(EditText)d.findViewById(R.id.priceEditText);
        latTxt=(EditText)d.findViewById(R.id.latEditText);
        longTxt=(EditText)d.findViewById(R.id.longEditText);

        Button saveb=(Button)d.findViewById(R.id.btn_save_annonce);

        saveb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GET DATA
                String title=titleTxt.getText().toString();
                String phone=phoneTxt.getText().toString();
                String desc=descTxt.getText().toString();
                double price=Double.parseDouble(priceTxt.getText().toString());
                double latitude=Double.parseDouble(latTxt.getText().toString());
                double longitude=Double.parseDouble(longTxt.getText().toString());

                //SET DATA
                Annonce an=new Annonce();
                an.setTitle(title);
                an.setPhone(phone);
                an.setDescription(desc);
                an.setPrice(price);
                an.setLatitude(latitude);
                an.setLongitude(longitude);

                //SAVE

                if(title!=null && title.length()>0) {
                    if (helper.saveAnnonce(an)) {
                        titleTxt.setText("");
                        phoneTxt.setText("");
                        descTxt.setText("");
                        priceTxt.setText("");
                        latTxt.setText("");
                        longTxt.setText("");

                        adapter = new AnnoncesAdapter(getActivity(), helper.retrieve_Annonces());
                        rv.setAdapter(adapter);
                    }
                }else
                    {
                        Toast.makeText(getActivity(),"donnees vides", Toast.LENGTH_LONG).show();
                    }
                }
        });
        d.show();
    }


}
