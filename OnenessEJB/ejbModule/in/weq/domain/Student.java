/**
 * 
 */
package in.weq.domain;

import in.weq.oneness.tos.AddressTO;
import in.weq.oneness.tos.ContactPersonTO;
import in.weq.oneness.tos.MarksheetTO;
import in.weq.oneness.tos.StudentTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Paddy
 *
 */
@Entity
@Table(name="student")
@DiscriminatorValue("STUD")
public class Student extends UserEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8949852981632344701L;

	@Column(name="imgSrc")
	private String imgSrc;
	
	@Column(name="lastName")
    private String lastName;
	
	@Column(name="name")
	private String name;
	
	@Column(name="DOB")
	private Long DOB;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="age")
	private int age;
	
	@Column(name="mediumOfEducation")
	private String mediumOfEducation;
	
	@Column(name="currentStandard")
	private String currentStandard;
	
	@Column(name="division")
	private String division;
	
	@OneToOne
	private StudentCategory category;
	
	@Column(name="fatherName")
	private String fatherName;
	
	@Column(name="fatherDOB")
	private Long fatherDOB;
	
	@Column(name="fatherOccupation")
	private String fatherOccupation;
	
	@Column(name="motherName")
	private String motherName;
	
	@Column(name="motherOccupation")
	private String motherOccupation;
	
	@Column(name="motherDOB")
	private Long motherDOB;
	
	@Column(name="numberOfMaleSiblings")
	private int numberOfMaleSiblings;
	
	@Column(name="numberOfFemaleSiblings")
	private int numberOfFemaleSiblings;
	
	@OneToMany(mappedBy="student", cascade=CascadeType.ALL)
	private List<Marksheet> marksheets;
	
	@ManyToOne
	@JoinColumn(name="school_id",referencedColumnName="id")
	private School school;

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDOB() {
		return DOB;
	}

	public void setDOB(Long dOB) {
		DOB = dOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMediumOfEducation() {
		return mediumOfEducation;
	}

	public void setMediumOfEducation(String mediumOfEducation) {
		this.mediumOfEducation = mediumOfEducation;
	}

	public String getCurrentStandard() {
		return currentStandard;
	}

	public void setCurrentStandard(String currentStandard) {
		this.currentStandard = currentStandard;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public StudentCategory getCategory() {
        return category;
    }

    public void setCategory(StudentCategory category) {
        this.category = category;
    }

    public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Long getFatherDOB() {
		return fatherDOB;
	}

	public void setFatherDOB(Long fatherDOB) {
		this.fatherDOB = fatherDOB;
	}

	public String getFatherOccupation() {
		return fatherOccupation;
	}

	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherOccupation() {
		return motherOccupation;
	}

	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}

	public Long getMotherDOB() {
		return motherDOB;
	}

	public void setMotherDOB(Long motherDOB) {
		this.motherDOB = motherDOB;
	}

	public int getNumberOfMaleSiblings() {
		return numberOfMaleSiblings;
	}

	public void setNumberOfMaleSiblings(int numberOfMaleSiblings) {
		this.numberOfMaleSiblings = numberOfMaleSiblings;
	}

	public int getNumberOfFemaleSiblings() {
		return numberOfFemaleSiblings;
	}

	public void setNumberOfFemaleSiblings(int numberOfFemaleSiblings) {
		this.numberOfFemaleSiblings = numberOfFemaleSiblings;
	}

	public List<Marksheet> getMarksheets() {
		return marksheets;
	}

	public void setMarksheets(List<Marksheet> marksheets) {
		this.marksheets = marksheets;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}
	
	public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
	public StudentTO convertToTO() {
		StudentTO studentTO = new StudentTO();
		
		studentTO.setActive(isActive());
		studentTO.setAge(age);
		studentTO.setCategory(category.getId());
		studentTO.setCurrentStandard(currentStandard);
		studentTO.setDivision(division);
		studentTO.setDOB(getDOB());
		studentTO.setFatherDOB(fatherDOB);
		studentTO.setFatherName(fatherName);
		studentTO.setFatherOccupation(fatherOccupation);
		studentTO.setGender(gender);
		studentTO.setImgSrc(imgSrc);
		studentTO.setLastName(lastName);
		studentTO.setMediumOfEducation(mediumOfEducation);
		studentTO.setMotherDOB(motherDOB);
		studentTO.setMotherName(motherName);
		studentTO.setMotherOccupation(motherOccupation);
		studentTO.setName(fatherName);
		studentTO.setNumberOfFemaleSiblings(numberOfFemaleSiblings);
		studentTO.setNumberOfMaleSiblings(numberOfMaleSiblings);
		studentTO.setPersistenceStatus(getPersistenceStatus());
		studentTO.setResourceId(getId());
		
		if(marksheets != null){
			List<MarksheetTO> marksheetTOs = new ArrayList<MarksheetTO>();
			for (Iterator<Marksheet> iMarksheet = marksheets.iterator(); iMarksheet.hasNext();) {
				MarksheetTO marksheetTO = iMarksheet.next().convertToTO();
				marksheetTOs.add(marksheetTO);
			}
			studentTO.setMarksheets(marksheetTOs);
		}
		
		List<ContactPerson> contactPersons = getContactPersons();
		if(contactPersons != null){
			List<ContactPersonTO> contactPersonTOs = new ArrayList<ContactPersonTO>();
			for (Iterator<ContactPerson> icontact = contactPersons.iterator(); icontact.hasNext();) {
				ContactPersonTO contactPersonTO = icontact.next().convertToTO();
				contactPersonTOs.add(contactPersonTO);
			}
			studentTO.setContactPersons(contactPersonTOs);
		}

		List<Address> addresses = getAddresses();
		if(addresses != null){
			List<AddressTO> addressTOs = new ArrayList<AddressTO>();
			for (Iterator<Address> iaddresse = addresses.iterator(); iaddresse.hasNext();) {
				AddressTO addressTO =  iaddresse.next().convertToTO();
				addressTOs.add(addressTO);
			}
			studentTO.setAddresses(addressTOs);
		}
		
		return studentTO;
	}
}