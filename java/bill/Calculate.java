package bill;

import java.util.List;

public interface Calculate {
	public boolean addReading(Appliances app);
	public boolean updateProduct(Appliances app);
	public List<Appliances > listApp();
	public Appliances getApp(int Id);
	public boolean deleteApp(Appliances app);
	public double costofdays(int units,float ratePerUnit,int noOfDays);
	public double costofMonths(int units,float ratePerUnit,int noOfDays);
	public double costofYears(int units,float ratePerUnit,int noOfDays);

}
