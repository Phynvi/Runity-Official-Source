package io.battlerune.content.store.currency.impl;

import io.battlerune.content.store.currency.Currency;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.net.packet.out.SendMessage;

public final class AllVsOnePointCurrency implements Currency {

	@Override
	public boolean tangible() {
		return false;
	}

	@Override
	public boolean takeCurrency(Player player, int amount) {
		if (player.allvsonepoint >= amount) {
			player.allvsonepoint -= amount;
			return true;
		} else {
			player.send(new SendMessage("You do not have enough vote points."));
			return false;
		}
	}

	@Override
	public void recieveCurrency(Player player, int amount) {
		player.allvsonepoint += amount;
	}

	@Override
	public int currencyAmount(Player player) {
		return player.allvsonepoint;
	}

	@Override
	public boolean canRecieveCurrency(Player player) {
		return true;
	}
}
