package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Movie;
import com.uca.capas.domain.Showcase;
import com.uca.capas.domain.User;
import com.uca.capas.dto.loginDTO;
import com.uca.capas.services.MovieService;
import com.uca.capas.services.ShowcaseService;
import com.uca.capas.services.UserService;

@Controller
public class AdminController {
	
	@Autowired
	MovieService Service1;
	
	@Autowired
	ShowcaseService Service2;
	
	@Autowired
	UserService Service3;
	
	static final int id2=0;
	
	
	@RequestMapping(value= "/Movie")
	public ModelAndView Movies() {
		
		ModelAndView mav = new ModelAndView();
		List<Movie> movies=Service1.findALL();
		mav.addObject("movies",movies);
		mav.setViewName("Movies");
		return mav;
	}
	
	@RequestMapping(value= "/Showcase")
	public ModelAndView Shows() {
		
		ModelAndView mav = new ModelAndView();
		List<Showcase> show=Service2.findALL();
		mav.addObject("show",show);
		mav.setViewName("Shows");
		return mav;
	}
	
	@RequestMapping(value= "/User")
	public ModelAndView User() {
		
		ModelAndView mav = new ModelAndView();
		List<User> user= Service3.findALL(); 
		mav.addObject("user",user);
		mav.setViewName("User");
		return mav;
	}
	
	@RequestMapping(value= "/Ret4")
	public ModelAndView End(@RequestParam(value="id") int id) {
		if(id==0) {
			User user= Service3.findOneAdmin();
			ModelAndView mav = new ModelAndView();
			Service3.UpdateS(user.getIdUser());
			id=-1;
			mav.addObject("loginDTO", new loginDTO());
			mav.setViewName("Login");
			return mav;
			
		}
		else {
			ModelAndView mav = new ModelAndView();
			Service3.UpdateS(id);
			mav.addObject("loginDTO", new loginDTO());
			mav.setViewName("Login");
			return mav;
		}
		
		
	}

}
