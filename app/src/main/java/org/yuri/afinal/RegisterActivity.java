package org.yuri.afinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper db;



    private ArrayAdapter adapter;
//    private Spinner spinner;



    EditText e1,e2,e3,e4,e5,e6;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        db = new DatabaseHelper(this);

        //reset초기화

//        spinner = (Spinner) findViewById(R.id.adminSpinner);
//        adapter = ArrayAdapter.createFromResource(this,R.array.admin, android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);



        e1 = (EditText) findViewById(R.id.idText);
        e2 = (EditText) findViewById(R.id.nameText);
        e3 = (EditText) findViewById(R.id.passwordText);
        e4 = (EditText) findViewById(R.id.password2Text);
        e5 = (EditText) findViewById(R.id.emailText);
        e6 = (EditText) findViewById(R.id.genderText);
        b1 = (Button) findViewById(R.id.signButton);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString(); //e4 = password confirm
                String s5 = e5.getText().toString();
                String s6 = e5.getText().toString();





                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_LONG).show();


                }else{

                    if(s3.equals(s4)){ //e4 = password confirm
                        Boolean chkid = db.chkid(s1); //s1 = id

                        if(chkid == true){
                            Boolean insert = db.insert(s1,s2,s3,s5,s6);
                                    //s1 = id, s2 = name, s3 = password, s5 = email, s6 = gender

                            if(insert == true){
                                Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_LONG).show();
                            }
                        }

                        else{

                            Toast.makeText(getApplicationContext(),"Id Already exists",Toast.LENGTH_LONG).show();
                        }
                    }
//                    Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
