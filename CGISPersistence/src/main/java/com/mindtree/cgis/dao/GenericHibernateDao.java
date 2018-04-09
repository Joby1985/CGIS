package com.mindtree.cgis.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.orm.hibernate4.SpringSessionContext;

public abstract class GenericHibernateDao<T, ID extends Serializable> {

	private static final Logger log = Logger
			.getLogger(GenericHibernateDao.class);

	private Class<T> persistentClass = null;

	private Session session;

	@SuppressWarnings("unchecked")
	public GenericHibernateDao() {
		Type returnType = getClass().getGenericSuperclass();

		if (returnType instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) returnType;
			this.persistentClass = (Class<T>) pt.getActualTypeArguments()[0];
		}
	}

	public abstract SessionFactory getSessionFactory();

	@SuppressWarnings("unchecked")
	public ID create(T entity) {
		return (ID) getSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	public T get(ID id) {
		//session.getSessionFactory().getCurrentSession();
		if (id == null) {
			return null;
		}
		System.out.println("\n THIS is WHAT: getSession()="+getSession());
		return (T) getSession().get(persistentClass, id);
	}

	public void update1(T entity) {
		if (this.session == null) {
			this.session = getSession();
		}

		try {
			session.update(entity);
			// session.flush();
			// session.clear();
			// session.beginTransaction().commit();
		} catch (HibernateException e) {

			e.printStackTrace();
		} finally {
			if (session != null) {
				// session.close();
			}
		}
	}

	public void update(T entity) {
		Session session = getSession();
		if (session != null) {
			try {

				session.update(entity);
				// session.flush();
				// session.clear();
				// session.beginTransaction().commit();
			} catch (HibernateException e) {

				e.printStackTrace();
			} finally {
				if (session != null) {
					// session.close();
				}
			}
		}
	}

	public void replicate(T entity) {
		getSession().replicate(entity, ReplicationMode.OVERWRITE);
	}

	public void delete(T entity) {

		getSession().delete(entity);
	}

	public boolean save(T entity) {

		try {
			//System.out.println("insise save method.............." + entity);
			this.session = getSession();
			// Transaction tx = session.beginTransaction();

			getSession().save(entity);
			// session.flush();
			// session.clear();
			// tx.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block

			log.error("save" + e);
			e.printStackTrace();
			return false;
		} finally {

			if (session != null) {
				// session.close();
			}
		}

	}

	public void setSession() {
		this.session = getSession();
	}

	public void saveDataList(List<T> dataList) {
		Session session = getSession();

		int i = 0;
		try {
			if (session != null) {

				// Transaction tx = session.beginTransaction();
				for (T data : dataList) {
					T entity = data;
					session.save(entity);

					if (i % 50 == 0) {

						session.flush();
						session.clear();

					}
					i++;
				}

				// tx.commit();
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (session != null) {
				// session.close();
			}
		}

	}


	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	public void evict(T entity) {
		getSession().evict(entity);
	}

	protected Class<T> getPersistentClass() {
		return persistentClass;
	}

	protected Session getSession() {
		Session currentSession = getSessionFactory().openSession();
		/*try {
			if (log.isTraceEnabled()) {
				@SuppressWarnings("deprecation")
				Connection jdbcConnection = currentSession.connection();
				if (jdbcConnection != null && !jdbcConnection.isClosed()) {
					log.trace("JDBC Connection parameters: TransactionIsolation="
							+ jdbcConnection.getTransactionIsolation()
							+ ", ReadOnly="
							+ jdbcConnection.isReadOnly()
							+ ", AutoCommit=" + jdbcConnection.getAutoCommit());
				}
			}
		} catch (HibernateException e) {
			if (log.isTraceEnabled()) {
				log.error(e.toString());
			}
		} catch (SQLException e) {
			if (log.isTraceEnabled()) {
				log.error(e.toString());
			}
		}*/

		return currentSession;
	}

	protected void closeSession() {
		Session session = getSession();
		if (session != null) {
			// session.close();
			// session = null;
		}
	}
	 
}
