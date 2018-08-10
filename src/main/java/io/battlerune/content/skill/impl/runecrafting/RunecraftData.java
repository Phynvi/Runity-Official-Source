package io.battlerune.content.skill.impl.runecrafting;

import java.util.Arrays;
import java.util.Optional;

/** Holds the runecrafting data - @author Daniel */
public enum RunecraftData {
	AIR(14897, 556, 6.0D, new int[] { 1, 11, 22, 33, 44, 55, 66, 77, 88, 99 }, 5000),
	MIND(14898, 558, 6.5D, new int[] { 1, 14, 28, 42, 56, 70, 84, 98 }, 15000),
	WATER(14899, 555, 7.0D, new int[] { 5, 19, 38, 57, 76, 95 }, 17500), EARTH(14900, 557, 7.5D, new int[] { 9, 26, 52, 78 }, 25000),
	FIRE(14901, 554, 8.0D, new int[] { 14, 35, 70 }, 25000), BODY(14902, 559, 8.5D, new int[] { 20, 46, 92 }, 30000),
	COSMIC(14903, 564, 10.0D, new int[] { 27, 59 }, 35000), CHAOS(14906, 562, 10.5D, new int[] { 35, 74 }, 50000),
	NATURE(14905, 561, 11.0D, new int[] { 44, 91 }, 75000), LAW(14904, 563, 10.5D, new int[] { 54 }, 100000),
	DEATH(14907, 560, 12.0D, new int[] { 65 }, 175000), BLOOD(27978, 565, 12.5D, new int[] { 77 }, 250000);
	//TODO ADAM RUNECRAFTING.

	/** The object identification. */
	private final int object;

	/** The runes obtained. */
	private final int runes;

	/** The experience rewarded. */
	private final double experience;

	/** The multiplier. */
	private final int[] multiplier;
	
	private int money;

	/** The runecrafting data. */
	RunecraftData(int object, int runes, double experience, int[] multiplier, int money) {
		this.object = object;
		this.runes = runes;
		this.experience = experience;
		this.multiplier = multiplier;
		this.money = money;
	}

	/** Gets the object identification. */
	public int getObject() {
		return object;
	}

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	/** Gets the level required. */
	public int getLevel() {
		return multiplier[0];
	}

	/** Gets the multiplier. */
	public int[] getMultiplier() {
		return multiplier;
	}

	/** Gets the runes obtained. */
	public int getRunes() {
		return runes;
	}

	/** Gets the experience rewarded. */
	public double getExperience() {
		return experience;
	}

	/** Gets the runecrafting data based on the object. */
	public static Optional<RunecraftData> forId(int id) {
		return Arrays.stream(values()).filter(a -> a.object == id).findAny();
	}
}
