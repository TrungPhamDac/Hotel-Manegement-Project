package View;

import DAO.ThongTinPhongDAO;
import DAO.KhachHangDAO;
import DAO.PhieuDatPhongDAO;
import Model.ThongTinPhong;
import Model.KhachHang;
import Model.PhieuDatPhong;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.regex.Matcher;
/**
 *
 * @author asus
 */
public class QuanLiDatPhongJPane extends javax.swing.JPanel {
//    private ArrayList<LoaiPhong> listKieuPhong;
    private ArrayList<ThongTinPhong> listPhongTrong;
    private ArrayList<KhachHang> listKhachHang;
    private HashMap<String, Integer> listPhongDat;
    private KhachHangDAO khachHangDAO;
    private PhieuDatPhongDAO phieuDatPhongDAO;
    private int curr_MaDatPhong;
    private int curr_MaKhachHang;
    private int tongTien;
    private PhieuDatPhong phieuDatPhong; 
    DefaultTableModel tblKhachHang;
    DefaultTableModel tblDanhSachPhongTrong;
    DefaultTableModel tblDanhSachPhongDat;
    Date date = new Date();
   
    public QuanLiDatPhongJPane() 
    {             
        initComponents(); 
//       phiếu đặt phòng init
        phieuDatPhong = new PhieuDatPhong();
        phieuDatPhongDAO = new PhieuDatPhongDAO();
        curr_MaDatPhong = phieuDatPhongDAO.getCurrentMaDatPhong();
        tongTien = 0;
        
//        khách hàng init

//      Danh sách phòng init        
        listPhongTrong = new ThongTinPhongDAO().getListChiTietTTPhong();
        tblDanhSachPhongTrong = (DefaultTableModel) Table_DanhSachPhongTrong.getModel();
        tblDanhSachPhongTrong.setColumnIdentifiers(new Object[]{"Mã phòng", "Kiểu phòng", "Kiểu giường", "Giá phòng"});
        
        listPhongDat = new HashMap<String,Integer>();
        tblDanhSachPhongDat = (DefaultTableModel) Table_DanhSachPhongDat.getModel();
        tblDanhSachPhongDat.setColumnIdentifiers(new Object[]{"Mã phòng"});
//        showTableChiTietTTPhong();
        showComboBox_KieuPhong();
//        showComboBox_KieuGiuong();
    }

