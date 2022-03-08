package thuchanh.tuan2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NhanVienCollection {
	private ArrayList<NhanVien> dsNV;
	
	public NhanVienCollection() {
		dsNV = new ArrayList<NhanVien>();
	}
	
	public boolean themNV(NhanVien nv) {
		if(dsNV.contains(nv)) {
			return false;
		}
		else {
			dsNV.add(nv);
			return true;
		}
	}
	
	public boolean xoaNV(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if(dsNV.contains(nv)) {
			dsNV.remove(nv);
			return true;
		}
		return false;
	}
	
	public NhanVien timKiem(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if(dsNV.contains(nv)) {
			return dsNV.get(dsNV.indexOf(nv));
		}
		return null;
	}

	public ArrayList<NhanVien> getDsNV() {
		return dsNV;
	}

	public void setDsNV(ArrayList<NhanVien> dsNV) {
		this.dsNV = dsNV;
	}
	
	public NhanVien getElement (int index) {
		if(index < 0 || index > dsNV.size()) {
			return null;
		}
		else {
			return dsNV.get(index);
		}
	}
	
	public int getSize() {
		return dsNV.size();
	}
}
