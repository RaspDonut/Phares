package com.develop.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Locale;

public class DetailPhareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_phare);

        Intent intent = getIntent();

        String name = intent.getStringExtra("nom");
        TextView phare_name = findViewById(R.id.nom_phare);
        phare_name.setText(name);

        String id = intent.getStringExtra("id");
        TextView phare_id = findViewById(R.id.id_phare);
        phare_id.setText(id);

        int hauteur = intent.getIntExtra("hauteur", 0);
        TextView phare_hauteur = findViewById(R.id.hauteur_phare);
        phare_hauteur.setText(String.format(Locale.getDefault(), "%d", hauteur));

        int nbEclat = intent.getIntExtra("nbEclat", 0);
        TextView phare_nbEclat = findViewById(R.id.nb_eclat_phare);
        phare_nbEclat.setText(String.format(Locale.getDefault(), "%d", nbEclat));

        int periode = intent.getIntExtra("periode", 0);
        TextView phare_periode = findViewById(R.id.periode_phare);
        phare_periode.setText(String.format(Locale.getDefault(), "%d", periode));

        int portee = intent.getIntExtra("portee", 0);
        TextView phare_portee = findViewById(R.id.portee_phare);
        phare_portee.setText(String.format(Locale.getDefault(), "%d", portee));

        int automatisation = intent.getIntExtra("automatisation", 0);
        TextView phare_automatisation = findViewById(R.id.automatisation_phare);
        phare_automatisation.setText(String.format(Locale.getDefault(), "%d", automatisation));

        String imgName = intent.getStringExtra("imgURL");
        String url = "http://laurent-freund.fr/cours/android/phares/web/img/" + imgName;
        ImageView image_phare = findViewById(R.id.img_phare);
        Glide.with(image_phare).load(url).fitCenter().into(image_phare);

        image_phare.setOnClickListener(v -> {
            if (v.getScaleX() == 1f) {
                v.animate().setDuration(1000);
                v.animate().scaleX(1.4f);
                v.animate().scaleY(1.4f);
            } else {
                v.animate().setDuration(500);
                v.animate().scaleX(1f);
                v.animate().scaleY(1f);

                if (v.getRotationY() == 0) {
                    v.animate().rotationY(180);
                } else {
                    v.animate().rotationY(0);
                }
            }
        });
    }
}