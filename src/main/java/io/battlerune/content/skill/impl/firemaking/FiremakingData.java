package io.battlerune.content.skill.impl.firemaking;

import java.util.Arrays;
import java.util.Optional;

public enum FiremakingData {
	TEAK_LOG(6333, 80, 35, 105.0D, 5000),
	ARCTIC_PINE_LOG(10810, 100, 42, 150.0D, 12500), 
	NORMAL_LOG(1511, 50, 1, 175.0D, 1000),
	OAK_LOG(1521, 55, 15, 300.0D, 2500),
	MOHOGANY_LOG(6332, 400, 50, 300.5D, 20000), 
	EUCALYPTUS_LOG(12581, 500, 58, 350.5D, 20000),
	WILLOW_LOG(1519, 60, 30, 400.0D, 3500), 
	AFK_LOGS(2862, 60, 1, 400.0D, 3500), 
	MAPLE_LOG(1517, 300, 45, 475.0D, 15000),
	YEW_LOG(1515, 750, 60, 575.5D, 17500),
	MAGIC_LOG(1513, 2500, 75, 675.5D, 25000);

	private final int log;

	private final int coins;

	private final int level;

	private final double exp;

	public int money;

	FiremakingData(int log, int coins, int level, double exp, int money) {
		this.log = log;
		this.coins = coins;
		this.level = level;
		this.exp = exp;
		this.money = money;
	}

	public int getLog() {
		return log;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getCoins() {
		return coins;
	}

	public int getLevel() {
		return level;
	}

	public double getExperience() {
		return exp;
	}

	public static Optional<FiremakingData> forId(int id) {
		return Arrays.stream(values()).filter(a -> a.log == id).findAny();
	}

}