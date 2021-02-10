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
    private TextView tvDate, is_uc, is_dort,tuketici_uc,tuketici_dort,ticari_alti, ticari_sekiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_calc_third_part);
        tvDate = findViewById(R.id.tvDate);
        is_uc = findViewById(R.id.is_uc);
        is_dort = findViewById(R.id.is_dort);
        tuketici_uc = findViewById(R.id.tuketici_uc);
        tuketici_dort = findViewById(R.id.tuketici_dort);
        ticari_alti = findViewById(R.id.ticari_alti);
        ticari_sekiz = findViewById(R.id.ticari_sekiz);
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

                        //For 3 weeks
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.set(selectedYear,selectedMonth,selectedDay);
                        calendar2.add(calendar2.DATE,21);
                        int threeWeekD = (calendar2.get(Calendar.DAY_OF_MONTH));
                        int threeWeekM = calendar2.get(Calendar.MONTH);
                        threeWeekM=threeWeekM+1;
                        int threeWeekY = calendar2.get(Calendar.YEAR);

                        //For 4 weeks
                        Calendar calendar3 = Calendar.getInstance();
                        calendar3.set(selectedYear,selectedMonth,selectedDay);
                        calendar3.add(calendar3.DATE,28);
                        int fourWeekD = (calendar3.get(Calendar.DAY_OF_MONTH));
                        int fourWeekM = calendar3.get(Calendar.MONTH);
                        fourWeekM=fourWeekM+1;
                        int fourWeekY = calendar3.get(Calendar.YEAR);

                        //For 6 weeks
                        Calendar calendar4 = Calendar.getInstance();
                        calendar4.set(selectedYear,selectedMonth,selectedDay);
                        calendar4.add(calendar4.DATE,42);
                        int sixWeekD = (calendar4.get(Calendar.DAY_OF_MONTH));
                        int sixWeekM = calendar4.get(Calendar.MONTH);
                        sixWeekM=sixWeekM+1;
                        int sixWeekY = calendar4.get(Calendar.YEAR);

                        //For 8 weeks
                        Calendar calendar5 = Calendar.getInstance();
                        calendar5.set(selectedYear,selectedMonth,selectedDay);
                        calendar5.add(calendar5.DATE,56);
                        int eightWeekD = (calendar5.get(Calendar.DAY_OF_MONTH));
                        int eightWeekM = calendar5.get(Calendar.MONTH);
                        eightWeekM=eightWeekM+1;
                        int eightWeekY = calendar5.get(Calendar.YEAR);

                        //TextView's Text
                        selectedMonth=selectedMonth+1;
                        String date = selectedDay + "/"+ selectedMonth + "/"+ selectedYear;
                        tvDate.setText(date);
                        //TextView's Text

                        is_uc.setText(threeWeekD + "/" + threeWeekM + "/" + threeWeekY);
                        is_dort.setText(fourWeekD + "/" + fourWeekM + "/" + fourWeekY);
                        tuketici_uc.setText(threeWeekD + "/" + threeWeekM + "/" + threeWeekY);
                        tuketici_dort.setText(fourWeekD + "/" + fourWeekM + "/" + fourWeekY);
                        ticari_alti.setText(sixWeekD + "/" + sixWeekM + "/" + sixWeekY);
                        ticari_sekiz.setText(eightWeekD + "/" + eightWeekM + "/" + eightWeekY);
                    }
                },year,month,day);
                datePickerDialog.show();
            }

        });

    }
}