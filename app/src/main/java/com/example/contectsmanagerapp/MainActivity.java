package com.example.contectsmanagerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.contectsmanagerapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Data source
    private ContactsDatabase contactsDatabase;
    private ArrayList<Contects> contectsArrayList=new ArrayList<>();

    //adaptor
    private MyAdaptor myAdaptor;

    //binding
    private ActivityMainBinding mainBinding;
    private MainActivityClickHandler clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //binding
        mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        clickHandler=new MainActivityClickHandler(this);
        mainBinding.setClickHandler(clickHandler);

        //recycler view
        RecyclerView recyclerView=mainBinding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);




        contactsDatabase=ContactsDatabase.getInstance(this);

        MyviewModel viewModel=new ViewModelProvider(this).get(MyviewModel.class);
//        Contects c1=new Contects("jack","hello@gmail.com");
//        viewModel.addNewContact(c1);

        contectsArrayList.clear();
        viewModel.getAllcontacts().observe(this, new Observer<List<Contects>>() {
            @Override
            public void onChanged(List<Contects> contects) {
                contectsArrayList.clear();
                for(Contects c:contects)
                {


                    if(c.getName() != null)
                    {
                        contectsArrayList.add(c);
                    Log.v("TAGY",c.getName());}


                   }
                myAdaptor.notifyDataSetChanged();
            }
        });



        myAdaptor=new MyAdaptor(contectsArrayList);
        recyclerView.setAdapter(myAdaptor);


        //swip to deleat
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                Contects c=contectsArrayList.get(viewHolder.getAdapterPosition());

                viewModel.deleatContect(c);

            }
        }).attachToRecyclerView(recyclerView);
    }
}