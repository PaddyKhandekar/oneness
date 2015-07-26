package in.weq.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-19T17:18:35.381+0530")
@StaticMetamodel(UserEntity.class)
public class UserEntity_ extends DomainObject_ {
	public static volatile ListAttribute<UserEntity, Address> addresses;
	public static volatile ListAttribute<UserEntity, Contact> contacts;
}
