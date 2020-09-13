package com.posni.cacheupdater;

import java.io.Serializable;
import java.time.Instant;

/**
 * The actual cache class with a TTL.
 * @param <T>
 */
public class Cache<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private T value;//The value stored in cache
	private long cacheSavedTime;//Epoch time as and when the cache is saved in value
	private final long ttl;//the maxismum amount of time in ms for which the cache has to be stored

	public Cache(final long ttl) {
		this.ttl = ttl;
	}

	public synchronized T get() {
		if (this.value == null)
			return null;

		//Before returning the value, if value's age is less than TTL, then return null
		final long now = Instant.now().toEpochMilli();
		if (getCacheAge(now) > this.ttl) {
			this.value = null;
			this.cacheSavedTime = 0;
			return null;
		}

		return this.value;
	}

	private long getCacheAge(long now) {
		return now-this.cacheSavedTime;
	}

	public synchronized void set(final T obj) {
		System.out.println("Inside Set: Setting the cache...");
		this.value = obj;
		this.cacheSavedTime = Instant.now().toEpochMilli();
	}
}