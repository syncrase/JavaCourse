package javaFundamentalsCorePlatform.streams.files.merger;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javaFundamentalsCorePlatform.streams.files.merger.filetype.IFileType;
import javaFundamentalsCorePlatform.streams.files.merger.skeleton.MergeableFileFactory;
import javaFundamentalsCorePlatform.streams.files.merger.skeleton.Merger;

public class RunAccessPoint {

	public static Logger logger = LoggerFactory.getLogger("fr.exp.files.*");

	public static void main(String[] args) {
		logger.warn("Main lauched");
//		Counter counter = Counter.getCounter();
//		counter.start();

		try {
			// 1/ r�cup�ration du tableau ordonn�, depuis le fichier texte, contenant
			// tous les noms de colonne
			logger.warn("Initialization of 'files/in/export.xls'");
			IFileType manipulator1 = MergeableFileFactory.getMergeableFile("files/in/export.xls");
			String[] columnCorrespondance1 = { "IDART", "IMAGE", "DEF", "", "", "BaseHT", "PRIX_TTC", "", "",
					"LOCATION" };
			manipulator1.setMapping(columnCorrespondance1);

			logger.warn("Initialization of 'files/in/ETAT_DU_STOCK.xls'");
			IFileType manipulator2 = MergeableFileFactory.getMergeableFile("files/in/ETAT_DU_STOCK.xls");
			String[] columnCorrespondance2 = { "", "", "", "", "", "", "", "Qt� en Stock", "", "" };
			manipulator2.setMapping(columnCorrespondance2);

//			logger.warn("Initialization of 'files/in/ipf_product (1).csv'");
//			IFileType manipulator3 = MergeableFileFactory.getMergeableFile("files/in/ETAT_DU_STOCK.xls");
//			String[] columnCorrespondance3 = { "", "", "", "", "", "", "", "Qt� en Stock", "", "" };
//			manipulator3.setMapping(columnCorrespondance3);

			// 3/ Enregistrement du mapping entre les deux tables, ie table de
			// correspondance cl� valeur (cl�: nom dans la table d'entr�e; valeur: nom dans
			// la table de sortie) UI facile � faire?
			// Prend quelque chose dans la table d'entr�e pour le mettre dans la table de
			// sortie
			// => Construction du tableau contenant les index des colonnes du tableau
			// d'entr�e qui m'int�ressent, dont la longueur �gale celle du tableau de sortie
			//
			// correspondance entre le format prestashop et le format haxia
			// "Product ID"; IDART
			// Image; IMAGE
			// Name; DEF
			// Reference;
			// Category;
			// "Base price"; BaseHT
			// "Final price"; PRIX_TTC
			// Quantity; Unite
			// Status;
			// Position LOCATION
			// index will be the index of the OUT file, value is the index in the IN file
			// where the real value is. The value is a kind of pointer
			// 4/ G�n�ration de la table de sortie contenant toutes les valeurs d�sir�es
			// g�n�ration de la ligne contenant les noms des colonnes
			// g�n�ration des lignes contenant les donn�es dump�es depuis le fichier
			// d'entr�e

			logger.warn("Initialize the merger");
			// r�cup�ration du format du fichier de sorti
			Merger merger = new Merger();
			IFileType desiredLayout = MergeableFileFactory.getMergeableFile("files/in/prestashop_product_export.csv");
			desiredLayout.loadTitles();
			logger.warn("Start merging");
			// merger.printPrestashopComptatibleCSV(desiredLayout, manipulator1,
			// manipulator3);
			List<IFileType> fileList = new ArrayList<IFileType>();
			fileList.add(manipulator1);
			fileList.add(manipulator2);
//			fileList.add(manipulator3);
			merger.merge(desiredLayout, fileList);
//			counter.stop();
//			logger.warn("Time elapsed: {}", counter.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
