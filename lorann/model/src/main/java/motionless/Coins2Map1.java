package motionless;

import model.Permeability;
import model.Sprite;

/**
 * <h1>Purse Class map1</h1>
 *
 * @author group1
 * @version 1.0
 */

public class Coins2Map1 extends MotionlessElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('B', "purse.png");

	/**
	 * Instantiates a new purse.
	 */
	public Coins2Map1() {
		super(SPRITE, Permeability.COINS);
	}

}
