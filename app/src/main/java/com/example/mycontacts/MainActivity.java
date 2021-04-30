package com.example.mycontacts;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity implements contacts.contactclicked {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter myadptr;
    ArrayList<person> friends;
    ImageButton btnadd;
    final int addperson = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        btnadd = findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //friends.add(new person("hanan","hanan@gmail.com","bhai","03333456789","1-2-1998","street1,modeltown"));
                //myadptr.notifyDataSetChanged();
                Intent intent = new Intent(MainActivity.this, addperson.class);
                startActivityForResult(intent, addperson);
            }
        });

        friends = new ArrayList<>();
        friends.add(new person("maham naveed", "mahamnaveed@gmail.com", "maham", "0333123457", "27.11.1999", "street4,block1,jt"));
        friends.add(new person("tooba naveed", "toobanaveed@gmail.com", "tooba", "03334353333", "25.10.1996", "street5,blockA,valancia"));
        friends.add(new person("usama naveed", "usamanaveed@gmail.com", "bhai", "033123455", "8.12.1994", "street8,blockD,jt"));
        friends.add(new person("sajal aly", "sajalaly@gmail.com", "aiza", "033123455", "18.3.1997", "street8,block1,DHA"));
        friends.add(new person("hania amir", "haniaamir@gmail.com", "hania", "033123455", "2.9.1999", "street11,blockC,Askari11"));
        friends.add(new person("ahad raza", "ahadraza@gmail.com", "ahad", "033123455", "2.3.2001", "street19,blockB,modeltown"));
        myadptr = new contacts(this, friends);
        recyclerView.setAdapter(myadptr);

    }


    @Override
    public void oncontactclicked(int index) {
        //Toast.makeText(this,friends.get(index).getName(), Toast.LENGTH_SHORT).show();

        Intent intent2 = new Intent(MainActivity.this, detailactivity.class);
        intent2.putExtra("name", friends.get(index).getName());
        intent2.putExtra("surname", friends.get(index).getEmail());
        intent2.putExtra("no", friends.get(index).getNo());
        intent2.putExtra("adress", friends.get(index).getAdress());
        intent2.putExtra("Dateofb", friends.get(index).getDateofbirth());
        startActivity(intent2);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==addperson) {
            if (resultCode == RESULT_OK) {
                data.getStringExtra("n");
                data.getStringExtra("e");
                data.getStringExtra("Adres");
                data.getStringExtra("num");
                data.getStringExtra("D");
                friends.add(new person("n", "e", "bhai", "num", "D", "Adres"));
                myadptr.notifyDataSetChanged();
                //Toast.makeText(this, "result passed", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "result not passed", Toast.LENGTH_SHORT).show();
            }
        }
        }
    }
