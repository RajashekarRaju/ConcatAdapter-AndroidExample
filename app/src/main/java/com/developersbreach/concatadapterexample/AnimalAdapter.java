package com.developersbreach.concatadapterexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    private final List<Animals> mAnimalList;
    private final AnimalAdapterListener mListener;

    AnimalAdapter(List<Animals> animalsList, AnimalAdapterListener listener) {
        this.mAnimalList = animalsList;
        this.mListener = listener;
    }

    public interface AnimalAdapterListener {
        void onAnimalSelected(Animals animals);
    }

    static class AnimalViewHolder extends RecyclerView.ViewHolder {

        private final TextView mAnimalNameTextView;

        AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            mAnimalNameTextView = itemView.findViewById(R.id.animal_name_item_text_view);
        }
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animals, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        final Animals animals = mAnimalList.get(position);
        holder.mAnimalNameTextView.setText(animals.getAnimalName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onAnimalSelected(animals);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAnimalList.size();
    }
}
