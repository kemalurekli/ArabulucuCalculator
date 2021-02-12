package com.example.arabulucuhesapmatik;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import java.util.Calendar;
public class TimeCalcThirdPart extends AppCompatActivity {
    private AdView mAdView;
    private DatePickerDialog.OnDateSetListener setListener;
    private TextView tvDate, workThreeWeek, workFourWeek,consumerThreeWeek,consumerFourWeek,commercialSixWeek, commercialEightWeek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_calc_third_part);
        //FOR ADS
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        // FOR ADS END
        tvDate = findViewById(R.id.tvDate);
        workThreeWeek = findViewById(R.id.workThreeWeek);
        workFourWeek = findViewById(R.id.workFourWeek);
        consumerThreeWeek = findViewById(R.id.consumerThreeWeek);
        consumerFourWeek = findViewById(R.id.consumerFourWeek);
        commercialSixWeek = findViewById(R.id.commercialSixWeek);
        commercialEightWeek = findViewById(R.id.commercialEightWeek);
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

                        workThreeWeek.setText(threeWeekD + "/" + threeWeekM + "/" + threeWeekY);
                        workFourWeek.setText(fourWeekD + "/" + fourWeekM + "/" + fourWeekY);
                        consumerThreeWeek.setText(threeWeekD + "/" + threeWeekM + "/" + threeWeekY);
                        consumerFourWeek.setText(fourWeekD + "/" + fourWeekM + "/" + fourWeekY);
                        commercialSixWeek.setText(sixWeekD + "/" + sixWeekM + "/" + sixWeekY);
                        commercialEightWeek.setText(eightWeekD + "/" + eightWeekM + "/" + eightWeekY);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

    }
}