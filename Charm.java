
public class Charm {
	private String name;
	private double price;
	
	@Override
	public String toString(){
		return getName();
	}
	
	Charm(){
		this("", 0.00);
	}
	
	Charm(String name, double price){
		this.setName(name);
		this.setPrice(price);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double price() {
		return price;
	}
	
}
