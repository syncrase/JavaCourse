package javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton;

import fr.exp.files.pearltrees.database.dao.LiaisonFoldedTagsDAO;
import fr.exp.files.pearltrees.database.dao.LiaisonTagUrlDAO;
import fr.exp.files.pearltrees.database.dao.PathsDAO;
import fr.exp.files.pearltrees.database.dao.TagsDAO;
import fr.exp.files.pearltrees.database.dao.UrlsDAO;
import fr.exp.files.pearltrees.database.dto.*;

/**
 * Cette méthode permet d'avoir une façade de DAO.
 * 
 * @author Pierre
 *
 */
public class DAOManipulator implements DaoMustHave {

	private static DaoMustHave dao;

	public DAOManipulator() {

	}

	@Override
	public DataTransfertObject exists(DataTransfertObject dto) {
		selectDao(dto);
		return DAOManipulator.dao.exists(dto);
	}

	@Override
	public DataTransfertObject insert(DataTransfertObject dto) {
		selectDao(dto);
		return DAOManipulator.dao.insert(dto);
	}

	@Override
	public DataTransfertObject getOrInsert(DataTransfertObject dto) {
		selectDao(dto);
		return DAOManipulator.dao.getOrInsert(dto);
	}

	/**
	 * Instancie le bon dao en fonction du type qu'il doit traiter
	 * 
	 * @param dto
	 */
	private static void selectDao(DataTransfertObject dto) {
		// TODO cette méthode est plutôt sale!!! Voir pour trouver un autre moyen
		// d'instancier dynamiquement!
		// Pour la 1ère utilisation de la dao
		if (DAOManipulator.dao == null) {
			if (dto instanceof TagsDTO) {
				DAOManipulator.dao = new TagsDAO(dto);
				return;
			}
			if (dto instanceof UrlsDTO) {
				DAOManipulator.dao = new UrlsDAO(dto);
				return;
			}
			if (dto instanceof PathsDTO) {
				DAOManipulator.dao = new PathsDAO(dto);
				return;
			}
			if (dto instanceof LiaisonTagUrlDTO) {
				DAOManipulator.dao = new LiaisonTagUrlDAO(dto);
				return;
			}
			if (dto instanceof LiaisonFoldedTagsDTO) {
				DAOManipulator.dao = new LiaisonFoldedTagsDAO(dto);
				return;
			}
		}

		// Quand la dao existe déjà
		if (DAOManipulator.dao instanceof TagsDAO) {
			if (dto instanceof TagsDTO) {
				// Je ne touche à rien
				return;
			}
			if (dto instanceof UrlsDTO) {
				DAOManipulator.dao = new UrlsDAO(dto);
				return;
			}
			if (dto instanceof PathsDTO) {
				DAOManipulator.dao = new PathsDAO(dto);
				return;
			}
			if (dto instanceof LiaisonTagUrlDTO) {
				DAOManipulator.dao = new LiaisonTagUrlDAO(dto);
				return;
			}
			if (dto instanceof LiaisonFoldedTagsDTO) {
				DAOManipulator.dao = new LiaisonFoldedTagsDAO(dto);
				return;
			}
		}
		if (DAOManipulator.dao instanceof UrlsDAO) {
			if (dto instanceof TagsDTO) {
				DAOManipulator.dao = new TagsDAO(dto);
				return;
			}
			if (dto instanceof UrlsDTO) {
				// Je ne touche à rien
				return;
			}
			if (dto instanceof PathsDTO) {
				DAOManipulator.dao = new PathsDAO(dto);
				return;
			}
			if (dto instanceof LiaisonTagUrlDTO) {
				DAOManipulator.dao = new LiaisonTagUrlDAO(dto);
				return;
			}
			if (dto instanceof LiaisonFoldedTagsDTO) {
				DAOManipulator.dao = new LiaisonFoldedTagsDAO(dto);
				return;
			}
		}
		if (DAOManipulator.dao instanceof PathsDAO) {
			if (dto instanceof TagsDTO) {
				DAOManipulator.dao = new TagsDAO(dto);
				return;
			}
			if (dto instanceof UrlsDTO) {
				DAOManipulator.dao = new UrlsDAO(dto);
				return;
			}
			if (dto instanceof PathsDTO) {
				// Je ne touche à rien
				return;
			}
			if (dto instanceof LiaisonTagUrlDTO) {
				DAOManipulator.dao = new LiaisonTagUrlDAO(dto);
				return;
			}
			if (dto instanceof LiaisonFoldedTagsDTO) {
				DAOManipulator.dao = new LiaisonFoldedTagsDAO(dto);
				return;
			}
		}
		if (DAOManipulator.dao instanceof LiaisonTagUrlDAO) {
			if (dto instanceof TagsDTO) {
				DAOManipulator.dao = new TagsDAO(dto);
				return;
			}
			if (dto instanceof UrlsDTO) {
				DAOManipulator.dao = new UrlsDAO(dto);
				return;
			}
			if (dto instanceof PathsDTO) {
				DAOManipulator.dao = new PathsDAO(dto);
				return;
			}
			if (dto instanceof LiaisonTagUrlDTO) {
				// Je ne touche à rien
				return;
			}
			if (dto instanceof LiaisonFoldedTagsDTO) {
				DAOManipulator.dao = new LiaisonFoldedTagsDAO(dto);
				return;
			}
		}
		if (DAOManipulator.dao instanceof LiaisonFoldedTagsDAO) {
			if (dto instanceof TagsDTO) {
				DAOManipulator.dao = new TagsDAO(dto);
				return;
			}
			if (dto instanceof UrlsDTO) {
				DAOManipulator.dao = new UrlsDAO(dto);
				return;
			}
			if (dto instanceof PathsDTO) {
				DAOManipulator.dao = new PathsDAO(dto);
				return;
			}
			if (dto instanceof LiaisonTagUrlDTO) {
				DAOManipulator.dao = new LiaisonTagUrlDAO(dto);
				return;
			}
			if (dto instanceof LiaisonFoldedTagsDTO) {
				// Je ne touche à rien
				return;
			}
		}
	}

}
