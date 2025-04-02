package Hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value="atx")
//@Table(name="atmper")

public class AtmTx extends Tx {

	@Override
	public String toString() {
		return "AtmTx [atm=" + atm + ", getId()=" + getId() + ", getAmt()=" + getAmt() + "]";
	}

	private int atm;

	public AtmTx() {}
	
	public AtmTx(double amt, int atm) {
		super(amt);
		this.atm = atm;
	}

	public int getAtm() {
		return atm;
	}

	public void setAtm(int atm) {
		this.atm = atm;
	}
	
}
