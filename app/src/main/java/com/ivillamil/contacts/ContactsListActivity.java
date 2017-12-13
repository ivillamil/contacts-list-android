package com.ivillamil.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ContactsListActivity extends AppCompatActivity {
    List<String> contacts;
    RecyclerView listView;
    ContactsListAdapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);

        contacts = getContacts();

        listView = (RecyclerView) findViewById(R.id.listView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ContactsListAdapter(contacts, R.layout.contact_item, new ContactsListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String contact, int position) {
                Toast.makeText(ContactsListActivity.this, "Clicked: " + contact, Toast.LENGTH_SHORT).show();
            }
        });

        listView.setLayoutManager(layoutManager);
        listView.setAdapter(adapter);
    }

    private List<String> getContacts() {
        String url = "https://gist.githubusercontent.com/ivillamil/e10ca31afcd136a5a7c7/raw/240a27e8c34b5bec7edfa19ee42efad909a85401/demo-users-db.json";
        return new ArrayList<String>() {{
            add("Antwon Schoen");
            add("Kenyatta Anderson");
            add("Miss Ida Casper");
            add("Christop Feil");
            add("Rachel Raeilly");
            add("Dra. Lila Bruen");
        }};
    }
}
