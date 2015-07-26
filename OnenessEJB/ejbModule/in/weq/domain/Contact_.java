package in.weq.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-05-24T13:28:51.117+0530")
@StaticMetamodel(Contact.class)
public class Contact_ extends DependentObject_ {
	public static volatile SingularAttribute<Contact, String> title;
	public static volatile SingularAttribute<Contact, String> firstName;
	public static volatile SingularAttribute<Contact, String> lastName;
	public static volatile SingularAttribute<Contact, String> designation;
	public static volatile SingularAttribute<Contact, String> contactType;
	public static volatile SingularAttribute<Contact, String> contactData;
	public static volatile SingularAttribute<Contact, String> status;
	public static volatile SingularAttribute<Contact, Boolean> primaryContact;
	public static volatile SingularAttribute<Contact, UserEntity> userEntity;
}
