package vo;

import java.sql.Date;


public class HomeworkVO {
	private String title, content, filename, filepath;
	private int homework_code, state, lecture_code, member_code, student_code;
	private Date writedate, duedate;
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getHomework_code() {
		return homework_code;
	}
	public void setHomework_code(int homework_code) {
		this.homework_code = homework_code;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getLecture_code() {
		return lecture_code;
	}
	public void setLecture_code(int lecture_code) {
		this.lecture_code = lecture_code;
	}
	public int getMember_code() {
		return member_code;
	}
	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}
	public int getStudent_code() {
		return student_code;
	}
	public void setStudent_code(int student_code) {
		this.student_code = student_code;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	
	
}
