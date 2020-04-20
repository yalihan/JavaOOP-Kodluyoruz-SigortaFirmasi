package insurance;

import java.time.LocalDate;

public abstract class Insurance {
	String insuranceType;
	double insruancePrice;
	LocalDate insuranceBeginDate;
	LocalDate insuranceFinishDate;
	
	public String getInsuranceType() {
		return insuranceType;
	}
	public double getInsruancePrice() {
		return insruancePrice;
	}
	public LocalDate getInsuranceBeginDate() {
		return insuranceBeginDate;
	}
	public LocalDate getInsuranceFinishDate() {
		return insuranceFinishDate;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public void setInsruancePrice(double insruancePrice) {
		this.insruancePrice = insruancePrice;
	}
	public void setInsuranceBeginDate(LocalDate insuranceBeginDate) {
		this.insuranceBeginDate = insuranceBeginDate;
	}
	public void setInsuranceFinishDate(LocalDate insuranceFinishDate) {
		this.insuranceFinishDate = insuranceFinishDate;
	}

	
	public abstract double calculatePolicy(LocalDate beginDate,LocalDate finishDate);

	public abstract String toString();

	
}
