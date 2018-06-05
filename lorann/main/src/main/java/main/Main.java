package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import controller.LorannController;
import model.ModelFacade;
import view.ViewFacade;

/**
 * <h1>Class Main</h1>
 *
 * @author group1
 * @version 1.0
 */
public abstract class Main {

	/** The Constant startX. */
	private static int startX = 0;

	/** The Constant startY. */
	private static int startY = 0;

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws SQLException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(final String[] args) throws IOException, SQLException, InterruptedException {

		System.out.println("Choose a level plz (between 1 & 5) : ");

		try {

			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			String levelString = bufferRead.readLine();
			Boolean iswholeNumber = WholeNumber(levelString);

			if (!iswholeNumber) {
				int level = Integer.parseInt(levelString);

				if (level > 0 && level < 6) {
					spawnLorann(level);
					Start(level);

				} else {

					Error();

				}
			} else {

				Error();

			}

		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * make the different spawn for Lorann
	 * 
	 * @param level
	 */
	public static void spawnLorann(int level) {

		if (level == 1) {

			startX = 17;
			startY = 5;

		} else if (level == 2) {

			startX = 18;
			startY = 1;

		} else if (level == 3) {

			startX = 1;
			startY = 1;

		} else if (level == 4) {

			startX = 2;
			startY = 2;

		} else if (level == 5) {

			startX = 1;
			startY = 6;

		}

	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	public static boolean WholeNumber(String string) {
		try {
			Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return true;
		}

		return false;
	}

	/**
	 * method for the error
	 * 
	 * @throws IOException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	public static void Error() throws IOException, SQLException, InterruptedException {

		System.out.println("Invalid number.");
		main(null);

	}

	/**
	 * method start
	 * 
	 * @param level
	 * @throws IOException
	 * @throws SQLException
	 * @throws InterruptedException:
	 */
	public static void Start(int level) throws IOException, SQLException, InterruptedException {
		System.out.println("Game start!");
		final ModelFacade model = new ModelFacade(level, startX, startY);
		final ViewFacade view = new ViewFacade(model.getMap(), model.getLorann(), model.getMonster());
		final LorannController controller = new LorannController(view, model);
		view.setOrderPerformer(controller.getOrderPeformer());
		controller.moove();
	}

}