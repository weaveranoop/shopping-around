package com.snap.beans;

import java.io.Serializable;

public class ShopBySectorKey implements Serializable {
	private int sector;
	private int shop_id;
	public int getSector() {
		return sector;
	}
	public void setSector(int sector) {
		this.sector = sector;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	

}
