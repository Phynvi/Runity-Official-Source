package io.battlerune.content.experiencerate;

import io.battlerune.game.world.entity.mob.player.PlayerRight;

/***
 * Experience rate modifier
 * 
 * @author Nerik#8690
 *
 */
public enum ExperienceData {

	NORMAL(PlayerRight.PLAYER, 30.0), HELPER(PlayerRight.HELPER, 35.0), MODERATOR(PlayerRight.MODERATOR, 35.0),
	ADMINISTRATOR(PlayerRight.ADMINISTRATOR, 35.0), DEVELOPER(PlayerRight.DEVELOPER, 35.0), OWNER(PlayerRight.OWNER, 35.0),

	DONATOR(PlayerRight.DONATOR, 20.0), SUPER_DONATOR(PlayerRight.SUPER_DONATOR, 21.0),
	EXTREME_DONATOR(PlayerRight.EXTREME_DONATOR, 22.0), ELITE_DONATOR(PlayerRight.ELITE_DONATOR, 23.0),
	KING_DONATOR(PlayerRight.KING_DONATOR, 24.0), SUPREME_DONATOR(PlayerRight.SUPREME_DONATOR, 25.0),
	YOUTUBER(PlayerRight.YOUTUBER, 36.0), GAMBLE_MANAGER(PlayerRight.GAMBLE_MANAGER, 37.0),
	DONATION_MANAGER(PlayerRight.DONATION_MANAGER, 38.0),

	IRONMAN(PlayerRight.IRONMAN, 15.0), ULTIMATE_IRONMAN(PlayerRight.ULTIMATE_IRONMAN, 12.5),
	HARDCORE_IRONMAN(PlayerRight.HARDCORE_IRONMAN, 5.0), CLASSIC(PlayerRight.CLASSIC, 2.0);

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
