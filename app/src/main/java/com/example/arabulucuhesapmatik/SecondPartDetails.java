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
        LinearLayout layout45 = findViewById(R.id.layout45000);
        LinearLayout layout80 = findViewById(R.id.layout80000);
        LinearLayout layout240 = findViewById(R.id.layout240000);
        LinearLayout layout600 = findViewById(R.id.layout600000);
        LinearLayout layout750 = findViewById(R.id.layout750000);
        LinearLayout layout1250 = findViewById(R.id.layout1250000);
        LinearLayout layout3000 = findViewById(R.id.layout3000000);
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
        TextView totalprice = findViewById(R.id.totalprice);
        // Table layout


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


        if (userinput < 35000) {
            System.out.println("küçük 35");
            layout45.setVisibility(View.INVISIBLE);
            layout80.setVisibility(View.INVISIBLE);
            layout240.setVisibility(View.INVISIBLE);
            layout600.setVisibility(View.INVISIBLE);
            layout750.setVisibility(View.INVISIBLE);
            layout1250.setVisibility(View.INVISIBLE);
            layout3000.setVisibility(View.INVISIBLE);
            switch (select1) {
                case 0:
                    ratio = 0.06;
                    result = userinput * ratio;
                    tvp35.setText(String.valueOf(result));
                    totalprice.setText("Toplam Tutar :  ₺" + (result));
                    break;
                case 1:
                    ratio = 0.09;
                    result = userinput * ratio;
                    tvp35.setText(String.valueOf(result));
                    totalprice.setText("Toplam Tutar :  ₺" + (result));
                    break;
            }
        } else if (userinput < 80000) {
            System.out.println("küçük 45");
            layout80.setVisibility(View.INVISIBLE);
            layout240.setVisibility(View.INVISIBLE);
            layout600.setVisibility(View.INVISIBLE);
            layout750.setVisibility(View.INVISIBLE);
            layout1250.setVisibility(View.INVISIBLE);
            layout3000.setVisibility(View.INVISIBLE);
            switch (select1) {
                case 0:
                    tvp35.setText("₺2.100,0");
                    ratio = 0.05;
                    result = ((userinput - 35000) * ratio);
                    tvp45.setText("₺" + (result));
                    totalprice.setText("Toplam Tutar :  ₺" + ((result + 2100)));
                    break;
                case 1:
                    tvp35.setText("₺3.150,0");
                    ratio = 0.075;
                    result = ((userinput - 35000) * ratio);
                    tvp45.setText("₺" + (result));
                    totalprice.setText("Toplam Tutar :  ₺" + ((result + 3150)));
                    break;
            }
        } else if (userinput < 160000) {
            System.out.println("küçük 80");
            layout240.setVisibility(View.INVISIBLE);
            layout600.setVisibility(View.INVISIBLE);
            layout750.setVisibility(View.INVISIBLE);
            layout1250.setVisibility(View.INVISIBLE);
            layout3000.setVisibility(View.INVISIBLE);
            switch (select1) {
                case 0:
                    tvp35.setText("₺2.100,0");
                    tvp45.setText("₺2.250,0");
                    ratio = 0.04;
                    result = ((userinput - 80000) * ratio);
                    tvp80.setText("₺" + (result));
                    totalprice.setText("Toplam Tutar :  ₺" + ((result + 4350)));
                    break;
                case 1:
                    tvp35.setText("₺3.150,0");
                    tvp45.setText("₺3.375,0");
                    ratio = 0.06;
                    result = ((userinput - 80000) * ratio);
                    tvp80.setText("₺" + (result));
                    totalprice.setText("Toplam Tutar :  ₺" + ((result + 6525)));
                    break;
            }
        } else if (userinput <= 400000) {
            System.out.println("küçük 240");
            layout600.setVisibility(View.INVISIBLE);
            layout750.setVisibility(View.INVISIBLE);
            layout1250.setVisibility(View.INVISIBLE);
            layout3000.setVisibility(View.INVISIBLE);
            switch (select1) {
                case 0:
                    tvp35.setText("₺2.100,0");
                    tvp45.setText("₺2.250,0");
                    tvp80.setText("₺3.200,0");
                    ratio = 0.03;
                    result = ((userinput - 160000) * ratio);
                    tvp240.setText("₺" + (result));
                    totalprice.setText("Toplam Tutar :  ₺" + ((result + 7550)));
                    break;
                case 1:
                    tvp35.setText("₺3.150,0");
                    tvp45.setText("₺3.375,0");
                    tvp80.setText("₺4.800,0");
                    ratio = 0.045;
                    result = ((userinput - 160000) * ratio);
                    tvp240.setText("₺" + (result));
                    totalprice.setText("Toplam Tutar :  ₺" + ((result + 11325)));
                    break;
            }
        } else if (userinput <= 1000000) {
            System.out.println("küçük 600");
            layout750.setVisibility(View.INVISIBLE);
            layout1250.setVisibility(View.INVISIBLE);
            layout3000.setVisibility(View.INVISIBLE);
            switch (select1) {
                case 0:
                    tvp35.setText("₺2.100,0");
                    tvp45.setText("₺2.250,0");
                    tvp80.setText("₺3.200,0");
                    tvp240.setText("₺7.200,0");
                    ratio = 0.02;
                    result = ((userinput - 400000) * ratio);
                    tvp600.setText("₺" + (result));
                    totalprice.setText("Toplam Tutar :  ₺" + ((result + 14750)));
                    break;
                case 1:
                    tvp35.setText("₺3.150,0");
                    tvp45.setText("₺3.375,0");
                    tvp80.setText("₺4.800,0");
                    tvp240.setText("₺10.800,0");
                    ratio = 0.03;
                    result = ((userinput - 400000) * ratio);
                    tvp600.setText("₺" + (result));
                    totalprice.setText("Toplam Tutar :  ₺" + ((result + 22125)));
                    break;
            }
        } else if (userinput <= 1750000) {
            System.out.println("küçük 750");
            layout1250.setVisibility(View.INVISIBLE);
            layout3000.setVisibility(View.INVISIBLE);
            switch (select1) {
                case 0:
                    tvp35.setText("₺2.100,0");
                    tvp45.setText("₺2.250,0");
                    tvp80.setText("₺3.200,0");
                    tvp240.setText("₺7.200,0");
                    tvp600.setText("₺12.000,0");
                    ratio = 0.015;
                    result = ((userinput - 1000000) * ratio);
                    tvp750.setText("₺" + (result));
                    totalprice.setText("Toplam Tutar :  ₺" + ((result + 26750)));
                    break;
                case 1:
                    tvp35.setText("₺3.150,0");
                    tvp45.setText("₺3.375,0");
                    tvp80.setText("₺4.800,0");
                    tvp240.setText("₺10.800,0");
                    tvp600.setText("₺18.000,0");
                    ratio = 0.025;
                    result = ((userinput - 1000000) * ratio);
                    tvp750.setText("₺" + (result));
                    totalprice.setText("Toplam Tutar :  ₺" + ((result + 40125)));
                    break;
            }
        } else if (userinput <= 3000000) {
            System.out.println("küçük 1250");
            layout3000.setVisibility(View.INVISIBLE);
            switch (select1) {
                case 0:
                    tvp35.setText("₺2.100,0");
                    tvp45.setText("₺2.250,0");
                    tvp80.setText("₺3.200,0");
                    tvp240.setText("₺7.200,0");
                    tvp600.setText("₺12.000,0");
                    tvp750.setText("₺11.250,0");
                    ratio = 0.01;
                    result = ((userinput - 1750000) * ratio);
                    tvp1250.setText("₺" + (result));
                    totalprice.setText("Toplam Tutar :  ₺" + ((result + 38000)));
                    break;
                case 1:
                    tvp35.setText("₺3.150,0");
                    tvp45.setText("₺3.375,0");
                    tvp80.setText("₺4.800,0");
                    tvp240.setText("₺10.800,0");
                    tvp600.setText("₺18.000,0");
                    tvp750.setText("₺18.750,0");
                    ratio = 0.015;
                    result = ((userinput - 1750000) * ratio);
                    tvp1250.setText("₺" + (result));
                    totalprice.setText("Toplam Tutar :  ₺" + ((result + 58875)));
                    break;
            }
        } else if (userinput > 3000000) {
            System.out.println("büyük 3000");
            switch (select1) {
                case 0:
                    tvp35.setText("₺2.100,0");
                    tvp45.setText("₺2.250,0");
                    tvp80.setText("₺3.200,0");
                    tvp240.setText("₺7.200,0");
                    tvp600.setText("₺12.000,0");
                    tvp750.setText("₺11.250,0");
                    tvp1250.setText("₺12.500,0");
                    ratio = 0.005;
                    result = ((userinput - 3000000) * ratio);
                    tvp3000.setText("₺" + (result));
                    totalprice.setText("Toplam Tutar :  ₺" + ((result + 50500)));
                    break;
                case 1:
                    tvp35.setText("₺3.150,0");
                    tvp45.setText("₺3.375,0");
                    tvp80.setText("₺4.800,0");
                    tvp240.setText("₺10.800,0");
                    tvp600.setText("₺18.000,0");
                    tvp750.setText("₺18.750,0");
                    tvp1250.setText("₺18.750,0");
                    ratio = 0.01;
                    result = ((userinput - 3000000) * ratio);
                    //tvp1250.setText("₺"+(String.valueOf(result)));
                    tvp1250.setText(result.toString());
                    totalprice.setText("Toplam Tutar :  ₺" + ((result + 77625)));
                    break;
            }
        }
    }
}