package com.example.showcontact;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.util.Patterns;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputLayout;

public class login extends AppCompatActivity {
    EditText email, password;
    Button login;
    TextView register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((email.getText().toString().equals("admin")) && (password.getText().toString().equals("admin"))){

                    Intent i = new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(login.this, "Erorr", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }

}