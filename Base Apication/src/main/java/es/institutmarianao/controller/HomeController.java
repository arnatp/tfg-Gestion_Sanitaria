package es.institutmarianao.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.institutmarianao.domain.User;
import es.institutmarianao.domain.Visit;
import es.institutmarianao.service.VisitService;

@Controller
public class HomeController {

	@Autowired
	private VisitService visitService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "welcomePage";
	}

	@RequestMapping(value = "/doctor/", method = RequestMethod.GET)
	public ModelAndView welcomeDoctor(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("userPage");
		User user = (User) request.getSession().getAttribute("user");
		LocalDate today = LocalDate.now();
		List<Visit> visits = visitService.getVisitsByDoctorIdAndDate(user.getUserId(), today.toString());
		modelAndView.getModelMap().addAttribute("visits", visits);
		return modelAndView;
	}

	@RequestMapping(value = "/patient/", method = RequestMethod.GET)
	public ModelAndView welcomePatient() {
		ModelAndView modelAndView = new ModelAndView("userPage");

		return modelAndView;
	}
}