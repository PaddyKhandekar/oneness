/**
 * 
 */
package in.weq.domain;

import in.weq.oneness.tos.StudentCategoryTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Paddy
 *
 */
@Entity
@Table(name="student_category")
public class StudentCategory extends DependentObject{

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

	public StudentCategoryTO convertToTO() {
	    
	    StudentCategoryTO category = new StudentCategoryTO();
	    category.setResourceId(getId());
		category.setCategory(this.category);
		return category;
	}
}