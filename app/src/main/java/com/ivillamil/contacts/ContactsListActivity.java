package com.ivillamil.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ContactsListActivity extends AppCompatActivity {
    List<String> contacts = new ArrayList<String>();
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);

        listView = (ListView) findViewById(R.id.listView);

        contacts.add("John");
        contacts.add("Kuzac");
        contacts.add("Laura");
        contacts.add("John");
        contacts.add("Kuzac");
        contacts.add("Laura");
        contacts.add("John");
        contacts.add("Kuzac");
        contacts.add("Laura");
        contacts.add("John");
        contacts.add("Kuzac");
        contacts.add("Laura");
        contacts.add("John");
        contacts.add("Kuzac");
        contacts.add("Laura");
        contacts.add("John");
        contacts.add("Kuzac");
        contacts.add("Laura");
        contacts.add("John");
        contacts.add("Kuzac");
        contacts.add("Laura");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ContactsListActivity.this, "Clicked: " + contacts.get(position), Toast.LENGTH_LONG).show();
            }
        });

        ContactsListAdapter contactsAdapter = new ContactsListAdapter(this, R.layout.contact_item, contacts);
        listView.setAdapter(contactsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_item:
                Log.i("Menu", "Add item");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void getContacts() {
        String url = "https://gist.githubusercontent.com/ivillamil/e10ca31afcd136a5a7c7/raw/240a27e8c34b5bec7edfa19ee42efad909a85401/demo-users-db.json";

    }
}
