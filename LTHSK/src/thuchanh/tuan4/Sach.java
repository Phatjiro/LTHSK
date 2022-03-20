package thuchanh.tuan4;

import java.util.Objects;

public class Sach {
	private String maSach;
	private String tuaSach;
	private int namXuatBan;
	private int soTrang;
	private String ISBN;
	private String tacGia;
	private String NXB;
	private Double donGia;
	
	public Sach(String maSach, String tuaSach, int namXuatBan, int soTrang, String iSBN, 
			String tacGia, String nXB, Double donGia) {
		super();
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.namXuatBan = namXuatBan;
		this.soTrang = soTrang;
		ISBN = iSBN;
		this.tacGia = tacGia;
		NXB = nXB;
		this.donGia = donGia;
	}

	public Sach(String maSach) {
		super();
		this.maSach = maSach;
	}
	
	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTuaSach() {
		return tuaSach;
	}

	public void setTuaSach(String tuaSach) {
		this.tuaSach = tuaSach;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getNXB() {
		return NXB;
	}

	public void setNXB(String nXB) {
		NXB = nXB;
	}

	public Double getDonGia() {
		return donGia;
	}

	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}

	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tuaSach=" + tuaSach + ", namXuatBan=" + namXuatBan + ", soTrang=" + soTrang
				+ ", ISBN=" + ISBN + ", tacGia=" + tacGia + ", NXB=" + NXB + ", donGia=" + donGia + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSach);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(maSach, other.maSach);
	}
	
}
