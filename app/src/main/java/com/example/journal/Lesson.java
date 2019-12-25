package com.example.journal;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lesson extends Activity {
    String data;
    String name;
    String saveText = new String();
    SharedPreferences sPref;
    int temp;
    String newSaveText;
    final String SAVED_TEXT = "saved_text";
    String[] sentenses;


    boolean isExistHomework = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson);
        isExistHomework = false;
        data = getIntent().getStringExtra("data");
        name = getIntent().getStringExtra("name");
        String access = getIntent().getStringExtra("access");
        final String dateAndName = data + ", " + name;
        TextView tv = (TextView) findViewById(R.id.tv);
        final EditText et = (EditText) findViewById(R.id.et);
        et.setText("");
        loadText();
        Button bt = (Button) findViewById(R.id.bt);
        tv.setText(dateAndName);

        sentenses = saveText.split("\n");
        if(access.equals("student")){
            et.setEnabled(false);
            bt.setVisibility(View.GONE);
        }else{
            et.setEnabled(true);
            bt.setVisibility(View.VISIBLE);
        }
        for(int i = 1; i < sentenses.length-1;i+=2){
            if(sentenses[i].equals(dateAndName)){
                temp = i;
                isExistHomework = true;
                break;
            }
        }
        if(isExistHomework) {
            et.setText(sentenses[temp + 1]);
            Toast.makeText(Lesson.this,"Text loaded",Toast.LENGTH_LONG).show();
        }
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isExistHomework){
                    sentenses[temp+1] = et.getText().toString();
                    fillNewSaveText(sentenses);

                } else{
                    newSaveText = saveText + "\n" + dateAndName + "\n" + et.getText().toString();
                    //Toast.makeText(Lesson.this,newSaveText,Toast.LENGTH_LONG).show();
                }
                saveText();
            }
        });
    }

    private void saveText(){
        sPref = getSharedPreferences("MyPref",MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT,newSaveText);
        ed.commit();
        Toast.makeText(Lesson.this,"Text saved",Toast.LENGTH_LONG).show();
    }
    private void loadText(){
        sPref = getSharedPreferences("MyPref",MODE_PRIVATE);
        saveText = sPref.getString(SAVED_TEXT,"");
    }
    private void fillNewSaveText(String[] sentenses){
        for(int i = 0; i < sentenses.length-1; i++){
            newSaveText += sentenses[i];
        }
    }
}
