package model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

public class BDDConnectionTest {

    private BDDConnection connector;

    @Before
    public void setUp() throws Exception {
        this.connector = new BDDConnection();
    }


    @Test
    public void testExecuteQuery() {
         try {
                Statement statement = connector.getConnection().createStatement();
                ResultSet resultEspected = statement.executeQuery("SELECT * FROM example");
                String resultStringEspected = "";

                while (resultEspected.next()) {
                    resultStringEspected += resultEspected.getString(1);
                }

                ResultSet result = connector.executeQuery("SELECT * FROM example");
                String resultString = "";

                while (result.next()) {
                    resultString += result.getString(1);
                }

                assertEquals(resultStringEspected,resultString);

            } catch (final SQLException e) {
                e.printStackTrace();
                fail("May be credential problem.");
            }
        }


    @Test
    public void testExecuteUpdate() {
    }

    @Test
    public void testPrepareCallString() {
    }

}