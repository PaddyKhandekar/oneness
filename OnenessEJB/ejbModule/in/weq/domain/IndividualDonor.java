/**
 * 
 */
package in.weq.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Paddy
 *
 */
@Entity
@Table(name="individual_donor")
public class IndividualDonor extends Donor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7875937882374203347L;

	@Column(name="occupation")
	private String occupation;

	@Column(name="nationality")
	private String nationality;

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}