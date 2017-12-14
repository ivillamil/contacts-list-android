package com.ivillamil.contacts;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

public class ContactDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.containsKey("address")) {
                TextView address = (TextView) findViewById(R.id.contactAddress);
                address.setText(bundle.getString("address"));
            }
            if (bundle.containsKey("avatar")) {
                Uri uri = Uri.parse(bundle.getString("avatar"));
                SimpleDraweeView contactImage = (SimpleDraweeView) findViewById(R.id.contactImage);
                contactImage.setImageURI(uri);
            }
            if (bundle.containsKey("description")) {
                TextView description = (TextView) findViewById(R.id.contactDescription);
                description.setText(bundle.getString("description"));
            }
            if (bundle.containsKey("email")) {
                TextView email = (TextView) findViewById(R.id.contactEmail);
                email.setText(bundle.getString("email"));
            }
            if (bundle.containsKey("name")) {
                TextView contactName = (TextView) findViewById(R.id.contactName);
                contactName.setText(bundle.getString("name"));
            }
            if (bundle.containsKey("phone")) {
                TextView phone = (TextView) findViewById(R.id.contactPhone);
                phone.setText(bundle.getString("phone"));
            }
            if (bundle.containsKey("title")) {
                TextView title = (TextView) findViewById(R.id.contactTitle);
                title.setText(bundle.getString("title"));
            }
        }
    }

    public void onBack(View view) {
        finish();
    }
}
