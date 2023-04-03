package service;

import javax.servlet.http.Cookie;

public class CookieService {
	public static  Cookie findByName(Cookie[] cookies, String name) {
		//쿠키배열 주고 이름주면
		if(cookies == null) {
			return null;
			
		}
		Cookie found = null;
		for(Cookie c : cookies) {
			if(c.getName().equals(name)) {
				//찾고자 하는 이름 찾아
				//널이 아니라는건 찾긴 찾았다는 것!
				found = c;
				break;
			}
		}
		return found;
	}
	
}
