package com.example.contectsmanagerapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Repository {
    private final ContactsDao contactsDao;
    Handler handler;

    ExecutorService executor;
    public Repository(Application application) {

        ContactsDatabase contactsDatabase=ContactsDatabase.getInstance(application);
        this.contactsDao=contactsDatabase.getcontactDAO();

        //FOr background databse operations
        executor= Executors.newSingleThreadExecutor();


        // for updation of UI
        handler = new Handler(Looper.getMainLooper());

    }

    public void addcontact(Contects contect)
    {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactsDao.insert(contect);
            }
        });

    }

    public void deletecontact(Contects contect)
    {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactsDao.delete(contect);
            }
        });

    }

    public LiveData<List<Contects>> getAllContects()
    {

        return  contactsDao.getAllContacts();
    }
}
