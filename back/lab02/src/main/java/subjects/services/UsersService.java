package subjects.services;

import org.springframework.stereotype.Service;

import subjects.DAOs.UsersRepository;
import subjects.entities.Users;

@Service
public class UsersService {
	
	private UsersRepository<Users, String> usersDAO;

	public UsersService(UsersRepository<Users, String> usersDAO) {
		super();
		this.usersDAO = usersDAO;
	}
	
	public Users getUser(String email) {
		return usersDAO.findById(email).get();
	}
	
	public boolean authenticateUser(String email, String senha) {
		return userExists(email) && usersDAO.findById(email).get().verifyPasswd(senha);		
	}

	// public User??? deleteUser() 
	
	public boolean userExists(String email) {
		return usersDAO.findById(email).isPresent();
	}
	
}
















