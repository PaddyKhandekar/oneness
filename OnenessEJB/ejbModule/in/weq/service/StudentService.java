/**
 * 
 */
package in.weq.service;

import in.weq.dao.StudentCategoryDAOLocal;
import in.weq.dao.StudentDAOLocal;
import in.weq.domain.Address;
import in.weq.domain.Contact;
import in.weq.domain.Student;
import in.weq.domain.StudentCategory;
import in.weq.exception.BusinessException;
import in.weq.exception.DatabaseException;
import in.weq.oneness.tos.AddressTO;
import in.weq.oneness.tos.ContactTO;
import in.weq.oneness.tos.SchoolTO;
import in.weq.oneness.tos.StudentCategoryTO;
import in.weq.oneness.tos.StudentTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * @author root
 *
 */
@Stateless
@EJB(beanInterface = StudentServiceLocal.class, name = "StudentService")
public class StudentService implements StudentServiceLocal {
	
	@EJB
	private StudentDAOLocal studentDAOLocal;
	
	@EJB
    private StudentCategoryDAOLocal studentCategoryDAOLocal;

	@Override
	public List<StudentTO> getActiveStudentListFromSchool(SchoolTO schoolTO) throws BusinessException {
		return null;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public StudentTO addStudent(StudentTO studentTO, SchoolTO schoolTO) throws BusinessException {
		Student student = new Student();
		student.setActive(studentTO.getActive());
		student.setAge(studentTO.getAge());
		student.setLastName(studentTO.getLastName());
		
		StudentCategory studentCategory;
        try {
            studentCategory = studentCategoryDAOLocal.getCategory(studentTO.getCategory());
        }
        catch (DatabaseException e) {
            throw new BusinessException(e.getMessage());
        }
        
		student.setCategory(studentCategory);
		student.setCurrentStandard(studentTO.getCurrentStandard());
		student.setDivision(studentTO.getDivision());
		student.setDOB(studentTO.getDOB());
		student.setFatherDOB(studentTO.getFatherDOB());
		student.setFatherName(studentTO.getFatherName());
		student.setFatherOccupation(studentTO.getFatherOccupation());
		student.setGender(studentTO.getGender());
		student.setImgSrc(studentTO.getImgSrc());
		student.setMediumOfEducation(studentTO.getMediumOfEducation());
		student.setMotherDOB(studentTO.getMotherDOB());
		student.setMotherName(studentTO.getMotherName());
		student.setMotherOccupation(studentTO.getMotherOccupation());
		student.setName(studentTO.getName());
		student.setNumberOfFemaleSiblings(studentTO.getNumberOfFemaleSiblings());
		student.setNumberOfMaleSiblings(studentTO.getNumberOfMaleSiblings());
		
		
		List<AddressTO> addressTOs = studentTO.getAddresses();
		if(addressTOs != null){
			List<Address> addresses = new ArrayList<Address>();
			for (Iterator<AddressTO> iAddress = addressTOs.iterator(); iAddress.hasNext();) {
				AddressTO addressTO = iAddress.next();
				Address address = new Address();
				address.setAddressLine1(addressTO.getAddressLine1());
				address.setAddressLine2(addressTO.getAddressLine2());
				address.setAddressType(addressTO.getAddressType());
				address.setCountry(addressTO.getCountry());
				address.setPermanent(addressTO.getPermanent());
				address.setPostal(addressTO.getPostal());
				address.setState(addressTO.getState());
				address.setTown(addressTO.getTown());
				
				addresses.add(address);
			}
			student.setAddresses(addresses);
		}
		
		List<ContactTO> contactTOs = studentTO.getContacts();
		if(contactTOs != null){
			List<Contact> contacts = new ArrayList<Contact>();
			for (Iterator<ContactTO> iContact = contactTOs.iterator(); iContact.hasNext();) {
				ContactTO contactTO = iContact.next();
				Contact contact = new Contact();
				contact.setContactData(contactTO.getContactData());
				contact.setContactType(contactTO.getContactType());
				contact.setDesignation(contactTO.getDesignation());
				contact.setFirstName(contactTO.getFirstName());
				contact.setLastName(contactTO.getLastName());
				contact.setPrimaryContact(contactTO.getPrimaryContact());
				contact.setStatus(contactTO.getStatus());
				contact.setTitle(contactTO.getTitle());
				
				contacts.add(contact);
			}
			student.setContacts(contacts);
		}
		
		try {
			student = studentDAOLocal.addStudent(student, schoolTO.getResourceId());
		} catch (DatabaseException e) {
			throw new BusinessException(e.getMessage());
		}
		
		return student.convertToTO();
	}
	
	@Override
    public StudentTO editStudent(StudentTO studentTO) throws BusinessException {
	    
        Student student = new Student();
        student.setId(studentTO.getResourceId());
        student.setActive(studentTO.getActive());
        student.setAge(studentTO.getAge());
        student.setLastName(studentTO.getLastName());
        
        StudentCategory studentCategory;
        try {
            studentCategory = studentCategoryDAOLocal.getCategory(studentTO.getCategory());
        }
        catch (DatabaseException e) {
            throw new BusinessException(e.getMessage());
        }
        
        student.setCategory(studentCategory);
        student.setCurrentStandard(studentTO.getCurrentStandard());
        student.setDivision(studentTO.getDivision());
        student.setDOB(studentTO.getDOB());
        student.setFatherDOB(studentTO.getFatherDOB());
        student.setFatherName(studentTO.getFatherName());
        student.setFatherOccupation(studentTO.getFatherOccupation());
        student.setGender(studentTO.getGender());
        student.setImgSrc(studentTO.getImgSrc());
        student.setMediumOfEducation(studentTO.getMediumOfEducation());
        student.setMotherDOB(studentTO.getMotherDOB());
        student.setMotherName(studentTO.getMotherName());
        student.setMotherOccupation(studentTO.getMotherOccupation());
        student.setName(studentTO.getName());
        student.setNumberOfFemaleSiblings(studentTO.getNumberOfFemaleSiblings());
        student.setNumberOfMaleSiblings(studentTO.getNumberOfMaleSiblings());
        
        
        List<AddressTO> addressTOs = studentTO.getAddresses();
        if(addressTOs != null){
            List<Address> addresses = new ArrayList<Address>();
            for (Iterator<AddressTO> iAddress = addressTOs.iterator(); iAddress.hasNext();) {
                AddressTO addressTO = iAddress.next();
                Address address = new Address();
                address.setAddressLine1(addressTO.getAddressLine1());
                address.setAddressLine2(addressTO.getAddressLine2());
                address.setAddressType(addressTO.getAddressType());
                address.setCountry(addressTO.getCountry());
                address.setPermanent(addressTO.getPermanent());
                address.setPostal(addressTO.getPostal());
                address.setState(addressTO.getState());
                address.setTown(addressTO.getTown());
                
                addresses.add(address);
            }
            student.setAddresses(addresses);
        }
        
        List<ContactTO> contactTOs = studentTO.getContacts();
        if(contactTOs != null){
            List<Contact> contacts = new ArrayList<Contact>();
            for (Iterator<ContactTO> iContact = contactTOs.iterator(); iContact.hasNext();) {
                ContactTO contactTO = iContact.next();
                Contact contact = new Contact();
                contact.setContactData(contactTO.getContactData());
                contact.setContactType(contactTO.getContactType());
                contact.setDesignation(contactTO.getDesignation());
                contact.setFirstName(contactTO.getFirstName());
                contact.setLastName(contactTO.getLastName());
                contact.setPrimaryContact(contactTO.getPrimaryContact());
                contact.setStatus(contactTO.getStatus());
                contact.setTitle(contactTO.getTitle());
                
                contacts.add(contact);
            }
            student.setContacts(contacts);
        }
        
        try {
            student = studentDAOLocal.editStudent(student);
        } catch (DatabaseException e) {
            throw new BusinessException(e.getMessage());
        }
        
        return student.convertToTO();
    }
	
	@Override
    public List<StudentCategoryTO> getSchoolCategoryList() throws BusinessException {
        List<StudentCategory> schoolCategories = null;
        List<StudentCategoryTO> schoolCategoriesTO = null;
        try {
            schoolCategories = studentCategoryDAOLocal.getAllCategories();
        }
        catch (DatabaseException e) {
            e.printStackTrace();
        }
        
        if(schoolCategories != null){
            schoolCategoriesTO = new ArrayList<StudentCategoryTO>();
            for (Iterator<StudentCategory> categoryIterator = schoolCategories.iterator(); categoryIterator.hasNext();) {
                schoolCategoriesTO.add(categoryIterator.next().convertToTO());
            }
            return schoolCategoriesTO;
        }
        return null;
    }

    @Override
    public StudentCategoryTO addSchoolCategory(StudentCategoryTO schoolCategoryTO) throws BusinessException {
        StudentCategory category = new StudentCategory();
        category.setCategory(schoolCategoryTO.getCategory());
        try {
            category = studentCategoryDAOLocal.addCategory(category);
            return category.convertToTO();
        }
        catch (DatabaseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public StudentCategoryTO editStudentCategory(StudentCategoryTO schoolCategoryTO) throws BusinessException {
        StudentCategory category = new StudentCategory();
        category.setCategory(schoolCategoryTO.getCategory());
        category.setId(schoolCategoryTO.getResourceId());
        try {
            category = studentCategoryDAOLocal.addCategory(category);
            return category.convertToTO();
        }
        catch (DatabaseException e) {
            e.printStackTrace();
        }
        return null;
    }
}