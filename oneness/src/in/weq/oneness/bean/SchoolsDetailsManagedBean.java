
package in.weq.oneness.bean;

import in.weq.exception.BusinessException;
import in.weq.oneness.tos.AddressTO;
import in.weq.oneness.tos.SchoolCategoryTO;
import in.weq.oneness.tos.SchoolTO;
import in.weq.service.SchoolServiceLocal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "schoolsDetails")
@ViewScoped
public class SchoolsDetailsManagedBean {

	private List<SchoolTO> searchedSchools;
	
	private List<SchoolTO> schools;
	
	private SchoolTO selectedSchool;
	
	private String searchableName;
	
	private String searchableLoaction;
	
	private SchoolCategoryTO searchableCategory;
	
	private List<SchoolCategoryTO> schoolCategories;
	
	private HashMap<String, SchoolCategoryTO> viewCatogories;
	
	private static final int SEARCHING_FACTORS_COUNT = 4;
	
	@EJB
	private SchoolServiceLocal schoolServiceLocal;
	
    @PostConstruct
    public void init() {
    	
    	searchedSchools = new ArrayList<SchoolTO>();
    	
    	try {
			schools = schoolServiceLocal.getActiveSchoolList();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
    	
    	if(schools == null){
    		schools = new ArrayList<SchoolTO>();
    	}
    	
    	try {
			schoolCategories = schoolServiceLocal.getSchoolCategoryList();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
    	
    	//create categories for view
    	viewCatogories = new HashMap<String, SchoolCategoryTO>();
    	viewCatogories.put("Select Catogory", null);
    	
    	if(schoolCategories != null){
    		for (Iterator<SchoolCategoryTO> iSchoolCategory = schoolCategories.iterator(); iSchoolCategory.hasNext();) {
    			SchoolCategoryTO schoolCategory = iSchoolCategory.next();
    			viewCatogories.put(schoolCategory.getCategory(), schoolCategory);
			}
    	} else{
    		schoolCategories = new ArrayList<SchoolCategoryTO>();
    	}
    }
    
    public void onAddNewSchoolClick(){
    	
    }
    
    public void onResetSearchClick(){
    	
    }
    
    public void onSearchClick(){
    	searchedSchools.clear();
    	for (Iterator<SchoolTO> iSchool = schools.iterator(); iSchool.hasNext();) {
    		SchoolTO school = iSchool.next();
    		int count = 0;
			
    		if(searchableName == null || school.getName().toLowerCase().contains(searchableName.toLowerCase())){
				count ++;
			}
    		
    		if(searchableCategory == null || school.getCategory().equals(searchableCategory.getResourceId())){
				count ++;
			}
    		
    		List<AddressTO> addreses = school.getAddresses();
    		if(searchableLoaction != null){
    			count ++;
    		}else if (addreses != null){
    			for (Iterator<AddressTO> iAddress = addreses.iterator(); iAddress.hasNext();) {
					AddressTO address = iAddress.next();
					if(address.getAddressLine1() != null){
						if(address.getAddressLine1().toLowerCase().contains(searchableLoaction.toLowerCase())){
							count ++;
							break;
						}
					}
					
					if(address.getAddressLine2() != null){
						if(address.getAddressLine2().toLowerCase().contains(searchableLoaction.toLowerCase())){
							count ++;
							break;
						}
					}
				}
    		}
    		
    		//TODO: add one more if
    		
    		if(count == SEARCHING_FACTORS_COUNT){
    			searchedSchools.add(school);
    		}
		}
    }

	public List<SchoolTO> getSearchedSchools() {
		return searchedSchools;
	}

	public void setSearchedSchools(List<SchoolTO> searchedSchools) {
		this.searchedSchools = searchedSchools;
	}

	public List<SchoolTO> getSchools() {
		return schools;
	}

	public void setSchools(List<SchoolTO> schools) {
		this.schools = schools;
	}

	public SchoolTO getSelectedSchool() {
		return selectedSchool;
	}

	public void setSelectedSchool(SchoolTO selectedSchool) {
		this.selectedSchool = selectedSchool;
	}

	public String getSearchableName() {
		return searchableName;
	}

	public void setSearchableName(String searchableName) {
		this.searchableName = searchableName;
	}

	public List<SchoolCategoryTO> getSchoolCategories() {
		return schoolCategories;
	}

	public void setSchoolCategories(List<SchoolCategoryTO> schoolCategories) {
		this.schoolCategories = schoolCategories;
	}

	public HashMap<String, SchoolCategoryTO> getViewCatogories() {
		return viewCatogories;
	}

	public void setViewCatogories(HashMap<String, SchoolCategoryTO> viewCatogories) {
		this.viewCatogories = viewCatogories;
	}

	public String getSearchableLoaction() {
		return searchableLoaction;
	}

	public void setSearchableLoaction(String searchableLoaction) {
		this.searchableLoaction = searchableLoaction;
	}

	public SchoolCategoryTO getSearchableCategory() {
		return searchableCategory;
	}

	public void setSearchableCategory(SchoolCategoryTO searchableCategory) {
		this.searchableCategory = searchableCategory;
	}
}