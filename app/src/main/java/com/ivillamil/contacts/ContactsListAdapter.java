package com.ivillamil.contacts;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by ivillamil on 12/12/17.
 */

class ContactsListAdapter extends RecyclerView.Adapter<ContactsListAdapter.ContactViewHolder> {
    private List<Contact> contacts;
    private int layout;
    private OnItemClickListener itemClickListener;

    ContactsListAdapter(List<Contact> contacts, int layout, OnItemClickListener listener) {
        this.contacts = contacts;
        this.layout = layout;
        this.itemClickListener = listener;
    }


    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new ContactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.bind(contacts.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    void update(List<Contact> contacts) {
        this.contacts.clear();
        this.contacts = contacts;
        this.notifyDataSetChanged();
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView titleTextView;
        private SimpleDraweeView contactImage;

        ContactViewHolder(View itemView) {
            super(itemView);
            this.nameTextView = itemView.findViewById(R.id.contactName);
            this.titleTextView = itemView.findViewById(R.id.contactTitle);
            this.contactImage = itemView.findViewById(R.id.contactImage);
        }

        void bind(final Contact contact, final OnItemClickListener listener) {
            nameTextView.setText(contact.getName());
            titleTextView.setText(contact.getTitle());

            Uri uri = Uri.parse(contact.getAvatar());
            contactImage.setImageURI(uri);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(contact, getAdapterPosition());
                }
            });
        }
    }

    interface OnItemClickListener {
        void onItemClick(Contact contact, int position);
    }
}
