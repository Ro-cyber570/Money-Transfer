package com.example.db;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class DataSourceConnectionFactory {
 private static Properties properties=new Properties();
 static {
	 FileInputStream fis;
	try {
		fis = new FileInputStream("src/com/example/db/db.properties");
		properties.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	 
 }
 static {
	 try {
		Class.forName(properties.getProperty("db.driver"));
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 
 public static Connection getConnection() throws SQLException {
	 String url=properties.getProperty("db.url");
	 String user=properties.getProperty("db.user");
	 String password=properties.getProperty("db.password");
	 return DriverManager.getConnection(url,user,password);
 }
 
}
