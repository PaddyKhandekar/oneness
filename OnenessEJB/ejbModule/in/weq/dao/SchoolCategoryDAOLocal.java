/**
 * 
 */
package in.weq.dao;

import java.util.List;

import in.weq.domain.SchoolCategory;
import in.weq.exception.DatabaseException;

import javax.ejb.Local;

/**
 * @author Paddy
 *
 */
@Local
public interface SchoolCategoryDAOLocal {
    
    /**
     * get all categories
     * @return {@link List} if found else null
     * @throws DatabaseException if some error occurs
     */
    public List<SchoolCategory> getAllCategories() throws DatabaseException;
    
    /**
     * get category by Id
     * @param categoryId category id
     * @return category if found else null
     * @throws DatabaseException if any thing happen
     */
    public SchoolCategory getCategories(Long categoryId) throws DatabaseException;
    
    /**
     * add categories
     * @return {@link SchoolCategory}
     * @throws DatabaseException if any occurs
     */
    public SchoolCategory addCategory(SchoolCategory category) throws DatabaseException;
}