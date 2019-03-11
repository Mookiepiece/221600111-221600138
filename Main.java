import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class Main{
	
	public static void main(String[] args) {
		//
		if(args.length!=1) {
			if(args.length==0) {
				System.err.println("No files inputed!"); 
				System.exit(0);
			}
			System.err.println("Only one parameter could be inpted!");
			System.exit(0);
		}
		if(!args[0].equals("input.txt")) {
			System.err.println("Incorrect file name!");
			System.exit(0);
		}
		//
		File inFile=new File(args[0]);
		FileInputStream inStream;
		try {
			
			
			
			inStream=new FileInputStream(inFile);
			try {
				int inChar;
				while((inChar=inStream.read())!=-1) {
					//TODO MK
				}
				inStream.close();
			} catch (IOException e) {
				System.err.println("Read char failed!");
				System.exit(0);
			}
			

			String s="TODO MK";//TODO MK
			
			File oFile=new File("result.txt");
			if(!oFile.exists()) {
				try {
					oFile.createNewFile();
				} catch (IOException e) {
					System.err.println("Create file result.txt failed!");
					System.exit(0);
				}
			}
			FileOutputStream oStream=new FileOutputStream(oFile);
			try {
				oStream.write(s.getBytes());
				oStream.close();
			} catch (IOException e) {
				System.err.println("Write result.txt failed!");
				System.exit(0);
			}
			
			//TODO MK
			System.out.println("OK");
			
			
		} catch (FileNotFoundException e) {
			System.err.println("File do not exists!");
			System.exit(0);
		}
	}
}