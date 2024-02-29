package devmaster.edu.vn.util;

import java.io.ObjectInputFilter.Config;
import java.lang.module.Configuration;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.SessionFactory;

public class HibernateUtil{
	private static SessionFactory sessionFactory;
	static {
		try {
			Configuration config = new Configuration().configure();
			ServiceRegistry reg=new StandardServiceRegistryBuilder().appleSettings(config.getProperties()).build();
			sessionFactory = config.buildSessinfactory(reg);
			
		}catch(Throwable ex) {
			ex.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}