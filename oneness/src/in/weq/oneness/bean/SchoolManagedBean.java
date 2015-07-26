
package in.weq.oneness.bean;

import in.weq.exception.BusinessException;
import in.weq.oneness.constants.UserDetails;
import in.weq.oneness.tos.AddressTO;
import in.weq.oneness.tos.ContactTO;
import in.weq.oneness.tos.SchoolCategoryTO;
import in.weq.oneness.tos.SchoolTO;
import in.weq.oneness.util.TextUtils;
import in.weq.service.SchoolServiceLocal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;


@ManagedBean(name = "schoolBean")
@ViewScoped
public class SchoolManagedBean {
    
    @EJB(mappedName = "SchoolService")
    private SchoolServiceLocal schoolServiceLocal;
    
    private List<SchoolTO> searchedSchools;

    private List<SchoolTO> schools;

    private SchoolTO selectedSchool;
    
    private SchoolTO newSchool;
    
    private List<String> schoolAdd;
    
    private List<SchoolCategoryTO> categories;
    
    private boolean showAddSchool;
    
    private String searchName;
    
    private String searchLocation;
    
    private String searchCategory;
    
    private boolean searchPayment;

    @PostConstruct
    public void init() {
        
        try {
            categories = schoolServiceLocal.getSchoolCategoryList();
        }
        catch (BusinessException e1) {
            e1.printStackTrace();
            categories = new ArrayList<SchoolCategoryTO>();
        }
        
        schoolAdd = new ArrayList<String>();
        try {
            schools = schoolServiceLocal.getActiveSchoolList();
        }
        catch (Exception e) { }
        
        searchedSchools = new ArrayList<SchoolTO>();
        if (schools == null) {
            schools = new ArrayList<SchoolTO>();
        }
        
        searchedSchools.addAll(schools);
        resetSchool();
    }

    public void onSchoolSelect(SelectEvent event) {
        selectedSchool = (SchoolTO) event.getObject();
    }

    public void onSchoolUnselect(SelectEvent event) {
        selectedSchool = null;
    }
    
    public void resetSchool(){
        newSchool = new SchoolTO();
        newSchool.setName("");
        newSchool.setRegistration("");
        List<AddressTO> addresses = new ArrayList<AddressTO>();
        newSchool.setAddresses(addresses);
        AddressTO addressTO = new AddressTO();
        addressTO.setAddressLine1("");
    }

    public void onAddNewSchoolClick() {
        resetSchool();
        showAddSchool = true;
    }
    
    public void onEditSelectedSchoolClick(SchoolTO school) {
        newSchool = school;
        showAddSchool = true;
    }

    public void onRemoveSchoolClick() {
        try {
            schoolServiceLocal.removeSchool(selectedSchool);
        }
        catch (Exception e) {
        }
    }

    public void onAddNewAddressClick() {
        List<AddressTO> addreses = newSchool.getAddresses();
        if(addreses == null){
            addreses = new ArrayList<AddressTO>();
            newSchool.setAddresses(addreses);
        }
        
        addreses.add(new AddressTO());
    }
    
    public void onAddNewContactClick() {
        List<ContactTO> contacts = newSchool.getContacts();
        if(contacts == null){
            contacts = new ArrayList<ContactTO>();
            newSchool.setContacts(contacts);
        }
        contacts.add(new ContactTO());
    }

    public void onNewContactClick() {
        List<ContactTO> contacts = selectedSchool.getContacts();
        if (contacts == null) {
            contacts = new ArrayList<ContactTO>();
        }
        contacts.add(new ContactTO());
    }

    public void onRemoveContactClick(Long id) {
        for (Iterator<ContactTO> iAddress = selectedSchool.getContacts().iterator(); iAddress.hasNext();) {
            ContactTO contact = iAddress.next();
            if (contact.getResourceId() == id) {
                selectedSchool.getAddresses().remove(contact);
            }
        }
    }

