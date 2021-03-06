package es.institutmarianao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.institutmarianao.domain.Patient;
import es.institutmarianao.domain.User;
import es.institutmarianao.service.PatientService;

@Controller
public class SignUpController {
	@Autowired
	private PatientService patientService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Qualifier("customAuthenticationProvider")
	private AuthenticationProvider authenticationProvider;

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public ModelAndView signUp() throws ServletException, IOException {
		ModelAndView modelview = new ModelAndView("user");
		modelview.getModelMap().addAttribute("user", new Patient());
		return modelview;
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String processSignUpForm(@Valid @ModelAttribute("user") Patient newPatientToAdd, BindingResult result,
			HttpServletRequest request) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Intentat accedir amb camps no permesos: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		if (result.hasErrors()) {
			return "user";
		}
		if (patientService.checkIfExists(newPatientToAdd)) {
			return "user";
		}
		// encode password
		newPatientToAdd.setPassword(passwordEncoder.encode(newPatientToAdd.getPassword()));

		patientService.add(newPatientToAdd);
		loginUser(newPatientToAdd, request);
		return "redirect:/check";
	}

	private void loginUser(User user, HttpServletRequest request) {
		try {
			// Must be called from request filtered by Spring Security, otherwise
			// SecurityContextHolder is not updated
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(),
					user.getPassword());
			token.setDetails(new WebAuthenticationDetails(request));
			Authentication authentication = authenticationProvider.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (Exception e) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
	}
}
