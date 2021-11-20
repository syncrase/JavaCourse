package javaFundamentalsCorePlatform.basicConcepts.methods;

public class PassReferenceByValue {

	public static void main(String[] args) {
		System.out.println("Test: Modification d'un objet dans une méthode");
		POJO pojc1 = new POJO();
		pojc1.setName("extérieur de la méthode");
		System.out.println(pojc1.getName());
		changePOJO(pojc1);
		System.out.println(pojc1.getName());
	}

	/**
	 * Re-instanciation du l'objet => la référence de l'objet passé en paramètre
	 * n'est pas modifiée
	 * 
	 * @param pojc1
	 */
	private static void changePOJO(POJO pojc1) {
		pojc1 = new POJO();
		pojc1.setName("coucou de l'intérieur");
	}

}
