package org.scaler.lld4aprilevening.InheritanceDemo.joinnedTable;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Entity(name = "jt_mentor")
@Data
public class Mentor extends User {

    private double mentorRating;

    @PrimaryKeyJoinColumn
    private long user_id;

}
