package doAnQuanLyGiaoDichNhaDat.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import doAnQuanLyGiaoDichNhaDat.domain.model.HouseTransaction;
import doAnQuanLyGiaoDichNhaDat.domain.model.LandTransaction;
import doAnQuanLyGiaoDichNhaDat.domain.model.Transaction;

public class TransactionPersistenceServiceImpl implements TransactionPersistenceService {
    private Connection connection;

    public TransactionPersistenceServiceImpl() throws ClassNotFoundException {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void themGiaoDich(Transaction transaction) {
        String sql = "INSERT INTO GiaoDich (NgayGiaoDich, DonGia, LoaiDat, LoaiNha, DiaChi, DienTich, ThanhTien) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDate(1, new java.sql.Date(transaction.getNgay().getTime()));
            pstmt.setDouble(2, transaction.getDonGia());
            if (transaction instanceof LandTransaction) {
                pstmt.setString(3, ((LandTransaction) transaction).getLoaiDat());
                pstmt.setNull(4, Types.VARCHAR);
                pstmt.setNull(5, Types.VARCHAR);
            } else if (transaction instanceof HouseTransaction) {
                pstmt.setNull(3, Types.VARCHAR);
                pstmt.setString(4, ((HouseTransaction) transaction).getLoaiNha());
                pstmt.setString(5, ((HouseTransaction) transaction).getDiaChi());
            }
            pstmt.setDouble(6, transaction.getDienTich());
            pstmt.setDouble(7, transaction.thanhTien());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoaGiaoDich(int maGiaoDich) {
        String sql = "DELETE FROM GiaoDich WHERE MaGD = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, maGiaoDich);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void suaGiaoDich(Transaction transaction) {
        String sql = "UPDATE GiaoDich SET NgayGiaoDich = ?, DonGia = ?, LoaiDat = ?, LoaiNha = ?, DiaChi = ?, DienTich = ?, ThanhTien = ? WHERE MaGD = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDate(1, new java.sql.Date(transaction.getNgay().getTime()));
            pstmt.setDouble(2, transaction.getDonGia());
            if (transaction instanceof LandTransaction) {
                pstmt.setString(3, ((LandTransaction) transaction).getLoaiDat());
                pstmt.setNull(4, Types.VARCHAR);
                pstmt.setNull(5, Types.VARCHAR);
            } else if (transaction instanceof HouseTransaction) {
                pstmt.setNull(3, Types.VARCHAR);
                pstmt.setString(4, ((HouseTransaction) transaction).getLoaiNha());
                pstmt.setString(5, ((HouseTransaction) transaction).getDiaChi());
            }
            pstmt.setDouble(6, transaction.getDienTich());
            pstmt.setDouble(7, transaction.thanhTien());
            pstmt.setInt(8, transaction.getMaGiaoDich());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transaction> timKiemGiaoDich(int maGiaoDich) {
        String sql = "SELECT * FROM GiaoDich WHERE MaGD = ?";
        List<Transaction> transactions = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, maGiaoDich);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Date ngay = rs.getDate("NgayGiaoDich");
                double donGia = rs.getDouble("DonGia");
                double dienTich = rs.getDouble("DienTich");
                if (rs.getString("LoaiDat") != null) {
                    LandTransaction transaction = new LandTransaction(maGiaoDich, (java.sql.Date) ngay, donGia,
                            dienTich, rs.getString("LoaiDat"));
                    transactions.add(transaction);
                } else {
                    HouseTransaction transaction = new HouseTransaction(maGiaoDich, (java.sql.Date) ngay, donGia,
                            dienTich, rs.getString("LoaiNha"), rs.getString("DiaChi"));
                    transactions.add(transaction);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    @Override
    public double tinhTBTTGDD() {
        String sql = "SELECT AVG(ThanhTien) FROM GiaoDich WHERE LoaiDat IN ('A', 'B', 'C');";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int tinhTongSLTungLoai(String loaigd) {
        String sql;
        if ("Tổng số lượng loại đất".equals(loaigd)) {
            // Câu lệnh SQL để đếm số lượng giao dịch theo loại đất
            sql = "SELECT COUNT(*) FROM GiaoDich WHERE LoaiDat IN ('A', 'B', 'C')";
        } else if ("Tổng số lượng loại nhà".equals(loaigd)) {
            // Câu lệnh SQL để đếm số lượng giao dịch theo loại nhà
            sql = "SELECT COUNT(*) FROM GiaoDich WHERE LoaiNha IN ('cao cấp', 'thường')";
        } else {
            // Trả về 0 nếu loại giao dịch không hợp lệ
            return 0;
        }

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Transaction> xuatGiaoDichTheoThang(String month) {
        String sql = "SELECT * FROM GiaoDich WHERE MONTH(NgayGiaoDich) = ?";
        List<Transaction> transactions = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, month);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int maGiaoDich = rs.getInt("MaGD");
                Date ngay = rs.getDate("NgayGiaoDich");
                double donGia = rs.getDouble("DonGia");
                double dienTich = rs.getDouble("DienTich");
                if (rs.getString("LoaiDat") != null) {
                    LandTransaction transaction = new LandTransaction(maGiaoDich, (java.sql.Date) ngay, donGia,
                            dienTich, rs.getString("LoaiDat"));
                    transactions.add(transaction);
                } else {
                    HouseTransaction transaction = new HouseTransaction(maGiaoDich, (java.sql.Date) ngay, donGia,
                            dienTich, rs.getString("LoaiNha"), rs.getString("DiaChi"));
                    transactions.add(transaction);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    @Override
    public List<Transaction> loadTatCaGiaoDich() {
        String sql = "SELECT * FROM GiaoDich";
        List<Transaction> transactions = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int maGiaoDich = rs.getInt("MaGD");
                Date ngay = rs.getDate("NgayGiaoDich");
                double donGia = rs.getDouble("DonGia");
                double dienTich = rs.getDouble("DienTich");

                if (rs.getString("LoaiDat") != null) {
                    // Giao dịch đất
                    LandTransaction transaction = new LandTransaction(
                            maGiaoDich,
                            (java.sql.Date) ngay,
                            donGia,
                            dienTich,
                            rs.getString("LoaiDat"));
                    transactions.add(transaction);
                } else if (rs.getString("LoaiNha") != null) {
                    // Giao dịch nhà
                    HouseTransaction transaction = new HouseTransaction(
                            maGiaoDich,
                            (java.sql.Date) ngay,
                            donGia,
                            dienTich,
                            rs.getString("LoaiNha"),
                            rs.getString("DiaChi"));
                    transactions.add(transaction);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
