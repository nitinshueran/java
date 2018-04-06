package com.shu.nitin.airtel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class provides implementation to all methods that will orchestrate object pool
 */
public class ObjectPoolFactory implements ObjectPool {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ObjectPoolFactory.class);

	/** The factory. */
	private static ObjectPoolFactory factory;

	/** The expiration time. */
	long expirationTime;

	/** The locked. */
	Hashtable<Object, Long> inUseObjects;

	/** The unlocked. */
	Hashtable<Object, Long> availableObjects;

	/**
	 * Instantiates a new object pool factory.
	 */
	private ObjectPoolFactory() {

		expirationTime = 30000;
		inUseObjects = new Hashtable<>();
		availableObjects = new Hashtable<>();
	}

	/**
	 * Gets the object pool factory.
	 *
	 * @return the object pool factory
	 */
	public static ObjectPoolFactory getObjectPoolFactory() {
		if (null == factory) {
			factory = new ObjectPoolFactory();
		}
		return factory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shu.nitin.fileparser.pool.ObjectPool#create()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T create(Class<T> type) {
		Constructor<T> cons = null;
		try {
			cons = type.getConstructor();
		} catch (NoSuchMethodException | SecurityException e1) {
			LOGGER.error("Error occured while instantiating class");
		}
		Object object = null;
		try {
			object = cons.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			LOGGER.error("Error occured while instantiating class");
		}
		return (T) object;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shu.nitin.fileparser.pool.ObjectPool#expire(java.lang.Object)
	 */
	@Override
	public void expire(Object object) {
		availableObjects.remove(object);
		object = null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shu.nitin.fileparser.pool.ObjectPool#checkOut()
	 */
	@Override
	synchronized public <T> Object getObjectFromPool(Class<T> type) {
		long now = System.currentTimeMillis();
		Object pooledObject;
		if (availableObjects.size() > 0) {
			Enumeration<Object> e = availableObjects.keys();
			while (e.hasMoreElements()) {
				pooledObject = e.nextElement();
				if ((now - ((Long) availableObjects.get(pooledObject)).longValue()) > expirationTime) {
					// object has expired
					expire(pooledObject);
				} else {
					availableObjects.remove(pooledObject);
					inUseObjects.put(pooledObject, new Long(now));
					return (pooledObject);
				}
			}
		}
		// no objects available, create a new one
		pooledObject = create(type);
		inUseObjects.put(pooledObject, new Long(now));
		return (pooledObject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shu.nitin.fileparser.pool.ObjectPool#checkIn(java.lang.Object)
	 */
	@Override
	synchronized public void addObjectToPool(Object o) {
		inUseObjects.remove(o);
		availableObjects.put(o, new Long(System.currentTimeMillis()));

	}

}
