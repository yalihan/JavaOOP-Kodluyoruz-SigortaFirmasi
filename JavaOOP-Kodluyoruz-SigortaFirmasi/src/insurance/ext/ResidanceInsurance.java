package insurance.ext;

import java.time.LocalDate;
import insurance.Insurance;

public class ResidanceInsurance extends Insurance {
	@Override
	public double calculatePolicy(LocalDate beginDate, LocalDate finishDate) {
		int day = finishDate.getDayOfYear() - beginDate.getDayOfYear();
		return super.getInsruancePrice()*day*3;
	}
	@Override
	public String toString() {
		return "ResidanceInsurance\n[ InsruancePrice: "+super.getInsruancePrice()+ " , InsuranceBeginDate: "+super.getInsuranceBeginDate()
				+" , InsuranceFinishDate: "+super.getInsuranceFinishDate()+" ]";
	}
}
