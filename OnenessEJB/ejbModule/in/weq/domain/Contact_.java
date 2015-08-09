package in.weq.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-28T21:52:46.987+0530")
@StaticMetamodel(Contact.class)
public class Contact_ extends DependentObject_ {
	public static volatile SingularAttribute<Contact, String> data;
	public static volatile SingularAttribute<Contact, ContactType> contactType;
	public static volatile SingularAttribute<Contact, ContactPerson> contactPerson;
}
