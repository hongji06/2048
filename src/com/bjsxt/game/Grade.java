package com.bjsxt.game;
//∏ﬂ∑÷¿‡
public class Grade {
	private String date;
	private int score;
	
	
	public Grade(String date, int score) {
		super();
		this.date = date;
		this.score = score;
	}
	public Grade() {
		super();
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Grade [date=" + date + ", score=" + score + "]";
	}
}
