/**
 * 
 */
package in.weq.domain;

import in.weq.oneness.tos.StudentSetTO;
import in.weq.oneness.tos.StudentTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Paddy
 *
 */
@Entity
@Table(name="student_set")
public class StudentSet extends DependentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -116755437447279003L;

	@Column(name="price")
	private double price;
	
	@Column(name="status")
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name="cart_id",referencedColumnName="id")
	private Cart cart;
	
	private List<Student> students;
	
	@ManyToOne
	@JoinColumn(name="school_id",referencedColumnName="id")
	private School school;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public StudentSetTO convertToTO() {
		StudentSetTO setTO = new StudentSetTO();
		setTO.setPrice(price);
		setTO.setResourceId(getId());
		setTO.setStatus(status);
		
		if(students != null){
			List<StudentTO> studentsTos = new ArrayList<StudentTO>();
			for (Iterator<Student> iStudent = students.iterator(); iStudent.hasNext();) {
				StudentTO studentTO = iStudent.next().convertToTO();
				studentsTos.add(studentTO);
			}
			setTO.setStudents(studentsTos);
		}
		return setTO;
	}
}