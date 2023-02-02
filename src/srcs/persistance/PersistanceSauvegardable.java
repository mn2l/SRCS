package srcs.persistance;

import java.io.*;

import srcs.banque.Compte;

public class PersistanceSauvegardable {

	public static void save(String fichier, Sauvegardable s) throws IOException {
		OutputStream out = new FileOutputStream(fichier);
		s.save(out);
		out.close();
	}
	
	public static Sauvegardable load(String fichier) throws IOException {
		InputStream in = new FileInputStream(fichier);
		Sauvegardable c = new Compte(in);
		in.close();
		return c;
	}
}
