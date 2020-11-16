package javaFundamentalsCorePlatform.streams.files.pearltrees.database.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javaFundamentalsCorePlatform.streams.files.pearltrees.database.dto.LiaisonFoldedTagsDTO;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton.DBConnection;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton.DBInfo;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton.DaoMeta;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton.DataTransfertObject;

public class LiaisonFoldedTagsDAO extends DaoMeta {

	public LiaisonFoldedTagsDAO(DataTransfertObject model) {
	}

	@Override
	public DataTransfertObject exists(DataTransfertObject model) {
		logger.error("Unused method for {}", PathsDAO.class);
		return null;
	}

	@Override
	public DataTransfertObject insert(DataTransfertObject model) {
		LiaisonFoldedTagsDTO dto = (LiaisonFoldedTagsDTO) model;
		try {

			PreparedStatement ps = DBConnection.getPreparedStatement("insert into " + DBInfo.DBName
					+ ".liaison_folded_tags (id_path,id_tag,id_parent_tag) values (?,?,?)");
			ps.setInt(1, dto.getPath());
			ps.setInt(2, dto.getTag());
			ps.setInt(3, dto.getParent());
			logger.trace("{}", ps);
			ps.executeUpdate();
			dto.setId(getLastInsertedId("id_liaison_folded_tags", "liaison_folded_tags"));
		} catch (SQLException e) {
			logger.error("Fail to get or insert", e);
		}
		return dto;
	}

}
