package doAnQuanLyGiaoDichNhaDat.presentation;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import doAnQuanLyGiaoDichNhaDat.domain.TransactionService;
import doAnQuanLyGiaoDichNhaDat.domain.TransactionServiceImpl;
import doAnQuanLyGiaoDichNhaDat.domain.model.HouseTransaction;
import doAnQuanLyGiaoDichNhaDat.domain.model.LandTransaction;
import doAnQuanLyGiaoDichNhaDat.domain.model.Transaction;
import doAnQuanLyGiaoDichNhaDat.persistence.TransactionPersistenceService;
import doAnQuanLyGiaoDichNhaDat.persistence.TransactionPersistenceServiceImpl;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class TransactionManagementUI extends JFrame {
    private JPanel paneRemote;

    private JTextField textField, textField_1, textField_2, txtDienTichRemote, txtDiaChiRemote, txtDonGiaRemote,
            txtNgayGiaoDichRemote;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private JTable tableRemote;
    private JComboBox<String> CBloaiGDRemote, CBloaiNhaRemote, CBloaiDatRemote, CBThangRemote, CBloaiRemote;

    private JButton btnAdd, btnDelete, btnEdit, btnExport, btnSearch, btnTotal, btnAverage,btnRefresh;

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JTextField getTextField_1() {
        return textField_1;
    }

    public void setTextField_1(JTextField textField_1) {
        this.textField_1 = textField_1;
    }

    public JTextField getTextField_2() {
        return textField_2;
    }

    public void setTextField_2(JTextField textField_2) {
        this.textField_2 = textField_2;
    }

    public JTextField getTxtDienTichRemote() {
        return txtDienTichRemote;
    }

    public void setTxtDienTichRemote(JTextField txtDienTichRemote) {
        this.txtDienTichRemote = txtDienTichRemote;
    }

    public JTextField getTxtDiaChiRemote() {
        return txtDiaChiRemote;
    }

    public void setTxtDiaChiRemote(JTextField txtDiaChiRemote) {
        this.txtDiaChiRemote = txtDiaChiRemote;
    }

    public JTextField getTxtDonGiaRemote() {
        return txtDonGiaRemote;
    }

    public void setTxtDonGiaRemote(JTextField txtDonGiaRemote) {
        this.txtDonGiaRemote = txtDonGiaRemote;
    }

    public JTextField getTxtNgayGiaoDichRemote() {
        return txtNgayGiaoDichRemote;
    }

    public void setTxtNgayGiaoDichRemote(JTextField txtNgayGiaoDichRemote) {
        this.txtNgayGiaoDichRemote = txtNgayGiaoDichRemote;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JButton getBtnExport() {
        return btnExport;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JButton getBtnTotal() {
        return btnTotal;
    }

    public JButton getBtnAverage() {
        return btnAverage;
    }

    TransactionController transactionControllerRemote;
    TransactionService transactionServiceRemote;

    public TransactionManagementUI(TransactionController transactionControllerRemote,
            TransactionService transactionServiceRemote) {
        this.transactionControllerRemote = transactionControllerRemote;
        this.transactionServiceRemote = transactionServiceRemote;
        setTitle("Transaction App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1500, 1500);
        setLocationRelativeTo(null);

        paneRemote = new JPanel();
        paneRemote.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(paneRemote);
        paneRemote.setLayout(null);

        JPanel mainPanelRemote = new JPanel();
        // mainPanelRemote.setBackground(new Color(46, 139, 87));
        mainPanelRemote.setBounds(0, 0, 1500, 1500);
        paneRemote.add(mainPanelRemote);
        mainPanelRemote.setLayout(null);

        JPanel inputPanelRemote = new JPanel();
        inputPanelRemote.setLayout(null);
        inputPanelRemote.setBounds(93, 10, 395, 320);
        mainPanelRemote.add(inputPanelRemote);

        JLabel dateLabelRemote = new JLabel("Ngày Giao Dịch");
        dateLabelRemote.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        dateLabelRemote.setBounds(10, 55, 108, 24);
        inputPanelRemote.add(dateLabelRemote);

        txtNgayGiaoDichRemote = new JTextField();
        txtNgayGiaoDichRemote.setColumns(10);
        txtNgayGiaoDichRemote.setBounds(133, 55, 145, 24);
        inputPanelRemote.add(txtNgayGiaoDichRemote);

        txtDonGiaRemote = new JTextField();
        txtDonGiaRemote.setColumns(10);
        txtDonGiaRemote.setBounds(133, 99, 145, 24);
        inputPanelRemote.add(txtDonGiaRemote);

        JLabel donGiaLabel_1_1 = new JLabel("Đơn Giá");
        donGiaLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        donGiaLabel_1_1.setBounds(10, 99, 108, 24);
        inputPanelRemote.add(donGiaLabel_1_1);

        JLabel loaiDatLabel_1 = new JLabel("Loại Đất");
        loaiDatLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        loaiDatLabel_1.setBounds(10, 147, 108, 24);
        inputPanelRemote.add(loaiDatLabel_1);

        txtDienTichRemote = new JTextField();
        txtDienTichRemote.setColumns(10);
        txtDienTichRemote.setBounds(133, 276, 145, 24);
        inputPanelRemote.add(txtDienTichRemote);

        JLabel dienTichLabel_1 = new JLabel("Diện Tích");
        dienTichLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        dienTichLabel_1.setBounds(10, 276, 108, 24);
        inputPanelRemote.add(dienTichLabel_1);

        CBloaiDatRemote = new JComboBox<>();
        CBloaiDatRemote.addItem("A");
        CBloaiDatRemote.addItem("B");
        CBloaiDatRemote.addItem("C");
        CBloaiDatRemote.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        CBloaiDatRemote.setBounds(133, 146, 145, 24);
        CBloaiDatRemote.setSelectedIndex(-1);

        inputPanelRemote.add(CBloaiDatRemote);

        JLabel loaiGDLabel_1 = new JLabel("Loại Giao Dịch");
        loaiGDLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        loaiGDLabel_1.setBounds(10, 10, 108, 24);
        inputPanelRemote.add(loaiGDLabel_1);

        CBloaiGDRemote = new JComboBox<>();
        CBloaiGDRemote.addItem("House");
        CBloaiGDRemote.addItem("Land");
        CBloaiGDRemote.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        CBloaiGDRemote.setBounds(133, 9, 145, 24);
        CBloaiGDRemote.setSelectedIndex(-1);
        inputPanelRemote.add(CBloaiGDRemote);

        JLabel loaiNhaLabel_1 = new JLabel("Loại Nhà");
        loaiNhaLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        loaiNhaLabel_1.setBounds(10, 194, 108, 24);
        inputPanelRemote.add(loaiNhaLabel_1);

        CBloaiNhaRemote = new JComboBox<>();
        CBloaiNhaRemote.addItem("cao cấp");
        CBloaiNhaRemote.addItem("thường");
        CBloaiNhaRemote.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        CBloaiNhaRemote.setBounds(133, 194, 145, 24);
        CBloaiNhaRemote.setSelectedIndex(-1);
        inputPanelRemote.add(CBloaiNhaRemote);

        JLabel diaChiLabel_1 = new JLabel("Địa Chỉ");
        diaChiLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        diaChiLabel_1.setBounds(10, 235, 108, 24);
        inputPanelRemote.add(diaChiLabel_1);

        txtDiaChiRemote = new JTextField();
        txtDiaChiRemote.setColumns(10);
        txtDiaChiRemote.setBounds(133, 235, 145, 24);
        inputPanelRemote.add(txtDiaChiRemote);

        JPanel tablePanel = new JPanel();
        tablePanel.setBounds(10, 340, 900, 300);
        mainPanelRemote.add(tablePanel);

        // Column names
        String[] columnNames = { "Mã Giao Dịch", "Ngày giao dịch", "Đơn giá", "Loại đất", "Loại nhà", "Địa chỉ",
                "Diện tích", "Thành tiền" };

        // Initialize table model with column names and no initial rows
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Initialize table and set model
        tableRemote = new JTable();
        tableRemote.setModel(model);
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(new JScrollPane(tableRemote), BorderLayout.CENTER); // Add JScrollPane for better view

        // Adjust column widths to fit table width
        tableRemote.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        btnRefresh = new JButton("Làm mới");
        btnRefresh.setBounds(0, 640, 95, 63);
        mainPanelRemote.add(btnRefresh);

        // Adding new buttons and text fields
        btnAdd = new JButton("Thêm");
        btnAdd.setBounds(100, 640, 85, 63);
        mainPanelRemote.add(btnAdd);

        btnDelete = new JButton("Xóa");
        btnDelete.setBounds(200, 640, 85, 63);
        mainPanelRemote.add(btnDelete);

        btnEdit = new JButton("Sửa");
        btnEdit.setBounds(300, 640, 85, 63);
        mainPanelRemote.add(btnEdit);

        btnSearch = new JButton("Tìm Kiếm");
        btnSearch.setBounds(500, 640, 105, 63);
        mainPanelRemote.add(btnSearch);

        btnExport = new JButton("Xuất");
        btnExport.setBounds(400, 640, 85, 63);
        mainPanelRemote.add(btnExport);

        btnTotal = new JButton("Tính tổng");
        btnTotal.setBounds(625, 640, 105, 63);
        mainPanelRemote.add(btnTotal);

        btnAverage = new JButton("Tính trung bình");
        btnAverage.setBounds(750, 640, 135, 63);
        mainPanelRemote.add(btnAverage);

        // Text của Tìm Kieem
        // textField = new JTextField();
        // textField.setBounds(559, 79, 239, 52);
        // mainPanelRemote.add(textField);
        // textField.setColumns(10);

        
        //
        // JLabel tiemkiemJLabel = new JLabel("id tìm kiếm");
        // tiemkiemJLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        // tiemkiemJLabel.setBounds(660, 79, 100, 52);
        // mainPanelRemote.add(tiemkiemJLabel);

        // textField_1 = new JTextField();
        // textField_1.setColumns(10);
        // textField_1.setBounds(559, 155, 239, 51);
        // mainPanelRemote.add(textField_1);

        CBThangRemote = new JComboBox<>();
        CBThangRemote.addItem("1");
        CBThangRemote.addItem("2");
        CBThangRemote.addItem("3");
        CBThangRemote.addItem("4");
        CBThangRemote.addItem("5");
        CBThangRemote.addItem("6");
        CBThangRemote.addItem("7");
        CBThangRemote.addItem("8");
        CBThangRemote.addItem("9");
        CBThangRemote.addItem("10");
        CBThangRemote.addItem("11");
        CBThangRemote.addItem("12");
        CBThangRemote.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        CBThangRemote.setBounds(559, 120, 239, 51);
        CBThangRemote.setSelectedIndex(-1);
        mainPanelRemote.add(CBThangRemote);

        JLabel thanglJLabel = new JLabel("Hãy chọn tháng mà bạn muốn xuất");
        thanglJLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        thanglJLabel.setBounds(559, 79, 239, 52);
        mainPanelRemote.add(thanglJLabel);

        // textField_2 = new JTextField();
        // textField_2.setColumns(10);
        // textField_2.setBounds(559, 227, 239, 52);
        // mainPanelRemote.add(textField_2);
        CBloaiRemote = new JComboBox<>();
        CBloaiRemote.addItem("Tổng số lượng loại đất");
        CBloaiRemote.addItem("Tổng số lượng loại nhà");
        CBloaiRemote.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        CBloaiRemote.setBounds(559, 227, 239, 52);
        CBloaiRemote.setSelectedIndex(-1);
        mainPanelRemote.add(CBloaiRemote);

        JLabel loaigdJLabel = new JLabel("Hãy chọn loại giao dịch mà bạn muốn tính tổng");
        loaigdJLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        loaigdJLabel.setBounds(559, 186, 270, 52);
        mainPanelRemote.add(loaigdJLabel);

        txtNgayGiaoDichRemote.setEditable(false);
        txtDonGiaRemote.setEditable(false);
        txtDiaChiRemote.setEditable(false);
        txtDienTichRemote.setEditable(false);
        CBloaiGDRemote.setEditable(false);
        CBloaiDatRemote.setEditable(false);
        loadTableData();
        CBloaiGDRemote.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                comboboxLoaiGD();
            }

        });

        // textField_1.setEditable(true);
        // textField_2.setEditable(false);
        loadTableData1();
    }

    public boolean clearFieldsAndComboBoxes() {
        // Xóa các trường văn bản
        textField.setText("");
        txtDienTichRemote.setText("");
        txtDiaChiRemote.setText("");
        txtDonGiaRemote.setText("");
        txtNgayGiaoDichRemote.setText("");

        // Đặt combobox về trạng thái rỗng
        CBloaiNhaRemote.setSelectedIndex(-1);
        CBloaiDatRemote.setSelectedIndex(-1);
        CBloaiGDRemote.setSelectedIndex(-1);
        CBThangRemote.setSelectedIndex(-1);
        CBloaiRemote.setSelectedIndex(-1);
        return true;

    }

    public void setTransactionController(TransactionController transactionController) {
        this.transactionControllerRemote = transactionController;
        btnAdd.addActionListener(transactionController);
        btnDelete.addActionListener(transactionController);
        btnEdit.addActionListener(transactionController);
        btnSearch.addActionListener(transactionController);
        btnExport.addActionListener(transactionController);
        btnTotal.addActionListener(transactionController);
        btnAverage.addActionListener(transactionController);
        btnRefresh.addActionListener(transactionController);
    }

    public void loadTableData1() {
        int selectedRow = tableRemote.getSelectedRow();
        if (selectedRow != -1) {
            // Lấy dữ liệu từ hàng được chọn
            int id = (int) tableRemote.getValueAt(selectedRow, 0);
            Date ngayGiaoDich = (Date) tableRemote.getValueAt(selectedRow, 1);
            float donGia = (float) tableRemote.getValueAt(selectedRow, 2);
            String loaiDat = (String) tableRemote.getValueAt(selectedRow, 3);
            String loaiNha = (String) tableRemote.getValueAt(selectedRow, 4);
            String diaChi = (String) tableRemote.getValueAt(selectedRow, 5);
            float dienTich = (float) tableRemote.getValueAt(selectedRow, 6);

            // Điền dữ liệu vào các trường
            txtNgayGiaoDichRemote.setText(new SimpleDateFormat("yyyy-MM-dd").format(ngayGiaoDich));
            txtDonGiaRemote.setText(String.valueOf(donGia));
            txtDiaChiRemote.setText(diaChi);
            txtDienTichRemote.setText(String.valueOf(dienTich));
            if (loaiDat != null && !loaiDat.isEmpty() && loaiNha == null) {
                CBloaiDatRemote.setSelectedItem(loaiDat);
                CBloaiGDRemote.setSelectedItem("Land");

            } else if (loaiNha != null && !loaiNha.isEmpty() && loaiDat == null) {
                CBloaiNhaRemote.setSelectedItem(loaiNha);
                CBloaiGDRemote.setSelectedItem("House");

            }
        }
    }

    public void loadTableDatatoID(int id) {
        // Lấy giao dịch từ dịch vụ
        List<Transaction> transactions = transactionServiceRemote.timKiemGiaoDich(id);

        // Xóa tất cả các hàng hiện tại trong bảng
        DefaultTableModel model = (DefaultTableModel) tableRemote.getModel();
        model.setRowCount(0);

        // Thêm dữ liệu mới vào bảng
        for (Transaction transaction : transactions) {
            Object[] rowData;
            if (transaction instanceof HouseTransaction) {
                HouseTransaction houseTransaction = (HouseTransaction) transaction;
                rowData = new Object[] {
                        houseTransaction.getMaGiaoDich(),
                        houseTransaction.getNgay(),
                        houseTransaction.getDonGia(),
                        "", // Loại đất không áp dụng cho giao dịch nhà
                        houseTransaction.getLoaiNha(),
                        houseTransaction.getDiaChi(),
                        houseTransaction.getDienTich(),
                        houseTransaction.thanhTien()
                };
            } else if (transaction instanceof LandTransaction) {
                LandTransaction landTransaction = (LandTransaction) transaction;
                rowData = new Object[] {
                        landTransaction.getMaGiaoDich(),
                        landTransaction.getNgay(),
                        landTransaction.getDonGia(),
                        landTransaction.getLoaiDat(),
                        "", // Loại nhà không áp dụng cho giao dịch đất
                        "", // Địa chỉ không áp dụng cho giao dịch đất
                        landTransaction.getDienTich(),
                        landTransaction.thanhTien()
                };
            } else {
                rowData = new Object[] { "", "", "", "", "", "", "", "" };
            }
            model.addRow(rowData);
        }
    }

    public void loadTableDatatoMonth(String x) {
        // Lấy giao dịch từ dịch vụ
        List<Transaction> transactions = transactionServiceRemote.xuatGiaoDichTheoThang(x);

        // Xóa tất cả các hàng hiện tại trong bảng
        DefaultTableModel model = (DefaultTableModel) tableRemote.getModel();
        model.setRowCount(0);

        // Thêm dữ liệu mới vào bảng
        for (Transaction transaction : transactions) {
            Object[] rowData;
            if (transaction instanceof HouseTransaction) {
                HouseTransaction houseTransaction = (HouseTransaction) transaction;
                rowData = new Object[] {
                        houseTransaction.getMaGiaoDich(),
                        houseTransaction.getNgay(),
                        houseTransaction.getDonGia(),
                        "", // Loại đất không áp dụng cho giao dịch nhà
                        houseTransaction.getLoaiNha(),
                        houseTransaction.getDiaChi(),
                        houseTransaction.getDienTich(),
                        houseTransaction.thanhTien()
                };
            } else if (transaction instanceof LandTransaction) {
                LandTransaction landTransaction = (LandTransaction) transaction;
                rowData = new Object[] {
                        landTransaction.getMaGiaoDich(),
                        landTransaction.getNgay(),
                        landTransaction.getDonGia(),
                        landTransaction.getLoaiDat(),
                        "", // Loại nhà không áp dụng cho giao dịch đất
                        "", // Địa chỉ không áp dụng cho giao dịch đất
                        landTransaction.getDienTich(),
                        landTransaction.thanhTien()
                };
            } else {
                rowData = new Object[] { "", "", "", "", "", "", "", "" };
            }
            model.addRow(rowData);
        }
    }

    public void loadTableData() {
        // Lấy tất cả giao dịch từ dịch vụ
        List<Transaction> transactions = transactionServiceRemote.loadTatCaGiaoDich();

        // Xóa tất cả các hàng hiện tại trong bảng
        DefaultTableModel model = (DefaultTableModel) tableRemote.getModel();
        model.setRowCount(0);

        // Thêm dữ liệu mới vào bảng
        for (Transaction transaction : transactions) {
            Object[] rowData;
            if (transaction instanceof HouseTransaction) {
                HouseTransaction houseTransaction = (HouseTransaction) transaction;
                rowData = new Object[] {
                        houseTransaction.getMaGiaoDich(),
                        houseTransaction.getNgay(),
                        houseTransaction.getDonGia(),
                        "", // Loại đất không áp dụng cho giao dịch nhà
                        houseTransaction.getLoaiNha(),
                        houseTransaction.getDiaChi(),
                        houseTransaction.getDienTich(),
                        houseTransaction.thanhTien()
                };
            } else if (transaction instanceof LandTransaction) {
                LandTransaction landTransaction = (LandTransaction) transaction;
                rowData = new Object[] {
                        landTransaction.getMaGiaoDich(),
                        landTransaction.getNgay(),
                        landTransaction.getDonGia(),
                        landTransaction.getLoaiDat(),
                        "", // Loại nhà không áp dụng cho giao dịch đất
                        "", // Địa chỉ không áp dụng cho giao dịch đất
                        landTransaction.getDienTich(),
                        landTransaction.thanhTien()
                };
            } else {
                rowData = new Object[] { "", "", "", "", "", "", "", "" };
            }
            model.addRow(rowData);
        }
    }

    public void exportTransaction() {

        transactionServiceRemote.xuatGiaoDichTheoThang(textField_1.getText());
        JOptionPane.showMessageDialog(this, "Xuất giao dịch thành công.");
    }

    private java.sql.Date convertToDate(String dateStr) {
        try {
            // Parse the input string into a java.util.Date
            java.util.Date utilDate = dateFormat.parse(dateStr.trim());

            // Convert java.util.Date to java.sql.Date
            return new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Định dạng ngày tháng không hợp lệ: " + dateStr + ". Vui lòng nhập lại theo định dạng yyyy-MM-dd.",
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public int getSelectedRow() {
        return tableRemote.getSelectedRow();
    }

    public void displayAverage(double average) {
        textField_1.setText(String.valueOf(average));
    }

    public void displayTotal(double total) {
        textField_2.setText(String.valueOf(total));
    }

    public int getTransactionIdToDelete() {
        int selectedRow = tableRemote.getSelectedRow();
        if (selectedRow != -1) {
            int Id = (int) tableRemote.getValueAt(selectedRow, 0);
            return Id;
        } else {
            JOptionPane.showMessageDialog(this, "hãy chọn giao dịch cần xóa.");
        }
        return selectedRow;
    }

    public Transaction getNewTransaction() {

        String loaiGiaoDich = (String) CBloaiGDRemote.getSelectedItem();
        Date ngayGiaoDich = convertToDate(txtNgayGiaoDichRemote.getText().trim());
        float donGia = Float.parseFloat(txtDonGiaRemote.getText());
        float dienTich = Float.parseFloat(txtDienTichRemote.getText());
        if (loaiGiaoDich.equals("House")) {
            String loaiNha = (String) CBloaiNhaRemote.getSelectedItem();
            String diaChi = txtDiaChiRemote.getText();
            return new HouseTransaction(-1, ngayGiaoDich, donGia, dienTich, loaiNha, diaChi); // Mã giao dịch tạm thời
                                                                                              // là -1
        } else if (loaiGiaoDich.equals("Land")) {
            String loaiDat = (String) CBloaiDatRemote.getSelectedItem();
            return new LandTransaction(-1, ngayGiaoDich, donGia, dienTich, loaiDat); // Mã giao dịch tạm thời là -1
        }

        // Nếu loại giao dịch không hợp lệ
        return null;
    }
   
    public Transaction getUpdatedTransaction() {
        int selectedRow = tableRemote.getSelectedRow();
   
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giao dịch để chỉnh sửa.");
            return null;
        }
   
        String loaiGiaoDich = CBloaiGDRemote.getSelectedItem().toString();
        if (loaiGiaoDich == null || loaiGiaoDich.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại giao dịch.");
            return null;
        }
   
        Date ngayGiaoDich;
        try {
            ngayGiaoDich = convertToDate(txtNgayGiaoDichRemote.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ.");
            return null;
        }
   
        float donGia;
        try {
            donGia = Float.parseFloat(txtDonGiaRemote.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Định dạng giá không hợp lệ.");
            return null;
        }
   
        float dienTich;
        try {
            dienTich = Float.parseFloat(txtDienTichRemote.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Định dạng diện tích không hợp lệ.");
            return null;
        }
        int transactionId = (int) tableRemote.getValueAt(selectedRow, 0);
        if ("Land".equals(loaiGiaoDich)) {
            String loaiDat = CBloaiDatRemote.getSelectedItem().toString();
            if (loaiDat == null || loaiDat.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn loại đất.");
                return null;
            }
            
            return new LandTransaction(transactionId, ngayGiaoDich, donGia, dienTich, loaiDat);
        } else if ("House".equals(loaiGiaoDich)) {
            String loaiNha = CBloaiNhaRemote.getSelectedItem().toString();
            if (loaiNha == null || loaiNha.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn loại nhà.");
                return null;
            }
            String diaChi = txtDiaChiRemote.getText();
            if (diaChi == null || diaChi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ.");
                return null;
            }
            return new HouseTransaction(transactionId, ngayGiaoDich, donGia, dienTich, loaiNha, diaChi);
        }
   
        return null;
    }
   
    // public Transaction getUpdatedTransaction() {
        
    //     int selectedRow = tableRemote.getSelectedRow();
        
    //     if (selectedRow >= 0) {
            
    //         int transactionId = (int) tableRemote.getValueAt(selectedRow, 0);
    //         String loaiGiaoDich = CBloaiGDRemote.getSelectedItem().toString();
    //         Date ngayGiaoDich = convertToDate(txtNgayGiaoDichRemote.getText());
    //         float donGia = Float.parseFloat(txtDonGiaRemote.getText());

    //         float dienTich = Float.parseFloat(txtDienTichRemote.getText());

    //         if ("Land".equals(loaiGiaoDich)) {
    //             String loaiDat = CBloaiDatRemote.getSelectedItem().toString();

    //             return new LandTransaction(transactionId, ngayGiaoDich, donGia, dienTich, loaiDat);
    //         } else if ("House".equals(loaiGiaoDich)) {
    //             String loaiNha = CBloaiNhaRemote.getSelectedItem().toString();
    //             String diaChi = txtDiaChiRemote.getText();
    //             return new HouseTransaction(transactionId, ngayGiaoDich, donGia, dienTich, loaiNha, diaChi);
    //         }

    //     } else {
    //         JOptionPane.showMessageDialog(this, "Please select a transaction to edit.");
    //     }
    //     return null;
    // }

    //
    public String getSearchKeywordid() {
        String idStr = JOptionPane.showInputDialog(this, "nhập mã giao dịch mà bạn muốn tìm");
        return idStr;
    }

    public String getSearchKeyword() {
        String loaiNha = CBThangRemote.getSelectedItem().toString();
        if (loaiNha == null || loaiNha.isEmpty()) {
        
        JOptionPane.showMessageDialog(this, "hãy chọn tháng mà bạn muốn xuất");
    }else 
    return CBThangRemote.getSelectedItem().toString();
return null;
}

    public String loai() {
        return CBloaiRemote.getSelectedItem().toString();
    }

    public void comboboxLoaiGD() {

        if ("House".equals(CBloaiGDRemote.getSelectedItem())) {
            CBloaiNhaRemote.setEditable(true);
            CBloaiDatRemote.setEditable(false);

            txtNgayGiaoDichRemote.setEditable(true);
            txtDonGiaRemote.setEditable(true);
            txtDiaChiRemote.setEditable(true);
            txtDienTichRemote.setEditable(true);
        } else if ("Land".equals(CBloaiGDRemote.getSelectedItem())) {
            CBloaiDatRemote.setEditable(true);
            CBloaiNhaRemote.setEditable(false);
            txtNgayGiaoDichRemote.setEditable(true);
            txtDonGiaRemote.setEditable(true);
            txtDienTichRemote.setEditable(true);
            txtDiaChiRemote.setEditable(false);
        }
    }

    public void loadtextfiled() {
        int tong = transactionServiceRemote.tinhTongSLTungLoai(CBloaiRemote.getSelectedItem().toString());

        JOptionPane.showMessageDialog(this, CBloaiRemote.getSelectedItem().toString() + " :" + String.valueOf(tong));

    }

    public void loadtextfiled1() {
        double tong = transactionServiceRemote.tinhTBTTGDD();
        JOptionPane.showMessageDialog(this, "Tổng Trung Bình thành tiền của Giao Dịch đất: " + String.valueOf(tong) + "$");
    }

  
    

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            TransactionPersistenceService persistenceService = new TransactionPersistenceServiceImpl();
            // Khởi tạo dịch vụ giao dịch
            TransactionService transactionService = new TransactionServiceImpl(persistenceService);
            // Khởi tạo giao diện người dùng
            TransactionManagementUI transactionManagementUI = new TransactionManagementUI(null, transactionService);

            // Khởi tạo điều khiển giao dịch
            TransactionController transactionController = new TransactionController(transactionManagementUI,
                    transactionService);

            // Cập nhật giao diện người dùng với điều khiển giao dịch
            transactionManagementUI.setTransactionController(transactionController);
            // Hiển thị giao diện người dùng
            transactionManagementUI.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}