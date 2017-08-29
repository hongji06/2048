package com.bjsxt.game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Game2048 extends JFrame implements KeyListener {

	/**
	 * 解码ID 是1L
	 */
	private static final long serialVersionUID = 1L;

	public static int score;

	private JTextArea text = new JTextArea();

	private static Color c = new Color(245, 245, 245);

	private JPanel contentPane;
	private JTextField x1y1;
	private JTextField x1y2;
	private JButton btnUp;
	private JButton btnLeft;
	private JButton btnRight;
	private JButton btnDown;
	private JButton btnExit;
	private JButton btnNewButton;
	private JTextField x1y4;
	private JTextField x1y3;
	private JTextField x2y2;
	private JTextField x2y1;
	private JTextField x3y2;
	private JTextField x3y1;
	private JTextField x4y2;
	private JTextField x4y1;
	private JTextField x2y4;
	private JTextField x2y3;
	private JTextField x3y4;
	private JTextField x3y3;
	private JTextField x4y4;
	private JTextField x4y3;
	private JButton btnHelp;
	private JButton btnGod;
	private JTextField Score;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JTextField textField;

	/**
	 * 对于游戏的全局进行初始化操作
	 */
	static {

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Game2048 frame = new Game2048();
				frame.setVisible(true);
			}
		});
		// System.out.println(score);
	}

	/**
	 * Create the frame.
	 */
	public Game2048() {
		setTitle("  2048\u6E38\u620F  \u7248\u672C\u53F7v2.1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 499, 323);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245)); // ***********************************************
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		text.addKeyListener(this);// 加入key监听
		contentPane.setLayout(null);
		setContentPane(contentPane);

		x1y1 = new JTextField();
		x1y1.setHorizontalAlignment(SwingConstants.CENTER);
		x1y1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		x1y1.setEditable(false);
		x1y1.setBounds(10, 10, 49, 43);
		contentPane.add(x1y1);
		x1y1.setColumns(10);

		x1y2 = new JTextField();
		x1y2.setHorizontalAlignment(SwingConstants.CENTER);
		x1y2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		x1y2.setEditable(false);
		x1y2.setBounds(69, 10, 49, 43);
		contentPane.add(x1y2);
		x1y2.setColumns(10);

		btnUp = new JButton("\u2191");
		btnUp.setFont(new Font("宋体", Font.PLAIN, 22));
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 向上移动的方法
				 */
				// 变为数组后,进行处理
				int[][] upRun = Realize.of(x1y1, x1y2, x1y3, x1y4, x2y1, x2y2, x2y3, x2y4, x3y1, x3y2, x3y3, x3y4, x4y1,
						x4y2, x4y3, x4y4);
				// 调用向上运动的方法,返回数组
				upRun = Realize.up(upRun);
				// 把返回的数组的值传给数字块
				arrayToLo(upRun);
				// 记录分数
				score += Add.scoreAdd;
				Score.setText("" + score);
				// 初始化各个判断值
				Move.moveBoo = false;
				Add.addBoo = false;
				Add.scoreAdd = 0;
				// 检查游戏是否已经结束
				if (Realize.examine(upRun)) {
					JOptionPane.showMessageDialog(contentPane, "已经没有可以移动的可能了,游戏结束~\n您获得的了   " + score + "  分,再接再厉!");
					// 判断是否将分数记录到文件内并执行操作
					Realize.end();
					Csh();// 重置数字块
				}
			}

		});
		btnUp.setBounds(315, 63, 89, 43);
		contentPane.add(btnUp);

		btnLeft = new JButton("\u2190");
		btnLeft.setFont(new Font("宋体", Font.PLAIN, 22));
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 向左移动的操作
				 */
				// 变为数组后,进行处理
				int[][] leftRun = Realize.of(x1y1, x1y2, x1y3, x1y4, x2y1, x2y2, x2y3, x2y4, x3y1, x3y2, x3y3, x3y4,
						x4y1, x4y2, x4y3, x4y4);
				// 调用向左运动的方法,返回数组
				leftRun = Realize.left(leftRun);
				// 把返回的数组的值传给数字块
				arrayToLo(leftRun);
				// 记录分数
				score += Add.scoreAdd;
				Score.setText("" + score);
				// 初始化各个判断值
				Move.moveBoo = false;
				Add.addBoo = false;
				Add.scoreAdd = 0;
				// 检查游戏是否已经结束
				if (Realize.examine(leftRun)) {
					JOptionPane.showMessageDialog(contentPane, "已经没有可以移动的可能了,游戏结束~\n您获得的了   " + score + "  分,再接再厉!");
					// 判断是否将分数记录到文件内并执行操作
					Realize.end();
					Csh();// 重置数字块
				}
			}
		});
		btnLeft.setBounds(251, 116, 89, 43);
		contentPane.add(btnLeft);

		btnRight = new JButton("\u2192");
		btnRight.setFont(new Font("宋体", Font.PLAIN, 22));
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 向右移动的操作
				 */
				// 变为数组后,进行处理
				int[][] rightRun = Realize.of(x1y1, x1y2, x1y3, x1y4, x2y1, x2y2, x2y3, x2y4, x3y1, x3y2, x3y3, x3y4,
						x4y1, x4y2, x4y3, x4y4);
				// 调用向右运动的方法,返回数组
				rightRun = Realize.right(rightRun);
				// 把返回的数组的值传给数字块
				arrayToLo(rightRun);
				// 记录分数
				score += Add.scoreAdd;
				Score.setText("" + score);
				// 初始化各个判断值
				Move.moveBoo = false;
				Add.addBoo = false;
				Add.scoreAdd = 0;
				// 检查游戏是否已经结束
				if (Realize.examine(rightRun)) {
					JOptionPane.showMessageDialog(contentPane, "已经没有可以移动的可能了,游戏结束~\n您获得的了   " + score + "  分,再接再厉!");
					// 判断是否将分数记录到文件内并执行操作
					Realize.end();
					Csh();// 重置数字块
				}
			}
		});
		btnRight.setBounds(376, 116, 89, 43);
		contentPane.add(btnRight);

		btnDown = new JButton("\u2193");
		btnDown.setFont(new Font("宋体", Font.PLAIN, 22));
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 向下移动的方法
				 */
				// 变为数组后,进行处理
				int[][] downRun = Realize.of(x1y1, x1y2, x1y3, x1y4, x2y1, x2y2, x2y3, x2y4, x3y1, x3y2, x3y3, x3y4,
						x4y1, x4y2, x4y3, x4y4);
				// 调用向下运动的方法,返回数组
				downRun = Realize.down(downRun);
				// 把返回的数组的值传给数字块
				arrayToLo(downRun);
				// 记录分数
				score += Add.scoreAdd;
				Score.setText("" + score);
				// 初始化各个判断值
				Move.moveBoo = false;
				Add.addBoo = false;
				Add.scoreAdd = 0;
				// 检查游戏是否已经结束
				if (Realize.examine(downRun)) {
					JOptionPane.showMessageDialog(contentPane, "已经没有可以移动的可能了,游戏结束~\n您获得的了   " + score + "  分,再接再厉!");
					// 判断是否将分数记录到文件内并执行操作
					Realize.end();
					Csh();// 重置数字块
				}
			}
		});
		btnDown.setBounds(315, 169, 89, 43);
		contentPane.add(btnDown);

		btnExit = new JButton("\u9000\u51FA");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 1.退出前将数字块的信息存储到文件内
				// 2.将数字块的内容转化为数组传给方法
				int showInternalConfirmDialog = JOptionPane.showInternalConfirmDialog(contentPane, "是否退出?");
				if (showInternalConfirmDialog == 0) {
					// 如果高于100分会自动存档
					if (score >= 100) {
						int[][] leftrun = Realize.of(x1y1, x1y2, x1y3, x1y4, x2y1, x2y2, x2y3, x2y4, x3y1, x3y2, x3y3,
								x3y4, x4y1, x4y2, x4y3, x4y4);
						// 调用存储方法
						// 获得时间信息
						// 记录时间信息
						DateFormat df = new SimpleDateFormat("MM月dd日HH:mm:ss");// 设定格式
						Date date = new Date(); // 获取毫秒数
						String dateStr = df.format(date); // 把毫秒数转化为字符串格式
						boolean save = Realize.save(leftrun, ("默认" + dateStr));
						if (!save) {
							JOptionPane.showMessageDialog(contentPane, "操作失败");
						}
					}
					// TODO
					// 3.结束游戏
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(10, 222, 108, 23);
		contentPane.add(btnExit);

		btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 重置按钮
				 */
				// 判断成绩是否足够录入高分榜
				Realize.end();
				// 初始化
				Csh();
			}
		});

		btnNewButton.setBounds(128, 222, 108, 23);
		contentPane.add(btnNewButton);

		x1y4 = new JTextField();
		x1y4.setHorizontalAlignment(SwingConstants.CENTER);
		x1y4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		x1y4.setEditable(false);
		x1y4.setColumns(10);
		x1y4.setBounds(187, 10, 49, 43);
		contentPane.add(x1y4);

		x1y3 = new JTextField();
		x1y3.setHorizontalAlignment(SwingConstants.CENTER);
		x1y3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		x1y3.setEditable(false);
		x1y3.setColumns(10);
		x1y3.setBounds(128, 10, 49, 43);
		contentPane.add(x1y3);

		x2y2 = new JTextField();
		x2y2.setHorizontalAlignment(SwingConstants.CENTER);
		x2y2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		x2y2.setEditable(false);
		x2y2.setColumns(10);
		x2y2.setBounds(69, 63, 49, 43);
		contentPane.add(x2y2);

		x2y1 = new JTextField();
		x2y1.setText("2");
		x2y1.setHorizontalAlignment(SwingConstants.CENTER);
		x2y1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		x2y1.setEditable(false);
		x2y1.setColumns(10);
		x2y1.setBounds(10, 63, 49, 43);
		contentPane.add(x2y1);

		x3y2 = new JTextField();
		x3y2.setHorizontalAlignment(SwingConstants.CENTER);
		x3y2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		x3y2.setEditable(false);
		x3y2.setColumns(10);
		x3y2.setBounds(69, 116, 49, 43);
		contentPane.add(x3y2);

		x3y1 = new JTextField();
		x3y1.setHorizontalAlignment(SwingConstants.CENTER);
		x3y1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		x3y1.setEditable(false);
		x3y1.setColumns(10);
		x3y1.setBounds(10, 116, 49, 43);
		contentPane.add(x3y1);

		x4y2 = new JTextField();
		x4y2.setHorizontalAlignment(SwingConstants.CENTER);
		x4y2.setText("2");
		x4y2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		x4y2.setEditable(false);
		x4y2.setColumns(10);
		x4y2.setBounds(69, 169, 49, 43);
		contentPane.add(x4y2);

		x4y1 = new JTextField();
		x4y1.setHorizontalAlignment(SwingConstants.CENTER);
		x4y1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		x4y1.setEditable(false);
		x4y1.setColumns(10);
		x4y1.setBounds(10, 169, 49, 43);
		contentPane.add(x4y1);

		x2y4 = new JTextField();
		x2y4.setHorizontalAlignment(SwingConstants.CENTER);
		x2y4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		x2y4.setEditable(false);
		x2y4.setColumns(10);
		x2y4.setBounds(187, 63, 49, 43);
		contentPane.add(x2y4);

		x2y3 = new JTextField();
		x2y3.setHorizontalAlignment(SwingConstants.CENTER);
		x2y3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		x2y3.setEditable(false);
		x2y3.setColumns(10);
		x2y3.setBounds(128, 63, 49, 43);
		contentPane.add(x2y3);

		x3y4 = new JTextField();
		x3y4.setHorizontalAlignment(SwingConstants.CENTER);
		x3y4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		x3y4.setEditable(false);
		x3y4.setColumns(10);
		x3y4.setBounds(187, 116, 49, 43);
		contentPane.add(x3y4);

		x3y3 = new JTextField();
		x3y3.setHorizontalAlignment(SwingConstants.CENTER);
		x3y3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		x3y3.setEditable(false);
		x3y3.setColumns(10);
		x3y3.setBounds(128, 116, 49, 43);
		contentPane.add(x3y3);

		x4y4 = new JTextField();
		x4y4.setHorizontalAlignment(SwingConstants.CENTER);
		x4y4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		x4y4.setEditable(false);
		x4y4.setColumns(10);
		x4y4.setBounds(187, 169, 49, 43);
		contentPane.add(x4y4);

		x4y3 = new JTextField();
		x4y3.setHorizontalAlignment(SwingConstants.CENTER);
		x4y3.setEditable(false);
		x4y3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		x4y3.setColumns(10);
		x4y3.setBounds(128, 169, 49, 43);
		contentPane.add(x4y3);

		btnHelp = new JButton("\u5E2E\u52A9");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane,
						"2048玩法介绍\n玩家通过不断的进行移动指令,使方块内的数字进行移动,数值相\n同的数字方块会进行合并,若再也没有可以合并的可能则游戏结束", "帮助", -1);
			}
		});
		btnHelp.setBounds(246, 222, 108, 23);
		contentPane.add(btnHelp);

		btnGod = new JButton("\u9AD8\u5206\u699C");
		btnGod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 显示高分榜
				 */
				// 调用高分榜方法,返回一个String数组
				String[] str = Realize.look();
				// 显示信息
				String s = "";
				for (int i = 0; i < str.length; i++) {
					s += str[i];
					if (i != str.length - 1) {
						s += "\n";
					}
				}
				JOptionPane.showMessageDialog(contentPane, "历史高分\n" + s, "高分榜", 1);
			}
		});
		btnGod.setBounds(364, 222, 108, 23);
		contentPane.add(btnGod);

		Score = new JTextField();
		Score.setText("0");
		Score.setFont(new Font("宋体", Font.PLAIN, 16));
		Score.setEditable(false);
		Score.setBounds(331, 10, 133, 32);
		contentPane.add(Score);
		Score.setColumns(10);

		button = new JButton("\u8BFB\u6863");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 实现读档的按钮
				 */
				// 使用方法获取存档文件内的信息,用存档类作为泛型返回一个集合
				ArrayList<Store> storelist = Realize.readStore();
				// 将集合内的信息转化为String类型的数组展示出来
				String s = "";
				for (int i = 0; i < storelist.size(); i++) {
					s += "分数:" + storelist.get(i).storeScore + "\t";
					s += "  备注:" + storelist.get(i).name;
					s += "\n";
				}
				String showInputDialog = JOptionPane.showInputDialog(contentPane, s, "通过备注读档", -1);// (contentPane,
				if (showInputDialog == null) {
					return;
				}
				// 处理这个用户输入的选项,找到他所对应的存档类
				boolean boo = true;
				int[][] arr = new int[4][4];
				for (int i = 0; i < storelist.size(); i++) {
					if (storelist.get(i).name.equals(showInputDialog)) {
						// 把该存档类导入到数字块内,分数改变,完成读档!
						// 存入数字块
						String ss = storelist.get(i).math;
						String[] split = ss.split("#");
						for (int j = 0; j < 4; j++) {
							String[] split2 = split[j].split("!");
							for (int n = 0; n < 4; n++) {
								arr[j][n] = Integer.parseInt(split2[n]);
							}
						}
						// 调用存数字块的方法
						arrayToLo(arr);
						// 改变分数
						score = Integer.parseInt(storelist.get(i).storeScore);
						// 刷新分数框
						Score.setText(storelist.get(i).storeScore);
						boo = false;
					}
				}
				if (boo) {
					JOptionPane.showMessageDialog(contentPane, "没有此存档");
				} else {
					JOptionPane.showMessageDialog(contentPane, "读档成功");
				}
			}
		});
		button.setBounds(10, 255, 108, 23);
		contentPane.add(button);

		button_1 = new JButton("\u5B58\u6863");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 实现存档的按钮
				 */
				// 实现// TODO
				// 弹出输入信息的窗口,返回一个字符串类型的值
				String showInputDialog = JOptionPane.showInputDialog(contentPane, "输入备注", "存档", -1);
				// 将字符串传输给实现类,将数据存储到文件内
				if (showInputDialog == null) {
					return;
				}
				if (showInputDialog.indexOf("@") > -1 || showInputDialog.indexOf("!") > -1
						|| showInputDialog.indexOf("#") > -1) {
					JOptionPane.showMessageDialog(contentPane, "备注不可以含有  ! @ #");
					return;
				}
				boolean store = store(showInputDialog);
				if (store) {
					JOptionPane.showMessageDialog(contentPane, "存档成功");
				} else {
					JOptionPane.showMessageDialog(contentPane, "备注重名或不存在!存档失败!");
				}
			}
		});
		button_1.setBounds(128, 255, 108, 23);
		contentPane.add(button_1);

		button_2 = new JButton("\u5220\u6863");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 实现删档的方法
				 */
				// 1 . 读取文件内的信息
				ArrayList<Store> storelist = Realize.readStore();
				// 2 . 弹出消息框,获得用户输入的信息是什么
				// 将集合内的信息转化为String类型的数组展示出来
				String s = "";
				for (int i = 0; i < storelist.size(); i++) {
					s += "分数:" + storelist.get(i).storeScore + "\t";
					s += "  备注:" + storelist.get(i).name;
					s += "\n";
				}
				String showInputDialog = JOptionPane.showInputDialog(contentPane, s, "通过备注删除存档", 2);
				if (showInputDialog == null) {
					return;
				}
				// 3 . 根据信息查找集合,把对应的那一条删除掉
				boolean boo = true;
				for (int i = 0; i < storelist.size(); i++) {
					if (storelist.get(i).name.equals(showInputDialog)) {
						storelist.remove(i);
						boo = false;
						break;
					}
				}
				if (boo) {
					JOptionPane.showMessageDialog(contentPane, "此备注不存在");
					return;
				}
				// 创建字符输出缓冲流
				BufferedWriter bfw = null;
				BufferedWriter bfw1 = null;
				try {
					bfw = new BufferedWriter(new FileWriter("./go on.txt"));
					bfw1 = new BufferedWriter(new FileWriter("./go on.txt", true));
					// 4 . 清空go on文件
					bfw.write("");
					// 5 . 把集合内的信息刷新到文件内
					for (int i = 0; i < storelist.size(); i++) { // 循环一次写一行
						String all = ""; // 存储这一行的字符串
						all += storelist.get(i).math + "@";
						all += storelist.get(i).storeScore + "@";
						all += storelist.get(i).name;
						bfw1.write(all);
						bfw1.flush();
						bfw1.newLine();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				} finally {
					// 6 . 关流
					if (bfw != null) {
						try {
							bfw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if (bfw1 != null) {
						try {
							bfw1.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				// 7 . 完善细节
				JOptionPane.showMessageDialog(contentPane, "删档成功");
			}
		});
		button_2.setBounds(246, 255, 108, 23);
		contentPane.add(button_2);

		JButton btnNewButton_1 = new JButton("\u6362\u80A4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 实现背景换色的按钮
				 */
				// 弹出窗口选择换肤
				String s = "输入编号或者自定义颜色(逗号分隔)\n1.少女粉(255,153,255)\n2.薰衣紫(238,130,238)\n3.湖水蓝(100,149,237)\n4.番茄红(255,  69 ,  0  )\n5.护眼绿(144,238,144)\n6.柠檬黄(215,215,0)\n7.奶奶灰(169,169,169)";
				String colors = JOptionPane.showInputDialog(contentPane, s, "更换背景色", -1);
				if (colors == null) {
					return;
				}
				if (colors.equals("1")) {
					c = new Color(255, 153, 255);
				} else if (colors.equals("2")) {
					c = new Color(238, 130, 238);
				} else if (colors.equals("3")) {
					c = new Color(100, 149, 237);
				} else if (colors.equals("4")) {
					c = new Color(255, 69, 0);
				} else if (colors.equals("5")) {
					c = new Color(144, 238, 144);
				} else if (colors.equals("6")) {
					c = new Color(215, 215, 0);
				} else if (colors.equals("7")) {
					c = new Color(169, 169, 169);
				} else {
					String[] split = colors.split(",");
					if (split.length != 3) {
						JOptionPane.showMessageDialog(contentPane, "颜色格式错误");
						return;
					}
					int a = Integer.parseInt(split[0]);
					int b = Integer.parseInt(split[1]);
					int c1 = Integer.parseInt(split[2]);
					if (a >= 0 && a <= 255 && b >= 0 && b <= 255 & c1 >= 0 && c1 <= 255) {
						c = new Color(a, b, c1);
					} else {
						JOptionPane.showMessageDialog(contentPane, "颜色格式错误");
						return;
					}
				}
				contentPane.setBackground(c);
			}
		});
		btnNewButton_1.setBounds(364, 255, 108, 23);
		contentPane.add(btnNewButton_1);

		textField = new JTextField();
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("\u5206\u6570");
		textField.setEditable(false);
		textField.setBounds(246, 10, 75, 32);
		contentPane.add(textField);
		textField.setColumns(10);
	}

	/**
	 * 将数组内的内容赋值给数字块
	 */
	public void arrayToLo(int[][] liferun) {
		// 首先清空数字块
		qingKong();
		// 再将数组内的数字赋值给数字块
		if (liferun[0][0] != 0) {
			x1y1.setText("" + liferun[0][0]);
		}
		if (liferun[0][1] != 0) {
			x1y2.setText("" + liferun[0][1]);
		}
		if (liferun[0][2] != 0) {
			x1y3.setText("" + liferun[0][2]);
		}
		if (liferun[0][3] != 0) {
			x1y4.setText("" + liferun[0][3]);
		}
		if (liferun[1][0] != 0) {
			x2y1.setText("" + liferun[1][0]);
		}
		if (liferun[1][1] != 0) {
			x2y2.setText("" + liferun[1][1]);
		}
		if (liferun[1][2] != 0) {
			x2y3.setText("" + liferun[1][2]);
		}
		if (liferun[1][3] != 0) {
			x2y4.setText("" + liferun[1][3]);
		}
		if (liferun[2][0] != 0) {
			x3y1.setText("" + liferun[2][0]);
		}
		if (liferun[2][1] != 0) {
			x3y2.setText("" + liferun[2][1]);
		}
		if (liferun[2][2] != 0) {
			x3y3.setText("" + liferun[2][2]);
		}
		if (liferun[2][3] != 0) {
			x3y4.setText("" + liferun[2][3]);
		}
		if (liferun[3][0] != 0) {
			x4y1.setText("" + liferun[3][0]);
		}
		if (liferun[3][1] != 0) {
			x4y2.setText("" + liferun[3][1]);
		}
		if (liferun[3][2] != 0) {
			x4y3.setText("" + liferun[3][2]);
		}
		if (liferun[3][3] != 0) {
			x4y4.setText("" + liferun[3][3]);
		}
	}

	/**
	 * 清空数字块
	 */
	public void qingKong() {
		x1y1.setText("");
		x1y2.setText("");
		x1y3.setText("");
		x1y4.setText("");
		x2y1.setText("");
		x2y2.setText("");
		x2y3.setText("");
		x2y4.setText("");
		x3y1.setText("");
		x3y2.setText("");
		x3y3.setText("");
		x3y4.setText("");
		x4y1.setText("");
		x4y2.setText("");
		x4y3.setText("");
		x4y4.setText("");
	}

	// 用来进行重置操作的方法
	public void Csh() {
		// 对数字块初始化
		// 调用初始化数字块的方法
		int[][] csh = new int[4][4];
		csh = RandomInt.csh(csh);
		// 把数组内的值赋值给数字块
		arrayToLo(csh);
		// 对各个静态值初始化
		Move.moveBoo = false;
		Add.addBoo = false;
		score = 0;
		Score.setText("0");
		Add.scoreAdd = 0;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub 向下按键时触发次处

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub 键盘抬起时触发此处

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub 键盘按下了是什么键
		x1y1.setText("" + e.getKeyChar());
	}

	public boolean store(String string) {
		// TODO Auto-generated method stub
		// 创建字符输出缓冲流
		// 调用方法获得数字块的数组形式
		int[][] leftrun = Realize.of(x1y1, x1y2, x1y3, x1y4, x2y1, x2y2, x2y3, x2y4, x3y1, x3y2, x3y3, x3y4, x4y1, x4y2,
				x4y3, x4y4);
		// 调用储存方法
		boolean save = Realize.save(leftrun, string);
		return save;
	}
}