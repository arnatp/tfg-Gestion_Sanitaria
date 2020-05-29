package es.institutmarianao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.institutmarianao.domain.User;
import es.institutmarianao.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public String check(HttpServletRequest request) throws ServletException, IOException {

		String userName = request.getUserPrincipal().getName();
		User user = userService.getUserByDni(userName);

		// set session atribute
		request.getSession().setAttribute("user", user);

		if (request.isUserInRole("ROLE_EMPLOYEE")) {
			return "redirect:/doctor/";
		}
		return "redirect:/patient/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws ServletException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		request.logout();
		return "redirect:/";
	}
}
