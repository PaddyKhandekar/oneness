/**
 * 
 */
package in.weq.service;

import in.weq.exception.BusinessException;
import in.weq.oneness.tos.SchoolTO;
import in.weq.oneness.tos.StudentSetTO;
import in.weq.oneness.tos.StudentTO;

import javax.ejb.Local;

/**
 * @author root
 *
 */
@Local
public interface StudentSetServiceLocal {
	
	/**
	 * add student to set if set is not created it will create 
	 * @param studentSetTO reference to set
	 * @param schoolTO reference of student
	 * @throws BusinessException if any error occurs
	 */
	public StudentSetTO addStudentTOSet(StudentSetTO studentSetTO, StudentTO studentTO) throws BusinessException;
	
	/**
     * add student set to school if set is not created it will create 
     * @param studentSetTO reference to set
     * @param schoolTO reference of student
     * @throws BusinessException if any error occurs
     */
    public StudentSetTO addStudentSetTOSchool(StudentSetTO studentSetTO, SchoolTO schoolTO) throws BusinessException;
	
	/**
	 * remove student from set
	 * @param studentSetTO null is not allowed
	 * @param schoolTO null is not allowed
	 * @throws BusinessException if any error occurs
	 */
	public void removeStudentFromSet(StudentSetTO studentSetTO, StudentTO studentTO) throws BusinessException;
	
	/**
	 * get student set by id
	 * @param studentSetId id of set
	 * @return {@link StudentSetTO} if found else null
	 * @throws BusinessException if any error occurs
	 */
	public StudentSetTO findStudentSetById(Long studentSetId) throws BusinessException;
}