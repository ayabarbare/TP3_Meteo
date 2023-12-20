package com.enismt.Tp3.controller;

import com.enismt.Tp3.model.EtalabAPIAddress;
import com.enismt.Tp3.model.Feature;
import com.enismt.Tp3.model.MeteoConceptApiAddress;
import com.fasterxml.jackson.core.JsonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.enismt.Tp3.model.AdresseRepository;

import java.awt.*;
import java.net.http.HttpHeaders;
import java.util.Collections;


@Controller
public class MeteoController {

	@Autowired
	RestTemplate rt;

    public static String API_KEY = "";

    @GetMapping("/adresse")
    public String meteoGet(Model model){
        return "Formulaire";
    }
	
    @PostMapping("/meteo")
    public String getadresse(@RequestParam(name="address",required = true) String address,Model model) {

        //elimination des espaces et les remplacer par des +
        String query = address.toLowerCase().replace(" ","+");

        //Geo API
        EtalabAPIAddress etalabAPIAddress = rt.getForObject("https://api-adresse.data.gouv.fr/search/?q=" + query + "&limit=1", EtalabAPIAddress.class);

        Feature feature = etalabAPIAddress.features.get(0);

        float longitude = feature.getGeometry().getCoordinates().get(0);
        float latitude = feature.getGeometry().getCoordinates().get(1);

            // Ajoutez les coordonnées à votre modèle
        model.addAttribute("longitude", longitude);
        model.addAttribute("latitude", latitude);

        String weatherApiKey="ddadd31d5bc898550890165ccd2560cb63ab5653d8e183e4e72dac372deb27d3";
        String weatherApiUrl = "https://api.meteo-concept.com/api/forecast/nextHours?token=" + weatherApiKey +  "&latlon=" + latitude + ","+ longitude ;

        MeteoConceptApiAddress responset = rt.getForObject(weatherApiUrl, MeteoConceptApiAddress.class);
        int temp2m = responset.forecast.get(0).getTemp2m();
        model.addAttribute("temp2m",temp2m);

        return "meteo";

        //Meteo API
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION JSON))
//        return "/meteo";

        }
    }
