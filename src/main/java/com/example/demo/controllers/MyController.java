package com.example.demo.controllers;

import com.example.demo.services.CatFacts;
import com.example.demo.services.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class MyController {



        @GetMapping("/")
        @ResponseBody
        public String hello() {
            return "Welcome to Cat Facts by Simon Klejnstrup\nHere you wil find random facts with cats. \nMeow!";
        }

    @GetMapping("/getSingle")
    @ResponseBody
    public String getSingle() throws IOException {
        CatService cS = new CatService();
        return  cS.getCatFactsString();
    }

    @GetMapping("/getTen")
    @ResponseBody
    public String getTen() throws IOException {
        CatFacts[] cFArray = getCatFactsArrayOf10();
        return Arrays.toString(cFArray);
    }

    public CatFacts[] getCatFactsArrayOf10() throws IOException {
        CatService cS = new CatService();

        CatFacts[] cF = new CatFacts[10];
        for (int i = 0; i <cF.length ; i++) {
            cF[i] = cS.getCatFacts();
        }
        return cF;
    }

    @GetMapping("/getTenSortByDate")
    @ResponseBody
    public String getTenSortByDate() throws IOException {

        List<CatFacts> cFArrayAsList = Arrays.asList(getCatFactsArrayOf10());
        Collections.sort(cFArrayAsList);

        return cFArrayAsList.toString();
    }

    @GetMapping("/contains")
    @ResponseBody
    public String contains(@RequestParam char character, @RequestParam int amount) throws IOException {

        CatService cS = new CatService();
        CatFacts catFact = cS.getCatFacts();
        String finalString;
        int counter = 0;
        for (int i = 0; i <catFact.getText().length() ; i++) {
            if (catFact.getText().charAt(i) == character){
                counter++;
            }
        }

        if (counter == amount){
            finalString = "Congratulations! The letter " + character + " was represented " + counter +
                " times in the following catfact: " + catFact.getText();
        } else {
            finalString = "Sorry no luck";
        }

        return finalString;
    }







        



}
