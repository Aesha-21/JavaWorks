package Hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value="ctx")
//@Table(name="checkper")

public class CheckTx extends Tx{
	
	@Override
	public String toString() {
		return "CheckTx [checkNo=" + checkNo + ", getId()=" + getId() + ", getAmt()=" + getAmt() + "]";
	}

	private int checkNo;
	
 public CheckTx() {}

public CheckTx(double amt, int checkNo) {
	super(amt);
	this.checkNo = checkNo;
}

public int getCheckNo() {
	return checkNo;
}

public void setCheckNo(int checkNo) {
	this.checkNo = checkNo;
}

}
