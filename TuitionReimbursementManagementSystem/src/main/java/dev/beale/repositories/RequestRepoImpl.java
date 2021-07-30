package dev.beale.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dev.beale.models.Request;
import dev.beale.util.HibernateUtil;

public class RequestRepoImpl implements RequestRepo {

	static final Logger log = Logger.getLogger(RequestRepoImpl.class);

	public Request createRequest(Request a) {

		Session sess = HibernateUtil.getSession();
		try {
			sess.beginTransaction();
			a.setId(Integer.parseInt(sess.save(a).toString()));
			sess.getTransaction().commit();
			log.info("setting up a new Request");
		} catch (HibernateException e) {
			log.error("Hibernate couldn't create a Request");
			e.printStackTrace();
			sess.getTransaction().rollback();
			a = null;
		} finally {
			sess.close();
		}

		return a;
	}

	@SuppressWarnings("unchecked")
	public List<Request> getAllRequests(int id, int name) {
		Session sess = HibernateUtil.getSession();
		List<Request> Requests = null;

		if (id > 0 & name > 0) {
			switch (name) {
			case 1:
				log.info("Sets up and creates a list");
				try {
					Requests = sess.createQuery("FROM Request WHERE urgent = true").list();

				} catch (HibernateException e) {
					log.error("Hibernate couldn't create the list");
					e.printStackTrace();
				} finally {
					sess.close();
					log.info("Session closes");
				}
				break;

			case 2:
				log.info("Sets up and creates a list");
				try {
					Requests = sess.createQuery("FROM Request WHERE denied = true OR employees_id = " + id).list();

				} catch (HibernateException e) {
					log.error("Hibernate couldn't create a list");
					e.printStackTrace();
				} finally {
					sess.close();
					log.info("Session closes");
				}
				break;
			default:
				log.info("Sets up and creates a list");
				try {
					Requests = sess.createQuery("FROM Request").list();

				} catch (HibernateException e) {
					log.error("Hibernate couldn't create a list");
					e.printStackTrace();
				} finally {
					sess.close();
					log.info("Session closes");
				}
			}
		} else {
			log.info("creating list based on e_id");
			try {
				Requests = sess.createQuery("FROM Request WHERE employees_id = " + id).list();

			} catch (HibernateException e) {
				log.error("couldn't get list");
				e.printStackTrace();
			} finally {
				sess.close();
			}
		}
		return Requests;
	}

	public Request getRequest(int id) {
		Session sess = HibernateUtil.getSession();
		Request a = null;

		try {
			a = sess.get(Request.class, id);
			log.info("getting the Request");
		} catch (HibernateException e) {
			log.error("couldnt get Request");
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return a;
	}

	@SuppressWarnings("deprecation")
	public Request getRequest(String name) {
		Session sess = HibernateUtil.getSession();
		Request em = null;

		try {

			Criteria crit = sess.createCriteria(Request.class);
			crit.add(Restrictions.eq("userName", name));

//			a = (Request) crit.uniqueResult();			
			if (crit.list().size() > 0)
				em = (Request) crit.list().get(0);
//			CriteriaQuery<Request> crit = sess.getCriteriaBuilder().createQuery(Request.class);
			log.info("Getting the Request by name");
		} catch (HibernateException e) {
			log.error("couldn't get the Request by name");
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return em;
	}

	public Request updateRequest(Request change) {
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

	public Request deleteRequest(int id) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Request em = sess.get(Request.class, id);

		try {
			tx = sess.beginTransaction();
			sess.delete(em);
			tx.commit();
			log.info("setting up to delete Request");
		} catch (HibernateException e) {
			log.error("couldn't delete Request");
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}

		return em;
	}

}
