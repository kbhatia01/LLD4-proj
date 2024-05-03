package org.scaler.lld4aprilevening.InheritanceDemo.TableperClass;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="TPC_INSTRUCTOR")

public class Instructor extends User {
    private String specialization;
}
