/**
 * 
 */
package in.weq.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.weq.oneness.tos.ContactPersonTO;
import in.weq.oneness.tos.ContactTO;

import javax.persistence.CascadeType;
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
@Table(name="contact_person")
public class ContactPerson extends DependentObject {

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

	@Column(name="primaryContact")
	private boolean primaryContact;
	
	@OneToMany(mappedBy = "contactPerson",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contact> contacts;
	
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
	
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public ContactPersonTO convertToTO(){

		ContactPersonTO contactPersonTO = new ContactPersonTO();
		contactPersonTO.setTitle(title);
		contactPersonTO.setFirstName(firstName);
		contactPersonTO.setLastName(lastName);
		contactPersonTO.setDesignation(designation);
		contactPersonTO.setPrimaryContact(primaryContact);
		
		if(contacts != null){
			List<ContactTO> contactTOs = new ArrayList<ContactTO>();
			for (Iterator<Contact> contactIterator = contacts.iterator(); contactIterator.hasNext();) {
				contactTOs.add(contactIterator.next().convertToTO());
			}
			contactPersonTO.setContacts(contactTOs);
		}
		return contactPersonTO;
	}
}