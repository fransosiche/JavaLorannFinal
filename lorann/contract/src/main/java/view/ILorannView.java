package view;

import java.awt.event.KeyEvent;

/**
 * <h1>Interface ILorannView.</h1>
 *
 * @author group1
 * @version 1.0
 */
public interface ILorannView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);
    /*
     * Key Released
     */
	void keyReleased(KeyEvent keyEvent);
	/*
	 * Key Typed
	 */
	void keyTyped(KeyEvent keyEvent);
}
