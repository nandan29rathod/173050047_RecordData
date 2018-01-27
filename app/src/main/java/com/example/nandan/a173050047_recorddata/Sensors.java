package com.example.nandan.a173050047_recorddata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Sensors extends AppCompatActivity {


    Toolbar myToolBar;
    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);
        myToolBar=(Toolbar)findViewById(R.id.toolbar);
        mySpinner=(Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Sensors.this,
                R.layout.custom_spinner_item,
                getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setSelection(1);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
//                Toast.makeText(Sensors.this,
//                        mySpinner.getSelectedItem().toString(),
//                        Toast.LENGTH_SHORT)
//                        .show();
                final Intent intent;
                switch(position){
                    case 0:
                         intent = new Intent(Sensors.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                         intent = new Intent(Sensors.this, Record.class);
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

        Button recordbt=(Button)findViewById(R.id.recordbt);

        recordbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // do something
                Intent intent = new Intent(Sensors.this, Record.class);
                startActivity(intent);

            }
        });

    }
}
