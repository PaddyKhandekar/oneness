/**
 * 
 */
package in.weq.oneness.tos;

import java.util.List;

/**
 * @author Paddy
 *
 */
public class StudentTO extends UserEntityTO {

	private String imgSrc;
	
    private String lastName;
	
	private String name;
	
	private Long DOB;
	
	private String gender;
	
	private int age;
	
	private String mediumOfEducation;
	
	private String currentStandard;
	
	private String division;
	
	private Long category;
	
	private String fatherName;
	
	private Long fatherDOB;
	
	private String fatherOccupation;
	
	private String motherName;
	
	private String motherOccupation;
	
	private Long motherDOB;
	
	private int numberOfMaleSiblings;
	
	private int numberOfFemaleSiblings;
	
	private List<MarksheetTO> marksheets;
	
	private StudentSetTO studentSet;
	
	private SchoolTO school;

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

	public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
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

	public List<MarksheetTO> getMarksheets() {
		return marksheets;
	}

	public void setMarksheets(List<MarksheetTO> marksheets) {
		this.marksheets = marksheets;
	}

	public StudentSetTO getStudentSet() {
		return studentSet;
	}

	public void setStudentSet(StudentSetTO studentSet) {
		this.studentSet = studentSet;
	}

	public SchoolTO getSchool() {
		return school;
	}

	public void setSchool(SchoolTO school) {
		this.school = school;
	}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}