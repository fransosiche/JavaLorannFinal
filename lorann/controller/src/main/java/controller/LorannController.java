package controller;

import java.io.IOException;

import model.IMobile;
import model.IModel;
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

				break;
			case LEFT:
				this.getModel().getLorann().moveLeft();
				break;
			case UP:
				this.getModel().getLorann().moveUp();
				break;
			case DOWN:
				this.getModel().getLorann().moveDown();
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
