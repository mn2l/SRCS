package srcs.banque;

import java.io.*;
import srcs.persistance.Sauvegardable;

public class Compte implements Sauvegardable {
	
	private final String id;
	private double solde;
	

	public Compte(String id) {
		this.id=id;	
		this.solde=0.0;
	}
	
	public Compte(InputStream in) throws IOException{
		DataInputStream din = new DataInputStream(in);
		this.id = din.readUTF();
		this.solde = din.readDouble();
		din.close();
	}
		
	public String getId() {
		return id;
	}

	public double getSolde() {
		return solde;
	}

	public void crediter(double montant) {
		solde += montant;
	}

	public void debiter(double montant) {
		solde -= montant;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==this) return true;
		if(o==null) return false;
		if(!(o instanceof Compte)) return false;
		Compte other= (Compte) o;
		return other.id.equals(id);
	}
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	public void save(OutputStream out) throws IOException {
		DataOutputStream dout = new DataOutputStream(out);
		dout.writeUTF(id);
		dout.writeDouble(solde);
		dout.close();
	}
	
}
