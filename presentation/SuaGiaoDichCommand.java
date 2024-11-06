package doAnQuanLyGiaoDichNhaDat.presentation;

import doAnQuanLyGiaoDichNhaDat.domain.TransactionService;
import doAnQuanLyGiaoDichNhaDat.domain.model.Transaction;

public class SuaGiaoDichCommand extends TransactionCommand {
    private Transaction transactionRemote;

    public SuaGiaoDichCommand(TransactionService transactionServiceRemote,Transaction transactionRemote) {
        super(transactionServiceRemote);
        this.transactionRemote = transactionRemote;
    }

    @Override
    public void execute() {
        transactionServiceRemote.suaGiaoDich(transactionRemote);
    }
}
