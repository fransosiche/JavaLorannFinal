package motionless;

import model.Permeability;
import model.Sprite;

/**
 * <h1>Purse Class map 1</h1>
 *
 * @author group1
 * @version 1.0
 */

public class Coins5Map1 extends MotionlessElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('F', "purse.png");

	/**
	 * Instantiates a new purse.
	 */
	public Coins5Map1() {
		super(SPRITE, Permeability.COINS);
	}

}
