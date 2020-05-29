package es.institutmarianao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	// private VisitService visitService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "welcomePage";
	}

	@RequestMapping(value = "/doctor/", method = RequestMethod.GET)
	public ModelAndView welcomeDoctor() {
		ModelAndView modelAndView = new ModelAndView("userPage");

		// modelAndView.getModelMap().addAttribute("visits",
		// visitWebService.getVisitsByDoctorId());
		return modelAndView;
	}

	@RequestMapping(value = "/patient/", method = RequestMethod.GET)
	public ModelAndView welcomePatient() {
		ModelAndView modelAndView = new ModelAndView("userPage");

		return modelAndView;
	}
}