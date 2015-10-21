/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.esbaum.ee.jsf;

import de.esbaum.ee.ejb.beans.TestSessionBeanLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author mscholl
 */
@ManagedBean(name = "Test1Bean")
@SessionScoped
public class NewJSFManagedBean implements Serializable {
    
    @EJB
    private TestSessionBeanLocal tsb;

    @Getter
    @Setter
    private String test1;
    private String response;
    
    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public NewJSFManagedBean() {
        System.out.println("instance");
        test1 = "Title";
    }
    
    public String getResponse() {
        //invalidate user session
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        
        try {
//            final Class c = Class.forName(test1);
//            if(CommonEntity.class.isAssignableFrom(c)) {
                final List l = tsb.getEntitiesByName(test1);
                return "all entities: " + l.toString();
//            } else {
//                return "you entered = " + test1 + " + which is not a known entity class";
//            }
        } catch (final Exception e) {
            e.printStackTrace();
            return "oops: " + e.getMessage();
        }
    }
}
