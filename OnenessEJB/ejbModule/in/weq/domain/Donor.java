/**
 * 
 */
package in.weq.domain;

import in.weq.oneness.tos.AddressTO;
import in.weq.oneness.tos.CartTO;
import in.weq.oneness.tos.DonorTO;
import in.weq.oneness.tos.PaymentDetailTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Paddy
 *
 */
@Entity
@Table(name="donor")
@DiscriminatorValue("DONOR")
@MappedSuperclass
public class Donor extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6794973175792413146L;
	
	@Column(name="makeMyProfileVisible")
	private boolean makeMyProfileVisible;
	
	@OneToMany(mappedBy="donor",cascade=CascadeType.ALL)
	private List<Cart> carts;
	
	@OneToMany(mappedBy="donor",cascade=CascadeType.ALL)
	private List<PaymentDetail> paymentDetails;

	public boolean isMakeMyProfileVisible() {
		return makeMyProfileVisible;
	}

	public void setMakeMyProfileVisible(boolean makeMyProfileVisible) {
		this.makeMyProfileVisible = makeMyProfileVisible;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public List<PaymentDetail> getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(List<PaymentDetail> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
	@Override
	public DonorTO convertToTO() {
		DonorTO donorTO = new DonorTO();
		
		donorTO.setActive(isActive());
		donorTO.setResourceId(getId());
		donorTO.setCreatedDate(getCreatedDate());
		donorTO.setMakeMyProfileVisible(makeMyProfileVisible);
		donorTO.setModifiedDate(getModifiedDate());
		donorTO.setPersistenceStatus(getPersistenceStatus());
		donorTO.setResourceId(getId());
		donorTO.setRole(getRole());
		donorTO.setStatusString(getStatusString());
		donorTO.setUsername(getUsername());
		
		List<Address> addresses = getAddresses();
		if(addresses != null){
			List<AddressTO> addressTOs = new ArrayList<AddressTO>();
			for (Iterator<Address> iaddresse = addresses.iterator(); iaddresse.hasNext();) {
				AddressTO addressTO =  iaddresse.next().convertToTO();
				addressTOs.add(addressTO);
			}
			donorTO.setAddresses(addressTOs);
		}
		
		if (carts != null) {
			List<CartTO> cartTOs = new ArrayList<CartTO>();
			for (Iterator<Cart> iCart = carts.iterator(); iCart.hasNext();) {
				CartTO cartTO = iCart.next().convertToTO();
				cartTOs.add(cartTO);
			}
			donorTO.setCarts(cartTOs);
		}
		
		if (carts != null) {
			List<PaymentDetailTO> paymentDetailTOs = new ArrayList<PaymentDetailTO>();
			for (Iterator<PaymentDetail> iPaymentDetail = paymentDetails.iterator(); iPaymentDetail.hasNext();) {
				PaymentDetailTO paymentDetailTO = iPaymentDetail.next().convertToTO();
				paymentDetailTOs.add(paymentDetailTO);
			}
			donorTO.setPaymentDetails(paymentDetailTOs);
		}
		return donorTO;
	}
}