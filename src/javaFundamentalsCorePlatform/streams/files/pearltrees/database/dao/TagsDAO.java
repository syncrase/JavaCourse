package javaFundamentalsCorePlatform.streams.files.pearltrees.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.exp.databases.mysql.DBConnection;
import fr.exp.databases.mysql.DBInfo;
import fr.exp.files.pearltrees.database.dto.TagsDTO;
import fr.exp.files.pearltrees.database.skeleton.DaoMeta;
import fr.exp.files.pearltrees.database.skeleton.DataTransfertObject;

public class TagsDAO extends DaoMeta {

	private DataTransfertObject tag;

	public TagsDAO(DataTransfertObject model) {
		this.tag = model;
	}

	/**
	 * Check in the table 'tags' if the tagName exists. If it does, return the id.
	 * If it doesn't, return 0.
	 * 
	 * @param tagName
	 * @return if( tagName exists in 'tags') tagId else 0
	 */
	@Override
	public DataTransfertObject exists(DataTransfertObject tag) {
		this.tag = tag;
		ResultSet resultSet;
		PreparedStatement ps = DBConnection.getPreparedStatement("SELECT * FROM tags WHERE tag = ?");
		try {
			ps.setString(1, ((TagsDTO) this.tag).getTag());
			logger.trace("{}", ps);
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				int id_tag = (int) resultSet.getInt("id_tag");
				((TagsDTO) this.tag).setId(id_tag);
				// logger.trace("{} existe", tag);
				return this.tag;
			}

			logger.trace("{} n'existe pas", tag);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Unable to request tag id for : {}", ((TagsDTO) this.tag).getTag());
		}
		return this.tag;
	}

	/**
	 * Insère dans la base de données.
	 * 
	 * @param tag
	 * @return Un tag avec l'id du tag
	 * @throws SQLException
	 */
	@Override
	public DataTransfertObject insert(DataTransfertObject tag) {
		this.tag = tag;
		try {
			if (this.tag.getId() == 0) {
				PreparedStatement ps = DBConnection
						.getPreparedStatement("insert into " + DBInfo.DBName + ".tags (tag) values (?)");
				ps.setString(1, ((TagsDTO) this.tag).getTag());
				logger.trace("{}", ps);
				ps.executeUpdate();
				((TagsDTO) this.tag).setId(getLastInsertedId("id_tag", "tags"));
			}
		} catch (SQLException e) {
			logger.error("Insert error", e);
		}
		return this.tag;
	}

}
