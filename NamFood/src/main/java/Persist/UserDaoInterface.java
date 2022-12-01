package Persist;

import Exceptions.UsernameExists;
import Exceptions.MailExists;
import Exceptions.UserExists;

import java.sql.SQLException;
import Model.User;


public interface UserDaoInterface {
   

    /**
     * adds a new user to the data base
     * @param entity to be inserted
     * @throws exceptions.MailExists
     * @throws exceptions.UsernameExists
     * @throws UserExists 
     * @throws SQLException 
     */
    int insert(User entity) throws UsernameExists, MailExists, UserExists, SQLException;

    /**
     * updates the given user from the data base
     * @param user to be removed
     * @return number of entries affected by the operation
     * @throws exceptions.MailExists
     * @throws exceptions.UsernameExists
     * @throws UserExists 
     * @throws SQLException 
     */
    //int update(User oldEntity, User newEntity) throws MailExists, UsernameExists, UserExists, SQLException;
    
    /**
     * finds user with the given parameter and query
     * @param mail or username, and query
     * @return user with the given parameter
     * @throws SQLException 
     */
	public User selectWhere(String code, String q) throws SQLException;
    
}

