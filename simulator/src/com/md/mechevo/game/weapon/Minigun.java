package com.md.mechevo.game.weapon;


import com.md.mechevo.game.Player;
import com.md.mechevo.game.Solid;
import com.md.mechevo.game.State;
import com.md.mechevo.game.projectile.Bullet;
import com.md.mechevo.game.projectile.Projectile;

public class Minigun extends Weapon {
	public Minigun(Player player) {
		super(20, 0.5f, player);
	}

	public void fire(State state, Solid target) {
		if (target != null) {
			double angle = super.getAngleToTarget(target);
			Projectile proj =
					new Bullet(state.getNextId(), this.getOwner().getPosition(), this.getOwner()
							.getAngle() + angle, this);
			state.addProjectile(proj);
		} else {
			Projectile proj =
					new Bullet(state.getNextId(), this.getOwner().getPosition(), this.getOwner()
							.getAngle(), this);
			state.addProjectile(proj);
		}
	}
}
