package com.example.mycontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class detailactivity extends AppCompatActivity {
     TextView tvname2,tvsurname2;
     ImageView imp;
     EditText etNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailactivity);
        imp=findViewById(R.id.imp);
        tvname2=findViewById(R.id.tvname2);
        tvsurname2=findViewById(R.id.tvsurname2);
        etNo=findViewById(R.id.etNo);
        tvname2.setText(getIntent().getStringExtra("name"));
        tvsurname2.setText(getIntent().getStringExtra("surname"));
        imp.setImageResource(getIntent().getIntExtra("image",0));
        etNo.setText(getIntent().getStringExtra("no"));

    }
}