package io.battlerune.content.scratchcard;

public enum ScratchCardData {

	FOURHUNDERD(1), FIVEHUNDERD(2), NINEHUNDERD(3);
	
	private int displayId;
	
	ScratchCardData(int displayId) {
		this.displayId = displayId;
	}
	
	public int getDisplayId() {
		return displayId;
	}

	public void setDisplayId(int displayId) {
		this.displayId = displayId;
	}

}
