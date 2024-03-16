package br.com.picpay.infrastructure.repository;

import br.com.picpay.infrastructure.entity.UserEntity;
import br.com.picpay.infrastructure.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {
    Optional<WalletEntity> findByUserTaxNumber(String taxNumber);
}
