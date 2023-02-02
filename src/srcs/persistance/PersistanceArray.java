package srcs.persistance;

import java.io.*;

public class PersistanceArray {
	
	public static void saveArrayInt(String f, int[] tab) throws IOException{
		DataOutputStream out = new DataOutputStream(new FileOutputStream(f));
		out.writeInt(tab.length);
		for(int i=0; i<tab.length; i++) {
			out.writeInt(tab[i]);
		}
		out.close();
	}
	
	public static int[] loadArrayInt(String fichier) throws IOException {
		DataInputStream in = new DataInputStream(new FileInputStream(fichier));
		int size = in.readInt();
		if(size <= 0) {
			in.close();
			return null;
		}
		int[] tab = new int[size];
		for(int i = 0; i < size; i++) {
			tab[i] = in.readInt();
		}
		
		in.close();
		
		return tab;
	}
	
}
