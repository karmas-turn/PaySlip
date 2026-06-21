-- ============================================================
--  PaySlip System – Database Schema
--  Run this script once in your MySQL client or Workbench
-- ============================================================

CREATE DATABASE IF NOT EXISTS payslip_db;
USE payslip_db;

-- ── 1. Departments ───────────────────────────────────────────
CREATE TABLE IF NOT EXISTS departments (
    id          INT          AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100) NOT NULL UNIQUE,
    created_at  TIMESTAMP    DEFAULT CURRENT_TIMESTAMP
);

-- ── 2. Admin Users ───────────────────────────────────────────
CREATE TABLE IF NOT EXISTS admins (
    id         INT          AUTO_INCREMENT PRIMARY KEY,
    full_name  VARCHAR(150) NOT NULL,
    email      VARCHAR(150) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,   -- store hashed passwords (BCrypt)
    created_at TIMESTAMP    DEFAULT CURRENT_TIMESTAMP
);

-- ── 3. Employees ─────────────────────────────────────────────
CREATE TABLE IF NOT EXISTS employees (
    id            INT           AUTO_INCREMENT PRIMARY KEY,
    employee_id   VARCHAR(20)   NOT NULL UNIQUE,   -- e.g. EMP001
    full_name     VARCHAR(150)  NOT NULL,
    email         VARCHAR(150)  NOT NULL UNIQUE,
    phone         VARCHAR(20),
    department_id INT,
    position      VARCHAR(100),
    basic_salary  DECIMAL(12,2) NOT NULL DEFAULT 0.00,
    hire_date     DATE,
    status        ENUM('Active','On Leave','Inactive') DEFAULT 'Active',
    password      VARCHAR(255)  NOT NULL,           -- hashed
    created_at    TIMESTAMP     DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE SET NULL
);

-- ── 4. Payslips ──────────────────────────────────────────────
CREATE TABLE IF NOT EXISTS payslips (
    id               INT           AUTO_INCREMENT PRIMARY KEY,
    employee_id      INT           NOT NULL,
    pay_period_month VARCHAR          NOT NULL,   -- 1-12
    pay_period_year  INT           NOT NULL,
    basic_salary     DECIMAL(12,2) NOT NULL,
    allowance        DECIMAL(12,2) DEFAULT 0.00,
    transport        DECIMAL(12,2) DEFAULT 0.00,
    tax              DECIMAL(12,2) DEFAULT 0.00,
    ssnt             DECIMAL(12,2) DEFAULT 0.00,
    other_deductions DECIMAL(12,2) DEFAULT 0.00,
    total_earnings   DECIMAL(12,2) GENERATED ALWAYS AS
                         (basic_salary + allowance + transport) STORED,
    total_deductions DECIMAL(12,2) GENERATED ALWAYS AS
                         (tax + ssnt + other_deductions) STORED,
    net_pay          DECIMAL(12,2) GENERATED ALWAYS AS
                         (basic_salary + allowance + transport - tax - ssnt - other_deductions) STORED,
    status           ENUM('Pending','Paid') DEFAULT 'Pending',
    generated_at     TIMESTAMP     DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (employee_id) REFERENCES employees(id) ON DELETE CASCADE,
    UNIQUE KEY uq_emp_period (employee_id, pay_period_month, pay_period_year)
);

-- ── Seed: default admin ───────────────────────────────────────
-- Password below is BCrypt hash of "admin123" – change before production
INSERT IGNORE INTO admins (full_name, email, password)
VALUES ('Admin User', 'admin@payslip.com',
        '$2a$10$abcdefghijklmnopqrstuuVfJ6kZs3RqKIW6gOkL/tNMvfK0tKkK6');

-- ── Seed: departments ─────────────────────────────────────────
INSERT IGNORE INTO departments (name) VALUES
    ('HR'), ('IT'), ('Finance'), ('Marketing'), ('Operations');