package GDM.demo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import GDM.demo.enumeration.RolEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Devloper {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36,columnDefinition = "varchar(36)",updatable = false,nullable = false)
    private UUID uuid;

    @Column(length = 50, columnDefinition = "varchar(50)", updatable = true, nullable = false)
    private String name;

    @Column(length = 50, columnDefinition = "varchar(50)", updatable = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private RolEnum rol;

    @ManyToOne
    private Game game;

    @Builder.Default
    @OneToMany(mappedBy = "devloper", cascade = {CascadeType.REMOVE})
    private List<Task> tasks = new ArrayList<>();
}
