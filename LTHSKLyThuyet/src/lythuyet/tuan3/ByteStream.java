package lythuyet.tuan3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ByteStream {
	public static void main(String[] args) throws IOException{
		FileReader inStream = null;
		FileWriter outStream = null;
		
		try {
			inStream = new FileReader("data\\srcfile.txt");
			outStream = new FileWriter("data\\desfile.txt");
			
			int c;
			
			while ((c = inStream.read()) != -1) {
				outStream.write(c);
			}
			System.out.println("Xong rồi nè bạn ơi!");
			
		} finally {
			// TODO: handle finally clause
			if (inStream != null) inStream.close();
			if (outStream != null) outStream.close();
		}
	}
}
