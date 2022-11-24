
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Lenovo
 */
public class PembeliFrame extends javax.swing.JFrame {

    public PembeliFrame() {
        initComponents();
    }

    private static Connection conn;
    private static String primaryKeyNow = "";
    private String cariKueri = "";
    private String setTable = "select * from Pembeli";

    private static void connect() {
        String hostname = "localhost";
        String sqlInstanceName = "LAPTOP-43HAT1M2"; //computer name 
        String sqlDatabase = "basdat";  //sql server database name
        String sqlUser = "123";
        String sqlPassword = "123"; //passwrod sa account
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        //jdbc:sqlserver://localhost:1433;instance=COMPUTERBERRY;databaseName=Database;
        String connectURL = "jdbc:sqlserver://" + hostname + ":1433"
                + ";instance=" + sqlInstanceName + ";databaseName=" + sqlDatabase + ";encrypt=true;trustServerCertificate=true";

        try {
            PembeliFrame.conn = DriverManager.getConnection(connectURL, sqlUser, sqlPassword);

        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Connect to database successful!!");
    }

    void tampilkanData() throws ClassNotFoundException, SQLException {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Username");
        model.addColumn("No Telp");
        model.addColumn("Password");
        model.addColumn("Nama Depan");
        model.addColumn("Nama Tengah");
        model.addColumn("Nama Akhir");
        model.addColumn("Tgl Lahir");
        model.addColumn("Jalan");
        model.addColumn("Kecamatan");
        model.addColumn("Kota");
        model.addColumn("No Rumah");
        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("Username");
        model2.addColumn("No Telp");
        model2.addColumn("Password");
        model2.addColumn("Nama Depan");
        model2.addColumn("Nama Tengah");
        model2.addColumn("Nama Akhir");
        model2.addColumn("Tgl Lahir");
        model2.addColumn("Jalan");
        model2.addColumn("Kecamatan");
        model2.addColumn("Kota");
        model2.addColumn("No Rumah");

        connect();
        int no = 1;
        Statement st = conn.createStatement();
        String cth = "select * from Pembeli";
        ResultSet resultSet = st.executeQuery(cth);
        while (resultSet.next()) {
            model.addRow(new Object[]{resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getDate(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getInt(11)});
        }
        tblPembeli.setModel(model);
        resultSet = st.executeQuery(setTable);
        while (resultSet.next()) {
            model2.addRow(new Object[]{resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getDate(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10), resultSet.getInt(11)});
        }
        tblPembeliCari.setModel(model2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGcari = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnCabangFrameKembali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfNoTelp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfNamaDepan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfNamaTengah = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfNamaAkhir = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfJalan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfKecamatan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfKota = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPembeli = new javax.swing.JTable();
        btnTambahData = new javax.swing.JButton();
        tfNoRumah = new javax.swing.JTextField();
        DateChooserTglLahir = new com.toedter.calendar.JDateChooser();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        tfPassword = new javax.swing.JPasswordField();
        cbSee = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        btnCari = new javax.swing.JButton();
        tfCari = new javax.swing.JTextField();
        cbUsername = new javax.swing.JCheckBox();
        cbNamaDepan = new javax.swing.JCheckBox();
        cbNoTelp = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPembeliCari = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pembeli");

        btnCabangFrameKembali.setText("Kembali");
        btnCabangFrameKembali.setToolTipText("");
        btnCabangFrameKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCabangFrameKembaliActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        tfUsername.setEditable(false);

        jLabel2.setText("No Telp");

        tfNoTelp.setEditable(false);

        jLabel3.setText("Password");

        jLabel4.setText("Nama Depan");

        tfNamaDepan.setEditable(false);

        jLabel5.setText("Nama Tengah");

        tfNamaTengah.setEditable(false);

        jLabel6.setText("Nama Akhir");

        tfNamaAkhir.setEditable(false);

        jLabel7.setText("Tgl Lahir");

        jLabel8.setText("Jalan");

        tfJalan.setEditable(false);

        jLabel9.setText("Kecamatan");

        tfKecamatan.setEditable(false);

        jLabel10.setText("Kota");

        tfKota.setEditable(false);

        jLabel11.setText("No Rumah");

        tblPembeli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPembeli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPembeliMouseClicked(evt);
            }
        });
        tblPembeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPembeliKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblPembeli);

