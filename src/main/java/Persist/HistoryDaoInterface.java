package Persist;

import java.sql.SQLException;
import java.util.List;

import Exceptions.MailExists;
import Exceptions.UserExists;
import Exceptions.UsernameExists;
import Model.User;
import Model.History;

public interface HistoryDaoInterface {

	    /**
	     * adds a restaurant to user history
	     * @param history to be inserted
	     * @throws SQLException 
	     */
	    void insert(History h) throws SQLException;
	    
	    /***
	     * return all history with given user's mail
	     * @param mail
	     * @return
	     */
	    public List<History> selectAll(String mail);
	    
	    /***
	     * return faved history with given user's mail
	     * @param mail
	     * @return
	     */
	    public List<History> selectWhereFav(String mail);
	    
	}


