/**
 * 
 */
package in.weq.service;

import in.weq.dao.ContactTypeDAOLocal;
import in.weq.dao.SuperAdminDAO;
import in.weq.dao.UserDAOLocal;
import in.weq.domain.ContactType;
import in.weq.domain.SuperAdmin;
import in.weq.domain.User;
import in.weq.exception.BusinessException;
import in.weq.exception.DatabaseException;
import in.weq.oneness.tos.ContactTypeTO;
import in.weq.oneness.tos.UserTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @author root
 *
 */
@Stateless
@EJB(beanInterface = UserServiceLocal.class, name = "UserService")
public class UserService implements UserServiceLocal {

    @EJB
    UserDAOLocal userDAOLocal;
    
    @EJB
    ContactTypeDAOLocal contactTypeDAOLocal;
    
    @EJB
    SuperAdminDAO superAdminDAO;
    
    @Override
    public UserTO getActiveUser(String username, String password) throws BusinessException {
        
        UserTO userTO = new UserTO();
        userTO.setUsername(username);
        userTO.setPassword(password);
        
        SuperAdmin admin = new SuperAdmin();
        admin.setPassword(password);
        admin.setUsername(username);
        try {
            admin = superAdminDAO.getActiveUser(admin);
        }
        catch (DatabaseException e1) {
            e1.printStackTrace();
        }
        
        if(admin != null){
            userTO.setRole("ADMIN");
            return userTO;
        }
        
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        try {
            user = userDAOLocal.getActiveUser(user);
        }
        catch (DatabaseException e) {
            e.printStackTrace();
        }
        
        if (user != null) {
            return user.convertToTO();
        }
        return null;
    }

	@Override
	public List<ContactTypeTO> getAllContactType() throws BusinessException {
		List<ContactType> contactTypes = null;
		
		try {
			contactTypes = contactTypeDAOLocal.getAllContactType();
		} catch (DatabaseException e) {
			throw new BusinessException(e.getMessage());
		}
		List<ContactTypeTO> contactTypeTOs = null;
		if (contactTypes != null) {
			contactTypeTOs =  new ArrayList<ContactTypeTO>();
			for (Iterator<ContactType> iterator = contactTypes.iterator(); iterator.hasNext();) {
				
				ContactType contactType = (ContactType) iterator.next();
				ContactTypeTO contactTypeTO = new ContactTypeTO();
				contactTypeTO.setResourceId(contactType.getId());
				contactTypeTO.setType(contactType.getType());
				contactTypeTOs.add(contactTypeTO);
			}
		}
		return contactTypeTOs;
	}

	@Override
	public ContactTypeTO getContactTypeById(Long contactTypeId) throws BusinessException {
		
		ContactTypeTO contactTypeTO = null;
		ContactType contactType;
		try {
			contactType = contactTypeDAOLocal.getContactTypeById(contactTypeId);
		} catch (DatabaseException e) {
			throw new BusinessException(e.getMessage());
		}
		
		if(contactType != null){
			contactTypeTO = new ContactTypeTO();
			contactTypeTO.setResourceId(contactType.getId());
			contactTypeTO.setType(contactType.getType());
		}
		return contactTypeTO;
	}

	@Override
	public ContactTypeTO createContactType(ContactTypeTO contactTypeTO) throws BusinessException {
		
		ContactType contactType = new ContactType();
		contactType.setType(contactTypeTO.getType());
		
		try {
			contactType = contactTypeDAOLocal.createContactType(contactType);
		} catch (DatabaseException e) {
			throw new BusinessException(e.getMessage());
		}
		
		if(contactType != null){
			contactTypeTO.setResourceId(contactType.getId());
			contactTypeTO.setType(contactType.getType());
		}
		return contactTypeTO;
	}
}