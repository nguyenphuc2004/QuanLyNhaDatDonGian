package doAnQuanLyGiaoDichNhaDat.domain.model;

import java.util.Date;

public class HouseTransaction extends Transaction {
    private String loaiNha;
    private String diaChi;

    public HouseTransaction(int maGiaoDich, Date ngay, double donGia, double dienTich, String loaiNha, String diaChi) {
        super(maGiaoDich, ngay, donGia, dienTich);
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
    }

    public String getLoaiNha() {
        return loaiNha;
    }

    public void setLoaiNha(String loaiNha) {
        this.loaiNha = loaiNha;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public double thanhTien() {
        if (loaiNha == "cao cấp") {
            return getDienTich() * getDonGia();
        } else {
            return getDienTich() * getDonGia() * 0.9;
        }
    }

}
