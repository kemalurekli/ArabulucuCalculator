package com.example.arabulucuhesapmatik;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
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
                    public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                        Calendar calendarNew = Calendar.getInstance();
                        calendarNew.set(selectedYear,selectedMonth,selectedDay);
                        calendarNew.add(calendarNew.DATE,21);
                        int threeWeekD = (calendarNew.get(Calendar.DAY_OF_MONTH));
                        int threeWeekM = calendarNew.get(Calendar.MONTH);
                        threeWeekM=threeWeekM+1;
                        int threeWeekY = calendarNew.get(Calendar.YEAR);

                        //TextView's Text
                        selectedMonth=selectedMonth+1;
                        String date = selectedDay + "/"+ selectedMonth + "/"+ selectedYear;
                        tvDate.setText(date);
                        //TextView's Text


                        date_text.setText("Date is : " + threeWeekD +"/"+threeWeekM+"/"+threeWeekY);
                    }
                },year,month,day);
                datePickerDialog.show();
            }

        });

    }
}