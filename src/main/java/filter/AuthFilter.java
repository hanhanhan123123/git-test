package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.User;
/*
 * 블랙리스트 차단 . 그룹화 시켜서 할 수 있음
 * 필터를 걸고 하고싶은일은 doFilter에 적음
 * 가도 되면 체인.두필터
 */
@WebFilter({"/moim/create","/moim/join-task"}) //필터대상 
//2개이상일때는 @webFilter({"/home/index.jsp", "/home/following.jsp"})
public class AuthFilter extends HttpFilter{
	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String uri = request.getRequestURI();//이 필터가 어디서 작동하는지 찍어줄 수 있다.
		
		
		//if를 걸어서 현재 요청을 보낸 사용자의 세션에 logon값이 true면 통과를 시키고
		//그게 아니면 /flow/login.jsp로 리 다이렉트 시키는 필터를 만들어 보자 
		
		boolean logon = (boolean)request.getSession().getAttribute("logon");
		User logonUser = (User)request.getSession().getAttribute("logonUser");
		
		if(!logon || logonUser == null) {
			response.sendRedirect("/user/login?url="+uri);//필터 통화시켜주는 방법 
			//그 다음필터가 있다면 그걸 작동시켜주고 필터가 없다면 목적지로 도착시켜준다.
		}else {
			chain.doFilter(request, response);// 사용자는 목적지를 못가고 튕김
		}
		//아래 방법으로 해도 됨
		//if(!logon && logonUser == null) {
		//	response.sendRedirect("/flow/login.jsp");
		//}else {
		//	chain.doFilter(request, response);
		}
	}