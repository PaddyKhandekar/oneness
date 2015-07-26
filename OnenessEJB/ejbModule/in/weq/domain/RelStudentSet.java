/**
 * 
 */
package in.weq.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Paddy
 *
 */
@Entity
@Table(name="rel_student_set")
public class RelStudentSet extends DependentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -116755437447279003L;
	
	@OneToOne
	private Student student;
	
	@OneToOne
    private StudentSet studentSet;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentSet getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(StudentSet studentSet) {
        this.studentSet = studentSet;
    }
}