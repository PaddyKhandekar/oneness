package in.weq.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-26T15:18:52.609+0530")
@StaticMetamodel(StudentSet.class)
public class StudentSet_ extends DependentObject_ {
	public static volatile SingularAttribute<StudentSet, Double> price;
	public static volatile SingularAttribute<StudentSet, Boolean> status;
	public static volatile SingularAttribute<StudentSet, Cart> cart;
	public static volatile SingularAttribute<StudentSet, School> school;
	public static volatile ListAttribute<StudentSet, Student> students;
}
