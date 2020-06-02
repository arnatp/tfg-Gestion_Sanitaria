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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.institutmarianao.domain.Doctor;
import es.institutmarianao.domain.Patient;
import es.institutmarianao.domain.Prescription;
import es.institutmarianao.domain.Visit;
import es.institutmarianao.service.DoctorService;
import es.institutmarianao.service.PatientService;
import es.institutmarianao.service.PrescriptionService;
import es.institutmarianao.service.VisitService;

@Controller
public class VisitController {
	@Autowired
	private VisitService visitService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private PrescriptionService prescriptionService;
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
		modelview.getModelMap().addAttribute("doctor", doctorService.getAll());
		Prescription prescription = new Prescription();
		if (visit.getPrescription() != null) {
			prescription = visit.getPrescription();
		}
		modelview.getModelMap().addAttribute("prescription", prescription);
		return modelview;
	}

	@RequestMapping(value = "/doctor/visit", method = RequestMethod.POST)
	public String updateVisit(@ModelAttribute("visit") Visit visitModified,
			@ModelAttribute("prescription") Prescription prescription, @RequestParam("doctorDni") String dni)
			throws ServletException, IOException {

		if (prescription != null) {
			prescriptionService.add(prescription);
		}
		visitModified.setCompleted(true);
		visitModified.setDoctor(doctorService.getUserByDni(dni));
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
		List<Visit> visits = visitService.getVisitsByPatientId(patientService.getUserByDni(patientDNI).getUserId());
		modelview.getModelMap().addAttribute("visits", visits);

		return modelview;
	}
}