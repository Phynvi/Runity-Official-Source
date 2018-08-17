package io.battlerune.content.mysterybox;

public enum MysteryBoxType {

	MYSTERY_BOX(6199);

	private int id;

	MysteryBoxType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
