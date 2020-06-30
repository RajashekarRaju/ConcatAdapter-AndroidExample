package com.developersbreach.concatadapterexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String INTENT_EXTRA_ANIMAL_DATA = "ANIMAL_DATA";
    public static final String INTENT_EXTRA_PLANET_DATA = "PLANET_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView detailTextView = findViewById(R.id.detail_text_view);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(INTENT_EXTRA_ANIMAL_DATA)) {
                final Animals animals = intent.getParcelableExtra(INTENT_EXTRA_ANIMAL_DATA);
                detailTextView.setText(animals.getAnimalName() + "\n" + "Id " + animals.getAnimalId());
            } else if ((intent.hasExtra(INTENT_EXTRA_PLANET_DATA))) {
                final Planets planets = intent.getParcelableExtra(INTENT_EXTRA_PLANET_DATA);
                detailTextView.setText(planets.getPlanetName() + "\n" + "Id " + planets.getPlanetId());
            }
        }
    }
}
