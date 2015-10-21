package de.esbaum.ee.ejb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author martin.scholl@cismet.de
 * @version 1.0
 */
@Entity(name = "country_code")
@Getter
@Setter
@ToString
public class CountryCode extends CommonEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String country;
    
    @Column
    private String code;

    @Override
    public boolean canEqual(Object other) {
        return other instanceof CountryCode;
    }
}
