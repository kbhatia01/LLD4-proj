package org.scaler.lld4aprilevening.InheritanceDemo.joinnedTable;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Entity(name="jt_user")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class User {
    @Id
    private long ID;
    private String name;
    private String email;

    private String password;
}
