package com.bjsxt.game;

/**
 * ������,ʵ�ִ���浵�ķ���
 * 
 * @author asus
 *
 */
public class Store {

	String math; // ���ֿ�
	String storeScore; // ��ʱ�ķ���
	String name; // ��ע������

	public Store(String math, String storeScore, String name) {
		super();
		this.math = math;
		this.storeScore = storeScore;
		this.name = name;
	}

	public Store() {
		super();
	}

	@Override
	public String toString() {
		return "Store [math=" + math + ", storeScore=" + storeScore + ", name=" + name + "]";
	}

}
