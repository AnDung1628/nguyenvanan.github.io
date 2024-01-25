package devmaster.edu.vn.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

public class connectionUtils {
	public static Connection getMSSConnection() throws SQLException, ClassCastException {
		String hostName = "localhost";
		String sqlInstanceName = "SQL2022";
		String dbName = "Lap04jspSevrletJDBC";
		String userName = "sa";
		String password = "An0327762985";
		String connectionURL = "jdbc:sqlserver://" + hostName + ":1433;instance=" + sqlInstanceName + ";databaseName="
				+ dbName;
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}

	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {

		}
	}

	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {

		}
	}
}
