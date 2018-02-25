package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String JSON_NAME_KEY = "name";
    private static final String JSON_MAIN_NAME_KEY = "mainName";
    private static final String JSON_ALSO_KNOWN_AS_KEY = "alsoKnownAs";
    private static final String JSON_PLACE_OF_ORIGIN_KEY = "placeOfOrigin";
    private static final String JSON_DESCRIPTION_KEY = "description";
    private static final String JSON_IMAGE_KEY = "image";
    private static final String JSON_INGREDIENTS_KEY = "ingredients";

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        Sandwich sandwich = new Sandwich();

        JSONObject jsonObject = new JSONObject(json);
        JSONObject name = jsonObject.getJSONObject(JSON_NAME_KEY);
        sandwich.setMainName(name.optString(JSON_MAIN_NAME_KEY));
        sandwich.setAlsoKnownAs(jsonArrayToList(name.getJSONArray(JSON_ALSO_KNOWN_AS_KEY)));
        sandwich.setPlaceOfOrigin(jsonObject.optString(JSON_PLACE_OF_ORIGIN_KEY));
        sandwich.setDescription(jsonObject.optString(JSON_DESCRIPTION_KEY));
        sandwich.setImage(jsonObject.optString(JSON_IMAGE_KEY));
        sandwich.setIngredients(jsonArrayToList(jsonObject.getJSONArray(JSON_INGREDIENTS_KEY)));

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
