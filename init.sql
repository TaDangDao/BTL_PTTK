-- Tạo database nếu chưa có
CREATE DATABASE IF NOT EXISTS vehicle_db;
USE vehicle_db;

-- Staff
CREATE TABLE IF NOT EXISTS staff (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    pass VARCHAR(255) NOT NULL
);
INSERT IGNORE INTO staff (username, password)
VALUES ('admin', 'admin123');
-- ChuXe
CREATE TABLE IF NOT EXISTS chuxe (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ten VARCHAR(255) NOT NULL,
    ngaySinh DATE NOT NULL,
    diaChi VARCHAR(255) NOT NULL
);

--  Xe
CREATE TABLE IF NOT EXISTS xe (
    bienSo VARCHAR(255),
    ngayDangKy DATE NOT NULL,
    id INT AUTO_INCREMENT PRIMARY KEY,
    tinhTrang VARCHAR(255),
    chuXeId INT NOT NULL,
    FOREIGN KEY (chuXeId) REFERENCES chuxe(id) ON DELETE CASCADE
);
