package id.ac.polinema.sharedpreferenceandsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class WelcomeActivity extends AppCompatActivity {
    SessionManagement sessionManagement;
    Button buttonCreateDatabase, buttonLogout;
    TextView tvUsername;
    HashMap<String, String> userInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        buttonCreateDatabase = findViewById(R.id.btnDatabase);
        buttonLogout = findViewById(R.id.btnLogout);
        tvUsername=findViewById(R.id.txtWelcome);

        sessionManagement = new SessionManagement(this);
        userInformation = sessionManagement.getUserInformation();

        tvUsername.setText("Welcome "+userInformation.get(sessionManagement.KEY_USERNAME));

        buttonCreateDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), InsertDataActivity.class);
                startActivity(mIntent);
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagement.logoutUser();
            }
        });
    }
}
