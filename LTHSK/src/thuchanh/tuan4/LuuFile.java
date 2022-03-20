package thuchanh.tuan4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class LuuFile {
	public boolean luuFile(Object obj, String filePath) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		return true;
	}
	
	public Object docFile(String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
		Object o = ois.readObject();
		ois.close();
		return o;
	}
	
	public SachCollection docFile2(String filePath) throws IOException {
		int i = 0;
		String[] data;
		String line;
		FileInputStream fis = new FileInputStream(filePath);
		Scanner sc = new Scanner(fis);
		SachCollection dsSach = new SachCollection();
		while (sc.hasNextLine()) {
			Sach sach = new Sach();
			line = sc.nextLine();
			data = line.split(";");
			
			sach.setMaSach(data[i]);
			sach.setTuaSach(data[++i]);
			sach.setNamXuatBan(Integer.parseInt(data[++i]));
			sach.setSoTrang(Integer.parseInt(data[++i]));
			sach.setISBN(data[++i]);
			sach.setTacGia(data[++i]);
			sach.setNXB(data[++i]);
			sach.setDonGia(Double.parseDouble(data[++i]));
			
			dsSach.themSach(sach);
			System.out.println(line);
			i=0;
		}
		sc.close();
		fis.close();
		return dsSach;
	}
}
