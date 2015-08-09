/**
 * 
 */
package in.weq.service;

import in.weq.dao.ContactTypeDAOLocal;
import in.weq.dao.SchoolCategoryDAOLocal;
import in.weq.dao.SchoolDAOLocal;
import in.weq.domain.Address;
import in.weq.domain.Contact;
import in.weq.domain.ContactPerson;
import in.weq.domain.ContactType;
import in.weq.domain.School;
import in.weq.domain.SchoolCategory;
import in.weq.exception.BusinessException;
import in.weq.exception.DatabaseException;
import in.weq.oneness.constants.Roles;
import in.weq.oneness.tos.AddressTO;
import in.weq.oneness.tos.ContactPersonTO;
import in.weq.oneness.tos.ContactTO;
import in.weq.oneness.tos.SchoolCategoryTO;
import in.weq.oneness.tos.SchoolTO;
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
@EJB(beanInterface = SchoolServiceLocal.class, name = "SchoolService")
public class SchoolService implements SchoolServiceLocal {

	@EJB
	private SchoolDAOLocal schoolDAOLocal;
	
	@EJB
	private StudentServiceLocal studentServiceLocal;
	
	@EJB
	private ContactTypeDAOLocal contactTypeDAOLocal;
	
	@EJB
    private SchoolCategoryDAOLocal schoolCategoryDAOLocal;

