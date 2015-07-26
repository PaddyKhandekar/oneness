/**
 * 
 */
package in.weq.dao;

import in.weq.domain.School;
import in.weq.exception.DatabaseException;
import in.weq.exception.StaleDataException;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author root
 *
 */
@Stateless
public class SchoolDAO extends AbstractDAO<School> implements SchoolDAOLocal{
	
    @SuppressWarnings("unused")
    private static final String TAG = SchoolDAO.class.getSimpleName();
    
	@PersistenceContext(name="OnenessEJB")
	private EntityManager em;
	
	public SchoolDAO() {
		super(School.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public List<School> getActiveSchoolList() throws DatabaseException {
		List<School> schools = findAll();
		if (schools != null) {
			for (Iterator<School> iSchool = schools.iterator(); iSchool.hasNext();) {
				School school = iSchool.next();
				if(!school.isActive()){
					schools.remove(school);
				}
			}
		}
		return schools;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public School addSchool(School school) throws DatabaseException {
		create(school);
		try {
			flush();
		} catch (StaleDataException e) {
			throw new DatabaseException(e.getMessage());
		}
		return school;
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public School editSchool(School school) throws DatabaseException {
		school = edit(school);
		return school;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public School findSchoolById(Long schoolId) throws DatabaseException {
		return find(schoolId);
	}
	
	@Override
	public void removeSchool(Long schoolId) throws DatabaseException {
		School school = find(schoolId);
		school.setActive(false);
		edit(school);
	}
}