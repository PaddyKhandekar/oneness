/**
 * 
 */
package in.weq.domain;

import in.weq.oneness.tos.UserTO;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

/**
 * @author Paddy
 *
 */
@Entity
@Table(name="user")
@DiscriminatorValue("USER")
@MappedSuperclass
public class User extends UserEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7293732632217752296L;

	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;

	@Column(name="statusString")
	private String statusString;

	@Column(name="role")
	private String role;
	
	@Column(name="createdDate")
	private Long createdDate;

	@Column(name="modifiedDate")
	private Long modifiedDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatusString() {
		return statusString;
	}

	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	public Long getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Long modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	@Override
	public UserTO convertToTO() {
	    UserTO userTO = new UserTO();
	    userTO.setActive(isActive());
	    userTO.setCreatedDate(createdDate);
	    userTO.setModifiedDate(modifiedDate);
	    userTO.setPassword(password);
	    userTO.setResourceId(getId());
	    userTO.setRole(role);
	    userTO.setStatusString(statusString);
	    userTO.setUsername(username);
	    return userTO;
	}
}