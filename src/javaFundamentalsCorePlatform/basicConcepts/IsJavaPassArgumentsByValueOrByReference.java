package javaFundamentalsCorePlatform.basicConcepts;

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
     * Dans cette méthode, on peut modifier l'objet POJO avec les accessseurs mais la référence ne l'objet ne peut
     * changer. Autrement dit une nouvelle instance de pojo n'écrasera pas l'instance du pojo qui est passé en paramètre
     * 
     * @param pojo
     */
    static void changeName(POJO pojo) {

        POJO gardeLaRefDuPojoDuMain = pojo;// J'assigne la référence de pojo
        pojo = new POJO();// Création d'un nouvelle référence propre à l'intérieur de la méthode changeName --> à partir
                          // de là, toutes les modifications faites sur pojo seront inaccessibles à la sorties de la
                          // méthode ==> la référence de l'objet main:pojo n'est plus celle de changeName:pojo

        gardeLaRefDuPojoDuMain.setName("gardeLaRefDuPojoDuMain");
        pojo.setName("new pojc1");
        // Dans la méthode main le nom de l'objet n'est pas modifié
        // ==> La référence est passée par valeur

        gardeLaRefDuPojoDuMain = pojo;
        // Il n'est pas possible de modifier la référence de l'objet en paramètre ==> elle est passé par valeur
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
