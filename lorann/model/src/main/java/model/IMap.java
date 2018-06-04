package model;

import java.util.ArrayList;
import java.util.Observable;

import element.Element;
/**
 * <h1>Interface IMap</h1>
 *
 * @author group1
 * @version 1.0
 */
public interface IMap {
	/**
	 * Set the changement of the mobile
	 */
	void setMobileHasChanged();
	/**
	 * get the height
	 * @return
	 */
	int getHeight();
	 /**
	  * get the position on the map
	  * @param x
	  * @param y
	  * @return
	  */
	Element getOnTheMapXY(int x, int y);
	/**
	 * get the observable
	 * @return
	 */
	Observable getObservable();
	/**
	 * get the width
	 * @return
	 */
	int getWidth();
	/**
	 * get the monster arraylist
	 * @return
	 */
	ArrayList<Element> getMonster();

}
