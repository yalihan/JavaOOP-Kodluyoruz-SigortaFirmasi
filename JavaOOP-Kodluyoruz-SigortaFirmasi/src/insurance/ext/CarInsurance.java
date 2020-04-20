package insurance.ext;

import java.time.LocalDate;
import insurance.Insurance;

public class CarInsurance extends Insurance {
	@Override
	public double calculatePolicy(LocalDate beginDate, LocalDate finishDate) {
		int day = finishDate.getDayOfYear() - beginDate.getDayOfYear();
		return super.getInsruancePrice()*day*2;
	}
	@Override
	public String toString() {
		return "CarInsurance\n[ InsruancePrice: "+super.getInsruancePrice()+ " , InsuranceBeginDate: "+super.getInsuranceBeginDate()
				+" , InsuranceFinishDate: "+super.getInsuranceFinishDate()+" ]";
	}
}
