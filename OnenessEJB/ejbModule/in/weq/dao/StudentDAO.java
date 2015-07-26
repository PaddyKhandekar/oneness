/**
 * 
 */
package in.weq.dao;

import in.weq.domain.School;
import in.weq.domain.Student;
import in.weq.domain.StudentSet;
import in.weq.exception.DatabaseException;
import in.weq.exception.StaleDataException;

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
public class StudentDAO extends AbstractDAO<Student> implements StudentDAOLocal{

	@PersistenceContext(name="OnenessEJB")
    private EntityManager em;
	
	@EJB
	private SchoolDAOLocal schoolDAOLocal;
	
	@EJB
    private StudentSetDAOLocal studentSetDAOLocal;
	
	@EJB
    private RelStudentSetDAOLocal relStudentSetDAOLocal;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public StudentDAO() {
		super(Student.class);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Student addStudent(Student student, Long schoolId) throws DatabaseException{
		
		School school = schoolDAOLocal.findSchoolById(schoolId);
		if(school == null){
			throw new DatabaseException("No school found");
		}
		
		student.setSchool(school);
		create(student);
		try {
			flush();
		} catch (StaleDataException e) {
			throw new DatabaseException(e.getMessage());
		}
		return student;
	}
	
	@Override
    public Student editStudent(Student student) throws DatabaseException{
        
        edit(student);
        try {
            flush();
        } catch (StaleDataException e) {
            throw new DatabaseException(e.getMessage());
        }
        return student;
    }

	@Override
	public List<Student> getActiveStudentFromSchool(School school) throws DatabaseException {
		List<Student> students = findAll();
		if(students == null){
			return null;
		}
		for (Iterator<Student> iStudent = students.iterator(); iStudent.hasNext();) {
			Student student = iStudent.next();
			if(!school.equals(student.getSchool()) && student.isActive()){
				students.remove(student);
			}
		}
		return students;
	}

	@Override
	public Student findStudentById(Long studentId) throws DatabaseException {
		return find(studentId);
	}

	@Override
	public void removeStudent(Long studentId) throws DatabaseException {
		Student student = find(studentId);
		student.setActive(false);
		student = edit(student);
	}

	@Override
	public List<Student> getStudentFromSetId(Long setId) throws DatabaseException {
	    StudentSet set = studentSetDAOLocal.findStudentSetById(setId);
		return relStudentSetDAOLocal.getStudentFromSet(set);
	}
}