package Day03;

public enum Month {
	
	JANUARY(30),FEB(28),March(31),APRIL(30),MAY(31),JUN(30),JULY(31),AUG(30),
	SEP(31),OCT(30),NOV(31),DEC(30);
	private int noOfDays;
	
	Month(int noOfDays){
		this.noOfDays = noOfDays;
	}

	@Override
	public String toString() {
		return "Month" + name() + "No of days" + noOfDays ;
	}
	
	public static void main(String[] args) {
		for(Month m : Month.values()) {
		 System.out.println(m);
		 }
	}
}
