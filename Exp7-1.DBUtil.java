import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
  
    private static final String DEFAULT_DB_URL  = "jdbc:mysql://localhost:3306/schooldb?useSSL=false&serverTimezone=UTC";
    private static final String DEFAULT_DB_USER = "appuser";
    private static final String DEFAULT_DB_PASS = "Mabud123@";

    private static String getSetting(String propName, String envName, String defaultValue) {
        String p = System.getProperty(propName);
        if (p != null && !p.isEmpty()) return p;
        String e = System.getenv(envName);
        if (e != null && !e.isEmpty()) return e;
        return defaultValue;
    }

    private static final String DB_URL  = getSetting("DB_URL",  "DB_URL",  DEFAULT_DB_URL);
    private static final String DB_USER = getSetting("DB_USER", "DB_USER", DEFAULT_DB_USER);
    private static final String DB_PASS = getSetting("DB_PASS", "DB_PASS", DEFAULT_DB_PASS);

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}
