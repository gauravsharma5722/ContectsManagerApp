package com.example.contectsmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.contectsmanagerapp.databinding.ActivityAddNewContactBinding;

public class AddNewContactActivity extends AppCompatActivity {
    private ActivityAddNewContactBinding binding;
    private AddNewContactClickHandler handler;
    private Contects contects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);
        contects=new Contects();
        binding= DataBindingUtil.setContentView(this,R.layout.activity_add_new_contact);
        binding.setContact(contects);
        MyviewModel myviewModel=new ViewModelProvider(this).get(MyviewModel.class);
        handler=new AddNewContactClickHandler(contects,this,myviewModel);
        binding.setClickhandler(handler);
    }
}