package com.lowe.playground.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CwolController {
	@RequestMapping(value = "/cwol", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView modelAndView = new ModelAndView("cwol");
		return modelAndView;
	}
}