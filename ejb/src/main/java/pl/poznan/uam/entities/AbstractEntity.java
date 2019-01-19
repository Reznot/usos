package pl.poznan.uam.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String uuid;
    private String comment;

    public AbstractEntity(Long id) {
        this.id = id;
    }

    @PrePersist
    @PreUpdate
    public void init() {
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();
        }
    }
}
