package in.weq.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-05-24T13:28:37.851+0530")
@StaticMetamodel(User.class)
public class User_ extends UserEntity_ {
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> statusString;
	public static volatile SingularAttribute<User, String> role;
	public static volatile SingularAttribute<User, Long> createdDate;
	public static volatile SingularAttribute<User, Long> modifiedDate;
}
