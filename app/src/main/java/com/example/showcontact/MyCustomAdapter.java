package com.example.showcontact;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {

    ArrayList<Contact_Data_Model> mydata;


    public MyCustomAdapter(ArrayList<Contact_Data_Model> mydata) {

        this.mydata = mydata;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_list_item,parent,false);
        MyViewHolder xyz = new MyViewHolder(v ,myCardListner);
        return xyz;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contact_Data_Model contact = mydata.get(position);
        holder.card_imag.setImageResource(contact.getImge_view());
        holder.card_name.setText(contact.getContactname());
        holder.card_title.setText(contact.getContacttitle());
        holder.card_phone.setText(contact.getContactphone());
        holder.card_btn.setText("Call");
    }

    @Override
    public int getItemCount() {
        return mydata.size();
    }




    //create in your cutom adapter your own interface for click item
    private OnCardItemListner myCardListner;

    public interface OnCardItemListner{

        void onCardClick (int postion);

        void onCallbtnClick (int postion);

    }

    // this method used in Main activty
    public void setMyCardListner(OnCardItemListner myCardListner) {
        this.myCardListner = myCardListner;
    }

    // inner class or nested class  (public or static )
           public static class MyViewHolder extends RecyclerView.ViewHolder{
               ImageView card_imag;
               TextView card_name;
               TextView card_title;
               TextView card_phone;
               MaterialButton card_btn;
               public MyViewHolder(View itemview ,OnCardItemListner mylistener ){
                    super(itemview);
                   card_imag = itemview.findViewById(R.id.card_img);
                   card_name = itemview.findViewById(R.id.card_tvname);
                   card_title = itemview.findViewById(R.id.card_tvtitle);
                    card_phone = itemview.findViewById(R.id.card_tvphone);
                    card_btn = itemview.findViewById(R.id.card_btn);
                   itemview.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           mylistener.onCardClick(getAdapterPosition());
                       }
                   });

                   card_btn.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           mylistener.onCallbtnClick(getAdapterPosition());
                       }
                   });

                }

           }

           //


}
