package br.com.picpay.infrastructure.repository;

import br.com.picpay.infrastructure.entity.TransactionPinEntity;
import br.com.picpay.infrastructure.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPinEntityRepository extends JpaRepository<TransactionPinEntity, Long> {
}
