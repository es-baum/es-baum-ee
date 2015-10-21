package de.esbaum.ee.ejb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author martin@es-baum.de
 * @version 1.0
 */
@Entity
@Getter
@Setter
@ToString
public class Customer extends CommonEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String surname;
    
    @Column
    private String forename;
    
    @ManyToOne
    @JoinColumn(name = "fk_title")
    private Title title;
    
    @ManyToOne
    @JoinColumn(name = "fk_home_address")
    private Address homeAddress;

    @Override
    public boolean canEqual(Object other) {
        return other instanceof Customer;
    }
}
