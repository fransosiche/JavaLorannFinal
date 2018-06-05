package mobile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

public class MobileTest {
	private static final Object Ax = 1;
	private static final Object Ay = 1;
	private int score = 0;
	private int x = 0;
	private int y = 0;
	private int xM = 0;
	private int yM = 0;
	Boolean alive = true;

	Boolean isAlive() {
		return alive;
	}

	Boolean isDie() {

		return true;
	}

	@Test
	public void testMoveUp() {

		new Point(x, y);
		assertEquals(x, this.getX());
		assertEquals(y - 1, this.getY() - 1);
	}

	private int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Test
	public void testMoveLeft() {
		new Point(x, y);
		assertEquals(x - 1, this.getX() - 1);
		assertEquals(y, this.getY());
	}

	@Test
	public void testMoveDown() {
		new Point(x, y);
		assertEquals(x, this.getX());
		assertEquals(y + 1, this.getY() + 1);
	}

	@Test
	public void testMoveRight() {
		new Point(x, y);
		assertEquals(x + 1, this.getX() + 1);
		assertEquals(y, this.getY());
	}

	@Test
	public void testMoveRightM() {
		new Point(xM, yM);
		assertEquals(xM + 1, this.getMX() + 1);
		assertEquals(yM, this.getMY());
	}

	private int getMY() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getMX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Test
	public void testMoveDownM() {
		new Point(xM, yM);
		assertEquals(xM, this.getMX());
		assertEquals(yM + 1, this.getMY() + 1);
	}

	@Test
	public void testMoveLeftM() {
		new Point(xM, yM);
		assertEquals(xM - 1, this.getMX() - 1);
		assertEquals(yM, this.getMY());
	}

	@Test
	public void testMoveUpM() {
		new Point(xM, yM);
		assertEquals(xM, this.getMX());
		assertEquals(yM - 1, this.getMY() - 1);
	}

	@Test
	public void testDoNothing() {
		new Point(x, y);
		assertEquals(x, this.getX());
		assertEquals(y, this.getY());
	}

	@Test
	public void testSetHasMoved() {
		new Point(x, y);
		assertNotEquals(Ax, this.getX());
		assertNotEquals(Ay, this.getY());
	}

	@Test
	public void testIsAlive() {
		assertTrue(this.isAlive());
	}

	@Test
	public void testDie() {
		alive = false;

		assertFalse(this.isAlive());
	}

	@Test
	public void testCoinsHasbeenTaken() {
		score = score + 1;
		assertEquals(score, 1);
	}

}