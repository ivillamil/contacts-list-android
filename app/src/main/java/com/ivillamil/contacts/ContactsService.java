package com.ivillamil.contacts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ivillamil on 12/13/17.
 */

public interface ContactsService {
    @GET("users-db.json")
    Call<List<Contact>> getContacts();
}
