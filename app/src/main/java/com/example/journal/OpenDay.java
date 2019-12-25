package com.example.journal;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.journal.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class OpenDay extends Activity {
    String day,month,year,data;
    int dayOfWeek;
    String[] monday = {"Математика, 110 каб.", "Иностранный язык, 113 каб.","Физическая культура","Физическая культура","Физика, 217 каб.","Химия, 311 каб.","Литература, 23 каб.","Физика, 217 каб."};
    String[] tuesday = {"История, 21 каб.","История, 21 каб.","Математика, 110 каб.","Физика, 213 каб.","Русский язык, 304 каб.","Информатика, 109 каб.","Иностранный язык, 113 каб.","Литература, 216 каб."};
    String[] wednesday = {"Информатика, 109 каб.","Биология, 18 каб.","Обществознание, 215(3) каб.","Физика, 213 каб.","ОБЖ, конф.зал","Математика, 110 каб.","Астрономия, 101 каб.","Ничего"};
    String[] thursday = {"Математика, 110 каб.","Математика, 110 каб.","История, 21 каб.","География, 115 каб.","Физика, 217 каб.","Английский язык, 113 каб.","Литература, 119 каб.","Ничего"};
    String[] friday = {"Обществознание, 110 каб.","Математика, 110 каб.","Русский язык, 119 каб.","Физическая культура","Черчение, БГТУ","Черчение, БГТУ","Программирование, БГТУ","Программирование, БГТУ"};
    String[] saturday = {"Ничего","Ничего","Ничего","Ничего","Ничего","Ничего","Ничего","Ничего"};
    String[] sunday = {"Ничего","Ничего","Ничего","Ничего","Ничего","Ничего","Ничего","Ничего"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_day);
        day = getIntent().getStringExtra("day");
        month = getIntent().getStringExtra("month");
        year = getIntent().getStringExtra("year");
        Calendar c = new GregorianCalendar(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
        dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        data = day + "." + (Integer.parseInt(month)+1) + "." + year;
        TextView date = (TextView)findViewById(R.id.date); date.setText(data);
        final Button[] lessons = new Button[8];
        lessons[0] = (Button) findViewById(R.id.firstLesson);
        lessons[1] = (Button) findViewById(R.id.secondLesson);
        lessons[2] = (Button) findViewById(R.id.thirdLesson);
        lessons[3] = (Button) findViewById(R.id.fourthLesson);
        lessons[4] = (Button) findViewById(R.id.fifthLesson);
        lessons[5] = (Button) findViewById(R.id.sixthLesson);
        lessons[6] = (Button) findViewById(R.id.seventhLesson);
        lessons[7] = (Button) findViewById(R.id.eighthLesson);
        final Button more = (Button) findViewById(R.id.more); more.setText("Заметки");
        switch (dayOfWeek){
            case 1:
                for(int i = 0; i < 8;i++){
                    lessons[i].setText(sunday[i]);
                }
                break;
            case 2:
                for(int i = 0; i < 8;i++){
                    lessons[i].setText(monday[i]);
                }
                break;
            case 3:
                for(int i = 0; i < 8;i++){
                    lessons[i].setText(tuesday[i]);
                }
                break;
            case 4:
                for(int i = 0; i < 8;i++){
                    lessons[i].setText(wednesday[i]);
                }
                break;
            case 5:
                for(int i = 0; i < 8;i++){
                    lessons[i].setText(thursday[i]);
                }
                break;
            case 6:
                for(int i = 0; i < 8;i++){
                    lessons[i].setText(friday[i]);
                }
                break;
            case 7:
                for(int i = 0; i < 8;i++){
                    lessons[i].setText(saturday[i]);
                }
                break;
        }

        lessons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OpenDay.this,Lesson.class);
                i.putExtra("access",getIntent().getStringExtra("access"));
                i.putExtra("data",data);
                i.putExtra("name",lessons[0].getText());
                startActivity(i);
            }
        });
        lessons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OpenDay.this,Lesson.class);
                i.putExtra("access",getIntent().getStringExtra("access"));
                i.putExtra("data",data);
                i.putExtra("name",lessons[1].getText());
                startActivity(i);
            }
        });
        lessons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OpenDay.this,Lesson.class);
                i.putExtra("access",getIntent().getStringExtra("access"));
                i.putExtra("data",data);
                i.putExtra("name",lessons[2].getText());
                startActivity(i);
            }
        });
        lessons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OpenDay.this,Lesson.class);
                i.putExtra("access",getIntent().getStringExtra("access"));
                i.putExtra("data",data);
                i.putExtra("name",lessons[3].getText());
                startActivity(i);
            }
        });
        lessons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OpenDay.this,Lesson.class);
                i.putExtra("access",getIntent().getStringExtra("access"));
                i.putExtra("data",data);
                i.putExtra("name",lessons[4].getText());
                startActivity(i);
            }
        });
        lessons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OpenDay.this,Lesson.class);
                i.putExtra("access",getIntent().getStringExtra("access"));
                i.putExtra("data",data);
                i.putExtra("name",lessons[5].getText());
                startActivity(i);
            }
        });
        lessons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OpenDay.this,Lesson.class);
                i.putExtra("access",getIntent().getStringExtra("access"));
                i.putExtra("data",data);
                i.putExtra("name",lessons[6].getText());
                startActivity(i);
            }
        });
        lessons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OpenDay.this,Lesson.class);
                i.putExtra("access",getIntent().getStringExtra("access"));
                i.putExtra("data",data);
                i.putExtra("name",lessons[7].getText());
                startActivity(i);
            }
        });
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OpenDay.this,Lesson.class);
                i.putExtra("access",getIntent().getStringExtra("access"));
                i.putExtra("data",data);
                i.putExtra("name",more.getText());
                startActivity(i);
            }
        });

    }
}
