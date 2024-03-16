CREATE TABLE users (
    id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    email VARCHAR(70) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    tax_number VARCHAR(15) NOT NULL UNIQUE,
    full_name VARCHAR(70) NOT NULL,
    type VARCHAR(30) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL
);

CREATE INDEX users_email_index ON users (email);
CREATE INDEX users_tax_number_index ON users (tax_number);
