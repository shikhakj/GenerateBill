package bill;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Appliances {
	@Id
	String Id;
	int units;
	float ratePerUnit;
	int noOfDays;
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public float getRatePerUnit() {
		return ratePerUnit;
	}
	public void setRatePerUnit(float ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;

}
	public String getId() {
		return Id;
	}
	public void setId(String Id) {
		Id = Id;
	}
}
