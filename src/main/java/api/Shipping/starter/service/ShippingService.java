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
package api.Shipping.starter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import api.Shipping.starter.resources.items.Item;
import api.Shipping.starter.resources.containers.BigContainer;
import api.Shipping.starter.resources.containers.SmallContainer;

@Service
public class ShippingService {
	
	private List<Item> order = new ArrayList<Item>(); // arraylist to store the order
	
	
	ShippingService(){
		
	}
	
	
	public void additem(Item item) {
		order.add(item);
	}

	public List<Item> getorder () {
		return this.order;
	}
	
	public void deleteItem(String name) {
		order.removeIf(item -> item.getName().equals(name));
	}
	
	public Item getItem(String name) {
		
    	return order.stream().filter(item -> item.getName().equals(name)).findFirst().get();	
	}
	
	public void updateItem(String name, Item item) {
		
    	//return order.stream().filter(item -> item.getName().equals(name)).findFirst().get();
		int index = order.indexOf(order.stream().filter(i -> i.getName().equals(name)).findFirst().get());
		order.set(index, item);
	}
	
	//method to calculate the total volume
	public double total_volume(List<Item> order) {
			
			double total_volume=0;
			
			for (Item item : order) {
				total_volume += item.getTotal_volume();
			}
			
			return total_volume;
	}
	
	// method to calculate the total weight
		public double total_weight(List<Item> order) {
			
			double total_weight=0;
			
			for (Item item : order) {
				total_weight += item.getTotal_weight();
			}
			
			return total_weight;
		}
		
		// method to calculate the price to pay for the shipping
		public int shipping_price(BigContainer bigcontainer, SmallContainer smallcontainer) {
			
			int shipping_price =0;
			
			shipping_price = bigcontainer.quantity_needed_getter()*bigcontainer.cost_getter() + smallcontainer.quantity_needed_getter()*smallcontainer.cost_getter();
			
			return shipping_price;
		}
		
		// method core of the app than calculate the best choice to shipping the items
		public ArrayList<String> best_shipping() {
			
			BigContainer bigcontainer = new BigContainer();
			SmallContainer smallcontainer = new SmallContainer();
			
			ArrayList<String> result = new ArrayList<>();
			
			double total_volume = this.total_volume(this.order);
			double total_weight = this.total_weight(this.order);
			
			
			if(total_volume<=smallcontainer.volume_getter()) {
				smallcontainer.quanity_needed_setter(1);
				smallcontainer.cost_setter(total_weight);
				
			}else if (total_volume>=smallcontainer.volume_getter() && total_volume<=bigcontainer.volume_getter()) {
				bigcontainer.quanity_needed_setter(1);
			}else {
				bigcontainer.quanity_needed_setter((int) (total_volume/bigcontainer.volume_getter()));
				
				if((total_volume%bigcontainer.volume_getter())<=smallcontainer.volume_getter()) {
					smallcontainer.quanity_needed_setter(1);
					smallcontainer.cost_setter(((total_volume%bigcontainer.volume_getter())/total_volume) * total_weight);
				}else {
					bigcontainer.quanity_needed_setter(1);
				}
			}
			
			
			result.add("\nnumber of big containers: " + bigcontainer.quantity_needed_getter());
			result.add("number of small containers: " + smallcontainer.quantity_needed_getter());
			result.add("number of items to ship: " + this.order.size());
			result.add("Total order Volume: " + total_volume + " m^3");
			result.add("Total order Weight: " + total_weight + " kg");
			
			result.add("Total price: " + this.shipping_price(bigcontainer, smallcontainer) + " Euros");
			
			return result;
			
		}
}
