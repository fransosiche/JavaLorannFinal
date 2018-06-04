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

public class Zombie extends Mobile implements IPawn {

	private static final Sprite sprite1 = new Sprite('c', "monster_4.png");

	/**
	 * Contructor
	 * 
	 * @param px
	 * @param py
	 * @param map
	 * @param permeability
	 * @throws IOException
	 */
	public Zombie(int px, int py, IMap map, Permeability permeability) throws IOException {
		super(px, py, sprite1, map, Permeability.MONSTER);
		sprite1.loadImage();

		// TODO Auto-generated constructor stub

	}

}