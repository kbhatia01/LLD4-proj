package org.scaler.lld4aprilevening.InheritanceDemo.joinnedTable;


import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "jt_TA")
@Data
public class TA extends User {

    private int noOfSession;
    private double rating;
}
