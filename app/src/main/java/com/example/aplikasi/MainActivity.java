package com.example.aplikasi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText et_nama, et_tanggal_lahir;
    Button btn_ramalkamu;
    Calendar calendar;
    String var_tanggal, var_nama;
    DatePickerDialog datepicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_tanggal_lahir = findViewById(R.id.et_tanggal_lahir);
        et_nama = findViewById(R.id.et_nama);
        btn_ramalkamu = findViewById(R.id.btn_ramalkamu);



        et_tanggal_lahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                datepicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        et_tanggal_lahir.setText(mDay + "/" +(mMonth+1) + "/" + mYear);
                    }
                },day,month,year);
                datepicker.show();


            }

        });

        btn_ramalkamu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et_tanggal_lahir.getText().toString().length() == 0) {
                    et_tanggal_lahir.setError("Tangal Tidak Boleh Kosong");
                } else {
                    var_tanggal = et_tanggal_lahir.getText().toString();
                    var_nama = et_nama.getText().toString();
                    Intent abc = new Intent(MainActivity.this, Hasil.class);
                    Bundle b = new Bundle();
                    b.putString("parse_tanggal", var_tanggal);
                    b.putString("parse_nama", var_nama);
                    abc.putExtras(b);
                    startActivity(abc);
                }

            }
        });
    }
}

