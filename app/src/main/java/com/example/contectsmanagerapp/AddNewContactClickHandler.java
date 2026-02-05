package com.example.contectsmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {
    Contects contect;
    Context context;
    MyviewModel myviewModel;

    public AddNewContactClickHandler(Contects contect, Context context, MyviewModel myviewModel) {
        this.contect = contect;
        this.context = context;
        this.myviewModel = myviewModel;
    }

    public void onSubmitBtnClicked(View view){
        if(contect.getName()==null || contect.getEmail()==null)
        {
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i =new Intent(context, MainActivity.class);
//            i.putExtra("Name",contect.getName());
//            i.putExtra("Email",contect.getEmail());
            Contects c=new Contects(contect.getName(), contect.getEmail());
            myviewModel.addNewContact(c);
            context.startActivity(i);
        }
    }
}
