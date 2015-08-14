package com.snap.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.snap.beans.CatalogTableBean;
import com.snap.beans.NearbyBean;
import com.snap.beans.ShopBean;
import com.snap.beans.UserBean;

public class DAOImpl implements DAO {
	private HibernateTemplate htemp;

	private SessionFactory sessionFactory;

	public void setHtemp(HibernateTemplate htemp) {
		this.htemp = htemp;
		sessionFactory = htemp.getSessionFactory();
		// System.out.println(sessionFactory);

	}

	public List<ShopBean> findNearbySectorShops(String category,int sector) {
		String query = "from NearbyBean where sector = ?";
		Object params[]  = {sector};
		List<NearbyBean> list  = htemp.find(query,params);
		List<ShopBean> ans = new ArrayList();
//		System.out.println(list.get(0).getKey().getNearby_sector());
		
		String q = "from ShopBean where sector = ? and category = ?";
		for (NearbyBean obj: list){
			System.out.println(obj.getKey().getNearby_sector());
			Object param[]=  {obj.getKey().getNearby_sector(),category};
			ShopBean shop = null;
			List<ShopBean> l2 = htemp.find(q,param);
			if(l2.size()!=0)
			shop=(ShopBean)l2.get(0);
			if (shop!=null)
				ans.add(shop);
			
		}
		if (ans!=null)
		return ans;
		return null;

	}

	public List<ShopBean> getShopByCategory(String category) {
		// TODO Auto-generated method stub

		String query = "from ShopBean " + "where category = ?";
		Object params[] = { category };
		List<ShopBean> list = htemp.find(query, params);
		// System.out.println(list.size());
		// for (ShopBean shop : list) {
		// System.out.println(shop.getShop_name());
		// }
	
		return list;
	}

	public List<ShopBean> getShopByCategoryArea(String category, int sector) {
		String query = "from ShopBean " + "where category = ? and sector =?";
		Object params[] = { category, sector };
		List<ShopBean> list = htemp.find(query, params);
		List<ShopBean> l2 = findNearbySectorShops(category,sector);
		if (l2!=null)
		list.addAll(l2);
		return list;
	}


	public List<ShopBean> getAllShops(String item) {
			// TODO Auto-generated method stub
			Set<Integer> id = new HashSet<Integer>();

			List<ShopBean> ans = new ArrayList<ShopBean>();
			String query = "select shop_id from CatalogTableBean where product_name like '%"
					+ item + "%'";
			List<Integer> list = htemp.find(query);
			id.addAll(list);
			for (int i : id) {
				ans.add((ShopBean) htemp.get(ShopBean.class, i));

			}
			
			if (ans.size()!=0)
				return ans;
			return null;

		}

	public int saveUser(String username, String email, String password,
			String address, String phoneno) {
		// TODO Auto-generated method stub
		UserBean user = new UserBean();
		user.setAddress(address);
		user.setEmail(email);
		user.setMobile(phoneno);
		user.setName(username);
		user.setPassword(password);
		htemp.save(user);
		return 1;
	}

	public UserBean getUser(String email) {
		// TODO Auto-generated method stub
		List<String> list = htemp.find("select name from UserBean");
		System.out.println(list.size());
		UserBean user = htemp.get(UserBean.class, email);
		System.out.println(user);
		return user;
	}

	public List<ShopBean> getShopsByItem(List<Integer> shop_id, String item) {
		// TODO Auto-generated method stub
		List<ShopBean> list = new ArrayList<ShopBean>();
		List<Integer> id = null;
		String q = "select shop_id from CatalogTableBean"
				+ " where  product_name like '%" + item + "%'";
		// Object[] params = {item};
		id = htemp.find(q);
		System.out.println(id.size());
		id.retainAll(shop_id);
		System.out.println(id.size() + " " + id.get(0));

		String query = "from ShopBean where shop_id=?";
		for (Integer i : id) {
			Object param[] = { i };
			list.add((ShopBean) htemp.get(ShopBean.class, i));
		}

		return list;
	}
	



	@Override
		public List<CatalogTableBean> listItems(int shop_id) {
			// TODO Auto-generated method stub
			List<CatalogTableBean> list = new ArrayList<CatalogTableBean>();
			String query = "from CatalogTableBean where shop_id = ?";
			Object params[] = {shop_id};
			return htemp.find(query,params);
			
			
			
		}

	@Override
	public String getShopName(int shop_id) {
		// TODO Auto-generated method stub
		
		ShopBean obj =  htemp.get(ShopBean.class, shop_id);
		return obj.getShop_name();
	}

}
