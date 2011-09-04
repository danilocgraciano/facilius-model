package facilius.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Graciano
 */
public class ConnectionManager {

    private static String driver;
    private static String url;
    private static String usuario;
    private static String senha;
    private static ConnectionManager instance = null;

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return (instance);
    }
    private Connection conn = null;

    private ConnectionManager() {
//        try {
//            PropertiesManager properties = new PropertiesManager("database.properties");
            driver = "org.postgresql.Driver";
            url = "jdbc:postgresql://localhost:5432/facilius/";
            usuario = "postgres";
            senha = "postgres";
//            driver = properties.getProperty("driver");
//            url = properties.getProperty("url");
//            usuario = properties.getProperty("usuario");
//            senha = properties.getProperty("senha");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }

    public Connection getConnection() {
        try {
            if ((conn == null) || (conn.isClosed())) {
                this.createConnection();
            }
            if (!conn.getAutoCommit()) {
                conn.setAutoCommit(true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return (conn);
    }

    private void createConnection() throws Exception {
        Class.forName(driver);
        conn = DriverManager.getConnection(url, usuario, senha);
    }
}