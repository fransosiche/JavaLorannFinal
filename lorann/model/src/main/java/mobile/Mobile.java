package mobile;

import java.awt.Point;
import java.io.IOException;

import javax.swing.JOptionPane;

import element.Element;
import model.IMap;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import showboard.IBoard;

/**
 * <h1>Mobile Class.</h1>
 *
 * @author group1
 * @version 1.0
 */
public abstract class Mobile extends Element implements IMobile {

	/**
	 * The x.
	 */
	private Point position;

	/** The alive. */
	private Boolean alive = true;

	/** The road. */
	private IMap map;

	/** The board. */
	private IBoard board;

	private int score = 0;

	/**
	 * Instantiates a new mobile.
	 *
	 * @param sprite
	 *            the sprite
	 * @param road
	 *            the road
	 * @param permeability
	 *            the permeability
	 */
	Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
		super(sprite, permeability);
		this.setMap(map);
		this.position = new Point();
	}

	/**
	 * Instantiates a new mobile.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param sprite
	 *            the sprite
	 * @param road
	 *            the road
	 * @param permeability
	 *            the permeability
	 */
	Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
		this(sprite, map, permeability);
		this.setX(x);
		this.setY(y);
	}

	/**
	 * Method to moove UP
	 */
	public void moveUp() throws IOException {
		if (this.getY() != 0) {
			if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1)
					.getPermeability() == Permeability.PENETRABLE) {
				this.setY(this.getY() - 1);
				this.setHasMoved();
			}
			if (this.getY() != 0) {
				try {
					if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1)
							.getPermeability() == Permeability.OPENGATE) {
						this.ImmobilhasChanged(getX(), getY() - 1);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1)
					.getPermeability() == Permeability.COINS) {
				this.CoinsHasbeenTaken(this.getX(), this.getY() - 1);
			} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1)
					.getPermeability() == Permeability.WIN) {
				GGWP();

			} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1)
					.getPermeability() == Permeability.MONSTER) {
				die();
			}
		}
	}

	/**
	 * Method to moove left
	 */
	public void moveLeft() throws IOException {
		if (this.getX() != 0) {
			if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY())
					.getPermeability() == Permeability.PENETRABLE) {
				this.setX(this.getX() - 1);
				this.setHasMoved();
			} else if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY())
					.getPermeability() == Permeability.OPENGATE) {

				this.ImmobilhasChanged(this.getX() - 1, this.getY());

			} else if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY())
					.getPermeability() == Permeability.COINS) {
				this.CoinsHasbeenTaken(this.getX() - 1, this.getY());
			} else if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY())
					.getPermeability() == Permeability.WIN) {
				GGWP();

			} else if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY())
					.getPermeability() == Permeability.MONSTER) {
				die();

			}
		}
	}

	/**
	 * Method to moove down
	 */
	public void moveDown() throws IOException {
		if (this.getY() != this.getMap().getHeight()) {
			if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1)
					.getPermeability() == Permeability.PENETRABLE) {
				this.setY(this.getY() + 1);
				this.setHasMoved();
			} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1)
					.getPermeability() == Permeability.OPENGATE) {
				this.ImmobilhasChanged(this.getX(), this.getY() + 1);
			} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1)
					.getPermeability() == Permeability.COINS) {
				this.CoinsHasbeenTaken(this.getX(), this.getY() + 1);
			} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1)
					.getPermeability() == Permeability.WIN) {
				GGWP();

			} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1)
					.getPermeability() == Permeability.MONSTER) {
				die();

			}
		}
	}

	/**
	 * Method to moove right
	 */
	public void moveRight() throws IOException {
		if (this.getX() != this.getMap().getWidth()) {
			if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY())
					.getPermeability() == Permeability.PENETRABLE) {
				this.setX(this.getX() + 1);
				this.setHasMoved();
			} else if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY())
					.getPermeability() == Permeability.OPENGATE) {
				this.ImmobilhasChanged(this.getX() + 1, this.getY());
			} else if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY())
					.getPermeability() == Permeability.COINS) {
				this.CoinsHasbeenTaken(this.getX() + 1, this.getY());
			} else if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY())
					.getPermeability() == Permeability.WIN) {
				GGWP();
			} else if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY())
					.getPermeability() == Permeability.MONSTER) {
				die();

			}
		}
	}

	public void moveRightM() throws IOException {
		if (this.getX() != this.getMap().getWidth()) {
			if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY())
					.getPermeability() == Permeability.PENETRABLE) {
				this.setX(this.getX() + 1);
				this.setHasMoved();
			}
		}
	}

	public void moveDownM() throws IOException {
		if (this.getY() != this.getMap().getHeight()) {
			if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1)
					.getPermeability() == Permeability.PENETRABLE) {
				this.setY(this.getY() + 1);
				this.setHasMoved();
			}
		}
	}

	public void moveLeftM() throws IOException {
		if (this.getX() != 0) {
			if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY())
					.getPermeability() == Permeability.PENETRABLE) {
				this.setX(this.getX() - 1);
				this.setHasMoved();
				System.out.println("oui");
			}
		}
	}

	public void moveUpM() throws IOException {
		if (this.getY() != 0) {
			if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1)
					.getPermeability() == Permeability.PENETRABLE) {
				this.setY(this.getY() - 1);
				this.setHasMoved();
			}
		}
	}

	/**
	 * Method donothing
	 */
	public void doNothing() {
		this.setHasMoved();
	}

	/**
	 * method to set the Y
	 * 
	 * @param y
	 */
	protected void setY(int y) {
		this.getPosition().y = y;
		if (this.isCrashed()) {
			this.die();
		}
	}

	/**
	 * Method to set the X
	 * 
	 * @param x
	 */
	protected void setX(int x) {
		this.getPosition().x = x;
		if (this.isCrashed()) {
			this.die();
		}
	}

	/**
	 * get the Y 
	 * @return the position of X
	 */
	public final int getY() {

		return this.getPosition().y;
	}

	/**
	 * get the X 
	 * @return the position of X
	 */
	public final int getX() {
		return this.getPosition().x;
	}

	/**
	 * Moved something
	 */
	protected void setHasMoved() {
		this.getMap().setMobileHasChanged();
	}

	/**
	 * get the map 
	 * @return the map
	 */
	public IMap getMap() {
		return map;
	}

	/**
	 * set the map return the map
	 * 
	 * @param map
	 */
	public void setMap(IMap map) {
		this.map = map;
	}

	/**
	 * Boolean if lorann is alive
	 * return alive
	 */
	public Boolean isAlive() {
		return alive;
	}

	/**
	 * method die
	 */
	public void die() {
		this.alive = false;
		this.setHasMoved();
		JOptionPane.showMessageDialog(null, "You loose");
		System.exit(0);

	}

	/**
	 * methid Boolean iscrashed
	 * return false
	 */
	public Boolean isCrashed() {
		return false;
	}

	/**
	 * method to getthePosition return the position
	 */
	public Point getPosition() {
		return this.position;
	}

	/**
	 * method GGWP if u manage to win the game
	 */
	public void GGWP() {
		JOptionPane.showMessageDialog(null, "You Win, your score is");
		JOptionPane.showMessageDialog(null, getScore());
		System.exit(0);
	}

	/**
	 * Sets the position.
	 *
	 * @param position
	 *            the position to set
	 */
	public void setPosition(final Point position) {
		this.position = position;
	}

	/**
	 * Method for the gate
	 * 
	 * @param x
	 * @param y
	 * @throws IOException
	 */
	protected void ImmobilhasChanged(int x, int y) throws IOException {
		this.getMap().getOnTheMapXY(x, y).setSprite(new Sprite(' ', "ground.png"));
		this.getMap().getOnTheMapXY(x, y).setPermeability(Permeability.PENETRABLE);
		this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();

		for (int a = 0; a < this.getMap().getWidth(); a++) {

			for (int z = 0; z < this.getMap().getHeight(); z++) {

				if (this.getMap().getOnTheMapXY(a, z).getSprite().getConsoleImage() == ',') {

					this.getMap().getOnTheMapXY(a, z).setSprite(new Sprite('G', "gate_open.png"));
					this.getMap().getOnTheMapXY(a, z).getSprite().loadImage();
					this.getMap().getOnTheMapXY(a, z).setPermeability(Permeability.WIN);

				}

				else if (this.getMap().getOnTheMapXY(this.getX(), this.getY())
						.getPermeability() == Permeability.OPENGATE) {
					try {
						this.ImmobilhasChanged(this.getX() + 1, this.getY());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					this.setX(this.getX() + 1);
					this.setHasMoved();

				}
			}

		}
	}

	/**
	 * method for the curses /coins
	 * 
	 * @param x
	 * @param y
	 * @throws IOException
	 */
	protected void CoinsHasbeenTaken(int x, int y) throws IOException {
		this.getMap().getOnTheMapXY(x, y).setSprite(new Sprite(' ', "ground.png"));
		this.getMap().getOnTheMapXY(x, y).setPermeability(Permeability.PENETRABLE);
		this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
		score = score + 1;
		System.out.print("Your score : ");
		System.out.println(score);

	}

	/**
	 * get the score
	 * 
	 * @return score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * set the score
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	protected IBoard getBoard() {
		return this.board;
	}

}
