package com.ivillamil.contacts;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ivillamil on 12/12/17.
 */

class ContactsListAdapter extends RecyclerView.Adapter<ContactsListAdapter.ContactViewHolder> {
    private List<String> contacts;
    private int layout;
    private OnItemClickListener itemClickListener;

    ContactsListAdapter(List<String> contacts, int layout, OnItemClickListener listener) {
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

    static class ContactViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView titleTextView;

        ContactViewHolder(View itemView) {
            super(itemView);
            this.nameTextView = itemView.findViewById(R.id.contactName);
            this.titleTextView = itemView.findViewById(R.id.contactTitle);
        }

        void bind(final String contact, final OnItemClickListener listener) {
            nameTextView.setText(contact);
            titleTextView.setText(contact);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(contact, getAdapterPosition());
                }
            });
        }
    }

    interface OnItemClickListener {
        void onItemClick(String contact, int position);
    }
}
