package com.google.android.gms.samples.vision.barcodereader.utils;

import android.content.res.Resources;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import com.google.android.gms.samples.vision.barcodereader.R;
import com.google.android.gms.samples.vision.barcodereader.domain.Meal;

public class DataHandler {
    private static String loadJSONFromAsset(Resources res) {
        String json = null;
        try {
            //InputStream is = App.getContext().getResources().openRawResource(R.raw.meals);
            InputStream is = res.openRawResource(R.raw.meals);
            Writer writer = new StringWriter();
            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }

            json = writer.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static Meal getMealById(Resources res, int id){
        Meal meal = null;
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(res));
            JSONArray lstMeals = obj.getJSONArray("meals");

            for (int i = 0; i < lstMeals.length(); i++) {
                JSONObject object = lstMeals.getJSONObject(i);
                Log.d("Meal", object.getString("name"));

                if (object.getInt("id") == id) {
                    meal = new Meal();
                    meal.setId(object.getInt("id"));
                    meal.setName(object.getString("name"));
                    meal.setQuote(object.getString("quote"));
                    meal.setAlternatives(object.getString("alternatives"));
                    meal.setCo2((float)object.getDouble("co2"));
                    meal.setWater((float)object.getDouble("water"));
                    meal.setEnergy((float)object.getDouble("energy"));
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return meal;
    }

    public static Meal getMealByBarCode(String barcode){
        Meal meal = new Meal();

        if (barcode.equals("4029764001883") || barcode.equals("7614400010779")) {
            return new Meal(100, "Club-Mate Cola", 20.2f, 21.2f, 22.2f, "Tap water", "Water keeps you young, try it!");
        } else if (barcode.equals("7610097185554")) {
            return new Meal(100, "Club-Mate", 20.2f, 21.2f, 22.2f, "Tap water", "Water keeps you young, try it!");
        } else if (barcode.equals("7640119220208")) {
            return new Meal(100, "Club-Mate", 20.2f, 21.2f, 22.2f, "Tap water", "Water keeps you young, try it!");
        } else {
            return null;
        }
    }

    public static Meal getMealByBName(Resources res, String name){
        Meal meal = null;
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(res));
            JSONArray lstMeals = obj.getJSONArray("meals");

            for (int i = 0; i < lstMeals.length(); i++) {
                JSONObject object = lstMeals.getJSONObject(i);
                Log.d("Details-->", object.getString("name"));

                if (object.getString("name").toLowerCase().equals(name.toLowerCase())) {
                    meal = new Meal();
                    meal.setId(object.getInt("id"));
                    meal.setName(object.getString("name"));
                    meal.setQuote(object.getString("quote"));
                    meal.setAlternatives(object.getString("alternatives"));
                    meal.setCo2((float)object.getDouble("co2"));
                    meal.setWater((float)object.getDouble("water"));
                    meal.setEnergy((float)object.getDouble("energy"));
                    break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return meal;
    }
}
