package org.yuri.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {



    EditText e1, e2, userId1, userName1, userEmail1, userGender1;
    Button b1;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        setContentView(R.layout.fragment_myinfo);


        db = new DatabaseHelper(this);
        e1 = (EditText) findViewById(R.id.idText);
        e2 = (EditText) findViewById(R.id.passwordText);
        b1 = (Button) findViewById(R.id.loginButton);


//
//        userId1 = (EditText) findViewById(R.id.userId1);
//        userName1 = (EditText) findViewById(R.id.userName1);
//        userEmail1 = (EditText) findViewById(R.id.userEmail1);
//        userGender1 = (EditText) findViewById(R.id.userGender1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                LoginActivity.this.startActivity(mainIntent);
            }
        });






        TextView registerButton = (TextView) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);


            }
       });



    }
}
