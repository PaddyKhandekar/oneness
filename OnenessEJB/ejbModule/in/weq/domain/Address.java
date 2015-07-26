/**
 * 
 */
package in.weq.domain;

import in.weq.oneness.tos.AddressTO;

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
@Table(name="addresses")
public class Address extends DependentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 800074100173259519L;

	@Column(name="addressLine1")
	private String addressLine1;

	@Column(name="addressLine2")
	private String addressLine2;

	@Column(name="town")
	private String town;

	@Column(name="state")
	private String state;

	@Column(name="country")
	private String country;

	@Column(name="postal")
	private String postal;

	@Column(name="addressType")
	private String addressType;
	
	@Column(name="permanent")
	private boolean permanent;

	@ManyToOne
	@JoinColumn(name="user_entity_id",referencedColumnName="id")
	private UserEntity userEntity;

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

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	
	public AddressTO  convertToTO(){
		AddressTO addressTO = new AddressTO();
		
		addressTO.setResourceId(getId());
		addressTO.setAddressLine1(addressLine1);
		addressTO.setAddressLine2(addressLine2);
		addressTO.setAddressType(addressType);
		addressTO.setCountry(country);
		addressTO.setPermanent(permanent);
		addressTO.setPostal(postal);
		addressTO.setResourceId(getId());
		addressTO.setState(state);
		addressTO.setTown(town);
		
		return addressTO;
	}
}