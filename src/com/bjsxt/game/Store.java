package com.bjsxt.game;

/**
 * 储存类,实现储存存档的方法
 * 
 * @author asus
 *
 */
public class Store {

	String math; // 数字块
	String storeScore; // 此时的分数
	String name; // 备注的名字

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
