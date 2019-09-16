package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import dao.UtenteDao;
import model.Utente;

public class UtenteService implements UserDetailsService {
	@Autowired
	private UtenteDao utenteDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utente utente = utenteDao.getByUsername(username);
		if(utente != null) {
			return User.withUsername(utente.getUsername())
						.password(utente.getPassword())
						.roles(utente.getRuolo().getNome()).build();
		} else {
			throw new UsernameNotFoundException("Username not found");
		}
	}

}
