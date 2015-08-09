/**
 * 
 */
package in.weq.dao;

import in.weq.domain.User;
import in.weq.exception.DatabaseException;

import javax.ejb.Local;

/**
 * @author Paddy
 *
 */
@Local
public interface UserDAOLocal {
	
    /**
     * get user from database
     * @param username 
     * @param password
     * @return {@link User} by the user name password
     * @throws DatabaseException
     */
    public User getActiveUser(User userTO) throws DatabaseException;
}