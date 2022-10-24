/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tsystems.restex;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 *
 * @author aalonsoa
 */
public class WebJsonReader {

    private String webBodyJson;

    public WebJsonReader(String webBodyJson)
    {
        this.webBodyJson = webBodyJson;
    }

    public String getText()
    {
        JsonObject joke = new Gson().fromJson(webBodyJson, JsonObject.class);
        return joke.get("value").getAsString();
    }

}
