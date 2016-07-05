package synapsehub.cd.notifhub.adapter;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

import synapsehub.cd.notifhub.Config;
import synapsehub.cd.notifhub.model.Annonce;

/**
 * Created by michelo on 7/4/16.
 */

public class FirebaseHelper {


    DatabaseReference db;
    Boolean saved=null;
    ArrayList<Annonce> annonces=new ArrayList<Annonce>();

    //Renvoi la reference de la abse des donnees
    public FirebaseHelper(DatabaseReference db){
        this.db=db;
    }

    //Enregistre dans la database au cas ou c'est non ull
    public Boolean saveAnnonce(Annonce annonce){
        if(annonce==null){
            saved=false;
        }else
        {
            try{
                db.child(Config.Child_annonce).push().setValue(annonce);
                saved=true;
            }catch (DatabaseException e){
                e.printStackTrace();
                saved=false;
            }
        }

        return saved;

    }

    //Fecth data et rempli l'arrayList
    private void fetchData_Annonce(DataSnapshot dataSnapshot){
        annonces.clear();
        for(DataSnapshot ds : dataSnapshot.getChildren())
        {
            Annonce annonce=ds.getValue(Annonce.class);
            annonces.add(annonce);
        }
    }

    //Read data from database
    public ArrayList<Annonce> retrieve_Annonces()
    {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData_Annonce(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData_Annonce(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return annonces;
    }


}
