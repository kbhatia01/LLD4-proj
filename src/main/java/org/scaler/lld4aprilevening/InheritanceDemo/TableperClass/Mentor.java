package org.scaler.lld4aprilevening.InheritanceDemo.TableperClass;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="TPC_MENTOR")

public class Mentor extends User {

    private double mentorRating;

}
