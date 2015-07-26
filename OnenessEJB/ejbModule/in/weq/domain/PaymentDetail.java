/**
 * 
 */
package in.weq.domain;

import in.weq.oneness.tos.PaymentDetailTO;

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
@Table(name="payment_detail")
public class PaymentDetail extends DependentObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6706380735399947351L;
	
	@Column(name="paymentAmount")
	private Double paymentAmount;
	
	@Column(name="paymentMode")
	private String paymentMode;
	
	@Column(name="dateOfPayment")
	private Long dateOfPayment;
	
	@ManyToOne
	@JoinColumn(name="donor_id",referencedColumnName="id")
	private Donor donor;

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

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}
	
	@Override
	public PaymentDetailTO convertToTO() {
		
		PaymentDetailTO paymentDetailTO = new PaymentDetailTO();
		
		paymentDetailTO.setResourceId(getId());
		paymentDetailTO.setDateOfPayment(dateOfPayment);
		paymentDetailTO.setPaymentAmount(paymentAmount);
		paymentDetailTO.setPaymentMode(paymentMode);
		paymentDetailTO.setResourceId(getId());

		return paymentDetailTO;
	}
}