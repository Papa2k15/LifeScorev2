package ludum.vita.dbtools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import ludum.vita.dao.DatabaseFactory;

public class LSDataGenerator {

	public static void main(String[] args) throws IOException, SQLException {
		LSDataGenerator gen = new LSDataGenerator();
		gen.clearAllTables();
		gen.standardData();
	}

	private String DIR = "sql/data";
	private DatabaseFactory factory;

	public LSDataGenerator() {
		this.factory = DatabaseFactory.getProductionInstance();
	}

	public LSDataGenerator(String projectHome, DatabaseFactory factory) {
		this.DIR = projectHome + "/sql/data";
		this.factory = factory;
	}

	public void clearAllTables() throws SQLException, FileNotFoundException, IOException {
		new DBBuilder(factory).executeSQLFile(DIR + "/deleteFromAllTables.sql");
	}

	public void standardData() throws FileNotFoundException, IOException, SQLException {
		generatePlayers();
		generateMissions();
		generatePoints();
		System.out.println("Operation completed.");
	}

	public void generatePlayers() throws SQLException, FileNotFoundException, IOException{
		new DBBuilder(factory).executeSQLFile(DIR+"/players.sql");
	}

	public void generateMissions() throws SQLException, FileNotFoundException, IOException{
		new DBBuilder(factory).executeSQLFile(DIR+"/missions.sql");
	}
	
	public void generatePoints() throws SQLException, FileNotFoundException, IOException{
		new DBBuilder(factory).executeSQLFile(DIR+"/points.sql");
	}
}
