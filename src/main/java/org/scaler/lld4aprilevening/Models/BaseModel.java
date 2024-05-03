package org.scaler.lld4aprilevening.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;


@Data
@MappedSuperclass
public class BaseModel {

    @Id
    private long id;

    private Date CreatedAt;

    private Date UpdatedAt;

}
