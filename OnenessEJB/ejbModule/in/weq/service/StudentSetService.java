/**
 * 
 */
package in.weq.service;

import in.weq.dao.SchoolDAOLocal;
import in.weq.dao.StudentDAOLocal;
import in.weq.dao.StudentSetDAOLocal;
import in.weq.domain.School;
import in.weq.domain.Student;
import in.weq.domain.StudentSet;
import in.weq.exception.BusinessException;
import in.weq.exception.DatabaseException;
import in.weq.oneness.tos.SchoolTO;
import in.weq.oneness.tos.StudentSetTO;
import in.weq.oneness.tos.StudentTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * @author root
 *
 */
@Stateless
@EJB(beanInterface = StudentSetServiceLocal.class, name = "StudentSetService")
public class StudentSetService implements StudentSetServiceLocal {
	
	@EJB
	private StudentSetDAOLocal studentSetDAOLocal;
	
	@EJB
	private StudentDAOLocal studentDAOLocal;
	
	@EJB
    private SchoolDAOLocal schoolDAOLocal;
	
	@EJB
	private StudentServiceLocal studentServiceLocal;
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public StudentSetTO addStudentTOSet(StudentSetTO studentSetTO, StudentTO studentTO) throws BusinessException {
		
		if(studentTO.getResourceId() == 0){
			studentTO = studentServiceLocal.addStudent(studentTO, studentTO.getSchool());
		}
		
		Student student = null;
		try {
			student = studentDAOLocal.findStudentById(studentTO.getResourceId());
		} catch (DatabaseException e) {
			throw new BusinessException(e.getMessage());
		}
		
		StudentSet studentSet = null;
		if(studentSetTO.getResourceId() == 0){
		    studentSet = new StudentSet();
		    studentSet.setPrice(studentSetTO.getPrice());
		    
		    School school = null;
            try {
                school = schoolDAOLocal.findSchoolById(studentSet.getSchool().getId());
            }
            catch (DatabaseException e) {
                throw new BusinessException(e.getMessage());
            }
            
		    studentSet.setSchool(school);
		    
            try {
                studentSet = studentSetDAOLocal.addStudentSet(studentSet);
            }
            catch (DatabaseException e) {
                throw new BusinessException(e.getMessage());
            }
        }
		
		try {
		    studentSet = studentSetDAOLocal.addStudentTOSet(studentSet, student);
		} catch (DatabaseException e) {
			throw new BusinessException(e.getMessage());
		}
		return studentSet.convertToTO();
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public StudentSetTO addStudentSetTOSchool(StudentSetTO studentSetTO, SchoolTO schoolTO) throws BusinessException {
	    
        
        School school = null;
        if(schoolTO.getResourceId() != 0){
            try {
                school = schoolDAOLocal.findSchoolById(schoolTO.getResourceId());
            } catch (DatabaseException e) {
                throw new BusinessException(e.getMessage());
            }
        } else{
            throw new BusinessException("Incorrect Data");
        }
        
        StudentSet studentSet = new StudentSet();
        studentSet.setPrice(studentSetTO.getPrice());
        studentSet.setSchool(school);
        
        try {
            studentSet = studentSetDAOLocal.addStudentSet(studentSet);
            schoolDAOLocal.editSchool(school);
        }
        catch (DatabaseException e) {
            e.printStackTrace();
        }
        
        return studentSet.convertToTO();
    }
	
	@Override
	public void removeStudentFromSet(StudentSetTO studentSetTO, StudentTO studentTO) throws BusinessException {
		
		Student student = null;
		try {
			student = studentDAOLocal.findStudentById(studentTO.getResourceId());
		} catch (DatabaseException e) {
			throw new BusinessException(e.getMessage());
		}
		
		StudentSet studentSet = new StudentSet();
		studentSet.setId(studentSetTO.getResourceId());
		
		try {
			studentSetDAOLocal.removeStudentFromSet(studentSet, student);
		} catch (DatabaseException e) {
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public StudentSetTO findStudentSetById(Long studentSetId) throws BusinessException {
		try {
			return studentSetDAOLocal.findStudentSetById(studentSetId).convertToTO();
		} catch (DatabaseException e) {
			throw new BusinessException(e.getMessage());
		}
	}
}