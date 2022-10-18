package com.am1n.mep;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// AM1N
public class MEPDBInterface
{
	private String mepid;
	private String dbid = "jdbc:derby:mepdata;create=true";
	private String dbloc;
	private Connection conn = null;
	private boolean init = false;

	public MEPDBInterface(String id) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		mepid = id;
		dbloc = System.getProperty("user.home").replaceAll("\\\\", "/") + "/mep/" + mepid + "/mepdb";
		System.setProperty("derby.system.home", dbloc);
		init = new File(dbloc + "/mepdata").exists();
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		try
		{
			conn = DriverManager.getConnection(dbid);
			if(!init)
			{
				String initDB = "CREATE TABLE Patient (patientID int NOT NULL, LastName varchar(255) NOT NULL, PRIMARY KEY (patientID))";
				conn.createStatement().execute(initDB);
				System.out.println("DB initialized...");
			}
			else
			{
				System.out.println("TABLE exists...");
			}
		}
		catch(SQLException e)
		{
			// TABLE exists...
			if(e.getSQLState().equals("X0Y32"))
			{
				System.out.println("ALERT: TABLE already exists?");
			}
		}
	}

	public int terminate()
	{
		if(conn != null)
		{
			boolean gotSQLExc = false;
			try
			{
				DriverManager.getConnection("jdbc:derby:;shutdown=true");
			}
			catch(SQLException ee)
			{
				if(ee.getSQLState().equals("XJ015"))
				{
					gotSQLExc = true;
				}
			}
			if(!gotSQLExc)
			{
				System.out.println("ALERT: Database odd termination.");
			}
		}
		System.out.println("DB termination OK...");
		return 0;
	}
}
