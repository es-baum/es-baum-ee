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
@Entity(name = "postal_code")
@Getter
@Setter
@ToString
public class PostalCode extends CommonEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String code;
    
    @Column
    private String city;
    
    @ManyToOne
    @JoinColumn(name = "fk_country_code")
    private CountryCode countryCode;
    
    @Override
    public boolean canEqual(Object other) {
        return other instanceof PostalCode;
    }
}
