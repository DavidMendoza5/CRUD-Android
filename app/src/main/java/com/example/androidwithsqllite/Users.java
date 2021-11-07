package com.example.androidwithsqllite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

    @Override
    protected void onResume() {
        super.onResume();

        DataBase db = new DataBase(getApplicationContext());

        List<UserModel> users = db.showUsers();

        name = findViewById(R.id.users);

        for (int i = 0; i < users.size(); i++) {
            if(i == 0) {
                name.setText("RFC:\t"+ users.get(i).getRfc() + "\nUser:\t" + users.get(i).getName() + "\n\n");
            } else {
                name.append("RFC:\t"+ users.get(i).getRfc() + "\nUser:\t" + users.get(i).getName() + "\n\n");
            }
        }
    }

    public  void searchUserByRfc(View view) {
        EditText rfc = (EditText) findViewById(R.id.searchRFC);
        Intent i = new Intent(this, User.class);
        i.putExtra("userRfc", rfc.getText().toString());
        startActivity(i);
    }

}
