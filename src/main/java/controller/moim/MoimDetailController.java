package controller.moim;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Attendance;
import data.Moim;
import data.User;
import repository.Attendances;
import repository.Moims;
import repository.Users;
@WebServlet("/moim/detail")
public class MoimDetailController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//링크를 타고 들어오는건 doget으로 만들면 됨
		String id = req.getParameter("id");
		//모임정보를 찾고 못찾으면 null , 찾으면 id찾아서 매니저로 등록
		Moim moim = Moims.findById(id);
		if(moim==null) {
			resp.sendRedirect("/moim/search");
			return;
		}
		req.setAttribute("moim", moim);
		//조인을 걸기 싫다면 유저에 투스트링 만들어놓고 
		//User manager = Users.findById(moim.getManagerId());
		//req.setAttribute("manager", manager);
		
		
		//조인을 안걸어놔서 리스트를 돌면서 반복문 돌면서 세팅
		
		//현재 로그인하고 있는 사용자는 로그온유저를 담아놨으니까 뽑고(캐스팅)
		User manager = 	Users.findById(moim.getManagerId());
		req.setAttribute("manager", manager);
		//문제! 로그인 안하고 들어오면 터짐. 그걸  해결할 코드
		List<Attendance> attendances = Attendances.findByMoimId(id);
		
		//for문으로 반복문 돌면서 아이디가 들어있는지 뽑고
		for(Attendance a : attendances) {
			User found = Users.findById(a.getUserId());
			a.setUserAvatarURL(found.getAvatarURL());
			a.setUserName(found.getName());
		}
		req.setAttribute("attendances", attendances);
		
		User logonUser = (User)req.getSession().getAttribute("logonUser");
		if(logonUser == null) {
			req.setAttribute("status", -1);
			//-1이라면 버튼을 못누르게 막을 것임
		}else {
			int status = Attendances.findUserStatusInMoim(id, logonUser.getId());
			req.setAttribute("status", status);
		}
			
		
				
		//뷰로 넘기는 작업은 패스
		req.getRequestDispatcher("/WEB-INF/views/moim/detail.jsp").forward(req, resp);
	}

}