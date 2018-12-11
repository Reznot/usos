package pl.poznan.uam.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String uuid;
    private String comment;

    //TODO
//    @PrePersist
//    public void init() {
//        if (uuid == null) {
//            uuid = UUID.randomUUID().toString();
//        }
//    }
}
