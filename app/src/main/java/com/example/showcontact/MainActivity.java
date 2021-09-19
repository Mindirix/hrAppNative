package com.example.showcontact;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView myrecycleview;
    MyCustomAdapter adapter;
    Contact_Data_Model contact ;
    MaterialButton btn_contacts_main , btn_history_main ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inflate views
        myrecycleview = findViewById(R.id.recycleview);
        btn_contacts_main = findViewById(R.id.btn_contacts_main);
        btn_history_main = findViewById(R.id.btn_history_main);

        //Click Listener
        btn_history_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),MainLeave.class);
                startActivity(intent);
            }
        });


        // Source of data

        ArrayList<Contact_Data_Model> mydata = new ArrayList<Contact_Data_Model>();
        mydata.add(new Contact_Data_Model(R.drawable.men,"Mohamed Hany","Devolper","01061355644"));
        mydata.add(new Contact_Data_Model(R.drawable.femal,"Fatma Hossam","Designer","01335454456"));
        mydata.add(new Contact_Data_Model(R.drawable.men,"Ahmed Mamduoh","System Adminstration","01061355644"));
        mydata.add(new Contact_Data_Model(R.drawable.men,"Ahmed Megahed","Instractor","01061355644"));



        adapter = new MyCustomAdapter(mydata);
        myrecycleview.setHasFixedSize(true);
        myrecycleview.setLayoutManager(new LinearLayoutManager(this));

        myrecycleview.setAdapter(adapter);




        // Important to open Details Activity
        adapter.setMyCardListner(new MyCustomAdapter.OnCardItemListner() {
            @Override
            public void onCardClick(int postion) {
//                Toast.makeText(MainActivity.this, "thi my card potion "+postion, Toast.LENGTH_SHORT).show();
     contact = new Contact_Data_Model(mydata.get(postion).getImge_view(),mydata.get(postion).getContactname(),mydata.get(postion).getContacttitle(),mydata.get(postion).getContactphone());

    //   Toast.makeText(MainActivity.this, "the number is"+mydata.get(postion).getContactphone(), Toast.LENGTH_SHORT).show();


            Bundle bundle = new Bundle();
            bundle.putSerializable("details",contact);
            Intent intent = new Intent(getBaseContext(),Detail_Card.class);
            intent.putExtras(bundle);
            startActivity(intent);

            }

            @Override
            public void onCallbtnClick(int postion) {

                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:"+mydata.get(postion).getContactphone()));
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED){

                }
                startActivity(call);



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


}