package controller;

import java.io.IOException;
/**
 * <h1>Interface ILorannView.</h1>
 *
 * @author group1
 * @version 1.0
 */
public interface ILorannController {
	
	 /**
     * Play.
     *
     * @throws InterruptedException
     *             the interrupted exception
	 * @throws IOException 
     */
    void moove() throws InterruptedException, IOException;

    /**
     * Gets the order peformer.
     *
     * @return the order peformer
     */
    IOrderPerformer getOrderPeformer();

}
