package es.institutmarianao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.institutmarianao.domain.Role;
import es.institutmarianao.domain.User;
import es.institutmarianao.serviceweb.DoctorWebService;
import es.institutmarianao.serviceweb.PatientWebService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PatientWebService patientWebService;
	@Autowired
	private DoctorWebService doctorWebService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Role> roles = new ArrayList<Role>();

		User user = patientWebService.getUserByDni(username);
		if (user != null) {
			roles.add(new Role("ROLE_PATIENT"));
			user.setAuthorities(roles);
			return user;
		}
		user = doctorWebService.getUserByDni(username);
		if (user != null) {
			roles.add(new Role("ROLE_EMPLOYEE"));
			user.setAuthorities(roles);
			return user;
		}
		return null;
	}

}
