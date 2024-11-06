package doAnQuanLyGiaoDichNhaDat.presentation;

import doAnQuanLyGiaoDichNhaDat.domain.TransactionService;

public class TimKiemGiaoDichCommand extends TransactionCommand {
    private int maGiaoDich;

    public TimKiemGiaoDichCommand(TransactionService transactionServiceRemote, int maGiaoDich) {
        super(transactionServiceRemote);
        this.maGiaoDich = maGiaoDich;
    }

    @Override
    public void execute() {
        transactionServiceRemote.timKiemGiaoDich(maGiaoDich);
    }
}
