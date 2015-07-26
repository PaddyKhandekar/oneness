/**
 * 
 */
package in.weq.domain;

import in.weq.oneness.tos.SchoolCategoryTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Paddy
 *
 */
@Entity
@Table(name="school_category")
public class SchoolCategory extends DependentObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8887243866089698864L;

	@Column(name="category")
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public SchoolCategoryTO convertToTO() {
	    
	    SchoolCategoryTO category = new SchoolCategoryTO();
	    category.setResourceId(getId());
		category.setCategory(this.category);
		return category;
	}
}