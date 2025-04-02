package Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Table(name="Tblper")

//@Inheritance(strategy = InheritanceType.JOINED)

//single table


@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="disc")  //it's store name of class
@DiscriminatorValue(value="tx")
@Table(name="allTxt")
public class Tx {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "txtseq")
	@SequenceGenerator(name="txtseq", sequenceName = "txt_seq",allocationSize = 1)
	private long id;
	private double amt;
	
	@ManyToOne(targetEntity = Account.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="account_id",referencedColumnName = "id") //here name will be column name of the current entity where refcolname will be parent
	private Account accounts;
	
	public Account getAccount() {
		return accounts;
	}
	
	public void setAccount(Account accounts) {
		this.accounts = accounts;
	}
	
	

	public Tx() {}
	
	
	public Tx(double amt) {
	
		this.amt = amt;
	}

	@Override
	public String toString() {
		return "Tx [id=" + id + ", amt=" + amt + ", account=" + accounts + "]";
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	

}
