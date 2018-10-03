package com.nvwa.lab2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setButtonsClickListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void myClickHandler(View view) {
        TextView qq = findViewById(R.id.text);
        switch (view.getId() ) {
            case R.id.redBtn:
                qq.setTextColor(Color.RED);
                break;
            case R.id.greenBtn:
                qq.setTextColor(Color.GREEN);
                break;
            case R.id.blueBtn:
                qq.setTextColor(Color.BLUE);
                break;
            default:
        }
    }

    public void setButtonsClickListener() {
        Button redBtn = findViewById( R.id.redBtn );
        Button greenBtn = findViewById( R.id.greenBtn );
        Button blueBtn = findViewById( R.id.blueBtn );

        View.OnClickListener myClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClickHandler(view);
            }
        };
        redBtn.setOnClickListener(myClickListener);
        greenBtn.setOnClickListener(myClickListener);
        blueBtn.setOnClickListener(myClickListener);
    }
}
