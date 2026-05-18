-- ============================================================
--  login_app  –  Database setup script
--  Run once before starting the Java application.
-- ============================================================

-- 1. Create and select the database
CREATE DATABASE IF NOT EXISTS login_app;
USE login_app;

-- 2. Create the users table
CREATE TABLE IF NOT EXISTS users (
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL
);

-- 3. Seed initial users
INSERT IGNORE INTO users (username, password) VALUES ('admin', 'admin123');
INSERT IGNORE INTO users (username, password) VALUES ('user1', 'pass1');

-- 4. Verify
SELECT * FROM users;