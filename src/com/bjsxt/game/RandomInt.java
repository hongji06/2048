package com.bjsxt.game;

public class RandomInt {

	/**
	 * ��0��λ���������2����4�ķ���
	 * 
	 * @param leftrun
	 * @return
	 */
	public static int[][] left(int[][] leftrun) {
		int a = 0;
		for (int i = 0; i < 4; i++) { // ѭ��һ��ִ��һ��
			for (int j = 0; j < 4; j++) {
				if (leftrun[i][j] == 0) {
					a++; // ��¼������0������
				}
			}
		}
		// aֵ���������ֿ��ڴ�ʱ0��ֵ�ж��ٸ�
		if (a == 0) {
			return leftrun;
		}
		// ͨ��a��ֵ��ȷ���Ƿ���ĳһ��λ����������
//		boolean boo = false; // �β���ֵ���������Ѿ���ӹ�����������
		gogogo: for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (leftrun[i][j] == 0) { // �ж��Ƿ���0
					int ranbom = (int) (Math.random() * a + 1);
					if (ranbom % a == 0) { // �ж��Ƿ��ڴ˴���������
						int ranbom2 = (int) (Math.random() * 18 + 1);
						if (ranbom2 % 18 == 0) { // �ж�����2����4
							leftrun[i][j] = 4;
						} else {
							leftrun[i][j] = 2;
						}
						return leftrun; // �������֮�󷵻�����
					}
				}
				if (i == 3 && j == 3) { // һ�ζ�û�����ɹ��Ļ���������
					i = 0;
					continue gogogo;
				}
			}
		}
		return leftrun;
	}

	/**
	 * ��ʼ�����ֿ�ķ���
	 * 
	 * @param csh
	 * @return
	 */
	public static int[][] csh(int[][] csh) {
		int a = 0; // �ж��Ѿ����ɼ������ֵı���
		gogogo: for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int ran = (int) (Math.random() * 16 + 1);// ������������Ƿ��ڴ˴���������
				if (ran % 8 == 0) {
					int ran2 = (int) (Math.random() * 18 + 1);// �������������������2����4
					if (ran2 % 18 == 0) {
						csh[i][j] = 4;
					} else {
						csh[i][j] = 2;
					}
					a++;
					if (a == 2) { // �Ѿ��������������˵Ļ��򷵻�csh����
						return csh;
					}
				}
				if (i == 3 && j == 3) {//������˴��˻��ǲ��������Ļ�����ͷ����
					i = 0;
					continue gogogo;
				}
			}
		}
		return csh;
	}
}
