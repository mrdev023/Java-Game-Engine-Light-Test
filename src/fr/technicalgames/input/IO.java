package fr.technicalgames.input;
import java.io.*;

public class IO {

	public static String loadFile(String path) throws Exception{
		String r = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		String buffer = "";
		while ((buffer = reader.readLine()) != null) {
				r += buffer + "\n";
		}
		reader.close();
		return r;
	}
	
}
