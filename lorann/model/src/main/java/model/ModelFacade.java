package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import mobile.Lorann;
import mobile.Masked;
import mobile.Golem;

public class ModelFacade implements IModel {

	private IMap map;

	private IMobile lorann;

	private ArrayList<IMobile> monster = new ArrayList<IMobile>();

	public ModelFacade(final int level, final int lorannX, final int lorannY) throws IOException, SQLException {
		this.setMap(new Map(level));
		this.setLorann(new Lorann(lorannX, lorannY, this.getMap()));

		this.getMonster().add(new Golem(10, 8, map, Permeability.MONSTER));
		this.getMonster().add(new Masked(5, 5, map, Permeability.MONSTER));

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
		return monster;
	}

	public void setMonster(ArrayList<IMobile> monster) {
		this.monster = monster;
	}
}
