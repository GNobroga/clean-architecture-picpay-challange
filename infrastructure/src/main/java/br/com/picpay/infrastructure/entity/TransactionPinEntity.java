package br.com.picpay.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "transactions_pin")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class TransactionPinEntity extends BaseEntity<Long> {

    @Column(nullable = false, length = 50)
    private String pin;

    @Column(nullable = false)
    private Integer attempt;

    @Column(nullable = false)
    private boolean blocked;
}
