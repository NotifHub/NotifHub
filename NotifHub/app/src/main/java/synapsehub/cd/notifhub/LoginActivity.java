package synapsehub.cd.notifhub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth fireAuth;
    private EditText txtUsern;
    private EditText txtpwd;
    private TextView txtIdentity;
    private TextView tv_register;
    Button connectButton;
    private String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Verification des preferences
        user_id=NothifHubApplication.prefs.getString(Config.PREFS_USERIDentity,null);
        if(user_id!=null){
            startActivity(new Intent(LoginActivity.this,inActivity.class));
            finish();
        }

        setContentView(R.layout.activity_login);

        fireAuth=FirebaseAuth.getInstance();


        txtUsern=(EditText) findViewById(R.id.username);
        txtpwd=(EditText)findViewById(R.id.password);

        txtIdentity=(TextView)findViewById(R.id.identity);
        tv_register = (TextView)findViewById(R.id.register);
        tv_register.setText(Html.fromHtml("<u>" + tv_register.getText().toString() + "</u>"));

        connectButton=(Button)findViewById(R.id.btn_signin);
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
                            Toast.makeText(getApplicationContext(), user.getEmail() + " is connected", Toast.LENGTH_SHORT).show();

                            NothifHubApplication.prefs.edit().putString(Config.PREFS_USERIDentity,user.getEmail()).commit();

                            startActivity(new Intent(LoginActivity.this, inActivity.class));
                            finish();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Utilisateur inconnu ...", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });



    }

    public void register(View v){
        startActivity(new Intent(this, SignUpActivity.class));
    }

}