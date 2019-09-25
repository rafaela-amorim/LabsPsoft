package disciplinas.services;

import org.springframework.stereotype.Service;

import disciplinas.DAOs.UsersRepository;
import disciplinas.entities.Users;

@Service
public class UsersService {

	private UsersRepository<Users, String> usersDAO;
	
	public UsersService(UsersRepository<Users, String> usersDAO) {
		super();
		this.usersDAO = usersDAO;
	}
	
//	--------------------------
	
	public Users addUser(Users user) {
		return usersDAO.save(user);
	}
	
	public boolean authenticate(String email, String senha) {
		Users u = usersDAO.findById(email).get();
		return userIsPresent(email) && u.checkPasswd(senha);
	}
	
	public boolean userIsPresent(String email) {
		return usersDAO.findById(email).isPresent();
	}
	
	public Users getUser(String email) {
		return usersDAO.findById(email).get();
	}
	
	public Users removeUser(String email) {
		Users u = getUser(email);
		usersDAO.deleteById(email);
		return u;
	}
	
	public boolean userHasPermission(String emailBody, String subjectEmail) {
		Users u = getUser(subjectEmail);
		
		return userIsPresent(subjectEmail) && u.getEmail().equals(emailBody);
	}

}
