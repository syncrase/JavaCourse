package javaFundamentalsCorePlatform.streams.files.pearltrees.database.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javaFundamentalsCorePlatform.streams.files.pearltrees.database.dto.LiaisonTagUrlDTO;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton.DBConnection;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton.DBInfo;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton.DaoMeta;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton.DataTransfertObject;

public class LiaisonTagUrlDAO extends DaoMeta {

	public LiaisonTagUrlDAO(DataTransfertObject model) {
	}

	@Override
	public DataTransfertObject exists(DataTransfertObject model) {
		logger.error("Unused method for {}", LiaisonTagUrlDAO.class);
		return null;
	}

	@Override
	public DataTransfertObject insert(DataTransfertObject model) {
		LiaisonTagUrlDTO dto = (LiaisonTagUrlDTO) model;
		try {

			PreparedStatement ps = DBConnection.getPreparedStatement(
					"insert into " + DBInfo.DBName + ".liaison_url_tags (id_url,id_tag,id_path) values (?,?,?)");
			ps.setInt(1, dto.getUrl());
			ps.setInt(2, dto.getTag());
			ps.setInt(3, dto.getPath());
			logger.trace("{}", ps);
			ps.executeUpdate();
			dto.setId(getLastInsertedId("id_liaison_url_tags", "liaison_url_tags"));
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Fail to get or insert", e);
		}
		return dto;
	}

}
