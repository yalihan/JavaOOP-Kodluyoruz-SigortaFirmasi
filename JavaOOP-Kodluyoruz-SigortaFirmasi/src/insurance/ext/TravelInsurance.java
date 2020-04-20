package insurance.ext;

import java.time.LocalDate;
import insurance.Insurance;

public class TravelInsurance extends Insurance{
	@Override
	public double calculatePolicy(LocalDate beginDate, LocalDate finishDate) {
		int day = finishDate.getDayOfYear() - beginDate.getDayOfYear();
		return super.getInsruancePrice()*day;
	}
	@Override
	public String toString() {
		return "TravelInsurance\n[ InsruancePrice: "+super.getInsruancePrice()+ " , InsuranceBeginDate: "+super.getInsuranceBeginDate()
				+" , InsuranceFinishDate: "+super.getInsuranceFinishDate()+" ]";
	}
}
