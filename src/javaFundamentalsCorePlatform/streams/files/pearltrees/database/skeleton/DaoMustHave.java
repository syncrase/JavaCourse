package javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton;

public interface DaoMustHave {

	/**
	 * Si l'objet existe, le renvoie compl�t� de son id. Sinon tel quel.
	 * 
	 * @param dto
	 * @return
	 */
	DataTransfertObject exists(DataTransfertObject dto);

	/**
	 * Ins�re l'objet en base de donn�es et renvoie l'objet compl�t� de son ID
	 * 
	 * @param dto
	 * @return
	 */
	DataTransfertObject insert(DataTransfertObject dto);

	DataTransfertObject getOrInsert(DataTransfertObject dto);

}
