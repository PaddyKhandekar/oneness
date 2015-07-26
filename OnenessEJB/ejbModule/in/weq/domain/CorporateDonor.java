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
@Table(name="corporate_donor")
public class CorporateDonor extends Donor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7787888086418320209L;
	
	@Column(name="companyName")
	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}