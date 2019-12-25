package com.example.journal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Journal extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.journal);

        final int n = 16;
        final int m = 6;
        final int [][]array = new int[n][m];

        for(int i = 0; i < n;i++){
            for(int j = 0; j < m;j++){
                array[i][j]=0;
            }
        }

        TableLayout tableLayout = (TableLayout) findViewById(R.id.table);


        for(int i = 1; i <= n;i++){

            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT));
            TextView tv = new TextView(this);
            tv.setTextColor(getResources().getColor(R.color.colorWhite));

            switch (i){
                case 1:
                    tv.setText(getResources().getString(R.string.russian));
                    break;
                case 2:
                    tv.setText(getResources().getString(R.string.literature));
                    break;
                case 3:
                    tv.setText(getResources().getString(R.string.math));
                    break;
                case 4:
                    tv.setText(getResources().getString(R.string.physic));
                    break;
                case 5:
                    tv.setText(getResources().getString(R.string.english));
                    break;
                case 6:
                    tv.setText(getResources().getString(R.string.fizra));
                    break;
                case 7:
                    tv.setText(getResources().getString(R.string.chemistry));
                    break;
                case 8:
                    tv.setText(getResources().getString(R.string.history));
                    break;
                case 9:
                    tv.setText(getResources().getString(R.string.informatika));
                    break;
                case 10:
                    tv.setText(getResources().getString(R.string.biology));
                    break;
                case 11:
                    tv.setText(getResources().getString(R.string.society));
                    break;
                case 12:
                    tv.setText(getResources().getString(R.string.obj));
                    break;
                case 13:
                    tv.setText(getResources().getString(R.string.astronomy));
                    break;
                case 14:
                    tv.setText(getResources().getString(R.string.geography));
                    break;
                case 15:
                    tv.setText(getResources().getString(R.string.chercenie));
                    break;
                case 16:
                    tv.setText(getResources().getString(R.string.programmirovanit));
                    break;
            }
            row.addView(tv,0);
            for(int j = 1; j <=m;j++){
                final Button bt =new Button(this);
                bt.setWidth(50);
                final int finalI = i;
                final int finalJ = j;
                bt.setText("" + array[finalI-1][finalJ-1]);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int count = Integer.parseInt(bt.getText().toString());
                        if(count==5)
                            count = 0;
                        else
                            count++;
                        bt.setText("" + count);
                        array[finalI-1][finalJ-1] = count;
                    }
                });
                row.addView(bt,j);
            }
            tableLayout.addView(row,1);
        }
    }
}
