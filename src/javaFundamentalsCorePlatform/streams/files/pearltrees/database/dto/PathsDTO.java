package javaFundamentalsCorePlatform.streams.files.pearltrees.database.dto;

import fr.exp.files.pearltrees.database.skeleton.DataTransfertObject;

public class PathsDTO implements DataTransfertObject {

	private int id_path;

	public PathsDTO(int path_id) {
		this.id_path = path_id;
	}

	public PathsDTO() {
	}

	@Override
	public void setId(int id_path) {
		this.id_path = id_path;
	}

	@Override
	public int getId() {
		return this.id_path;
	}

}
