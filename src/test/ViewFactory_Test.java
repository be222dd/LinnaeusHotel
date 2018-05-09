package test;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import org.junit.Test;
import view.ViewFactory;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

/**
 * Created by Henry on 29-Apr-18.
 */
public class ViewFactory_Test
{
    @Test
    public void getMainSceneReturnTest() throws OperationNotSupportedException
    {
        JFXPanel fxPanel = new JFXPanel();
        ViewFactory vf = ViewFactory.defaultFactory;
        Object resultScene = vf.getMainScene(); // Object was used because of instanceof
        assertTrue(resultScene instanceof Scene); //since the method can return a null it is valid to run this
    }

    @Test
    public void getMainSceneExceptionTest() throws OperationNotSupportedException
    {
        JFXPanel fxPanel = new JFXPanel();
        ViewFactory vf = ViewFactory.defaultFactory;
        Boolean exceptionThrown = false;
        Scene scene = vf.getMainScene();
        try
        {
            Scene scene2 = vf.getMainScene();
        }
        catch (OperationNotSupportedException onse)
        {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void getCreateReservationSceneReturnTest()
    {
        ViewFactory vf = ViewFactory.defaultFactory;
        Object resultReservation = vf.getReservationLayoutScene();
        assertTrue(resultReservation instanceof Scene);
    }
}
