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
	
	private List<ContactTO> contacts;

	public List<AddressTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressTO> addresses) {
		this.addresses = addresses;
	}

	public List<ContactTO> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactTO> contacts) {
		this.contacts = contacts;
	}
}