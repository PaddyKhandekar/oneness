/**
 * 
 */
package in.weq.oneness.tos;


/**
 * @author Paddy
 *
 */
public class ContactTO extends DependentObjectTO {

	private String title;

	private String firstName;

	private String lastName;

	private String designation;

	private String contactType;

	private String contactData;

	private String status;

	private Boolean primaryContact;
	
	private UserEntityTO userEntity;

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

	public Boolean getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(Boolean primaryContact) {
		this.primaryContact = primaryContact;
	}

	public UserEntityTO getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntityTO userEntity) {
		this.userEntity = userEntity;
	}
}