/**
 * 
 */
package in.weq.domain;

import in.weq.oneness.tos.AddressTO;
import in.weq.oneness.tos.ContactPersonTO;
import in.weq.oneness.tos.ContactTO;
import in.weq.oneness.tos.SchoolTO;
import in.weq.oneness.tos.StudentSetTO;
import in.weq.oneness.tos.StudentTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Paddy
 *
 */
@Entity
@Table(name="school")
@DiscriminatorValue("SCHOOL")
@MappedSuperclass
public class School extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8887243866089698864L;

	@Column(name="name")
	private String name;
	
	@Column(name="registration_no")
	private String registration;

	@OneToOne
	private SchoolCategory category;

	@Column(name="imgSrc")
	private String imgSrc;

	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy="school")
	private List<StudentSet> sets;
	
	@OneToMany(mappedBy="school")
	private List<Student> students;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Contact emailId;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Contact website;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SchoolCategory getCategory() {
        return category;
    }

    public void setCategory(SchoolCategory category) {
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
	
	public List<StudentSet> getSets() {
		return sets;
	}

	public void setSets(List<StudentSet> sets) {
		this.sets = sets;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public Contact getEmailId() {
		return emailId;
	}

	public void setEmailId(Contact emailId) {
		this.emailId = emailId;
	}

	public Contact getWebsite() {
		return website;
	}

	public void setWebsite(Contact website) {
		this.website = website;
	}

	public SchoolTO convertToTO() {
		SchoolTO schoolTO = new SchoolTO();
		
		schoolTO.setResourceId(getId());
		schoolTO.setActive(isActive());
		schoolTO.setCategory(category.getId());
		
		schoolTO.setCreatedDate(getCreatedDate());
		schoolTO.setDescription(description);
		schoolTO.setImgSrc(imgSrc);
		
		schoolTO.setModifiedDate(getModifiedDate());
		schoolTO.setName(name);
		schoolTO.setRole(getRole());
		
		schoolTO.setUsername(getUsername());
		schoolTO.setPassword(getPassword());
		schoolTO.setRegistration(getRegistration());
		
		if (emailId != null) {
			ContactTO emailIdTO = new ContactTO();
			emailIdTO.setResourceId(emailId.getId());
			emailIdTO.setData(emailId.getData());
			schoolTO.setEmailId(emailIdTO);
		}
		
		if (website != null) {
			ContactTO websiteTO = new ContactTO();
			websiteTO.setResourceId(website.getId());
			websiteTO.setData(website.getData());
			schoolTO.setWebsite(websiteTO);
		}
		
		List<ContactPerson> contactPersons = getContactPersons();
		if(contactPersons != null){
			List<ContactPersonTO> contactPersonTOs = new ArrayList<ContactPersonTO>();
			for (Iterator<ContactPerson> iterator = contactPersons.iterator(); iterator.hasNext();) {
				contactPersonTOs.add(iterator.next().convertToTO());
			}
			schoolTO.setContactPersons(contactPersonTOs);
		}
		
		List<Address> addresses = getAddresses();
		if (addresses != null) {
			List<AddressTO> addressTOs = new ArrayList<AddressTO>();
			for (Iterator<Address> iterator = addresses.iterator(); iterator.hasNext();) {
				Address address =  iterator.next();
				addressTOs.add(address.convertToTO());
				
			}
			schoolTO.setAddresses(addressTOs);
		}
		
		if(sets != null){
			List<StudentSetTO> setTOs = new ArrayList<StudentSetTO>();
			for (Iterator<StudentSet> setIterator = sets.iterator(); setIterator.hasNext();) {
				StudentSet set = setIterator.next();
				setTOs.add(set.convertToTO());
			}
			schoolTO.setSets(setTOs);
		}
		
		if(students !=  null){
			List<StudentTO> studentTOs = new ArrayList<StudentTO>();
			for (Iterator<Student> studentIterator = students.iterator(); studentIterator.hasNext();) {
				Student student = studentIterator.next();
				studentTOs.add(student.convertToTO());
			}
			schoolTO.setStudents(studentTOs);
		}
		
		return schoolTO;
	}
}