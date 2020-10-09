package javaFundamentalsCorePlatform.streams.files.pearltrees.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javaFundamentalsCorePlatform.streams.files.pearltrees.database.dto.UrlsDTO;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton.DBConnection;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton.DBInfo;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton.DaoMeta;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton.DataTransfertObject;

public class UrlsDAO extends DaoMeta {

	private DataTransfertObject url;

	public UrlsDAO(DataTransfertObject model) {
		this.url = model;
	}

	public DataTransfertObject insert(DataTransfertObject url) {
		this.url = (UrlsDTO) url;
		PreparedStatement insertIntoTagsStatement = DBConnection
				.getPreparedStatement("insert into " + DBInfo.DBName + ".urls (url,label) values (?, ?)");
		try {
			insertIntoTagsStatement.setString(1, ((UrlsDTO) this.url).getUrl().toString());
			insertIntoTagsStatement.setString(2, ((UrlsDTO) this.url).getLabel());
			logger.trace("{}", insertIntoTagsStatement);
			insertIntoTagsStatement.executeUpdate();

			((UrlsDTO) this.url).setId(getLastInsertedId("id_url", "urls"));
			return this.url;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Fail to update", e);
		}
		return this.url;
	}

	/**
	 * Récupère une Url en base de données à partir de l'url et du label
	 * 
	 * @param url Url contenant url ET label
	 * @return L'objet url complété de son id en base de données, ou pas s'il
	 *         n'existe pas.
	 */
	public DataTransfertObject exists(DataTransfertObject url) {
		ResultSet resultSet;
		PreparedStatement ps = DBConnection.getPreparedStatement("SELECT * FROM urls WHERE url = ? & label = ?");
		try {
			ps.setString(1, ((UrlsDTO) this.url).getUrl().toString());
			ps.setString(2, ((UrlsDTO) this.url).getLabel());
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				int id_url = (int) resultSet.getInt("id_url");
				logger.trace("{}", ps);
				((UrlsDTO) this.url).setId(id_url);
				return url;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Unable to check if {} exists", ((UrlsDTO) this.url));
		}
		return this.url;
	}

}
