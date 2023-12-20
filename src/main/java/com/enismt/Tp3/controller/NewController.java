package com.enismt.Tp3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.enismt.Tp3.model.AdresseRepository;

@Controller
public class NewController {
	
    @Autowired
    AdresseRepository addressRepository;

	@GetMapping("/Adresse")
    public String showAddresses(Model model) {
		
		return "Formulaire";
        
    }
	
}
