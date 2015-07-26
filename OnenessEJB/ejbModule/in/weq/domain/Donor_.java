package in.weq.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-05-24T13:28:59.704+0530")
@StaticMetamodel(Donor.class)
public class Donor_ extends User_ {
	public static volatile SingularAttribute<Donor, Boolean> makeMyProfileVisible;
	public static volatile ListAttribute<Donor, Cart> carts;
	public static volatile ListAttribute<Donor, PaymentDetail> paymentDetails;
}
