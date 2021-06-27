
package View;

import Bean.DanhMuc;
import Controller.ChuyenManHinhController;
import Model.User;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class AdminJFrame extends javax.swing.JFrame {
    private User user;
    public AdminJFrame(){
        initComponents();
        setResizable(true);
        setVisible(true);
        setTitle("QUẢN LÍ KHÁCH SẠN PARADISE");
        
        ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
        controller.setView(Panel_TrangChu,Label_TrangChu);
        
        List<DanhMuc> listItem = new ArrayList<>();
        listItem.add(new DanhMuc("TrangChu",Panel_TrangChu,Label_TrangChu));
        listItem.add(new DanhMuc("QuanLiKhachHang",Panel_QuanLiKhachHang,Label_QuanLiKhachHang));
        listItem.add(new DanhMuc("QuanLiNhanVien",Panel_QuanLiNhanVien,Label_QuanLiNhanVien));
        listItem.add(new DanhMuc("QuanLiPhong",Panel_QuanLiPhong,Label_QuanLiPhong));
        listItem.add(new DanhMuc("QuanLiDichVu",Panel_QuanLiDichVu,Label_QuanLiDichVu));
        listItem.add(new DanhMuc("DatTiec",Panel_DatTiec,Label_DatTiec));
        listItem.add(new DanhMuc("ThongKe",Panel_ThongKe,Label_ThongKe));
        listItem.add(new DanhMuc("DangXuat", Panel_DangXuat, Label_DangXuat));
//        listItem.add(new DanhMuc("QuanLiDatPhong",Panel_QuanLiDatPhong,Label_QuanLiDatPhong));
//        listItem.add(new DanhMuc("CheckIn",Panel_CheckIn,Label_CheckIn));
        controller.setEvent(listItem);

        JFrameCenterOfScreen();
        Clock();

    }
    public void setUser(User u)
    {
        user = u;
    }
    public void JFrameCenterOfScreen(){
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
    }
    
    public void Clock(){
        new Thread(){
            public void run(){
                while(true){
                    String date = new java.text.SimpleDateFormat("EEEE, dd-MM-yyyy       HH:mm:ss ").format(Calendar.getInstance().getTime());                    
                    Text_Time.setText(date);
                }
            }
            
        }.start();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Panel_TrangChu = new javax.swing.JPanel();
        Label_TrangChu = new javax.swing.JLabel();
        Panel_QuanLiPhong = new javax.swing.JPanel();
        Label_QuanLiPhong = new javax.swing.JLabel();
        Panel_QuanLiKhachHang = new javax.swing.JPanel();
        Label_QuanLiKhachHang = new javax.swing.JLabel();
        Panel_QuanLiNhanVien = new javax.swing.JPanel();
        Label_QuanLiNhanVien = new javax.swing.JLabel();
        Panel_QuanLiDichVu = new javax.swing.JPanel();
        Label_QuanLiDichVu = new javax.swing.JLabel();
        Panel_DatTiec = new javax.swing.JPanel();
        Label_DatTiec = new javax.swing.JLabel();
        Panel_ThongKe = new javax.swing.JPanel();
        Label_ThongKe = new javax.swing.JLabel();
        Panel_DangXuat = new javax.swing.JPanel();
        Label_DangXuat = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Text_Time = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jpnRoot.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jpnMenu.setBackground(new java.awt.Color(0, 0, 0));
        jpnMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("STXinwei", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PARADISE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
        );

        Panel_TrangChu.setBackground(new java.awt.Color(102, 102, 102));

        Label_TrangChu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label_TrangChu.setForeground(new java.awt.Color(255, 255, 255));
        Label_TrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_home_white_24dp.png"))); // NOI18N
        Label_TrangChu.setText("Trang chủ");

        javax.swing.GroupLayout Panel_TrangChuLayout = new javax.swing.GroupLayout(Panel_TrangChu);
        Panel_TrangChu.setLayout(Panel_TrangChuLayout);
        Panel_TrangChuLayout.setHorizontalGroup(
            Panel_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_TrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_TrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_TrangChuLayout.setVerticalGroup(
            Panel_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_TrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        Panel_QuanLiPhong.setBackground(new java.awt.Color(102, 102, 102));

        Label_QuanLiPhong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label_QuanLiPhong.setForeground(new java.awt.Color(255, 255, 255));
        Label_QuanLiPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_room_preferences_white_24dp.png"))); // NOI18N
        Label_QuanLiPhong.setText("Quản lí phòng");

        javax.swing.GroupLayout Panel_QuanLiPhongLayout = new javax.swing.GroupLayout(Panel_QuanLiPhong);
        Panel_QuanLiPhong.setLayout(Panel_QuanLiPhongLayout);
        Panel_QuanLiPhongLayout.setHorizontalGroup(
            Panel_QuanLiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_QuanLiPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_QuanLiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_QuanLiPhongLayout.setVerticalGroup(
            Panel_QuanLiPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_QuanLiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        Panel_QuanLiKhachHang.setBackground(new java.awt.Color(102, 102, 102));

        Label_QuanLiKhachHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label_QuanLiKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        Label_QuanLiKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_person_white_24dp.png"))); // NOI18N
        Label_QuanLiKhachHang.setText("Quản lí khách hàng");

        javax.swing.GroupLayout Panel_QuanLiKhachHangLayout = new javax.swing.GroupLayout(Panel_QuanLiKhachHang);
        Panel_QuanLiKhachHang.setLayout(Panel_QuanLiKhachHangLayout);
        Panel_QuanLiKhachHangLayout.setHorizontalGroup(
            Panel_QuanLiKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_QuanLiKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_QuanLiKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );
        Panel_QuanLiKhachHangLayout.setVerticalGroup(
            Panel_QuanLiKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_QuanLiKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        Panel_QuanLiNhanVien.setBackground(new java.awt.Color(102, 102, 102));

        Label_QuanLiNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label_QuanLiNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        Label_QuanLiNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_people_white_24dp.png"))); // NOI18N
        Label_QuanLiNhanVien.setText("Quản lí nhân viên");

        javax.swing.GroupLayout Panel_QuanLiNhanVienLayout = new javax.swing.GroupLayout(Panel_QuanLiNhanVien);
        Panel_QuanLiNhanVien.setLayout(Panel_QuanLiNhanVienLayout);
        Panel_QuanLiNhanVienLayout.setHorizontalGroup(
            Panel_QuanLiNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_QuanLiNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_QuanLiNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_QuanLiNhanVienLayout.setVerticalGroup(
            Panel_QuanLiNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_QuanLiNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        Panel_QuanLiDichVu.setBackground(new java.awt.Color(102, 102, 102));

        Label_QuanLiDichVu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label_QuanLiDichVu.setForeground(new java.awt.Color(255, 255, 255));
        Label_QuanLiDichVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_room_service_white_24dp.png"))); // NOI18N
        Label_QuanLiDichVu.setText("Quản lí dịch vụ");

        javax.swing.GroupLayout Panel_QuanLiDichVuLayout = new javax.swing.GroupLayout(Panel_QuanLiDichVu);
        Panel_QuanLiDichVu.setLayout(Panel_QuanLiDichVuLayout);
        Panel_QuanLiDichVuLayout.setHorizontalGroup(
            Panel_QuanLiDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_QuanLiDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_QuanLiDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_QuanLiDichVuLayout.setVerticalGroup(
            Panel_QuanLiDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_QuanLiDichVu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        Panel_DatTiec.setBackground(new java.awt.Color(102, 102, 102));

        Label_DatTiec.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label_DatTiec.setForeground(new java.awt.Color(255, 255, 255));
        Label_DatTiec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_liquor_white_24dp.png"))); // NOI18N
        Label_DatTiec.setText("Đặt tiệc");

        javax.swing.GroupLayout Panel_DatTiecLayout = new javax.swing.GroupLayout(Panel_DatTiec);
        Panel_DatTiec.setLayout(Panel_DatTiecLayout);
        Panel_DatTiecLayout.setHorizontalGroup(
            Panel_DatTiecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_DatTiecLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_DatTiec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_DatTiecLayout.setVerticalGroup(
            Panel_DatTiecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_DatTiec, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        Panel_ThongKe.setBackground(new java.awt.Color(102, 102, 102));

        Label_ThongKe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label_ThongKe.setForeground(new java.awt.Color(255, 255, 255));
        Label_ThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_leaderboard_white_24dp.png"))); // NOI18N
        Label_ThongKe.setText("Thống kê, báo cáo");

        javax.swing.GroupLayout Panel_ThongKeLayout = new javax.swing.GroupLayout(Panel_ThongKe);
        Panel_ThongKe.setLayout(Panel_ThongKeLayout);
        Panel_ThongKeLayout.setHorizontalGroup(
            Panel_ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_ThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );
        Panel_ThongKeLayout.setVerticalGroup(
            Panel_ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_ThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Panel_DangXuat.setBackground(new java.awt.Color(102, 102, 102));

        Label_DangXuat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Label_DangXuat.setForeground(new java.awt.Color(255, 255, 255));
        Label_DangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagine/baseline_logout_white_24dp.png"))); // NOI18N
        Label_DangXuat.setText("Đăng xuất");
        Label_DangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_DangXuatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Panel_DangXuatLayout = new javax.swing.GroupLayout(Panel_DangXuat);
        Panel_DangXuat.setLayout(Panel_DangXuatLayout);
        Panel_DangXuatLayout.setHorizontalGroup(
            Panel_DangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_DangXuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_DangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_DangXuatLayout.setVerticalGroup(
            Panel_DangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_DangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel_TrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel_QuanLiPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel_QuanLiKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel_QuanLiNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel_QuanLiDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel_DatTiec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel_ThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel_DangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(Panel_TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel_QuanLiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(Panel_QuanLiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel_QuanLiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(Panel_QuanLiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(Panel_DatTiec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel_ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(Panel_DangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Text_Time.setFont(new java.awt.Font("SimSun-ExtB", 0, 18)); // NOI18N
        Text_Time.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Text_Time.setText("dd/MM/yyyy              00:00:00 AM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(699, Short.MAX_VALUE)
                .addComponent(Text_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Text_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnRootLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Label_DangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_DangXuatMouseClicked
        int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất?", "Đăng xuất", JOptionPane.YES_NO_OPTION);
        if (ret == JOptionPane.YES_OPTION){  
            this.dispose();
            LoginForm lgform = new LoginForm();
            lgform.setVisible(true);
        } else if (ret == JOptionPane.NO_OPTION){
            Panel_DangXuat.setBackground(new Color(102,102,102));
            Label_DangXuat.setBackground(new Color(102,102,102));
        }
    }//GEN-LAST:event_Label_DangXuatMouseClicked

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainJFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_DangXuat;
    private javax.swing.JLabel Label_DatTiec;
    private javax.swing.JLabel Label_QuanLiDichVu;
    private javax.swing.JLabel Label_QuanLiKhachHang;
    private javax.swing.JLabel Label_QuanLiNhanVien;
    private javax.swing.JLabel Label_QuanLiPhong;
    private javax.swing.JLabel Label_ThongKe;
    private javax.swing.JLabel Label_TrangChu;
    private javax.swing.JPanel Panel_DangXuat;
    private javax.swing.JPanel Panel_DatTiec;
    private javax.swing.JPanel Panel_QuanLiDichVu;
    private javax.swing.JPanel Panel_QuanLiKhachHang;
    private javax.swing.JPanel Panel_QuanLiNhanVien;
    private javax.swing.JPanel Panel_QuanLiPhong;
    private javax.swing.JPanel Panel_ThongKe;
    private javax.swing.JPanel Panel_TrangChu;
    private javax.swing.JLabel Text_Time;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
