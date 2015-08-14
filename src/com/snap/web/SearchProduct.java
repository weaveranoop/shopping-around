package com.snap.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;

import com.snap.beans.CatalogTableBean;
import com.snap.beans.ShopBean;
import com.snap.client1.ApplicationContextUtil;
import com.snap.dao.DAO;
import com.snap.dao.DAOImpl;

/**
 * Servlet implementation class SearchProduct
 */
@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int shop_id = Integer.parseInt(request.getParameter("shop_id")); 
		//System.out.println(category);
		AbstractApplicationContext fac = ApplicationContextUtil.getAbstractApplicationContext();
		DAO dao = fac.getBean("mydao", DAOImpl.class);
		List<CatalogTableBean> lst = dao.listItems(shop_id);
		String shopname = dao.getShopName(shop_id);
		request.setAttribute("sname", shopname);
		request.setAttribute("plist", lst);
		RequestDispatcher rd = request.getRequestDispatcher("ProductList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String item = request.getParameter("item");
		//System.out.println(item);
		AbstractApplicationContext fac = ApplicationContextUtil.getAbstractApplicationContext();
		DAO dao = fac.getBean("mydao", DAOImpl.class);
		List<ShopBean> lst = dao.getAllShops(item);
		/*for(ShopBean sb : lst){
			System.out.println(sb.getShop_name());
		}*/
		request.setAttribute("slist", lst);
		RequestDispatcher rd = request.getRequestDispatcher("ShopListing.jsp");
		rd.forward(request, response);
	}

}
