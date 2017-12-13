package com.ivillamil.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ivillamil on 12/12/17.
 */

public class ContactsListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> contacts;

    public ContactsListAdapter(Context context, int layout, List<String> contacts) {
        this.context = context;
        this.layout = layout;
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return this.contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return this.contacts.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ContactViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(this.layout, null);
            holder = new ContactViewHolder();
            holder.nameTextView = convertView.findViewById(R.id.contactName);
            convertView.setTag(holder);
        } else {
            holder = (ContactViewHolder) convertView.getTag();
        }


        String contact = contacts.get(position);
        holder.nameTextView.setText(contact);

        return convertView;
    }

    static class ContactViewHolder {
        private TextView nameTextView;

    }
}
