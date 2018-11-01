package com.example.taruc.lab2_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewMessage;
    private float size; //to store font size

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewMessage = findViewById(R.id.textViewMessage);
        size = textViewMessage.getTextSize();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

        /**@see **/
        if(id == R.id.action_settings)
            return true;
        else if (id == R.id.action_zoom_in) {
            //TODO : increase font size by 1 unit
            float sp = textViewMessage.getTextSize() / getResources().getDisplayMetrics().scaledDensity;
            textViewMessage.setTextSize(sp + 1);
        } else if (id == R.id.action_zoom_out) {
            // TODO: decrease font size by 1 unit
            float sp = textViewMessage.getTextSize() / getResources().getDisplayMetrics().scaledDensity;
            textViewMessage.setTextSize(sp - 1);
        } else if(id == R.id.action_about_us) {
            // TODO: Create the AboutUs activity and use Intent
            Intent toAboutUs= new Intent(this, AboutUs.class);
            startActivity(toAboutUs);
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
