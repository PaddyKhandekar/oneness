/**
 * 
 */
package in.weq.service;

import in.weq.dao.SuperAdminDAO;
import in.weq.dao.UserDAOLocal;
import in.weq.domain.SuperAdmin;
import in.weq.domain.User;
import in.weq.exception.BusinessException;
import in.weq.exception.DatabaseException;
import in.weq.oneness.tos.UserTO;

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
}