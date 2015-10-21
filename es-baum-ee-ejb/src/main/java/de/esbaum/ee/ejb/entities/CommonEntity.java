package de.esbaum.ee.ejb.entities;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author martin@es-baum.de
 * @version 1.0
 */
@MappedSuperclass
public abstract class CommonEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public abstract Long getId();

    public abstract void setId(final Long id);

    public abstract boolean canEqual(Object other);
    
    @Override
    public int hashCode() {
        return getId() == null ? 0 : getId().hashCode();
    }

    @Override
    public boolean equals(Object object) {
        boolean equal = false;
        
        if(object instanceof CommonEntity) {
            final CommonEntity other = (CommonEntity)object;
            if(other.canEqual(this)) {
                if(getId() == null && other.getId() == null) {
                    equal = this == other;
                } else {
                    equal = getId() != null && getId().equals(other.getId());
                }
            }
        }
        
        return equal;
    }

    @Override
    public String toString() {
        return "de.esbaum.ejb.entities.CommonEntity[ id=" + getId() + " ]";
    }
}
