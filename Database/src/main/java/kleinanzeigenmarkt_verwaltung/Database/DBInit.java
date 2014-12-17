package kleinanzeigenmarkt_verwaltung.Database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

/**
 *Initalising the database 
 *
 */
public class DBInit {
    	public static void main(String[] args) throws Exception {

    		Connection c = DriverManager.getConnection(
    				"jdbc:hsqldb:file:../Database/database/testdb", "sa", "");
    		c.setAutoCommit(false);
    		System.out.println("Autocommit " + (c.getAutoCommit() ? "on" : "off"));

    		c.createStatement().executeQuery("DROP TABLE ANZEIGE IF EXISTS");

    		c.createStatement().executeQuery("CREATE TABLE ANZEIGE (id INTEGER PRIMARY KEY, bezeichnung varchar(255), menge INTEGER, preis FLOAT, kontakt varchar(255)) ");				
    						
    		c.commit();
    		c.close();
    		
    		IDatabaseTester databaseTester = new JdbcDatabaseTester("org.hsqldb.jdbcDriver",
    				"jdbc:hsqldb:file:../Database/database/testdb", "sa", "");
    		databaseTester.setDataSet(new FlatXmlDataSetBuilder().build(new File("startDB.xml")));
    		databaseTester.onSetup();
    		
    		System.out.println("ready");
    }
}
