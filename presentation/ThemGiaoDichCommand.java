package doAnQuanLyGiaoDichNhaDat.presentation;

import doAnQuanLyGiaoDichNhaDat.domain.TransactionService;
import doAnQuanLyGiaoDichNhaDat.domain.model.Transaction;

public class ThemGiaoDichCommand extends TransactionCommand {
    private Transaction transactionRemote;

    public ThemGiaoDichCommand(TransactionService transactionServiceRemote,Transaction transactionRemote) {
        super(transactionServiceRemote);
        this.transactionRemote = transactionRemote;
    }

    @Override
    public void execute() {
        transactionServiceRemote.themGiaoDich(transactionRemote);
    }
}
