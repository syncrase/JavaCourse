package javaFundamentalsCorePlatform.basicConcepts.methods;

public class PassReferenceByValue {

	public static void main(String[] args) {
		System.out.println("Test: Modification d'un objet dans une m�thode");
		POJO pojc1 = new POJO();
		pojc1.setName("ext�rieur de la m�thode");
		System.out.println(pojc1.getName());
		changePOJO(pojc1);
		System.out.println(pojc1.getName());
	}

	/**
	 * Re-instanciation du l'objet => la r�f�rence de l'objet pass� en param�tre
	 * n'est pas modifi�e
	 * 
	 * @param pojc1
	 */
	private static void changePOJO(POJO pojc1) {
		pojc1 = new POJO();
		pojc1.setName("coucou de l'int�rieur");
	}

}
