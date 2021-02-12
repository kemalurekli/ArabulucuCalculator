package com.example.arabulucuhesapmatik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class ProportionalPriceSecondPart extends AppCompatActivity {

    private AdView mAdView;
    private EditText inputTime;
    private TextView definition, totalPrice;
    private Spinner spinner1, spinner2, spinner3, spinner4;
    private Button button;
    private ArrayList<String> arrayList_mediator, arrayList_casetype, arrayList_option1, arrayList_option2, arrayList_people;
    private ArrayAdapter<String> arrayAdapter_mediator, arrayAdapter_parties, arrayAdapter_selector2, arrayAdapter_selector3;
    private int selection1, selection2, selection3, selection4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proportional_price_second_part);

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

        inputTime = findViewById(R.id.inputTime);
        button = findViewById(R.id.calculateButton);
        definition = findViewById(R.id.definition);
        totalPrice = findViewById(R.id.totalPrice);
        spinner1 = (Spinner) findViewById(R.id.secondInput);
        spinner2 = (Spinner) findViewById(R.id.thirdInput);
        spinner3 = (Spinner) findViewById(R.id.fourthInput);
        spinner4 = (Spinner) findViewById(R.id.fifthInput);
        //================================================SPİNNER 1 ================================================//
        arrayList_mediator = new ArrayList<>();
        arrayList_mediator.add(getString(R.string.one_referee_name));
        arrayList_mediator.add(getString(R.string.more_referee_name));
        arrayAdapter_mediator = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_mediator);
        spinner1.setAdapter(arrayAdapter_mediator);

        //================================================SPİNNER 2 ================================================//
        arrayList_casetype = new ArrayList<>();
        arrayList_casetype.add("Dava Şartı Kapsamındaki Uyuşmazlıklar");
        arrayList_casetype.add("İhtiyari Uyuşmazlık");
        arrayAdapter_selector2 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_casetype);
        spinner2.setAdapter(arrayAdapter_selector2);
        //================================================SPİNNER 2 FİNİSH ================================================//

        //========================================Spinner 1 GETTİNG VALUE ====================================//
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selection1 = position;
                System.out.println(selection1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //======================================== For Spinner 3's VALUES ====================================//
        arrayList_option1 = new ArrayList<>();
        arrayList_option1.add("İş Hukuku Uyuşmazlıkları");
        arrayList_option1.add("Ticari Uyuşmazlık");

        arrayList_option2 = new ArrayList<>();
        arrayList_option2.add("Aile Hukuku Uyuşmazlıkları");
        arrayList_option2.add("Ticari Uyuşmazlık");
        arrayList_option2.add("İş Hukuku Uyuşmazlıkları");
        arrayList_option2.add("Tüketici Uyuşmazlıkları");
        arrayList_option2.add("Diğer Tür Uyuşmazlıklar");
        //========================================Spinner 2 GETTİNG VALUE AND ADJUSTMENT SPİNNER 3 ====================================//
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    arrayAdapter_parties = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_option1);
                }
                if (position == 1) {
                    arrayAdapter_parties = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_option2);
                }
                selection2 = position;

                System.out.println(selection2);
                spinner3.setAdapter(arrayAdapter_parties);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //========================================Spinner 3 GETTİNG VALUE ====================================//

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selection3 = position;
                System.out.println(selection3);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //================================================SPİNNER 4 ================================================//
        arrayList_people = new ArrayList<>();
        arrayList_people.add(getString(R.string.two_part_name));
        arrayList_people.add(getString(R.string.threeandfive_part_name));
        arrayList_people.add(getString(R.string.sixandten_part_name));
        arrayList_people.add(getString(R.string.more_eleven_part_name));
        arrayAdapter_selector3 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_people);
        spinner4.setAdapter(arrayAdapter_selector3);
        //================================================SPİNNER 4 FİNİSH ================================================//

        //========================================Spinner 4 GETTİNG VALUE ====================================//
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selection4=position;
                System.out.println(selection4);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //=======================================================================================================================//
    }
    public void timeToPriceCalc(View view){
        if (inputTime.getText().toString().matches("") || Double.parseDouble(inputTime.getText().toString())>100000000){
            Toast.makeText(this,"Geçersiz Ücret!", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(ProportionalPriceSecondPart.this,SecondPartDetails.class);
            double userValue = Double.parseDouble(inputTime.getText().toString());
            intent.putExtra("userInput",userValue);
            intent.putExtra("select1",selection1);
            intent.putExtra("select2",selection2);
            intent.putExtra("select3",selection3);
            intent.putExtra("select4",selection4);
            startActivity(intent);
        }

    }
}