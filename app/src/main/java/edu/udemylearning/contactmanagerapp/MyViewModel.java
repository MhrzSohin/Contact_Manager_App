package edu.udemylearning.contactmanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    private MyRepository myRepository;
    private LiveData<List<Contacts>> allContacts;


    public MyViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new MyRepository(getApplication());
    }
    public LiveData<List<Contacts>> getAllContacts(){
        allContacts = myRepository.getAllContacts();
        return allContacts;
    }
    public void addNewContacts(Contacts contacts){
        myRepository.addContact(contacts);
    }
    public  void deleteAvailableContacts(Contacts contacts){
        myRepository.deleteContact(contacts);
    }

}
