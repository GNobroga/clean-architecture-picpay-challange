CREATE TABLE transactionsPin (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pin VARCHAR(50) NOT NULL,
    attempt INT NOT NULL,
    blocked BOOL NOT NULL DEFAULT FALSE,
    createdAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedAt DATETIME NULL
);