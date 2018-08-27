package io.battlerune.content.experiencerate;

import io.battlerune.game.world.entity.mob.player.PlayerRight;

/***
 * Experience rate modifier
 * @author Nerik#8690
 *
 */
public enum ExperienceData {

	NORMAL(PlayerRight.PLAYER, 7.5),
	HELPER(PlayerRight.HELPER, 7.5),
	MODERATOR(PlayerRight.MODERATOR, 7.5),
	ADMINISTRATOR(PlayerRight.ADMINISTRATOR, 7.5),
	DEVELOPER(PlayerRight.DEVELOPER, 7.5),
	OWNER(PlayerRight.OWNER, 7.5),

	
	DONATOR(PlayerRight.DONATOR, 8.0),
	SUPER_DONATOR(PlayerRight.SUPER_DONATOR, 8.5),
	EXTREME_DONATOR(PlayerRight.EXTREME_DONATOR, 9.0),
	ELITE_DONATOR(PlayerRight.ELITE_DONATOR, 9.5),
	KING_DONATOR(PlayerRight.KING_DONATOR, 10.0),
	SUPREME_DONATOR(PlayerRight.SUPREME_DONATOR, 15.0),
	YOUTUBER(PlayerRight.YOUTUBER, 15.0),
	GRAPHIC(PlayerRight.GRAPHIC, 15.0),

	
	IRONMAN(PlayerRight.IRONMAN, 5.0),
	ULTIMATE_IRONMAN(PlayerRight.ULTIMATE_IRONMAN, 3.5),
	HARDCORE_IRONMAN(PlayerRight.HARDCORE_IRONMAN, 2.5),
	CLASSIC(PlayerRight.CLASSIC, 2.0),

	;

	private PlayerRight mode;
	private double modifier;

	ExperienceData(PlayerRight mode, double modifier) {
		this.mode = mode;
		this.modifier = modifier;
	}

	public PlayerRight getMode() {
		return mode;
	}

	public double getModifier() {
		return modifier;
	}
}
