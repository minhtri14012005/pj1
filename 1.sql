-- ==========================================
-- 1. NHÓM BẢNG QUẢN LÝ TÀI KHOẢN & PHÂN QUYỀN
-- ==========================================

-- Bảng Vai trò (Roles)
CREATE TABLE VaiTro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ten_vai_tro VARCHAR(50) NOT NULL UNIQUE -- Sẽ lưu giá trị như: 'ROLE_MANAGER', 'ROLE_STAFF'
);

-- Bảng Người dùng (Users)
CREATE TABLE NguoiDung (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ten_dang_nhap VARCHAR(50) NOT NULL UNIQUE,
    mat_khau VARCHAR(255) NOT NULL, -- Mật khẩu nên được mã hóa (VD: BCrypt) bởi Spring Boot
    ho_ten VARCHAR(100),
    vai_tro_id INT,
    trang_thai BOOLEAN DEFAULT TRUE, -- TRUE là đang hoạt động
    FOREIGN KEY (vai_tro_id) REFERENCES VaiTro(id)
);


-- ==========================================
-- 2. NHÓM BẢNG THỰC ĐƠN & NGUYÊN LIÊU
-- ==========================================

-- Bảng Nguyên liệu thô (Ingredients)
CREATE TABLE NguyenLieu (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ten_nguyen_lieu VARCHAR(100) NOT NULL,
    don_vi_tinh VARCHAR(20) NOT NULL, -- VD: gram, kg, lit
    so_luong_ton_kho FLOAT DEFAULT 0
);

-- Bảng Món ăn (Menu)
CREATE TABLE MonAn (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ten_mon_an VARCHAR(100) NOT NULL,
    gia_ban DECIMAL(10, 2) NOT NULL,
    trang_thai_phuc_vu BOOLEAN DEFAULT TRUE
);

-- Bảng Định lượng (BOM) - Dùng để quy đổi từ món ăn ra nguyên liệu
CREATE TABLE DinhLuong (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mon_an_id INT,
    nguyen_lieu_id INT,
    so_luong_can_thiet FLOAT NOT NULL, -- VD: 250(g) thịt gà cho 1 phần Gà nướng[cite: 1]
    FOREIGN KEY (mon_an_id) REFERENCES MonAn(id),
    FOREIGN KEY (nguyen_lieu_id) REFERENCES NguyenLieu(id)
);


-- ==========================================
-- 3. NHÓM BẢNG LỊCH SỬ BÁN HÀNG (DỮ LIỆU CHO AI)
-- ==========================================

-- Bảng Đơn hàng (Orders) - Lưu bối cảnh thời gian, thời tiết[cite: 1]
CREATE TABLE DonHang (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nguoi_tao_id INT, -- Liên kết để biết nhân viên nào tạo đơn
    thoi_gian_tao DATETIME DEFAULT CURRENT_TIMESTAMP,
    tong_tien DECIMAL(12, 2) NOT NULL,
    thoi_tiet VARCHAR(50), -- VD: rainy, sunny - rất hữu ích cho AI[cite: 1]
    la_ngay_le BOOLEAN DEFAULT FALSE, -- Đánh dấu ngày lễ[cite: 1]
    FOREIGN KEY (nguoi_tao_id) REFERENCES NguoiDung(id)
);

-- Bảng Chi tiết đơn hàng (Order Details)
CREATE TABLE ChiTietDonHang (
    id INT AUTO_INCREMENT PRIMARY KEY,
    don_hang_id INT,
    mon_an_id INT,
    so_luong_ban INT NOT NULL,
    don_gia DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (don_hang_id) REFERENCES DonHang(id),
    FOREIGN KEY (mon_an_id) REFERENCES MonAn(id)
);