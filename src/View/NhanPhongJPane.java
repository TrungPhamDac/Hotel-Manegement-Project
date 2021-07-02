package View;

import Controller.CheckInController;
import DAO.DataBaseConnection;
import DAO.ThongTinPhongDAO;
import DAO.KhachHangDAO;
import DAO.PhieuDatPhongDAO;
import Model.ThongTinPhong;
import Model.KhachHang;
import Model.PhieuDatPhong;
import Model.ThongTinPhieuDatPhong;
import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author asus
 */
public class NhanPhongJPane extends javax.swing.JPanel {
//    private ArrayList<LoaiPhong> listKieuPhong;
    private ArrayList<ThongTinPhieuDatPhong> listPhieuDatPhong;
    private DefaultTableModel tblPhieuDatPhong;
    public NhanPhongJPane() 
    {              
        initComponents(); 
        tblPhieuDatPhong = (DefaultTableModel) Table_PhieuDatPhong.getModel();
        tblPhieuDatPhong.setColumnIdentifiers(new Object[]{"Mã đặt phòng","Tên khách hàng", "CCCD", "SDT", "Ngày đặt", "Ngày nhận phòng","Ngày trả phòng","Danh sách phòng đặt"});
        loadPhieuDatPhong();

        Table_PhieuDatPhong.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus, int row, int col) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
                try {
                    Date d = new SimpleDateFormat("dd-MM-yyyy").parse(tblPhieuDatPhong.getValueAt(row, 5).toString());
                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    Date currentDate = format.parse(format.format(new Date()));
                    if (d.compareTo(currentDate) < 0 )
                        setForeground(Color.RED);
                    else if (d.compareTo(currentDate) == 0)
                        setForeground(Color.GREEN);
                    else 
                        setForeground(Color.BLACK);
                } catch (ParseException ex) {
                    Logger.getLogger(NhanPhongJPane.class.getName()).log(Level.SEVERE, null, ex);
                }                
                return this;
            }   
        });


        Table_PhieuDatPhong.setShowHorizontalLines(true);
        Table_PhieuDatPhong.setDefaultEditor(Object.class, null);
    }
    public void loadPhieuDatPhong()
    {
        tblPhieuDatPhong.setRowCount(0);
        Connection conn = new DataBaseConnection().getConnection();
        String sql = "SELECT MADATPHONG  FROM PHIEUDATPHONG WHERE TTNHANPHONG = 0 ";
                try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int madp = rs.getInt("MADATPHONG");
                addPhieuDatPhongToTable(madp);
            }
            Table_PhieuDatPhong.setModel(tblPhieuDatPhong);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void addPhieuDatPhongToTable(int madp)
    {
        PhieuDatPhong d = new PhieuDatPhongDAO().getThongTinPhieuDatPhong(madp);
        tblPhieuDatPhong.addRow(new Object[]{d.getMaDatPhong(),d.getKhachHang().getTenKH(),d.getKhachHang().getCCCD(),d.getKhachHang().getSDT(),
                    new SimpleDateFormat("dd-MM-yyyy").format(d.getNgayDat()),
                    new SimpleDateFormat("dd-MM-yyyy").format(d.getNgayNhan()),
                    new SimpleDateFormat("dd-MM-yyyy").format(d.getNgayTra()),
                    d.getStringDSPhong()
                    });
//        Table_PhieuDatPhong.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
//        {
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
//            {                    
//                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//                try {
////                c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
//                Date d = new SimpleDateFormat("dd-MM-yyyy").parse(table.getModel().getValueAt(row, 5).toString());
//                if (d.before(new Date()))
//                    c.setForeground(Color.red);
//                } catch (ParseException ex) {
//                    Logger.getLogger(NhanPhongJPane.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                return c;
//            }
//        });

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Text_MaDatPhong = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        Button_XacNhanPhong = new javax.swing.JButton();
        Button_HuyDatPhong = new javax.swing.JButton();
        jDateChooser_NgayDat = new com.toedter.calendar.JDateChooser();
        Text_TenKH = new javax.swing.JTextField();
        jDateChooser_NgayNhan = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jDateChooser_NgayTra = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        Text_CCCD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Text_SDT = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_PhieuDatPhong = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1058, 644));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mã đặt phòng");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Tên khách hàng");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Ngày đặt");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Ngày nhận");

        Text_MaDatPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Button_XacNhanPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_XacNhanPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/checked_30px.png"))); // NOI18N
        Button_XacNhanPhong.setText("Xác nhận nhận phòng");
        Button_XacNhanPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_XacNhanPhongActionPerformed(evt);
            }
        });

        Button_HuyDatPhong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_HuyDatPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/event_declined_30px.png"))); // NOI18N
        Button_HuyDatPhong.setText("Hủy đặt phòng");
        Button_HuyDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_HuyDatPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Button_XacNhanPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(Button_HuyDatPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Button_XacNhanPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Button_HuyDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jDateChooser_NgayDat.setDateFormatString("dd-MM-yyyy");
        jDateChooser_NgayDat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Text_TenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jDateChooser_NgayNhan.setDateFormatString("dd-MM-yyyy");
        jDateChooser_NgayNhan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Ngày trả");

        jDateChooser_NgayTra.setDateFormatString("dd-MM-yyyy");
        jDateChooser_NgayTra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Số CCCD");

        Text_CCCD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Số điện thoại");

        Text_SDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Text_MaDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Text_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser_NgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Text_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jDateChooser_NgayNhan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                        .addComponent(jDateChooser_NgayDat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(Text_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Text_MaDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(Text_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel18))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jDateChooser_NgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser_NgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser_NgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(31, 31, 31)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        Table_PhieuDatPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Table_PhieuDatPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_PhieuDatPhongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_PhieuDatPhong);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1058, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Table_PhieuDatPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_PhieuDatPhongMouseClicked
        // TODO add your handling code here:
        ListSelectionModel listTable_KhachHang = Table_PhieuDatPhong.getSelectionModel();
        listTable_KhachHang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        int indexTB = Table_PhieuDatPhong.getSelectedRow();
        if (indexTB < tblPhieuDatPhong.getRowCount() && indexTB >= 0){
            Text_MaDatPhong.setText(tblPhieuDatPhong.getValueAt(indexTB, 0).toString());
            Text_TenKH.setText(tblPhieuDatPhong.getValueAt(indexTB, 1).toString());
            Text_CCCD.setText(tblPhieuDatPhong.getValueAt(indexTB, 2).toString());
            Text_SDT.setText(tblPhieuDatPhong.getValueAt(indexTB, 3).toString());
            try {
                jDateChooser_NgayDat.setDate(new SimpleDateFormat("dd-MM-yyyy").parse(tblPhieuDatPhong.getValueAt(indexTB, 4).toString()));
                jDateChooser_NgayNhan.setDate(new SimpleDateFormat("dd-MM-yyyy").parse(tblPhieuDatPhong.getValueAt(indexTB, 5).toString()));
                jDateChooser_NgayTra.setDate(new SimpleDateFormat("dd-MM-yyyy").parse(tblPhieuDatPhong.getValueAt(indexTB, 6).toString()));
            } catch (ParseException ex) {
                Logger.getLogger(NhanPhongJPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Table_PhieuDatPhongMouseClicked

    private void Button_HuyDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_HuyDatPhongActionPerformed
        // TODO add your handling code here:
        if(new CheckInController().KtraTextCheckIn(Text_MaDatPhong, Text_TenKH, Text_CCCD, Text_SDT, jDateChooser_NgayDat, jDateChooser_NgayNhan, jDateChooser_NgayTra)){
            if (new PhieuDatPhongDAO().HuyDatPhong(Integer.parseInt(Text_MaDatPhong.getText())))
            {     
                JOptionPane.showMessageDialog(this, "Hủy phiếu đặt phòng thành công");
                clearText();
            }
            else {
                int count = tblPhieuDatPhong.getRowCount();
                loadPhieuDatPhong();
                if(tblPhieuDatPhong.getRowCount() != count)
                {
                    JOptionPane.showMessageDialog(this, "Hủy phiếu đặt phòng thành công");
                    clearText();
                }
                else
                JOptionPane.showMessageDialog(this, "Hủy phiếu đặt phòng thất bại");
            }
        }
        
    }//GEN-LAST:event_Button_HuyDatPhongActionPerformed

    private void Button_XacNhanPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_XacNhanPhongActionPerformed
        if(new CheckInController().KtraTextCheckIn(Text_MaDatPhong, Text_TenKH, Text_CCCD, Text_SDT, jDateChooser_NgayDat, jDateChooser_NgayNhan, jDateChooser_NgayTra)){
            if (new PhieuDatPhongDAO().XacNhanNhanPhong(Integer.parseInt(Text_MaDatPhong.getText())))
            {     
                JOptionPane.showMessageDialog(this, "Xác nhận nhận phòng thành công");
                clearText();
            }
            else {
                int count = tblPhieuDatPhong.getRowCount();
                loadPhieuDatPhong();
                if(tblPhieuDatPhong.getRowCount() != count)
                {
                    JOptionPane.showMessageDialog(this, "Xác nhận nhận phòng thành công");
                    clearText();
                }
                else
                JOptionPane.showMessageDialog(this, "Nhận phòng thất bại");
            }
        }
    }//GEN-LAST:event_Button_XacNhanPhongActionPerformed

    public void clearText(){
        Text_MaDatPhong.setText("");
        Text_TenKH.setText("");
        Text_CCCD.setText("");
        Text_SDT.setText("");
        jDateChooser_NgayDat.setDate(null);
        jDateChooser_NgayNhan.setDate(null);
        jDateChooser_NgayTra.setDate(null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_HuyDatPhong;
    private javax.swing.JButton Button_XacNhanPhong;
    private javax.swing.JTable Table_PhieuDatPhong;
    private javax.swing.JTextField Text_CCCD;
    private javax.swing.JTextField Text_MaDatPhong;
    private javax.swing.JTextField Text_SDT;
    private javax.swing.JTextField Text_TenKH;
    private com.toedter.calendar.JDateChooser jDateChooser_NgayDat;
    private com.toedter.calendar.JDateChooser jDateChooser_NgayNhan;
    private com.toedter.calendar.JDateChooser jDateChooser_NgayTra;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
