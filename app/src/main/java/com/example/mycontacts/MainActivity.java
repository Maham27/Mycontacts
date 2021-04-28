package com.example.mycontacts;

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

public class MainActivity extends AppCompatActivity implements contacts.contactclicked {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter myadptr;
    ArrayList<person> friends;
    ImageButton btnadd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        btnadd=findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friends.add(new person("rana","waqas","bhai","03333456789"));
                myadptr.notifyDataSetChanged();
            }
        });

        friends=new ArrayList<>();
        friends.add(new person("maham","naveed","maham","0333123457"));
        friends.add(new person("tooba","naveed","tooba","03334353333"));
        friends.add(new person("usama","naveed","bhai","033123455"));
        friends.add(new person("sajal","naveed","aiza","033123455"));
        friends.add(new person("hania","amir","hania","033123455"));
        friends.add(new person("ahad","raza","ahad","033123455"));
        myadptr=new contacts(this,friends);
        recyclerView.setAdapter(myadptr);

    }



    @Override
    public void oncontactclicked(int index) {
        //Toast.makeText(this,friends.get(index).getName(), Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(MainActivity.this,detailactivity.class);
        intent.putExtra("name",friends.get(index).getName());
        intent.putExtra("surname",friends.get(index).getSurname());
        intent.putExtra("image",friends.get(index).getPreference());
        intent.putExtra("no",friends.get(index).getNo());
        startActivity(intent);
        finish();
    }
}