package com.example.androidwithsqllite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class User extends AppCompatActivity {
    TextView user, userName, userPhone, userEmail;
    String rfc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);

        rfc = getIntent().getStringExtra("userRfc");

        user = findViewById(R.id.showUserInfo);
        userName = findViewById(R.id.newName);
        userPhone = findViewById(R.id.newPhone);
        userEmail = findViewById(R.id.newEmail);

        DataBase db = new DataBase(getApplicationContext());
        UserModel userModel = new UserModel();

        userModel = db.searchUser(userModel, rfc);

        user.setText("Usuario:\t"+userModel.getRfc());
        userName.setText(userModel.getName());
        userPhone.setText(userModel.getPhone());
        userEmail.setText(userModel.getEmail());
    }

    public void updateUser(View view) {
        DataBase db = new DataBase(getApplicationContext());

        db.updateUser(rfc, userName.getText().toString(), userPhone.getText().toString(), userEmail.getText().toString());
        Toast.makeText(getApplicationContext(), "Usuario actualizado correctamente", Toast.LENGTH_SHORT).show();
    }

    public void deleteUser(View view) {
        DataBase db = new DataBase(getApplicationContext());
        db.deleteUser(rfc);
        Toast.makeText(getApplicationContext(), "Usuario eliminado correctamente", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, Users.class);
        startActivity(i);
    }
}
