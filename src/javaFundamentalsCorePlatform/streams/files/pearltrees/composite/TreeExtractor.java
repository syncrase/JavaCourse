package javaFundamentalsCorePlatform.streams.files.pearltrees.composite;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.LoggerFactory;

import fr.exp.files.pearltrees.composite.impl.INode;
import fr.exp.files.pearltrees.composite.impl.PearltreesComposite;
import fr.exp.files.pearltrees.composite.impl.utils.TreeBuilder;

/**
 * The private constructor allow to parse the html file and to build a tree
 * structure with the abstract class TreeBuilder
 * 
 * @author Pierre
 *
 */
public class TreeExtractor extends TreeBuilder {

	INode content;

	public static ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory
			.getLogger("fr.exp.files.pearltrees");

	/**
	 * The private constructor parse the html file and build a tree structure with
	 * the abstract class TreeBuilder. Core of the extraction process
	 * 
	 * @filepath path of the file to parse
	 */
	public TreeExtractor(String filePath) {
		super();
		logger.trace("Parse the pearltrees file: {}", filePath);

		File input = new File(filePath);
		Document doc;
		try {
			doc = Jsoup.parse(input, "UTF-8");
			Elements allElements = doc.getAllElements();
			content = new PearltreesComposite();
			logger.trace("Begin to construct the content representative objet");
			this.build(allElements, (PearltreesComposite) content);
			logger.trace("Finish to construct the content representative objet");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Unable to parse the file: {}", filePath);
		}

	}

	public INode getContent() {
		return content;
	}

}
