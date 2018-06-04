package motionless;

import model.Permeability;
import model.Sprite;

/**
 * <h1>Purse Class</h1>
 *
 * @author group1
 * @version 1.0
 */

public class Coins1Map5 extends MotionlessElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('O', "purse.png");

	/**
	 * Instantiates a new purse.
	 */
	public Coins1Map5 () {
		super(SPRITE, Permeability.COINS);
	}

}