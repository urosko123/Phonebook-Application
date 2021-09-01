package com.example.contacts;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


public class AllContactFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    ArrayList<Contact> contactArrayList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_all_contact, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewId);
        setAdapter();
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // setAdapter();

    }

    private void setAdapter() {
        loadData();
        MyContactsAdapter contactsAdapter = new MyContactsAdapter(contactArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(contactsAdapter);
    }
  private void loadData() {
        contactArrayList.add(new Contact("Uros", "Visekruna", "123456789"));
      contactArrayList.add(new Contact("Uros", "Visekruna", "123456789"));
      contactArrayList.add(new Contact("Uros", "Visekruna", "123456789"));
      contactArrayList.add(new Contact("Uros", "Visekruna", "123456789"));
      contactArrayList.add(new Contact("Uros", "Visekruna", "123456789"));
      contactArrayList.add(new Contact("Uros", "Visekruna", "123456789"));
      contactArrayList.add(new Contact("Uros", "Visekruna", "123456789"));
      contactArrayList.add(new Contact("Uros", "Visekruna", "123456789"));
      contactArrayList.add(new Contact("Uros", "Visekruna", "123456789"));
      contactArrayList.add(new Contact("Uros", "Visekruna", "123456789"));
      contactArrayList.add(new Contact("Uros", "Visekruna", "123456789"));
      contactArrayList.add(new Contact("Uros", "Visekruna", "123456789"));
      contactArrayList.add(new Contact("Uros", "Visekruna", "123456789"));
      contactArrayList.add(new Contact("Uros", "Visekruna", "123456789"));
      contactArrayList.add(new Contact("Uros", "Visekruna", "123456789"));
      /*System.out.println("LOAD DATA");
      // method to load arraylist from shared prefs
      // initializing our shared prefs with name as
      // shared preferences.
      SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared preferences", MODE_PRIVATE);

      // creating a variable for gson.
      Gson gson = new Gson();

      // below line is to get to string present from our
      // shared prefs if not present setting it as null.
      String json = sharedPreferences.getString("contacts", null);

      // below line is to get the type of our array list.
      Type type = new TypeToken<ArrayList<Contact>>() {}.getType();

      // in below line we are getting data from gson
      // and saving it to our array list
      contactArrayList = gson.fromJson(json, type);

      // checking below if the array list is empty or not
      if (contactArrayList == null) {
          // if the array list is empty
          // creating a new array list.
          contactArrayList = new ArrayList<>();
      }*/
  }

}