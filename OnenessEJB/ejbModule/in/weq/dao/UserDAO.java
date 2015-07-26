/**
 * 
 */
package in.weq.dao;

import in.weq.domain.User;
import in.weq.exception.DatabaseException;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author root
 *
 */
@Stateless
public class UserDAO extends AbstractDAO<User> implements UserDAOLocal{
	
	@SuppressWarnings("unused")
    private static final String TAG = UserDAO.class.getSimpleName();
    @PersistenceContext(name="OnenessEJB")
	private EntityManager em;
	
	public UserDAO() {
		super(User.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

    @Override
    public User getActiveUser(User user) throws DatabaseException {
        
        List<User> users = findAll();
        if (users != null) {
            for (Iterator<User> userIterator = users.iterator(); userIterator.hasNext();) {
                User iterater = userIterator.next();
                if(iterater.getUsername().equalsIgnoreCase(user.getUsername()) && iterater.getPassword().equals(user.getPassword())){
                    return iterater;
                }
            }
        }
        return null;
    }
}