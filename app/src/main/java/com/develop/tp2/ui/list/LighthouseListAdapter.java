package com.develop.tp2.ui.list;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.develop.tp2.DetailPhareActivity;
import com.develop.tp2.MainActivity;
import com.develop.tp2.R;

import com.develop.tp2.model.LighthouseModel;

import java.util.List;
import java.util.Locale;

public class LighthouseListAdapter extends RecyclerView.Adapter<LighthouseListAdapter.LighthouseItemViewHolder> {

    private final List<LighthouseModel> mValues;

    public LighthouseListAdapter(List<LighthouseModel> items) {
        mValues = items;
    }

    @Override
    public LighthouseItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lighthouse_item, parent, false);
        return new LighthouseItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LighthouseItemViewHolder holder, int position) {
        final LighthouseModel currentItem = mValues.get(position);

        holder.mLighthouseName.setText(currentItem.getNom());
        holder.mLighthouseRegion.setText(currentItem.getRegion());
        String constructionString = String.format(Locale.getDefault(), "%d", currentItem.getConstruction());
        holder.mLighthouseConstruction.setText(constructionString);
        String url = "http://laurent-freund.fr/cours/android/phares/web/img/" + currentItem.getImgFile();
        Glide.with(holder.mView).load(url).into(holder.mLighthouseImage);

        holder.mView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DetailPhareActivity.class);
            intent.putExtra("id", currentItem.getId());
            intent.putExtra("nom", currentItem.getNom());
            intent.putExtra("hauteur", currentItem.getHauteur());
            intent.putExtra("nbEclat", currentItem.getNbEclat());
            intent.putExtra("periode", currentItem.getPeriode());
            intent.putExtra("portee", currentItem.getPortee());
            intent.putExtra("automatisation", currentItem.getAutomatisation());
            intent.putExtra("lon", currentItem.getLon());
            intent.putExtra("lat", currentItem.getLat());
            intent.putExtra("imgURL", currentItem.getImgFile());

            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class LighthouseItemViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mLighthouseName;
        public final TextView mLighthouseRegion;
        public final TextView mLighthouseConstruction;
        public final ImageView mLighthouseImage;

        public LighthouseItemViewHolder(View view) {
            super(view);
            mView = view;
            mLighthouseName = (TextView) view.findViewById(R.id.lighthouse_name);
            mLighthouseRegion = (TextView) view.findViewById(R.id.lighthouse_region);
            mLighthouseConstruction = (TextView) view.findViewById(R.id.lighthouse_construction);
            mLighthouseImage = (ImageView) view.findViewById(R.id.img_phare);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mLighthouseName.getText() + "'";
        }
    }
}