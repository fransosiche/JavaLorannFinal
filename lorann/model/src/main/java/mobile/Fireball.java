package mobile;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import model.IMap;
import model.ModelFacade;
import model.Permeability;
import model.Sprite;
import showboard.ISquare;

/**
 * <h1>Fireball Class</h1>
 *
 * @author group1
 * @version 1.0
 * @see ISquare
 */
public class Fireball extends Mobile implements Runnable {
	/**
	 * the sprite of the fireball
	 */
	private static final Sprite spriteFireBall = new Sprite('c', "fireball_2.png");
	/**
	 * FIREBALL constuctor to load the sprite
	 * @param x
	 * @param y
	 * @param map
	 * @param fireball
	 * @throws IOException
	 */
	public Fireball(int x, int y, IMap map, ModelFacade fireball) throws IOException {
		super(x, y, spriteFireBall, map, Permeability.BLOCKING, fireball);

		spriteFireBall.loadImage();

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(this, 0, 1, TimeUnit.SECONDS);
	}
	/**
	 * the run method
	 */
	public void run() {
		try {
			this.moveLeft();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void fireball() throws IOException {

	}

}