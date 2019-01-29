package javaFundamentalsCorePlatform.streams.files.pearltrees.database.dto;

import java.net.MalformedURLException;
import java.net.URL;

import fr.exp.files.pearltrees.database.skeleton.DataTransfertObject;

public class UrlsDTO implements DataTransfertObject {

	private int id_url;
	private URL url;
	private String label;

	public UrlsDTO(URL url, String label) {
		super();
		this.url = url;
		this.label = label;
		this.id_url = 0;
	}

	public UrlsDTO(int id_url, String url, String label) {
		super();

		this.id_url = id_url;
		this.label = label;
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public UrlsDTO(int id_url) {
		this.id_url = id_url;
	}

	public UrlsDTO() {
	}

	@Override
	public int getId() {
		return id_url;
	}

	@Override
	public void setId(int id_url) {
		this.id_url = id_url;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String toString() {
		return "{" + id_url + ", " + label + ": " + url.toString() + "}";
	}
}
