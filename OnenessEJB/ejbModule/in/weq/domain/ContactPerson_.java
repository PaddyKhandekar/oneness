package in.weq.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-28T21:52:47.032+0530")
@StaticMetamodel(ContactPerson.class)
public class ContactPerson_ extends DependentObject_ {
	public static volatile SingularAttribute<ContactPerson, String> title;
	public static volatile SingularAttribute<ContactPerson, String> firstName;
	public static volatile SingularAttribute<ContactPerson, String> lastName;
	public static volatile SingularAttribute<ContactPerson, String> designation;
	public static volatile SingularAttribute<ContactPerson, Boolean> primaryContact;
	public static volatile ListAttribute<ContactPerson, Contact> contacts;
	public static volatile SingularAttribute<ContactPerson, UserEntity> userEntity;
}
