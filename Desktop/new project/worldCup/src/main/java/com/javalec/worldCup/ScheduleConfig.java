package com.javalec.worldCup;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.javalec.worldCup.dao.ContentRepository;
import com.javalec.worldCup.dto.ContentDto;

@Component
public class ScheduleConfig {
	@Autowired
	private EhCacheCacheManager cacheManager;

	@Autowired
	private ContentRepository repo;

	@Scheduled(cron = "0/30 * * * * *")
	@Transactional
	public void testSchedule() {

		List<Integer> keys = cacheManager.getCacheManager().getCache("win").getKeys();

		if (keys.size() > 0) {
			for (Integer x : keys) {
				Map<String, Integer> m = (Map) cacheManager.getCacheManager().getCache("win").get(x).getObjectValue();

				for (String key : m.keySet()) {

					ContentDto dto = repo.findByIdandName(x, key);
					dto.setWin(dto.getWin() + m.get(key));

				}
			}
		}
		Objects.requireNonNull(cacheManager.getCache("win")).clear();
		Objects.requireNonNull(cacheManager.getCache("statistic")).clear();
		System.out.println(("[MYTEST] test batch " + LocalDateTime.now()));

	}
}
