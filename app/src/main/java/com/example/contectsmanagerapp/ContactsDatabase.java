package com.example.contectsmanagerapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contects.class},version=1)
public abstract class ContactsDatabase extends RoomDatabase {

    public abstract ContactsDao getcontactDAO();

    //singlton pattern

    private static ContactsDatabase dbinstance;

    public static synchronized ContactsDatabase getInstance(Context context){
        if(dbinstance==null){
            dbinstance=Room.databaseBuilder(context.getApplicationContext(),ContactsDatabase.class,"contacts_db").fallbackToDestructiveMigration().build();
        }
        return dbinstance;
    }

}
