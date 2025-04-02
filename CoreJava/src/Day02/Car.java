package Day02;
public class Car implements Cloneable{

	private String make;
	private String model;
	private int year;
	private int version;
	private int variant;
	
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getVariant() {
		return variant;
	}
	public void setVariant(int variant) {
		this.variant = variant;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String make, String model, int year, int version, int variant) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.version = version;
		this.variant = variant;
	}
	
	
	//Carbuilder ex for builder design
	
	public static CarBuilder builder() {
		return new CarBuilder(new Car());
	}
	
	
	
	//clone method
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	//equal method
	@Override
	public boolean equals(Object obj) {
		/* if object is car */
		if(!(obj instanceof Car)) return false;
		Car car = (Car) obj;
		//compare object
		return year == car.year && version == car.version && variant == car.variant && make.equals(car.make)
				&& model.equals(car.model) && make.equals(car.make);
	}
	
	@Override
	public String toString() {
		//return make +" "+model+" "+year+" "+version+" "+variant;
		return new StringBuilder()
				.append(make)
				.append(" ")
				.append(model)
				.append(" ")
				.append(year)
				.append(" ")
				.append(version)
				.append(" ")
				.append(variant)
				.toString();
	}
	
	//hashcode
	public int hashcode() {
		return (toString()+"Car").hashCode();
	}
	
	
	//ex of builder design pattern
	public static class CarBuilder {
		
		private Car car;
		
		public CarBuilder(Car car) {
			this.car=car;
		}
		
		public Car build() {
			return car;
		}
		
		public CarBuilder make(String make) {
			car.setMake(make);
			return this;
		}
		
		public CarBuilder model(String model) {
			car.setModel(model);
			return this;
		}
		
		public CarBuilder year(int year) {
			car.setYear(year);
			return this;
		}
		
		public CarBuilder version(String version) {
			car.setMake(version);
			return this;
		}
		
		public CarBuilder variant(String variant) {
			car.setMake(variant);
			return this;
		}
		
		
		
	}
	
	
	
	
}