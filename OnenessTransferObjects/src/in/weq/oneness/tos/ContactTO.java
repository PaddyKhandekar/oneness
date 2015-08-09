/**
 * 
 */
package in.weq.oneness.tos;


/**
 * @author Paddy
 *
 */
public class ContactTO extends DependentObjectTO {

	private ContactTypeTO contactType;

	private String data;

	public ContactTypeTO getContactType() {
		return contactType;
	}

	public void setContactType(ContactTypeTO contactType) {
		this.contactType = contactType;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}