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
 * 实现2048类中的方法
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
	 * 向左移动的方法
	 * 
	 * @param liferun
	 * @return
	 */
	public static int[][] left(int[][] leftrun) {
		// 向左对齐
		leftrun = Move.left(leftrun);
		// 检查相加
		leftrun = Add.left(leftrun);
		// 向左对齐
		leftrun = Move.left(leftrun);
		// 随机生成2或者4
		// 增加判断语句判断是否调用该方法
		if (Move.moveBoo || Add.addBoo) {
			leftrun = RandomInt.left(leftrun);
		}

		return leftrun;
	}

	/**
	 * 向右移动的方法
	 * 
	 * @param leftrun
	 * @return
	 */
	public static int[][] right(int[][] leftrun) {
		// 向右对齐
		leftrun = Move.right(leftrun);
		// 检查相加
		leftrun = Add.right(leftrun);
		// 向右对齐
		leftrun = Move.right(leftrun);
		// 随机生成2或者4
		// 增加判断语句判断是否调用该方法
		if (Move.moveBoo || Add.addBoo) {
			leftrun = RandomInt.left(leftrun);
		}
		return leftrun;
	}

	/**
	 * 向上移动的方法
	 * 
	 * @param leftrun
	 * @return
	 */
	public static int[][] up(int[][] leftrun) {
		// 向上对齐
		leftrun = Move.up(leftrun);
		// 检查相加
		leftrun = Add.up(leftrun);
		// 向上对齐
		leftrun = Move.up(leftrun);
		// 随机生成2或者4
		// 增加判断语句判断是否调用该方法
		if (Move.moveBoo || Add.addBoo) {
			leftrun = RandomInt.left(leftrun);
		}
		return leftrun;
	}

	/**
	 * 向下移动的方法
	 * 
	 * @param leftrun
	 * @return
	 */
	public static int[][] down(int[][] leftrun) {
		// 向上对齐
		leftrun = Move.down(leftrun);
		// 检查相加
		leftrun = Add.down(leftrun);
		// 向上对齐
		leftrun = Move.down(leftrun);
		// 随机生成2或者4
		// 增加判断语句判断是否调用该方法
		if (Move.moveBoo || Add.addBoo) {
			leftrun = RandomInt.left(leftrun);
		}
		return leftrun;
	}

	/**
	 * 将数字块内的数字转化为数组的方法
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
		// 判断这个字符串是否可以转化成int类型的值
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
		for (int i = 0; i < 4; i++) { // 横线排查
			for (int j = 0; j < 3; j++) {
				if (leftrun[i][j] == 0 || leftrun[i][j + 1] == 0) {
					return false;
				}
				if (leftrun[i][j] == leftrun[i][j + 1]) {
					return false;
				}
			}
		}
		for (int i = 0; i < 3; i++) { // 纵向排查
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
	 * 判断是否将数字存入文件的方法
	 */
	public static void end() {

//		File file = new File("./2048.txt");
		ArrayList<Grade> change = change();
		if (change.size() < 5) {
			// 若是小于5的话直接存入
			writer();
			return;
		}
		int[] arr = new int[change.size() + 1];
		for (int i = 0; i < change.size(); i++) { // 遍历集合
			arr[i] = change.get(i).getScore();// 将对应对象的分数值赋值给数组arr

		}
		arr[arr.length - 1] = Game2048.score; // 将分数输入到数组内
		Arrays.sort(arr); // 升序冒泡
		if (arr[0] == Game2048.score) { // 如果是最小的数字则不存入
			return;
		} else { // 否则将此数字存入文件内
			// 删除一个最低的成绩
			for (int i = 0; i < change.size(); i++) { // 遍历集合
				if (change.get(i).getScore() == arr[0]) {
					change.remove(i); // 若是某对象的分数和最少的分数一样的话,则移除该对象
				}
			}
			// 将集合刷新到文件内
			shuaxinFile(change);
			// 把此次的成绩存入文件内
			writer();
		}

	}

	// 将集合内的内容刷新到文件内的方法
	private static void shuaxinFile(ArrayList<Grade> change) {
		// 清空文件
		File file = new File("./2048.txt");
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// 创建字符输出缓冲流
		BufferedWriter bfw = null;
		try {
			bfw = new BufferedWriter(new FileWriter("./2048.txt", true));
			for (int i = 0; i < change.size(); i++) {
				// 将集合内的信息化成字符串存储到文件内
				String mess = change.get(i).getDate() + "!" + change.get(i).getScore();
				bfw.write(mess);
				bfw.flush();
				// 换行
				bfw.newLine();
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 关流
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
	 * 将文件内信息转化为集合的方法
	 */
	public static ArrayList<Grade> change() {
		ArrayList<Grade> AList = new ArrayList<>();
		// 创建字符输入缓冲流
		BufferedReader fr = null;
		try {
			fr = new BufferedReader(new FileReader("./2048.txt"));
			String s = "";
			while ((s = fr.readLine()) != null) {
				String[] split = s.split("!");// 用叹号切割为一个String数组
				Grade gra = new Grade(split[0], Integer.parseInt(split[1]));// 创建对象并将信息存入
				AList.add(gra); // 把对象存到集合内
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		} finally {
			// 关流
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
	 * 将分数记录到文件内的方法
	 */
	public static void writer() {
		// 创建字符输出缓冲流
		BufferedWriter fos = null;
		try {
			fos = new BufferedWriter(new FileWriter("./2048.txt", true));
			// 将分数和时间信息输出到文件内
			String s = "" + Game2048.score;
			// 记录时间信息
			DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// 设定格式
			Date date = new Date(); // 获取毫秒数
			String dateStr = df.format(date); // 把毫秒数转化为字符串格式
			String mess = dateStr + "!" + s; // 拼接在一起,用叹号隔开
			// 输出流输出信息
			fos.write(mess);
			fos.flush();
			fos.newLine();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关流
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
	 * 显示高分榜的方法
	 * 
	 * @return
	 */
	public static String[] look() {
		// 1.将文件中的信息读取
		// 1.1调用方法
		ArrayList<Grade> change = change();
		// 2.将读取到的信息装进数组内
		// 2.1将集合内的信息按照分数的降序存到Grade类型的数组内
		Grade[] gra = new Grade[change.size()]; // 用于储存信息的Grade类型数组
		for (int i = 0; i < change.size(); i++) {
			gra[i] = change.get(i);
		}
		// 2.2把gra数组按照分数排序
		// 开始冒泡排序
		Grade g = null;
		for (int i = 0; i < gra.length - 1; i++) { // 冒泡排序,一次循环处理一个
			boolean boo = true;
			for (int j = gra.length - 1; j > 0; j--) { // 一次循环比较一次
				if (gra[j].getScore() > gra[j - 1].getScore()) {
					g = gra[j]; // 交换位置
					gra[j] = gra[j - 1];
					gra[j - 1] = g;
					boo = false;
				}
			}
			if (boo) {
				break;
			}
		}
		// 2.3把gra数组的属性提取出来赋值给str
		String[] str = new String[gra.length];
		for (int i = 0; i < str.length; i++) {
			str[i] = gra[i].getDate() + "分数:" + gra[i].getScore();
		}
		// 传给主方法
		return str;
	}

	/**
	 * 将数字块的信息存储到文件内
	 * 
	 * @param leftrun
	 */
	public static boolean save(int[][] leftrun, String name) {
		if (name == null || name.equals("")) {
			return false;
		}
		// 调用方法检测此名称是否合法
		if (!Realize.jiance(name)) {
			return false;
		}
		String s = "";
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				s += leftrun[i][j];
				if (j != 3) { // 如果不是最后一个元素则接一个!
					s += "!";
				}
			}
			if (i != 3) { // 若不是最后一个一维数组则接一个#
				s += "#";
			}
		}
		s += "@" + Game2048.score; // 把分数拼接上,用@隔开
		s += "@" + name;
		// 将拼接后的字符串存储到文件内/game/go on.txt
		// 创建字符缓冲输出流
		BufferedWriter bfw = null;
		try {
			bfw = new BufferedWriter(new FileWriter("./go on.txt", true));
			// 将字符串写出
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
	 * 用于存档的时候检测名称是否合格
	 * 
	 * @param name
	 * @return
	 */
	private static boolean jiance(String name) {
		// 使用方法获取存档文件内的信息,用存档类作为泛型返回一个集合
		ArrayList<Store> list = Realize.readStore();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).name.equals(name)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 使用方法获取存档文件内的信息,用存档类作为泛型返回一个集合
	 * 
	 * @return
	 */
	public static ArrayList<Store> readStore() {
		// 声明集合
		ArrayList<Store> list = new ArrayList<>();
		// 创建字符输入缓冲流
		BufferedReader bfw = null;
		try {
			bfw = new BufferedReader(new FileReader("./go on.txt"));
			String s = "";
			while ((s = bfw.readLine()) != null) {
				// 0!0!16!4#0!32!16!2#0!0!0!4#0!0!0!2@112@默认
				// 切割字符串,分成三份
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
