package dev.beale.services;

import java.util.List;

import dev.beale.models.Employee;

public interface EmployeeService {

	public Employee getEmployee(String name);

	public Employee getEmployee(int id);

	public List<Employee> getAllEmployees();

	public Employee createEmployee(Employee m);

	public Employee updateEmployee(Employee change);

	public Employee deleteEmployee(int id);

}
