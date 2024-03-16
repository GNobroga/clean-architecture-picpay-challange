CREATE TABLE users (
    id UUID NOT NULL PRIMARY KEY,
    email VARCHAR(70) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    textNumber VARCHAR(15) NOT NULL UNIQUE,
    fullName VARCHAR(70) NOT NULL,
    type VARCHAR(30) NOT NULL,
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP NULL
);

CREATE INDEX users_email_index ON users (email);
CREATE INDEX users_text_number_index ON users (textNumber);
