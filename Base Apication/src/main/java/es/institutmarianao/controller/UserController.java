package es.institutmarianao.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.institutmarianao.domain.User;
import es.institutmarianao.serviceweb.UserWebService;

@Controller
public class UserController {

	@Autowired
	private UserWebService userService;

	@RequestMapping(value = "/patient/home", method = RequestMethod.GET)
	public ModelAndView orders() throws ServletException, IOException {
		ModelAndView modelview = new ModelAndView("orders");
		return modelview;
	}

	@RequestMapping(value = "/doctor/home", method = RequestMethod.GET)
	public ModelAndView orders1() throws ServletException, IOException {
		ModelAndView modelview = new ModelAndView("orders");
		return modelview;
	}

	@RequestMapping(value = "/secured/updateUser", method = RequestMethod.GET)
	public ModelAndView updateUser() throws ServletException, IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.getUserByDni(auth.getName());
		ModelAndView modelview = new ModelAndView("user");
		modelview.getModelMap().addAttribute("user", user);
		return modelview;
	}

	@RequestMapping(value = "/secured/updateUser", method = RequestMethod.POST)
	public String processUpdateUserForm(@ModelAttribute("user") User newUserToAdd, BindingResult result) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Intentat accedir amb camps no permesos: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		userService.update(newUserToAdd);
		return "redirect:/";
	}

}
