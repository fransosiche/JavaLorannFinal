package controller;

import java.io.IOException;
import java.util.Random;

import model.IMobile;
import model.IModel;
import model.Permeability;
import view.ILorannView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller
 * component.</h1>
 *
 * @author Groupe 1
 * @version 1.0
 */
public class LorannController implements ILorannController, IOrderPerformer {

	private static final int speed = 200;

	private static int speed1 = 100;

	/** The view. */
	private ILorannView view;

	/** The model. */
	private IModel model;
	/*
	 * Call the enum
	 */
	private UserOrder stackOrder;

	/**
	 * Instantiates a new controller facade.
	 *
	 * @param view
	 *            the view
	 * @param model
	 *            the model
	 */
	public LorannController(final ILorannView view, final IModel model) {
		this.view = view;
		this.model = model;
		this.clearStackOrder();
	}

	/**
	 * 
	 * @param H
	 * @return
	 * @throws IOException
	 */
	public void random() throws IOException {
		int H = (int) (Math.random() * (4 - 0));
		if (H == 0) {
			this.getModel().getMonster().get(1).moveDownM();
		} else if (H == 1) {
			this.getModel().getMonster().get(1).moveUpM();
		} else if (H == 2) {
			this.getModel().getMonster().get(1).moveLeftM();
		} else if (H == 3) {
			this.getModel().getMonster().get(1).moveRightM();
		}
	}

	public void randomv2() throws IOException {
		int W = (int) (Math.random() * (4 - 0));
		if (W == 0) {
			this.getModel().getMonster().get(2).moveDownM();
		} else if (W == 1) {
			this.getModel().getMonster().get(2).moveUpM();
		} else if (W == 2) {
			this.getModel().getMonster().get(2).moveLeftM();
		} else if (W == 3) {
			this.getModel().getMonster().get(2).moveRightM();
		}
	}

	public void randomv3() throws IOException {
		int G = (int) (Math.random() * (4 - 0));
		if (G == 0) {
			this.getModel().getMonster().get(3).moveDownM();
		} else if (G == 1) {
			this.getModel().getMonster().get(3).moveUpM();
		} else if (G == 2) {
			this.getModel().getMonster().get(3).moveLeftM();
		} else if (G == 3) {
			this.getModel().getMonster().get(3).moveRightM();
		}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.ILorannController#moove()
	 */

	public final void moove() throws InterruptedException, IOException {
		while (this.getModel().getLorann().isAlive()) {
			Thread.sleep(speed);
			switch (this.getStackOrder()) {
			case RIGHT:
				this.getModel().getLorann().moveRight();

				this.getModel().getMonster().get(0).moveRightM();
				random();
				randomv2();
				randomv3();

				break;
			case LEFT:
				this.getModel().getLorann().moveLeft();

				this.getModel().getMonster().get(0).moveLeftM();
				random();
				randomv2();
				randomv3();

				break;
			case UP:
				this.getModel().getLorann().moveUp();

				this.getModel().getMonster().get(0).moveUpM();
				random();
				randomv2();
				randomv3();

				break;
			case DOWN:
				this.getModel().getLorann().moveDown();
				this.getModel().getMonster().get(0).moveDownM();
				random();
				randomv2();
				randomv3();

				break;

			case NOP:
			default:
				this.getModel().getLorann().doNothing();
				random();

				break;
			}
			this.clearStackOrder();
			for (IMobile issou : this.getModel().getMonster()) {

				if (this.getModel().getLorann().getX() == issou.getX()
						&& this.getModel().getLorann().getY() == issou.getY()
						&& issou.getPermeability() == Permeability.MONSTER) {
					this.getModel().getLorann().isCrashed();
					this.getModel().getLorann().die();
				}

			}
		}
	}

	public final void moove2() throws InterruptedException, IOException {
		while (this.getModel().getLorann().isAlive()) {
			Thread.sleep(speed1);
			switch (this.getStackOrder()) {
			case RIGHT:

				randomv2();
				randomv3();

				break;
			case LEFT:

				randomv2();
				randomv3();

				break;
			case UP:

				randomv2();
				randomv3();

				break;
			case DOWN:

				randomv2();
				randomv3();

				break;

			case NOP:
			default:

				randomv2();
				randomv3();
				break;
			}
			this.clearStackOrder();

		}

	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	public ILorannView getView() {
		return this.view;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.IOrderPerformer#orderPerform(controller.UserOrder)
	 */
	public final void orderPerform(final UserOrder userOrder) throws IOException {
		this.setStackOrder(userOrder);
	}

	/*
	 * set the view
	 * 
	 */
	private void setView(final ILorannView view) {
		this.view = view;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public IModel getModel() {
		return this.model;
	}

	/*
	 * Set the model.
	 * 
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Gets the stack order.
	 *
	 * @return the stack order
	 */
	private UserOrder getStackOrder() {
		return this.stackOrder;
	}

	/**
	 * Sets the stack order.
	 *
	 * @param stackOrder
	 *            the new stack order
	 */
	private void setStackOrder(final UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	/**
	 * Clear stack order.
	 */
	private void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.ILorannController#getOrderPeformer()
	 */
	public IOrderPerformer getOrderPeformer() {
		return this;
	}

}
