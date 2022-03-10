package lythuyet.tuan3;

import java.io.Serializable;

public class Book implements Serializable{
	private String tieuDe;

	public Book(String tieuDe) {
		super();
		this.tieuDe = tieuDe;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	
}
