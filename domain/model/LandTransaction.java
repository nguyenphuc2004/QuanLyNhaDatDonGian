package doAnQuanLyGiaoDichNhaDat.domain.model;

import java.util.Date;

public class LandTransaction extends Transaction {
    private String loaiDat;

    public LandTransaction(int maGiaoDich, Date ngay, double donGia, double dienTich, String loaiDat) {
        super(maGiaoDich, ngay, donGia, dienTich);
        this.loaiDat = loaiDat;
    }

    public String getLoaiDat() {
        return loaiDat;
    }

    public void setLoaiDat(String loaiDat) {
        this.loaiDat = loaiDat;
    }

    @Override
    public double thanhTien() {
        if (loaiDat == "A") {
            return getDienTich() * getDonGia() * 1.5;
        } else {
            return getDienTich() * getDonGia();
        }
    }

}
