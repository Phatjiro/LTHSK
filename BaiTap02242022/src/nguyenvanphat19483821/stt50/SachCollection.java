package nguyenvanphat19483821.stt50;

import java.util.ArrayList;

public class SachCollection {
	private ArrayList<Sach> dsSach;

	public SachCollection() {
		dsSach = new ArrayList<Sach>();
	}
	
	public boolean themSach(Sach sach) {
		if (dsSach.contains(sach)) {
			return false;
		} else {
			dsSach.add(sach);
			return true;
		}
	}
	
	public boolean xoaSach(String maSach) {
		Sach sach = new Sach(maSach);
		if(dsSach.contains(sach)) {
			dsSach.remove(sach);
			return true;
		}
		return false;
	}
	
	public Sach timSach(String maSach) {
		Sach sach = new Sach(maSach);
		if (dsSach.contains(sach)) {
			return dsSach.get(dsSach.indexOf(sach));
		}
		return null;
	}

	public ArrayList<Sach> getDsSach() {
		return dsSach;
	}

	public void setDsSach(ArrayList<Sach> dsSach) {
		this.dsSach = dsSach;
	}
	
	public Sach getElement(int i) {
		if (i < 0 && i > dsSach.size()) {
			return null;
		}
		return dsSach.get(i);
	}
	
	public int getSize() {
		return dsSach.size();
	}
	
	public void inDsSach() {
		for(int i=0; i<dsSach.size(); i++) {
			dsSach.get(i).toString();
		}
	}
}
