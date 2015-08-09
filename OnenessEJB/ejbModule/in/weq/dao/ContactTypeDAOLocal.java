/**
 * 
 */
package in.weq.dao;

import in.weq.domain.ContactType;
import in.weq.exception.DatabaseException;

import java.util.List;

import javax.ejb.Local;

/**
 * @author Paddy
 *
 */
@Local
public interface ContactTypeDAOLocal {
	
    /**
	 * get all contact type
	 * @return {@link List} find all contact type if found else null
	 * @throws DatabaseException if something goes wrong
	 */
	public List<ContactType> getAllContactType() throws DatabaseException;
	
	/**
	 * get contact type by id
	 * @param contactTypeId contact id
	 * @return {@link ContactType} if found else null
	 * @throws DatabaseException if something goes wrong
	 */
	public ContactType getContactTypeById(Long contactTypeId) throws DatabaseException;
	
	/**
	 * create contact type
	 * @param contactType {@link ContactType}
	 * @return if created else null
	 * @throws DatabaseException if something goes wrong
	 */
	public ContactType createContactType(ContactType contactTypeTO) throws DatabaseException;
}