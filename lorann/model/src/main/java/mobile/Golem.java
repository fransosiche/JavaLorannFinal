package mobile;

import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;
import showboard.IPawn;

/**
 * <h1>Golem class.</h1>
 *
 * @author group1
 * @version 1.0
 */

public class Golem extends Mobile implements IPawn {

	private static final Sprite sprite1 = new Sprite('c', "monster_1.png");

	/**
	 * Contructor
	 * @param px
	 * @param py
	 * @param map
	 * @param permeability
	 * @throws IOException
	 */
	public Golem(int px, int py, IMap map, Permeability permeability) throws IOException {
		super(px, py, sprite1, map, Permeability.MONSTER);
		sprite1.loadImage();

		// TODO Auto-generated constructor stub

	}

	/**
	 * Method IA
	 * @throws IOException
	 */
	public void IA() throws IOException {
		super.moveLeft();
	}

}
