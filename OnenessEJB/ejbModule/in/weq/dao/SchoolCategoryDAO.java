/**
 * 
 */
package in.weq.dao;

import java.util.List;

import in.weq.domain.SchoolCategory;
import in.weq.exception.DatabaseException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author root
 *
 */
@Stateless
public class SchoolCategoryDAO extends AbstractDAO<SchoolCategory> implements SchoolCategoryDAOLocal{
	
	@PersistenceContext(name="OnenessEJB")
	private EntityManager em;
	
	public SchoolCategoryDAO() {
		super(SchoolCategory.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	@Override
	public List<SchoolCategory> getAllCategories() throws DatabaseException {
	    return findAll();
	}
	
	@Override
	public SchoolCategory addCategory(SchoolCategory category) throws DatabaseException {
	    category = edit(category);
	    return category;
	}

    @Override
    public SchoolCategory getCategories(Long categoryId) throws DatabaseException {
        return find(categoryId);
    }
}