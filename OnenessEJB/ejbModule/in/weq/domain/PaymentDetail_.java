package in.weq.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-05-24T13:28:37.846+0530")
@StaticMetamodel(PaymentDetail.class)
public class PaymentDetail_ extends DependentObject_ {
	public static volatile SingularAttribute<PaymentDetail, Double> paymentAmount;
	public static volatile SingularAttribute<PaymentDetail, String> paymentMode;
	public static volatile SingularAttribute<PaymentDetail, Long> dateOfPayment;
	public static volatile SingularAttribute<PaymentDetail, Donor> donor;
}
