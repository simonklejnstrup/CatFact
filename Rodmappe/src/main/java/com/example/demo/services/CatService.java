package com.example.demo.services;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CatService {
    public String getCatFactsString() throws IOException {
        //Choose what API to consume
        URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
        //Instantiate a Buffered Reader to consume the InputStream from the URL
        BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));
        //Map the data from Json to an object
        CatFacts data = new Gson().fromJson(inputFromCatURL, CatFacts.class);
        //Close the BufferedReader
        inputFromCatURL.close();

        return  data.toString();
    }

    public CatFacts getCatFacts() throws IOException {
        //Choose what API to consume
        URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
        //Instantiate a Buffered Reader to consume the InputStream from the URL
        BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));
        //Map the data from Json to an object
        CatFacts data = new Gson().fromJson(inputFromCatURL, CatFacts.class);
        //Close the BufferedReader
        inputFromCatURL.close();

        return  data;
    }




}