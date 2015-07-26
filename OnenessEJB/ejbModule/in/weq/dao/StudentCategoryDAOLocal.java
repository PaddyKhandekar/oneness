/**
 * 
 */
package in.weq.dao;

import in.weq.domain.SchoolCategory;
import in.weq.domain.StudentCategory;
import in.weq.exception.DatabaseException;

import java.util.List;

import javax.ejb.Local;

/**
 * @author Paddy
 *
 */
@Local
public interface StudentCategoryDAOLocal {
    
    /**
     * get all categories
     * @return {@link List} if found else null
     * @throws DatabaseException if some error occurs
     */
    public List<StudentCategory> getAllCategories() throws DatabaseException;
    
    /**
     * get category by Id
     * @param categoryId category id
     * @return category if found else null
     * @throws DatabaseException if any thing happen
     */
    public StudentCategory getCategory(Long categoryId) throws DatabaseException;
    
    /**
     * add categories
     * @return {@link SchoolCategory}
     * @throws DatabaseException if any occurs
     */
    public StudentCategory addCategory(StudentCategory category) throws DatabaseException;
}