package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
* This class represents the connection between the program and the remote database 
* located on the Free sql database server (http://www.freesqldatabase.com/).
* Using Connector/J (the official JDBC driver for MySQL) is required 
* (can be downloaded from https://dev.mysql.com/downloads/connector/j/5.1.html).
* For administrating the database phpMyAdmin is used and can be reached at 
* http://www.phpmyadmin.co/index.php
* 
* @author Maria Gvozdeva
*/

public class DBConnect {
	
	// init database constants
	private static final String URL = "jdbc:mysql://sql7.freesqldatabase.com:3306/";
    private static final String DB_NAME = "sql7237521";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_USER = "sql7237521"; 
	private static final String DB_PASSWORD = "zQGcXlDeEJ";
	
	// init connection object
	private Connection connection = null;
	
	//init statement and ResultSet object
	private Statement stm = null; 
	private ResultSet res = null; 
	
	//init properties object
	private Properties properties;
	
	//create properties
	private Properties getProperties() {
		
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", DB_USER);
            properties.setProperty("password", DB_PASSWORD);
        }
        
        return properties;
    }

	/**
	 *  Connects the remote database with help of JDBC
	 */
	public Connection getConnected() throws Exception {

		try {

			System.out.println("Connecting to database...");
			Class.forName(DRIVER); 		//loads and initializes the MySQL driver
			connection = DriverManager.getConnection(URL+DB_NAME, getProperties());
		
			System.out.println ("Database connection is established\n");
			
			if (connection == null) {
				System.out.println ("Database connection is not established");
			}
			
		} catch (Exception e) {

           e.printStackTrace();
                  
        } 
		
		return connection;
	}
	
	/**
	 *  
	 *  Updates data in the database. This method is used when we need 
	 *  to change data in the database (add, delete or update records).
	 */
	public void updateData(String query) throws Exception {
		
		try {
			
			getConnected().createStatement().executeUpdate(query);
			System.out.println ("Database has been successfully updated");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	/**
	 *  Retrieves data from the database 
	 */
	public ResultSet retrieveData(String query) throws Exception {
		
		try {
			
			stm = getConnected().createStatement();
			res = stm.executeQuery(query);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} 
		
		return res;
	}
	
	
	/**
	 *  Returns table data from the database as array list
	 */
	public ArrayList<Object> getArrData (String query) throws Exception {
		
		ArrayList<Object> resultArr = new ArrayList<Object>();

		try {

			ResultSet res = retrieveData(query);
			
			if (res.next()) {
				
				int columns = res.getMetaData().getColumnCount();
				
				do {
					
					for  (int i = 1; i <= columns; i++) {
						
			        	resultArr.add(res.getObject(i));
			        }
					
				} while(res.next());
				
			} else {
				
				System.out.println("No records were found that match the specified criteria");
				//TODO handle if does not match
				
			}
			
			closeConnection();
			
		} catch (Exception e) {

			System.err.println("Exception: " + e.getMessage());

        } 
		
		return resultArr;
	}
	
	/**
	 *  Shows table records
	 */
	public void showData(String query) throws Exception {

		try {

			ResultSet res = retrieveData(query);
			
			if (res.next()) {
				
				int columns = res.getMetaData().getColumnCount();
				
		        System.out.println("Table: " + res.getMetaData().getTableName(1));
		        System.out.println();
		        
		        do {
		        	for  (int i = 1; i <= columns; i++) {
			        	System.out.print(res.getMetaData().getColumnName(i) + ": ");
			        	System.out.println(res.getObject(i));
			        }
		        } while (res.next());
		        
			} else {
				
				System.out.println("No records were found that match the specified criteria");
				
			}
			
	        closeConnection();
        
		} catch (Exception e) {
	
			System.err.println("Exception: " + e.getMessage());
	
	    } 
    }
	
	/**
	 *  Closes the database connection
	 */
	public void closeConnection() {
		
		try {
			
			 if (stm != null) {
				 stm.close();
			 }
				
			 if (res != null) {
				res.close();
			 }
			 
			 if (connection != null) {
				connection.close();
			 }
			
		} catch (Exception e) {

	        e.printStackTrace();
	        stm = null;
	        res = null;
	        connection = null;
	    } 
	}
}