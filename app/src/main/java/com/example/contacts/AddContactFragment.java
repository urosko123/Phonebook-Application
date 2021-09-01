package com.example.contacts;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class AddContactFragment extends Fragment implements View.OnClickListener {

    View view;

    public EditText name;
    public EditText lastName;
    public EditText number;
    public Button addContactBtn;


    public ArrayList<Contact> contactsList = new ArrayList<>();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_contact, container, false);
        name = (EditText) view.findViewById(R.id.identerName);
        name.setOnClickListener(this);
        lastName = (EditText) view.findViewById(R.id.identerLastName);
        lastName.setOnClickListener(this);
        number = (EditText) view.findViewById(R.id.identerNumber);
        number.setOnClickListener(this);
        addContactBtn = (Button) view.findViewById(R.id.buttonAdd);
        addContactBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private boolean checkIfExists() {
        if (!contactsList.isEmpty()) {
            for (Contact contact : contactsList) {
                if (contact.getName().equals(name.getText().toString()) && contact.getLastName().equals(lastName.getText().toString())) {
                    Toast.makeText(getActivity().getApplicationContext(), "Already added", Toast.LENGTH_SHORT).show();
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void resetTextFields() {
        name.setText("Name: ");
        lastName.setText("Last Name: ");
        number.setText("Number: ");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.identerName:
                name.setText("");
                return;
            case R.id.identerLastName:
                lastName.setText("");
                return;
            case R.id.identerNumber:
                number.setText("");
                return;
            case R.id.buttonAdd:
                //Add contacts to the list
                if (!checkIfExists()) {
                    contactsList.add(new Contact(name.getText().toString(), lastName.getText().toString(), number.getText().toString()));
                    saveData();
                }
                resetTextFields();
                //setAdapter();
                Toast.makeText(getActivity().getApplicationContext(), "Size of the list is: " + contactsList.size(), Toast.LENGTH_SHORT).show();
                return;
            default:
                return;
        }


    }

    public ArrayList<Contact> getlist() {
        return contactsList;
    }

    private void saveData() {
        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared preferences", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // creating a new variable for gson.
        Gson gson = new Gson();

        // getting data from gson and storing it in a string.
        String json = gson.toJson(contactsList);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("contacts", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();

        // after saving data we are displaying a toast message.
        Toast.makeText(getActivity().getApplicationContext(), "Saved Array List to Shared preferences. ", Toast.LENGTH_SHORT).show();
    }
}