package com.example.krishnakumar.customviewpaint;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int imputSelection =0;
    private MyView myView;
    static String[] colorsArray = new String[]{
            "Red",
            "Blue",
            "Black",
            "Green" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    private void init(){
        myView = (MyView)findViewById(R.id.myView);
        myView.setPaintColor(Color.BLUE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuicon:
                changeColor();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    private void changeColor(){

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Pick a color");
        builder.setSingleChoiceItems(colorsArray, -1,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        dialog.cancel();
                        switch (item){
                            case 0:
                                myView.setPaintColor(Color.RED);
                                break;
                            case 1:
                                myView.setPaintColor(Color.BLUE);
                                break;
                            case 2:
                                myView.setPaintColor(Color.BLACK);
                                break;
                            case 3:
                                myView.setPaintColor(Color.GREEN);
                                break;
                        }
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
