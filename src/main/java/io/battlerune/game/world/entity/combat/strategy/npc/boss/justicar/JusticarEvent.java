package io.battlerune.game.world.entity.combat.strategy.npc.boss.justicar;

import java.util.concurrent.TimeUnit;

import io.battlerune.game.task.Task;
import io.battlerune.game.world.World;
import io.battlerune.game.world.entity.mob.npc.Npc;
import io.battlerune.util.Stopwatch;

public class JusticarEvent extends Task {
	private Npc Justicar;
	private boolean initial;
	private final Stopwatch stopwatch = Stopwatch.start();

	public JusticarEvent() {
		super(false, 100);
		this.Justicar = null;
		this.initial = true;
	}

	@Override
	public void execute() {
		if ((Justicar == null || !Justicar.isRegistered()) && !initial) {
			initial = true;
			stopwatch.reset();
		}

		if (initial) {
			if (stopwatch.elapsedTime(TimeUnit.MINUTES) == 65) {
				Justicar = JusticarUtility.generateSpawn();
				initial = false;
				stopwatch.reset();
			}
			return;
		}

		if (stopwatch.elapsedTime(TimeUnit.MINUTES) == 15) {// 15 minutes
			initial = true;
			stopwatch.reset();
			if (Justicar != null) {
				Justicar.speak("Pathetic humans could not kill me! Muhahaha");
				World.schedule(2, () -> Justicar.unregister());
				World.sendMessage("[Justicar] You have failed to kill me! Muhahaha");
			}
			World.sendMessage("<col=ff0000> Justicar has disappeared! He will return in 30 minutes.");
		} else if (stopwatch.elapsedTime(TimeUnit.MINUTES) == 10) {// 10 minutes
			World.sendMessage("<col=ff0000> Justicar will disappear in 5 minutes!");
		} else if (stopwatch.elapsedTime(TimeUnit.MINUTES) == 5) {// 5 minutes
			World.sendMessage("<col=ff0000> Justicar will disappear in 10 minutes!");
		}
	}
}
