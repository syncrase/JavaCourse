package javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton;

/**
 * Sert à signifier que l'objet est reçevable par les méthodes de l'interface
 * DaoMustHave.java Cette interface sert à englober l'ensemble des dto sous un
 * même nom
 * 
 * @author Pierre
 *
 */
public interface DataTransfertObject {

	int getId();

	void setId(int lastInsertedId);

}
