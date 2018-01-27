package com.example.nandan.a173050047_recorddata;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collections;

public class Record extends AppCompatActivity {

    Toolbar myToolBar;
    Spinner mySpinner;

    Switch sButton;
    private TextView records;
    ArrayList<String> timestamps=new ArrayList<String>(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        myToolBar=(Toolbar)findViewById(R.id.toolbar);
        mySpinner=(Spinner)findViewById(R.id.spinner);
//        myToolBar.setTitle(getResources().getString(R.string.app_name));

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Record.this,
                R.layout.custom_spinner_item,
                getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setSelection(2);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
//                Toast.makeText(Record.this,
//                        mySpinner.getSelectedItem().toString(),
//                        Toast.LENGTH_SHORT)
//                        .show();

                final Intent intent;
                switch(position){
                    case 0:
                        intent = new Intent(Record.this, MainActivity.class);
                      startActivity(intent);
                        break;
                    case 1:
                      intent = new Intent(Record.this, Sensors.class);
                        startActivity(intent);
                        break;
// and so on
// .....

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        sButton = (Switch) findViewById(R.id.switchState);
        records = (TextView) findViewById(R.id.records);

        sButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean on) {
                if (!on) {
                    //Do something when Switch button is on/checked
                    Long tsLong = System.currentTimeMillis()/1000;
                    String ts =  tsLong.toString();
                    timestamps.add(ts);
                    Collections.sort(timestamps);
//                    if(timestamps.size()>5)
//                        timestamps.remove()
                    Collections.reverse(timestamps);
                }
                String recordings="Recordings:\n\n";
                int i=1;
                for(String str:timestamps) {
                    if(i<6&&str.length()>0){
                        recordings+=i+". "+str+"\n";
                        i++;
                    }
//                    else timestamps.remove(i);
                }
                records.setText(recordings);

//                else {
//                    //Do something when Switch is off/unchecked
//                    records.setText("Switch is off.....");
//                }
            }
        });

    }
}
