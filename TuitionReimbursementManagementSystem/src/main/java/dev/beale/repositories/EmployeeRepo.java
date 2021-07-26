package dev.beale.repositories;

import java.util.List;

import dev.beale.models.Employee;

public interface EmployeeRepo {

	public Employee createEmployee(Employee e);

	public List<Employee> getAllEmployees();

	public Employee getEmployee(int id);

	public Employee getEmployee(String name);

	public Employee updateEmployee(Employee change);

	public Employee deleteEmployee(int id);
}
