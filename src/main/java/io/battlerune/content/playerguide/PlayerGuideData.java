package io.battlerune.content.playerguide;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendURL;

/**
 * Stores the player guide data
 * @author Nerik#8690
 *
 */
public enum PlayerGuideData {

	ECONOMY_INFO(-9485, PlayerGuideDifficulty.EASY, "Main Currency?", new String[] {
			"Our economy is built by the players,", "We have introduced 1Bill and 500 Mill Tickets."
			,"Bosses mainly drop these tickets", "They can also be obtained from MBoxe's", "& From donating & Voting.", 
			"They can be spent in various shops ", "all over Runity", "such as the Rare Store and Customs store", "& PVM & Misc Items Store!"}),
	
	MONEY_MAKING(-9484, PlayerGuideDifficulty.EASY, "Making Bank?", new String[] {
			"", "", "", "", "", "", "", "",
	}),
	
	
	
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