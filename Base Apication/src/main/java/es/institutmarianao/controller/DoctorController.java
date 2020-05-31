package es.institutmarianao.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.institutmarianao.domain.Doctor;
import es.institutmarianao.service.DoctorService;

@Controller
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value = "/doctor/updateUser", method = RequestMethod.GET)
	public ModelAndView updateUser() throws ServletException, IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Doctor doctor = doctorService.getUserByDni(auth.getName());
		ModelAndView modelview = new ModelAndView("user");
		modelview.getModelMap().addAttribute("user", doctor);
		return modelview;
	}

}
