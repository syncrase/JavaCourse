package javaFundamentalsCorePlatform.streams.files.pearltrees;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.css.Counter;

public class Run {

	public static Logger logger = LoggerFactory.getLogger("fr.exp.files.pearltrees");

	public static void main(String[] args) {
		logger.warn("Main lauched");
//		Counter counter = Counter.getCounter();
//		counter.start();

		// pearltrees_export20171007.html
		// files/in/pearltrees_export-25-12-2016.html
		PearltreesFacade2 pearltreesFacade2 = new PearltreesFacade2("files/in/pearltrees_export20171007.html");
		// print(pearltreesFacade2.getFoldedTags());
		// pearltreesFacade2.writeHtmlFile("files/out/my_pearltrees_export.html");

		pearltreesFacade2.deleteAll();
		pearltreesFacade2.saveInDataBase();

		// print(pearltreesFacade2.getTablesName());
		// print(pearltreesFacade2.loadFromDataBase());

		// Sauvegarde du résultat en base de données
		// Structure de dossier -> le tag complexe de chaque url doit être son
		// path dans la struture de dossiers
		// 1- Afficher toutes les urls avec son tag complexe
		// 2- Enregistrer toutes les url dans la base de données
		// 3- Récupérer les objets dans la BDD ? GetTags()? GetUrls()?
		// GetUrlTaggedWith(Tag tag)? GetUrlTaggedWith(Tag[] tags)?
		// 4- Exporter les données de l'objet vers un fichier html d'export
		// formaté à la manière de pearltrees

		// fichier pearltrees <-> java objet <-> base données
		// => 4 interactions à coder. Code pour générer le java en tout ou
		// partie?
		// Sachant que la base de données peut-être mongodb, neo4j, ... et
		// fichier! ==>> Bosser sur le pattern adéquat! (builder, factory?)
//		counter.stop();
//		logger.warn("Time elapsed: {}", counter.getTime());
	}

	// private static void print(String msg, Object... args) {
	// if (args.length == 0) {
	// System.out.println(msg);
	// } else {
	// System.out.println(String.format(msg, args));
	// }
	// }
	//
	// private static String trim(String s, int width) {
	// if (s.length() > width)
	// return s.substring(0, width - 1) + ".";
	// else
	// return s;
	// }

}
