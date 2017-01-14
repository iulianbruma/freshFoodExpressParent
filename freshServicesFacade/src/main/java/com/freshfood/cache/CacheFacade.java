package com.freshfood.cache;

import org.springframework.cache.Cache;

public class CacheFacade {
	
	private Cache cache;
	
	public CacheFacade(Cache cache) {
		this.cache = cache;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String key) {

		T object = (T) cache.get(key);
//		LOG.debug("get object={} from cache for key={}", object, key);
		//CacheManager cache;
		return object;
	}
}
