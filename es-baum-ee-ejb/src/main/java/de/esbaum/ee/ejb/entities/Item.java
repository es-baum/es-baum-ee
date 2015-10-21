package de.esbaum.ee.ejb.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
public class Item extends CommonEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "item_name")
    private String itemName;
    
    @Column
    private String description;
    
    @Column(name = "service_date")
    @Temporal(TemporalType.DATE)
    private Date serviceDate;
    
    @Column
    private Double price;
    
    @Column
    private Double amount;
    
    @ManyToOne
    @JoinColumn(name = "unit")
    private Unit unit;

    @Override
    public boolean canEqual(Object other) {
        return other instanceof Item;
    }
}
