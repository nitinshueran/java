package com.shu.nitin.collection;

public class CollectionDemo {

	public static void main(String[] args) {
		Shipment shipment = new Shipment();
		shipment.add(StaticProducts.DOOR);
		shipment.add(StaticProducts.WINDOW);
		shipment.add(StaticProducts.TABLE);
		
		//shipment.prepare();
		
		shipment.filterLightAndHeavyUsingInbuitJava8Method();
		System.out.println("Light Products: "+shipment.getLightProducts());
		System.out.println("Heavy Products: "+shipment.getHeavyProducts());
	}

}
