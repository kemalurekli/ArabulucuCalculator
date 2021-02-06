package com.example.arabulucuhesapmatik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondPartDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_part_details);
        TextView tvExplanation = findViewById(R.id.tvExplanation);
        TextView tvr35 = findViewById(R.id.tvr35);
        TextView tvr45 = findViewById(R.id.tvr45);
        TextView tvr80 = findViewById(R.id.tvr80);
        TextView tvr240 = findViewById(R.id.tvr240);
        TextView tvr600 = findViewById(R.id.tvr600);
        TextView tvr750 = findViewById(R.id.tvr750);
        TextView tvr1250 = findViewById(R.id.tvr1250);
        TextView tvr3000 = findViewById(R.id.tvr3000);
        TextView tvp35 = findViewById(R.id.tvp35);
        TextView tvp45 = findViewById(R.id.tvp45);
        TextView tvp80 = findViewById(R.id.tvp80);
        TextView tvp240 = findViewById(R.id.tvp240);
        TextView tvp600 = findViewById(R.id.tvp600);
        TextView tvp750 = findViewById(R.id.tvp750);
        TextView tvp1250 = findViewById(R.id.tvp1250);
        TextView tvp3000 = findViewById(R.id.tvp3000);
        TextView totalPrice = findViewById(R.id.totalprice);


        Intent intent = getIntent();
        double userinput = intent.getDoubleExtra("userInput", 0);
        int select1 = intent.getIntExtra("select1", 0);
        int select2 = intent.getIntExtra("select2", 0);
        int select3 = intent.getIntExtra("select3", 0);
        int select4 = intent.getIntExtra("select4", 0);
        Double ratio, result;

        switch (select1) {
            case 0:
                tvr35.setText("%6");
                tvr45.setText("%5");
                tvr80.setText("%4");
                tvr240.setText("%3");
                tvr600.setText("%2");
                tvr750.setText("%1.5");
                tvr1250.setText("%1");
                tvr3000.setText("%0.5");
                break;
            case 1:
                tvr35.setText("%9");
                tvr45.setText("%7.5");
                tvr80.setText("%6");
                tvr240.setText("%4.5");
                tvr600.setText("%3");
                tvr750.setText("%2.5");
                tvr1250.setText("%1.5");
                tvr3000.setText("%1");
                break;
        }
        if (userinput <= 50000) {
            switch (select1) {
                case 0:
                    ratio = 0.06;
                    result = userinput * ratio;
                    //---------------------------Min Price Check-----------------------------------
                    result = minPriceCheck(result,select2,select3,select4);
                    tvp35.setText(String.valueOf(result));
                    totalPrice.setText("Toplam Tutar :  ₺" + (result));
                    break;
                case 1:
                    ratio = 0.09;
                    result = userinput * ratio;
                    //---------------------------Min Price Check-----------------------------------
                    result = minPriceCheck(result,select2,select3,select4);
                    tvp35.setText(String.valueOf(result));
                    totalPrice.setText("Toplam Tutar :  ₺" + (result));
                    break;
            }
        } else if (userinput <= 130000) {
            switch (select1) {
                case 0:
                    tvp35.setText("₺3.000,00");
                    ratio = 0.05;
                    result = ((userinput - 50000) * ratio);
                    tvp45.setText("₺" + (result));
                    totalPrice.setText("Toplam Tutar :  ₺" + ((result + 3000)));
                    break;
                case 1:
                    tvp35.setText("₺4.500,00");
                    ratio = 0.075;
                    result = ((userinput - 50000) * ratio);
                    tvp45.setText("₺" + (result));
                    totalPrice.setText("Toplam Tutar :  ₺" + ((result + 4500)));
                    break;
            }
        } else if (userinput <= 260000) {
            switch (select1) {
                case 0:
                    tvp35.setText("₺3.000,00");
                    tvp45.setText("₺4.000,00");
                    ratio = 0.04;
                    result = ((userinput - 130000) * ratio);
                    tvp80.setText("₺" + (result));
                    totalPrice.setText("Toplam Tutar :  ₺" + ((result + 7000)));
                    break;
                case 1:
                    tvp35.setText("₺4.500,00");
                    tvp45.setText("₺6.000,00");
                    ratio = 0.06;
                    result = ((userinput - 130000) * ratio);
                    tvp80.setText("₺" + (result));
                    totalPrice.setText("Toplam Tutar :  ₺" + ((result + 10500)));
                    break;
            }
        } else if (userinput <= 520000) {
            switch (select1) {
                case 0:
                    tvp35.setText("₺3.000,00");
                    tvp45.setText("₺4.000,00");
                    tvp80.setText("₺5.200,00");
                    ratio = 0.03;
                    result = ((userinput - 260000) * ratio);
                    tvp240.setText("₺" + (result));
                    totalPrice.setText("Toplam Tutar :  ₺" + ((result + 12200)));
                    break;
                case 1:
                    tvp35.setText("₺4.500,00");
                    tvp45.setText("₺6.000,00");
                    tvp80.setText("₺7.800,00");
                    ratio = 0.045;
                    result = ((userinput - 260000) * ratio);
                    tvp240.setText("₺" + (result));
                    totalPrice.setText("Toplam Tutar :  ₺" + ((result + 18300)));
                    break;
            }
        } else if (userinput <= 1300000) {
            switch (select1) {
                case 0:
                    tvp35.setText("₺3.000,00");
                    tvp45.setText("₺4.000,00");
                    tvp80.setText("₺5.200,00");
                    tvp240.setText("₺7.800,00");
                    ratio = 0.02;
                    result = ((userinput - 520000) * ratio);
                    tvp600.setText("₺" + (result));
                    totalPrice.setText("Toplam Tutar :  ₺" + ((result + 20000)));
                    break;
                case 1:
                    tvp35.setText("₺4.500,00");
                    tvp45.setText("₺6.000,00");
                    tvp80.setText("₺7.800,00");
                    tvp240.setText("₺11.700,00");
                    ratio = 0.03;
                    result = ((userinput - 520000) * ratio);
                    tvp600.setText("₺" + (result));
                    totalPrice.setText("Toplam Tutar :  ₺" + ((result + 30000)));
                    break;
            }
        } else if (userinput <= 2340000) {
            switch (select1) {
                case 0:
                    tvp35.setText("₺3.000,00");
                    tvp45.setText("₺4.000,00");
                    tvp80.setText("₺5.200,00");
                    tvp240.setText("₺7.800,00");
                    tvp600.setText("₺15.600,00");
                    ratio = 0.015;
                    result = ((userinput - 1300000) * ratio);
                    tvp750.setText("₺" + (result));
                    totalPrice.setText("Toplam Tutar :  ₺" + ((result + 35600)));
                    break;
                case 1:
                    tvp35.setText("₺4.500,00");
                    tvp45.setText("₺6.000,00");
                    tvp80.setText("₺7.800,00");
                    tvp240.setText("₺11.700,00");
                    tvp600.setText("₺23.400,00");
                    ratio = 0.025;
                    result = ((userinput - 1300000) * ratio);
                    tvp750.setText("₺" + (result));
                    totalPrice.setText("Toplam Tutar :  ₺" + ((result + 53400)));
                    break;
            }
        } else if (userinput <= 4420000) {
            switch (select1) {
                case 0:
                    tvp35.setText("₺3.000,00");
                    tvp45.setText("₺4.000,00");
                    tvp80.setText("₺5.200,00");
                    tvp240.setText("₺7.800,00");
                    tvp600.setText("₺15.600,00");
                    tvp750.setText("₺15.600,00");
                    ratio = 0.01;
                    result = ((userinput - 2340000) * ratio);
                    tvp1250.setText("₺" + (result));
                    totalPrice.setText("Toplam Tutar :  ₺" + ((result + 51200)));
                    break;
                case 1:
                    tvp35.setText("₺4.500,00");
                    tvp45.setText("₺6.000,00");
                    tvp80.setText("₺7.800,00");
                    tvp240.setText("₺11.700,00");
                    tvp600.setText("₺23.400,00");
                    tvp750.setText("₺26.000,00");
                    ratio = 0.015;
                    result = ((userinput - 2340000) * ratio);
                    tvp1250.setText("₺" + (result));
                    totalPrice.setText("Toplam Tutar :  ₺" + ((result + 79400)));
                    break;
            }
        } else if (userinput > 4420000) {
            switch (select1) {
                case 0:
                    tvp35.setText("₺3.000,00");
                    tvp45.setText("₺4.000,00");
                    tvp80.setText("₺5.200,00");
                    tvp240.setText("₺7.800,00");
                    tvp600.setText("₺15.600,00");
                    tvp750.setText("₺15.600,00");
                    tvp1250.setText("₺20.800,00");
                    ratio = 0.005;
                    result = ((userinput - 4420000) * ratio);
                    tvp3000.setText("₺" + (result));
                    totalPrice.setText("Toplam Tutar :  ₺" + ((result + 72000)));
                    break;
                case 1:
                    tvp35.setText("₺4.500,00");
                    tvp45.setText("₺6.000,00");
                    tvp80.setText("₺7.800,00");
                    tvp240.setText("₺11.700,0");
                    tvp600.setText("₺23.400,00");
                    tvp750.setText("₺26.000,00");
                    tvp1250.setText("₺31.200,00");
                    ratio = 0.01;
                    result = ((userinput - 4420000) * ratio);
                    //tvp1250.setText("₺"+(String.valueOf(result)));
                    tvp3000.setText(result.toString());
                    totalPrice.setText("Toplam Tutar :  ₺" + ((result + 110600)));
                    break;
            }
        }
        tvExplanation.setText("₺ " + userinput + " Anlaşma Tutarlı arabuluculuk ücreti");
    }
    private double minPriceCheck(Double result, int select2, int select3, int select4) {
        if (result<680 && select2==0 && select3==0 && select4==0){
            result=680.0;
        }else if (result<720 && select2==0 && select3==0 && select4==1){
            result=720.0;
        }else if (result<760 && select2==0 && select3==0 && select4==2){
            result=760.0;
        }else if (result<780 && select2==0 && select3==0 && select4==3){
            result=800.0;
        }else if (result<1320 && select2==0 && select3==1 && select4==0){
            result=1320.0;
        }else if (result<1360 && select2==0 && select3==1 && select4==1){
            result=1360.0;
        }else if (result<1400 && select2==0 && select3==1 && select4==2){
            result=1400.0;
        }else if (result<1440 && select2==0 && select3==1 && select4==3){
            result=1440.0;
        }else if (result<340 && select2==1 && select3==0 && select4==0){
            result=340.0;
        }else if (result<360 && select2==1 && select3==0 && select4==1){
            result=360.0;
        }else if (result<380 && select2==1 && select3==0 && select4==2){
            result=380.0;
        }else if (result<400 && select2==1 && select3==0 && select4==3){
            result=400.0;
        }else if (result<660 && select2==1 && select3==1 && select4==0){
            result=660.0;
        }else if (result<680 && select2==1 && select3==1 && select4==1){
            result=680.0;
        }else if (result<700 && select2==1 && select3==1 && select4==2){
            result=700.0;
        }else if (result<700 && select2==1 && select3==1 && select4==3){
            result=700.0;
        }else if (result<340 && select2==1 && select3==2 && select4==0){
            result=340.0;
        }else if (result<360 && select2==1 && select3==2 && select4==1){
            result=360.0;
        }else if (result<380 && select2==1 && select3==2 && select4==2){
            result=380.0;
        }else if (result<400 && select2==1 && select3==2 && select4==3){
            result = 400.0;
        }else if (result<340 && select2==1 && select3==3 && select4==0){
            result=340.0;
        }else if (result<360 && select2==1 && select3==3 && select4==1){
            result=360.0;
        }else if (result<380 && select2==1 && select3==3 && select4==2){
            result=380.0;
        }else if (result<400 && select2==1 && select3==3 && select4==3) {
            result = 400.0;
        }else if (result<410 && select2==1 && select3==4 && select4==0){
            result=410.0;
        }else if (result<430 && select2==1 && select3==4 && select4==1){
            result=430.0;
        }else if (result<450 && select2==1 && select3==4 && select4==2){
            result=450.0;
        }else if (result<470 && select2==1 && select3==4 && select4==3) {
            result = 470.0;
        }
        return result;
    }
}