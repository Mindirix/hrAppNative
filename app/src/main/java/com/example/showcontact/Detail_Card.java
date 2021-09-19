package com.example.showcontact;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class Detail_Card extends AppCompatActivity {

    ImageView tv_img;
    TextView tv_name , tv_title,tv_phone;
    MaterialButton btn_contacts_details , btn_his_details ;
    Contact_Data_Model contact ;
    //MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__card);

        tv_img = findViewById(R.id.d_img);
        tv_title = findViewById(R.id.d_title);
        tv_phone = findViewById(R.id.d_phone);
        tv_name= findViewById(R.id.d_name);
        btn_contacts_details = findViewById(R.id.btn_contacts_details);
        btn_his_details = findViewById(R.id.btn_his_details);

        //Click Listener 1
        btn_contacts_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        //Click Listener 2
        btn_his_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),MainLeave.class);
                startActivity(intent);
            }
        });
        

    }

    //makes the menu visable
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        contact =(Contact_Data_Model) data.getSerializableExtra("details");
        tv_name.setText(contact.getContactname());
        tv_img.setImageResource(contact.getImge_view());
        tv_phone.setText(contact.getContactphone());
        tv_title.setText(contact.getContacttitle());


    }


}