package vo;

import java.sql.Date;


public class HomeworkSubmitVO {
	private String member_name, content;
	private int submit_code, homework_code, member_code, state, subcnt, notcnt;
	private Date submitdate;
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
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

