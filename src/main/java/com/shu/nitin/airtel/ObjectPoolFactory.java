package com.shu.nitin.airtel;

import java.util.Hashtable;

public class ObjectPoolFactory implements ObjectPool {
	
	long expirationTime;

	Hashtable<Object, Boolean> locked;
	
	Hashtable<Object, Boolean> unlocked;
	
	public ObjectPoolFactory() {
		locked = new Hashtable<>();
		unlocked = new Hashtable<>();
	}

	@Override
	public Object create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validate(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void expire(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object checkOut() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkIn(Object o) {
		// TODO Auto-generated method stub

	}

	public long getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(long expirationTime) {
		this.expirationTime = expirationTime;
	}

	public Hashtable<Object, Boolean> getLocked() {
		return locked;
	}

	public void setLocked(Hashtable<Object, Boolean> locked) {
		this.locked = locked;
	}

	public Hashtable<Object, Boolean> getUnlocked() {
		return unlocked;
	}

	public void setUnlocked(Hashtable<Object, Boolean> unlocked) {
		this.unlocked = unlocked;
	}

	
	
	

}
