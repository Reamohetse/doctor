package com.example.doctor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HelperAdapter extends RecyclerView.Adapter {

    List<fetchData> fetchDataList;

    public HelperAdapter(List<fetchData> fetchDataList){
        this.fetchDataList = fetchDataList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ViewHolderClass viewHolderClass =new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
      ViewHolderClass viewHolderClass = (ViewHolderClass)holder;
      fetchData fetchData=fetchDataList.get(position);
      viewHolderClass.firstname.setText(fetchData.getFirstname());
      viewHolderClass.lastname.setText(fetchData.getLastname());
      viewHolderClass.gender.setText(fetchData.getGender());
      viewHolderClass.date.setText(fetchData.getDate());
    }

    @Override
    public int getItemCount() {
        return fetchDataList.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder{
         TextView firstname,lastname,gender,date;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            firstname=itemView.findViewById(R.id.firstname);
            lastname=itemView.findViewById(R.id.lastname);
            gender=itemView.findViewById(R.id.gender);
            date=itemView.findViewById(R.id.date);
        }
    }
}
