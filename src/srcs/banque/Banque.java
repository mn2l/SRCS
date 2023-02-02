package srcs.banque;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

import srcs.persistance.Sauvegardable;

public class Banque implements Sauvegardable{

	private final Set<Client> clients;
	
	public Banque() {
		clients=new HashSet<>();
	}
		
	public int nbClients() {
		return clients.size();
	}
	
	public int nbComptes() {
		Set<Compte> comptes = new HashSet<>();
		for(Client c : clients) {
			comptes.add(c.getCompte());
		}
		return comptes.size();
	}
	
	public Client getClient(String nom) {
		for(Client c : clients) {
			if(c.getNom().equals(nom)) return c;
		}
		return null;
	}
	
	public boolean addNewClient(Client c) {
		return clients.add(c);
	}

	@Override
	public void save(OutputStream out) throws IOException {
		for(Client c : clients) {
			c.save(out);
		}
	}
	

}
