package com.example.androidwithsqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText rfc, name, phone, email;
    Button addUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBase db = new DataBase(getApplicationContext());

        rfc = findViewById(R.id.rfcInput);
        name = findViewById(R.id.nameInput);
        phone = findViewById(R.id.phoneInput);
        email = findViewById(R.id.emailInput);

        addUser = findViewById(R.id.btnAdd);

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.addUser(rfc.getText().toString(), name.getText().toString(), Integer.parseInt(phone.getText().toString()),
                        email.getText().toString());
                Toast.makeText(getApplicationContext(), "Usuario agregado correctamente", Toast.LENGTH_SHORT).show();
            }
        });
    }
}