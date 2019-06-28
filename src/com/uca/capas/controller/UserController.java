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

import com.uca.capas.domain.User;

import com.uca.capas.dto.UserDTO;
import com.uca.capas.services.UserService;


@Controller
public class UserController {
	
	@Autowired
	UserService Service3;
	

	@RequestMapping(value="/StateUser",method= RequestMethod.POST)
	public ModelAndView SaveS(@RequestParam(value="id") Integer id){
		System.out.println(id);
		User Usr=Service3.findOne(id);
		
		if(Usr.getStateU().equals("Activo")) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("UserDTO",Service3.mapDTO(id));
			mav.setViewName("UserState");
		
	         return mav;
			
		}
		else {
			Service3.UpdateU(id);
			ModelAndView mav = new ModelAndView("redirect:/User");	
			
			
		
		return mav;
			
		}		
		
	}
	
	@RequestMapping(value="/SaveC",method= RequestMethod.POST)
	public ModelAndView Save(@Valid @ModelAttribute("UserDTO") UserDTO UserDTO ,BindingResult result){
		ModelAndView mav = new ModelAndView();	
		
		if(result.hasErrors()) {
	    	mav.setViewName("UserState");
	       }	
		
		else {
			Service3.UpdateC(UserDTO);
			List<User> user= Service3.findALL(); 
			mav.addObject("user",user);
			mav.setViewName("User");
		}
		
		return mav;
	}
	
	@RequestMapping(value= "/Ret3")
	public ModelAndView Movies() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("HomeAdmin");
		return mav;
	}
	
}
