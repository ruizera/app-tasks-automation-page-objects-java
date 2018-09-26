package support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connection {
	private static Connection connection = null;
	String user = FileReaderManager.getInstance().getConfigReader().getDBUser();
	String url = FileReaderManager.getInstance().getConfigReader().getDBUrl();
	String senha = FileReaderManager.getInstance().getConfigReader().getDBPassword();

	public Connection getConection() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");

		if (connection == null) {
			connection = DriverManager.getConnection(url, user, senha);
		}
		System.out.println(connection);

		return connection;
	}

	public void add(String cenario, String step, String esperado, String obtido, String result) throws SQLException {
		String createTable = "CREATE TABLE IF NOT EXISTS resultados"
        + "(	cenario					VARCHAR(50),"
        + "		step           			VARCHAR(50),"
        + "		applicationUrl	        VARCHAR(50),"
        + "		currentUrl          	VARCHAR(50),"
        + "		result           		VARCHAR(50));";

		Statement stmt = connection.createStatement();
		stmt.execute(createTable);

		String insert = "INSERT INTO resultados VALUES('"+cenario+"','"+step+"','"+esperado+"','"+obtido+"','"+result+"');";
		stmt.executeUpdate(insert);
		
	}
}
