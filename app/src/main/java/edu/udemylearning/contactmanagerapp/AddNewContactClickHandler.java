package edu.udemylearning.contactmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {
    Contacts contacts;
    Context context;
    MyViewModel myViewModel;

    public AddNewContactClickHandler(Contacts contacts, Context context, MyViewModel myViewModel) {
        this.contacts = contacts;
        this.context = context;
        this.myViewModel = myViewModel;
    }

    public void AddBtn(View view){
        if (contacts.getName()==null || contacts.getName().isEmpty() || contacts.getEmail().isEmpty() || contacts.getEmail()==null){
            Toast.makeText(context,"Empty Fields",Toast.LENGTH_LONG).show();
        }else {
            Intent i = new Intent(context, MainActivity.class);
//            i.putExtra("NAME",contacts.getName());
//            i.putExtra("EMAIL",contacts.getEmail());
            context.startActivity(i);
            Contacts c = new Contacts(contacts.getName(),contacts.getEmail());
            myViewModel.addNewContacts(c);
        }
    }
}
