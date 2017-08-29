package com.bjsxt.game;

public class Add {

	public static boolean addBoo = false;// 记录是否出现相加情况的布尔值
	public static int scoreAdd = 0;

	// 向左相加的方法
	public static int[][] left(int[][] leftrun) {
		for (int i = 0; i < 4; i++) { // 循环一次处理一行
			for (int j = 0; j < 3; j++) { // 循环一次处理一个元素
				// 若是左边的和右边的元素同值,则堆加到左边的值内.
				if (leftrun[i][j] != 0 && (leftrun[i][j] == leftrun[i][j + 1])) {
					Add.scoreAdd += leftrun[i][j];
					leftrun[i][j] = leftrun[i][j] * 2;
					leftrun[i][j + 1] = 0;
					// 如果出现了相加的情况,改变静态布尔值
					addBoo = true;
				}
			}
		}
		return leftrun;
	}

	//向右相加的方法
	public static int[][] right(int[][] leftrun) {
		for (int i = 0; i < 4; i++) { // 循环一次处理一行
			for (int j = 3; j > 0; j--) { // 循环一次处理一个元素
				// 若是右边的和左边的元素同值,则堆加到右边的值内.
				if (leftrun[i][j] != 0 && (leftrun[i][j] == leftrun[i][j - 1])) {
					Add.scoreAdd += leftrun[i][j];
					leftrun[i][j] = leftrun[i][j] * 2;
					leftrun[i][j - 1] = 0;
					// 如果出现了相加的情况,改变静态布尔值
					addBoo = true;
				}
			}
		}
		return leftrun;
	}

	//向上相加的方法
	public static int[][] up(int[][] leftrun) {
		for (int i = 0; i < 3; i++) { // 循环一次处理一行
			for (int j = 0; j < 4; j++) { // 循环一次处理一个元素
				// 若是上边的和下边的元素同值,则堆加到上边的值内.
				if (leftrun[i][j] != 0 && (leftrun[i][j] == leftrun[i+1][j])) {
					Add.scoreAdd += leftrun[i][j];
					leftrun[i][j] = leftrun[i][j] * 2;
					leftrun[i+1][j] = 0;
					// 如果出现了相加的情况,改变静态布尔值
					addBoo = true;
				}
			}
		}
		return leftrun;
	}

	//向下相加的
	public static int[][] down(int[][] leftrun) {
		for (int i = 3; i > 0; i--) { // 循环一次处理一行
			for (int j = 0; j < 4; j++) { // 循环一次处理一个元素
				// 若是上边的和下边的元素同值,则堆加到上边的值内.
				if (leftrun[i][j] != 0 && (leftrun[i][j] == leftrun[i-1][j])) {
					Add.scoreAdd += leftrun[i][j];
					leftrun[i][j] = leftrun[i][j] * 2;
					leftrun[i-1][j] = 0;
					// 如果出现了相加的情况,改变静态布尔值
					addBoo = true;
				}
			}
		}
		return leftrun;
	}

}
