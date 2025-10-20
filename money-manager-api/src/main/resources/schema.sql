DROP TABLE  IF EXISTS transactions;
CREATE TABLE transactions (
    id UUID PRIMARY KEY,
    date TIMESTAMP NOT NULL,
    amount NUMERIC(12,2) NOT NULL,
    category VARCHAR(255) NOT NULL,
    account VARCHAR(255) NOT NULL,
    note TEXT NOT NULL,
    type VARCHAR(20) NOT NULL,
    description TEXT
);

DROP  TABLE  IF EXISTS accounts;
CREATE TABLE accounts (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    balance NUMERIC(12,2) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
