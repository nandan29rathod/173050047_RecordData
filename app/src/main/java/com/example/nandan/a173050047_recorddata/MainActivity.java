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

public class MainActivity extends AppCompatActivity {

    Toolbar myToolBar;
    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myToolBar=(Toolbar)findViewById(R.id.toolbar);
        mySpinner=(Spinner)findViewById(R.id.spinner);
//        myToolBar.setTitle(getResources().getString(R.string.app_name));


                /*   -------------------------------------*/








        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                R.layout.custom_spinner_item,
                getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
//                Toast.makeText(MainActivity.this,
//                        mySpinner.getSelectedItem().toString(),
//                        Toast.LENGTH_SHORT)
//                        .show();
                final Intent intent;
                switch(position){
                    case 1:
                        intent = new Intent(MainActivity.this, Sensors.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, Record.class);
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


        //

        Button recordbt=(Button)findViewById(R.id.recordbt);

        recordbt.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v){
                                            // do something
                                            Intent intent = new Intent(MainActivity.this, Record.class);
                                            startActivity(intent);

                                        }
                                    });
//        /*   -------------------------------------*/
    }
}
