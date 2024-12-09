package edu.udemylearning.contactmanagerapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Contacts.class},version = 1)
public abstract class ContactDB extends RoomDatabase {
    public abstract ContactsDAO getContactDAO();

    //singleton pattern
    private static ContactDB dbinstance;
    public static synchronized ContactDB getInstance(Context context){
        if (dbinstance == null){
            dbinstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ContactDB.class,"contacts_db").fallbackToDestructiveMigration().build();
        }return dbinstance;

    }
}
