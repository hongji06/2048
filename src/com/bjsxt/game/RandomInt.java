package com.bjsxt.game;

public class RandomInt {

	/**
	 * 在0的位置随机生成2或者4的方法
	 * 
	 * @param leftrun
	 * @return
	 */
	public static int[][] left(int[][] leftrun) {
		int a = 0;
		for (int i = 0; i < 4; i++) { // 循环一次执行一行
			for (int j = 0; j < 4; j++) {
				if (leftrun[i][j] == 0) {
					a++; // 记录数组内0的数量
				}
			}
		}
		// a值代表了数字块内此时0的值有多少个
		if (a == 0) {
			return leftrun;
		}
		// 通过a的值来确定是否在某一个位置生成数字
//		boolean boo = false; // 次布尔值用来管理已经添加过随机数的情况
		gogogo: for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (leftrun[i][j] == 0) { // 判断是否是0
					int ranbom = (int) (Math.random() * a + 1);
					if (ranbom % a == 0) { // 判断是否在此处生成数字
						int ranbom2 = (int) (Math.random() * 18 + 1);
						if (ranbom2 % 18 == 0) { // 判断生成2还是4
							leftrun[i][j] = 4;
						} else {
							leftrun[i][j] = 2;
						}
						return leftrun; // 生成完毕之后返回数组
					}
				}
				if (i == 3 && j == 3) { // 一次都没有生成过的话重新来过
					i = 0;
					continue gogogo;
				}
			}
		}
		return leftrun;
	}

	/**
	 * 初始化数字块的方法
	 * 
	 * @param csh
	 * @return
	 */
	public static int[][] csh(int[][] csh) {
		int a = 0; // 判断已经生成几个数字的变量
		gogogo: for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int ran = (int) (Math.random() * 16 + 1);// 随机数决定了是否在此处生成数字
				if (ran % 8 == 0) {
					int ran2 = (int) (Math.random() * 18 + 1);// 此随机数决定了是生成2还是4
					if (ran2 % 18 == 0) {
						csh[i][j] = 4;
					} else {
						csh[i][j] = 2;
					}
					a++;
					if (a == 2) { // 已经生成两个数字了的话则返回csh数组
						return csh;
					}
				}
				if (i == 3 && j == 3) {//如果到此处了还是不足两个的话则重头来过
					i = 0;
					continue gogogo;
				}
			}
		}
		return csh;
	}
}
