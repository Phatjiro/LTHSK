package lythuyet.tuan3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestIOStream {
	public static void main(String[] args) throws Exception{
		FileInputStream fileIN = null;
		FileOutputStream fileOUT = null;
		
		try {
			fileIN = new FileInputStream("D:\\Code\\Java\\EclipseWorkNew\\LTHSKLyThuyet\\data\\IOStream.txt");
			fileOUT = new FileOutputStream("D:\\Code\\Java\\EclipseWorkNew\\LTHSKLyThuyet\\data\\IOStream_copy.txt");
			
			int c;
			while((c=fileIN.read()) != -1) {
				fileOUT.write(c);
			}
			System.out.println("Xong r nè broooo ơi!!");
		} finally {
			// TODO: handle finally clause
			if (fileIN != null) fileIN.close();
			if (fileOUT != null) fileOUT.close();
		}
	}
}
