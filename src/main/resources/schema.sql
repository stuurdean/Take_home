CREATE TABLE IF NOT EXISTS accounts (
    id SERIAL PRIMARY KEY,
    balance DECIMAL(15, 2) NOT NULL,
    start_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL
    );