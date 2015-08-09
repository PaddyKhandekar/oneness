/**
 * 
 */
package in.weq.service;

import java.util.List;

import in.weq.exception.BusinessException;
import in.weq.oneness.tos.ContactTypeTO;
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
	 * @return {@link UserTO} by the user name password
	 * @throws BusinessException
	 */
	public UserTO getActiveUser(String username, String password) throws BusinessException;
	
	/**
	 * get all contact type
	 * @return {@link List} find all contact type if found else null
	 * @throws BusinessException if something goes wrong
	 */
	public List<ContactTypeTO> getAllContactType() throws BusinessException;
	
	/**
	 * get contact type by id
	 * @param contactTypeId contact id
	 * @return {@link ContactTypeTO} if found else null
	 * @throws BusinessException if something goes wrong
	 */
	public ContactTypeTO getContactTypeById(Long contactTypeId) throws BusinessException;
	
	/**
	 * create contact type
	 * @param contactTypeTO {@link ContactTypeTO}
	 * @return if created else null
	 * @throws BusinessException if something goes wrong
	 */
	public ContactTypeTO createContactType(ContactTypeTO contactTypeTO) throws BusinessException;
}