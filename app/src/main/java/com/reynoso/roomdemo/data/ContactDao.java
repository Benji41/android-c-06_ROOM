package com.reynoso.roomdemo.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.reynoso.roomdemo.model.Contact;

import java.util.List;

/**
 * Created by Noé Benjamín Reynoso Aguirre on 9/30/2022.
 */
@Dao
public interface ContactDao {
    //CRUD OPERATIONS
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertContact(Contact contact);

    @Query("DELETE FROM CONTACT_TB")
    void deleteAllContacts();

    @Delete
    void deleteSingleContact(Contact contact);

    @Query("SELECT * FROM contact_tb WHERE contact_id")
    LiveData <Contact> getSingleContact(Contact contact);

    @Query("SELECT * FROM contact_tb")
    LiveData<List<Contact>> getAllContacts();

    @Update
    int updateContact(Contact contact);
}
