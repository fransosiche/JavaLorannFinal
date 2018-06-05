package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import mobile.Lorann;
import mobile.Masked;
import mobile.Pauline;
import mobile.Zombie;
import mobile.Fireball;
import mobile.Golem;

/**
 * <h1>Model facade class.</h1>
 *
 * @author group1
 * @version 1.0
 */
public class ModelFacade implements IModel {
	/**
	 * the Map
	 */
	private IMap map;

	/**
	 * the Lorann from Interface Imobile
	 */
	private IMobile lorann;
	/**
	 * the arraylist monster
	 */
	private ArrayList<IMobile> monster = new ArrayList<IMobile>();
	/**
	 * the fireball
	 */
	private IMobile fireball;
	/**
	 * Constructor
	 * @param level
	 * @param lorannX
	 * @param lorannY
	 * @throws IOException
	 * @throws SQLException
	 */
	public ModelFacade(final int level, final int lorannX, final int lorannY) throws IOException, SQLException {
		this.setMap(new Map(level));
		this.setLorann(new Lorann(lorannX, lorannY, this.getMap(),this));
		this.getMonster().add(new Golem(7, 2, map, Permeability.MONSTER,this));
		this.getMonster().add(new Masked(2, 6, map,Permeability.MONSTER,this));
		this.getMonster().add(new Pauline(16, 7, map,Permeability.MONSTER ,this));
		this.getMonster().add(new Zombie(6, 10, map,Permeability.MONSTER,this));
		this.getMonster().add(new Fireball(lorannX, lorannY, map, this));
	}

	@Override
	public void getLevelById(int id) throws SQLException {

	}
	/**
	 * get the lorann
	 * @return the lorann
	 */
	public IMobile getLorann() {
		return this.lorann;
	}
	/**
	 * Set the Lorann
	 * @param lorann
	 * @return the Lorann
	 */
	private void setLorann(Lorann lorann) {
		this.lorann = (IMobile) lorann;
	}
	/**
	 * get the map
	 * @return map	
	 */
	public IMap getMap() {
		return map;
	}
	/**
	 * set the map
	 * @return the map
	 */
	public void setMap(IMap map) {
		this.map = map;
	}
	/**
	 * get the arraylist 
	 * return the monster
	 */
	public ArrayList<IMobile> getMonster() {
		// TODO Auto-generated method stub
		return this.monster;
	}
	/**
	 * set the monster
	 * @param monster
	 * @return the monster
	 */
	public void setMonster(ArrayList<IMobile> monster) {
		this.monster = monster;
	}

	/**
	 * set the fireball
	 * @param fireball
	 * @return fireball
	 */
	public void setFireball(IMobile fireball) {
		this.fireball = fireball;
	}
	/**
	 * get the fireball
	 * @return fireball
	 */
	public IMobile getFireball() {
		return fireball;
	}
}
