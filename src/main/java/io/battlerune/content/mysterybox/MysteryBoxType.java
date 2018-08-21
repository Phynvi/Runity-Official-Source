package io.battlerune.content.mysterybox;

/**
 * Type of mystery box
 * @author Nerik#8690
 *
 */
public enum MysteryBoxType {

	MYSTERY_BOX(6199), SILVER_MBOX(12955);

	private int id;

	MysteryBoxType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
