package es.institutmarianao.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.institutmarianao.domain.Doctor;
import es.institutmarianao.domain.Patient;
import es.institutmarianao.domain.Prescription;
import es.institutmarianao.domain.Visit;
import es.institutmarianao.service.DoctorService;
import es.institutmarianao.service.PatientService;
import es.institutmarianao.service.VisitService;

@Controller
public class VisitController {
	@Autowired
	private VisitService visitService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "patient/visit", method = RequestMethod.GET)
	public ModelAndView requestVisit() throws ServletException, IOException {
		ModelAndView modelview = new ModelAndView("visit");
		modelview.getModelMap().addAttribute("visit", new Visit());
		List<Doctor> doctors = doctorService.getAll();
		modelview.getModelMap().addAttribute("doctor", doctors);

		return modelview;
	}

	@RequestMapping(value = "/patient/visit", method = RequestMethod.POST)
	public String processSignUpForm(@ModelAttribute("visit") Visit newVisitToAdd, BindingResult result,
			HttpServletRequest request, @RequestParam("doctorDni") String dni) {

		Patient patient = (Patient) request.getSession().getAttribute("user");
		newVisitToAdd.setDoctor(doctorService.getUserByDni(dni));
		newVisitToAdd.setPatient(patient);
		visitService.add(newVisitToAdd);
		return "redirect:/patient/";
	}

	@RequestMapping(value = "/patient/visits", method = RequestMethod.GET)
	public ModelAndView getAllPatientVisits(HttpServletRequest request) throws ServletException, IOException {
		ModelAndView modelview = new ModelAndView("allVisits");
		Patient patient = (Patient) request.getSession().getAttribute("user");
		List<Visit> visits = visitService.getVisitsCompletedByPatientId(patient.getUserId());
		modelview.getModelMap().addAttribute("visits", visits);

		return modelview;
	}

	@RequestMapping(value = "/doctor/visits", method = RequestMethod.GET)
	public ModelAndView getAllDocotorVisits(HttpServletRequest request) throws ServletException, IOException {
		ModelAndView modelview = new ModelAndView("allVisits");
		Doctor doctor = (Doctor) request.getSession().getAttribute("user");
		List<Visit> visits = visitService.getVisitsByDoctorId(doctor.getUserId());
		modelview.getModelMap().addAttribute("visits", visits);

		return modelview;
	}

	@RequestMapping(value = "/doctor/visit", method = RequestMethod.GET)
	public ModelAndView seeVisit(@RequestParam("visitId") int visitId) throws ServletException, IOException {
		ModelAndView modelview = new ModelAndView("visit");
		Visit visit = visitService.getVisitByVisitId(visitId);
		modelview.getModelMap().addAttribute("visit", visit);
		modelview.getModelMap().addAttribute("patientDni", visit.getPatient().getDni());
		List<Doctor> doctors = new ArrayList<Doctor>();

		doctors.add(doctorService.getUserByDni(visit.getDoctor().getDni()));
		modelview.getModelMap().addAttribute("doctor", doctors);
		new Prescription();

		return modelview;
	}

	@RequestMapping(value = "/doctor/visit", method = RequestMethod.POST)
	public String updateVisit(@ModelAttribute("visit") Visit visitModified, @RequestParam("doctorDni") String dni,
			@RequestParam("patientDni") String patientDni) throws ServletException, IOException {

		visitModified.setCompleted(true);
		visitModified.setPatient(patientService.getUserByDni(patientDni));
		visitModified.setDoctor(doctorService.getUserByDni(dni));
		if (visitModified.getPrescription().getMedicamentName().isEmpty()) {
			visitModified.setPrescription(null);
		}
		visitService.update(visitModified);
		return "redirect:/doctor/";
	}

	@RequestMapping(value = "/patient/cancelVisit", method = RequestMethod.GET)
	public String cancelVisit(@RequestParam("visitId") int visitId) throws ServletException, IOException {
		visitService.delete(visitId);
		return "redirect:/patient/";
	}

	@RequestMapping(value = "/doctor/visits/findAllByDni", method = RequestMethod.POST)
	public ModelAndView getAllVisitsByPatientId(@RequestParam("patientDNI") String patientDNI)
			throws ServletException, IOException {
		ModelAndView modelview = new ModelAndView("allVisits");
		try {
			List<Visit> visits = visitService.getVisitsByPatientId(patientService.getUserByDni(patientDNI).getUserId());
			modelview.getModelMap().addAttribute("visits", visits);
		} catch (Exception e) {
			modelview.getModelMap().addAttribute("error", "No se ha encontrado el paciente");
		}
		modelview.getModelMap().addAttribute("patientDni", patientDNI);

		return modelview;
	}

	@RequestMapping(value = "patient/printHistory", method = RequestMethod.GET)
	public ModelAndView download(HttpServletRequest request) {

		// create some sample data
		Patient patient = (Patient) request.getSession().getAttribute("user");
		List<Visit> visits = visitService.getVisitsCompletedByPatientId(patient.getUserId());

		// return a view which will be resolved by an excel view resolver
		return new ModelAndView("pdfView", "visits", visits);
	}

	@RequestMapping(value = "/doctor/visits/printHistory", method = RequestMethod.GET)
	public ModelAndView downloadExcel(HttpServletRequest request, @RequestParam("patientDNI") String patientDNI) {

		// create some sample data
		Patient patient = patientService.getUserByDni(patientDNI);
		List<Visit> visits = visitService.getVisitsCompletedByPatientId(patient.getUserId());

		// return a view which will be resolved by an excel view resolver
		return new ModelAndView("pdfView", "visits", visits);
	}

}