package com.example.teamb_project.vo;

import java.sql.Date;

public class HomeworkSubmitVO {
	private int submit_code, homework_code, member_code, state, subcnt, notcnt;
	private Date submitdate;

	public int getSubmit_code() {
		return submit_code;
	}

	public void setSubmit_code(int submit_code) {
		this.submit_code = submit_code;
	}

	public int getHomework_code() {
		return homework_code;
	}

	public void setHomework_code(int homework_code) {
		this.homework_code = homework_code;
	}

	public int getMember_code() {
		return member_code;
	}

	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getSubcnt() {
		return subcnt;
	}

	public void setSubcnt(int subcnt) {
		this.subcnt = subcnt;
	}

	public int getNotcnt() {
		return notcnt;
	}

	public void setNotcnt(int notcnt) {
		this.notcnt = notcnt;
	}

	public Date getSubmitdate() {
		return submitdate;
	}

	public void setSubmitdate(Date submitdate) {
		this.submitdate = submitdate;
	}
}
