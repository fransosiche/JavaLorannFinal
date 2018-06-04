package motionless;

import model.Permeability;
import model.Sprite;

/**
 * <h1>Purse Class</h1>
 *
 * @author group1
 * @version 1.0
 */

public class Coins2Map4 extends MotionlessElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('N', "purse.png");

	/**
	 * Instantiates a new purse.
	 */
	public Coins2Map4  () {
		super(SPRITE, Permeability.COINS);
	}

}