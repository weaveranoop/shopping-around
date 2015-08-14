package com.snap.web;

import java.io.IOException;

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
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignUp() {
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
		String username = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phoneno = request.getParameter("contact");
	
		String view = null;
		HttpSession sess = request.getSession();
		AbstractApplicationContext fac = ApplicationContextUtil.getAbstractApplicationContext();
		DAO dao = fac.getBean("mydao", DAOImpl.class);
		UserBean user = dao.getUser(email);
		
		if(user == null){
			/*System.out.println("in");
			System.out.println(address);
			System.out.println(password);
			System.out.println("out");*/
			int status = dao.saveUser(username,email,password,address,phoneno);
			if(status == 1){
				view ="Sucess.jsp";
			}
		}
		else{
			view ="SignupPage.jsp";
		}
		System.out.println(view);
		response.sendRedirect(view);
	}

}
