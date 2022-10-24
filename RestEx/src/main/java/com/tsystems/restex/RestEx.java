/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.tsystems.restex;

/**
 *
 * @author aalonsoa
 */
public class RestEx {

    static WebHttpRequest wReq = new WebHttpRequest("https://api.chucknorris.io/jokes/random");
    static WebJsonReader wJson;

    public static void main(String[] args)
    {
        String joke = wReq.request();
        wJson = new WebJsonReader(joke);

        System.out.println(wJson.getText());
    }
}
