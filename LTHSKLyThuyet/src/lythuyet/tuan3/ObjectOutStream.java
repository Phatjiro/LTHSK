package lythuyet.tuan3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutStream {
	public static void main(String[] args) throws IOException{
		Book book1 = new Book("Phát nè");
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("data\\Sach.txt");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(book1);
			oos.flush();
			System.out.println("Xong rồi nè bro ơi");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			if(fos != null) fos.close();
			if(oos != null) oos.close();
		}
	}
}
