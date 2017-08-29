package com.bjsxt.game;

public class Move {
	
	public static boolean moveBoo = false; // 记录是否出现移动的布尔值
	// 向左对齐的方法

	public static int[][] left(int[][] leftrun) {
		for (int z = 1; z <= 4; z++) { // 对齐四次
			for (int i = 0; i < 4; i++) { // 循环一次走一行
				for (int j = 0; j < 3; j++) { // 循环一次处理一个元素
					if (leftrun[i][j] == 0 && leftrun[i][j + 1] != 0) { // 如果该元素的值为0的话向左移动一位
						leftrun[i][j] = leftrun[i][j + 1];
						leftrun[i][j + 1] = 0;
						// 如果交换 了一次的话改变静态布尔值
						Move.moveBoo = true;
					}
				}
			}
		}
		return leftrun;
	}

	// 向右对齐的方法
	public static int[][] right(int[][] leftrun) {
		for (int z = 1; z <= 4; z++) { // 对齐四次
			for (int i = 0; i < 4; i++) { // 循环一次走一行
				for (int j = 1; j < 4; j++) { // 循环一次处理一个元素
					if (leftrun[i][j] == 0 && leftrun[i][j - 1] != 0) { // 如果该元素的值为0的话向右移动一位
						leftrun[i][j] = leftrun[i][j - 1];
						leftrun[i][j - 1] = 0;
						// 如果交换 了一次的话改变静态布尔值
						Move.moveBoo = true;
					}
				}
			}
		}
		return leftrun;
	}

	// 向上对齐的方法
	public static int[][] up(int[][] leftrun) {
		for (int z = 1; z <= 4; z++) { // 对齐四次
			for (int i = 0; i < 3; i++) { // 循环一次走一行
				for (int j = 0; j < 4; j++) { // 循环一次处理一个元素
					if (leftrun[i][j] == 0 && leftrun[i + 1][j] != 0) { // 如果该元素的值为0的话向上移动一位
						leftrun[i][j] = leftrun[i + 1][j];
						leftrun[i + 1][j] = 0;
						// 如果交换 了一次的话改变静态布尔值
						Move.moveBoo = true;
					}
				}
			}
		}
		return leftrun;
	}

	// 向下对齐的方法
	public static int[][] down(int[][] leftrun) {
		for (int z = 1; z <= 4; z++) { // 对齐四次
			for (int i = 3; i > 0; i--) { // 循环一次走一行
				for (int j = 0; j < 4; j++) { // 循环一次处理一个元素
					if (leftrun[i][j] == 0 && leftrun[i - 1][j] != 0) { // 如果该元素的值为0的话向下移动一位
						leftrun[i][j] = leftrun[i - 1][j];
						leftrun[i - 1][j] = 0;
						// 如果交换 了一次的话改变静态布尔值
						Move.moveBoo = true;
					}
				}
			}
		}
		return leftrun;
	}

}
