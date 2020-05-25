package es.institutmarianao.service;

import java.util.List;

import es.institutmarianao.domain.Employee;

public interface EmployeeService {

	List<Employee> getAll();

	void add(Employee personeel);

	void update(Employee personeel);

	void delete(Employee personeel);

	Employee getUserByDni(Employee personeel);

	Employee getuserByMediCard(Employee personeel);

}
