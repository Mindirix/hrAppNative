package com.example.showcontact;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;

public class MainLeave extends AppCompatActivity {
    ListView mleavesList;
    FloatingActionButton mAddNewleave;
    Custom_Contact_Adapter leaveadapter;
    leave_Data_Model model;
    MaterialButton btn_contacts_history, btn_his_history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_leave);

        mleavesList = findViewById(R.id.leave_list);
        mAddNewleave = findViewById(R.id.add_new_leave);
        btn_contacts_history = findViewById(R.id.btn_contacts_history);
        btn_his_history = findViewById(R.id.btn_his_history);


        leaveadapter = new Custom_Contact_Adapter(getBaseContext(), R.layout.leave_item_view);

        mAddNewleave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CreateLeaveActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        //Click Listener
        btn_contacts_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
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

        if (resultCode == 2) {

            leave_Data_Model r;
            r = (leave_Data_Model) data.getExtras().getSerializable("leaveKey");
            leaveadapter.add(r);
            mleavesList.setAdapter(leaveadapter);


        }
    }

}
