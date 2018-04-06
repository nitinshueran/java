package com.shu.nitin.pool;

/**
 * The Interface defines methods that will handle connection pool to any object.
 */
public interface ObjectPool {

	
	/**
	 * This method will create an instance of the type passes to it.
	 *
	 * @param <T> the generic type
	 * @param type the type
	 * @return the t
	 */
	<T> T create(Class<T> type);

	/**
	 * This method will remove the object from available object list and mark it for garbage collection.
	 *
	 * @param o
	 *            the o
	 */
	void expire(Object o);

	/**
	 * This method will fetch the Object of class type passes to it from available Object pool.
	 *
	 * @param <T> the generic type
	 * @param type the type
	 * @return the object
	 */
	<T> Object getObjectFromPool(Class<T> type);

	
	/**
	 * This method will add the object to connection pool
	 *
	 * @param o the o
	 */
	void addObjectToPool(Object o);

}
