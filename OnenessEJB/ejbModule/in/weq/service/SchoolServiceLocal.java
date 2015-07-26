/**
 * 
 */
package in.weq.service;

import in.weq.exception.BusinessException;
import in.weq.oneness.tos.SchoolCategoryTO;
import in.weq.oneness.tos.SchoolTO;
import in.weq.oneness.tos.StudentTO;

import java.util.List;

import javax.ejb.Local;

/**
 * @author root
 *
 */
@Local
public interface SchoolServiceLocal {
	
	/**
	 * get all active school in system
	 * @return {@link List} schools else null
	 * @throws BusinessException if some error at database occurs 
	 */
	public List<SchoolTO> getActiveSchoolList() throws BusinessException;
	
	/**
	 * adds new school
	 * @param schoolTO null is not allowed
	 * @throws BusinessException thrown if some error occurs
	 */
	public SchoolTO addSchool(SchoolTO schoolTO) throws BusinessException;
	
	/**
	 * edit school
	 * @param schoolTO null is not allowed
	 * @throws BusinessException thrown if some error occurs
	 */
	public SchoolTO editSchool(SchoolTO schoolTO) throws BusinessException;
	
	/**
	 * edit school
	 * @param schoolTO null is not allowed
	 * @throws BusinessException thrown if some error occurs
	 */
	public void removeSchool(SchoolTO schoolTO) throws BusinessException;
	
	/**
	 * adds new student to school
	 * @param studentTO null is not allowed
	 * @throws BusinessException thrown if some error occurs
	 */
	public void addStudent(StudentTO studentTO, SchoolTO schoolTO) throws BusinessException;
	
	/**
	 * finds school by id
	 * @param schoolId
	 * @return
	 * @throws BusinessException
	 */
    public SchoolTO findSchoolById(Long schoolId) throws BusinessException;
    
    /**
     * get all school categories
     * @return {@link List} list if found else null
     * @throws BusinessException if any error occurs
     */
    public List<SchoolCategoryTO> getSchoolCategoryList() throws BusinessException;
    
    /**
     * add category
     * @param schoolCategoryTO
     * @return if found else null
     * @throws BusinessException if any error occurs
     */
    public SchoolCategoryTO addSchoolCategory(SchoolCategoryTO schoolCategoryTO) throws BusinessException;
    
    /**
     * Edit category
     * @param schoolCategoryTO
     * @return if found else null
     * @throws BusinessException if any error occurs
     */
    public SchoolCategoryTO editSchoolCategory(SchoolCategoryTO schoolCategoryTO) throws BusinessException;
}