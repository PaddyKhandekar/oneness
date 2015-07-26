/**
 * 
 */
package in.weq.domain;

import in.weq.oneness.tos.DomainObjectTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.eclipse.persistence.annotations.Customizer;

/**
 * @author root
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="domain_object")
@DiscriminatorColumn(name = "DOMAIN_TYPE")
@Customizer(InheritanceCustomizer.class)
public class DomainObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2309881841178677028L;

	@Id
	@Column(name="id",nullable=false)
	@TableGenerator(name = "DOMAIN_GEN", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "DOMAIN_GEN")
	private long id;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="persistenceStatus")
	private String persistenceStatus;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPersistenceStatus() {
		return persistenceStatus;
	}

	public void setPersistenceStatus(String persistenceStatus) {
		this.persistenceStatus = persistenceStatus;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public boolean equals(Object obj) {
		DomainObject object = (DomainObject) obj;
		return id == object.getId();
	}
	
	public DomainObjectTO convertToTO(){
		DomainObjectTO domainObjectTO = new DomainObjectTO();
		domainObjectTO.setActive(active);
		domainObjectTO.setPersistenceStatus(persistenceStatus);
		domainObjectTO.setResourceId(id);
		return domainObjectTO;
	}
}