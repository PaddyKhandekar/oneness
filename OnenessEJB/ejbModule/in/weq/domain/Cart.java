/**
 * 
 */
package in.weq.domain;

import in.weq.oneness.tos.CartTO;
import in.weq.oneness.tos.StudentSetTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Paddy
 *
 */
@Entity
@Table(name="cart")
public class Cart extends DependentObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5258476367773964208L;

	@Column(name="totalPrice")
	private double totalPrice;
	
	@OneToMany(mappedBy="cart")
	private List<StudentSet> studentSets;
	
	@ManyToOne
	@JoinColumn(name="donar_id",referencedColumnName="id")
	private Donor donor;

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<StudentSet> getStudentSets() {
		return studentSets;
	}

	public void setStudentSets(List<StudentSet> studentSets) {
		this.studentSets = studentSets;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}
	
	@Override
	public CartTO convertToTO() {
		CartTO cartTO = new CartTO();
		cartTO.setResourceId(getId());
		cartTO.setTotalPrice(totalPrice);
		cartTO.setDonor(donor.convertToTO());
		if (studentSets != null) {
			List<StudentSetTO> studentSetTOs = new ArrayList<StudentSetTO>();
			for (Iterator<StudentSet> iSet = studentSets.iterator(); iSet.hasNext();) {
				StudentSetTO studentSetTO = iSet.next().convertToTO();
				studentSetTOs.add(studentSetTO);
			}
			cartTO.setStudentSets(studentSetTOs);
		}
		return cartTO;
	}
}