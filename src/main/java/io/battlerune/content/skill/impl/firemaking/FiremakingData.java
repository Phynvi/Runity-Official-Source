package io.battlerune.content.skill.impl.firemaking;

import java.util.Arrays;
import java.util.Optional;

public enum FiremakingData {
	NORMAL_LOG(1511, 50, 1, 150.0D, 1000), ACHEY_LOG(2862, 25, 1, 40.0D, 1500), OAK_LOG(1521, 55, 15, 300.0D, 2500),
	WILLOW_LOG(1519, 60, 30, 450.0D, 3500), TEAK_LOG(6333, 80, 35, 105.0D, 5000), ARCTIC_PINE_LOG(10810, 100, 42, 125.0D, 12500),
	MAPLE_LOG(1517, 300, 45, 575.0D, 15000), MOHOGANY_LOG(6332, 400, 50, 300.5D, 20000), EUCALYPTUS_LOG(12581, 500, 58, 300.5D, 20000),
	YEW_LOG(1515, 750, 60, 500.5D, 17500), MAGIC_LOG(1513, 2500, 75, 650.5D, 25000);

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