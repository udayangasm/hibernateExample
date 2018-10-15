package AOP.testHibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	Customer cus = new Customer();
    	cus.setName("udayanga");
    	cus.setNic("882553361V");
    	cus.setAddress("pilimathalawa");
    	cus.setTp("0714069926");
    	cus.setActive('Y');
    	cus.setCreatedDate(new Date());
		
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
    	  
    	SessionFactory factory = meta.getSessionFactoryBuilder().build();  
    	Session session = factory.openSession();  

		Transaction t = session.beginTransaction();
	

		session.persist(cus);

		t.commit();
		session.close();
		System.out.println("successfully saved");
		
		
    }
    
  
    
    
}

