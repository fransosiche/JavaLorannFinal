package motionless;

import element.Element;
import model.Permeability;
import model.Sprite;

/**
 * <h1>MotionlessElement Class</h1>
 *
 * @author group1
 * @version 1.0
 */

public abstract class MotionlessElement extends Element {

    /**
     * Instantiate new element
     *
     * @param sprite
     *            the sprite
     * @param permeability
     *            the permeability
     */
	public MotionlessElement(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
	}

}