    public void onSubmitClick() {
        FacesContext context = FacesContext.getCurrentInstance();
        if(TextUtils.emptyUtil(newSchool.getName())){
            context.addMessage(null, new FacesMessage("Invalid School Name"));
            return;
        }
        
        if(TextUtils.emptyUtil(newSchool.getRegistration())){
            context.addMessage(null, new FacesMessage("Invalid School Registration"));
            return;
        }
        
        if(TextUtils.emptyUtil(newSchool.getUsername()) || newSchool.getUsername().length() < UserDetails.USERNAME_LEN){
            context.addMessage(null, new FacesMessage("Invalid School Username"));
            return;
        }
        
        if(TextUtils.emptyUtil(newSchool.getPassword()) || newSchool.getPassword().length() < UserDetails.PASSWORD_LEN){
            context.addMessage(null, new FacesMessage("Invalid School Password"));
            return;
        }
        
        List<AddressTO> addreses = newSchool.getAddresses();
        if(addreses == null || addreses.isEmpty()){
            context.addMessage(null, new FacesMessage("School Address Needed"));
            return;
        }
        
        for (Iterator<AddressTO> iteratorAddress = addreses.iterator(); iteratorAddress.hasNext();) {
            AddressTO address = iteratorAddress.next();
            
            if(TextUtils.emptyUtil(address.getAddressLine1()) || TextUtils.emptyUtil(address.getAddressLine1())){
                context.addMessage(null, new FacesMessage("Invalid School Address"));
                return;
            }
            
            if(TextUtils.emptyUtil(address.getTown())){
                context.addMessage(null, new FacesMessage("Invalid School Address Town"));
                return;
            }
            
            if(TextUtils.emptyUtil(address.getState())){
                context.addMessage(null, new FacesMessage("Invalid School Address State"));
                return;
            }
            
            if(TextUtils.emptyUtil(address.getPostal()) ||address.getPostal().length() < UserDetails.PINCODE_LEN){
                context.addMessage(null, new FacesMessage("Invalid School Address Pincode"));
                return;
            }
            
            //TODO: create new View
            address.setPermanent(true);
        }
        
        List<ContactTO> contacts = newSchool.getContacts();
        if(contacts == null || contacts.isEmpty()){
            context.addMessage(null, new FacesMessage("School Address Needed"));
            return;
        }
        
        for (Iterator<ContactTO> iteratorContact = contacts.iterator(); iteratorContact.hasNext();) {
            ContactTO contact = iteratorContact.next();
            if(TextUtils.emptyUtil(contact.getFirstName())){
                context.addMessage(null, new FacesMessage("Invalid School Contact First Name"));
                return;
            }
            
            if(TextUtils.emptyUtil(contact.getLastName())){
                context.addMessage(null, new FacesMessage("Invalid School Contact Last Name"));
                return;
            }
            
            if(TextUtils.emptyUtil(contact.getDesignation())){
                context.addMessage(null, new FacesMessage("Invalid School Contact Last Name"));
                return;
            }
            
            if(TextUtils.emptyUtil(contact.getContactType())){
                context.addMessage(null, new FacesMessage("Invalid School Contact Type"));
                return;
            }
            
            if(TextUtils.emptyUtil(contact.getContactData())){
                context.addMessage(null, new FacesMessage("Invalid School Contact Data"));
                return;
            }
            
            //TODO: create new View
            contact.setPrimaryContact(true);
        }
        
        SchoolTO school = null;
        
        if(newSchool.getResourceId() == null || newSchool.getResourceId() == 0){
          //TODO: create new View
            newSchool.setActive(true);
            
            try {
                school = schoolServiceLocal.addSchool(newSchool);
            }
            catch (BusinessException e) {}
        } else {
            try {
                school = schoolServiceLocal.editSchool(newSchool);
            }
            catch (BusinessException e) {}
        }
        
        if(school == null){
            context.addMessage(null, new FacesMessage("Fail to perform operation"));
            return;
        }
        
        showAddSchool = false;
        searchedSchools.remove(newSchool);
        searchedSchools.add(school);
        newSchool = school;
    }
    
    public void onRemoveAddress(AddressTO address){
        newSchool.getAddresses().remove(address);
    }
    
    public void onRemoveContact(ContactTO contact){
        newSchool.getContacts().remove(contact);
    }

    public List<SchoolTO> getSearchedSchools() {
        return searchedSchools;
    }

    public void setSearchedSchools(List<SchoolTO> searchedSchools) {
        this.searchedSchools = searchedSchools;
    }

    public SchoolTO getSelectedSchool() {
        return selectedSchool;
    }

    public void setSelectedSchool(SchoolTO selectedSchool) {
        this.selectedSchool = selectedSchool;
    }

    public List<SchoolTO> getSchools() {
        return schools;
    }

    public void setSchools(List<SchoolTO> schools) {
        this.schools = schools;
    }

    public List<String> getSchoolAdd() {
        return schoolAdd;
    }

    public void setSchoolAdd(List<String> schoolAdd) {
        this.schoolAdd = schoolAdd;
    }

    public boolean isShowAddSchool() {
        return showAddSchool;
    }

    public void setShowAddSchool(boolean showAddSchool) {
        this.showAddSchool = showAddSchool;
    }

    public SchoolTO getNewSchool() {
        return newSchool;
    }

    public void setNewSchool(SchoolTO newSchool) {
        this.newSchool = newSchool;
    }

    public List<SchoolCategoryTO> getCategories() {
        return categories;
    }

    public void setCategories(List<SchoolCategoryTO> categories) {
        this.categories = categories;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getSearchLocation() {
        return searchLocation;
    }

    public void setSearchLocation(String searchLocation) {
        this.searchLocation = searchLocation;
    }

    public String getSearchCategory() {
        return searchCategory;
    }

    public void setSearchCategory(String searchCategory) {
        this.searchCategory = searchCategory;
    }

    public boolean isSearchPayment() {
        return searchPayment;
    }

    public void setSearchPayment(boolean searchPayment) {
        this.searchPayment = searchPayment;
    }
}