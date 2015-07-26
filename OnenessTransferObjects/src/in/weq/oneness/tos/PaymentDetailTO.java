/**
 * 
 */
package in.weq.oneness.tos;


/**
 * @author Paddy
 *
 */
public class PaymentDetailTO extends DependentObjectTO {
	
	private Double paymentAmount;
	
	private String paymentMode;
	
	private Long dateOfPayment;
	
	private DonorTO donor;

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Long getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(Long dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public DonorTO getDonor() {
		return donor;
	}

	public void setDonor(DonorTO donor) {
		this.donor = donor;
	}
}