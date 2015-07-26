package in.weq.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-26T15:19:27.527+0530")
@StaticMetamodel(Student.class)
public class Student_ extends UserEntity_ {
	public static volatile SingularAttribute<Student, String> imgSrc;
	public static volatile SingularAttribute<Student, String> lastName;
	public static volatile SingularAttribute<Student, String> name;
	public static volatile SingularAttribute<Student, Long> DOB;
	public static volatile SingularAttribute<Student, String> gender;
	public static volatile SingularAttribute<Student, Integer> age;
	public static volatile SingularAttribute<Student, String> mediumOfEducation;
	public static volatile SingularAttribute<Student, String> currentStandard;
	public static volatile SingularAttribute<Student, String> division;
	public static volatile SingularAttribute<Student, StudentCategory> category;
	public static volatile SingularAttribute<Student, String> fatherName;
	public static volatile SingularAttribute<Student, Long> fatherDOB;
	public static volatile SingularAttribute<Student, String> fatherOccupation;
	public static volatile SingularAttribute<Student, String> motherName;
	public static volatile SingularAttribute<Student, String> motherOccupation;
	public static volatile SingularAttribute<Student, Long> motherDOB;
	public static volatile SingularAttribute<Student, Integer> numberOfMaleSiblings;
	public static volatile SingularAttribute<Student, Integer> numberOfFemaleSiblings;
	public static volatile ListAttribute<Student, Marksheet> marksheets;
	public static volatile SingularAttribute<Student, School> school;
}
