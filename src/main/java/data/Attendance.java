package data;

public class Attendance {

	int id;
	String userId;
	String moimId;
	int status;
	
	String UserName;
	String userAvatarURL;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMoimId() {
		return moimId;
	}
	public void setMoimId(String moimId) {
		this.moimId = moimId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserAvatarURL() {
		return userAvatarURL;
	}
	public void setUserAvatarURL(String userAvatarURL) {
		this.userAvatarURL = userAvatarURL;
	}
	@Override
	public String toString() {
		return "Attendance [id=" + id + ", userId=" + userId + ", moimId=" + moimId + ", status=" + status
				+ ", UserName=" + UserName + ", userAvatarURL=" + userAvatarURL + ", getId()=" + getId()
				+ ", getUserId()=" + getUserId() + ", getMoimId()=" + getMoimId() + ", getStatus()=" + getStatus()
				+ ", getUserName()=" + getUserName() + ", getUserAvatarURL()=" + getUserAvatarURL() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}