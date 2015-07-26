/**
 * 
 */
package in.weq.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author root
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="user_entity")
@MappedSuperclass
public class UserEntity extends DomainObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4017509262869685160L;
	
	@OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Address> addresses;
	
	@OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contact> contacts;

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
}