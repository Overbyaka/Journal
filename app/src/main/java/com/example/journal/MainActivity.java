package com.example.journal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"create",Toast.LENGTH_SHORT).show();
    }

    String LOGINSTUDENT = "Mur";
    String PASSWORDSTUDENT = "Meow";
    String LOGINTEACHER = "1";
    String PASSWORDTEACHER = "1";
    String LOGINDIRECTOR = "2";
    String PASSWORDDIRECTOR = "2";

  /*  String FILENAME = "login.txt";

    public boolean login(String l, String p){
        boolean isLogin = false;
        try {
            InputStream inputStream = openFileInput(FILENAME);

            if (inputStream != null) {
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(isr);
                String line;
                String[]answer;
                while ((line = reader.readLine()) != null) {
                    answer = line.split(" ");
                    if(l.equals(answer[0])&&p.equals(answer[1])){
                        isLogin = true;
                        break;
                    }
                }
                inputStream.close();
            }

        } catch(Throwable throwable){
            Toast.makeText(getApplicationContext(),
                    "Exception: " + throwable.toString(), Toast.LENGTH_LONG).show();
        }
        return isLogin;
    }*/
    public void entering(View view){
        String login = ((EditText)findViewById(R.id.login)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();
        TextView result = (TextView) findViewById(R.id.result);
        if(LOGINSTUDENT.equals(login) && PASSWORDSTUDENT.equals(password)){
        //if(login(login,password)){
            result.setTextColor(Color.GREEN);
            result.setText("Верно");
            Intent i = new Intent(MainActivity.this,MainActivity2.class);
            i.putExtra("access","student");
            startActivity(i);
        } else if(LOGINTEACHER.equals(login) && PASSWORDTEACHER.equals(password)){
            //if(login(login,password)){
            result.setTextColor(Color.GREEN);
            result.setText("Верно");
            Intent i = new Intent(MainActivity.this,MainActivity2.class);
            i.putExtra("access","teacher");
            startActivity(i);
        } else if(LOGINDIRECTOR.equals(login) && PASSWORDDIRECTOR.equals(password)){
            //if(login(login,password)){
            result.setTextColor(Color.GREEN);
            result.setText("Верно");
            Intent i = new Intent(MainActivity.this,MainActivity2.class);
            i.putExtra("access","director");
            startActivity(i);
        }
        else {
            result.setTextColor(Color.RED);
            result.setText("Вы ошиблись в логине или пароле");
        }

    }
}
