/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.esbaum.ee.ejb.beans;

import de.esbaum.ee.ejb.entities.CommonEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mscholl
 */
@Local
public interface TestSessionBeanLocal {

    <T extends CommonEntity> List<T> getEntities(Class<T> entityClass);

    List getEntitiesByName(String name);
    
}
