package motionless;

import model.Permeability;
import model.Sprite;

/**
 * <h1>Purse Class</h1>
 *
 * @author group1
 * @version 1.0
 */

public class Coins1Map2 extends MotionlessElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('H', "purse.png");

	/**
	 * Instantiates a new purse.
	 */
	public Coins1Map2 () {
		super(SPRITE, Permeability.COINS);
	}

}