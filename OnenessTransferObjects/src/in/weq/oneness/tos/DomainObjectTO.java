/**
 * 
 */
package in.weq.oneness.tos;


/**
 * @author root
 *
 */
public class DomainObjectTO {

	private Long resourceId;
	
	private String persistenceStatus;
	
	private Boolean active;

	public String getPersistenceStatus() {
		return persistenceStatus;
	}

	public void setPersistenceStatus(String persistenceStatus) {
		this.persistenceStatus = persistenceStatus;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
}