package com.example.teamb_project.vo;

import java.sql.Date;

public class CounselVO {
	private int counsel_code, writer, receiver;
	private String title, content, answer, writer_name, receiver_name;
	private Date write_date, answer_date;

	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

	public String getWriter_name() {
		return writer_name;
	}

	public String getReceiver_name() {
		return receiver_name;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setAnswer_date(Date answer_date) {
		this.answer_date = answer_date;
	}

	public String getAnswer() {
		return answer;
	}

	public Date getAnswer_date() {
		return answer_date;
	}

	public int getCounsel_code() {
		return counsel_code;
	}
	public void setCounsel_code(int counsel_code) {
		this.counsel_code = counsel_code;
	}
	public int getWriter() {
		return writer;
	}
	public void setWriter(int writer) {
		this.writer = writer;
	}
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	
	
}
