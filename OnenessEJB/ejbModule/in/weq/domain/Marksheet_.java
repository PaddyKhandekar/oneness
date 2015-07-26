package in.weq.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-05-24T13:28:37.842+0530")
@StaticMetamodel(Marksheet.class)
public class Marksheet_ extends DependentObject_ {
	public static volatile SingularAttribute<Marksheet, String> standard;
	public static volatile SingularAttribute<Marksheet, String> examType;
	public static volatile ListAttribute<Marksheet, MarksheetData> marksheetDatas;
	public static volatile SingularAttribute<Marksheet, Student> student;
}
