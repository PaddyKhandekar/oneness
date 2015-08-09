/**
 * 
 */
package in.weq.domain;

import in.weq.oneness.tos.ContactTypeTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Paddy
 *
 */
@Entity
@Table(name="contact_type")
public class ContactType extends DependentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7278974226322458182L;

	@Column(name="type")
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public ContactTypeTO convertToTO() {
		
		ContactTypeTO contactTypeTO = new ContactTypeTO();
		contactTypeTO.setResourceId(getId());
		contactTypeTO.setType(type);
		return contactTypeTO;
	}
}