package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        Sandwich sandwich = new Sandwich();

        JSONObject jsonObject = new JSONObject(json);
        JSONObject name = jsonObject.getJSONObject("name");
        sandwich.setMainName(name.getString("mainName"));
        sandwich.setAlsoKnownAs(jsonArrayToList(name.getJSONArray("alsoKnownAs")));
        sandwich.setPlaceOfOrigin(jsonObject.getString("placeOfOrigin"));
        sandwich.setDescription(jsonObject.getString("description"));
        sandwich.setImage(jsonObject.getString("image"));
        sandwich.setIngredients(jsonArrayToList(jsonObject.getJSONArray("ingredients")));

        return sandwich;
    }

    public static List<String> jsonArrayToList (JSONArray array) throws JSONException {
        ArrayList<String> list = new ArrayList<>();

        for( int i = 0; i < array.length(); i++){
            list.add(array.getString(i));
        }

        return list;
    }
}
