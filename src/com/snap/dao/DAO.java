package com.snap.dao;

import java.util.List;
import java.util.Map;

import com.snap.beans.CatalogTableBean;
import com.snap.beans.ShopBean;
import com.snap.beans.UserBean;

public interface DAO {
	
	public int saveUser(String username, String email, String password,
			String address, String phoneno);
	public UserBean getUser(String email) ;
	public List<ShopBean> getShopByCategory(String category);
	public List<ShopBean> getShopByCategoryArea(String category,int sector);
	public List<ShopBean> getAllShops(String item);
	public List<ShopBean> getShopsByItem(List<Integer> shop_id, String item);
	public List<ShopBean> findNearbySectorShops(String category,int sector);
	public List<CatalogTableBean> listItems(int shop_id);
	public String getShopName(int shop_id);
	
	
	
}
