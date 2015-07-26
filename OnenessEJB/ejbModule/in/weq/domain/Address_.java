package in.weq.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-05-24T13:28:59.696+0530")
@StaticMetamodel(Address.class)
public class Address_ extends DependentObject_ {
	public static volatile SingularAttribute<Address, String> addressLine1;
	public static volatile SingularAttribute<Address, String> addressLine2;
	public static volatile SingularAttribute<Address, String> town;
	public static volatile SingularAttribute<Address, String> state;
	public static volatile SingularAttribute<Address, String> country;
	public static volatile SingularAttribute<Address, String> postal;
	public static volatile SingularAttribute<Address, String> addressType;
	public static volatile SingularAttribute<Address, Boolean> permanent;
	public static volatile SingularAttribute<Address, UserEntity> userEntity;
}
