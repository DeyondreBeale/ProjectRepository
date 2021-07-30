package dev.beale.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dev.beale.models.Employee;
import dev.beale.util.HibernateUtil;

public class EmployeeRepoImpl implements EmployeeRepo {
	static final Logger log = Logger.getLogger(EmployeeRepoImpl.class);

	public Employee createEmployee(Employee a) {

		Session sess = HibernateUtil.getSession();
		try {
			sess.beginTransaction();
			a.setId(Integer.parseInt(sess.save(a).toString()));
			sess.getTransaction().commit();
			log.info("setting up a new employee");
		} catch (HibernateException e) {
			log.error("Hibernate couldn't create a employee");
			e.printStackTrace();
			sess.getTransaction().rollback();
			a = null;
		} finally {
			sess.close();
		}

		return a;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		Session sess = HibernateUtil.getSession();
		List<Employee> employees = null;
		try {
			// SELECT * FROM Employees
			// HQL - wants you to be able to just use your Java Classes.
			employees = sess.createQuery("FROM Employee").list();
			log.info("setting up a list of employees");
		} catch (HibernateException e) {
			log.error("couldn't create a list");
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return employees;
	}

	public Employee getEmployee(int id) {
		Session sess = HibernateUtil.getSession();
		Employee a = null;

		try {
			a = sess.get(Employee.class, id);
			log.info("getting the employee");
		} catch (HibernateException e) {
			log.error("couldnt get employee");
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return a;
	}

	@SuppressWarnings("deprecation")
	public Employee getEmployee(String name) {
		Session sess = HibernateUtil.getSession();
		Employee em = null;
		try {
			try {

				Criteria crit = sess.createCriteria(Employee.class);
				crit.add(Restrictions.eq("userName", name));

//			a = (Employee) crit.uniqueResult();			
				if (crit.list().size() > 0)
					em = (Employee) crit.list().get(0);
//			CriteriaQuery<Employee> crit = sess.getCriteriaBuilder().createQuery(Employee.class);
				log.info("Getting the employee by name");
			} catch (HibernateException e) {
				log.error("couldn't get the employee by name");
				e.printStackTrace();
			} finally {
				sess.close();
			}
		} catch (NumberFormatException e) {
			em = null;
		}

		return em;
	}

	public Employee updateEmployee(Employee change) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = sess.beginTransaction();
			sess.update(change);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}

		return change;
	}

	public Employee deleteEmployee(int id) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Employee em = sess.get(Employee.class, id);

		try {
			tx = sess.beginTransaction();
			sess.delete(em);
			tx.commit();
			log.info("setting up to delete employee");
		} catch (HibernateException e) {
			log.error("couldn't delete employee");
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}

		return em;
	}
}
