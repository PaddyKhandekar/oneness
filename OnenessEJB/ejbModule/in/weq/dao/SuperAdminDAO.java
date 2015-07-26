/**
 * 
 */
package in.weq.dao;

import in.weq.domain.SuperAdmin;
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
public class SuperAdminDAO extends AbstractDAO<SuperAdmin>{
	
	@PersistenceContext(name="OnenessEJB")
	private EntityManager em;
	
	public SuperAdminDAO() {
		super(SuperAdmin.class);
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

    public SuperAdmin getActiveUser(SuperAdmin admin) throws DatabaseException {
        List<SuperAdmin> admins = findAll();
        if (admins != null) {
            for (Iterator<SuperAdmin> userIterator = admins.iterator(); userIterator.hasNext();) {
                SuperAdmin superAdmin = userIterator.next();
                if(superAdmin.getUsername().equalsIgnoreCase(admin.getUsername()) && superAdmin.getPassword().equalsIgnoreCase(admin.getPassword())){
                    return superAdmin;
                }
            }
        }
        return null;
    }
}