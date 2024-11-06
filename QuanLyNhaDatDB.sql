use dbGDnhadat;

CREATE TABLE GiaoDich (
    MaGD INT AUTO_INCREMENT PRIMARY KEY,
    NgayGiaoDich DATE NULL,
    DonGia DECIMAL(10, 2) NULL,
    LoaiDat ENUM('A', 'B', 'C') NUll,
    LoaiNha ENUM('cao cấp', 'thường') NULL,
    DiaChi VARCHAR(255)  NULL,
    DienTich DECIMAL(10, 2) NULL,
    ThanhTien INT NULL
);

INSERT INTO GiaoDich (NgayGiaoDich, DonGia, LoaiDat, DienTich,ThanhTien)
VALUES
    ('2022-01-01', 5000, 'A', 100,5000*100),
    ('2021-01-02', 4000, 'B', 200,800000),
    ('2024-07-03', 3000, 'C', 300,900000),
    ('2024-07-04', 6000, 'A', 150,6000*150),
    ('2024-07-05', 3500, 'B', 250,3500*2500);

INSERT INTO GiaoDich (NgayGiaoDich, DonGia, LoaiNha, DiaChi, DienTich)
VALUES
    ('2024-07-06', 8000, 'cao cấp', '123 Main St', 100),
    ('2024-07-07', 7000, 'thường', '456 Elm St', 150),
    ('2024-07-08', 7500, 'cao cấp', '789 Oak St', 120),
    ('2024-07-09', 6800, 'thường', '321 Pine St', 160),
    ('2024-07-10', 8200, 'cao cấp', '654 Maple St', 110);


 