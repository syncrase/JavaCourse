package javaFundamentalsCorePlatform.streams.files.pearltrees;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javaFundamentalsCorePlatform.streams.files.pearltrees.composite.TreeExtractor;
import javaFundamentalsCorePlatform.streams.files.pearltrees.composite.impl.INode;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.TaggedUrlDatabaseIO;
import javaFundamentalsCorePlatform.streams.files.pearltrees.database.dto.TagsDTO;
import javaFundamentalsCorePlatform.streams.files.pearltrees.metamodels.TaggedUrl;

/**
 * All front methods
 * 
 * @author Pierre
 *
 */
public class PearltreesFacade2 {

	private INode pearlTreesExportData;

	public static Logger logger =  LoggerFactory
			.getLogger("fr.exp.files.pearltrees");

	/**
	 * Launch the extraction process
	 * 
	 * @param filePath
	 */
	public PearltreesFacade2(String filePath) {
		logger.trace("Début construction PearltreesFacade2");
		TreeExtractor treeExtractor = new TreeExtractor(filePath);
		pearlTreesExportData = treeExtractor.getContent();
		logger.trace("Fin construction PearltreesFacade2");
	}

	/**
	 * export process
	 * 
	 * @param string
	 * 
	 */
	public void writeHtmlFile(String filePath) {
		logger.trace("Write the result to the file {}", filePath);
		Path path = FileSystems.getDefault().getPath(filePath);
		String html = generateHtml();

		Charset charset = Charset.forName("UTF-8");
		// The BufferedWriter use requires to set the project compliance to 1.7
		try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
			writer.write(html, 0, html.length());
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
			logger.error("Unable to write the result to the file {}", filePath);
		}
	}

	private String generateHtml() {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>\n");
		sb.append("<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=UTF-8\">\n");
		sb.append("<!--This is an automatically generated file.\n");
		sb.append("It will be read and overwritten.\n");
		sb.append("Do Not Edit! -->\n");
		sb.append("<Title>Pearltrees Export</Title>\n");
		sb.append("<H1>Pearltrees Export</H1>\n");
		sb.append("<DL><p>\n");
		sb.append(pearlTreesExportData.getHtmlFormat(0));
		sb.append("</DL><p>\n");
		return sb.toString();
	}

	/**
	 * 
	 * @return
	 */
	public String getFoldedTags() {
		ArrayList<TaggedUrl> taggedUrlList = pearlTreesExportData.getFoldedTags(new ArrayList<TagsDTO>());
		String returnedString = "";
		ArrayList<TagsDTO> foldedTagList;
		for (TaggedUrl taggedUrl : taggedUrlList) {
			foldedTagList = taggedUrl.getTags();
			for (TagsDTO fd : foldedTagList) {
				returnedString += fd.getTag() + (foldedTagList.indexOf(fd) != foldedTagList.size() - 1 ? ", " : "");
			}
			returnedString += ": ";
			returnedString += taggedUrl.getUrl().getLabel() + "\n";
		}
		return returnedString;
	}

	/*
	 * DATABASE METHODS
	 */

	// public String loadFromDataBase() {
	//
	// // Parcours de toutes les urls pour les ajouter une a une à l'objet
	// // pearlTreesExportData
	//
	// TaggedUrlDatabaseIO taggedUrlIO = new TaggedUrlDatabaseIO();
	//
	// // TODO faire en sorte que je reçoive un PearltreesComponent!!! Pas
	// // possible, la nature du PearltreesComponent est une structure de
	// // fichier => une url = un path
	// // Possible si une url apparaît plusieurs fois. problème quand il n'y a
	// // pas de tag de base!!!!
	// // Pas possible d'utiliser PearltreesComponent
	// // Permettra d'utiliser les autres méthodes de la façade + avoir à
	// // disposition tous les IO pour construire l'objet
	// ArrayList<TaggedUrl> taggedUrlList;
	// taggedUrlList = taggedUrlIO.read();
	//
	// StringBuilder sb = new StringBuilder();
	// for (TaggedUrl taggedUrl : taggedUrlList) {
	// // TODO ici ça ne va pas. Chaque url peut avoir plusieurs folded
	// // tags
	// // Donc, récupérer le path pour chaque tag
	// sb.append(taggedUrl.getTags().get(0).getFullPath() +
	// taggedUrl.getUrl().getLabel() + "\n");
	// }
	// return sb.toString();
	// }

	public void deleteAll() {
		TaggedUrlDatabaseIO writer = new TaggedUrlDatabaseIO();
		writer.deleteAll();
	}

	// public String getTablesName() {
	// TaggedUrlDatabaseIO taggedUrlDatabaseIO = new TaggedUrlDatabaseIO();
	//
	// return taggedUrlDatabaseIO.getTablesName();
	// }

	public void saveInDataBase() {
		try {
			logger.trace("Save in data base");

			// Get all taggedUrls
			ArrayList<TaggedUrl> taggedUrlList = pearlTreesExportData.getFoldedTags(new ArrayList<TagsDTO>());
			// Write each taggedUrl in db
			TaggedUrlDatabaseIO writer = new TaggedUrlDatabaseIO();
			for (TaggedUrl taggedUrl : taggedUrlList) {
				writer.taggedUrlInsertion(taggedUrl);
			}
			logger.info("Save complete");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Fail to save in database", e);
		}
	}

	// public String toString() {
	// return pearlTreesExportData.toString();
	// }
}
