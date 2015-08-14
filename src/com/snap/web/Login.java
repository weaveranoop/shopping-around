package com.snap.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.AbstractApplicationContext;

import com.snap.beans.UserBean;
import com.snap.client1.ApplicationContextUtil;
import com.snap.dao.DAO;
import com.snap.dao.DAOImpl;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess = request.getSession(false);
		if(sess!=null) {
			sess.invalidate();
		}
		response.sendRedirect("SignupPage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("lemail");
		String password = request.getParameter("lpwd");
//	    System.out.println(email);
//	    System.out.println(password);
		String view = null;
		AbstractApplicationContext fac = ApplicationContextUtil.getAbstractApplicationContext();
		DAO dao=fac.getBean("mydao",DAOImpl.class);
		
		UserBean user = dao.getUser(email);
		System.out.println(user.getPassword());
		if(user != null){
			String pwd = (String) user.getPassword();
			if(pwd.equals(password)){
				HttpSession sess = request.getSession();
				sess.setAttribute("username", user.getName());
				view = "Page2.jsp";
			}
			else{
				view ="SignupPage.jsp";
			}
		}
		else{
			view ="SignupPage.jsp";
		}
		//System.out.println(view);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		//response.sendRedirect(view);
	}

}
