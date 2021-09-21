package com.example.Demo1.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Demo1.model.Alien;
import com.example.Demo1.repository.AlienRepo;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("")
	public String s() {
		return "index";
	}
	
	@GetMapping("/addAlien")
	public ModelAndView newAlien(Alien alien) 
	{
		ModelAndView mv = new ModelAndView("detail");
		repo.save(alien);
		mv.addObject(alien);
		return mv;
	}
	

	@PostMapping("/alien")
	public ResponseEntity<Alien> addAlien(@RequestBody Alien alien){
		repo.save(alien);
		return ResponseEntity.status(HttpStatus.OK).body(alien);
	}
	
	@GetMapping(path="/aliens",produces= {"application/json"})
	public ResponseEntity<String> getAliens() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll().toString());
	}
	
	
	@RequestMapping("/aliens/{aid}")
	public ResponseEntity<Alien> getAliensById(@PathVariable("aid") int aid){
		return ResponseEntity.status(HttpStatus.OK).body(repo.findById(aid).orElse(new Alien()));
	}
}
