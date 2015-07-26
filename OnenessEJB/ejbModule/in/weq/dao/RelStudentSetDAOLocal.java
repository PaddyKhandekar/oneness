/**
 * 
 */
package in.weq.dao;

import in.weq.domain.Student;
import in.weq.domain.StudentSet;
import in.weq.exception.DatabaseException;

import java.util.List;

import javax.ejb.Local;

/**
 * @author Paddy
 *
 */
@Local
public interface RelStudentSetDAOLocal {

	/**
	 * get student of the set
	 * @param set from  school
	 * @return {@link List} if student found else null
	 * @throws DatabaseException if some wrong happen
	 */
	public List<Student> getStudentFromSet(StudentSet set)throws DatabaseException;
	
	/**
	 * get student set from student
	 * @param student from school
	 * @return {@link StudentSet} if found else null
	 * @throws DatabaseException if some wrong happen
	 */
    public StudentSet getSetFromStudent(Student student)throws DatabaseException;
    
    
    /**
     * 
     * @param studentSet
     * @param student
     * @return
     * @throws DatabaseException
     */
    public StudentSet addStudentToSet(StudentSet studentSet, Student student)throws DatabaseException;
    
    /**
     * 
     * @param studentSet
     * @param student
     * @return
     * @throws DatabaseException
     */
    public StudentSet removeStudentFromSet(StudentSet studentSet, Student student)throws DatabaseException;
}