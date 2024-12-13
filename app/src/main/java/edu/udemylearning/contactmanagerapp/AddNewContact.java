package edu.udemylearning.contactmanagerapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import edu.udemylearning.contactmanagerapp.databinding.AddNewContactBinding;

public class AddNewContact extends AppCompatActivity {
    private AddNewContactClickHandler contactClickHandler;
    private AddNewContactBinding binding;

    private Contacts contacts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contacts = new Contacts("","");
        binding = DataBindingUtil.setContentView(this,R.layout.add_new_contact);
        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        contactClickHandler = new AddNewContactClickHandler(contacts,this,myViewModel);
        binding.setClickHandler(contactClickHandler);
        binding.setContact(contacts);

    }
}
