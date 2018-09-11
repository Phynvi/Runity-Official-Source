package io.battlerune.game.world.entity.combat;

import io.battlerune.game.world.entity.combat.formula.MagicFormula;
import io.battlerune.game.world.entity.combat.formula.MeleeFormula;
import io.battlerune.game.world.entity.combat.formula.RangedFormula;
import io.battlerune.game.world.entity.combat.strategy.basic.MeleeStrategy;
import io.battlerune.game.world.entity.mob.Mob;

public enum CombatType {
	
	MELEE(new MeleeFormula()), 
	
	RANGED(new RangedFormula()), 
	
	MAGIC(new MagicFormula());

	public FormulaModifier<Mob> formula;

	CombatType(FormulaModifier<Mob> formula) {
		this.formula = formula;
	}
	
	public FormulaModifier<Mob> getFormula() {//im retarded..
		return formula;
	}
}
