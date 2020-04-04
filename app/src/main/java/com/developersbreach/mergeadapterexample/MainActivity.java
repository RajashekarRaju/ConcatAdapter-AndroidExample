package com.developersbreach.mergeadapterexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.MergeAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.developersbreach.mergeadapterexample.AnimalAdapter.AnimalAdapterListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Animals> mAnimalsList;
    private List<Planets> mPlanetsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recycler_view);

        addAnimalsToList();
        addPlanetsToList();

        AnimalAdapter animalAdapter = new AnimalAdapter(getApplicationContext(), mAnimalsList, new AnimalItemClickListener());
        PlanetAdapter planetAdapter = new PlanetAdapter(getApplicationContext(), mPlanetsList, new PlanerItemClickListener());
        MergeAdapter mergeAdapter = new MergeAdapter(animalAdapter, planetAdapter);
        recyclerView.setAdapter(mergeAdapter);
    }

    private void addAnimalsToList() {
        mAnimalsList = new ArrayList<>();
        mAnimalsList.add(new Animals(1, "Lion"));
        mAnimalsList.add(new Animals(2, "Cat"));
    }

    private void addPlanetsToList() {
        mPlanetsList = new ArrayList<>();
        mPlanetsList.add(new Planets(1, "Mars"));
        mPlanetsList.add(new Planets(2, "Pluto"));
    }

    private class AnimalItemClickListener implements AnimalAdapterListener {
        @Override
        public void onAnimalSelected(Animals animals) {
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.INTENT_EXTRA_ANIMAL_DATA, animals);
            startActivity(intent);
        }
    }

    private class PlanerItemClickListener implements PlanetAdapter.PlanetAdapterListener {
        @Override
        public void onPlanetSelected(Planets planets) {
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.INTENT_EXTRA_PLANET_DATA, planets);
            startActivity(intent);
        }
    }
}
