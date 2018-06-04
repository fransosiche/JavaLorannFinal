package motionless;

import model.Permeability;
import model.Sprite;

/**
 * <h1>Closed door class</h1>
 *
 * @author group1
 * @version 1.0
 */

public class Closed_Door extends MotionlessElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite(',', "gate_closed.png");

	/**
	 * Instantiates a new gate.
	 */
	public Closed_Door() {
		super(SPRITE, Permeability.MONSTER);
	}

}