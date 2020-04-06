package com.developersbreach.mergeadapterexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.MergeAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.developersbreach.mergeadapterexample.AnimalAdapter.AnimalAdapterListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Animals> mAnimalsList;
    private List<Planets> mPlanetsList;

    private MergeAdapter mMergeAdapter;
    private AnimalAdapter mAnimalAdapter;
    private PlanetAdapter mPlanetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recycler_view);

        addAnimalsToList();
        addPlanetsToList();

        mAnimalAdapter = new AnimalAdapter(mAnimalsList, new AnimalItemClickListener());
        mPlanetAdapter = new PlanetAdapter(mPlanetsList, new PlanetItemClickListener());
        mMergeAdapter = new MergeAdapter(mAnimalAdapter, mPlanetAdapter);
        recyclerView.setAdapter(mMergeAdapter);
    }

    public void removeAnimalAdapter(View view) {
        mMergeAdapter.removeAdapter(mAnimalAdapter);
    }

    public void addAnimalAdapter(View view) {
        mMergeAdapter.addAdapter(mAnimalAdapter);
    }

    public void removePlanetAdapter(View view) {
        mMergeAdapter.removeAdapter(mPlanetAdapter);
    }

    public void addPlanetAdapter(View view) {
        mMergeAdapter.addAdapter(mPlanetAdapter);
    }

    private class AnimalItemClickListener implements AnimalAdapterListener {
        @Override
        public void onAnimalSelected(Animals animals) {
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.INTENT_EXTRA_ANIMAL_DATA, animals);
            startActivity(intent);
        }
    }

    private class PlanetItemClickListener implements PlanetAdapter.PlanetAdapterListener {
        @Override
        public void onPlanetSelected(Planets planets) {
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.INTENT_EXTRA_PLANET_DATA, planets);
            startActivity(intent);
        }
    }

    private void addAnimalsToList() {
        mAnimalsList = new ArrayList<>();
        mAnimalsList.add(new Animals(1, "Cat"));
        mAnimalsList.add(new Animals(2, "Dog"));
        mAnimalsList.add(new Animals(3, "Giraffe"));
    }

    private void addPlanetsToList() {
        mPlanetsList = new ArrayList<>();
        mPlanetsList.add(new Planets(1, "Mercury"));
        mPlanetsList.add(new Planets(2, "Pluto"));
        mPlanetsList.add(new Planets(3, "Earth"));
    }
}
