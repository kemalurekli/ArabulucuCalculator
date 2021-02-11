package com.example.arabulucuhesapmatik;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.arabulucuhesapmatik.Constants.Topic;
import com.example.arabulucuhesapmatik.enums.DisagreementType;
import com.example.arabulucuhesapmatik.enums.SubDisagreementType;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class TimeToPriceFirstPart extends AppCompatActivity {


    private AdView mAdView;
    private EditText inputTime;
    private TextView definition, totalPrice;
    private Spinner topics, parties;
    private Button button;

    private ArrayList<String> arrayList_parties;
    private ArrayAdapter<String> arrayAdapter_topics, arrayAdapter_parties;
    private int selection, subselection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_to_price_first_part);

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
        topics = findViewById(R.id.secondInput);
        parties = findViewById(R.id.thirdInput);

        arrayAdapter_topics = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Topic.Topics);
        topics.setAdapter(arrayAdapter_topics);

        //=========parties spinner starts ============

        arrayList_parties = new ArrayList<>();
        arrayList_parties.add(getString(R.string.two_part_name));
        arrayList_parties.add(getString(R.string.threeandfive_part_name));
        arrayList_parties.add(getString(R.string.sixandten_part_name));
        arrayList_parties.add(getString(R.string.more_eleven_part_name));

        arrayAdapter_parties = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_parties);
        parties.setAdapter(arrayAdapter_parties);

        topics.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selection = position;
                System.out.println(selection);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        parties.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                subselection = position;
                System.out.println(subselection);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void calculateAndSet(int hour, int multiply, int topicIndex, int partiesIndex) {
        int total = hour * multiply;
        definition.setText(Topic.Topics.get(topicIndex) + " " + arrayList_parties.get(partiesIndex) + ", taraf sayısı gözetilmeksizin " + hour + " saat için");
        totalPrice.setText("Toplam Ücret : " + total + " TL");
    }

    public void timeToPriceCalc(View view) {
        int hour = 0;
        if (inputTime.getText().toString().matches("") || Integer.parseInt(inputTime.getText().toString())>1000) {
            Toast.makeText(this, "Geçersiz Seçim.", Toast.LENGTH_SHORT).show();
        } else {
            hour = Integer.parseInt(inputTime.getText().toString());
            if (selection == DisagreementType.AILE_HUKUKU.getValue()) {
                if (subselection == SubDisagreementType.TWO.getValue()) {
                    calculateAndSet(hour, 340, 0, 0);
                } else if (subselection == SubDisagreementType.THREE_OR_FIVE.getValue()) {
                    calculateAndSet(hour, 360, 0, 1);
                } else if (subselection == SubDisagreementType.SIX_OR_TEN.getValue()) {
                    calculateAndSet(hour, 380, 0, 2);
                } else if (subselection == SubDisagreementType.ELEVEN.getValue()) {
                    calculateAndSet(hour, 400, 0, 3);
                }
            } else if (selection == DisagreementType.TICARI.getValue()) {
                if (subselection == 0) {
                    calculateAndSet(hour, 660, 1, 0);
                } else if (subselection == 1) {
                    calculateAndSet(hour, 680, 1, 1);
                } else if (subselection == 2) {
                    calculateAndSet(hour, 700, 1, 2);
                } else if (subselection == 3) {
                    calculateAndSet(hour, 720, 1, 3);
                }
            } else if (selection == DisagreementType.ISCI.getValue()) {
                if (subselection == 0) {
                    calculateAndSet(hour, 340, 2, 0);
                } else if (subselection == 1) {
                    calculateAndSet(hour, 360, 2, 1);
                } else if (subselection == 2) {
                    calculateAndSet(hour, 380, 2, 2);
                } else if (subselection == 3) {
                    calculateAndSet(hour, 400, 2, 3);
                }
            } else if (selection == DisagreementType.TUKETICI.getValue()) {
                if (subselection == 0) {
                    calculateAndSet(hour, 340, 3, 0);
                } else if (subselection == 1) {
                    calculateAndSet(hour, 360, 3, 1);
                } else if (subselection == 2) {
                    calculateAndSet(hour, 380, 3, 2);
                } else if (subselection == 3) {
                    calculateAndSet(hour, 400, 3, 3);
                }
            } else if (selection == DisagreementType.DIGER.getValue()) {
                if (subselection == 0) {
                    calculateAndSet(hour, 410, 4, 0);
                } else if (subselection == 1) {
                    calculateAndSet(hour, 430, 4, 1);
                } else if (subselection == 2) {
                    calculateAndSet(hour, 450, 4, 2);
                } else if (subselection == 3) {
                    calculateAndSet(hour, 470, 4, 3);
                }
            }
        }
    }
}