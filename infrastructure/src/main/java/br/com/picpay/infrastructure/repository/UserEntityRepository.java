package br.com.picpay.infrastructure.repository;

import br.com.picpay.infrastructure.entity.TransactionEntity;
import br.com.picpay.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {
}
