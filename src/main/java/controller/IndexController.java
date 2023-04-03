package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.Moim;
import repository.Moims;

/*
 * 웰컴 처리하는 컨트롤러
 */
@WebServlet("/index")
public class IndexController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Date today = new Date();
		req.setAttribute("today", today);
	
		
		SqlSessionFactory factory = (SqlSessionFactory )
				req.getServletContext().getAttribute("sqlSessionFactory");
				
		SqlSession session = factory.openSession();
		//select sql은 selectOne or selectList 여러건이 나오면 selectList
		List<Moim> result = session.selectList("moims.findLatest"); 
		//한개짜리 뽑을땐	//Moim moim = session.selectOne("moim.findLatest");
		//모임매핑에 namespace="moims" id="findLatest" //이 명령문으로 수행하고 리스트로 추출
		System.out.println(result);
		
		//List<Moim> list =Moims.findLatest();
		//jdbc방식으로 만들었다. 순수하게 오라클에서 제공하는 방법
		
		session.close(); //mybatis에서 한 곳은 다 클로즈해주기!
		
		req.setAttribute("latest", result);
		req.setAttribute("millis", System.currentTimeMillis());
		
		req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
	}
}
