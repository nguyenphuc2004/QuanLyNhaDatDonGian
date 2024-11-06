package doAnQuanLyGiaoDichNhaDat.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import doAnQuanLyGiaoDichNhaDat.domain.TransactionService;
import doAnQuanLyGiaoDichNhaDat.domain.model.Transaction;

import java.awt.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import doAnQuanLyGiaoDichNhaDat.presentation.TransactionCommand;

public class TransactionController implements ActionListener {

    private static TransactionController instance;
    private TransactionManagementUI transactionManagementUIRemote;
    private TransactionService transactionServiceRemote;
    private TransactionCommand commandRemote;

    public TransactionController(TransactionManagementUI transactionManagementUIRemote,
            TransactionService transactionServiceRemote) {
        this.transactionManagementUIRemote = transactionManagementUIRemote;
        this.transactionServiceRemote = transactionServiceRemote;
    }

    public static TransactionController makeTransactionController() {
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        TransactionCommand commandRemote;
        switch (command) {
            case "Làm mới":

            // Gọi phương thức để thêm giao dịch mới

            transactionManagementUIRemote.clearFieldsAndComboBoxes();
                transactionManagementUIRemote.loadTableData();
                System.out.println( transactionManagementUIRemote.clearFieldsAndComboBoxes());
           
            break;
            case "Thêm":

                // Gọi phương thức để thêm giao dịch mới
                Transaction transaction = transactionManagementUIRemote.getNewTransaction();
                if (transaction != null) {
                    commandRemote = new ThemGiaoDichCommand(transactionServiceRemote, transaction);
                    this.execute2(commandRemote);
                    JOptionPane.showMessageDialog(null, "Thêm Thành Công");
                    transactionManagementUIRemote.loadTableData();
                    transactionManagementUIRemote.clearFieldsAndComboBoxes();
                } else {
                    JOptionPane.showMessageDialog(transactionManagementUIRemote, "LỖi");
                }
                break;
            case "Xóa":
                // Gọi phương thức để xóa giao dịch
                int selectedRow = transactionManagementUIRemote.getTransactionIdToDelete();
                commandRemote = new XoaGiaoDichCommand(transactionServiceRemote, selectedRow);
                this.execute2(commandRemote);
                transactionManagementUIRemote.loadTableData();

                break;
            case "Sửa":
                // Gọi phương thức để sửa giao dịch
                Transaction updatedTransaction = transactionManagementUIRemote.getUpdatedTransaction();
                if(updatedTransaction!=null){
                commandRemote = new SuaGiaoDichCommand(transactionServiceRemote, updatedTransaction);
                this.execute2(commandRemote);
                transactionManagementUIRemote.loadTableData();
                transactionManagementUIRemote.clearFieldsAndComboBoxes();
                }else JOptionPane.showMessageDialog(null, "điền đúng và đầy đủ thông tin ");
                break;
            case "Tìm Kiếm":
                // Gọi phương thức để tìm kiếm giao dịch
                String keyword = transactionManagementUIRemote.getSearchKeywordid();
                commandRemote = new TimKiemGiaoDichCommand(transactionServiceRemote, Integer.parseInt(keyword));
                this.execute2(commandRemote);
                transactionManagementUIRemote.loadTableDatatoID(Integer.parseInt(keyword));
                break;
            case "Xuất":
                // Gọi phương thức để xuất giao dịch
                String month = transactionManagementUIRemote.getSearchKeyword();
                commandRemote = new LayGiaoDichThangCommand(month, transactionServiceRemote);
                this.execute2(commandRemote);
                transactionManagementUIRemote.loadTableDatatoMonth(month);
                break;
            case "Tính tổng":
                // Gọi phương thức để tính tổng
                String montha = transactionManagementUIRemote.loai();
                commandRemote = new TinhTongSLTungLoaiCommand(transactionServiceRemote, montha);

                this.execute2(commandRemote);
                transactionManagementUIRemote.loadtextfiled();

                break;
            case "Tính trung bình":
                // Gọi phương thức để tính trung bình
                commandRemote = new TrungBinhThanhTienGDDatCommand(transactionServiceRemote);
                this.execute2(commandRemote);
                transactionManagementUIRemote.loadtextfiled1();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Lệnh không hợp lệ: " + command);
                break;
        }
    }

    public void execute2(TransactionCommand command) {
        command.execute();
    }

   
   

    
}