package io.battlerune.content.scratchcard;

public enum ScratchCardData {

	ABYSSAL_WHIP(4151), ABYSSAL_DAGGER(13265), ABYSSAL_BLUDGEON(13263);
	
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
