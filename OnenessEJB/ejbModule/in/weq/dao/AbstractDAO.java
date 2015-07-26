/**
 * 
 */

package in.weq.dao;

import in.weq.exception.DatabaseException;
import in.weq.exception.StaleDataException;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * 
 * @author Paddy
 */
public abstract class AbstractDAO<T> {
    /**
     * 
     */
    private Class<T> entityClass;

    public AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createInstant(T entity) throws DatabaseException {
        getEntityManager().persist(entity);
        try {
            getEntityManager().flush();
        }
        catch (PersistenceException persistenceException) {
            Logger.getLogger(AbstractDAO.class.getName()).log(java.util.logging.Level.SEVERE, "Error in createInstant {0}",
                    new Object[] { persistenceException.getMessage() });
            throw new DatabaseException(persistenceException.getMessage());
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void create(T entity) throws DatabaseException {
        getEntityManager().persist(entity);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T edit(T entity) throws DatabaseException {
        try {
            entity = getEntityManager().merge(entity);
            getEntityManager().flush();
            return entity;
        }
        catch (PersistenceException persistenceException) {
            Logger.getLogger(AbstractDAO.class.getName()).log(java.util.logging.Level.SEVERE, "Error in edit {0}",
                    new Object[] { persistenceException.getMessage() });
            throw new DatabaseException(persistenceException.getMessage());
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
        getEntityManager().flush();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void flush() throws DatabaseException, StaleDataException {
        try {
            getEntityManager().flush();
        }
        catch (PersistenceException persistenceException) {
            Logger.getLogger(AbstractDAO.class.getName()).log(java.util.logging.Level.SEVERE, "Error in flushing {0}",
                    new Object[] { persistenceException.getMessage() });
            if (persistenceException instanceof OptimisticLockException) {
                throw new StaleDataException("The Entity was outdated", 0 + "");
            }
            throw new DatabaseException(persistenceException.getMessage());
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void refreshEntity(T entity) {
        getEntityManager().refresh(entity);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public T find(Object id) throws DatabaseException {
        try {
            return getEntityManager().find(entityClass, id);
        }
        catch (IllegalArgumentException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<T> findAll() throws DatabaseException {
        try {
            CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            cq.orderBy(getEntityManager().getCriteriaBuilder().asc(cq.from(entityClass).get("id")));

            return getEntityManager().createQuery(cq).getResultList();
        }
        catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<T> findAllByIds(List<Long> ids) throws DatabaseException {
        try {
            CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(entityClass);

            Root root = cq.from(entityClass);
            Expression<Long> exp = root.get("id");
            Predicate p2 = exp.in(ids);
            cq.where(p2);

            return getEntityManager().createQuery(cq).getResultList();
        }
        catch (Exception e) {
            Logger.getLogger(AbstractDAO.class.getName()).log(java.util.logging.Level.SEVERE, "Error in finding all by Id",
                    new Object[] { e.getMessage() });
            throw new DatabaseException("General error in getting the entities from the data store");
        }
    }

}
