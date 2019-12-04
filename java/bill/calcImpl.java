package bill;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository("Calculate")
@Transactional
public class calcImpl implements Calculate {
	@Autowired
	private SessionFactory sessionFactory;
	
	public calcImpl() {
		
	}

	public calcImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public double costofdays(int units,float ratePerUnit,int noOfDays)
	{
double result;
result=units*ratePerUnit*noOfDays;
return result;
	}
	
	public double costofMonths(int units,float ratePerUnit,int noOfDays) {
		double result;
		result=units*ratePerUnit*noOfDays*30;
		return result;
		
	}
	public double costofYears(int units,float ratePerUnit,int noOfDays) {
		double result;
		result=units*ratePerUnit*noOfDays*365;
		return result;
		
	}
	
	public boolean addReading(Appliances app) {
		try {
			sessionFactory.getCurrentSession().save(app);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	public boolean updateProduct(Appliances app) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(app);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	
	public List<Appliances > listApp() {
		return sessionFactory.getCurrentSession().createQuery("From Appliances").list();
		
	}
	
	public Appliances getApp(int Id) {
		Session session = sessionFactory.openSession();
		Appliances app = (Appliances) session.get(Appliances.class,Id);
		return app;
	}


	public boolean deleteApp(Appliances app) {
		try {
			sessionFactory.getCurrentSession().delete(app);
			return true;
		} catch (Exception e) {
			return false;
		}
	}



}
