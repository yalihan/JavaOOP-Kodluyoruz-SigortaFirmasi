package insurance.ext;

import java.time.LocalDate;
import insurance.Insurance;

public class HealthInsurance extends Insurance {
	@Override
	public double calculatePolicy(LocalDate beginDate, LocalDate finishDate) {
		int day = finishDate.getDayOfYear() - beginDate.getDayOfYear();
		return super.getInsruancePrice()*day*4;
	}
	@Override
	public String toString() {
		return "HealthInsurance\n[ InsruancePrice: "+super.getInsruancePrice()+ " , InsuranceBeginDate: "+super.getInsuranceBeginDate()
				+" , InsuranceFinishDate: "+super.getInsuranceFinishDate()+" ]";
	}
}
