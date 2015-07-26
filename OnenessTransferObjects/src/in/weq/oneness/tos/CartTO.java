/**
 * 
 */
package in.weq.oneness.tos;

import java.util.List;

/**
 * @author Paddy
 *
 */
public class CartTO extends DependentObjectTO {
	
	private double totalPrice;
	
	private List<StudentSetTO> studentSets;
	
	private DonorTO donor;

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<StudentSetTO> getStudentSets() {
		return studentSets;
	}

	public void setStudentSets(List<StudentSetTO> studentSets) {
		this.studentSets = studentSets;
	}

	public DonorTO getDonor() {
		return donor;
	}

	public void setDonor(DonorTO donor) {
		this.donor = donor;
	}
}