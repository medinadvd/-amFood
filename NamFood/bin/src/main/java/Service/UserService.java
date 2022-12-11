package Service;

import Exceptions.MailExists;
import Model.User;

public interface UserService {
	
	public User findUserByMail(String mail);
	
	public int saveCustomer(User userNew) throws MailExists;
	
}
