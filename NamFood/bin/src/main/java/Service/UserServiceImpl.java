package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Exceptions.MailExists;
import Model.User;
import Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository uR;
	
	@Override
	public User findUserByMail(String mail) {
		return uR.findByCorreo(mail);
	}

	@Override
	public int saveCustomer(User userNew) throws MailExists {
		User u = uR.findByCorreo(userNew.getMail());
		if (u==null) {
           uR.save(userNew);
        }else {
        	 throw new MailExists("There is already a user with mail");
        }
		return 0;
	}

}
