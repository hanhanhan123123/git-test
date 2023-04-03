package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 쿠키?
		// 브라우저에서 관리되는 것으로 일종의 데이터를 담긴 일종의 파일이라고 보면 된다.
		// 쿠키에는 도메인값이 있는데 (쿠키 발행처) 브라우저는 웹 요청을 보낼때 발행처가 같다면
		// 쿠키를 같이 포함시켜 전송을 하게 되어있다.

		// 백엔드 쪽에서는 클라이언트가 보낸 쿠키들을 확인하는게 가능하다.
		Cookie[] cookies = req.getCookies(); // 가지고 오는 쿠키가 없다면 null
		if (cookies != null) {
			for (Cookie c : cookies) {
				System.out.println("==>"+c.toString());
			}
		}else {
			System.out.println("not found cookid");
		}
		req.getRequestDispatcher("/WEB-INF/views/test.jsp").forward(req, resp);
	}
}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		String message = " 와우 드디어 금요일 ";
//		//System.out.println(BCrypt.gensalt());
//		String salt ="$2a$10$pOKX4m8m5q3K17DQCIUv1O";
//		
//		for(int cnt =1; cnt<=5; cnt++) {
//			String hashed = BCrypt.hashpw(message, BCrypt.gensalt());//DB저장
//			
//			System.out.println(hashed);
//			boolean f= message.equals(hashed);
//			System.out.println("string.equals="+f);
//			
//			boolean ff = BCrypt.checkpw(message, hashed);
//			System.out.println("BCrypt.checkpw = "+ff);		
//		}		
//	}
