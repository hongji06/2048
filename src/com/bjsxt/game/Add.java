package com.bjsxt.game;

public class Add {

	public static boolean addBoo = false;// ��¼�Ƿ�����������Ĳ���ֵ
	public static int scoreAdd = 0;

	// ������ӵķ���
	public static int[][] left(int[][] leftrun) {
		for (int i = 0; i < 4; i++) { // ѭ��һ�δ���һ��
			for (int j = 0; j < 3; j++) { // ѭ��һ�δ���һ��Ԫ��
				// ������ߵĺ��ұߵ�Ԫ��ֵͬ,��Ѽӵ���ߵ�ֵ��.
				if (leftrun[i][j] != 0 && (leftrun[i][j] == leftrun[i][j + 1])) {
					Add.scoreAdd += leftrun[i][j];
					leftrun[i][j] = leftrun[i][j] * 2;
					leftrun[i][j + 1] = 0;
					// �����������ӵ����,�ı侲̬����ֵ
					addBoo = true;
				}
			}
		}
		return leftrun;
	}

	//������ӵķ���
	public static int[][] right(int[][] leftrun) {
		for (int i = 0; i < 4; i++) { // ѭ��һ�δ���һ��
			for (int j = 3; j > 0; j--) { // ѭ��һ�δ���һ��Ԫ��
				// �����ұߵĺ���ߵ�Ԫ��ֵͬ,��Ѽӵ��ұߵ�ֵ��.
				if (leftrun[i][j] != 0 && (leftrun[i][j] == leftrun[i][j - 1])) {
					Add.scoreAdd += leftrun[i][j];
					leftrun[i][j] = leftrun[i][j] * 2;
					leftrun[i][j - 1] = 0;
					// �����������ӵ����,�ı侲̬����ֵ
					addBoo = true;
				}
			}
		}
		return leftrun;
	}

	//������ӵķ���
	public static int[][] up(int[][] leftrun) {
		for (int i = 0; i < 3; i++) { // ѭ��һ�δ���һ��
			for (int j = 0; j < 4; j++) { // ѭ��һ�δ���һ��Ԫ��
				// �����ϱߵĺ��±ߵ�Ԫ��ֵͬ,��Ѽӵ��ϱߵ�ֵ��.
				if (leftrun[i][j] != 0 && (leftrun[i][j] == leftrun[i+1][j])) {
					Add.scoreAdd += leftrun[i][j];
					leftrun[i][j] = leftrun[i][j] * 2;
					leftrun[i+1][j] = 0;
					// �����������ӵ����,�ı侲̬����ֵ
					addBoo = true;
				}
			}
		}
		return leftrun;
	}

	//������ӵ�
	public static int[][] down(int[][] leftrun) {
		for (int i = 3; i > 0; i--) { // ѭ��һ�δ���һ��
			for (int j = 0; j < 4; j++) { // ѭ��һ�δ���һ��Ԫ��
				// �����ϱߵĺ��±ߵ�Ԫ��ֵͬ,��Ѽӵ��ϱߵ�ֵ��.
				if (leftrun[i][j] != 0 && (leftrun[i][j] == leftrun[i-1][j])) {
					Add.scoreAdd += leftrun[i][j];
					leftrun[i][j] = leftrun[i][j] * 2;
					leftrun[i-1][j] = 0;
					// �����������ӵ����,�ı侲̬����ֵ
					addBoo = true;
				}
			}
		}
		return leftrun;
	}

}
