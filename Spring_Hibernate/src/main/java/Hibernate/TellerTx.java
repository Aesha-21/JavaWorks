package Hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value="ttx")
//@Table(name="tellerper")

public class TellerTx extends Tx {
	
	
	@Override
	public String toString() {
		return "TellerTx [teller=" + teller + ", branch=" + branch + ", getId()=" + getId() + ", getAmt()=" + getAmt()
				+ "]";
	}

	private String teller;
	private String branch;
	
	public TellerTx() {}
	
	public TellerTx(double amt, String teller, String branch) {
		super(amt);
		this.teller = teller;
		this.branch = branch;
	}
	
	public String getTeller() {
		return teller;
	}

	public void setTeller(String teller) {
		this.teller = teller;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	
	
	

	
}
