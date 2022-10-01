package com.reynoso.roomdemo.Utils;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.reynoso.roomdemo.data.ContactDao;
import com.reynoso.roomdemo.model.Contact;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Noé Benjamín Reynoso Aguirre on 9/30/2022.
 */
@Database(entities = {Contact.class},version = 1,exportSchema = false)
public abstract class ContactRoomDatabase extends RoomDatabase {
    public abstract ContactDao contactDao();
    private static volatile ContactRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    private static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private final String DATABASE_NAME = "contact_db";
    public ContactRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (ContactRoomDatabase.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),ContactRoomDatabase.class,DATABASE_NAME).build();
            }
        }
        return INSTANCE;
    }
}
