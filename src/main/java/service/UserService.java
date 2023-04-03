package service;

public class UserService {
	public static boolean validate(String id, String pass, String name) {
		if (!id.matches("[a-z][a-z0-9]{3,}")) {
			//{3,} 비밀번호 4자리
			return false;
		}
		if (pass.length() < 4) {
			return false;
		}
		if (name.length() < 2) {
			return false;
		}
		return true;
	}
	
	
}
