package synapsehub.cd.notifhub.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import synapsehub.cd.notifhub.R;

/**
 * Created by michelo on 7/1/16.
 */

public class LoginFragment extends Fragment {

    private FirebaseAuth fireAuth;
    EditText txtUsern;
    EditText txtpwd;
    TextView txtIdentity;
    Button connectButton;

    public LoginFragment() { } //Constructor



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_login, container, false);

        fireAuth=FirebaseAuth.getInstance();

        txtUsern=(EditText) rootView.findViewById(R.id.username);
        txtpwd=(EditText) rootView.findViewById(R.id.password);


        connectButton=(Button) rootView.findViewById(R.id.btn_signin);
    //implementation du click listener
        connectButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String userStr=txtUsern.getText().toString();
                String pwdStr=txtpwd.getText().toString();

                if(!userStr.isEmpty() && !pwdStr.isEmpty()){
                    fireAuth.signInWithEmailAndPassword(userStr,pwdStr).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            FirebaseUser user=authResult.getUser();
                            //Essayer d'afficher dans le navigation drawer header
                            //txtIdentity.setText(user.getEmail());
                            Toast.makeText(getActivity(), user.getEmail() + " is connected", Toast.LENGTH_SHORT).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(), "Utilisateur inconnu ...", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        return rootView;
    }

}
