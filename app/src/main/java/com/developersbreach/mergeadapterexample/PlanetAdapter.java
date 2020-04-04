package com.developersbreach.mergeadapterexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {


    private Context mContext;
    private List<Planets> mPlanetsList;
    private PlanetAdapterListener mListener;

    PlanetAdapter(Context context, List<Planets> planetsList, PlanetAdapterListener listener) {
        this.mContext = context;
        this.mPlanetsList = planetsList;
        this.mListener = listener;
    }

    public interface PlanetAdapterListener {
        void onPlanetSelected(Planets planets);
    }

    static class PlanetViewHolder extends RecyclerView.ViewHolder {

        private TextView mPlanetNameTextView;

        PlanetViewHolder(@NonNull final View itemView) {
            super(itemView);
            mPlanetNameTextView = itemView.findViewById(R.id.planet_name_item_text_view);
        }
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_planets, parent, false);
        return new PlanetViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        final Planets planets = mPlanetsList.get(position);
        holder.mPlanetNameTextView.setText(planets.getPlanetName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onPlanetSelected(planets);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPlanetsList.size();
    }
}
