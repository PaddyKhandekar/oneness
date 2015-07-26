/**
 * 
 */
package in.weq.oneness.tos;


/**
 * @author Paddy
 *
 */
public class AddressTO extends DependentObjectTO {

	private String addressLine1;

	private String addressLine2;

	private String town;

	private String state;

	private String country;

	private String postal;

	private String addressType;
	
	private Boolean permanent;

	private UserEntityTO userEntity;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public UserEntityTO getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntityTO userEntity) {
		this.userEntity = userEntity;
	}

	public Boolean getPermanent() {
		return permanent;
	}

	public void setPermanent(Boolean permanent) {
		this.permanent = permanent;
	}
}