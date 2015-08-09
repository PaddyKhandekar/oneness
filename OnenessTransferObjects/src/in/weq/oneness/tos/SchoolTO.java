/**
 * 
 */
package in.weq.oneness.tos;

import java.util.List;


/**
 * @author Paddy
 *
 */
public class SchoolTO extends UserTO {

	private String name;

	private Long category;

	private String imgSrc;

	private String description;
	
	private String registration;
	
	private ContactTO emailId;
	
	private ContactTO website;
	
    private List<StudentSetTO> sets;
    
    private List<StudentTO> students;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

    public ContactTO getEmailId() {
		return emailId;
	}

	public void setEmailId(ContactTO emailId) {
		this.emailId = emailId;
	}

	public ContactTO getWebsite() {
		return website;
	}

	public void setWebsite(ContactTO website) {
		this.website = website;
	}

	public List<StudentSetTO> getSets() {
        return sets;
    }

    public void setSets(List<StudentSetTO> sets) {
        this.sets = sets;
    }

    public List<StudentTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentTO> students) {
        this.students = students;
    }
}