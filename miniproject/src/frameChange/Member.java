package frameChange;

public class Member implements java.io.Serializable {
	private String userId, userPwd, userPwd2, userName, userBirth, userEmail, userEnumber, userPhone;
	
	public Member() {}
	
	public Member(String userId, String userPwd, String userName, String userBirth,
			String email, String phone) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userPwd2 = userPwd2;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userEmail = userEmail;
		this.userEnumber = userEnumber;
		this.userPhone = userPhone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserPwd2() {
		return userPwd2;
	}

	public void setUserPwd2(String userPwd2) {
		this.userPwd2 = userPwd2;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserEnumber() {
		return userEnumber;
	}

	public void setUserEnumber(String userEnumber) {
		this.userEnumber = userEnumber;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUsreName() {
		return userName;
	}

	public void setUsreName(String usreName) {
		this.userName = usreName;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userPwd2=" + userPwd2 + ", userName=" + userName
				+ ", userBirth=" + userBirth + ", userEmail=" + userEmail + ", userEnumber=" + userEnumber
				+ ", userPhone=" + userPhone + "]";
	}

}
