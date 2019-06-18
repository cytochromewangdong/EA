package edu.mum.cs544.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import edu.mum.cs544.common.service.GlobalLockService;

@Component
public class CommonJob {

	@Autowired
	GlobalLockService globalLockService;


	@Scheduled(fixedRate = 5000, initialDelay = 10000)
	public void regularJobInLock() {
		boolean locked = globalLockService.captureLock(Thread.currentThread().getId());
		try {
			if (locked) {
				System.out.println("Only one");
			}
		} finally {
			globalLockService.releaseLock(locked, Thread.currentThread().getId());
		}
	}



	@Scheduled(cron = "0 0 23 * * *")
	public void fixTimeTask() {

	}
}
