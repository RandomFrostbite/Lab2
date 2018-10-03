package com.nvwa.lab2;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
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
        setSpinnerItemSelectedListener();
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

    public void myClickHandler( View view ) {
        TextView qq = findViewById( R.id.qq );
        switch ( view.getId() ) {
            case R.id.redBtn:
                qq.setTextColor( Color.RED );
                break;
            case R.id.greenBtn:
                qq.setTextColor( Color.GREEN );
                break;
            case R.id.blueBtn:
                qq.setTextColor( Color.BLUE );
                break;
            default:
        }
    }

    public void setButtonsClickListener() {
        Button redBtn   = findViewById( R.id.redBtn );
        Button greenBtn = findViewById( R.id.greenBtn );
        Button blueBtn  = findViewById( R.id.blueBtn );

        View.OnClickListener myClickListener = new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                myClickHandler(view);
            }
        };
        if ( redBtn != null )
            redBtn.setOnClickListener( myClickListener );
        if ( greenBtn != null )
            greenBtn.setOnClickListener( myClickListener );
        if ( blueBtn != null )
            blueBtn.setOnClickListener( myClickListener );
    }
    public void setSpinnerItemSelectedListener() {
        Spinner spinner = findViewById( R.id.spinner );
        if ( spinner != null ) {
            spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected( AdapterView<?> parent, View view, int position, long id ) {
                    ImageView logoView = findViewById( R.id.img );
                    if( logoView != null ) {
                        Drawable dr;
                        switch( position ) {
                            case 0:
                                dr = ResourcesCompat.getDrawable( getResources(),R.drawable.pp_logo,null );
                                break;
                            case 1:
                                dr = ResourcesCompat.getDrawable( getResources(),R.drawable.et_logo,null );
                                break;
                            case 2:
                                dr = ResourcesCompat.getDrawable( getResources(),R.drawable.kr_logo,null );
                                break;
                            default:
                                dr = ResourcesCompat.getDrawable( getResources(),R.drawable.et_logo,null );
                        }
                        logoView.setImageDrawable(dr);
                    }
                }

                @Override
                public void onNothingSelected( AdapterView<?> parent ) {

                }
            } );
        }
    }
}
