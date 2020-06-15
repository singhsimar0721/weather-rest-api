/**
 * 
 */
package com.service.weather.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Simarpreet Singh, created on 10 April 2020.
 * 
 * Cache Scheduler, to clear the cache after every ${clear.all.cache.fixed.rate} i.e. 2 Hours 
 * and with delay of time ${clear.all.cache.init.delay} i.e. immediately, after the application starts. 
 *
 */
@Component
public class ClearCacheScheduler {
	
	private static final Logger logger = LoggerFactory.getLogger(ClearCacheScheduler.class);

	@Autowired
	private CacheManager cacheManager;

	/**
	 * Scheduler method, to clear all the cache-regions being used in application since the application started.
	 * It will clear every after {fixedRatString} interval and after a delay of {initialDelayString} since the application started.
	 */
	@Scheduled(fixedRateString = "${clear.all.cache.fixed.rate}", initialDelayString = "${clear.all.cache.init.delay}") 
	public void reportCurrentTime() {
		logger.info("Scheduler: Clearing all the cache-regions");
		cacheManager.getCacheNames().parallelStream().forEach(name -> cacheManager.getCache(name).clear());
		logger.info("Scheduler: Cache cleared successfully!");
	}
}
