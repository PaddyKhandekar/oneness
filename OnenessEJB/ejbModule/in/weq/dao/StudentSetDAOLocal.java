/**
 * 
 */
package in.weq.dao;

import in.weq.domain.School;
import in.weq.domain.Student;
import in.weq.domain.StudentSet;
import in.weq.exception.DatabaseException;

import java.util.List;

import javax.ejb.Local;

/**
 * @author root
 *
 */
@Local
public interface StudentSetDAOLocal {
	
	/**
	 * add student to set if set is not created it will create 
	 * @param studentSetTO reference to set
	 * @param studentTO reference of student
	 * @throws DatabaseException if any error occurs
	 */
	public StudentSet addStudentTOSet(StudentSet studentSet, Student student) throws DatabaseException;
	
	/**
     * add student to set if set is not created it will create 
     * @param studentSetTO reference to set
     * @param studentTO reference of student
     * @throws DatabaseException if any error occurs
     */
    public StudentSet addStudentSet(StudentSet studentSet) throws DatabaseException;
	
	/**
     * add student to set if set is not created it will create 
     * @param studentSetTO reference to set
     * @param studentTO reference of student
     * @throws DatabaseException if any error occurs
     */
    public StudentSet addStudentSetTOSchool(StudentSet studentSetTO, School student) throws DatabaseException;
	
	/**
	 * remove student from set
	 * @param studentSetTO null is not allowed
	 * @param studentTO null is not allowed
	 * @throws DatabaseException if any error occurs
	 */
	public StudentSet removeStudentFromSet(StudentSet studentSet, Student student) throws DatabaseException;
	
	/**
	 * get student set by id
	 * @param studentSetId id of set
	 * @return {@link StudentSetTO} if found else null
	 * @throws DatabaseException if any error occurs
	 */
	public StudentSet findStudentSetById(Long studentSetId) throws DatabaseException;
	
	/**
	 * get student set by school id
	 * @param SchoolId id of school
	 * @return {@link List<StudentSetTO>} if found else null
	 * @throws DatabaseException if any error occurs
	 */
	public List<StudentSet> findStudentSetBySchoolId(Long SchoolId) throws DatabaseException;
}