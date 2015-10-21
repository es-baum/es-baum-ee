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
public class Address extends CommonEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String street;
    
    @Column(name = "house_number")
    private String houseNumber;
    
    @Column
    private String district;
    
    @ManyToOne
    @JoinColumn(name = "fk_postal_code")
    private PostalCode postalCode;

    @Override
    public boolean canEqual(Object other) {
        return other instanceof Address;
    }
}
