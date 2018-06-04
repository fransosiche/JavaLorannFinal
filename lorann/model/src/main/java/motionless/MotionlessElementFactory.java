package motionless;

/**
 * <h1>A factory to create MotionlessElements objects.</h1>
 *
 * @author group1
 * @version 1.0
 */

public class MotionlessElementFactory {

	/** The Constant crystalBall. */
	private static final CrystalBall crystalBall = new CrystalBall();

	/** The gate open. */
	private static final Open_Door OD = new Open_Door();
	/**
	 * the gate closed
	 */
	private static final Closed_Door CD = new Closed_Door();

	/** The Constant bone. */
	private static final Bone bone = new Bone();

	/** The Constant horizontalBone. */
	private static final HorizontalBone horizontalBone = new HorizontalBone();

	/** The Constant verticalBone. */
	private static final VerticalBone verticalBone = new VerticalBone();

	/** The coins 1 for map1. */
	private static final Coins2Map1 coins2 = new Coins2Map1();
	/** The coins 2 for map1. */
	private static final Coins1Map1 coins1 = new Coins1Map1();
	/** The coins 3 for map1. */
	private static final Coins3Map1 coins3 = new Coins3Map1();
	/** The coins 4 for map1. */
	private static final Coins4Map1 coins4 = new Coins4Map1();
	/** The coins 5 for map1. */
	private static final Coins5Map1 coins5 = new Coins5Map1();
	private static final Coins1Map2 coins12 = new Coins1Map2();
	private static final Coins2Map2 coins22 = new Coins2Map2();
	private static final Coins1Map3 coins31 = new Coins1Map3();
	private static final Coins2Map3 coins32 = new Coins2Map3();
	private static final Coins1Map4 coins41 = new Coins1Map4();
	private static final Coins2Map4 coins42 = new Coins2Map4();
	private static final Coins1Map5 coins51 = new Coins1Map5();
	private static final Coins2Map5 coins52 = new Coins2Map5();
	/** The constant Dirt. */
	private static final Dirt dirt = new Dirt();

	/**
	 * The motionless elements is an array of all possible MotionlessElement.
	 */

	private static MotionlessElement[] motionlessElements = { crystalBall, CD, OD, bone, horizontalBone, verticalBone,
			coins1, coins2, coins3, coins4, coins5, dirt, coins12, coins22, coins31, coins32, coins41, coins42, coins51, coins52 };

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createCrystalBall() {
		return crystalBall;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createOpenDoor() {
		return OD;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */

	public static MotionlessElement createClosedDoor() {
		return CD;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createBone() {
		return bone;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createHorizontalBone() {
		return horizontalBone;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createVerticalBone() {
		return verticalBone;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createCoins1() {
		return coins1;
	}

	/**
	 * /** Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */

	public static MotionlessElement createCoins2() {
		return coins2;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createCoins3() {
		return coins3;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createCoins4() {
		return coins4;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createCoins5() {
		return coins5;
	}

	public static MotionlessElement createCoins12() {
		return coins12;
	}

	public static MotionlessElement createCoins22() {
		return coins22;
	}

	public static MotionlessElement createCoins31() {
		return coins31;
	}

	public static MotionlessElement createCoins32() {
		return coins32;
	}

	public static MotionlessElement createCoins41() {
		return coins41;
	}

	public static MotionlessElement createCoins42() {
		return coins42;
	}

	public static MotionlessElement createCoins51() {
		return coins51;
	}

	public static MotionlessElement createCoins52() {
		return coins52;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createGround() {
		return dirt;
	}

	/**
	 * 
	 * @param fileSymbol
	 * @return
	 */
	public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
		for (final MotionlessElement motionlessElement : motionlessElements) {
			if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
				return motionlessElement;
			}
		}
		return null;
	}
}
