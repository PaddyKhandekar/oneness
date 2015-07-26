/**
 * 
 */
package in.weq.dao;

import in.weq.domain.School;
import in.weq.domain.Student;
import in.weq.domain.StudentSet;
import in.weq.exception.DatabaseException;

import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author root
 *
 */
@Stateless
public class StudentSetDAO extends AbstractDAO<StudentSet> implements StudentSetDAOLocal{

	@PersistenceContext(name="OnenessEJB")
	private EntityManager em;
	
	@EJB
	private StudentDAOLocal studentDAOLocal;
	
	@EJB
    private RelStudentSetDAOLocal relStudentSetDAOLocal;
	
    private SchoolDAOLocal schoolDAOLocal;
	
	public StudentSetDAO() {
		super(StudentSet.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	@Override
	public StudentSet addStudentTOSet(StudentSet studentSet, Student student) throws DatabaseException {
		return relStudentSetDAOLocal.addStudentToSet(studentSet, student);
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public StudentSet addStudentSet(StudentSet studentSet) throws DatabaseException {
        createInstant(studentSet);
        return studentSet;
    }
	
	@Override
    public StudentSet addStudentSetTOSchool(StudentSet studentSet, School school) throws DatabaseException {
	    
        school.getSets().add(studentSet);
        edit(studentSet);
        schoolDAOLocal.editSchool(school);
        return studentSet;
    }

	@Override
	public StudentSet removeStudentFromSet(StudentSet studentSet, Student student) throws DatabaseException {
		return relStudentSetDAOLocal.removeStudentFromSet(studentSet, student);
	}

	@Override
	public StudentSet findStudentSetById(Long studentSetId) throws DatabaseException {
		
	    StudentSet studentSet = find(studentSetId);
		List<Student> students = relStudentSetDAOLocal.getStudentFromSet(studentSet);
		studentSet.setStudents(students);
		
		return studentSet;
	}

	@Override
	public List<StudentSet> findStudentSetBySchoolId(Long schoolId) throws DatabaseException {
		List<StudentSet> sets = findAll();
		if (sets != null) {
			for (Iterator<StudentSet> iSets = sets.iterator(); iSets.hasNext();) {
				StudentSet set = iSets.next();
				if(set.getSchool().getId() != schoolId){
					sets.remove(set);
				}
			}
		}
		return sets;
	}
}