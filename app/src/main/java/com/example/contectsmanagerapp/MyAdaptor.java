package com.example.contectsmanagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contectsmanagerapp.databinding.ContactListItemBinding;

import java.util.ArrayList;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.ContactViewHolder> {
    public MyAdaptor(ArrayList<Contects> contects) {
        this.contects = contects;
    }

    private ArrayList<Contects> contects;

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ContactListItemBinding contactListItemBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.contact_list_item,parent,false);
        return new ContactViewHolder(contactListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        Contects currentcontect = contects.get(position);
        holder.contactListItemBinding.setContact(currentcontect);

    }

    @Override
    public int getItemCount() {
        if (contects != null)
        {
            return contects.size();
        }

        else {
            return 0;
        }

    }

    public void setContects(ArrayList<Contects> contects) {
        this.contects = contects;

        notifyDataSetChanged();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder{
        private ContactListItemBinding contactListItemBinding;

        public ContactViewHolder(@NonNull  ContactListItemBinding contactListItemBinding) {
            super(contactListItemBinding.getRoot());
            this.contactListItemBinding = contactListItemBinding;
        }
    }
}
