package io.battlerune.content.activity.annoucements;

public enum AnnouncementData {

	RUNITY_FUTURE("For more information regarding our plans with Runity do ::thread 145"),
	VOTING_COMPETITON("Top voter will get LOADS of Bonds as rewards! do ::thread 147 for more information!"),
	STORE("35% Of All Item's on the store! Do ::store to purchase them & support the server!"),
	GUIDE("Do ::guide to view a High Quality money making guide! Make Bank!"),

	
	
	;
	
	private String content;
	
	AnnouncementData(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}

}
