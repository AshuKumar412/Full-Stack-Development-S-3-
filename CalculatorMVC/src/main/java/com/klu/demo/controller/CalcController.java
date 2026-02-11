package com.klu.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.demo.service.CalcService;
/*import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;*/

@RestController
@RequestMapping("/calculator")
public class CalcController {
	@Autowired
	private CalcService service;
	
	
	//ADDITION - RequestParam
	//URL: http://localhost:8080/calcualtor/add?a=10&b=5
	
	
	@RequestMapping("/add")
	public int add(@RequestParam int a, @RequestParam int b) {
		return service.add(a, b);
	}
	
	//SUBSTRACTIO - PathVariable
		//URL: http://localhost:8080/calcualtor/substract/20/5
	@RequestMapping("/substract/{a}/{b}")
	public int substract(@PathVariable int a, @PathVariable int b) {
		return service.substract(a, b);
	}
	
	//MULTIPLICATION - PathVariable
		//URL: http://localhost:8080/calcualtor
	
	@RequestMapping("/multiply/{a}/{b}")
	public int multiply(@PathVariable int a, @PathVariable int b) {
		return service.multiply(a, b);
	}
	
	//DIVISION - RequestParm
	//URL: http://localhost:8080/calculator/divide?a=100&b=20
	
	@RequestMapping("/divide")
	public double divide(@RequestParam int a, @RequestParam int b) {
		return service.divide(a, b);
	}
	
	//MODULO - PathVariable
	//URL: http://localhost:8080/calculator/modulo/20/4
	
	@RequestMapping("/modulo/{a}/{b}")
	public double modulo(@PathVariable int a, @PathVariable int b) {
		return service.modulo(a, b);
	}
	
}
