

import java.awt.*;
import java.util.*;

import processing.core.PImage;

public class Mario extends Sprite {

	public static final int MARIO_WIDTH = 40;
	public static final int MARIO_HEIGHT = 60;
	
	private double yVel;
	private final double grav = 0.3;
	private boolean onGround, touchingWall;

	public Mario(PImage img, int x, int y) {
		super(img, x, y, MARIO_WIDTH, MARIO_HEIGHT);
		yVel = 0;
		onGround = false;
	}

	// METHODS
	public void walk(int dir) {
		// MOVES it left and right only
		moveByAmount(dir * 5, 0);
	}

	public void jump() {
		// JUMP!
		if(onGround) {
		yVel = -10;
		}
	}

	public void act(ArrayList<Shape> obstacles) {
		// FALL (and stop when a platform is hit)
		
		if(yVel + grav < 7)
			yVel += grav;
		
		y += yVel;
		boolean onGround = false;
		boolean touchingWall = false;
		for(Shape s : obstacles) {
			if(s.intersects(this)) {
				
				if(this.y > s.getBounds().getY()) {
					onGround = true;
					break;
				}
				else
					touchingWall = true;
			}
		}
		if(onGround) {
			y -= yVel;
			yVel = 0;
			this.onGround = true;
		}
		else if(touchingWall) {
			this.touchingWall = true;
		}
		else {
			this.onGround = false;
			this.touchingWall = false;
		}
			
	}


}
