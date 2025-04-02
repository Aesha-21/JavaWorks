package Hibernate;

import java.lang.annotation.Inherited;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Account {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "accseq")
	@SequenceGenerator(name = "accseq",sequenceName = "acc_seq",allocationSize = 1)
	private long id;
	private double balance;
	private String type;
	
	@ManyToMany(targetEntity = Customer.class,fetch = FetchType.LAZY,mappedBy = "accounts")
	private Set<Customer> customers;
	
	public Set<Customer> getCustomers() {
		return customers;
	}
	
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	
	public void removeTx(Tx tx) {
		txs.remove(tx);
		tx.setAccount(null);
	}
	
	public void addTx(Tx tx) {
		if(txs==null) 
			txs =new HashSet<Tx>();
		txs.add(tx);
		tx.setAccount(this);
		
	}
	
	@OneToMany(targetEntity = Tx.class,mappedBy = "accounts",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Tx> txs;
	
	
	public Set<Tx> getTxs() {
		return txs;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", type=" + type + "]";
	}

	public void setTxs(Set<Tx> txs) {
		this.txs = txs;
	}
	
	public Account() {}
	
	public Account(long id, double balance, String type) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