	@Override
	public List<SchoolTO> getActiveSchoolList() throws BusinessException {
		List<School> schools = null;
		try {
			schools = schoolDAOLocal.getActiveSchoolList();
		} catch (DatabaseException e) {
			throw new BusinessException(e.getMessage());
		}

		List<SchoolTO> schoolTOs = new ArrayList<SchoolTO>();
		for (Iterator<School> iSchool = schools.iterator(); iSchool.hasNext();) {
			schoolTOs.add(iSchool.next().convertToTO());
		}
		return schoolTOs;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public SchoolTO addSchool(SchoolTO schoolTO) throws BusinessException {

		School school = new School();

		school.setName(schoolTO.getName());
		school.setActive(schoolTO.getActive());
		school.setImgSrc(schoolTO.getImgSrc());
		
		SchoolCategory schoolCategory = null;
        try {
            schoolCategory = schoolCategoryDAOLocal.getCategories(schoolTO.getCategory());
        }
        catch (DatabaseException e) {
            throw new BusinessException(e.getMessage());
        }

		school.setCategory(schoolCategory);
		school.setCreatedDate(System.currentTimeMillis());
		school.setDescription(schoolTO.getDescription());
		school.setStatusString(schoolTO.getStatusString());
		school.setRole(Roles.SCHOOL.toString());
		
		school.setRegistration(schoolTO.getRegistration());
	    school.setUsername(schoolTO.getUsername());
	    school.setPassword(schoolTO.getPassword());
	    
	    ContactTO emailIdTO = schoolTO.getEmailId();
	    if(emailIdTO != null){
	    	Contact emailId = new Contact();
	    	emailId.setData(emailIdTO.getData());
	    	school.setEmailId(emailId);
	    }
	    
	    ContactTO websiteTO = schoolTO.getEmailId();
	    if(websiteTO != null){
	    	Contact website = new Contact();
	    	website.setData(websiteTO.getData());
	    	school.setEmailId(website);
	    }

		List<AddressTO> addressesTOs = schoolTO.getAddresses();
		if (addressesTOs != null) {
			
			List<Address> addresses = new ArrayList<Address>();
			for (Iterator<AddressTO> iAddress = addressesTOs.iterator(); iAddress.hasNext();) {

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
				address.setUserEntity(school);

				addresses.add(address);
			}
			school.setAddresses(addresses);
		}

		List<ContactPersonTO> contactContactPersonTOs = schoolTO.getContactPersons();
		if(contactContactPersonTOs != null){
			
			List<ContactPerson> contactPersons = new ArrayList<ContactPerson>();
			for (Iterator<ContactPersonTO> iContactPerson = contactContactPersonTOs.iterator(); iContactPerson.hasNext();) {
				
				ContactPersonTO contactPersonTO = iContactPerson.next();
				ContactPerson contactPerson = new ContactPerson();
				
				contactPerson.setDesignation(contactPersonTO.getDesignation());
				contactPerson.setFirstName(contactPersonTO.getFirstName());
				contactPerson.setLastName(contactPersonTO.getLastName());
				contactPerson.setPrimaryContact(contactPersonTO.isPrimaryContact());
				contactPerson.setTitle(contactPersonTO.getTitle());
				
				List<ContactTO> contactTOs = contactPersonTO.getContacts();
				if(contactTOs != null){
					List<Contact> contacts = new ArrayList<Contact>();
					for (Iterator<ContactTO> iContact = contactTOs.iterator(); iContact.hasNext();) {
						ContactTO contactTO = iContact.next();
						Contact contact = new Contact();
						
						ContactType contactType = null;
						try {
							contactType = contactTypeDAOLocal.getContactTypeById(contactTO.getResourceId());
						} catch (DatabaseException e) {
							throw new BusinessException(e.getMessage());
						}
						contact.setContactType(contactType);
						contact.setData(contactTO.getData());
					}
					contactPerson.setContacts(contacts);
				}
				
				contactPersons.add(contactPerson);
			}
			school.setContactPersons(contactPersons);
		}

		try {
			school = schoolDAOLocal.addSchool(school);
		} catch (DatabaseException e) {
			throw new BusinessException(e.getMessage());
		}
		return school.convertToTO();
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public SchoolTO editSchool(SchoolTO schoolTO) throws BusinessException {

		School school = null;
        try {
            school = schoolDAOLocal.findSchoolById(schoolTO.getResourceId());
        }
        catch (DatabaseException e1) {
            e1.printStackTrace();
        }
        
		if (school == null) {
            school = new School();
        }

		school.setId(schoolTO.getResourceId());
		school.setName(schoolTO.getName());
		school.setActive(schoolTO.getActive());
		school.setImgSrc(schoolTO.getImgSrc());
		
		SchoolCategory schoolCategory = null;
        try {
            schoolCategory = schoolCategoryDAOLocal.getCategories(schoolTO.getCategory());
        }
        catch (DatabaseException e) {
            throw new BusinessException(e.getMessage());
        }

		school.setCategory(schoolCategory);
		school.setCreatedDate(System.currentTimeMillis());
		school.setDescription(schoolTO.getDescription());
		school.setStatusString(schoolTO.getStatusString());
		
		school.setUsername(schoolTO.getUsername());
        school.setPassword(schoolTO.getPassword());
        school.setRegistration(schoolTO.getRegistration());
        
        ContactTO emailIdTO = schoolTO.getEmailId();
	    if(emailIdTO != null){
	    	Contact emailId = new Contact();
	    	emailId.setId(emailIdTO.getResourceId());
	    	emailId.setData(emailIdTO.getData());
	    	school.setEmailId(emailId);
	    }
	    
	    ContactTO websiteTO = schoolTO.getEmailId();
	    if(websiteTO != null){
	    	Contact website = new Contact();
	    	website.setId(websiteTO.getResourceId());
	    	website.setData(websiteTO.getData());
	    	school.setEmailId(website);
	    }

		List<AddressTO> addressesTOs = schoolTO.getAddresses();
		if(addressesTOs != null){
			List<Address> addresses = new ArrayList<Address>();
			for (Iterator<AddressTO> iterator = addressesTOs.iterator(); iterator.hasNext();) {
				
				AddressTO addressTO = iterator.next();
				Address address = new Address();
				
				address.setId(addressTO.getResourceId());
				address.setAddressLine1(addressTO.getAddressLine1());
				address.setAddressLine2(addressTO.getAddressLine2());
				address.setAddressType(addressTO.getAddressType());
				address.setCountry(addressTO.getCountry());
				address.setPermanent(addressTO.getPermanent());
				address.setPostal(addressTO.getPostal());
				address.setState(addressTO.getState());
				address.setTown(addressTO.getTown());
				address.setUserEntity(school);
				
				addresses.add(address);
			}
			school.setAddresses(addresses);
		}

		List<ContactPersonTO> contactContactPersonTOs = schoolTO.getContactPersons();
		if(contactContactPersonTOs != null){
			
			List<ContactPerson> contactPersons = new ArrayList<ContactPerson>();
			for (Iterator<ContactPersonTO> iContactPerson = contactContactPersonTOs.iterator(); iContactPerson.hasNext();) {
				
				ContactPersonTO contactPersonTO = iContactPerson.next();
				ContactPerson contactPerson = new ContactPerson();
				
				contactPerson.setId(contactPersonTO.getResourceId());
				contactPerson.setDesignation(contactPersonTO.getDesignation());
				contactPerson.setFirstName(contactPersonTO.getFirstName());
				contactPerson.setLastName(contactPersonTO.getLastName());
				contactPerson.setPrimaryContact(contactPersonTO.isPrimaryContact());
				contactPerson.setTitle(contactPersonTO.getTitle());
				
				List<ContactTO> contactTOs = contactPersonTO.getContacts();
				if(contactTOs != null){
					List<Contact> contacts = new ArrayList<Contact>();
					for (Iterator<ContactTO> iContact = contactTOs.iterator(); iContact.hasNext();) {
						ContactTO contactTO = iContact.next();
						Contact contact = new Contact();
						
						ContactType contactType = null;
						try {
							contactType = contactTypeDAOLocal.getContactTypeById(contactTO.getResourceId());
						} catch (DatabaseException e) {
							throw new BusinessException(e.getMessage());
						}
						contact.setId(contactTO.getResourceId());
						contact.setContactType(contactType);
						contact.setData(contactTO.getData());
					}
					contactPerson.setContacts(contacts);
				}
				
				contactPersons.add(contactPerson);
			}
			school.setContactPersons(contactPersons);
		}

		try {
			school = schoolDAOLocal.editSchool(school);
		} catch (DatabaseException e) {
			throw new BusinessException(e.getMessage());
		}
		
		return school.convertToTO();
	}

	@Override
	public void addStudent(StudentTO studentTO, SchoolTO schoolTO) throws BusinessException {
		try {
			studentServiceLocal.addStudent(studentTO, schoolTO);
		} catch (BusinessException e) {
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void removeSchool(SchoolTO schoolTO) throws BusinessException {
		try {
			schoolDAOLocal.removeSchool(schoolTO.getResourceId());
		} catch (DatabaseException e) {
			throw new BusinessException(e.getMessage());
		}
	}

    @Override
    public SchoolTO findSchoolById(Long schoolId) throws BusinessException {
        School school = null;
        try {
            school = schoolDAOLocal.findSchoolById(schoolId);
        }
        catch (DatabaseException e) {
            throw new BusinessException(e.getMessage());
        }
        
        if (school != null) {
            return school.convertToTO();
        }
        return null;
    }

    @Override
    public List<SchoolCategoryTO> getSchoolCategoryList() throws BusinessException {
        List<SchoolCategory> schoolCategories = null;
        List<SchoolCategoryTO> schoolCategoriesTO = null;
        try {
            schoolCategories = schoolCategoryDAOLocal.getAllCategories();
        }
        catch (DatabaseException e) {
            e.printStackTrace();
        }
        
        if(schoolCategories != null){
            schoolCategoriesTO = new ArrayList<SchoolCategoryTO>();
            for (Iterator<SchoolCategory> categoryIterator = schoolCategories.iterator(); categoryIterator.hasNext();) {
                schoolCategoriesTO.add(categoryIterator.next().convertToTO());
            }
            return schoolCategoriesTO;
        }
        return null;
    }

    @Override
    public SchoolCategoryTO addSchoolCategory(SchoolCategoryTO schoolCategoryTO) throws BusinessException {
        SchoolCategory category = new SchoolCategory();
        category.setCategory(schoolCategoryTO.getCategory());
        try {
            category = schoolCategoryDAOLocal.addCategory(category);
            return category.convertToTO();
        }
        catch (DatabaseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SchoolCategoryTO editSchoolCategory(SchoolCategoryTO schoolCategoryTO) throws BusinessException {
        SchoolCategory category = new SchoolCategory();
        category.setCategory(schoolCategoryTO.getCategory());
        category.setId(schoolCategoryTO.getResourceId());
        try {
            category = schoolCategoryDAOLocal.addCategory(category);
            return category.convertToTO();
        }
        catch (DatabaseException e) {
            e.printStackTrace();
        }
        return null;
    }
}