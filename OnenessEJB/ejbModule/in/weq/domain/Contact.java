/**
 * 
 */
package in.weq.domain;

import in.weq.oneness.tos.ContactTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Paddy
 *
 */
@Entity
@Table(name="contact")
public class Contact extends DependentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7278974226322458182L;

	@Column(name="data")
	private String data;
	
	@OneToOne
	private ContactType contactType;
	
	@ManyToOne
	@JoinColumn(name="contact_person_id",referencedColumnName="id")
	private ContactPerson contactPerson;
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ContactType getContactType() {
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public ContactPerson getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(ContactPerson contactPerson) {
		this.contactPerson = contactPerson;
	}

	public ContactTO convertToTO(){
		
		ContactTO contactTO = new ContactTO();
		contactTO.setResourceId(getId());
		contactTO.setData(data);
		contactTO.setContactType(contactType.convertToTO());
		return contactTO;
	}
}