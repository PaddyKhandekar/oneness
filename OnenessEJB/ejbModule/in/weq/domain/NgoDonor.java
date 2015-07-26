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
@Table(name="ngo_donor")
public class NgoDonor extends Donor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3335543205399240288L;
	
	@Column(name="NameOfNGO")
	private String NameOfNGO;

	public String getNameOfNGO() {
		return NameOfNGO;
	}

	public void setNameOfNGO(String nameOfNGO) {
		NameOfNGO = nameOfNGO;
	}
}