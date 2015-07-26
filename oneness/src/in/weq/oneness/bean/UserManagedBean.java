package in.weq.oneness.bean;

import in.weq.exception.BusinessException;
import in.weq.oneness.constants.Roles;
import in.weq.oneness.constants.SessionConstants;
import in.weq.oneness.tos.UserTO;
import in.weq.service.UserServiceLocal;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UserManagedBean
{
    @SuppressWarnings("unused")
    private static final String TAG = UserManagedBean.class.getSimpleName();

    @EJB(mappedName = "UserService")
    private UserServiceLocal userServiceLocal;
    
    private String username;
    private String password;
    
    private String searchUser;
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getSearchUser()
    {
        return searchUser;
    }
    
    public void setSearchUser(String searchUser)
    {
        this.searchUser = searchUser;
    }
    
    public String login()
    {
        UserTO userTO = null;
        try {
            userTO = userServiceLocal.getActiveUser(getUsername(), getPassword());
        }
        catch (BusinessException e) {
            e.printStackTrace();
        }
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put( SessionConstants.USER, userTO);
        if(userTO != null)
        {
            if(Roles.ADMIN == Roles.valueOf(userTO.getRole())){
                return "schools";
            } else if(Roles.SCHOOL == Roles.valueOf(userTO.getRole())){
                return "school";
            }
        }
        context.addMessage("username", new FacesMessage("Invalid UserName and Password"));
        return "login";
    }
}