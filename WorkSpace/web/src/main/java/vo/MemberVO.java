package vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

public class MemberVO {
	private int member_code, lecture_code;
	private String type, profilepath, phone, gender, id, pw, member_name, email, address, post, salt, lecture_name;
	private Date birth;
	
	
	
	public int getLecture_code() {
		return lecture_code;
	}
	public void setLecture_code(int lecture_code) {
		this.lecture_code = lecture_code;
	}
	public String getLecture_name() {
		return lecture_name;
	}
	public void setLecture_name(String lecture_name) {
		this.lecture_name = lecture_name;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public int getMember_code() {
		return member_code;
	}
	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProfilepath() {
		return profilepath;
	}
	public void setProfilepath(String profilepath) {
		this.profilepath = profilepath;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	
}
