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


import com.uca.capas.domain.Showcase;
import com.uca.capas.dto.ShowDTO;
import com.uca.capas.services.MovieService;
import com.uca.capas.services.ShowcaseService;

@Controller
public class ShowController {
	
	@Autowired
	MovieService Service1;
	
	@Autowired
	ShowcaseService Service2;
	
	@RequestMapping(value= "/Ret2")
	public ModelAndView Movies() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("HomeAdmin");
		return mav;
	}
	

	@RequestMapping(value="/EditS",method= RequestMethod.POST)
	public ModelAndView Edit(@RequestParam(value="id") int id){
		ModelAndView mav = new ModelAndView();	
  	   mav.addObject("showDTO",Service2.MapDTO(id));
		 mav.setViewName("EditS");
		return mav;
	}
	
	@RequestMapping(value="/SaveS",method= RequestMethod.POST)
	public ModelAndView Save(@Valid @ModelAttribute("showDTO") ShowDTO showDTO ,BindingResult result){
		ModelAndView mav = new ModelAndView();	
		
		if(result.hasErrors() || Service1.findOne(showDTO.getIdMovie())==null) {
	    	mav.setViewName("EditS");
	       }	
		
		else {
			Service2.UpdateS(showDTO);
			List<Showcase> show=Service2.findALL();
			mav.addObject("show",show);
			mav.setViewName("Shows");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/addS",method= RequestMethod.POST)
	public ModelAndView Add(){
		ModelAndView mav = new ModelAndView();	
  	   mav.addObject("showDTO2",new ShowDTO());
		 mav.setViewName("AddS");
		return mav;
	}
	
	@RequestMapping(value="/perS",method= RequestMethod.POST)
	public ModelAndView Perist(@Valid @ModelAttribute("showDTO2") ShowDTO showDTO2 ,BindingResult result){
		ModelAndView mav = new ModelAndView();	
		
		if(result.hasErrors() || Service1.findOne(showDTO2.getIdMovie())==null) {
	    	mav.setViewName("AddS");
	    	
	       }	
		
		else {
			ModelAndView mav2 = new ModelAndView("redirect:/Showcase");	
			Service2.AddS(showDTO2);
			return mav2;
		}
		return mav;
		
	}
	


}
