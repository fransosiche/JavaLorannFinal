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

public class ModelFacade implements IModel {

	private IMap map;

	private IMobile lorann;

	private ArrayList<IMobile> monster = new ArrayList<IMobile>();
	
	private IMobile fireball;

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

	public IMobile getLorann() {
		return this.lorann;
	}

	private void setLorann(Lorann lorann) {
		this.lorann = (IMobile) lorann;
	}

	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

	public ArrayList<IMobile> getMonster() {
		// TODO Auto-generated method stub
		return this.monster;
	}

	public void setMonster(ArrayList<IMobile> monster) {
		this.monster = monster;
	}


	public void setFireball(IMobile fireball) {
		this.fireball = fireball;
	}
	
	public IMobile getFireball() {
		return fireball;
	}
}
