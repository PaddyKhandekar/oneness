/**
 * 
 */
package in.weq.oneness.tos;

import java.util.List;

/**
 * @author root
 *
 */
public class UserEntityTO extends DomainObjectTO {

	private List<AddressTO> addresses;
	
	private List<ContactPersonTO> contactPersons;

	public List<AddressTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressTO> addresses) {
		this.addresses = addresses;
	}

	public List<ContactPersonTO> getContactPersons() {
		return contactPersons;
	}

	public void setContactPersons(List<ContactPersonTO> contactPersons) {
		this.contactPersons = contactPersons;
	}
}