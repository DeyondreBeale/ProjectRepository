package dev.beale.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dev.beale.models.Employee;

public class EmployeeRepoImplTest {

	private Employee a;

	@Before
	public void init() {
		a = new Employee();
		a.setId(100);
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
		Employee test = ad.createEmployee(a);
		assertNotNull(test);
		assertEquals(test.getId(), 5);
	}

	@Test
	public void testGetEmployeeInt() {
		EmployeeRepo ad = new EmployeeRepoImpl();
		Employee test = ad.getEmployee(1);
		assertNotNull(test);
		assertEquals(test.getFirstName(), "Dee");
	}

	@Test
	public void testGetEmployeeName() {
		EmployeeRepo ad = new EmployeeRepoImpl();
		Employee test = ad.getEmployee("DocWho");
		assertNotNull(test);
		assertEquals(test.getUserName(), "DocWho");
	}

	@Test
	public void testGetAllEmployees() {
		EmployeeRepo ad = new EmployeeRepoImpl();
		List<Employee> test = ad.getAllEmployees();
		assertNotNull(test);
	}

	@Test
	public void testUpdateEmployeeEmployee() {
		EmployeeRepo ad = new EmployeeRepoImpl();
		Employee current = ad.getEmployee(3);
		Employee test = ad.updateEmployee(current);
		assertNotNull(test);
	}

	@Test
	public void testDeleteEmployeeInt() {
		EmployeeRepo ad = new EmployeeRepoImpl();
		Employee test = ad.deleteEmployee(100);
		assertNotNull(test);
	}

}
