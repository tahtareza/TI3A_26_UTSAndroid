package id.ac.polinema.sharedpreferenceandsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button buttonLogin;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = findViewById(R.id.editTextUsername);
        edtPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.btnLogin);

        sessionManagement = new SessionManagement(this);

        if (sessionManagement.isLoggedIn()){
            goToActivity();
        }

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = edtUsername.getText().toString();
                String pwd = edtPassword.getText().toString();
                if(uname.trim().isEmpty()||pwd.trim().isEmpty()|| uname.matches("") || pwd.matches("")){
                    Toast.makeText(MainActivity.this, "Username dan Password tidak boleh kosong dan tidak boleh ada spasi", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    sessionManagement.createLoginSession(edtUsername.getText().toString(), edtPassword.getText().toString());
                    goToActivity();
                }
            }
        });
    }

    private void goToActivity(){
        Intent mIntent = new Intent(getApplicationContext(), WelcomeActivity.class);
        startActivity(mIntent);
    }
}
