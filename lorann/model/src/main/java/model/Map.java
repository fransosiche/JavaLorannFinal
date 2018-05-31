package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import element.Element;
import mobile.Monster1;
import mobile.Monster2;
import mobile.Monster3;
import mobile.Monster4;
import motionless.MotionlessElementFactory;
import model.dao.*;

public class Map extends Observable implements IMap {

	/** The width. */
	private int width;

	/** The height. */
	private int height;

	/** The on the road. */
	private IElement[][] onTheMap;
	
	private ArrayList<Element> monster;

	private LorannDAO dao = new LorannDAO();

	/**
	 * Instantiates a new road with the content of the file fileName.
	 *
	 * @param fileName
	 *            the file name where the map of the road is
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws SQLException
	 */
	Map(final int level) throws IOException, SQLException {
		super();
		this.loadFile(level);
	}

	/**
	 * Loads file.
	 *
	 * @param fileName
	 *            the file name
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws SQLException
	 */
	private void loadFile(final int level) throws IOException, SQLException {
		final BufferedReader buffer = new BufferedReader(new InputStreamReader(dao.getLevelById(level)));
		String line;
		int y = 0;
		line = buffer.readLine();
		this.setWidth(Integer.parseInt(line));
		line = buffer.readLine();
		this.setHeight(Integer.parseInt(line));
		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
		line = buffer.readLine();
		while (y != this.getHeight()) {
			for (int x = 0; x != (this.getWidth()); x++) {
				this.setOnTheMapXY(MotionlessElementFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
				if(this.getOnTheMapXY(x, y) == null){
					for(int i=1; i<5; i++){
						switch(line.toCharArray()[x]){
						case 1:
							this.setOnTheMapXY(MotionlessElementFactory.createGround(), x, y);
							this.monster.add(new Monster1(x, y, new Sprite('1', "monster_1.png"), this, Permeability.MONSTER));
							break;
						case 2:
							this.setOnTheMapXY(MotionlessElementFactory.createGround(), x, y);
							this.monster.add(new Monster2(x, y, new Sprite('2', "monster_2.png"), this, Permeability.MONSTER));
							break;
						case 3:
							this.setOnTheMapXY(MotionlessElementFactory.createGround(), x, y);
							this.monster.add(new Monster3(x, y, new Sprite('3', "monster_3.png"), this, Permeability.MONSTER));
							break;
						case 4:
							this.setOnTheMapXY(MotionlessElementFactory.createGround(), x, y);
							this.monster.add(new Monster4(x, y, new Sprite('4', "monster_4.png"), this, Permeability.MONSTER));
							break;
						}
					}
				}
			}
			System.out.println(line);
			line = buffer.readLine();
			y++;
		}
		buffer.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#getWidth()
	 */
	@Override
	public final int getWidth() {
		return this.width;
	}

	/**
	 * Sets the width.
	 *
	 * @param width
	 *            the new width
	 */
	private void setWidth(final int width) {
		this.width = width;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#getHeight()
	 */
	@Override
	public final int getHeight() {
		return this.height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height
	 *            the new height
	 */
	private void setHeight(final int height) {
		this.height = height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#getOnTheRoadXY(int, int)
	 */
	@Override
	public final Element getOnTheMapXY(final int x, final int y) {
		return (Element) this.onTheMap[x][y];
	}

	/**
	 * Sets the on the road XY.
	 *
	 * @param element
	 *            the element
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public void setOnTheMapXY(final IElement element, final int x, final int y) {
		this.onTheMap[x][y] = element;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#setMobileHasChanged()
	 */
	@Override
	public final void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#getObservable()
	 */
	@Override
	public Observable getObservable() {
		return this;
	}

	public ArrayList<Element> getMonster() {
		return monster;
	}

	public void setMonster(ArrayList<Element> monster) {
		this.monster = monster;
	}
}
