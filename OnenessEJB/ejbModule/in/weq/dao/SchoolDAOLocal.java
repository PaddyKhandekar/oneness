/**
 * 
 */
package in.weq.dao;

import in.weq.domain.School;
import in.weq.exception.DatabaseException;

import java.util.List;

import javax.ejb.Local;

/**
 * @author Paddy
 *
 */
@Local
public interface SchoolDAOLocal {
	
	/**
	 * adds new student to school
	 * @param studentTO null is not allowed
	 * @throws DatabaseException thrown if some error occurs
	 */
	public List<School> getActiveSchoolList() throws DatabaseException;
	
	/**
	 * adds new school
	 * @param school
	 * @throws DatabaseException thrown if some error occurs
	 */
	public School addSchool(School school) throws DatabaseException;
	
	/**
	 * edit school
	 * @param school
	 * @throws DatabaseException thrown if some error occurs
	 */
	public School editSchool(School school) throws DatabaseException;
	
	/**
	 * remove school
	 * @param school
	 * @throws DatabaseException thrown if some error occurs
	 */
	public void removeSchool(Long schoolId) throws DatabaseException;
	
	/**
	 * get school by id
	 * @param schoolId student id
	 * @return {@link School} else null
	 * @throws DatabaseException if some error occurs
	 */
	public School findSchoolById(Long schoolId) throws DatabaseException;
}