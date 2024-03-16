CREATE TABLE wallets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    balance DECIMAL(10, 2) NOT NULL,
    userId UUID NOT NULL UNIQUE,
    transactionPinId BIGINT NOT NULL UNIQUE,
    createdAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedAt DATETIME NULL,

    FOREIGN KEY (userId) REFERENCES users(id),
    FOREIGN KEY (transactionPinId) REFERENCES transactions_pin(id)
);