package edu.matc.test.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class creates a connection to a test database for the cribbage UserDaoTest
 *
 */
public class Database {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private static Database instance = new Database();

    private Properties properties;

    private Connection connection;

    private Database() {
        loadProperties();
    }

    /**
     * Loads the database properties
     */
    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/database.properties"));
        } catch (IOException ioe) {
            logger.error("Could not load properties", ioe);
        } catch (Exception e) {
            logger.error("Database loadProperties error: ", e);
        }
    }

    /**
     * Gets the instance
     * @return instance
     */
    public static Database getInstance() {
        return instance;
    }

    /**
     * Gets the connection
     * @return connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Creates a connection to the database
     * @throws Exception for when any exception occurs
     */
    public void connect() throws Exception {
        if (connection != null)
            return;
        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            throw new Exception("MySQL Driver not found");
        }

        String url = properties.getProperty("url");
        connection = DriverManager.getConnection(url, properties.getProperty("username"), properties.getProperty("password"));
    }

    /**
     * Disconnects the database connection
     */
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("Cannot close database", e);
            }
        }
        connection = null;
    }

    /**
     * Runs sql statement
     * @param sqlFile the string to be processed
     */
    public void runSQL(String sqlFile) {

        Statement stmt = null;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(sqlFile);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            Class.forName("com.mysql.jdbc.Driver");
            connect();
            stmt = connection.createStatement();
            while (true) {
                String sql = br.readLine();
                if (sql == null) {
                    break;
                }
                stmt.executeUpdate(sql);
            }
        } catch (SQLException se) {
            logger.error(se);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            disconnect();
        }
    }
}
