package com.javalec.worldCup;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.javalec.worldCup.dao.IContentDao;

@Component
public class ScheduleConfig {
	@Autowired
	private EhCacheCacheManager cacheManager;
	
	@Autowired
	private IContentDao dao;

	@Scheduled(cron = "0 0/1 * * * *")
	public void testSchedule() {
		List<Integer> keys = cacheManager.getCacheManager().getCache("win").getKeys();
		System.out.println(keys);
		if (keys.size() > 0) {
			for (Integer x : keys) {
				System.out.println(cacheManager.getCacheManager().getCache("win").get(x).getObjectValue());
				Map<String, Integer> m = (Map) cacheManager.getCacheManager().getCache("win").get(x).getObjectValue();
				for (String key : m.keySet()) {
					dao.update(x, key,m.get(key));
				}
			}
		}
		Objects.requireNonNull(cacheManager.getCache("win")).clear();
		Objects.requireNonNull(cacheManager.getCache("statistic")).clear();
		System.out.println(("[MYTEST] test batch " + LocalDateTime.now()));

	}
}
