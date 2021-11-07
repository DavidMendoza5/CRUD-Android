package com.example.androidwithsqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void getUsers(View view) {
        Intent i = new Intent(this, Users.class);
        startActivity(i);
    }

    public void addNewUser(View view) {
        DataBase db = new DataBase(getApplicationContext());
        UserModel userModel;

        userModel = getInputData();
        db.addUser(userModel.getRfc(), userModel.getName(), userModel.getPhone(), userModel.getEmail());
        Toast.makeText(getApplicationContext(), "Usuario agregado correctamente", Toast.LENGTH_SHORT).show();

    }

    public UserModel getInputData() {
        EditText inputRfc, inputName, inputPhone, inputEmail;
        String rfc, name, email, phone;

        inputRfc = findViewById(R.id.rfcInput);
        inputName = findViewById(R.id.nameInput);
        inputPhone = findViewById(R.id.phoneInput);
        inputEmail = findViewById(R.id.emailInput);

        rfc = inputRfc.getText().toString();
        name = inputName.getText().toString();
        phone = inputPhone.getText().toString();
        email = inputEmail.getText().toString();

        return new UserModel(rfc, name, phone, email);
    }
}