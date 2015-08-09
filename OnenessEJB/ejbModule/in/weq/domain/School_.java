package in.weq.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-28T21:53:49.727+0530")
@StaticMetamodel(School.class)
public class School_ extends User_ {
	public static volatile SingularAttribute<School, String> name;
	public static volatile SingularAttribute<School, String> registration;
	public static volatile SingularAttribute<School, SchoolCategory> category;
	public static volatile SingularAttribute<School, String> imgSrc;
	public static volatile SingularAttribute<School, String> description;
	public static volatile ListAttribute<School, StudentSet> sets;
	public static volatile ListAttribute<School, Student> students;
	public static volatile SingularAttribute<School, Contact> emailId;
	public static volatile SingularAttribute<School, Contact> website;
}
