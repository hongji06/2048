package com.bjsxt.game;

public class Move {
	
	public static boolean moveBoo = false; // ��¼�Ƿ�����ƶ��Ĳ���ֵ
	// �������ķ���

	public static int[][] left(int[][] leftrun) {
		for (int z = 1; z <= 4; z++) { // �����Ĵ�
			for (int i = 0; i < 4; i++) { // ѭ��һ����һ��
				for (int j = 0; j < 3; j++) { // ѭ��һ�δ���һ��Ԫ��
					if (leftrun[i][j] == 0 && leftrun[i][j + 1] != 0) { // �����Ԫ�ص�ֵΪ0�Ļ������ƶ�һλ
						leftrun[i][j] = leftrun[i][j + 1];
						leftrun[i][j + 1] = 0;
						// ������� ��һ�εĻ��ı侲̬����ֵ
						Move.moveBoo = true;
					}
				}
			}
		}
		return leftrun;
	}

	// ���Ҷ���ķ���
	public static int[][] right(int[][] leftrun) {
		for (int z = 1; z <= 4; z++) { // �����Ĵ�
			for (int i = 0; i < 4; i++) { // ѭ��һ����һ��
				for (int j = 1; j < 4; j++) { // ѭ��һ�δ���һ��Ԫ��
					if (leftrun[i][j] == 0 && leftrun[i][j - 1] != 0) { // �����Ԫ�ص�ֵΪ0�Ļ������ƶ�һλ
						leftrun[i][j] = leftrun[i][j - 1];
						leftrun[i][j - 1] = 0;
						// ������� ��һ�εĻ��ı侲̬����ֵ
						Move.moveBoo = true;
					}
				}
			}
		}
		return leftrun;
	}

	// ���϶���ķ���
	public static int[][] up(int[][] leftrun) {
		for (int z = 1; z <= 4; z++) { // �����Ĵ�
			for (int i = 0; i < 3; i++) { // ѭ��һ����һ��
				for (int j = 0; j < 4; j++) { // ѭ��һ�δ���һ��Ԫ��
					if (leftrun[i][j] == 0 && leftrun[i + 1][j] != 0) { // �����Ԫ�ص�ֵΪ0�Ļ������ƶ�һλ
						leftrun[i][j] = leftrun[i + 1][j];
						leftrun[i + 1][j] = 0;
						// ������� ��һ�εĻ��ı侲̬����ֵ
						Move.moveBoo = true;
					}
				}
			}
		}
		return leftrun;
	}

	// ���¶���ķ���
	public static int[][] down(int[][] leftrun) {
		for (int z = 1; z <= 4; z++) { // �����Ĵ�
			for (int i = 3; i > 0; i--) { // ѭ��һ����һ��
				for (int j = 0; j < 4; j++) { // ѭ��һ�δ���һ��Ԫ��
					if (leftrun[i][j] == 0 && leftrun[i - 1][j] != 0) { // �����Ԫ�ص�ֵΪ0�Ļ������ƶ�һλ
						leftrun[i][j] = leftrun[i - 1][j];
						leftrun[i - 1][j] = 0;
						// ������� ��һ�εĻ��ı侲̬����ֵ
						Move.moveBoo = true;
					}
				}
			}
		}
		return leftrun;
	}

}
