package doAnQuanLyGiaoDichNhaDat.presentation;

import doAnQuanLyGiaoDichNhaDat.domain.TransactionService;

public class LayGiaoDichThangCommand extends TransactionCommand {
    private String month;

    public LayGiaoDichThangCommand(String month, TransactionService transactionServiceRemote) {
        super(transactionServiceRemote);
        this.month = month;

    }

    @Override
    public void execute() {
        transactionServiceRemote.xuatGiaoDichTheoThang(month);
    }
}
