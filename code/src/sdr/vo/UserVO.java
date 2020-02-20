package sdr.vo;

import java.util.Date;

public class UserVO {
	String userid;
	String userpwd;
	String username;
	String useraddr;
	String userphone;
	String ranks;
	String birth;
	String gender;
	String email;
	
	public UserVO() {
		super();
	}

	public UserVO(String userid, String userpwd, String username, String useraddr, String userphone, String ranks,
			String birth, String gender, String email) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.useraddr = useraddr;
		this.userphone = userphone;
		this.ranks = ranks;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseraddr() {
		return useraddr;
	}

	public void setUseraddr(String useraddr) {
		this.useraddr = useraddr;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getRanks() {
		return ranks;
	}

	public void setRanks(String ranks) {
		this.ranks = ranks;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", useraddr=" + useraddr
				+ ", userphone=" + userphone + ", ranks=" + ranks + ", birth=" + birth + ", gender=" + gender
				+ ", email=" + email + "]";
	}
	
}
