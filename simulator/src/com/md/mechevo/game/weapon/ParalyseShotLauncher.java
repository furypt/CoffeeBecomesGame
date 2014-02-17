package com.md.mechevo.game.weapon;

import com.md.mechevo.game.Player;
import com.md.mechevo.game.Solid;
import com.md.mechevo.game.State;
import com.md.mechevo.game.projectile.ParalyseShot;
import com.md.mechevo.game.projectile.Projectile;

public class ParalyseShotLauncher extends Weapon {
	public ParalyseShotLauncher(Player player) {
		super(15, 5, player);
	}

	@Override
	public void fire(State state, Solid target) {
		if (target != null) {
			double angle = super.getAngleToTarget(target);
			Projectile proj =
					new ParalyseShot(state.getNextId(), this.getOwner().getPosition(), this
							.getOwner().getAngle() + angle, this);
			state.addProjectile(proj);
		} else {
			Projectile proj =
					new ParalyseShot(state.getNextId(), this.getOwner().getPosition(), this
							.getOwner().getAngle(), this);
			state.addProjectile(proj);
		}
	}
}
