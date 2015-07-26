package in.weq.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-05-24T13:28:37.843+0530")
@StaticMetamodel(MarksheetData.class)
public class MarksheetData_ extends DependentObject_ {
	public static volatile SingularAttribute<MarksheetData, String> subject;
	public static volatile SingularAttribute<MarksheetData, Integer> obtainedMarks;
	public static volatile SingularAttribute<MarksheetData, Integer> totalMarks;
	public static volatile SingularAttribute<MarksheetData, Marksheet> marksheet;
}
