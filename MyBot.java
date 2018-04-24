/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication93;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sun.util.locale.StringTokenIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;

public class MyBot extends org.jibble.pircbot.PircBot {
    static String OPEN_WEATHER_API_KEY = "";
    static String TWITTER_API_KEY = "";
    String baseUrl_weather = "http://api.openweathermap.org/data/2.5/weather?zip&units=imperial" ;//94040,us
    String baseUrlostfix_weather = ",us";

    public MyBot(){
        this.setName("Wolf_z7");
    }

    public void onMessage(String channel, String sender, String login, String hostName, String message) {
        try {
            processMessage(channel, sender, login, hostName, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processMessage(String channel, String sender, String login, String hostName, String message) throws IOException {
       if (message.startsWith("weather")) {
           getWeatherInfo(channel, message);
       } else if (message.startsWith("twitter")){
           getTwitterInfo(channel);
       } else {
           handleUnknownMessage(channel);
        }
    }

    private void handleUnknownMessage(String channel) {
       sendMessage(channel, "Example of correct usage: \"weather <zipcode>\" or \"twiiter <search term>\"  ");
    }

    private void getTwitterInfo(String channel) {
    }

    private void getWeatherInfo(String s, String channel) throws IOException {

        StringTokenizer tokenizer = new StringTokenizer(s, " ");
        tokenizer.nextToken();
        String zipcode = tokenizer.nextToken();

        String responseStr = null;

        // request
        final int OK = 200;
        URL url = new URL(baseUrl_weather + zipcode + baseUrlostfix_weather);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        int responseCode = connection.getResponseCode();
        if(responseCode == OK){
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            responseStr  = response.toString();
        }

        // response
        // Get Gson object
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        wetherData weatherData = gson.fromJson(responseStr, (Type) wetherData.class);

        //
        sendMessage(channel, weatherData.toString());
    }
}
