package com.shu.nitin.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Shipment implements Iterable<Shipment>{
	
	private List<Product> products = new ArrayList<>();
	
	private List<Product> lightProducts = new ArrayList<>();
	
	private List<Product> heavyProducts = new ArrayList<>();
	
	private static final int PRODUCT_NOT_PRESENT = -1;
	
	public void add(Product product) {
		products.add(product);
	}
	
	public void repalce(Product oldProduct, Product newProduct) {
		int index = products.indexOf(oldProduct);
		if(index != PRODUCT_NOT_PRESENT) {
			products.set(index, newProduct);
		}
	}
	
	public void prepare() {
		
		//check for weight greater then 20 for heavy products
		lightProducts = products.stream().sorted((Product p1, Product p2) -> {
			return p1.getWeight() - p2.getWeight();
		}).filter(p -> {
			if(p.getWeight() < 20) {
				return true;
			}else {
				heavyProducts.add(p);
				return false;
			}
			
		}).collect(Collectors.toList());
		
	}
	
	public void filterLightAndHeavyUsingInbuitJava8Method() {
		Map<Boolean, List<Product>> heavyAndLightProducts = products.stream().collect(Collectors.partitioningBy(p -> p.getWeight() > 20));
		heavyProducts = heavyAndLightProducts.get(true);
		lightProducts = heavyAndLightProducts.get(false);
	}

	@Override
	public Iterator<Shipment> iterator() {
		return null;
	}

	public List<Product> getLightProducts() {
		return lightProducts;
	}

	public List<Product> getHeavyProducts() {
		return heavyProducts;
	}
	
}