        btnTambahData.setText("Tambah Data");
        btnTambahData.setEnabled(false);
        btnTambahData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahDataActionPerformed(evt);
            }
        });

        tfNoRumah.setEditable(false);

        btnHapus.setText("Hapus");
        btnHapus.setEnabled(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.setEnabled(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tfPassword.setEditable(false);

        cbSee.setText("See");
        cbSee.setBorder(null);
        cbSee.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/eye.png"))); // NOI18N
        cbSee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel11))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(DateChooserTglLahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tfKecamatan, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                            .addComponent(tfKota, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                            .addComponent(tfNoRumah)
                                            .addComponent(tfJalan)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(tfNamaAkhir))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfPassword)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbSee))
                                    .addComponent(tfNamaDepan, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfNamaTengah)
                                    .addComponent(tfNoTelp))))
                        .addGap(864, 864, 864))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addComponent(tfUsername)
                        .addGap(861, 861, 861))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(359, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(745, 745, 745)
                                .addComponent(btnCabangFrameKembali))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnTambahData)
                            .addGap(18, 18, 18)
                            .addComponent(btnHapus)
                            .addGap(18, 18, 18)
                            .addComponent(btnEdit)
                            .addGap(18, 18, 18)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnReset)
                            .addGap(290, 290, 290)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfNamaDepan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfNamaTengah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfNamaAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(DateChooserTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(tfJalan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfKecamatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfNoRumah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(164, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTambahData)
                        .addComponent(btnSimpan)
                        .addComponent(btnReset)
                        .addComponent(btnEdit)
                        .addComponent(btnHapus))
                    .addGap(7, 7, 7)
                    .addComponent(btnCabangFrameKembali)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Main", jPanel1);

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnGcari.add(cbUsername);
        cbUsername.setText("Username");
        cbUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUsernameActionPerformed(evt);
            }
        });

        btnGcari.add(cbNamaDepan);
        cbNamaDepan.setText("Nama Depan");
        cbNamaDepan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNamaDepanActionPerformed(evt);
            }
        });

        btnGcari.add(cbNoTelp);
        cbNoTelp.setText("No Telp");
        cbNoTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNoTelpActionPerformed(evt);
            }
        });

        tblPembeliCari.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPembeliCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPembeliCariMouseClicked(evt);
            }
        });
        tblPembeliCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPembeliCariKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblPembeliCari);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(cbUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbNamaDepan)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(254, 254, 254)
                            .addComponent(btnCari))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCari)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbUsername)
                    .addComponent(cbNamaDepan)
                    .addComponent(cbNoTelp))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cari", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCabangFrameKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCabangFrameKembaliActionPerformed
        MainFrame frame1 = new MainFrame();
        frame1.setVisible(true);
        frame1.enableAdmin();
        frame1.pindah();
        this.dispose();
    }//GEN-LAST:event_btnCabangFrameKembaliActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        String temp = tfUsername.getText();
        if (temp.replaceAll("\\s", "").equals("")) {
            JOptionPane.showMessageDialog(new PembeliFrame(), "Error");
            btnReset.doClick();
        } else {
            connect();
            try {
                Statement st = conn.createStatement();
                String cth2 = "select * from Pembeli where username = '" + temp + "'";
                String cth = "delete from Pembeli where "
                        + "username = '" + temp + "'";
                ResultSet resultSet = st.executeQuery(cth2);
                //kalau username nya tidak exist
                if (!resultSet.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(new PembeliFrame(), "Tidak Ada Hasil");
                } else {
                    boolean gotResults = st.execute(cth);
                    ResultSet rs = null;
                    if (!gotResults) {
                        System.out.println("No results returned");
                    } else {
                        rs = st.getResultSet();
                    }
                    JOptionPane.showMessageDialog(new PembeliFrame(), "Data Berhasil Di Hapus");
                }
            } catch (SQLException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(new PembeliFrame(), e);
            }
            try {
                PembeliFrame konek = new PembeliFrame();
                konek.setVisible(true);
                konek.tampilkanData();
                this.dispose();
                tfUsername.setText(temp);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        btnSimpan.setEnabled(true);
        btnTambahData.setEnabled(true);
        btnHapus.setEnabled(true);
        tfUsername.setEditable(true);
        tfNoTelp.setEditable(true);
        tfPassword.setEditable(true);
        tfNamaDepan.setEditable(true);
        tfNamaTengah.setEditable(true);
        tfNamaAkhir.setEditable(true);
        tfJalan.setEditable(true);
        tfKecamatan.setEditable(true);
        tfKota.setEditable(true);
        tfNoRumah.setEditable(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String temp = primaryKeyNow;
        String tempPrimaryKey = tfUsername.getText();
        if (temp.replaceAll("\\s", "").equals("")) {
            JOptionPane.showMessageDialog(new CabangFrame(), "Error");
            btnReset.doClick();
        } else {
            connect();
            try {
                Statement st = conn.createStatement();
                char[] pwc = tfPassword.getPassword();
                String pw = "";
                for (char s : pwc) {
                    pw += String.valueOf(s);
                }
                Date date = DateChooserTglLahir.getDate();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                String cth = "update Pembeli set "
                        + "username='" + tfUsername.getText() + "'"
                        + ", no_telp='" + tfNoTelp.getText() + "'"
                        + ", password= HASHBYTES('SHA2_512', '" + pw + "')"
                        + ", nama_depan='" + tfNamaDepan.getText() + "'"
                        + ", nama_tengah='" + tfNamaTengah.getText() + "'"
                        + ", nama_belakang='" + tfNamaAkhir.getText() + "'"
                        + ", tanggal_lahir='" + sqlDate + "'"
                        + ", jalan='" + tfJalan.getText() + "'"
                        + ", kecamatan='" + tfKecamatan.getText() + "'"
                        + ", kota='" + tfKota.getText() + "'"
                        + ", no_rumah=" + tfNoRumah.getText()
                        + " where username='" + temp + "'";
                boolean gotResults = st.execute(cth);
                ResultSet rs = null;
                if (!gotResults) {
                    System.out.println("No results returned");
                } else {
                    rs = st.getResultSet();
                }
                JOptionPane.showMessageDialog(new PembeliFrame(), "Data Berhasil Di Simpan");
            } catch (SQLException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(new PembeliFrame(), "Data Berhasil Di Simpan");
            }
            try {
                PembeliFrame konek = new PembeliFrame();
                konek.setVisible(true);
                konek.tampilkanData();
                this.dispose();
                if (!temp.equals(tempPrimaryKey)) {
                    konek.tfUsername.setText(tempPrimaryKey);
                    konek.tfUsername.setText(tempPrimaryKey);
                } else {
                    konek.tfUsername.setText(temp);
                    konek.tfUsername.setText(temp);
                }

                konek.btnCari.doClick();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        try {
            PembeliFrame konek = new PembeliFrame();
            konek.setVisible(true);
            konek.tampilkanData();
            konek.klik();
            this.dispose();
//                    Date date = konek.DateChooserTglLahir.getDate();
//                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblPembeliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPembeliMouseClicked
        int baris = tblPembeli.rowAtPoint(evt.getPoint());
        String username = tblPembeli.getValueAt(baris, 0).toString();
        tfUsername.setText(username);
        primaryKeyNow = username;

        String noTelp = tblPembeli.getValueAt(baris, 1).toString();
        tfNoTelp.setText(noTelp);

        String password = tblPembeli.getValueAt(baris, 2).toString();
        tfPassword.setText(password);

        String namaDepan = tblPembeli.getValueAt(baris, 3).toString();
        tfNamaDepan.setText(namaDepan);

        var obj = tblPembeli.getValueAt(baris, 4);
        if (obj != null) {
            String namaTengah = tblPembeli.getValueAt(baris, 4).toString();
            tfNamaTengah.setText(namaTengah);
        } else {
            String namaTengah = "";
            tfNamaTengah.setText(namaTengah);
        }

        String namaAkhir = tblPembeli.getValueAt(baris, 5).toString();
        tfNamaAkhir.setText(namaAkhir);

        String date = tblPembeli.getValueAt(baris, 6).toString();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date2;
        try {
            date2 = formatter.parse(date);
            DateChooserTglLahir.setDate(date2);
        } catch (ParseException ex) {
            Logger.getLogger(PembeliFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        String jalan = tblPembeli.getValueAt(baris, 7).toString();
        tfJalan.setText(jalan);

        String kecamatan = tblPembeli.getValueAt(baris, 8).toString();
        tfKecamatan.setText(kecamatan);

        String kota = tblPembeli.getValueAt(baris, 9).toString();
        tfKota.setText(kota);

        String noRumah = tblPembeli.getValueAt(baris, 10).toString();
        tfNoRumah.setText(noRumah);
    }//GEN-LAST:event_tblPembeliMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String temp = tfCari.getText();
        if (temp.replaceAll("\\s", "").equals("")) {
            JOptionPane.showMessageDialog(new CabangFrame(), "Input Kosong");
        } else {
            connect();
            try {
                Statement st = conn.createStatement();
                String cariKueri1 = this.cariKueri + temp + "'";
                setTable = cariKueri1;
                try {
                    tampilkanData();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PembeliFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                ResultSet resultSet = st.executeQuery(cariKueri1);
                if (!resultSet.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(new CabangFrame(), "Tidak Ada Hasil");
                    tfCari.setText(temp);
                } else {

                    while (resultSet.next()) {
                        tfUsername.setText(resultSet.getString(1));
                        tfNoTelp.setText(resultSet.getString(2));
                        tfPassword.setText(resultSet.getString(3));
                        tfNamaDepan.setText(resultSet.getString(4));
                        tfNamaTengah.setText(resultSet.getString(5));
                        tfNamaAkhir.setText(resultSet.getString(6));

                        String date = resultSet.getDate(7).toString();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date date2;
                        try {
                            date2 = formatter.parse(date);
                            DateChooserTglLahir.setDate(date2);
                        } catch (ParseException ex) {
                            Logger.getLogger(PembeliFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        tfJalan.setText(resultSet.getString(8));
                        tfKecamatan.setText(resultSet.getString(9));
                        tfKota.setText(resultSet.getString(10));
                        tfNoRumah.setText(resultSet.getString(11));
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new CabangFrame(), e);
            }
        }
    }

    /*
    private void btnTambahDataActionPerformed() {
    }//GEN-LAST:event_btnCariActionPerformed
*/
    private void btnTambahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahDataActionPerformed
        String temp = tfUsername.getText();
        if (temp.replaceAll("\\s", "").equals("")) {
            JOptionPane.showMessageDialog(new PembeliFrame(), "Error");
            btnReset.doClick();
        } else {
            connect();
            try {
                Statement st = conn.createStatement();
                char[] pwc = tfPassword.getPassword();
                String pw = "";
                for (char s : pwc) {
                    pw += String.valueOf(s);
                }
                Date date = DateChooserTglLahir.getDate();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                String cth = "insert into Pembeli values("
                        + "'" + temp + "'"
                        + ", '" + tfNoTelp.getText() + "'"
                        + ", HASHBYTES('SHA2_512', '" + pw + "')"
                        + ", '" + tfNamaDepan.getText() + "'"
                        + ", '" + tfNamaTengah.getText() + "'"
                        + ", '" + tfNamaAkhir.getText() + "'"
                        + ", '" + sqlDate + "'"
                        + ", '" + tfJalan.getText() + "'"
                        + ", '" + tfKecamatan.getText() + "'"
                        + ", '" + tfKota.getText() + "'"
                        + ", " + tfNoRumah.getText()
                        + ")";
                boolean gotResults = st.execute(cth);
                ResultSet rs = null;
                if (!gotResults) {
                    System.out.println("No results returned");
                } else {
                    rs = st.getResultSet();
                }
                JOptionPane.showMessageDialog(new PembeliFrame(), "Data Berhasil Di Simpan");
            } catch (SQLException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(new PembeliFrame(), e);
            }
            try {
                PembeliFrame konek = new PembeliFrame();
                konek.setVisible(true);
                konek.tampilkanData();
                this.dispose();
                konek.tfUsername.setText(temp);
                konek.tfUsername.setText(temp);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnTambahDataActionPerformed

    private void cbSeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSeeActionPerformed
        if (cbSee.isSelected())
            tfPassword.setEchoChar((char) 0);
        else
            tfPassword.setEchoChar('*');
    }//GEN-LAST:event_cbSeeActionPerformed

    private void cbUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUsernameActionPerformed
        primaryKeyNow = tfCari.getText();
        cariKueri = "select * from Pembeli where username = '";
    }//GEN-LAST:event_cbUsernameActionPerformed

    private void tblPembeliCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPembeliCariMouseClicked
        int baris = tblPembeliCari.rowAtPoint(evt.getPoint());
        String username = tblPembeliCari.getValueAt(baris, 0).toString();
        tfUsername.setText(username);
        primaryKeyNow = username;

        String noTelp = tblPembeliCari.getValueAt(baris, 1).toString();
        tfNoTelp.setText(noTelp);

        String password = tblPembeliCari.getValueAt(baris, 2).toString();
        tfPassword.setText(password);

        String namaDepan = tblPembeliCari.getValueAt(baris, 3).toString();
        tfNamaDepan.setText(namaDepan);

        var obj = tblPembeliCari.getValueAt(baris, 4);
        if (obj != null) {
            String namaTengah = tblPembeliCari.getValueAt(baris, 4).toString();
            tfNamaTengah.setText(namaTengah);
        } else {
            String namaTengah = "";
            tfNamaTengah.setText(namaTengah);
        }

        String namaAkhir = tblPembeliCari.getValueAt(baris, 5).toString();
        tfNamaAkhir.setText(namaAkhir);

        String date = tblPembeliCari.getValueAt(baris, 6).toString();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date2;
        try {
            date2 = formatter.parse(date);
            DateChooserTglLahir.setDate(date2);
        } catch (ParseException ex) {
            Logger.getLogger(PembeliFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        String jalan = tblPembeliCari.getValueAt(baris, 7).toString();
        tfJalan.setText(jalan);

        String kecamatan = tblPembeliCari.getValueAt(baris, 8).toString();
        tfKecamatan.setText(kecamatan);

        String kota = tblPembeliCari.getValueAt(baris, 9).toString();
        tfKota.setText(kota);

        String noRumah = tblPembeliCari.getValueAt(baris, 10).toString();
        tfNoRumah.setText(noRumah);
    }//GEN-LAST:event_tblPembeliCariMouseClicked

    private void cbNamaDepanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNamaDepanActionPerformed
        cariKueri = "select * from Pembeli where nama_depan = '";
    }//GEN-LAST:event_cbNamaDepanActionPerformed

    private void cbNoTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNoTelpActionPerformed
        cariKueri = "select * from Pembeli where no_telp = '";
    }//GEN-LAST:event_cbNoTelpActionPerformed

    private void tblPembeliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPembeliKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP) {
            try {
                int baris = tblPembeli.getSelectedRow();
                String username = tblPembeli.getValueAt(baris, 0).toString();
                tfUsername.setText(username);
                primaryKeyNow = username;

                String noTelp = tblPembeli.getValueAt(baris, 1).toString();
                tfNoTelp.setText(noTelp);

                String password = tblPembeli.getValueAt(baris, 2).toString();
                tfPassword.setText(password);

                String namaDepan = tblPembeli.getValueAt(baris, 3).toString();
                tfNamaDepan.setText(namaDepan);

                var obj = tblPembeli.getValueAt(baris, 4);
                if (obj != null) {
                    String namaTengah = tblPembeli.getValueAt(baris, 4).toString();
                    tfNamaTengah.setText(namaTengah);
                } else {
                    String namaTengah = "";
                    tfNamaTengah.setText(namaTengah);
                }

                String namaAkhir = tblPembeli.getValueAt(baris, 5).toString();
                tfNamaAkhir.setText(namaAkhir);

                String date = tblPembeli.getValueAt(baris, 6).toString();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date2;
                try {
                    date2 = formatter.parse(date);
                    DateChooserTglLahir.setDate(date2);
                } catch (ParseException ex) {
                    Logger.getLogger(PembeliFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                String jalan = tblPembeli.getValueAt(baris, 7).toString();
                tfJalan.setText(jalan);

                String kecamatan = tblPembeli.getValueAt(baris, 8).toString();
                tfKecamatan.setText(kecamatan);

                String kota = tblPembeli.getValueAt(baris, 9).toString();
                tfKota.setText(kota);

                String noRumah = tblPembeli.getValueAt(baris, 10).toString();
                tfNoRumah.setText(noRumah);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_tblPembeliKeyReleased

    private void tblPembeliCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPembeliCariKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP) {
            try {
                int baris = tblPembeliCari.getSelectedRow();
                String username = tblPembeliCari.getValueAt(baris, 0).toString();
                tfUsername.setText(username);
                primaryKeyNow = username;

                String noTelp = tblPembeliCari.getValueAt(baris, 1).toString();
                tfNoTelp.setText(noTelp);

                String password = tblPembeliCari.getValueAt(baris, 2).toString();
                tfPassword.setText(password);

                String namaDepan = tblPembeliCari.getValueAt(baris, 3).toString();
                tfNamaDepan.setText(namaDepan);

                var obj = tblPembeliCari.getValueAt(baris, 4);
                if (obj != null) {
                    String namaTengah = tblPembeliCari.getValueAt(baris, 4).toString();
                    tfNamaTengah.setText(namaTengah);
                } else {
                    String namaTengah = "";
                    tfNamaTengah.setText(namaTengah);
                }

                String namaAkhir = tblPembeliCari.getValueAt(baris, 5).toString();
                tfNamaAkhir.setText(namaAkhir);

                String date = tblPembeliCari.getValueAt(baris, 6).toString();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date2;
                try {
                    date2 = formatter.parse(date);
                    DateChooserTglLahir.setDate(date2);
                } catch (ParseException ex) {
                    Logger.getLogger(PembeliFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                String jalan = tblPembeliCari.getValueAt(baris, 7).toString();
                tfJalan.setText(jalan);

                String kecamatan = tblPembeliCari.getValueAt(baris, 8).toString();
                tfKecamatan.setText(kecamatan);

                String kota = tblPembeliCari.getValueAt(baris, 9).toString();
                tfKota.setText(kota);

                String noRumah = tblPembeliCari.getValueAt(baris, 10).toString();
                tfNoRumah.setText(noRumah);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_tblPembeliCariKeyReleased

    void klik() {
        cbUsername.doClick();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CabangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CabangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CabangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CabangFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PembeliFrame konek = new PembeliFrame();
                    konek.setVisible(true);
                    konek.tampilkanData();
                    konek.klik();
//                    Date date = konek.DateChooserTglLahir.getDate();
//                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooserTglLahir;
    private javax.swing.JButton btnCabangFrameKembali;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.ButtonGroup btnGcari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahData;
    private javax.swing.JCheckBox cbNamaDepan;
    private javax.swing.JCheckBox cbNoTelp;
    private javax.swing.JCheckBox cbSee;
    private javax.swing.JCheckBox cbUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblPembeli;
    private javax.swing.JTable tblPembeliCari;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfJalan;
    private javax.swing.JTextField tfKecamatan;
    private javax.swing.JTextField tfKota;
    private javax.swing.JTextField tfNamaAkhir;
    private javax.swing.JTextField tfNamaDepan;
    private javax.swing.JTextField tfNamaTengah;
    private javax.swing.JTextField tfNoRumah;
    private javax.swing.JTextField tfNoTelp;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
