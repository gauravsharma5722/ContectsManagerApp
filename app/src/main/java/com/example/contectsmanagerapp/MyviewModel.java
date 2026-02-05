package com.example.contectsmanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyviewModel extends AndroidViewModel {

    private Repository myrepository;
    private LiveData<List<Contects>> allcontacts;

    public MyviewModel(@NonNull Application application) {
        super(application);
        this.myrepository =new Repository(application);
    }

    public LiveData<List<Contects>> getAllcontacts()
    {
        allcontacts=myrepository.getAllContects();
        return allcontacts;
    }

    public void addNewContact(Contects contect)
    {
        myrepository.addcontact(contect);
    }
    public void deleatContect(Contects contect)
    {
        myrepository.deletecontact(contect);
    }

}
