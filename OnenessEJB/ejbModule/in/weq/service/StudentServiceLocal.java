/**
 * 
 */
package in.weq.service;

import in.weq.exception.BusinessException;
import in.weq.oneness.tos.SchoolTO;
import in.weq.oneness.tos.StudentCategoryTO;
import in.weq.oneness.tos.StudentTO;

import java.util.List;

import javax.ejb.Local;

/**
 * @author root
 *
 */
@Local
public interface StudentServiceLocal {
	
	/**
	 * get list of students from school
	 * @param schoolTO object with id
	 * @return {@link List} {@link StudentTO} if result else null
	 * @throws BusinessException if any error occurs
	 */
	public List<StudentTO> getActiveStudentListFromSchool(SchoolTO schoolTO) throws BusinessException;
	
	/**
	 * adds new student to school
	 * @param studentTO it will be added, null is not allowed
	 * @param schoolTO in this school, null is not allowed
	 * @throws BusinessException if any error occurs
	 */
	public StudentTO addStudent(StudentTO studentTO, SchoolTO schoolTO) throws BusinessException;
	
	/**
     * adds new student to school
     * @param studentTO it will be added, null is not allowed
     * @param schoolTO in this school, null is not allowed
     * @throws BusinessException if any error occurs
     */
    public StudentTO editStudent(StudentTO studentTO) throws BusinessException;
    
    /**
     * get all school categories
     * @return {@link List} list if found else null
     * @throws BusinessException if any error occurs
     */
    public List<StudentCategoryTO> getSchoolCategoryList() throws BusinessException;
    
    /**
     * add category
     * @param schoolCategoryTO
     * @return if found else null
     * @throws BusinessException if any error occurs
     */
    public StudentCategoryTO addSchoolCategory(StudentCategoryTO schoolCategoryTO) throws BusinessException;
    
    /**
     * Edit category
     * @param schoolCategoryTO
     * @return if found else null
     * @throws BusinessException if any error occurs
     */
    public StudentCategoryTO editStudentCategory(StudentCategoryTO schoolCategoryTO) throws BusinessException;
}