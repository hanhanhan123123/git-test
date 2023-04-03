package data;

public class User {
	
	//데이터베이스 테이블 유형 보고 만들면 됨
		String id;
		String pass;
		String name;
		String avatarId;
		String avatarURL;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAvatarId() {
			return avatarId;
		}
		public void setAvatarId(String avatarId) {
			this.avatarId = avatarId;
		}
		public String getAvatarURL() {
			return avatarURL;
		}
		public void setAvatarURL(String avatarURL) {
			this.avatarURL = avatarURL;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}

}
