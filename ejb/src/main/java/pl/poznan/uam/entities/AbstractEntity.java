package pl.poznan.uam.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String uuid;
    private String comment;

    public AbstractEntity(Long id) {
        this.id = id;
    }

    //TODO
//    @PrePersist
//    public void init() {
//        if (uuid == null) {
//            uuid = UUID.randomUUID().toString();
//        }
//    }
}
