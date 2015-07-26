/**
 * 
 */
package in.weq.dao;

import in.weq.domain.School;
import in.weq.domain.Student;
import in.weq.exception.DatabaseException;

import java.util.List;

import javax.ejb.Local;

/**
 * @author Paddy
 *
 */
@Local
public interface StudentDAOLocal {

	/**
	 * get active schools from school
	 * 
	 * @param school
	 *            get student from schools
	 * @return {@link Student} if found else null
	 * @throws DatabaseException
	 *             if anything fails DatabaseException
	 */
	public List<Student> getActiveStudentFromSchool(School school)throws DatabaseException;

	/**
	 * adds new school
	 * 
	 * @param student
	 *            null is not allowed
	 * @throws DatabaseException
	 *             thrown if some error occurs
	 */
	public Student addStudent(Student student, Long schoolId)throws DatabaseException;
	
	
	/**
     * adds new school
     * 
     * @param student null is not allowed
     * @throws DatabaseException thrown if some error occurs
     */
    public Student editStudent(Student student)throws DatabaseException;

	/**
	 * remove school
	 * 
	 * @param student
	 *            null is not allowed
	 * @throws DatabaseException
	 *             thrown if some error occurs
	 */
	public void removeStudent(Long studentId) throws DatabaseException;

	/**
	 * get student by id
	 * 
	 * @param studentId
	 *            student id
	 * @return {@link Student} else null
	 * @throws DatabaseException
	 *             if some error occurs
	 */
	public Student findStudentById(Long studentId) throws DatabaseException;

	/**
	 * get students from list
	 * 
	 * @param setId
	 *            set id
	 * @return {@link List<Student>} if found else null
	 * @throws DatabaseException
	 *             if anything fails DatabaseException
	 */
	public List<Student> getStudentFromSetId(Long setId)throws DatabaseException;
}