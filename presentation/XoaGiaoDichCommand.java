package doAnQuanLyGiaoDichNhaDat.presentation;

import doAnQuanLyGiaoDichNhaDat.domain.TransactionService;

public class XoaGiaoDichCommand extends TransactionCommand {
    private int maGiaoDich;

    public XoaGiaoDichCommand(TransactionService transactionServiceRemote, int maGiaoDich) {
        super(transactionServiceRemote);
        this.maGiaoDich = maGiaoDich;
    }

    @Override
    public void execute() {
        transactionServiceRemote.xoaGiaoDich(maGiaoDich);
    }
}
