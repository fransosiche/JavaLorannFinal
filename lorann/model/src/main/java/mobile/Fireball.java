package mobile;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import model.IMap;
import model.ModelFacade;
import model.Permeability;
import model.Sprite;

public class Fireball extends Mobile implements Runnable {

	private static final Sprite spriteFireBall = new Sprite('c', "fireball_2.png");

	public Fireball(int x, int y, IMap map, ModelFacade fireball) throws IOException {
		super(x, y, spriteFireBall, map, Permeability.BLOCKING, fireball);

		spriteFireBall.loadImage();

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(this, 0, 1, TimeUnit.SECONDS);
	}

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