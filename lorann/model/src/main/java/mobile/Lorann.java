package mobile;

import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;

/**
 * <h1>ClassLorann.</h1>
 *
 * @author group1
 * @version 1.0
 */
public class Lorann extends Mobile {

	/** The Constant SpriteUL */
	private static final Sprite spriteUL = new Sprite('c', "lorann_ul.png");

	/** The Constant SpriteUR */
	private static final Sprite spriteUR = new Sprite('c', "lorann_ur.png");

	/** The Constant SpriteBR */
	private static final Sprite spriteBR = new Sprite('c', "lorann_br.png");

	/** The Constant SpriteBL */
	private static final Sprite spriteBL = new Sprite('c', "lorann_bl.png");

	/** The Constant spriteTurnLeft. */
	private static final Sprite spriteTurnLeft = new Sprite('c', "lorann_l.png");

	/** The Constant spriteTurnRight. */
	private static final Sprite spriteTurnRight = new Sprite('c', "lorann_r.png");

	/** The Constant spriteTurnUp. */
	private static final Sprite spriteTurnUp = new Sprite('c', "lorann_u.png");

	/** The Constant spriteTurnDown. */
	private static final Sprite spriteTurnDown = new Sprite('c', "lorann_b.png");

	/**
	 * Constructor of Lorann to load the sprite
	 * 
	 * @param x
	 * @param y
	 * @param map
	 * @throws IOException
	 */
	public Lorann(final int x, final int y, IMap map) throws IOException {
		super(x, y, spriteUL, map, Permeability.BLOCKING);
		spriteUL.loadImage();
		spriteUR.loadImage();
		spriteBR.loadImage();
		spriteBL.loadImage();
		spriteTurnLeft.loadImage();
		spriteTurnRight.loadImage();
		spriteTurnDown.loadImage();
		spriteTurnUp.loadImage();
	}

	/**
	 * Method Moveup
	 * @throws IOException
	 */
	public void moveUp() throws IOException {
		super.moveUp();
		this.setSprite(spriteTurnUp);
	}

	/**
	 * method MoveLeft
	 * @throws IOException
	 */
	public void moveLeft() throws IOException {
		super.moveLeft();
		this.setSprite(spriteTurnLeft);
	}

	/**
	 * method MoveDown
	 * @throws IOException
	 */
	public void moveDown() throws IOException {
		super.moveDown();
		this.setSprite(spriteTurnDown);
	}
	/**
	 * Method Move Right
	 * 
	 * @throws IOException
	 */
	public void moveRight() throws IOException {
		super.moveRight();
		this.setSprite(spriteTurnRight);
	}
	/**
	 * method do nothing
	 */
	public void doNothing() {

	}

}
