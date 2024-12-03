package com.uber_persona.backend.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SalidaJson {
    public static String toString(Object t) {
        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson gson = gsonBuilder.setPrettyPrinting().create();

        return gson.toJson(t).trim().replace("\n", "").replace("\t", "");
    }
}
