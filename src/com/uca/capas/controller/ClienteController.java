package com.uca.capas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.repositories.UserRepository;
import com.uca.capas.services.MovieService;
import com.uca.capas.services.ShowcaseService;
import com.uca.capas.services.ShowXCinemaService;

@Controller
public class ClienteController {

	@Autowired
	MovieService Service1;
	
	@Autowired
	UserRepository Users;
	
	@Autowired
	ShowcaseService showservice;
	
	@Autowired
	ShowXCinemaService sxcservice;
	
	@RequestMapping(value="/addreserva",method= RequestMethod.POST)
	public ModelAndView agregarReserva(@RequestParam(value="iduser") int iduser,
			@RequestParam("idmovie") int idmovie){
		ModelAndView mav = new ModelAndView();	
		mav.addObject("p", Service1.findOne(idmovie));
		mav.addObject("u", Users.findOne(iduser));
		mav.addObject("f", showservice.fechas());
		mav.addObject("s", showservice.findAllPerMovie(idmovie));
		mav.setViewName("reservar");
		return mav;
	}
	
	@RequestMapping(value="/factura",method= RequestMethod.POST)
	public ModelAndView factura(@RequestParam(value="iduser") int iduser,
			@RequestParam("idmovie") int idmovie){
		ModelAndView mav = new ModelAndView();	
		mav.addObject("p", Service1.findOne(idmovie));
		mav.addObject("u", Users.findOne(iduser));
		mav.addObject("f", showservice.fechas());
		mav.addObject("s", showservice.findAllPerMovie(idmovie));
		mav.setViewName("reservar");
		return mav;
	}
	
	
	@RequestMapping(value="/comprar",method= RequestMethod.POST)
	public ModelAndView comprar(@RequestParam(value="iduser") int iduser,
			@RequestParam("idshowcase") int idshowcase,
			@RequestParam("idmovie") int idmovie){
		ModelAndView mav = new ModelAndView();	
		mav.addObject("p", Service1.findOne(idmovie));
		mav.addObject("sxc",sxcservice.getSXC(idshowcase));
		mav.addObject("u", Users.findOne(iduser));
		mav.addObject("f", showservice.fechas());
		mav.addObject("s", showservice.findAllPerMovie(idmovie));
		mav.setViewName("comprar");
		return mav;
	}
	
	
	@RequestMapping(value="/agregarreservafilter",method= RequestMethod.POST)
	public ModelAndView agregarReservaFilter(@RequestParam(value="iduser") int iduser,
			@RequestParam(value="idmovie") int idmovie,
			@RequestParam(value="tipo") String tipoFunc,
			@RequestParam(value="fec") String fechaF){
		ModelAndView mav = new ModelAndView();	
		mav.addObject("p", Service1.findOne(idmovie));
		mav.addObject("u", Users.findOne(iduser));
		mav.addObject("f", showservice.fechas());
		mav.addObject("s", showservice.findAllPerMovieFilter(idmovie, tipoFunc, ));
		mav.setViewName("reservafilter");
		return mav;
	}
	
	
	
}
