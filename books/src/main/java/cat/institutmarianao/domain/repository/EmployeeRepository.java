package cat.institutmarianao.domain.repository;

import java.util.List;

import cat.institutmarianao.domain.Employee;

public interface EmployeeRepository {

	List<Employee> getAll();

	void add(Employee personeel);

	void update(Employee personeel);

	void delete(Employee personeel);

	Employee getUserByDni(Employee personeel);

	Employee getuserByMediCard(Employee personeel);

}
