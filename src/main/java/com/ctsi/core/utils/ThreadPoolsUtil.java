package com.ctsi.core.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolsUtil {

	private static ExecutorService cachedThreadPool = new ThreadPoolExecutor(10, 100, 60L, TimeUnit.SECONDS,
			new LinkedBlockingQueue<Runnable>());

	public static void addTask(Runnable task) {
		try {
			cachedThreadPool.execute(task);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
