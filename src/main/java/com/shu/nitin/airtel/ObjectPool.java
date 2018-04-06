package com.shu.nitin.airtel;


// TODO: Auto-generated Javadoc
/**
 * The Interface ObjectPool.
 */
public interface ObjectPool {

	/**
	 * Creates the.
	 *
	 * @return the object
	 */
	Object create();

	/**
	 * Validate.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	boolean validate(Object o);

	/**
	 * Expire.
	 *
	 * @param o the o
	 */
	void expire(Object o);

	/**
	 * Check out.
	 *
	 * @return the object
	 */
	Object checkOut();

	/**
	 * Check in.
	 *
	 * @param o the o
	 */
	void checkIn( Object o );

}
