package com.example.arabulucuhesapmatik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ca-app-pub-4590136360115636~2833125868


    }

    public void goTimeToPrice(View view) {
        Intent intent = new Intent(MainActivity.this, TimeToPriceFirstPart.class);
        startActivity(intent);
    }

    public void goProportionalPrice(View view) {
        Intent intent = new Intent(MainActivity.this, ProportionalPriceSecondPart.class);
        startActivity(intent);
    }
}