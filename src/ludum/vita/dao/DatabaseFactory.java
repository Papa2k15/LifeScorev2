package ludum.vita.dao;

import java.sql.SQLException;
import java.sql.Connection;

import ludum.vita.dbtools.DBConnectionDriver;

public class DatabaseFactory {
	private static DatabaseFactory productionInstance = null;
	private DBConnectionDriver driver;

	/**
	 * @return A production instance of the DatabaseFactory, to be used in deployment (by Tomcat).
	 */
	public static DatabaseFactory getProductionInstance() {
		if(productionInstance == null){
			productionInstance = new DatabaseFactory();
		}
		return productionInstance;
	}

	/**
	 * Protected constructor.
	 */
	protected DatabaseFactory() {
		this.driver = new DBConnectionDriver();
	}

	public Connection getConnection() throws SQLException {
		return driver.getConnection();
	}

	public PlayerDAO getPlayerDAO(){
		return new PlayerDAO(this);
	}
	
	public MissionDAO getMissionsDAO(){
		return new MissionDAO(this);
	}
	
	public PointsDAO getPointsDAO(){
		return new PointsDAO(this);
	}
}
