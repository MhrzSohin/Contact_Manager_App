package edu.udemylearning.contactmanagerapp;

import android.view.LayoutInflater;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.udemylearning.contactmanagerapp.databinding.ContactListItemBinding;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactViewHolder> {
    private ArrayList<Contacts> contactsArrayList;

    public MyAdapter(ArrayList<Contacts> contactsArrayList) {
        this.contactsArrayList = contactsArrayList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactListItemBinding contactListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.contact_list_item,parent,false);
        return new ContactViewHolder(contactListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contacts currentContacts = contactsArrayList.get(position);
        holder.contactListItemBinding.setContact(currentContacts);
    }

    public void setContactsArrayList(ArrayList<Contacts> contactsArrayList) {
        this.contactsArrayList = contactsArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (contactsArrayList!=null){
        return contactsArrayList.size();
        }else {
            return 0;
        }


    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
         private ContactListItemBinding contactListItemBinding;

         public ContactViewHolder(@NonNull ContactListItemBinding contactListItemBinding) {
             super(contactListItemBinding.getRoot());
             this.contactListItemBinding = contactListItemBinding;

         }
     }
}
