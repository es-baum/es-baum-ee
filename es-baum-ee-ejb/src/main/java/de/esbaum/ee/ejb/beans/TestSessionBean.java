/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.esbaum.ee.ejb.beans;

import de.esbaum.ee.ejb.entities.CommonEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author mscholl
 */
@Stateless
public class TestSessionBean implements TestSessionBeanLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public <T extends CommonEntity> List<T> getEntities(final Class<T> entityClass) {
        final CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(entityClass);
        final Root<T> r = cq.from(entityClass);
        cq.select(r);
        
        return em.createQuery(cq).getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List getEntitiesByName(final String entityName) {
        return em.createQuery("FROM " + entityName).getResultList();
    }
}
