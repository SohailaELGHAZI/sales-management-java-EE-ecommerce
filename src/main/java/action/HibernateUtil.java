package action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory=buildSessionFactory();
	private static ServiceRegistry serviceRegistry;
	private static Session session = null;

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate_stock.cfg.xml");
			configuration.configure("hibernate_v.cfg.xml");
			
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

			return configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static Session openSession() {
		return sessionFactory.openSession();
	}
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	public static void close() {
		if (sessionFactory != null){
			sessionFactory.close();
		}
		sessionFactory = null;
	}
}