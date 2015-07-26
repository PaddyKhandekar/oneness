/**
 * 
 */
package in.weq.dao;

import in.weq.domain.StudentCategory;
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
public class StudentCategoryDAO extends AbstractDAO<StudentCategory> implements StudentCategoryDAOLocal{
	
	@PersistenceContext(name="OnenessEJB")
	private EntityManager em;
	
	public StudentCategoryDAO() {
		super(StudentCategory.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	@Override
	public List<StudentCategory> getAllCategories() throws DatabaseException {
	    return findAll();
	}
	
	@Override
	public StudentCategory addCategory(StudentCategory category) throws DatabaseException {
	    category = edit(category);
	    return category;
	}

    @Override
    public StudentCategory getCategory(Long categoryId) throws DatabaseException {
        return find(categoryId);
    }
}