    public void showTableChiTietTTPhong(){
        tblDanhSachPhongTrong.setRowCount(0);
        for(ThongTinPhong ttPhong : listPhongTrong){
            tblDanhSachPhongTrong.addRow(new Object[]{ttPhong.getMaPhg(), ttPhong.getKieuPhong(), ttPhong.getKieuGiuong(), 
                ttPhong.getDonGia()});          
        }
    }
    public String getMaKH()
    {
        ChonKhachHang panel = new ChonKhachHang();
        int result =    JOptionPane.showConfirmDialog(null, panel, "Chọn khách hàng", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION)
        {
            return panel.returnMaKH();
        }
        else return null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ComboBox_KieuPhong = new javax.swing.JComboBox<>();
        ComboBox_KieuGiuong = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_DanhSachPhongTrong = new javax.swing.JTable();
        Button_TimKiemPhong = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Text_MaKhachHang = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser_NgayNhan = new com.toedter.calendar.JDateChooser();
        jDateChooser_NgayTra = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        Button_XacNhanKhachHang = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table_DanhSachPhongDat = new javax.swing.JTable();
        Button_ThemPhongDat = new javax.swing.JButton();
        Button_XoaPhongDat = new javax.swing.JButton();
        Button_TaoDonDatPhong = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        Text_TienTraTruoc = new javax.swing.JTextField();
        Text_TongTien = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1058, 644));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jPanel2.setPreferredSize(new java.awt.Dimension(1058, 642));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Kiểu phòng");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Kiểu giường");

        ComboBox_KieuPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ComboBox_KieuPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        ComboBox_KieuPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_KieuPhongActionPerformed(evt);
            }
        });

        ComboBox_KieuGiuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ComboBox_KieuGiuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        ComboBox_KieuGiuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_KieuGiuongActionPerformed(evt);
            }
        });

        Table_DanhSachPhongTrong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(Table_DanhSachPhongTrong);

        Button_TimKiemPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_TimKiemPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/Search_Icon.png"))); // NOI18N
        Button_TimKiemPhong.setText("Tìm phòng trống");
        Button_TimKiemPhong.setMaximumSize(new java.awt.Dimension(115, 40));
        Button_TimKiemPhong.setMinimumSize(new java.awt.Dimension(115, 40));
        Button_TimKiemPhong.setPreferredSize(new java.awt.Dimension(115, 40));
        Button_TimKiemPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_TimKiemPhongActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Mã khách hàng");

        Text_MaKhachHang.setEditable(false);
        Text_MaKhachHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Ngày nhận");

        jDateChooser_NgayNhan.setDateFormatString("dd/MM/yyyy");
        jDateChooser_NgayNhan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser_NgayTra.setDateFormatString("dd/MM/yyyy");
        jDateChooser_NgayTra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Ngày trả");

        Button_XacNhanKhachHang.setBackground(new java.awt.Color(51, 51, 51));
        Button_XacNhanKhachHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_XacNhanKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        Button_XacNhanKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_people_white_24dp.png"))); // NOI18N
        Button_XacNhanKhachHang.setText("Chọn khách hàng");
        Button_XacNhanKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_XacNhanKhachHangMouseClicked(evt);
            }
        });
        Button_XacNhanKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_XacNhanKhachHangActionPerformed(evt);
            }
        });

        Table_DanhSachPhongDat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Table_DanhSachPhongDat.setColumnSelectionAllowed(true);
        jScrollPane4.setViewportView(Table_DanhSachPhongDat);
        Table_DanhSachPhongDat.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        Button_ThemPhongDat.setText(">>");
        Button_ThemPhongDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_ThemPhongDatMouseClicked(evt);
            }
        });

        Button_XoaPhongDat.setText("<<");
        Button_XoaPhongDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_XoaPhongDatMouseClicked(evt);
            }
        });

        Button_TaoDonDatPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_TaoDonDatPhong.setText("Tạo đơn đặt phòng");
        Button_TaoDonDatPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_TaoDonDatPhongMouseClicked(evt);
            }
        });
        Button_TaoDonDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_TaoDonDatPhongActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Tiền trả trước");

        Text_TienTraTruoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Text_TongTien.setEditable(false);
        Text_TongTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Tiền phòng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Text_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Button_XacNhanKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ComboBox_KieuPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ComboBox_KieuGiuong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jDateChooser_NgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jDateChooser_NgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(Button_TimKiemPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Button_TaoDonDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Button_ThemPhongDat, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Button_XoaPhongDat, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Text_TienTraTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Text_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Button_XacNhanKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Text_MaKhachHang)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(Button_ThemPhongDat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Button_XoaPhongDat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Text_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(Text_TienTraTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(ComboBox_KieuPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(ComboBox_KieuGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jDateChooser_NgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser_NgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGap(18, 24, Short.MAX_VALUE)
                                .addComponent(Button_TimKiemPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Button_TaoDonDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGap(96, 96, 96))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Phiếu đặt phòng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Button_TimKiemPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_TimKiemPhongActionPerformed
        // TODO add your handling code here:
        if (jDateChooser_NgayNhan.getDate()==null || jDateChooser_NgayTra.getDate()==null )
        {
            JOptionPane.showMessageDialog(this,"Yêu cầu nhập ngày nhận, ngày trả trước khi tra cứu danh sách phòng trống");
        }      
        else
        {
            String kieuPhong = ComboBox_KieuPhong.getSelectedItem().toString();
            try {
                //            int kieuGiuong = Integer.parseInt(ComboBox_LoaiGiuong.getSelectedItem().toString());
//            Date ngayNhan = jDateChooser_NgayNhan.getDate();
//            Date ngayTra = jDateChooser_NgayTra.getDate();
                listPhongTrong = new ThongTinPhongDAO().getListTTPhongTrong("",1 , new java.sql.Date(jDateChooser_NgayNhan.getDate().getTime()), new java.sql.Date(jDateChooser_NgayTra.getDate().getTime()));
            } catch (SQLException ex) {
                Logger.getLogger(QuanLiDatPhongJPane.class.getName()).log(Level.SEVERE, null, ex);
            }
            showTableChiTietTTPhong();
        }

        
    }//GEN-LAST:event_Button_TimKiemPhongActionPerformed

    private void Button_TaoDonDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_TaoDonDatPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_TaoDonDatPhongActionPerformed
    
    private void Button_XacNhanKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_XacNhanKhachHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_XacNhanKhachHangMouseClicked

    private void Button_ThemPhongDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_ThemPhongDatMouseClicked
        // TODO add your handling code here:
        int indexTB = Table_DanhSachPhongTrong.getSelectedRow();
        if (indexTB < tblDanhSachPhongTrong.getRowCount() && indexTB >= 0){
            String selectedRoom = tblDanhSachPhongTrong.getValueAt(indexTB, 0).toString();
            Integer selectedPrice =  Integer.valueOf(tblDanhSachPhongTrong.getValueAt(indexTB, 3).toString());
            if (!listPhongDat.keySet().contains(selectedRoom))
            {
                listPhongDat.put(selectedRoom, selectedPrice);
                tblDanhSachPhongDat.addRow(new Object[]{selectedRoom});
                tongTien += listPhongDat.get(selectedRoom);
                Text_TongTien.setText(Integer.toString(tongTien));
            }
        }

    }//GEN-LAST:event_Button_ThemPhongDatMouseClicked

    private void Button_XoaPhongDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_XoaPhongDatMouseClicked
        // TODO add your handling code here:
        int indexTB = Table_DanhSachPhongDat.getSelectedRow();
        if (indexTB < tblDanhSachPhongDat.getRowCount() && indexTB >= 0){
            String selectedRoom = tblDanhSachPhongDat.getValueAt(indexTB, 0).toString();
            tongTien -= listPhongDat.get(selectedRoom);
            listPhongDat.remove(selectedRoom);
            tblDanhSachPhongDat.removeRow(indexTB);
            Text_TongTien.setText(Integer.toString(tongTien));
        }
    }//GEN-LAST:event_Button_XoaPhongDatMouseClicked

    private void Button_TaoDonDatPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_TaoDonDatPhongMouseClicked
        // TODO add your handling code here:
        phieuDatPhong.setMaDatPhong(curr_MaDatPhong);
        KhachHang k = new KhachHang();
        k.setMaKH(Integer.parseInt(Text_MaKhachHang.getText()));
        phieuDatPhong.setKhachHang(k);
        phieuDatPhong.setNgayNhan(jDateChooser_NgayNhan.getDate());
        phieuDatPhong.setNgayTra(jDateChooser_NgayTra.getDate());
        try {
            if (phieuDatPhongDAO.TaoPhieuDatPhong(phieuDatPhong, new ArrayList<String>(listPhongDat.keySet()) ))
            {
                JOptionPane.showMessageDialog(this, "Thêm phiếu đặt phòng thành công.");
            }
            else {
                JOptionPane.showMessageDialog(this,"Thêm phiếu đặt phòng thất bại");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiDatPhongJPane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Button_TaoDonDatPhongMouseClicked

    private void ComboBox_KieuGiuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_KieuGiuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_KieuGiuongActionPerformed

    private void ComboBox_KieuPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_KieuPhongActionPerformed
        // TODO add your handling code here:
        ComboBox_KieuGiuong.removeAllItems();
        showComboBox_KieuGiuong();

    }//GEN-LAST:event_ComboBox_KieuPhongActionPerformed

    private void Button_XacNhanKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_XacNhanKhachHangActionPerformed
        // TODO add your handling code here:
        Text_MaKhachHang.setText(getMaKH());
    }//GEN-LAST:event_Button_XacNhanKhachHangActionPerformed
    public KhachHang getKhachHangValue()
    {
        KhachHang kh =new KhachHang();
        kh.setMaKH(Integer.parseInt(Text_MaKhachHang.getText()));
        return kh;

    }
    public void clearTextKhachHang()
    {
        Text_MaKhachHang.setText(Integer.toString(curr_MaKhachHang));
    }
    public void showComboBox_KieuPhong(){
        ArrayList<ThongTinPhong> ttKieuPhong = new ThongTinPhongDAO().getKieuPhong();
        for(ThongTinPhong data : ttKieuPhong){
            ComboBox_KieuPhong.addItem(data.getKieuPhong());
        }
    }
    
    public void showComboBox_KieuGiuong(){
        ArrayList<ThongTinPhong> ttKieuGiuong = new ThongTinPhongDAO().getKieuGiuong(ComboBox_KieuPhong.getSelectedItem().toString());
        for(ThongTinPhong data : ttKieuGiuong){
            ComboBox_KieuGiuong.addItem(String.valueOf(data.getKieuGiuong()));
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_TaoDonDatPhong;
    private javax.swing.JButton Button_ThemPhongDat;
    private javax.swing.JButton Button_TimKiemPhong;
    private javax.swing.JButton Button_XacNhanKhachHang;
    private javax.swing.JButton Button_XoaPhongDat;
    private javax.swing.JComboBox<String> ComboBox_KieuGiuong;
    private javax.swing.JComboBox<String> ComboBox_KieuPhong;
    private javax.swing.JTable Table_DanhSachPhongDat;
    private javax.swing.JTable Table_DanhSachPhongTrong;
    private javax.swing.JTextField Text_MaKhachHang;
    private javax.swing.JTextField Text_TienTraTruoc;
    private javax.swing.JTextField Text_TongTien;
    private com.toedter.calendar.JDateChooser jDateChooser_NgayNhan;
    private com.toedter.calendar.JDateChooser jDateChooser_NgayTra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
