package com.example.contectsmanagerapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactsDao {
    @Insert
    void insert(Contects contacts);
    @Delete
    void delete(Contects contects);

    

    @Query("SELECT * FROM contacts_table")
    LiveData<List<Contects>> getAllContacts();
}

