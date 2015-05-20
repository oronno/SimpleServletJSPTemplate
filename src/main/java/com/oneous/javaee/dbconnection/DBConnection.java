package com.oneous.javaee.dbconnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnection {
    public static final Logger log = LoggerFactory.getLogger(DBConnection.class);


    public static Connection getDatabaseConnection() {
        Properties properties = new Properties();
        Connection connection = null;

        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));

            // load the Driver Class
            Class.forName(properties.getProperty("DB_DRIVER_CLASS"));

            connection = DriverManager.getConnection(properties.getProperty("DB_URL"),
                    properties.getProperty("DB_USERNAME"),
                    properties.getProperty("DB_PASSWORD"));
        } catch (FileNotFoundException e) {
            log.error("Properties file not found", e);
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException ", e);
        } catch (SQLException e) {
            log.error("SQLException ", e);
        } catch (IOException e) {
            log.error("IOException ", e);
        }

        return connection;
    }
}
