package ludum.vita.dao;

import java.sql.SQLException;
import java.sql.Connection;

public class EvilDatabaseFactory extends DatabaseFactory {
	
	public static final String MESSAGE = "Exception thrown from Evil Test Connection Driver";
	private static EvilDatabaseFactory evilInstance = null;
//	private DBConnectionDriver driver = null;
//	private int numCorrect = 0;

	/**
	 * @return A production instance of the DatabaseFactory, to be used in deployment (by Tomcat).
	 */
	public static EvilDatabaseFactory getProductionInstance() {
		if (evilInstance == null)
			evilInstance = new EvilDatabaseFactory();
		return evilInstance;
	}

	/**
	 * Protected constructor.
	 */
	protected EvilDatabaseFactory() {
	}

	public Connection getConnection() throws SQLException {
		throw new SQLException(MESSAGE);
	}
}
