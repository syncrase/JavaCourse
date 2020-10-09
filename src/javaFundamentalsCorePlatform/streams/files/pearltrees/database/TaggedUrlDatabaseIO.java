package javaFundamentalsCorePlatform.streams.files.pearltrees.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javaFundamentalsCorePlatform.streams.files.pearltrees.database.dto.LiaisonFoldedTagsDTO;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.dto.LiaisonTagUrlDTO;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.dto.PathsDTO;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.dto.TagsDTO;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.dto.UrlsDTO;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton.DAOManipulator;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton.DBConnection;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton.DataTransfertObject;
import javaFundamentalsCorePlatform.streams.files.pearltrees.metamodels.TaggedUrl;

public class TaggedUrlDatabaseIO {
	public static Logger logger = LoggerFactory.getLogger("fr.exp.files.pearltrees");

	// TODO pour beaucoup plus tard. Si je veux faire des UI pour manipuler tout ça.
	// Des méthodes pour rassembler des paths. Supprimer des paths entier. recréer
	// le path quand un tag est supprimé
	// Mais en priorité, permettre à une url d'avoir plusieurs foldedTags!!!

	public void taggedUrlInsertion(TaggedUrl taggedUrl) {

		logger.trace("Get or insert {}", taggedUrl.getUrl().toString());
		DAOManipulator dao = new DAOManipulator();

		// Get or insert the url
		taggedUrl.setUrl((UrlsDTO) dao.insert(taggedUrl.getUrl()));

		insert(taggedUrl);
	}

	private void insert(TaggedUrl taggedUrl) {
		logger.info("{}", taggedUrl.toString());

		DAOManipulator dao = new DAOManipulator();
		taggedUrl.setPath(dao.insert(new PathsDTO()));
		DataTransfertObject tag = new TagsDTO();
		if (taggedUrl.getTags().size() > 0) {
			tag = taggedUrl.getTags().get(0);
			tag = dao.getOrInsert(tag);
			taggedUrl.getTags().set(0, (TagsDTO) tag);
		}

		for (int i = 0; i < taggedUrl.getTags().size(); i++) {
			if (i == taggedUrl.getTags().size() - 1) {
				LiaisonTagUrlDTO dto = new LiaisonTagUrlDTO(taggedUrl.getUrl().getId(),
						taggedUrl.getTags().get(i).getId(), taggedUrl.getPath().getId());
				dao.insert(dto);
			} else {
				tag = dao.getOrInsert(taggedUrl.getTags().get(i + 1));
				// Write child tag in db
				taggedUrl.getTags().set(i + 1, (TagsDTO) tag);
				LiaisonFoldedTagsDTO dto = new LiaisonFoldedTagsDTO(taggedUrl.getPath().getId(),
						taggedUrl.getTags().get(i + 1).getId(), taggedUrl.getTags().get(i).getId());
				dao.insert(dto);
			}
		}
		logger.trace("Fin de l'inscription de l'url taggées");
	}

	public ArrayList<TaggedUrl> read() {
		logger.trace("Read for all urls");

		ResultSet resultSet;
		TaggedUrlsMap pool = new TaggedUrlsMap();
		try {
			String query = "";
			// TODO Comment récupérer les urls et tous leurs tags dans une seule
			// requête?
			query += "SELECT * " + "FROM urls U, liaison_url_tags L, tags T "
					+ "WHERE U.id_url = L.id_url AND T.id_tag = L.id_tag";
			// AND L.id_path = F.id_path
			// AND F.id_parent = T.id_tag --> pas nécessaire puisque j'ai le
			// path j'obtiens l'information id_parent dans le retour
			resultSet = DBConnection.executeQuery(query);
			int path;
			UrlsDTO url;
			// FoldedTag tag;
			TagsDTO tag;
			TaggedUrl taggedUrl;
			while (resultSet.next()) {
				url = new UrlsDTO(resultSet.getInt("U.id_url"), resultSet.getString("U.url"),
						resultSet.getString("U.label"));
				// tag = new FoldedTag(resultSet.getInt("T.id_tag"),
				// resultSet.getString("T.tag"));
				tag = new TagsDTO(resultSet.getInt("T.id_tag"), resultSet.getString("T.tag"));

				path = resultSet.getInt("L.id_path");

				taggedUrl = new TaggedUrl(url, tag, path);
				pool.add(taggedUrl);
			}

			// Maintenant que l'on a récupéré toutes les urls taggées, on
			// récupère les tags parents

			// Je parcours la liste des taggedUrl pour checker le path et
			// requêter (
			// si le path n'existe pas déjà dans la map je le crée)
			// Sinon je crée

			// Parcours récursif de l'arbre et ajout du tag parent récursivement
			// Map accessible par singleton
			for (TaggedUrl obtainedTaggedUrl : pool.getArrayList()) {
				query = "SELECT * "// U.id_url U.url U.label T.tag
						+ "FROM liaison_url_tags L, liaison_folded_tags F, tags T " + "WHERE L.id_url = "
						+ obtainedTaggedUrl.getUrl().getId()
						+ " AND L.id_path = F.id_path AND F.id_parent_tag  = T.id_tag";
				resultSet = DBConnection.executeQuery(query);
				while (resultSet.next()) {
					// Je récupère tous les tags et je les ajoute à mon objet
					// obtainedTaggedUrl.addTag(new FoldedTag(resultSet.getInt("id_tag"),
					// resultSet.getString("tag")),
					// resultSet.getInt("id_parent_tag"));
					obtainedTaggedUrl.addTag(new TagsDTO(resultSet.getInt("id_tag"), resultSet.getString("tag")),
							resultSet.getInt("id_parent_tag"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Read for all urls", e);
		}
		return pool.getArrayList();
	}

	public void deleteAll() {
		logger.trace("Delete the whole database content");
		PreparedStatement delete;
		try {
			delete = DBConnection.getPreparedStatement("DELETE FROM `liaison_folded_tags` WHERE 1");
			delete.executeUpdate();
			delete = DBConnection.getPreparedStatement("DELETE FROM `liaison_url_tags` WHERE 1");
			delete.executeUpdate();
			delete = DBConnection.getPreparedStatement("DELETE FROM `tags` WHERE 1");
			delete.executeUpdate();
			delete = DBConnection.getPreparedStatement("DELETE FROM `urls` WHERE 1");
			delete.executeUpdate();
			delete = DBConnection.getPreparedStatement("DELETE FROM `paths` WHERE 1");
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Unable to delete the whole database content", e);
		}
	}

	// public String getTablesName() {
	// logger.trace("Get database table names");
	// // Cette méthode n'a rien à faire dans cette classe. Créer un classe
	// // DatabaseIO? DBConnection?
	// ResultSet resultSet;
	// String query = "";
	// String returnedString = "";
	// ArrayList<String> tableList = new ArrayList<String>();
	// // requête?
	// query += "SELECT TABLE_NAME FROM information_schema.tables "
	// + "where TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA = 'pearltrees_data'";
	// // AND L.id_path = F.id_path
	// // AND F.id_parent = T.id_tag --> pas nécessaire puisque j'ai le
	// // path j'obtiens l'information id_parent dans le retour
	// try {
	// resultSet = DBConnection.executeQuery(query);
	// while (resultSet.next()) {
	// // TODO need some parse
	// tableList.add(resultSet.getString("TABLE_NAME"));
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// logger.error("Unable to get database table names");
	// }
	//
	// for (String tableName : tableList) {
	// returnedString += tableName + "\n";
	// }
	// return null;
	// }
}
