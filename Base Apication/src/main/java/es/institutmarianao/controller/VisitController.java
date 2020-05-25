package es.institutmarianao.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VisitController {
	@RequestMapping(value = "/patient/visit", method = RequestMethod.GET)
	public ModelAndView orders() throws ServletException, IOException {
		ModelAndView modelview = new ModelAndView("orders");
		return modelview;
	}

	@RequestMapping(value = "/patient/visit", method = RequestMethod.POST)
	public ModelAndView orders() throws ServletException, IOException {
		ModelAndView modelview = new ModelAndView("orders");
		return modelview;
	}
}
