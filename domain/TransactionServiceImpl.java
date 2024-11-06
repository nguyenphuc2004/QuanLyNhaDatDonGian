package doAnQuanLyGiaoDichNhaDat.domain;

import java.util.ArrayList;
import java.util.List;

import doAnQuanLyGiaoDichNhaDat.domain.model.LandTransaction;
import doAnQuanLyGiaoDichNhaDat.domain.model.Transaction;
import doAnQuanLyGiaoDichNhaDat.persistence.TransactionPersistenceService;

public class TransactionServiceImpl extends Publisher implements TransactionService {
    private TransactionPersistenceService transactionPersistenceServiceRemote;

    public TransactionServiceImpl(TransactionPersistenceService transactionPersistenceServiceRemote) {
        this.transactionPersistenceServiceRemote = transactionPersistenceServiceRemote;

    }

    @Override
    public void themGiaoDich(Transaction transaction) {
        transactionPersistenceServiceRemote.themGiaoDich(transaction);
        changeState();
    }

    @Override
    public void xoaGiaoDich(int maGiaoDich) {
        transactionPersistenceServiceRemote.xoaGiaoDich(maGiaoDich);
        changeState();
    }

    @Override
    public void suaGiaoDich(Transaction transaction) {
        transactionPersistenceServiceRemote.suaGiaoDich(transaction);
        changeState();
    }

    @Override
    public List<Transaction> timKiemGiaoDich(int maGiaoDich) {
        return transactionPersistenceServiceRemote.timKiemGiaoDich(maGiaoDich);
    }

    @Override
    public double tinhTBTTGDD() {
        return transactionPersistenceServiceRemote.tinhTBTTGDD();
    }

    @Override
    public int tinhTongSLTungLoai(String loaigd) {
        return transactionPersistenceServiceRemote.tinhTongSLTungLoai(loaigd);

    }

    @Override
    public List<Transaction> xuatGiaoDichTheoThang(String month) {
        return transactionPersistenceServiceRemote.xuatGiaoDichTheoThang(month);
    }

    @Override
    public List<Transaction> loadTatCaGiaoDich() {
        return transactionPersistenceServiceRemote.loadTatCaGiaoDich();
    }

    private void changeState() {
        notifySubscribers();
    }

}
