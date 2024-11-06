package doAnQuanLyGiaoDichNhaDat.presentation;

import doAnQuanLyGiaoDichNhaDat.domain.TransactionService;

public abstract class TransactionCommand {
    protected TransactionService transactionServiceRemote;

    public TransactionCommand(TransactionService transactionServiceRemote) {
        this.transactionServiceRemote = transactionServiceRemote;
    }

    public abstract void execute();
}