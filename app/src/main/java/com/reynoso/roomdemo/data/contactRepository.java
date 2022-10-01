package com.reynoso.roomdemo.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.reynoso.roomdemo.Utils.ContactRoomDatabase;
import com.reynoso.roomdemo.model.Contact;

import java.util.List;

/**
 * Created by Noé Benjamín Reynoso Aguirre on 9/30/2022.
 */
public class contactRepository {
    private ContactDao contactDao;
    private LiveData<List<Contact>> allContacts;

    public contactRepository(Application application) {
        ContactRoomDatabase contactRoomDatabase = ContactRoomDatabase.getDatabase(application);
        contactDao = contactRoomDatabase.contactDao();
        allContacts = contactDao.getAllContacts();
    }
    public LiveData<List<Contact>> getAllContacts(){
        return allContacts;
    }
    public void insertContact(Contact contact){
        ContactRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                contactDao.insertContact(contact);
            }
        });
    }
}
