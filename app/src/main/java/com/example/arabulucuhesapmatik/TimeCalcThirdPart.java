package com.example.arabulucuhesapmatik;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class TimeCalcThirdPart extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener setListener;
    private TextView tvDate, date_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_calc_third_part);
        tvDate = findViewById(R.id.tvDate);
        date_text = findViewById(R.id.date_text);
        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(TimeCalcThirdPart.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month=month+1;
                        String date = day + "/"+ month + "/"+ year;
                        tvDate.setText(date);
                        //Calendar newDate = calendar.set(0,0,0,7,0,0);
                        date_text.setText("Date is : " + date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

    }
}