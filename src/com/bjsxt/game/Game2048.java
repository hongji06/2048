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
	 * ����ID ��1L
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
	 * ������Ϸ��ȫ�ֽ��г�ʼ������
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
		text.addKeyListener(this);// ����key����
		contentPane.setLayout(null);
		setContentPane(contentPane);

		x1y1 = new JTextField();
		x1y1.setHorizontalAlignment(SwingConstants.CENTER);
		x1y1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		x1y1.setEditable(false);
		x1y1.setBounds(10, 10, 49, 43);
		contentPane.add(x1y1);
		x1y1.setColumns(10);

		x1y2 = new JTextField();
		x1y2.setHorizontalAlignment(SwingConstants.CENTER);
		x1y2.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		x1y2.setEditable(false);
		x1y2.setBounds(69, 10, 49, 43);
		contentPane.add(x1y2);
		x1y2.setColumns(10);

		btnUp = new JButton("\u2191");
		btnUp.setFont(new Font("����", Font.PLAIN, 22));
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * �����ƶ��ķ���
				 */
				// ��Ϊ�����,���д���
				int[][] upRun = Realize.of(x1y1, x1y2, x1y3, x1y4, x2y1, x2y2, x2y3, x2y4, x3y1, x3y2, x3y3, x3y4, x4y1,
						x4y2, x4y3, x4y4);
				// ���������˶��ķ���,��������
				upRun = Realize.up(upRun);
				// �ѷ��ص������ֵ�������ֿ�
				arrayToLo(upRun);
				// ��¼����
				score += Add.scoreAdd;
				Score.setText("" + score);
				// ��ʼ�������ж�ֵ
				Move.moveBoo = false;
				Add.addBoo = false;
				Add.scoreAdd = 0;
				// �����Ϸ�Ƿ��Ѿ�����
				if (Realize.examine(upRun)) {
					JOptionPane.showMessageDialog(contentPane, "�Ѿ�û�п����ƶ��Ŀ�����,��Ϸ����~\n����õ���   " + score + "  ��,�ٽ�����!");
					// �ж��Ƿ񽫷�����¼���ļ��ڲ�ִ�в���
					Realize.end();
					Csh();// �������ֿ�
				}
			}

		});
		btnUp.setBounds(315, 63, 89, 43);
		contentPane.add(btnUp);

		btnLeft = new JButton("\u2190");
		btnLeft.setFont(new Font("����", Font.PLAIN, 22));
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * �����ƶ��Ĳ���
				 */
				// ��Ϊ�����,���д���
				int[][] leftRun = Realize.of(x1y1, x1y2, x1y3, x1y4, x2y1, x2y2, x2y3, x2y4, x3y1, x3y2, x3y3, x3y4,
						x4y1, x4y2, x4y3, x4y4);
				// ���������˶��ķ���,��������
				leftRun = Realize.left(leftRun);
				// �ѷ��ص������ֵ�������ֿ�
				arrayToLo(leftRun);
				// ��¼����
				score += Add.scoreAdd;
				Score.setText("" + score);
				// ��ʼ�������ж�ֵ
				Move.moveBoo = false;
				Add.addBoo = false;
				Add.scoreAdd = 0;
				// �����Ϸ�Ƿ��Ѿ�����
				if (Realize.examine(leftRun)) {
					JOptionPane.showMessageDialog(contentPane, "�Ѿ�û�п����ƶ��Ŀ�����,��Ϸ����~\n����õ���   " + score + "  ��,�ٽ�����!");
					// �ж��Ƿ񽫷�����¼���ļ��ڲ�ִ�в���
					Realize.end();
					Csh();// �������ֿ�
				}
			}
		});
		btnLeft.setBounds(251, 116, 89, 43);
		contentPane.add(btnLeft);

		btnRight = new JButton("\u2192");
		btnRight.setFont(new Font("����", Font.PLAIN, 22));
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * �����ƶ��Ĳ���
				 */
				// ��Ϊ�����,���д���
				int[][] rightRun = Realize.of(x1y1, x1y2, x1y3, x1y4, x2y1, x2y2, x2y3, x2y4, x3y1, x3y2, x3y3, x3y4,
						x4y1, x4y2, x4y3, x4y4);
				// ���������˶��ķ���,��������
				rightRun = Realize.right(rightRun);
				// �ѷ��ص������ֵ�������ֿ�
				arrayToLo(rightRun);
				// ��¼����
				score += Add.scoreAdd;
				Score.setText("" + score);
				// ��ʼ�������ж�ֵ
				Move.moveBoo = false;
				Add.addBoo = false;
				Add.scoreAdd = 0;
				// �����Ϸ�Ƿ��Ѿ�����
				if (Realize.examine(rightRun)) {
					JOptionPane.showMessageDialog(contentPane, "�Ѿ�û�п����ƶ��Ŀ�����,��Ϸ����~\n����õ���   " + score + "  ��,�ٽ�����!");
					// �ж��Ƿ񽫷�����¼���ļ��ڲ�ִ�в���
					Realize.end();
					Csh();// �������ֿ�
				}
			}
		});
		btnRight.setBounds(376, 116, 89, 43);
		contentPane.add(btnRight);

		btnDown = new JButton("\u2193");
		btnDown.setFont(new Font("����", Font.PLAIN, 22));
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * �����ƶ��ķ���
				 */
				// ��Ϊ�����,���д���
				int[][] downRun = Realize.of(x1y1, x1y2, x1y3, x1y4, x2y1, x2y2, x2y3, x2y4, x3y1, x3y2, x3y3, x3y4,
						x4y1, x4y2, x4y3, x4y4);
				// ���������˶��ķ���,��������
				downRun = Realize.down(downRun);
				// �ѷ��ص������ֵ�������ֿ�
				arrayToLo(downRun);
				// ��¼����
				score += Add.scoreAdd;
				Score.setText("" + score);
				// ��ʼ�������ж�ֵ
				Move.moveBoo = false;
				Add.addBoo = false;
				Add.scoreAdd = 0;
				// �����Ϸ�Ƿ��Ѿ�����
				if (Realize.examine(downRun)) {
					JOptionPane.showMessageDialog(contentPane, "�Ѿ�û�п����ƶ��Ŀ�����,��Ϸ����~\n����õ���   " + score + "  ��,�ٽ�����!");
					// �ж��Ƿ񽫷�����¼���ļ��ڲ�ִ�в���
					Realize.end();
					Csh();// �������ֿ�
				}
			}
		});
		btnDown.setBounds(315, 169, 89, 43);
		contentPane.add(btnDown);

		btnExit = new JButton("\u9000\u51FA");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 1.�˳�ǰ�����ֿ����Ϣ�洢���ļ���
				// 2.�����ֿ������ת��Ϊ���鴫������
				int showInternalConfirmDialog = JOptionPane.showInternalConfirmDialog(contentPane, "�Ƿ��˳�?");
				if (showInternalConfirmDialog == 0) {
					// �������100�ֻ��Զ��浵
					if (score >= 100) {
						int[][] leftrun = Realize.of(x1y1, x1y2, x1y3, x1y4, x2y1, x2y2, x2y3, x2y4, x3y1, x3y2, x3y3,
								x3y4, x4y1, x4y2, x4y3, x4y4);
						// ���ô洢����
						// ���ʱ����Ϣ
						// ��¼ʱ����Ϣ
						DateFormat df = new SimpleDateFormat("MM��dd��HH:mm:ss");// �趨��ʽ
						Date date = new Date(); // ��ȡ������
						String dateStr = df.format(date); // �Ѻ�����ת��Ϊ�ַ�����ʽ
						boolean save = Realize.save(leftrun, ("Ĭ��" + dateStr));
						if (!save) {
							JOptionPane.showMessageDialog(contentPane, "����ʧ��");
						}
					}
					// TODO
					// 3.������Ϸ
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
				 * ���ð�ť
				 */
				// �жϳɼ��Ƿ��㹻¼��߷ְ�
				Realize.end();
				// ��ʼ��
				Csh();
			}
		});

		btnNewButton.setBounds(128, 222, 108, 23);
		contentPane.add(btnNewButton);

		x1y4 = new JTextField();
		x1y4.setHorizontalAlignment(SwingConstants.CENTER);
		x1y4.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		x1y4.setEditable(false);
		x1y4.setColumns(10);
		x1y4.setBounds(187, 10, 49, 43);
		contentPane.add(x1y4);

		x1y3 = new JTextField();
		x1y3.setHorizontalAlignment(SwingConstants.CENTER);
		x1y3.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		x1y3.setEditable(false);
		x1y3.setColumns(10);
		x1y3.setBounds(128, 10, 49, 43);
		contentPane.add(x1y3);

		x2y2 = new JTextField();
		x2y2.setHorizontalAlignment(SwingConstants.CENTER);
		x2y2.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		x2y2.setEditable(false);
		x2y2.setColumns(10);
		x2y2.setBounds(69, 63, 49, 43);
		contentPane.add(x2y2);

		x2y1 = new JTextField();
		x2y1.setText("2");
		x2y1.setHorizontalAlignment(SwingConstants.CENTER);
		x2y1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		x2y1.setEditable(false);
		x2y1.setColumns(10);
		x2y1.setBounds(10, 63, 49, 43);
		contentPane.add(x2y1);

		x3y2 = new JTextField();
		x3y2.setHorizontalAlignment(SwingConstants.CENTER);
		x3y2.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		x3y2.setEditable(false);
		x3y2.setColumns(10);
		x3y2.setBounds(69, 116, 49, 43);
		contentPane.add(x3y2);

		x3y1 = new JTextField();
		x3y1.setHorizontalAlignment(SwingConstants.CENTER);
		x3y1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		x3y1.setEditable(false);
		x3y1.setColumns(10);
		x3y1.setBounds(10, 116, 49, 43);
		contentPane.add(x3y1);

		x4y2 = new JTextField();
		x4y2.setHorizontalAlignment(SwingConstants.CENTER);
		x4y2.setText("2");
		x4y2.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		x4y2.setEditable(false);
		x4y2.setColumns(10);
		x4y2.setBounds(69, 169, 49, 43);
		contentPane.add(x4y2);

		x4y1 = new JTextField();
		x4y1.setHorizontalAlignment(SwingConstants.CENTER);
		x4y1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		x4y1.setEditable(false);
		x4y1.setColumns(10);
		x4y1.setBounds(10, 169, 49, 43);
		contentPane.add(x4y1);

		x2y4 = new JTextField();
		x2y4.setHorizontalAlignment(SwingConstants.CENTER);
		x2y4.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		x2y4.setEditable(false);
		x2y4.setColumns(10);
		x2y4.setBounds(187, 63, 49, 43);
		contentPane.add(x2y4);

		x2y3 = new JTextField();
		x2y3.setHorizontalAlignment(SwingConstants.CENTER);
		x2y3.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		x2y3.setEditable(false);
		x2y3.setColumns(10);
		x2y3.setBounds(128, 63, 49, 43);
		contentPane.add(x2y3);

		x3y4 = new JTextField();
		x3y4.setHorizontalAlignment(SwingConstants.CENTER);
		x3y4.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		x3y4.setEditable(false);
		x3y4.setColumns(10);
		x3y4.setBounds(187, 116, 49, 43);
		contentPane.add(x3y4);

		x3y3 = new JTextField();
		x3y3.setHorizontalAlignment(SwingConstants.CENTER);
		x3y3.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		x3y3.setEditable(false);
		x3y3.setColumns(10);
		x3y3.setBounds(128, 116, 49, 43);
		contentPane.add(x3y3);

		x4y4 = new JTextField();
		x4y4.setHorizontalAlignment(SwingConstants.CENTER);
		x4y4.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		x4y4.setEditable(false);
		x4y4.setColumns(10);
		x4y4.setBounds(187, 169, 49, 43);
		contentPane.add(x4y4);

		x4y3 = new JTextField();
		x4y3.setHorizontalAlignment(SwingConstants.CENTER);
		x4y3.setEditable(false);
		x4y3.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		x4y3.setColumns(10);
		x4y3.setBounds(128, 169, 49, 43);
		contentPane.add(x4y3);

		btnHelp = new JButton("\u5E2E\u52A9");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane,
						"2048�淨����\n���ͨ�����ϵĽ����ƶ�ָ��,ʹ�����ڵ����ֽ����ƶ�,��ֵ��\nͬ�����ַ������кϲ�,����Ҳû�п��Ժϲ��Ŀ�������Ϸ����", "����", -1);
			}
		});
		btnHelp.setBounds(246, 222, 108, 23);
		contentPane.add(btnHelp);

		btnGod = new JButton("\u9AD8\u5206\u699C");
		btnGod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * ��ʾ�߷ְ�
				 */
				// ���ø߷ְ񷽷�,����һ��String����
				String[] str = Realize.look();
				// ��ʾ��Ϣ
				String s = "";
				for (int i = 0; i < str.length; i++) {
					s += str[i];
					if (i != str.length - 1) {
						s += "\n";
					}
				}
				JOptionPane.showMessageDialog(contentPane, "��ʷ�߷�\n" + s, "�߷ְ�", 1);
			}
		});
		btnGod.setBounds(364, 222, 108, 23);
		contentPane.add(btnGod);

		Score = new JTextField();
		Score.setText("0");
		Score.setFont(new Font("����", Font.PLAIN, 16));
		Score.setEditable(false);
		Score.setBounds(331, 10, 133, 32);
		contentPane.add(Score);
		Score.setColumns(10);

		button = new JButton("\u8BFB\u6863");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * ʵ�ֶ����İ�ť
				 */
				// ʹ�÷�����ȡ�浵�ļ��ڵ���Ϣ,�ô浵����Ϊ���ͷ���һ������
				ArrayList<Store> storelist = Realize.readStore();
				// �������ڵ���Ϣת��ΪString���͵�����չʾ����
				String s = "";
				for (int i = 0; i < storelist.size(); i++) {
					s += "����:" + storelist.get(i).storeScore + "\t";
					s += "  ��ע:" + storelist.get(i).name;
					s += "\n";
				}
				String showInputDialog = JOptionPane.showInputDialog(contentPane, s, "ͨ����ע����", -1);// (contentPane,
				if (showInputDialog == null) {
					return;
				}
				// ��������û������ѡ��,�ҵ�������Ӧ�Ĵ浵��
				boolean boo = true;
				int[][] arr = new int[4][4];
				for (int i = 0; i < storelist.size(); i++) {
					if (storelist.get(i).name.equals(showInputDialog)) {
						// �Ѹô浵�ർ�뵽���ֿ���,�����ı�,��ɶ���!
						// �������ֿ�
						String ss = storelist.get(i).math;
						String[] split = ss.split("#");
						for (int j = 0; j < 4; j++) {
							String[] split2 = split[j].split("!");
							for (int n = 0; n < 4; n++) {
								arr[j][n] = Integer.parseInt(split2[n]);
							}
						}
						// ���ô����ֿ�ķ���
						arrayToLo(arr);
						// �ı����
						score = Integer.parseInt(storelist.get(i).storeScore);
						// ˢ�·�����
						Score.setText(storelist.get(i).storeScore);
						boo = false;
					}
				}
				if (boo) {
					JOptionPane.showMessageDialog(contentPane, "û�д˴浵");
				} else {
					JOptionPane.showMessageDialog(contentPane, "�����ɹ�");
				}
			}
		});
		button.setBounds(10, 255, 108, 23);
		contentPane.add(button);

		button_1 = new JButton("\u5B58\u6863");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * ʵ�ִ浵�İ�ť
				 */
				// ʵ��// TODO
				// ����������Ϣ�Ĵ���,����һ���ַ������͵�ֵ
				String showInputDialog = JOptionPane.showInputDialog(contentPane, "���뱸ע", "�浵", -1);
				// ���ַ��������ʵ����,�����ݴ洢���ļ���
				if (showInputDialog == null) {
					return;
				}
				if (showInputDialog.indexOf("@") > -1 || showInputDialog.indexOf("!") > -1
						|| showInputDialog.indexOf("#") > -1) {
					JOptionPane.showMessageDialog(contentPane, "��ע�����Ժ���  ! @ #");
					return;
				}
				boolean store = store(showInputDialog);
				if (store) {
					JOptionPane.showMessageDialog(contentPane, "�浵�ɹ�");
				} else {
					JOptionPane.showMessageDialog(contentPane, "��ע�����򲻴���!�浵ʧ��!");
				}
			}
		});
		button_1.setBounds(128, 255, 108, 23);
		contentPane.add(button_1);

		button_2 = new JButton("\u5220\u6863");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * ʵ��ɾ���ķ���
				 */
				// 1 . ��ȡ�ļ��ڵ���Ϣ
				ArrayList<Store> storelist = Realize.readStore();
				// 2 . ������Ϣ��,����û��������Ϣ��ʲô
				// �������ڵ���Ϣת��ΪString���͵�����չʾ����
				String s = "";
				for (int i = 0; i < storelist.size(); i++) {
					s += "����:" + storelist.get(i).storeScore + "\t";
					s += "  ��ע:" + storelist.get(i).name;
					s += "\n";
				}
				String showInputDialog = JOptionPane.showInputDialog(contentPane, s, "ͨ����עɾ���浵", 2);
				if (showInputDialog == null) {
					return;
				}
				// 3 . ������Ϣ���Ҽ���,�Ѷ�Ӧ����һ��ɾ����
				boolean boo = true;
				for (int i = 0; i < storelist.size(); i++) {
					if (storelist.get(i).name.equals(showInputDialog)) {
						storelist.remove(i);
						boo = false;
						break;
					}
				}
				if (boo) {
					JOptionPane.showMessageDialog(contentPane, "�˱�ע������");
					return;
				}
				// �����ַ����������
				BufferedWriter bfw = null;
				BufferedWriter bfw1 = null;
				try {
					bfw = new BufferedWriter(new FileWriter("./go on.txt"));
					bfw1 = new BufferedWriter(new FileWriter("./go on.txt", true));
					// 4 . ���go on�ļ�
					bfw.write("");
					// 5 . �Ѽ����ڵ���Ϣˢ�µ��ļ���
					for (int i = 0; i < storelist.size(); i++) { // ѭ��һ��дһ��
						String all = ""; // �洢��һ�е��ַ���
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
					// 6 . ����
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
				// 7 . ����ϸ��
				JOptionPane.showMessageDialog(contentPane, "ɾ���ɹ�");
			}
		});
		button_2.setBounds(246, 255, 108, 23);
		contentPane.add(button_2);

		JButton btnNewButton_1 = new JButton("\u6362\u80A4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * ʵ�ֱ�����ɫ�İ�ť
				 */
				// ��������ѡ�񻻷�
				String s = "�����Ż����Զ�����ɫ(���ŷָ�)\n1.��Ů��(255,153,255)\n2.޹����(238,130,238)\n3.��ˮ��(100,149,237)\n4.���Ѻ�(255,  69 ,  0  )\n5.������(144,238,144)\n6.���ʻ�(215,215,0)\n7.���̻�(169,169,169)";
				String colors = JOptionPane.showInputDialog(contentPane, s, "��������ɫ", -1);
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
						JOptionPane.showMessageDialog(contentPane, "��ɫ��ʽ����");
						return;
					}
					int a = Integer.parseInt(split[0]);
					int b = Integer.parseInt(split[1]);
					int c1 = Integer.parseInt(split[2]);
					if (a >= 0 && a <= 255 && b >= 0 && b <= 255 & c1 >= 0 && c1 <= 255) {
						c = new Color(a, b, c1);
					} else {
						JOptionPane.showMessageDialog(contentPane, "��ɫ��ʽ����");
						return;
					}
				}
				contentPane.setBackground(c);
			}
		});
		btnNewButton_1.setBounds(364, 255, 108, 23);
		contentPane.add(btnNewButton_1);

		textField = new JTextField();
		textField.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("\u5206\u6570");
		textField.setEditable(false);
		textField.setBounds(246, 10, 75, 32);
		contentPane.add(textField);
		textField.setColumns(10);
	}

	/**
	 * �������ڵ����ݸ�ֵ�����ֿ�
	 */
	public void arrayToLo(int[][] liferun) {
		// ����������ֿ�
		qingKong();
		// �ٽ������ڵ����ָ�ֵ�����ֿ�
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
	 * ������ֿ�
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

	// �����������ò����ķ���
	public void Csh() {
		// �����ֿ��ʼ��
		// ���ó�ʼ�����ֿ�ķ���
		int[][] csh = new int[4][4];
		csh = RandomInt.csh(csh);
		// �������ڵ�ֵ��ֵ�����ֿ�
		arrayToLo(csh);
		// �Ը�����ֵ̬��ʼ��
		Move.moveBoo = false;
		Add.addBoo = false;
		score = 0;
		Score.setText("0");
		Add.scoreAdd = 0;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub ���°���ʱ�����δ�

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub ����̧��ʱ�����˴�

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub ���̰�������ʲô��
		x1y1.setText("" + e.getKeyChar());
	}

	public boolean store(String string) {
		// TODO Auto-generated method stub
		// �����ַ����������
		// ���÷���������ֿ��������ʽ
		int[][] leftrun = Realize.of(x1y1, x1y2, x1y3, x1y4, x2y1, x2y2, x2y3, x2y4, x3y1, x3y2, x3y3, x3y4, x4y1, x4y2,
				x4y3, x4y4);
		// ���ô��淽��
		boolean save = Realize.save(leftrun, string);
		return save;
	}
}