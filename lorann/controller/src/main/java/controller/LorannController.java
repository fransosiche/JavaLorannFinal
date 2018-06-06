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
 * @author Group 1
 * @version 1.0
 */
public class LorannController implements ILorannController, IOrderPerformer {
	/**
	 * the speed for bots
	 */
	private static final int speed = 50;
	/**
	 * the speed for thread of lorann
	 */
	private static final int speed1 = 600;

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
	 * Random method
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

	/*
	 * The Ai that going to follow you/chase you
	 * 
	 */
	public void follow() throws IOException {
		if (this.getModel().getLorann().getX() != this.getModel().getMonster().get(3).getX()
				|| this.getModel().getLorann().getY() != this.getModel().getMonster().get(3).getY()) {

			if (this.getModel().getLorann().getX() > this.getModel().getMonster().get(3).getX()) {
				this.getModel().getMonster().get(3).moveRightM();
			} else if (this.getModel().getLorann().getX() < this.getModel().getMonster().get(3).getX()) {
				this.getModel().getMonster().get(3).moveLeftM();
			}

			if (this.getModel().getLorann().getY() > this.getModel().getMonster().get(3).getY()) {
				this.getModel().getMonster().get(3).moveDownM();

			} else if (this.getModel().getLorann().getY() < this.getModel().getMonster().get(3).getY()) {
				this.getModel().getMonster().get(3).moveUpM();
			}

		}
	}

	/**
	 * Follow by line
	 * 
	 * @throws IOException
	 */
	public void followbyline() throws IOException {
		if (this.getModel().getLorann().getX() != this.getModel().getMonster().get(2).getX()
				&& this.getModel().getLorann().getY() != this.getModel().getMonster().get(2).getY()) {

			if (this.getModel().getLorann().getX() > this.getModel().getMonster().get(2).getX()) {
				this.getModel().getMonster().get(2).moveRightM();
			} else if (this.getModel().getLorann().getX() < this.getModel().getMonster().get(2).getX()) {
				this.getModel().getMonster().get(2).moveLeftM();
			}

			if (this.getModel().getLorann().getY() > this.getModel().getMonster().get(2).getY()) {
				this.getModel().getMonster().get(2).moveDownM();

			} else if (this.getModel().getLorann().getY() < this.getModel().getMonster().get(2).getY()) {
				this.getModel().getMonster().get(2).moveUpM();
			}

		}
	}

	/**
	 * the moove method
	 */

	public final void moove() throws InterruptedException, IOException {
		while (this.getModel().getLorann().isAlive()) {
			Thread.sleep(speed);
			switch (this.getStackOrder()) {
			case RIGHT:
				this.getModel().getLorann().moveRight();
				getModel().getMonster().get(0).moveRightM();

				break;
			case LEFT:
				this.getModel().getLorann().moveLeft();
				getModel().getMonster().get(0).moveLeftM();

				break;
			case UP:
				this.getModel().getLorann().moveUp();
				getModel().getMonster().get(0).moveUpM();

				break;
			case DOWN:
				this.getModel().getLorann().moveDown();
				getModel().getMonster().get(0).moveDownM();

				break;

			case NOP:
			default:
				this.getModel().getLorann().doNothing();

				break;
			}
			this.clearStackOrder();

		}
	}

	/**
	 * Moove for AI
	 */
	public final void mooveAI() throws InterruptedException, IOException {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				while (getModel().getLorann().isAlive()) {
					try {
						Thread.sleep(speed1);

						switch (getStackOrder()) {
						case RIGHT:

							random();
							followbyline();
							follow();

							break;
						case LEFT:

							random();
							followbyline();
							follow();

							break;
						case UP:

							random();
							followbyline();
							follow();

							break;
						case DOWN:

							random();
							followbyline();
							follow();

							break;

						case NOP:
						default:

							random();
							followbyline();
							follow();

							break;
						}
						clearStackOrder();
						for (IMobile issou : getModel().getMonster()) {

							if (getModel().getLorann().getX() == issou.getX()
									&& getModel().getLorann().getY() == issou.getY()
									&& issou.getPermeability() == Permeability.MONSTER) {
								getModel().getLorann().isCrashed();
								getModel().getLorann().die();
							}

						}
					} catch (InterruptedException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
		t.start();
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
