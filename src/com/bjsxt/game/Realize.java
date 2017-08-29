package com.bjsxt.game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JTextField;

/**
 * ʵ��2048���еķ���
 * 
 * @author asus
 *
 */
public class Realize {
	public static void main(String[] args) {
		// String s = "";
		// int n = Integer.parseUnsignedInt(s);
		// System.out.println(n);
		int[][] i = new int[4][4];
		System.out.println(i[0][0]);
		File file = new File("./2048.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �����ƶ��ķ���
	 * 
	 * @param liferun
	 * @return
	 */
	public static int[][] left(int[][] leftrun) {
		// �������
		leftrun = Move.left(leftrun);
		// ������
		leftrun = Add.left(leftrun);
		// �������
		leftrun = Move.left(leftrun);
		// �������2����4
		// �����ж�����ж��Ƿ���ø÷���
		if (Move.moveBoo || Add.addBoo) {
			leftrun = RandomInt.left(leftrun);
		}

		return leftrun;
	}

	/**
	 * �����ƶ��ķ���
	 * 
	 * @param leftrun
	 * @return
	 */
	public static int[][] right(int[][] leftrun) {
		// ���Ҷ���
		leftrun = Move.right(leftrun);
		// ������
		leftrun = Add.right(leftrun);
		// ���Ҷ���
		leftrun = Move.right(leftrun);
		// �������2����4
		// �����ж�����ж��Ƿ���ø÷���
		if (Move.moveBoo || Add.addBoo) {
			leftrun = RandomInt.left(leftrun);
		}
		return leftrun;
	}

	/**
	 * �����ƶ��ķ���
	 * 
	 * @param leftrun
	 * @return
	 */
	public static int[][] up(int[][] leftrun) {
		// ���϶���
		leftrun = Move.up(leftrun);
		// ������
		leftrun = Add.up(leftrun);
		// ���϶���
		leftrun = Move.up(leftrun);
		// �������2����4
		// �����ж�����ж��Ƿ���ø÷���
		if (Move.moveBoo || Add.addBoo) {
			leftrun = RandomInt.left(leftrun);
		}
		return leftrun;
	}

	/**
	 * �����ƶ��ķ���
	 * 
	 * @param leftrun
	 * @return
	 */
	public static int[][] down(int[][] leftrun) {
		// ���϶���
		leftrun = Move.down(leftrun);
		// ������
		leftrun = Add.down(leftrun);
		// ���϶���
		leftrun = Move.down(leftrun);
		// �������2����4
		// �����ж�����ж��Ƿ���ø÷���
		if (Move.moveBoo || Add.addBoo) {
			leftrun = RandomInt.left(leftrun);
		}
		return leftrun;
	}

	/**
	 * �����ֿ��ڵ�����ת��Ϊ����ķ���
	 * 
	 * @return
	 */
	public static int[][] of(JTextField x1y1, JTextField x1y2, JTextField x1y3, JTextField x1y4, JTextField x2y1,
			JTextField x2y2, JTextField x2y3, JTextField x2y4, JTextField x3y1, JTextField x3y2, JTextField x3y3,
			JTextField x3y4, JTextField x4y1, JTextField x4y2, JTextField x4y3, JTextField x4y4) {
		int[][] liferun = new int[4][4];

		if (Realize.in(x1y1.getText())) {
			liferun[0][0] = Integer.parseInt(x1y1.getText());
		}
		if (Realize.in(x1y2.getText())) {
			liferun[0][1] = Integer.parseInt(x1y2.getText());
		}
		if (Realize.in(x1y3.getText())) {
			liferun[0][2] = Integer.parseInt(x1y3.getText());
		}
		if (Realize.in(x1y4.getText())) {
			liferun[0][3] = Integer.parseInt(x1y4.getText());
		}
		if (Realize.in(x2y1.getText())) {
			liferun[1][0] = Integer.parseInt(x2y1.getText());
		}
		if (Realize.in(x2y2.getText())) {
			liferun[1][1] = Integer.parseInt(x2y2.getText());
		}
		if (Realize.in(x2y3.getText())) {
			liferun[1][2] = Integer.parseInt(x2y3.getText());
		}
		if (Realize.in(x2y4.getText())) {
			liferun[1][3] = Integer.parseInt(x2y4.getText());
		}
		if (Realize.in(x3y1.getText())) {
			liferun[2][0] = Integer.parseInt(x3y1.getText());
		}
		if (Realize.in(x3y2.getText())) {
			liferun[2][1] = Integer.parseInt(x3y2.getText());
		}
		if (Realize.in(x3y3.getText())) {
			liferun[2][2] = Integer.parseInt(x3y3.getText());
		}
		if (Realize.in(x3y4.getText())) {
			liferun[2][3] = Integer.parseInt(x3y4.getText());
		}
		if (Realize.in(x4y1.getText())) {
			liferun[3][0] = Integer.parseInt(x4y1.getText());
		}
		if (Realize.in(x4y2.getText())) {
			liferun[3][1] = Integer.parseInt(x4y2.getText());
		}
		if (Realize.in(x4y3.getText())) {
			liferun[3][2] = Integer.parseInt(x4y3.getText());
		}
		if (Realize.in(x4y4.getText())) {
			liferun[3][3] = Integer.parseInt(x4y4.getText());
		}

		return liferun;
	}

	public static boolean in(String string) {
		// �ж�����ַ����Ƿ����ת����int���͵�ֵ
		if (string == null || string == "") {
			return false;
		}
		char[] charArray = string.toCharArray();
		boolean boo = false;
		for (char c : charArray) {
			if (c <= '9' && c >= '0') {
				boo = true;
			}
		}
		return boo;
	}

	public static boolean examine(int[][] leftrun) {
		for (int i = 0; i < 4; i++) { // �����Ų�
			for (int j = 0; j < 3; j++) {
				if (leftrun[i][j] == 0 || leftrun[i][j + 1] == 0) {
					return false;
				}
				if (leftrun[i][j] == leftrun[i][j + 1]) {
					return false;
				}
			}
		}
		for (int i = 0; i < 3; i++) { // �����Ų�
			for (int j = 0; j < 4; j++) {
				if (leftrun[i][j] == 0 || leftrun[i + 1][j] == 0) {
					return false;
				}
				if (leftrun[i][j] == leftrun[i + 1][j]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * �ж��Ƿ����ִ����ļ��ķ���
	 */
	public static void end() {

//		File file = new File("./2048.txt");
		ArrayList<Grade> change = change();
		if (change.size() < 5) {
			// ����С��5�Ļ�ֱ�Ӵ���
			writer();
			return;
		}
		int[] arr = new int[change.size() + 1];
		for (int i = 0; i < change.size(); i++) { // ��������
			arr[i] = change.get(i).getScore();// ����Ӧ����ķ���ֵ��ֵ������arr

		}
		arr[arr.length - 1] = Game2048.score; // ���������뵽������
		Arrays.sort(arr); // ����ð��
		if (arr[0] == Game2048.score) { // �������С�������򲻴���
			return;
		} else { // ���򽫴����ִ����ļ���
			// ɾ��һ����͵ĳɼ�
			for (int i = 0; i < change.size(); i++) { // ��������
				if (change.get(i).getScore() == arr[0]) {
					change.remove(i); // ����ĳ����ķ��������ٵķ���һ���Ļ�,���Ƴ��ö���
				}
			}
			// ������ˢ�µ��ļ���
			shuaxinFile(change);
			// �Ѵ˴εĳɼ������ļ���
			writer();
		}

	}

	// �������ڵ�����ˢ�µ��ļ��ڵķ���
	private static void shuaxinFile(ArrayList<Grade> change) {
		// ����ļ�
		File file = new File("./2048.txt");
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// �����ַ����������
		BufferedWriter bfw = null;
		try {
			bfw = new BufferedWriter(new FileWriter("./2048.txt", true));
			for (int i = 0; i < change.size(); i++) {
				// �������ڵ���Ϣ�����ַ����洢���ļ���
				String mess = change.get(i).getDate() + "!" + change.get(i).getScore();
				bfw.write(mess);
				bfw.flush();
				// ����
				bfw.newLine();
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// ����
			if (bfw != null) {
				try {
					bfw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * ���ļ�����Ϣת��Ϊ���ϵķ���
	 */
	public static ArrayList<Grade> change() {
		ArrayList<Grade> AList = new ArrayList<>();
		// �����ַ����뻺����
		BufferedReader fr = null;
		try {
			fr = new BufferedReader(new FileReader("./2048.txt"));
			String s = "";
			while ((s = fr.readLine()) != null) {
				String[] split = s.split("!");// ��̾���и�Ϊһ��String����
				Grade gra = new Grade(split[0], Integer.parseInt(split[1]));// �������󲢽���Ϣ����
				AList.add(gra); // �Ѷ���浽������
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		} finally {
			// ����
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return AList;
	}

	/**
	 * ��������¼���ļ��ڵķ���
	 */
	public static void writer() {
		// �����ַ����������
		BufferedWriter fos = null;
		try {
			fos = new BufferedWriter(new FileWriter("./2048.txt", true));
			// ��������ʱ����Ϣ������ļ���
			String s = "" + Game2048.score;
			// ��¼ʱ����Ϣ
			DateFormat df = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");// �趨��ʽ
			Date date = new Date(); // ��ȡ������
			String dateStr = df.format(date); // �Ѻ�����ת��Ϊ�ַ�����ʽ
			String mess = dateStr + "!" + s; // ƴ����һ��,��̾�Ÿ���
			// ����������Ϣ
			fos.write(mess);
			fos.flush();
			fos.newLine();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ����
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * ��ʾ�߷ְ�ķ���
	 * 
	 * @return
	 */
	public static String[] look() {
		// 1.���ļ��е���Ϣ��ȡ
		// 1.1���÷���
		ArrayList<Grade> change = change();
		// 2.����ȡ������Ϣװ��������
		// 2.1�������ڵ���Ϣ���շ����Ľ���浽Grade���͵�������
		Grade[] gra = new Grade[change.size()]; // ���ڴ�����Ϣ��Grade��������
		for (int i = 0; i < change.size(); i++) {
			gra[i] = change.get(i);
		}
		// 2.2��gra���鰴�շ�������
		// ��ʼð������
		Grade g = null;
		for (int i = 0; i < gra.length - 1; i++) { // ð������,һ��ѭ������һ��
			boolean boo = true;
			for (int j = gra.length - 1; j > 0; j--) { // һ��ѭ���Ƚ�һ��
				if (gra[j].getScore() > gra[j - 1].getScore()) {
					g = gra[j]; // ����λ��
					gra[j] = gra[j - 1];
					gra[j - 1] = g;
					boo = false;
				}
			}
			if (boo) {
				break;
			}
		}
		// 2.3��gra�����������ȡ������ֵ��str
		String[] str = new String[gra.length];
		for (int i = 0; i < str.length; i++) {
			str[i] = gra[i].getDate() + "����:" + gra[i].getScore();
		}
		// ����������
		return str;
	}

	/**
	 * �����ֿ����Ϣ�洢���ļ���
	 * 
	 * @param leftrun
	 */
	public static boolean save(int[][] leftrun, String name) {
		if (name == null || name.equals("")) {
			return false;
		}
		// ���÷������������Ƿ�Ϸ�
		if (!Realize.jiance(name)) {
			return false;
		}
		String s = "";
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				s += leftrun[i][j];
				if (j != 3) { // ����������һ��Ԫ�����һ��!
					s += "!";
				}
			}
			if (i != 3) { // ���������һ��һά�������һ��#
				s += "#";
			}
		}
		s += "@" + Game2048.score; // �ѷ���ƴ����,��@����
		s += "@" + name;
		// ��ƴ�Ӻ���ַ����洢���ļ���/game/go on.txt
		// �����ַ����������
		BufferedWriter bfw = null;
		try {
			bfw = new BufferedWriter(new FileWriter("./go on.txt", true));
			// ���ַ���д��
			bfw.write(s);
			bfw.newLine();
			bfw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bfw != null) {
				try {
					bfw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	/**
	 * ���ڴ浵��ʱ���������Ƿ�ϸ�
	 * 
	 * @param name
	 * @return
	 */
	private static boolean jiance(String name) {
		// ʹ�÷�����ȡ�浵�ļ��ڵ���Ϣ,�ô浵����Ϊ���ͷ���һ������
		ArrayList<Store> list = Realize.readStore();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).name.equals(name)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * ʹ�÷�����ȡ�浵�ļ��ڵ���Ϣ,�ô浵����Ϊ���ͷ���һ������
	 * 
	 * @return
	 */
	public static ArrayList<Store> readStore() {
		// ��������
		ArrayList<Store> list = new ArrayList<>();
		// �����ַ����뻺����
		BufferedReader bfw = null;
		try {
			bfw = new BufferedReader(new FileReader("./go on.txt"));
			String s = "";
			while ((s = bfw.readLine()) != null) {
				// 0!0!16!4#0!32!16!2#0!0!0!4#0!0!0!2@112@Ĭ��
				// �и��ַ���,�ֳ�����
				String[] split = s.split("@");
				String math = split[0];
				String storeScore = split[1];
				String name = split[2];
				Store store = new Store(math, storeScore, name);
				list.add(store);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (bfw != null) {
				try {
					bfw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}

}
