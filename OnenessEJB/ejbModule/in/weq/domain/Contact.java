/**
 * 
 */
package in.weq.domain;

import in.weq.oneness.tos.ContactTO;

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
@Table(name="contact")
public class Contact extends DependentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7278974226322458182L;

	@Column(name="title")
	private String title;

	@Column(name="firstName")
	private String firstName;

	@Column(name="lastName")
	private String lastName;

	@Column(name="designation")
	private String designation;

	@Column(name="contactType")
	private String contactType;

	@Column(name="contactData")
	private String contactData;

	@Column(name="status")
	private String status;

	@Column(name="primaryContact")
	private boolean primaryContact;
	
	@ManyToOne
	@JoinColumn(name="user_entity_id",referencedColumnName="id")
	private UserEntity userEntity;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContactData() {
		return contactData;
	}

	public void setContactData(String contactData) {
		this.contactData = contactData;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(boolean primaryContact) {
		this.primaryContact = primaryContact;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	public ContactTO convertToTO(){
		ContactTO contactTO = new ContactTO();
		
		contactTO.setResourceId(getId());
		contactTO.setContactData(contactData);
		contactTO.setContactType(contactType);
		contactTO.setDesignation(designation);
		contactTO.setFirstName(firstName);
		contactTO.setLastName(lastName);
		contactTO.setPrimaryContact(primaryContact);
		contactTO.setResourceId(getId());
		contactTO.setStatus(status);
		contactTO.setTitle(title);
		
		return contactTO;
	}
}