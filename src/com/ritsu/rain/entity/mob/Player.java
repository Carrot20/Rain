package com.ritsu.rain.entity.mob;

import com.ritsu.rain.Game;
import com.ritsu.rain.graphics.Screen;
import com.ritsu.rain.graphics.Sprite;
import com.ritsu.rain.input.Keyboard;
import com.ritsu.rain.input.Mouse;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_back;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_back;
	}

	public void update() {
		int xa = 0, ya = 0;
		if (anim < 7500) {
			anim++;
		} else {
			anim = 0;
		}
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}

		updateShooting();

	}

	private void updateShooting() {
		if (Mouse.getButton() == 1) {
			double dx = Mouse.getX() - (Game.width / 2);
			double dy = Mouse.getY() - (Game.height / 2);
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
		}
	}

	public void render(Screen screen) {
		int flip = 0;
		if (dir == 0) {
			sprite = Sprite.player_forward;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_forward_1;
				} else {
					sprite = Sprite.player_forward_2;
				}
			}
		}
		if (dir == 1) {
			sprite = Sprite.player_side;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_side_1;
				} else {
					sprite = Sprite.player_side_2;
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.player_back;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_back_1;
				} else {
					sprite = Sprite.player_back_2;
				}
			}
		}
		if (dir == 3) {
			sprite = Sprite.player_side;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_side_1;
				} else {
					sprite = Sprite.player_side_2;
				}
			}
			flip = 1;
		}
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}

}
