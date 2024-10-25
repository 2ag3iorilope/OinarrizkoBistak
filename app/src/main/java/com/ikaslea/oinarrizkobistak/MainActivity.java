package com.ikaslea.oinarrizkobistak;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button b;
    CheckBox cb;
    RadioButton rb0;
    RadioButton rb1;
    RadioGroup tRadioG;
    EditText et;
    Spinner s;
    SeekBar sb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bistak);


        tv = findViewById(R.id.editTextText);
        b = findViewById(R.id.button);
        cb = findViewById(R.id.checkBox);
        rb0 = findViewById(R.id.radioButton4);
        rb1 = findViewById(R.id.radioButton5);
        tRadioG = findViewById(R.id.radioGroup2);
        et = findViewById(R.id.editTextText);
        s = findViewById(R.id.spinner);
        sb = findViewById(R.id.seekBar);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        sb.setMax(10);

        tv.setText("Testua kodetik editatzen dugu");

        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.e("Info", "Boton click");
            }
        });


        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
                Integer i = seekBar.getProgress();
                Log.e("Info", i.toString());
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
            }
        });

        et.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // Testua kapturatzen da enter sakatzean
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    EditText et = (EditText) v;
                    Log.e("Info", et.getText().toString());
                }
                return false;
            }
        });
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Log.e("Info", "Se ha seleccionado " + (arg3 + 1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        rb0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.e("Info", "RadioButton0 aukeratuta");
            }
        });

        rb1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.e("Info", "RadioButton1 aukeratuta");
            }
        });

        tRadioG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton4)
                    Log.e("Info", "radioButton4 aukeratuta");
                else if (checkedId == R.id.radioButton5)
                    Log.e("Info", "radioButton5 aukeratuta");

            }
        });

        cb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                if (cb.isChecked()) {
                    // checkbox-a hautatuta badago
                    Log.e("Info", "CheckBox hautatuta");
                } else {
                    // checkbox-a hautatuta ez badago
                    Log.e("Info", "CheckBox ez hautatuta");
                }
            }
        });
    }
}
