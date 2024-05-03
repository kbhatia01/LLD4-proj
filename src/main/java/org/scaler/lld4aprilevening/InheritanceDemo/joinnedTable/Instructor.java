package org.scaler.lld4aprilevening.InheritanceDemo.joinnedTable;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "jt_instructor")
public class Instructor extends User{
    private String specialization;
}
