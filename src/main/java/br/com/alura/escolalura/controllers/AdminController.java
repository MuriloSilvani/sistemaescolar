package br.com.alura.escolalura.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/error")
	public String error() {
		
		return "error";
	}
	
	@GetMapping("/backindex")
	public String backindex() {
		
		return "redirect:/";
	}
}
