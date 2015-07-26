/**
 * 
 */
package in.weq.service;

import in.weq.exception.BusinessException;
import in.weq.oneness.tos.UserTO;

import javax.ejb.Local;

/**
 * @author root
 *
 */
@Local
public interface UserServiceLocal {
	
	/**
	 * get user from database
	 * @param username 
	 * @param password
	 * @return {@link UserTO} by the username password
	 * @throws BusinessException
	 */
	public UserTO getActiveUser(String username, String password) throws BusinessException;
}