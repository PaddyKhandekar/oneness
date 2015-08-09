/**
 * 
 */
package in.weq.oneness.tos;

import java.util.List;

/**
 * @author Paddy
 *
 */
public class StudentSetTO extends DependentObjectTO {

	private double price;
	
	private boolean status;
	
	private CartTO cart;
	
	private List<StudentTO> students;
	
	private int studentSize;

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

	public CartTO getCart() {
		return cart;
	}

	public void setCart(CartTO cart) {
		this.cart = cart;
	}

	public List<StudentTO> getStudents() {
		return students;
	}

	public void setStudents(List<StudentTO> students) {
		this.students = students;
	}

	public int getStudentSize() {
		return studentSize;
	}

	public void setStudentSize(int studentSize) {
		this.studentSize = studentSize;
	}
}