/**
 * 
 */

package in.weq.dao;

import in.weq.domain.ContactType;
import in.weq.exception.DatabaseException;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author root
 *
 */
@Stateless
public class ContactTypeDAO extends AbstractDAO<ContactType> implements ContactTypeDAOLocal {

    @PersistenceContext(name = "OnenessEJB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactTypeDAO() {
        super(ContactType.class);
    }

	@Override
	public List<ContactType> getAllContactType() throws DatabaseException {
		return findAll();
	}

	@Override
	public ContactType getContactTypeById(Long contactTypeId) throws DatabaseException {
		return find(contactTypeId);
	}

	@Override
	public ContactType createContactType(ContactType contactType) throws DatabaseException {
		createInstant(contactType);
		return contactType;
	}
}