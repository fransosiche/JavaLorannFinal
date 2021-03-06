package mobile;

import java.io.IOException;

import model.IMap;
import model.ModelFacade;
import model.Permeability;
import model.Sprite;
import showboard.IPawn;

/**
 * <h1>Masked class</h1>
 *
 * @author group1
 * @version 1.0
 */
public class Masked extends Mobile implements IPawn {

	private static final Sprite sprite1 = new Sprite('c', "monster_2.png");

	/**
	 * Constructor of Masked
	 * 
	 * @param px
	 * @param py
	 * @param map
	 * @param permeability
	 * @throws IOException
	 */
	public Masked(int px, int py, IMap map, Permeability permeability, ModelFacade Model) throws IOException {
		super(px, py, sprite1, map, Permeability.MONSTER, Model);
		sprite1.loadImage();

		// TODO Auto-generated constructor stub

	}

	@Override
	public void fireball() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
