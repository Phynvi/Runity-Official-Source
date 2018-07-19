package io.battlerune.content.skill.impl.hunter.trap.impl;

import io.battlerune.content.skill.impl.hunter.trap.Trap;
import io.battlerune.content.skill.impl.hunter.trap.TrapState;
import io.battlerune.game.world.entity.mob.player.Player;
import io.battlerune.game.world.object.CustomGameObject;

public class SnareTrap extends Trap {

	private TrapState state;

	public SnareTrap(CustomGameObject obj, TrapState state, int ticks, Player p) {
		super(obj, state, ticks, p);
	}

	/**
	 * @return the state
	 */
	public TrapState getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(TrapState state) {
		this.state = state;
	}

}
