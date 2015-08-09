/**
 * 
 */
package in.weq.oneness.tos;

import java.util.List;

/**
 * @author Paddy
 *
 */
public class ContactPersonTO extends DependentObjectTO {

	private String title;

	private String firstName;

	private String lastName;

	private String designation;

	private boolean primaryContact;
	
	private List<ContactTO> contacts;
	
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

	public List<ContactTO> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactTO> contacts) {
		this.contacts = contacts;
	}
}