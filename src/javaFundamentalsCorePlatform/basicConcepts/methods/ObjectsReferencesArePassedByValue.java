package javaFundamentalsCorePlatform.basicConcepts.methods;

public class ObjectsReferencesArePassedByValue {

	public static void main(String[] args) {

		System.out.println("Test: Modification d'un objet dans une m�thode");
		POJO pojc1 = new POJO();
		pojc1.setName("pojc1");
		System.out.println(pojc1.getName());
		changeName(pojc1);
		System.out.println(pojc1.getName());
		// Le nom de l'objet � �t� modifi� dans la m�thode
		// --> passage de l'objet par r�f�rence
		// --> MAIS la r�f�rence est pass�e par valeur
		//

		System.out.println("Test: Modification d'un type primitif dans une m�thode");
		int i = 0;
		System.out.println(i);
		changeInt(i);
		System.out.println(i);
		// La valeur de l'entier n'� pas �t� modifi� dans la m�thode
		// --> passage par valeur
	}

	/**
	 * Dans cette m�thode, on peut modifier l'objet POJO avec les accessseurs mais
	 * la r�f�rence de l'objet ne peut changer => une nouvelle instance de pojo
	 * n'�crasera pas l'instance du pojo qui est pass� en param�tre
	 * 
	 * @param pojo
	 */
	static void changeName(POJO pojo) {

		POJO gardeLaRefDuPojoDuMain = pojo;// J'assigne la r�f�rence de pojo
		gardeLaRefDuPojoDuMain.setName("gardeLaRefDuPojoDuMain");// Je modifie l'objet re�u en param�tre car je poss�de
																	// sa r�f�rence

		// Changement de r�f�rence de l'objet pojo ==> la r�f�rence de l'objet main:pojo
		// n'est plus celle de changeName:pojo
		pojo = new POJO();
		pojo.setName("new pojc1");
		// Dans la m�thode main le nom de l'objet n'est pas modifi�
		// ==> La r�f�rence est pass�e par valeur

		/*
		 * ATTENTION : la r�f�rence de gardeLaRefDuPojoDuMain devient la r�f�rence de
		 * l'objet main:pojo ==> � partir de l� il n'est plus possible de modifier
		 * quoique ce soit venant de l'ext�rieur de la m�thode
		 */
		gardeLaRefDuPojoDuMain = pojo;
		// Il n'est pas possible de modifier la r�f�rence de l'objet en param�tre ==>
		// elle est pass� par valeur

		// JE MODIFIE LA VALEUR DE LA REFERENCE A L'INTERIEUR DE LA METHODE<br>
		// LA REFERENCE DE L'OBJET A L'EXTERIEUR REST INCHANGEE
	}

	static void changeInt(int i) {
		i = 5;
	}
}

class POJO {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
