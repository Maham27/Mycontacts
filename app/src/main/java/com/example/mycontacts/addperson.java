package com.example.mycontacts;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.ImageView;





public class addperson extends AppCompatActivity {


     EditText etname,etemail,etnum,etadress,etdob;
     ImageView ivp,imBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addperson);
        etname=findViewById(R.id.etname);
        etemail=findViewById(R.id.etemail);
        etnum=findViewById(R.id.etnum);
        etadress=findViewById(R.id.etadress);
        etdob=findViewById(R.id.etdob);
        ivp=findViewById(R.id.ivp);
        imBack=findViewById(R.id.imBack);

        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name, Eml;
                String Adrs;
                String number, dob;
                Name = etname.getText().toString().trim();
                Eml = etemail.getText().toString().trim();
                number = etnum.getText().toString().trim();
                Adrs = etadress.getText().toString().trim();
                dob = etdob.getText().toString().trim();
                if (Name.isEmpty()) {
                    etname.setError("name cannot be empty");
                } else if (Eml.isEmpty()) {
                    etemail.setError("email cannot be empty");
                } else if (number.isEmpty()) {
                    etnum.setError("no cannot be empty");
                } else if (Adrs.isEmpty()) {
                    etadress.setError("adress cannot be empty");
                } else if (dob.isEmpty()) {
                    etdob.setError("name cannot be empty");
                } else {
                    Intent intent = new Intent(addperson.this, MainActivity.class);
                    intent.putExtra("n", Name);
                    intent.putExtra("e", Eml);
                    intent.putExtra("Adres", Adrs);
                    intent.putExtra("num", number);
                    intent.putExtra("D", dob);
                    setResult(RESULT_OK, intent);
                    startActivity(intent);
                }
            }
            });
}
}