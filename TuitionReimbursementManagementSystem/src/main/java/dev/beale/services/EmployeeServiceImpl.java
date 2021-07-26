package dev.beale.services;

import java.util.List;

import dev.beale.models.Employee;
import dev.beale.repositories.EmployeeRepo;

public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeRepo cd;

	public EmployeeServiceImpl(EmployeeRepo cd) {
		this.cd = cd;
	}

	@Override
	public Employee createEmployee(Employee c) {
		return cd.createEmployee(c);
	}

	@Override
	public Employee getEmployee(int id) {
		return cd.getEmployee(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return cd.getAllEmployees();
	}

	@Override
	public Employee updateEmployee(Employee change) {
		return cd.updateEmployee(change);
	}

	@Override
	public Employee deleteEmployee(int id) {
		return cd.deleteEmployee(id);
	}

	@Override
	public Employee getEmployee(String name) {
		return cd.getEmployee(name);
	}
}
