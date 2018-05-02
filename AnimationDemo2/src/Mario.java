

import java.awt.*;
import java.util.*;

import processing.core.PImage;

public class Mario extends Sprite {

	public static final int MARIO_WIDTH = 40;
	public static final int MARIO_HEIGHT = 60;

	public Mario(PImage img, int x, int y) {
		super(img, x, y, MARIO_WIDTH, MARIO_HEIGHT);
	}

	// METHODS
	public void walk(int dir) {
		// MOVES it left and right only
		moveByAmount(dir, 0);
	}

	public void jump() {
		// JUMP!
	}

	public void act(ArrayList<Shape> obstacles) {
		// FALL (and stop when a platform is hit)
		y += 2;
		boolean onGround = false;
		for(Shape s : obstacles) {
			if(s.intersects(this)) {
				onGround = true;
				break;
			}
		}
		if(onGround)
			y -= 2;
	}


}
