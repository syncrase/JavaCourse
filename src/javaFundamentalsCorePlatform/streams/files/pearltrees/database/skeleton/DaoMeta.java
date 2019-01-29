package javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.LoggerFactory;

import fr.exp.databases.mysql.DBConnection;
import fr.exp.databases.mysql.DBInfo;

public abstract class DaoMeta implements DaoMustHave {

	static protected ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory
			.getLogger("pearltrees.dao");

	protected int getLastInsertedId(String column_name, String table_name) {
		// Get the id of the last inserted row
		ResultSet resultSet;
		String query = "SELECT " + column_name + " FROM " + DBInfo.DBName + "." + table_name + " ORDER BY "
				+ column_name + " DESC LIMIT 1";
		try {
			resultSet = DBConnection.executeQuery(query);
			if (resultSet.next()) {
				int lastInserted = resultSet.getInt(column_name);
				// logger.trace("Returned id {} from query : {}", lastInserted, query);
				return lastInserted;

			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Unable to request for the last inserted id", e);
		}
		return 0;
	}

	public DataTransfertObject getOrInsert(DataTransfertObject dto) {
		dto = exists(dto);
		if (dto != null && dto.getId() == 0)
			dto = insert(dto);
		return dto;
	}

}
