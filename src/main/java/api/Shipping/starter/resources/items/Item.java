/**
 *	Made by :
 *
 *	- Miguel Ernesto Morales Molina
	- Karim Moluh Seidou
	- Hadi Mustafa
	- Rayan Bou Hassan
	- Arman Islam

 * 
 **/
package api.Shipping.starter.resources.items;

public class Item {
	
	private String name; // variable to store item name
	private double weight;// variable to store item weight
	private double total_weight; // Variable to store total weight of one type of product
	private int quantity;// variable to store item quantity
	private double volume;// variable to store single item volume
	private double total_volume; // variable to store total volume of one kind of product
	private String shape;
	private double side;
	private double radius;
	private double height;
	private double lenght;
	private double width;
	
	public Item(String name, int quantity, double weight, String shape){
		
		this.name = name;
		
	
		this.quantity = quantity;
		
		
		this.weight = weight;
		
		this.total_weight = this.weight * this.quantity;
		
		this.shape = shape;
	}
	
	
	public Item() {
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getTotal_weight() {
		return total_weight;
	}
	public void setTotal_weight(double total_weight) {
		this.total_weight = total_weight;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getTotal_volume() {
		return total_volume;
	}
	public void setTotal_volume(double total_volume) {
		this.total_volume = total_volume;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
		this.total_weight();
		this.volume();
	}
	
	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}


	public double getRadius() {
		return radius;
	}


	public void setRadius(double radius) {
		this.radius = radius;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}

	public double getLenght() {
		return lenght;
	}


	public void setLenght(double lenght) {
		this.lenght = lenght;
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public void total_volume() {
		this.total_volume = this.volume*this.quantity;
	}
	
	public void total_weight() {
		this.total_weight = this.weight * this.quantity;
	}
	
	public void volume() {
		
		if(this.getShape().equals("cube")) {
			this.setVolume(this.side*3);
		} else if(this.getShape().equals("cylinder")) {
			this.setVolume(Math.PI*Math.pow(this.radius, 2)*this.height);
		} else if(this.getShape().equals("pentagon")) {
			this.setVolume((0.25)*(Math.sqrt(5*(5+2*Math.sqrt(5)))*(Math.pow(this.side, 2))*this.height));
		} else if(this.getShape().equals("rectangule")) {
			this.setVolume(this.lenght*this.height*this.width);
		}
		
		
		this.total_volume();
	}
	
	
}
