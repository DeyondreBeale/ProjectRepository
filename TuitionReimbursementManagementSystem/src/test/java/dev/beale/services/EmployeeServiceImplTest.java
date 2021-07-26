package dev.beale.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.beale.models.Employee;
import dev.beale.repositories.EmployeeRepo;
import dev.beale.repositories.EmployeeRepoImpl;

public class EmployeeServiceImplTest {

	private Employee a;

	@Before
	public void init() {
		a = new Employee();
		a.setId(101);
		a.setFirstName("Doctor");
		a.setLastName("Who");
		a.setUserName("DocWho");
		a.setPassword("000");
		a.setEmail("Tardis4Life@Time.com");
		a.setPhoneNumber(701);
		a.setTuitionAvailable(1000);
		a.setRole("benCo");
		a.setSupervisorId(102);
		a.setDepartHeadId(101);
		a.setBenCoId(100);

	}

	@Test
	public void testCreateEmployee() {
		EmployeeRepo ad = new EmployeeRepoImpl();
		EmployeeService es = new EmployeeServiceImpl(ad);
		Employee test = es.createEmployee(a);
		assertNotNull(test);
		assertEquals(test.getId(), 5);
	}

	@Test
	public void testGetEmployeeInt() {
		EmployeeRepo ad = new EmployeeRepoImpl();
		EmployeeService es = new EmployeeServiceImpl(ad);
		Employee test = es.getEmployee(101);
		assertNotNull(test);
		assertEquals(test.getId(), 101);
	}

	@Test
	public void testGetEmployeeName() {
		EmployeeRepo ad = new EmployeeRepoImpl();
		EmployeeService es = new EmployeeServiceImpl(ad);
		Employee test = es.getEmployee("DocWho");
		assertNotNull(test);
		assertEquals(test.getUserName(), "DocWho");
	}

	@Test
	public void testGetAllEmployees() {
		EmployeeRepo ad = new EmployeeRepoImpl();
		EmployeeService es = new EmployeeServiceImpl(ad);
		List<Employee> test = es.getAllEmployees();
		assertNotNull(test);
	}

	@Test
	public void testUpdateEmployeeEmployee() {
		EmployeeRepo ad = new EmployeeRepoImpl();
		EmployeeService es = new EmployeeServiceImpl(ad);
		Employee test = es.updateEmployee(a);
		assertEquals(test.getId(), 101);
	}

	@Test
	public void testDeleteEmployeeInt() {
		EmployeeRepo ad = new EmployeeRepoImpl();
		EmployeeService es = new EmployeeServiceImpl(ad);
		Employee test = es.deleteEmployee(101);
		assertEquals(a, test);
	}

}
