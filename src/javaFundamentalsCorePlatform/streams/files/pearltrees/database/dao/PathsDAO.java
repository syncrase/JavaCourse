package javaFundamentalsCorePlatform.streams.files.pearltrees.database.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.exp.databases.mysql.DBConnection;
import fr.exp.databases.mysql.DBInfo;
import fr.exp.files.pearltrees.database.skeleton.DaoMeta;
import fr.exp.files.pearltrees.database.skeleton.DataTransfertObject;

public class PathsDAO extends DaoMeta {
	DataTransfertObject path;

	public PathsDAO(DataTransfertObject model) {
		this.path = model;
	}

	@Override
	public DataTransfertObject exists(DataTransfertObject model) {
		logger.error("Unused method for {}", PathsDAO.class);
		return null;
	}

	/**
	 * Crée une ligne dans la table path et renvoie son Id. Permet d'identifier un
	 * parent unique alors qu'il y en a plusieurs qui le sont potentiellement. Utile
	 * pour n'avoir qu'une inscription du tag en base de données quand il y a
	 * plusieurs fois son occurence
	 * 
	 * @return
	 */
	@Override
	public DataTransfertObject insert(DataTransfertObject model) {
		this.path = model;
		// logger.trace("Request for a new id path to the database");
		PreparedStatement ps = DBConnection
				.getPreparedStatement("insert into " + DBInfo.DBName + ".paths (id_path) values (0)");
		try {
			// logger.trace("{}", ps);
			ps.executeUpdate();
			this.path.setId(getLastInsertedId("id_path", "paths"));
			return this.path;
		} catch (SQLException e1) {
			e1.printStackTrace();
			logger.error("Unable to have a new id path, It's weird bro...", e1);
		}
		return this.path;
	}

}
