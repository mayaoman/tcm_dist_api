package com.yention.tcm.api.utils;

/** 
 * @Package com.yention.tcm.api.utils
 * @ClassName: GenerateID
 * @Description: 获取唯一编号(20位)
 * @author 孙刚
 * @date 2019年4月19日 上午10:56:06
 */
public final class GenerateID {
	private GenerateID() {
	}

	/**
	 * @Title: getID
	 * @Description: 根据当前时间+六位随机数字拼装唯一编号
	 * @return String
	 */
	public static String getID() {
		int n = 0;
		n = (int) (Math.random() * 1000000);
		while (n < 100000 || !handle(n)) {
			n = (int) (Math.random() * 1000000);
		}
		long currentTimeMillis = System.currentTimeMillis();
		return "" + currentTimeMillis + "" + n;
	}

	/**
	 * @Title: getRandomCode
	 * @Description: 获得六位随机数字
	 * @return String
	 */
	public static String getRandomCode() {
		int n = 0;
		n = (int) (Math.random() * 1000000);
		while (n < 100000 || !handle(n)) {
			n = (int) (Math.random() * 1000000);
		}
		return "" + n;
	}

	private static boolean handle(int n) {
		int[] list = new int[6];
		for (int i = 0; i < 6; i++) {
			list[i] = n % 10;
			n = n / 10;
		}
		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				if (list[i] == list[j])
					return false;
			}
		}
		return true;
	}
}
