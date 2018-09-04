package io.battlerune.content.activity.annoucements;

public enum AnnouncementData {

	RSGP("@red@ Contact Jordan (Owner) for anything related to rsgp donations!");
	
	private String content;
	
	AnnouncementData(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}

}
