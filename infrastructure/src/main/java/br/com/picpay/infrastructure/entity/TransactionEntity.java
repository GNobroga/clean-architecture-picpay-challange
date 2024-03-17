package br.com.picpay.infrastructure.entity;

import br.com.picpay.core.domain.Wallet;
import br.com.picpay.core.domain.enums.TransactionStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class TransactionEntity extends BaseEntity<Long> {

    @JoinColumn(nullable = false)
    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE })
    private WalletEntity fromWallet;

    @JoinColumn(nullable = false)
    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE })
    private WalletEntity toWallet;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal transactionValue;

    @Column(length = 30)
    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum status;
}
