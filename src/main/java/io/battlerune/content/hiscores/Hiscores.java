package io.battlerune.content.hiscores;

import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.entity.skill.Skill;

public class Hiscores {

	private int[] experience = new int[26];
	
	private Player player;

	public Hiscores(Player player) {
		this.player = player;
	}

	public void execute() {
		switch (player.right) {
		case ULTIMATE_IRONMAN:
			com.everythingrs.hiscores.Hiscores.update("it0nzms11avukb49jofyr2j4iyeigg9m99i3uqugiaspds4ibwg9wfjv364piqs8tbb0yynwmi",  
					"Ultimate Ironman", player.getUsername(), player.right.ordinal(), getExperience(), player.debug);
			break;
		case IRONMAN:
			com.everythingrs.hiscores.Hiscores.update("it0nzms11avukb49jofyr2j4iyeigg9m99i3uqugiaspds4ibwg9wfjv364piqs8tbb0yynwmi",  
					"Ironman", player.getUsername(), player.right.ordinal(), getExperience(), player.debug);
			break;
		case HARDCORE_IRONMAN:
			com.everythingrs.hiscores.Hiscores.update("it0nzms11avukb49jofyr2j4iyeigg9m99i3uqugiaspds4ibwg9wfjv364piqs8tbb0yynwmi",  
					"Hardcore Ironman", player.getUsername(), player.right.ordinal(), getExperience(), player.debug);
			break;
		default:
			com.everythingrs.hiscores.Hiscores.update("it0nzms11avukb49jofyr2j4iyeigg9m99i3uqugiaspds4ibwg9wfjv364piqs8tbb0yynwmi",  
					"Normal Mode", player.getUsername(), player.right.ordinal(), getExperience(), player.debug);
			break;

		}
	}
	
	private int[] getExperience() {
		for(int i = 0; i < player.skills.getSkills().length; i++) {
			System.out.println("Experience: " + Skill.getExperienceForLevel(99));
			experience[i] = (int) player.skills.getSkills()[i].getExperience();
		}
		return experience;
	}
}
