package edu.udemylearning.contactmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {
    Contacts contacts;
    Context context;

    public AddNewContactClickHandler(Contacts contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    public void AddBtn(View view){
        if (contacts.getName()==null || contacts.getEmail()==null){
            Toast.makeText(context,"Empty Fields",Toast.LENGTH_LONG).show();
        }else {
            Intent i = new Intent(context, MainActivity.class);
            i.putExtra("NAME",contacts.getName());
            i.putExtra("EMAIL",contacts.getEmail());
            context.startActivity(i);
        }
    }
}
