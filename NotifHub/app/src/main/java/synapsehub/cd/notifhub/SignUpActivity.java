package synapsehub.cd.notifhub;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth fireAuth;
    private EditText txtUsern;
    private EditText txtpwd;
    private EditText txtrepwd;
    private TextView tv_register;
    Button registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fireAuth=FirebaseAuth.getInstance();

        txtUsern=(EditText)findViewById(R.id.username2);
        txtpwd=(EditText)findViewById(R.id.password2);
        txtrepwd=(EditText)findViewById(R.id.repassword);

        registerButton=(Button)findViewById(R.id.btn_signup);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailStr=txtUsern.getText().toString();
                String pwdStr=txtpwd.getText().toString();
                String pwdStr2=txtrepwd.getText().toString();

                if(!emailStr.isEmpty() && !pwdStr.isEmpty() && !pwdStr2.isEmpty()){
                    if(pwdStr.toString().equals(pwdStr2.toString())){
                        fireAuth.createUserWithEmailAndPassword(emailStr,pwdStr).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                FirebaseUser user=authResult.getUser();
                                Toast.makeText(getApplicationContext(),"Utilisateur enregistre !", Toast.LENGTH_LONG).show();
                                Intent i=new Intent();
                                i.putExtra(Intent.EXTRA_TEXT,user.getEmail());
                                setResult(RESULT_OK,i);
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Authentification echouee !", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }
            }
        });

    }
}
