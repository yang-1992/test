package com.ctsi.vpn.util;

import java.util.*;

/**
 * 生成主键的工具类
 * @author liminqiang
 *
 */
public class PrimaryKeyBuild {

	private static Integer loopNum = Integer.valueOf("0");

	private static final int MAX_LOOPNUM = 999;

	private static final int MAX_REQNUM = 1000;

	private static int LEFT_MOVE_BIT = 1000;

	private static long ID_BAS = 100000L;

	/***
	 * 最多生成100个ID
	 * 
	 * @param reqNum
	 * @return
	 */
	public static List<Long> createIdAtMostOneHundred(int reqNum) {
		List<Long> list = new ArrayList<Long>();
		if (reqNum > 0) {
			int runNum = 1;
			if (reqNum > MAX_REQNUM) {
				if (reqNum % 100 == 0) {
					runNum = reqNum / MAX_REQNUM;
				} else {
					runNum = reqNum / MAX_REQNUM + 1;
				}
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			int tempnum = MAX_REQNUM < reqNum ? MAX_REQNUM : reqNum;
			int count = 0;
			int temploopNum = loopNum.intValue();
			for (int j = 0; j < runNum; j++) {
				for (int i = 0; i < tempnum; i++) {
					synchronized (loopNum) {
						if (temploopNum > MAX_LOOPNUM) {
							temploopNum = 1;
						} else {
							++temploopNum;
						}
						loopNum = Integer.valueOf(String.valueOf(temploopNum));
					}

					Date now = new Date();
					long time = now.getTime();
					String timeStr = String.valueOf(time);
					timeStr = timeStr.substring(1, timeStr.length());
					list.add(Long.valueOf(timeStr).longValue() * LEFT_MOVE_BIT
							+ ID_BAS + loopNum.longValue());
					count++;

				}
				tempnum = reqNum - count;
				tempnum = MAX_REQNUM < tempnum ? MAX_REQNUM : tempnum;
			}
		}
		return list;
	}

	/**
	 * 生成ID
	 * 
	 * @return
	 */
	public static long createId() {
		int count = 1;
		int result = count / MAX_REQNUM;
		int remainder = count % MAX_REQNUM;
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < result; i++) {
			list.addAll(createIdAtMostOneHundred(1000));
		}
		list.addAll(createIdAtMostOneHundred(remainder));

		Collections.sort(list, new Comparator<Long>() {
			public int compare(Long o1, Long o2) {
				long poor = o1.longValue() - o2.longValue();
				return (new Long(poor)).intValue();
			}
		});

		return list.get(0).longValue();
	}
}
