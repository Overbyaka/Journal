package com.example.journal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"create",Toast.LENGTH_SHORT).show();
    }

    String LOGIN= "Mur";
    String PASSWORD = "Meow";

    public void entering(View view){
        String login = ((EditText)findViewById(R.id.login)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();
        TextView result = (TextView) findViewById(R.id.result);
        if(LOGIN.equals(login) && PASSWORD.equals(password)){
            result.setTextColor(Color.GREEN);
            result.setText("Верно");
            Intent i = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(i);
        }
        else {
            result.setTextColor(Color.RED);
            result.setText("Вы ошиблись в логине или пароле");
        }
    }
}
