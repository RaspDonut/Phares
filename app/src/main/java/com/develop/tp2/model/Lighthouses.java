package com.develop.tp2.model;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class Lighthouses {
    public static ArrayList<LighthouseModel> ITEMS = new ArrayList<>();

    public static void parseJSON(Context context) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(context.getAssets().open("phares_all.json")));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            String str = new String(sb.toString()) ;

            JSONObject jObjConnection = new JSONObject(str);
            JSONObject jsonBix = jObjConnection.getJSONObject("phares");
            JSONArray jsonA = jsonBix.getJSONArray("liste");
            for(int i = 0; i < jsonA.length(); i++) {
                JSONObject obj = (JSONObject)jsonA.get(i);
                String id = obj.getString("id");
                String nom = obj.getString("name");
                String imgFile = obj.getString("filename");
                String region = obj.getString("region");
                int construction = obj.getInt("construction");
                int hauteur = obj.getInt("hauteur");
                int eclat = obj.getInt("eclat");
                int periode = obj.getInt("periode");
                int portee = obj.getInt("portee");
                int automatisation = obj.getInt("automatisation");
                double lat = obj.getDouble("lat");
                double lon = obj.getDouble("lon");

                ITEMS.add(new LighthouseModel(id, nom, imgFile, region, construction, hauteur, eclat, periode, portee, automatisation, lat, lon));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
