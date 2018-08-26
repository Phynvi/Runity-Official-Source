package io.battlerune.content.experiencerate;

import io.battlerune.game.world.entity.mob.player.Player;

/**
 * Adjusts the experience rate
 * @author Nerik#8690
 *
 */
public class ExperienceModifier {

	private Player player;
	
	public ExperienceModifier(Player player) {
		this.player = player;
	}
	
	public double getModifier() {
		for(ExperienceData experience : ExperienceData.values()) {
			if(experience.getMode().equals(player.right)) {
				return experience.getModifier();
			}
		}
		return 1.0;
	}
	
}
