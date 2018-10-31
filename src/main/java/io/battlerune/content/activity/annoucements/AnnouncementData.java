package io.battlerune.content.activity.annoucements;

public enum AnnouncementData {

	RUNITY_FUTURE("For more information regarding our plans with Runity do ::thread 145"),
	VOTING_COMPETITON("Top voter will get LOADS of Bonds as rewards! do ::thread 147 for more information!"),
	STORE("35% Of All Item's on the store! Do ::store to purchase them & support the server!"),
	GUIDE("Do ::guide to view a High Quality money making guide! Make Bank!"),
	UPDATES("Check Runity's Discord #Updates to view our latest Updates!!"),
	UPDATE_SCHEDULE("Here at Runity we tend to push 2-3 Updates a week!"),
	EVENTS_MONDAY("Did you know on Mondays, we give all of our players 15% Bonus Drop Rate Boost!"),
	EVENTS_TUESDAY("Did you know on Tuesdays, we give all of our players Double PK Points!"),
	EVENTS_WEDNESDAY("Did you know on Wednesdays, we give all of ours players Double AvO Tickets/Rewards!"),
	EVENTS_THURSDAY("Did you know on Thursdays, we give all of ours players Double AvO Tickets/Rewards!"),
	EVENTS_FRIDAY("Did you know on Fridays, we give all our players 30% Bonus Drop Rate Boost!"),
	EVENTS_SATURDAY("Did you know on Saturdays, we give all of our players Double Experience!"),
	EVENTS_SUNDAY("Did you know on Sundays, we give all of our players Double Experience!"),
	NORMAL_PRAYER("Having Unlimited prayer is completely intentional! We Implemented to make PvM'ing more easier"),
	DISCORD("Join ::discord We tend to post our #updates and host multiple #giveaways a day!"),
	DID_YOUKNOW("Did you know we released Double threat! Duo instanced minigame! Use the portal at home!!"),



	
	
	;
	
	private String content;
	
	AnnouncementData(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}

}
