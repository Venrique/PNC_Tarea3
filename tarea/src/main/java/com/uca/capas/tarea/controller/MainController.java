package com.uca.capas.tarea.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/index")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("/validacion")
	public ModelAndView validacion(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String nacimiento, 
			@RequestParam String lugar, @RequestParam String colegio, @RequestParam String telefono,  @RequestParam String cel) {
		
		
		boolean bandera = true;
		ModelAndView mav = new ModelAndView();
		
		if(nombre.length()<1) {
			mav.addObject("msg", "El nombre no puede ser menor a 1 caracter.");
			bandera=false;
		}else if(nombre.length()>25) {
			mav.addObject("msg", "El nombre no puede ser mayor a 25 caracteres.");
			bandera=false;
		}
		
		if(apellido.length()<1) {
			mav.addObject("msg", "El nombre no puede ser menor a 1 caracter.");
			bandera=false;
		}else if(apellido.length()>25) {
			mav.addObject("msg", "El nombre no puede ser mayor a 25 caracteres.");
			bandera=false;
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date birth = format.parse(nacimiento);
			Date min = format.parse("2003-01-01");
			
			if(birth.after(min)) {
				mav.addObject("msg", "La fecha de nacimiento no puede ser mayor al 01/01/2003.");
				bandera=false;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(lugar.length()<1) {
			mav.addObject("msg", "El lugar de nacimiento no puede ser menor a 1 caracter.");
			bandera=false;
		}else if(lugar.length()>25) {
			mav.addObject("msg", "El lugar de nacimiento no puede ser mayor a 25 caracteres.");
			bandera=false;
		}
		
		if(colegio.length()<1) {
			mav.addObject("msg", "El nombre del colegio no puede ser menor a 1 caracter.");
			bandera=false;
		}else if(colegio.length()>100) {
			mav.addObject("msg", "El nombre del colegio no puede ser mayor a 100 caracteres.");
			bandera=false;
		}
		
		if(telefono.length()!=8) {
			mav.addObject("msg", "El telefono no puede tener más o menos de 8 números.");
			bandera=false;
		}
		
		if(cel.length()!=8) {
			mav.addObject("msg", "El telefono celular no puede tener más o menos de 8 números.");
			bandera=false;
		}
		
		if(bandera==false) {
			mav.setViewName("fallido");
		}else {
			mav.setViewName("exito");
		}
		
		
		return mav;
	}
}
