CREATE TABLE IF NOT EXISTS transactions (
    id INT PRIMARY KEY,
    date TIMESTAMP NOT NULL,
    amount NUMERIC(12,2) NOT NULL,
    category VARCHAR(255) NOT NULL,
    account VARCHAR(255) NOT NULL,
    note TEXT NOT NULL,
    type VARCHAR(20) NOT NULL,
    description TEXT
);
