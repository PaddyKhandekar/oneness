/**
 * 
 */

package in.weq.dao;

import in.weq.domain.RelStudentSet;
import in.weq.domain.Student;
import in.weq.domain.StudentSet;
import in.weq.exception.DatabaseException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author root
 *
 */
@Stateless
public class RelStudentSetDAO extends AbstractDAO<RelStudentSet> implements RelStudentSetDAOLocal {

    @PersistenceContext(name = "OnenessEJB")
    private EntityManager em;

    @EJB
    private StudentDAOLocal studentDAOLocal;

    @EJB
    private StudentSetDAOLocal studentSetDAOLocal;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RelStudentSetDAO() {
        super(RelStudentSet.class);
    }

    @Override
    public List<Student> getStudentFromSet(StudentSet set) throws DatabaseException {
        List<RelStudentSet> relStudentSets = findAll();
        List<Student> students = new ArrayList<Student>();

        for (Iterator<RelStudentSet> iterator = relStudentSets.iterator(); iterator.hasNext();) {
            RelStudentSet relStudentSet = (RelStudentSet) iterator.next();
            if (relStudentSet.getStudentSet().getId() == set.getId()) {
                Student student = studentDAOLocal.findStudentById(relStudentSet.getStudent().getId());
                students.add(student);
            }
        }
        return students;
    }

    @Override
    public StudentSet getSetFromStudent(Student student) throws DatabaseException {
        List<RelStudentSet> relStudentSets = findAll();

        for (Iterator<RelStudentSet> iterator = relStudentSets.iterator(); iterator.hasNext();) {
            RelStudentSet relStudentSet = (RelStudentSet) iterator.next();
            if (relStudentSet.getStudent().getId() == student.getId()) {
                return studentSetDAOLocal.findStudentSetById(relStudentSet.getStudentSet().getId());
            }
        }
        return null;
    }

    @Override
    public StudentSet addStudentToSet(StudentSet studentSet, Student student) throws DatabaseException {
        RelStudentSet relStudentSet = new RelStudentSet();
        relStudentSet.setStudent(student);
        relStudentSet.setStudentSet(studentSet);
        
        createInstant(relStudentSet);
        List<Student> students = studentSet.getStudents();
        if(students == null){
            students = new ArrayList<Student>();
            studentSet.setStudents(students);
        }
        
        return studentSet;
    }

    @Override
    public StudentSet removeStudentFromSet(StudentSet studentSet, Student student) throws DatabaseException {
        
        List<RelStudentSet> relStudentSets = findAll();
        
        for (Iterator<RelStudentSet> iterator = relStudentSets.iterator(); iterator.hasNext();) {
            RelStudentSet relStudentSet = (RelStudentSet) iterator.next();
            if (relStudentSet.getStudentSet().getId() == studentSet.getId()
                    && relStudentSet.getStudent().getId() == student.getId()) {
                remove(relStudentSet);
                
                studentSet.getStudents().remove(student);
            }
        }
        
        return studentSet;
    }
}
