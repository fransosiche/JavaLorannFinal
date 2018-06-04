package model;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author groupe 1
 * @version 1.0
 */
public interface IModel {

	/**
	 * Gets the level by id.
	 *
	 * @param id
	 *            the id
	 * @return the example by id
	 * @throws SQLException
	 *             the SQL exception
	 */
	void getLevelById(int id) throws SQLException;
	
	/*
	 * get the Lorann
	 */

	IMobile getLorann();
	
	/*
	 * get the Monster arraylist
	 */

	ArrayList<IMobile> getMonster();

}
