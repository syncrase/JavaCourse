package javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton;

public interface DaoMustHave {

	/**
	 * Si l'objet existe, le renvoie complété de son id. Sinon tel quel.
	 * 
	 * @param dto
	 * @return
	 */
	DataTransfertObject exists(DataTransfertObject dto);

	/**
	 * Insère l'objet en base de données et renvoie l'objet complété de son ID
	 * 
	 * @param dto
	 * @return
	 */
	DataTransfertObject insert(DataTransfertObject dto);

	DataTransfertObject getOrInsert(DataTransfertObject dto);

}
