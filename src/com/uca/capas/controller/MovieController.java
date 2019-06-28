package com.uca.capas.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Movie;
import com.uca.capas.dto.MovieDTO;
import com.uca.capas.services.MovieService;


@Controller
public class MovieController {
	
	@Autowired
	MovieService Service1;
	
	@RequestMapping(value= "/Ret")
	public ModelAndView Movies() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("HomeAdmin");
		return mav;
	}
	
	@RequestMapping(value="/EditM",method= RequestMethod.POST)
	public ModelAndView Edit(@RequestParam(value="id") int id){
		ModelAndView mav = new ModelAndView();	
  	   mav.addObject("movieDTO",Service1.MapDTO(id));
		 mav.setViewName("EditM");
		return mav;
	}
	
	@RequestMapping(value="/Save",method= RequestMethod.POST)
	public ModelAndView Save(@Valid @ModelAttribute("movieDTO") MovieDTO movieDTO ,BindingResult result){
		ModelAndView mav = new ModelAndView();	
		
		if(result.hasErrors()) {
	    	mav.setViewName("EditM");
	       }	
		
		else {
			Service1.Update(movieDTO);
			List<Movie> movies=Service1.findALL();
			mav.addObject("movies",movies);
			mav.setViewName("Movies");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/StateM",method= RequestMethod.POST)
	public ModelAndView SaveS(@RequestParam(value="id") int id){
		ModelAndView mav = new ModelAndView("redirect:/Movie");	
		
			Service1.UpdateS(id);
		
		
		return mav;
	}
	
	
	@RequestMapping(value="/addM",method= RequestMethod.POST)
	public ModelAndView Add(){
		ModelAndView mav = new ModelAndView();	
  	   mav.addObject("movieDTO2",new MovieDTO());
		 mav.setViewName("AddM");
		return mav;
	}
	
	@RequestMapping(value="/perM",method= RequestMethod.POST)
	public ModelAndView Perist(@Valid @ModelAttribute("movieDTO2") MovieDTO movieDTO2 ,BindingResult result){
		ModelAndView mav = new ModelAndView();	
		
		if(result.hasErrors()) {
	    	mav.setViewName("AddM");
	    	
	       }	
		
		else {
			ModelAndView mav2 = new ModelAndView("redirect:/Movie");	
			Service1.Add(movieDTO2);
			return mav2;
		}
		return mav;
		
	}
	
	

}
