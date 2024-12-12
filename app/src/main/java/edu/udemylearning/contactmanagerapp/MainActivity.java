package edu.udemylearning.contactmanagerapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.udemylearning.contactmanagerapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
   ContactDB contactDB;
    private ArrayList<Contacts> contactsArrayList = new ArrayList<>();
    private MyAdapter myAdapter;
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandler mainActivityClickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
       mainActivityClickHandler = new MainActivityClickHandler(this);
       activityMainBinding.setClickHandler(mainActivityClickHandler);

        RecyclerView recyclerView = activityMainBinding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
       //Adapter

        //Database
        contactDB = ContactDB.getInstance(this);
        //ViewModel
        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        Contacts c1 = new Contacts("Sohesh","Sohesh@gmail.com");
        viewModel.addNewContacts(c1);

        viewModel.getAllContacts().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {
                contactsArrayList.clear();
                for (Contacts c : contacts){
                    Log.v("TagY", c.getName());
                    contactsArrayList.add(c);
                }
                myAdapter.notifyDataSetChanged();
            }
        });
        myAdapter = new MyAdapter(contactsArrayList);
        recyclerView.setAdapter(myAdapter);



    }
}