package de.esbaum.ee.ejb.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Invoice extends CommonEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "invoice_id")
    private Long invoiceId;
    
    @Column(name = "invoice_date")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    
    @Column
    private Double lumpsum;
    
    @ManyToOne
    @JoinColumn(name = "fk_customer_order")
    private Order order;
    
    @ManyToOne
    @JoinColumn(name = "fk_billing_customer")
    private Customer billingCustomer;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable (
        name = "jt_invoice_item",
        joinColumns={ @JoinColumn(name="fk_invoice", referencedColumnName="id") },
        inverseJoinColumns={ @JoinColumn(name="fk_item", referencedColumnName="id") }
    )
    private List<Item> items;

    @Override
    public boolean canEqual(Object other) {
        return other instanceof Invoice;
    }
}
