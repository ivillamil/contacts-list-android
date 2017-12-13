package com.ivillamil.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ContactsListActivity extends AppCompatActivity {
    List<Contact> contacts = new ArrayList<Contact>();
    RecyclerView listView;
    ContactsListAdapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);

        listView = (RecyclerView) findViewById(R.id.listView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ContactsListAdapter(contacts, R.layout.contact_item, new ContactsListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Contact contact, int position) {
                Toast.makeText(ContactsListActivity.this, "Clicked: " + contact.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setLayoutManager(layoutManager);
        listView.setAdapter(adapter);

        getContacts();
    }

    private void getContacts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/ivillamil/76c07f710e4151e75911a0aab72e1a38/raw/772085e70f361bdd28e2d70fabe2e7f4826e487d/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ContactsService service = retrofit.create(ContactsService.class);
        Call<List<Contact>> contactCall = service.getContacts();
        contactCall.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                contacts = response.body();
                adapter.update(contacts);
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {

            }
        });
    }
}
