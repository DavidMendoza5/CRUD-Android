package com.example.androidwithsqllite;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class Users extends AppCompatActivity {
    TextView name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_users);

        DataBase db = new DataBase(getApplicationContext());

        List<UserModel> users = db.showUsers();

        name = findViewById(R.id.users);

        for (int i = 0; i < users.size(); i++) {
           name.append("RFC:\t"+ users.get(i).getRfc() + "\nUser:\t" + users.get(i).getName() + "\n\n");
        }

    }

}
