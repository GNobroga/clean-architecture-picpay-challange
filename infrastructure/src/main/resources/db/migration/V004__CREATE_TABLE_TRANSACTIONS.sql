CREATE TABLE transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fromWallet BIGINT NOT NULL,
    toWallet BIGINT NOT NULL,
    transactionValue DECIMAL(10, 2) NOT NULL,
    status VARCHAR(30) NOT NULL,
    createdAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedAt DATETIME NULL,

    FOREIGN KEY (fromWallet) REFERENCES wallets(id),
    FOREIGN KEY (toWallet) REFERENCES wallets(id)
);