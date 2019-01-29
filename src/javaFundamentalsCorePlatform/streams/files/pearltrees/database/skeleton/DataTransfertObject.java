package javaFundamentalsCorePlatform.streams.files.pearltrees.database.skeleton;

/**
 * Sert � signifier que l'objet est re�evable par les m�thodes de l'interface
 * DaoMustHave.java Cette interface sert � englober l'ensemble des dto sous un
 * m�me nom
 * 
 * @author Pierre
 *
 */
public interface DataTransfertObject {

	int getId();

	void setId(int lastInsertedId);

}
