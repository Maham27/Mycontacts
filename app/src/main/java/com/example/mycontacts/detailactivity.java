package com.example.mycontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class detailactivity extends AppCompatActivity {
     TextView tvname2,tvsurname2,tvAdress,tvDateofbirth;
     ImageView imp,imback,imCall;
     EditText etNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailactivity);
        imp=findViewById(R.id.imp);
        tvname2=findViewById(R.id.tvname2);
        tvsurname2=findViewById(R.id.tvsurname2);
        etNo=findViewById(R.id.etNo);
        tvAdress=findViewById(R.id.tvAdress);
        tvDateofbirth=findViewById(R.id.tvDateofbirth);
        imback=findViewById(R.id.imback);
        imCall=findViewById(R.id.imCall);

        tvname2.setText(getIntent().getStringExtra("name"));
        tvsurname2.setText(getIntent().getStringExtra("surname"));
        etNo.setText(getIntent().getStringExtra("no"));
        tvDateofbirth.setText(getIntent().getStringExtra("Dateofb"));
        tvAdress.setText(getIntent().getStringExtra("adress"));
        imCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+etNo.getText().toString()));
                startActivity(intent1);
            }
        });
        imback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(detailactivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}