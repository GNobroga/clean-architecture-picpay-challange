package br.com.picpay.infrastructure.entity;

import br.com.picpay.core.domain.enums.UserTypeEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class UserEntity extends BaseEntity<UUID> {


    @Column(nullable = false, unique = true, length = 70)
    private String email;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false, length = 15)
    private String taxNumber;

    @Column(nullable = false, length = 70)
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private UserTypeEnum type;

}
