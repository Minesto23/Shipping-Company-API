package api.Shipping.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.Shipping.starter.resources.items.Item;
import api.Shipping.starter.service.ShippingService;


@RestController
public class ShippingController {

	
	@Autowired
	ShippingService shippingservice;
	
	@RequestMapping(method=RequestMethod.GET, value = "/products")
	public List<Item> getProducst() {
		
		return shippingservice.getorder();
	}
	
	@RequestMapping("/products/{name}")
	public Item getItem(@PathVariable String name) {
		return shippingservice.getItem(name);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/products")
	public void addOneTopic(@RequestBody Item item) {
			shippingservice.additem(item);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/shipping")
	public List<String> getShipping() {
		
		return shippingservice.best_shipping();	
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/products/{name}")
	public void deleteitem(@PathVariable String name) {
		shippingservice.deleteItem(name);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/products/{name}")
	public void updateItem(@PathVariable String name, @RequestBody Item item) {
		shippingservice.updateItem(name, item);
	}
	
	
	
	
}
