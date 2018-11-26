package com.example.xin.lab;

import android.content.DialogInterface;
import android.drm.DrmStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TestToolbar extends AppCompatActivity {
    String currentMessage = "You selected item 1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);

        Toolbar lab8_toolbar = (Toolbar)findViewById(R.id.lab8_toolbar);
        setSupportActionBar(lab8_toolbar) ;

        Button button = findViewById(R.id.toolbar_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Test Toolbar", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });


    }

    public boolean onCreateOptionsMenu (Menu m){
        getMenuInflater().inflate(R.menu.toolbar_menu, m );
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem mi){
        int id = mi.getItemId();

        switch (id){
            case R.id.action_one:
                Log.d("ToolBar", "Option 1 selected");
                Snackbar.make(findViewById(R.id.action_one),currentMessage,Snackbar.LENGTH_LONG).setAction("Action",null).show();
                break;
            case R.id.action_two:
                Log.d("Toolbar", "Option 2 selected");
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.dailog_title)
                        .setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //user clicked OK button
                                finish();
                            }
                        });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //user cancelled the dialog
                    }
                });
                //Create the AlertDailog
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
            case R.id.action_three:
                Log.d("Toolbar", "Option 3 selected");
                AlertDialog.Builder builderItemThree = new AlertDialog.Builder(this);
                //Get the inflator
                LayoutInflater layout = this.getLayoutInflater();
                View v = layout.inflate(R.layout.item_three,null);

                builderItemThree.setView(v)
                        .setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText text = v.findViewById(R.id.lab8_editText);
                                currentMessage = text.getText().toString();
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                    //user clicked the cancel button
                            }
                        });
                AlertDialog alert = builderItemThree.create();
                alert.show();



                break;
            case R.id.action_about:
                Log.d("Toolbar", "About selected");
                Toast.makeText(this,R.string.about,Toast.LENGTH_SHORT ).show();
                break;
        }


        return super.onOptionsItemSelected(mi);

    }
}
