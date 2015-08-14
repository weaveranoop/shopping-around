package com.snap.beans;

import java.io.Serializable;

public class NearbyKey implements Serializable{
      private int sector;
      private int nearby_sector;
	public int getSector() {
		return sector;
	}
	public void setSector(int sector) {
		this.sector = sector;
	}
	public int getNearby_sector() {
		return nearby_sector;
	}
	public void setNearby_sector(int nearby_sector) {
		this.nearby_sector = nearby_sector;
	}
      
}
