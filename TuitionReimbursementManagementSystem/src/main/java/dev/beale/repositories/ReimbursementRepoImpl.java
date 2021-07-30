package dev.beale.repositories;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import dev.beale.models.Reimbursement;
import dev.beale.util.HibernateUtil;

public class ReimbursementRepoImpl implements ReimbursementRepo {

	static final Logger log = Logger.getLogger(ReimbursementRepoImpl.class);

	public Reimbursement createReimbursement(Reimbursement a) {
		Session sess = HibernateUtil.getSession();
		try {
			sess.beginTransaction();
			a.setId(Integer.parseInt(sess.save(a).toString()));
			sess.getTransaction().commit();
			log.info("Sets up and connects to make a reimbursement");
		} catch (HibernateException e) {
			log.error("Hibernate couldn't create reimbursement");
			e.printStackTrace();
			sess.getTransaction().rollback();
			a = null;
		} finally {
			sess.close();
			log.info("closes session");
		}

		return a;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Reimbursement> getAllReimbursement(int id, int name) {
		Session sess = HibernateUtil.getSession();
		List<Reimbursement> Reimbursements = null;

		if (id == -1) {
			switch (name) {
			case 1:
				log.info("Sets up and creates a list");
				try {
					Reimbursements = sess
							.createQuery("FROM Reimbursement WHERE supervisor_approved = false AND status = 'pending'")
							.list();

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
					Reimbursements = sess.createQuery(
							"FROM Reimbursement WHERE supervisor_approved = true AND departmenthead_approved = false AND status = 'pending'")
							.list();

				} catch (HibernateException e) {
					log.error("Hibernate couldn't create a list");
					e.printStackTrace();
				} finally {
					sess.close();
					log.info("Session closes");
				}
				break;
			case 3:
				log.info("Sets up and creates a list");
				try {
					Reimbursements = sess.createQuery(
							"FROM Reimbursement WHERE supervisor_approved = true AND departmenthead_approved = true AND coordinator_approved = false AND status = 'pending' OR (file_attachment = 1 AND coordinator_approved = true AND status != 'approved')")
							.list();

				} catch (HibernateException e) {
					log.error("Hibernate couldn't create the list");
					e.printStackTrace();
				} finally {
					sess.close();
					log.info("Session closes");
				}
				break;
			default:
				log.info("Sets up and creates a list");
				try {
					Reimbursements = sess.createQuery("FROM Reimbursement").list();

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
				Reimbursements = sess.createQuery("FROM Reimbursement WHERE e_id = " + id).list();

			} catch (HibernateException e) {
				log.error("couldn't get list");
				e.printStackTrace();
			} finally {
				sess.close();
			}
		}
		return Reimbursements;
	}

	public Reimbursement getReimbursement(int id) {
		Session sess = HibernateUtil.getSession();
		Reimbursement a = null;
		log.info("getting reimbursement by id");
		try {
			a = sess.get(Reimbursement.class, id);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return a;
	}

	@SuppressWarnings({ "deprecation" })
	public Reimbursement getReimbursement(int id, int rId) {
		Session sess = HibernateUtil.getSession();
		Reimbursement list = null;
		log.info("getting reimbursement based on id and eid");
		try {
			Criteria cr = sess.createCriteria(Reimbursement.class)
					.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
							.add(Projections.property("r_id"), "rId"))
					.setResultTransformer(Transformers.aliasToBean(Reimbursement.class));

			list = (Reimbursement) cr.uniqueResult();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return list;
	}

	@SuppressWarnings("deprecation")
	public Reimbursement getReimbursement(String name) {
		Session sess = HibernateUtil.getSession();
		Reimbursement a = null;
		log.info("Getting reimbursement by name");
		try {

			Criteria crit = sess.createCriteria(Reimbursement.class);
			crit.add(Restrictions.eq("name", name));

//			a = (Reimbursement) crit.uniqueResult();			
			if (crit.list().size() > 0)
				a = (Reimbursement) crit.list().get(0);
//			CriteriaQuery<Reimbursement> crit = sess.getCriteriaBuilder().createQuery(Reimbursement.class);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}

		return a;
	}

	public Reimbursement updateReimbursement(Reimbursement change) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		log.info("getting change to update reimbursement");
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

	public Reimbursement deleteReimbursement(int id) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Reimbursement a = sess.get(Reimbursement.class, id);
		log.info("getting delete info to delete");
		try {
			tx = sess.beginTransaction();
			sess.delete(a);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}

		return a;
	}
}
