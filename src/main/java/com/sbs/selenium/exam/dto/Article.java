package com.sbs.selenium.exam.dto;

public class Article {

	private int no;
	private String title;
	private String writer;
	private String dateTime;
	private int hit;
	private int recommand;
	
	public Article(int no, String title, String writer, String dateTime, int hit, int recommand) {
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.dateTime = dateTime;
		this.hit = hit;
		this.recommand = recommand;
		
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getRecommand() {
		return recommand;
	}
	public void setRecommand(int recommand) {
		this.recommand = recommand;
	}
	
	
}
