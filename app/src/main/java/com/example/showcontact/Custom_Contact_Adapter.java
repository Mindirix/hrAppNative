package com.example.showcontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Custom_Contact_Adapter extends ArrayAdapter<leave_Data_Model> {

    Context context;
    int resource;

    public Custom_Contact_Adapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        leave_Data_Model leave_data_model = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.leave_item_view, parent, false);
        }



        TextView manager = convertView.findViewById(R.id.manager);
        TextView startdate = convertView.findViewById(R.id.start_date);
        TextView reason = convertView.findViewById(R.id.reason);



        manager.setText(leave_data_model.getManager());
        startdate.setText(leave_data_model.getStartdate());

        reason.setText(leave_data_model.getReason());

        return convertView;

    }


}
