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

import es.institutmarianao.domain.Patient;
import es.institutmarianao.service.PatientService;

@Controller
public class PatientController {

	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "/patient/updateUser", method = RequestMethod.GET)
	public ModelAndView updateUser() throws ServletException, IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Patient patient = patientService.getUserByDni(auth.getName());
		ModelAndView modelview = new ModelAndView("user");
		modelview.getModelMap().addAttribute("user", patient);
		return modelview;
	}

	@RequestMapping(value = "/patient/updateUser", method = RequestMethod.POST)
	public String processUpdateUserForm(@ModelAttribute("user") Patient updatePatient, BindingResult result) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Intentat accedir amb camps no permesos: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		patientService.update(updatePatient);
		return "redirect:/patient/";
	}
}
