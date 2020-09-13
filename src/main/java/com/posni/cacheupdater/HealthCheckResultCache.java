package com.posni.cacheupdater;

import java.io.Serializable;
import java.time.Instant;
import java.util.Optional;
import java.util.function.Supplier;

public class HealthCheckResultCache<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private T healthCheckResult;
	private long cacheSavedTime;
	private final long ttl;

	public HealthCheckResultCache(final long ttl) {
		this.ttl = ttl;
	}

	public synchronized T get() {
		if (this.healthCheckResult == null)
			return null;

		final long now = Instant.now().toEpochMilli();
		if (now - this.cacheSavedTime > this.ttl) {
			this.healthCheckResult = null;
			this.cacheSavedTime = 0;
			return null;
		}

		return this.healthCheckResult;
	}

	public synchronized void set(final T obj) {
		System.out.println("Inside Set: Setting the cache...");
		this.healthCheckResult = obj;
		this.cacheSavedTime = Instant.now().toEpochMilli();
	}
}