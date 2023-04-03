package controller.moim;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Moim;
import repository.Moims;

@WebServlet("/moim/search")
public class MoimSearchController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//여러가지를 넘겨야 할때는 배열로 넘겨야 한다 Values 
		// 같은 이름으로 여러개의 데이터를 넘길때는 Values
		String[] cates = req.getParameterValues("cate");
		//System.out.println(Arrays.toString(cate));
		//파라미터는 0번째꺼 리턴
		
		List<Moim> list = Moims.findByCate(cates);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/moim/search.jsp").forward(req, resp);	
		
	}
}
