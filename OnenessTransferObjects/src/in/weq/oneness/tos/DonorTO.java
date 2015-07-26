/**
 * 
 */
package in.weq.oneness.tos;

import java.util.List;

/**
 * @author Paddy
 *
 */
public class DonorTO extends UserTO {

	private boolean makeMyProfileVisible;
	
	private List<CartTO> carts;
	
	private List<PaymentDetailTO> paymentDetails;

	public boolean isMakeMyProfileVisible() {
		return makeMyProfileVisible;
	}

	public void setMakeMyProfileVisible(boolean makeMyProfileVisible) {
		this.makeMyProfileVisible = makeMyProfileVisible;
	}

	public List<CartTO> getCarts() {
		return carts;
	}

	public void setCarts(List<CartTO> carts) {
		this.carts = carts;
	}

	public List<PaymentDetailTO> getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(List<PaymentDetailTO> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
}