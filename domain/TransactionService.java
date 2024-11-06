package doAnQuanLyGiaoDichNhaDat.domain;

import java.util.List;

import doAnQuanLyGiaoDichNhaDat.domain.model.Transaction;

public interface TransactionService {
    public void themGiaoDich(Transaction transaction);

    public void xoaGiaoDich(int maGiaoDich);

    public void suaGiaoDich(Transaction transaction);

    public List<Transaction> timKiemGiaoDich(int maGiaoDich);

    public double tinhTBTTGDD();

    public int tinhTongSLTungLoai(String loaigd);

    public List<Transaction> xuatGiaoDichTheoThang(String month);

    List<Transaction> loadTatCaGiaoDich();
}
