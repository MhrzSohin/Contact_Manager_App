package edu.udemylearning.contactmanagerapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyRepository {
    private final ContactsDAO contactsDAO;
    ExecutorService executorService;
    Handler handler;
    public MyRepository(Application application) {

        executorService = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
        ContactDB contactDB = ContactDB.getInstance(application);
        this.contactsDAO = contactDB.getContactDAO();
    }

    public void addContact(Contacts contacts){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                contactsDAO.insert(contacts);
            }
        });

    }
    public void deleteContact(Contacts contacts){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                contactsDAO.delete(contacts);
            }
        });

    }
    public LiveData <List<Contacts>> getAllContacts(){
        return contactsDAO.getAllContacts();
    }
}
