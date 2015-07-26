package in.weq.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-05-24T13:28:59.697+0530")
@StaticMetamodel(Cart.class)
public class Cart_ extends DependentObject_ {
	public static volatile SingularAttribute<Cart, Double> totalPrice;
	public static volatile ListAttribute<Cart, StudentSet> studentSets;
	public static volatile SingularAttribute<Cart, Donor> donor;
}
