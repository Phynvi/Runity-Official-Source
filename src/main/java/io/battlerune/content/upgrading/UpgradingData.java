package io.battlerune.content.upgrading;


/**
 * 
 * @author Adam_#6723 
 * Class which holds the upgrading data.
 */

public enum UpgradingData {
	
//	ICEKATANA(id, upgradedid, pointsrequired)
	ICE_KATANA(3273, "Ice Katana", 11647,  21820, 500),
	SAMURAI_SET(3274, "Samurai Set", 11647, 21820, 500),
	;
	
	public String itemname;
	public final int id;
	public final int upgradedid;
	public int requirement;
	public int pointsid;
	public int pointsrequired;
	
	UpgradingData(int id, String itemname, int upgradedid,int pointsid, int pointsrequired){
		this.id = id;
		this.itemname = itemname;
		this.upgradedid = upgradedid;
		this.pointsid = pointsid;
		this.pointsrequired = pointsrequired;
	}
	
	public String getItemname() {
		return itemname;
	}
	
	public int getId() {
		return id;
	}
	
	public int getPointsid() {
	 return pointsid;
	}
	
	public int getUpgradedId() {
		return upgradedid;
	}
	public int getPointsrequired() {
		return pointsrequired;
	}
	
	/**
	 * 
	 * @param Going to use this as a donator benefit / prestige perk.
	 * So users who have the perk activated get the pointsrequired / 2 or 3
	 */
	public void setpointsrequired(int pointsrequired) {
	    this.pointsrequired = pointsrequired;
	}
	

}
