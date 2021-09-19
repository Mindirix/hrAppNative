package com.example.showcontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class CreateLeaveActivity extends AppCompatActivity {

    ListView mleavesList;
    EditText et_manager, et_startDate, et_numberdays ,et_reason;
    Button mSaveLeave;
    MaterialButton btn_contacts_createleave , btn_his_createleave ;
//    String smanager,sstartdate,sreason,snumberdays;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_leave);

        mleavesList= findViewById(R.id.leave_list);
        et_manager = findViewById(R.id.et_manager);
        et_startDate = findViewById(R.id.et_Date);
        et_numberdays = findViewById(R.id.et_num_days);
        et_reason = findViewById(R.id.et_reason);
        mSaveLeave= findViewById(R.id.save);
        btn_contacts_createleave = findViewById(R.id.btn_contacts_createleave);
        btn_his_createleave = findViewById(R.id.btn_his_createleave);

        //Click Listener for Nav Buttons
        btn_contacts_createleave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        //Click Listener 2
        btn_his_createleave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),MainLeave.class);
                startActivity(intent);
            }
        });

        //Save Click Listener
        mSaveLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                leave_Data_Model model = new leave_Data_Model();
                model.setManager(et_manager.getText().toString());
                model.setNumdays(et_numberdays.getText().toString());
                model.setReason(et_reason.getText().toString());
                model.setStartdate(et_startDate.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putSerializable("leaveKey", model);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(2, intent);
                finish();
            }
        });


    }
}