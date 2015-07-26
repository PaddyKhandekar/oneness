/**
 * 
 */
package in.weq.domain;

import in.weq.oneness.tos.DependentObjectTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author root
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="dependent_object")
public class DependentObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2309881841178677028L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public DependentObjectTO convertToTO(){
		DependentObjectTO dependentObjectTO = new DependentObjectTO();
		dependentObjectTO.setResourceId(id);
		return dependentObjectTO;
	}
}