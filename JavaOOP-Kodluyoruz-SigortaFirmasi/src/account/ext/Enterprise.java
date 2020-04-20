package account.ext;

import java.time.LocalDate;
import java.util.ArrayList;
import account.Account;
import insurance.Insurance;
import user.User;

public class Enterprise extends Account {
	public Enterprise(User user) {
		super(user);
	}
	@Override
	public void addPolicy(ArrayList<Insurance> insuranceList,Insurance insurance,LocalDate beginDate,LocalDate finishDate) {
		insurance.setInsruancePrice(3.0);
		insurance.calculatePolicy(beginDate, finishDate);
		super.insuranceList.add(insurance);
	}

	@Override
	public int compareTo(Account account) {
		return super.getUser().getName().compareTo(account.getUser().getName());
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}
