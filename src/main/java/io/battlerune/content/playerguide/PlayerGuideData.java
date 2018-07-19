package io.battlerune.content.playerguide;

/**
 * Stores the player guide data
 * 
 * @author Nerik#8690
 *
 */
public enum PlayerGuideData {

	ECONOMY_INFO(-9485, PlayerGuideDifficulty.EASY, "Main Currency?",
			new String[] { "Our economy is built by the players,", "We have introduced 1Bill and 500 Mill Tickets.",
					"Bosses mainly drop these tickets", "They can also be obtained from MBoxe's",
					"& From donating & Voting.", "They can be spent in various shops ", "all over Runity",
					"such as the Rare Store and Customs store", "& PVM & Misc Items Store!" }),

	MONEY_MAKING(-9484, PlayerGuideDifficulty.EASY, "Making Bank?",
			new String[] { "There are various ways in which a player can obtain money on runity.",
					"One of most effective ways is PvM'ing", "& Skilling.",
					"Runity Has over 30+ Bosses with various drops.", "NPC Drops can be found here ::drops",
					"and the teleports can be accessed on the bottom left Tab.",
					"Custom Item's can be obtained from majority of these bosses,", "Aswell as Mystery boxes.",
					"There are more money making guide's by watching Jordan's Video.", }),

	;

	private int buttonId;
	private PlayerGuideDifficulty difficulty;
	private String title;
	private String[] content;

	PlayerGuideData(int buttonId, PlayerGuideDifficulty difficulty, String title, String[] content) {
		this.buttonId = buttonId;
		this.difficulty = difficulty;
		this.title = title;
		this.content = content;
	}

	public int getButtonId() {
		return buttonId;
	}

	public PlayerGuideDifficulty getDifficulty() {
		return difficulty;
	}

	public String getTitle() {
		return title;
	}

	public String[] getContent() {
		return content;
	}

}
