package doAnQuanLyGiaoDichNhaDat.presentation;

import doAnQuanLyGiaoDichNhaDat.domain.TransactionService;

public class TinhTongSLTungLoaiCommand extends TransactionCommand {
    private String loaigd;

    public TinhTongSLTungLoaiCommand(TransactionService transactionServiceRemote, String loaigd) {
        super(transactionServiceRemote);
        this.loaigd = loaigd;
    }

    @Override
    public void execute() {
        transactionServiceRemote.tinhTongSLTungLoai(loaigd);
    }
}