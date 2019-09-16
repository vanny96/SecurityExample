package dao;

import org.springframework.stereotype.Repository;

import model.Utente;

@Repository
public class UtenteDao {
	
	public Utente getByUsername(String username) {
		return new Utente();
	}
}
