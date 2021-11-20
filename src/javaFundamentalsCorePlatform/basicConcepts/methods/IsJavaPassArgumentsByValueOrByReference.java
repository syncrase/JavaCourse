package javaFundamentalsCorePlatform.basicConcepts.methods;

public class IsJavaPassArgumentsByValueOrByReference {

	public static void main(String[] args) {

		System.out.println("Test: Modification d'un objet dans une méthode");
		POJO pojc1 = new POJO();
		pojc1.setName("pojc1");
		System.out.println(pojc1.getName());
		changeName(pojc1);
		System.out.println(pojc1.getName());
		// Le nom de l'objet à été modifié dans la méthode
		// --> passage de l'objet par référence
		// --> MAIS la référence est passée par valeur
		//

		System.out.println("Test: Modification d'un type primitif dans une méthode");
		int i = 0;
		System.out.println(i);
		changeInt(i);
		System.out.println(i);
		// La valeur de l'entier n'à pas été modifié dans la méthode
		// --> passage par valeur
	}

	/**
	 * Dans cette méthode, on peut modifier l'objet POJO avec les accessseurs mais
	 * la référence de l'objet ne peut changer => une nouvelle instance de pojo
	 * n'écrasera pas l'instance du pojo qui est passé en paramètre
	 * 
	 * @param pojo
	 */
	static void changeName(POJO pojo) {

		POJO gardeLaRefDuPojoDuMain = pojo;// J'assigne la référence de pojo
		gardeLaRefDuPojoDuMain.setName("gardeLaRefDuPojoDuMain");// Je modifie l'objet reçu en paramètre car je possède
																	// sa référence

		// Changement de référence de l'objet pojo ==> la référence de l'objet main:pojo
		// n'est plus celle de changeName:pojo
		pojo = new POJO();
		pojo.setName("new pojc1");
		// Dans la méthode main le nom de l'objet n'est pas modifié
		// ==> La référence est passée par valeur

		/*
		 * ATTENTION : la référence de gardeLaRefDuPojoDuMain devient la référence de
		 * l'objet main:pojo ==> à partir de là il n'est plus possible de modifier
		 * quoique ce soit venant de l'extérieur de la méthode
		 */
		gardeLaRefDuPojoDuMain = pojo;
		// Il n'est pas possible de modifier la référence de l'objet en paramètre ==>
		// elle est passé par valeur

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
