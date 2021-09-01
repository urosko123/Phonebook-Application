package com.example.contacts;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyContactsAdapter extends RecyclerView.Adapter<MyContactsAdapter.MyContactsViewHolder> {

    private ArrayList<Contact> contactsList;

    public MyContactsAdapter(ArrayList<Contact> contactsList) {
        this.contactsList = contactsList;
    }

    @NonNull
    @Override
    public MyContactsAdapter.MyContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyContactsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyContactsAdapter.MyContactsViewHolder holder, int position) {

        if (!contactsList.isEmpty()) {
            String name = contactsList.get(position).getName();
            String lastName = contactsList.get(position).getLastName();
            holder.name.setText(name);
            holder.lastname.setText(lastName);
        } else {
           // Toast.makeText(holder.itemView.getContext(), "Size of the list is: ", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class MyContactsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView name;
        private TextView lastname;

        public MyContactsViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.recyclerItemName);
            lastname = itemView.findViewById(R.id.recyclerItemLastName);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            System.out.println("Item clicked " + getLayoutPosition());
        }
    }

}
