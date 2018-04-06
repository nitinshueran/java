package com.shu.nitin.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectPoolFactoryDemo {
	
	private int count;
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ObjectPoolFactoryDemo.class);

	public static void main(String[] args) {
		
		LOGGER.info("Creating connection pool of FileParserObject");
		ObjectPoolFactory factory = ObjectPoolFactory.getObjectPoolFactory();
		for(int i=0; i<100; i++) {
			
		}
		ObjectPoolFactoryDemo demo = (ObjectPoolFactoryDemo) factory.getObjectFromPool(ObjectPoolFactoryDemo.class);
		demo.count++;
		demo.success();
		
	}

	private void success() {
		LOGGER.info("Object accessed from Factory"+ count);
	}

}
