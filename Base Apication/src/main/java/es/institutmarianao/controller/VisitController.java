package es.institutmarianao.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.institutmarianao.domain.Doctor;
import es.institutmarianao.domain.Visit;
import es.institutmarianao.service.DoctorService;
import es.institutmarianao.service.VisitService;

@Controller
public class VisitController {
	@Autowired
	private VisitService visitService;
	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value = "/visit", method = RequestMethod.GET)
	public ModelAndView requestVisit() throws ServletException, IOException {
		ModelAndView modelview = new ModelAndView("visit");
		modelview.getModelMap().addAttribute("visit", new Visit());
		List<Doctor> doctors = doctorService.getAll();
		modelview.getModelMap().addAttribute("doctor", doctors);

		return modelview;
	}

	@RequestMapping(value = "/patient/visit", method = RequestMethod.POST)
	public String processSignUpForm(@ModelAttribute("visit") Visit newVisitToAdd, BindingResult result,
			HttpServletRequest request) {
		visitService.add(newVisitToAdd);
		return "redirect:/";
	}
//
//	@RequestMapping(value = "/doctor/visits", method = RequestMethod.GET)
//	public ModelAndView orders() throws ServletException, IOException {
//		ModelAndView modelview = new ModelAndView("orders");
//		return modelview;
//	}
//
//	@RequestMapping(value = "/doctor/visit", method = RequestMethod.GET)
//	public ModelAndView orders() throws ServletException, IOException {
//		ModelAndView modelview = new ModelAndView("orders");
//		return modelview;
//	}
//
//	@RequestMapping(value = "/doctor/visit", method = RequestMethod.POST)
//	public ModelAndView orders() throws ServletException, IOException {
//		ModelAndView modelview = new ModelAndView("orders");
//		return modelview;
//	}
}