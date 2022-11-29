
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
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
public class PesananFrame extends javax.swing.JFrame {

    public PesananFrame() {
        initComponents();
    }

    private static Connection conn;
    private static String primaryKeyNow = "";
    private String cariKueri = "";
    private String setTable = "select * from Pesanan";

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
            PesananFrame.conn = DriverManager.getConnection(connectURL, sqlUser, sqlPassword);

        } catch (SQLException ex) {
            Logger.getLogger(PesananFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Connect to database successful!!");
    }

    void tampilkanData() throws ClassNotFoundException, SQLException {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Pesanan");
        model.addColumn("Username Pembeli");
        model.addColumn("Kode Pembayaran");
        model.addColumn("No Kasir");
        model.addColumn("Total");
        model.addColumn("Jenis Pengambilan");
        model.addColumn("Pengantar");
        model.addColumn("Tgl Pemesanan");

        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("ID Pesanan");
        model2.addColumn("Username Pembeli");
        model2.addColumn("Kode Pembayaran");
        model2.addColumn("No Kasir");
        model2.addColumn("Total");
        model2.addColumn("Jenis Pengambilan");
        model2.addColumn("Pengantar");
        model2.addColumn("Tgl Pemesanan");

        connect();
        int no = 1;
        Statement st = conn.createStatement();
        String cth = "select * from Pesanan";
        ResultSet resultSet = st.executeQuery(cth);
        while (resultSet.next()) {
            model.addRow(new Object[]{resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7), resultSet.getDate(8)});
        }
        tblPesanan.setModel(model);
        resultSet = st.executeQuery(setTable);
        while (resultSet.next()) {
            model2.addRow(new Object[]{resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7), resultSet.getDate(8)});
        }
        tblPesananCari.setModel(model2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGCari = new javax.swing.ButtonGroup();
        btnGPengambilan = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnCabangFrameKembali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfIdPesanan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfPembeli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfKodePembayaran = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfPegawai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfPengantar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesanan = new javax.swing.JTable();
        btnTambahData = new javax.swing.JButton();
        DateChooserTglPemesanan = new com.toedter.calendar.JDateChooser();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        cbTakeAway = new javax.swing.JCheckBox();
        cbDelivery = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        btnCari = new javax.swing.JButton();
        tfCari = new javax.swing.JTextField();
        cbIdPesanan = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPesananCari = new javax.swing.JTable();
        cbPembeli = new javax.swing.JCheckBox();
        cbPembayaran = new javax.swing.JCheckBox();
        cbPegawai = new javax.swing.JCheckBox();
        cbTotal = new javax.swing.JCheckBox();
        cbPengambilan = new javax.swing.JCheckBox();
        cbPengantar = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cabang");

        btnCabangFrameKembali.setText("Kembali");
        btnCabangFrameKembali.setToolTipText("");
        btnCabangFrameKembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCabangFrameKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCabangFrameKembaliActionPerformed(evt);
            }
        });

        jLabel1.setText("ID Pesanan");

        tfIdPesanan.setEditable(false);

        jLabel2.setText("Pembeli");

        tfPembeli.setEditable(false);

        jLabel4.setText("Kode Pembayaran");

        tfKodePembayaran.setEditable(false);

        jLabel5.setText("No Kasir");

        tfPegawai.setEditable(false);

        jLabel6.setText("Total");

        tfTotal.setEditable(false);

        jLabel7.setText("Tgl Pemesanan");

        jLabel8.setText("Pengambilan");

        jLabel9.setText("Pengantar");

        tfPengantar.setEditable(false);

        tblPesanan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesananMouseClicked(evt);
            }
        });
        tblPesanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPesananKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblPesanan);

        btnTambahData.setText("Tambah Data");
        btnTambahData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTambahData.setEnabled(false);
        btnTambahData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahDataActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus.setEnabled(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpan.setEnabled(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnGPengambilan.add(cbTakeAway);
        cbTakeAway.setText("Takeaway");
        cbTakeAway.setEnabled(false);

        btnGPengambilan.add(cbDelivery);
        cbDelivery.setText("Delivery");
        cbDelivery.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                        .addGap(1052, 1052, 1052))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(DateChooserTglPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(39, 39, 39)
                                .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfPengantar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfPembeli, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(tfIdPesanan))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbTakeAway, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfPegawai, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(tfKodePembayaran))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(383, Short.MAX_VALUE)
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
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfIdPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfKodePembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbTakeAway)
                        .addComponent(cbDelivery))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfPengantar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DateChooserTglPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(268, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
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
        btnCari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnGCari.add(cbIdPesanan);
        cbIdPesanan.setText("Id Pesanan");
        cbIdPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIdPesananActionPerformed(evt);
            }
        });

        tblPesananCari.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPesananCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesananCariMouseClicked(evt);
            }
        });
        tblPesananCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPesananCariKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblPesananCari);

        btnGCari.add(cbPembeli);
        cbPembeli.setText("Pembeli");
        cbPembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPembeliActionPerformed(evt);
            }
        });

        btnGCari.add(cbPembayaran);
        cbPembayaran.setText("Kode Pembayaran");
        cbPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPembayaranActionPerformed(evt);
            }
        });

        btnGCari.add(cbPegawai);
        cbPegawai.setText("ID Kasir");
        cbPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPegawaiActionPerformed(evt);
            }
        });

        btnGCari.add(cbTotal);
        cbTotal.setText("Total");
        cbTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTotalActionPerformed(evt);
            }
        });

        btnGCari.add(cbPengambilan);
        cbPengambilan.setText("Pengambilan");
        cbPengambilan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPengambilanActionPerformed(evt);
            }
        });

        btnGCari.add(cbPengantar);
        cbPengantar.setText("Username Pengantar");
        cbPengantar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPengantarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnCari)
                        .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbIdPesanan)
                                .addComponent(cbPegawai))
                            .addGap(7, 7, 7)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbPembeli)
                                .addComponent(cbTotal))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbPengambilan)
                                .addComponent(cbPembayaran))))
                    .addComponent(cbPengantar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCari)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbIdPesanan)
                    .addComponent(cbPembeli)
                    .addComponent(cbPembayaran))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPegawai)
                    .addComponent(cbTotal)
                    .addComponent(cbPengambilan))
                .addGap(18, 18, 18)
                .addComponent(cbPengantar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cari", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 71, Short.MAX_VALUE))
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
        String temp = tfIdPesanan.getText();
        if (temp.replaceAll("\\s", "").equals("")) {
            JOptionPane.showMessageDialog(new PembeliFrame(), "Error");
        } else {
            connect();
            try {
                Statement st = conn.createStatement();
                String cth2 = "select * from Pesanan where id_pesanan = '" + temp + "'";
                String cth = "delete from Pesanan where "
                        + "id_pesanan = '" + temp + "'";
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
                PesananFrame konek = new PesananFrame();
                konek.setVisible(true);
                konek.tampilkanData();
                this.dispose();
                tfIdPesanan.setText(temp);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        btnSimpan.setEnabled(true);
        btnTambahData.setEnabled(true);
        btnHapus.setEnabled(true);

        tfIdPesanan.setEditable(false);
        tfPembeli.setEditable(true);
        tfKodePembayaran.setEditable(true);
        tfPegawai.setEditable(true);
        tfTotal.setEditable(true);
        cbTakeAway.setEnabled(true);
        cbDelivery.setEnabled(true);
        tfPengantar.setEditable(true);

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String temp = primaryKeyNow;
        String tempPrimaryKey = tfIdPesanan.getText();
        if (temp.replaceAll("\\s", "").equals("")) {
            JOptionPane.showMessageDialog(new KasirFrame(), "Error");
            btnReset.doClick();
        } else {
            connect();
            try {
                Statement st = conn.createStatement();
                Date date = DateChooserTglPemesanan.getDate();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                String cth = "update Pesanan set "
                        + "username_pembeli='" + tfPembeli.getText() + "'"
                        + ", kode_pembayaran='" + tfKodePembayaran.getText() + "'"
                        + ", no_pegawai='" + tfPegawai.getText() + "'"
                        + ", total='" + tfTotal.getText() + "'"
                        + ", jenis_pengambilan='" + getSelectedButtonText(btnGPengambilan) + "'"
                        + ", username_pengantar='" + tfPengantar.getText() + "'"
                        + ", tgl_pemesanan='" + sqlDate + "'"
                        + " where id_pesanan='" + temp + "'";
                boolean gotResults = st.execute(cth);
                ResultSet rs = null;
                if (!gotResults) {
                    System.out.println("No results returned");
                } else {
                    rs = st.getResultSet();
                }
                JOptionPane.showMessageDialog(new KasirFrame(), "Data Berhasil Di Simpan");
            } catch (SQLException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(new KasirFrame(), e);
            }
            try {
                PesananFrame konek = new PesananFrame();
                konek.setVisible(true);
                konek.tampilkanData();
                this.dispose();
                if (!temp.equals(tempPrimaryKey)) {
                    konek.tfIdPesanan.setText(tempPrimaryKey);
                    konek.tfIdPesanan.setText(tempPrimaryKey);
                } else {
                    konek.tfIdPesanan.setText(temp);
                    konek.tfIdPesanan.setText(temp);
                }

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        try {
            PesananFrame konek = new PesananFrame();
            konek.setVisible(true);
            konek.tampilkanData();
            konek.klik();
            this.dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblPesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPesananMouseClicked
        int baris = tblPesanan.rowAtPoint(evt.getPoint());
        String username = tblPesanan.getValueAt(baris, 0).toString();
        tfIdPesanan.setText(username);
        primaryKeyNow = username;

        String noTelp = tblPesanan.getValueAt(baris, 1).toString();
        tfPembeli.setText(noTelp);

        String password = tblPesanan.getValueAt(baris, 2).toString();
        tfKodePembayaran.setText(password);

        String namaDepan = tblPesanan.getValueAt(baris, 3).toString();
        tfPegawai.setText(namaDepan);

        String namaAkhir = tblPesanan.getValueAt(baris, 4).toString();
        tfTotal.setText(namaAkhir);

        String date = tblPesanan.getValueAt(baris, 7).toString();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date2;
        try {
            date2 = formatter.parse(date);
            DateChooserTglPemesanan.setDate(date2);
        } catch (ParseException ex) {
            Logger.getLogger(KasirFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        String us = tblPesanan.getValueAt(baris, 5).toString();

        if (us.equalsIgnoreCase("Takeaway")) {
            cbTakeAway.setSelected(true);
        } else {
            cbDelivery.setSelected(true);
        }

        String gaji = tblPesanan.getValueAt(baris, 6).toString();
        tfPengantar.setText(gaji);

    }//GEN-LAST:event_tblPesananMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String temp = tfCari.getText();
        if (temp.replaceAll("\\s", "").equals("")) {
            JOptionPane.showMessageDialog(new KasirFrame(), "Input Kosong");
        } else {
            connect();
            try {
                Statement st = conn.createStatement();
                String cth = cariKueri + temp + "'";
                setTable = cth;
                try {
                    tampilkanData();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PesananFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                ResultSet resultSet = st.executeQuery(cth);
                if (!resultSet.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(new KasirFrame(), "Tidak Ada Hasil");
                    tfCari.setText(temp);
                } else {
                    while (resultSet.next()) {
                        tfIdPesanan.setText(resultSet.getString(1));
                        tfPembeli.setText(resultSet.getString(2));
                        tfKodePembayaran.setText(resultSet.getString(3));
                        tfPegawai.setText(resultSet.getString(4));
                        tfTotal.setText(resultSet.getString(5));

                        String date = resultSet.getDate(8).toString();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date date2;
                        try {
                            date2 = formatter.parse(date);
                            DateChooserTglPemesanan.setDate(date2);
                        } catch (ParseException ex) {
                            Logger.getLogger(PengantarFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String us = resultSet.getString(6);
                        if (us.equalsIgnoreCase("Takeaway")) {
                            cbTakeAway.setSelected(true);
                        } else {
                            cbDelivery.setSelected(true);
                        }
                        tfPengantar.setText(resultSet.getString(7));
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new KasirFrame(), e);
            }
        }
    }

    /*
    private void btnTambahDataActionPerformed() {
    }//GEN-LAST:event_btnCariActionPerformed
*/
    private void btnTambahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahDataActionPerformed
        String temp = "";
        tfIdPesanan.setText(temp);
        connect();
        try {
            Statement st = conn.createStatement();
            Date date = DateChooserTglPemesanan.getDate();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            String cth = "insert into Pesanan values("
                    + "'" + tfPembeli.getText() + "'"
                    + ", '" + tfKodePembayaran.getText() + "'"
                    + ", '" + tfPegawai.getText() + "'"
                    + ", '" + tfTotal.getText() + "'"
                    + ", '" + getSelectedButtonText(btnGPengambilan) + "'"
                    + ", '" + tfPengantar.getText() + "'"
                    + ", '" + sqlDate + "'"
                    + ")";
            boolean gotResults = st.execute(cth);
            ResultSet rs = null;
            if (!gotResults) {
                System.out.println("No results returned");
            } else {
                rs = st.getResultSet();
            }
            JOptionPane.showMessageDialog(new KasirFrame(), "Data Berhasil Di Simpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new KasirFrame(), e);
        }
        try {
            PesananFrame konek = new PesananFrame();
            konek.setVisible(true);
            konek.tampilkanData();
            this.dispose();
            konek.tfIdPesanan.setText(temp);
            konek.tfIdPesanan.setText(temp);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(KasirFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTambahDataActionPerformed

    private void tblPesananCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPesananCariMouseClicked
        int baris = tblPesananCari.rowAtPoint(evt.getPoint());
        String username = tblPesananCari.getValueAt(baris, 0).toString();
        tfIdPesanan.setText(username);
        primaryKeyNow = username;

        String noTelp = tblPesananCari.getValueAt(baris, 1).toString();
        tfPembeli.setText(noTelp);

        String password = tblPesananCari.getValueAt(baris, 2).toString();
        tfKodePembayaran.setText(password);

        String namaDepan = tblPesananCari.getValueAt(baris, 3).toString();
        tfPegawai.setText(namaDepan);

        String namaAkhir = tblPesananCari.getValueAt(baris, 4).toString();
        tfTotal.setText(namaAkhir);

        String date = tblPesananCari.getValueAt(baris, 7).toString();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date2;
        try {
            date2 = formatter.parse(date);
            DateChooserTglPemesanan.setDate(date2);
        } catch (ParseException ex) {
            Logger.getLogger(KasirFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        String us = tblPesananCari.getValueAt(baris, 5).toString();
        if (us.equalsIgnoreCase("Takeaway")) {
            cbTakeAway.setSelected(true);
        } else {
            cbDelivery.setSelected(true);
        }

        String gaji = tblPesananCari.getValueAt(baris, 6).toString();
        tfPengantar.setText(gaji);
    }//GEN-LAST:event_tblPesananCariMouseClicked

    private void cbIdPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIdPesananActionPerformed
        primaryKeyNow = tfCari.getText();
        cariKueri = "select * from Pesanan where id_pesanan = '";
    }//GEN-LAST:event_cbIdPesananActionPerformed

    private void cbPembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPembeliActionPerformed
        cariKueri = "select * from Pesanan where username_pembeli = '";
    }//GEN-LAST:event_cbPembeliActionPerformed

    private void cbPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPembayaranActionPerformed
        cariKueri = "select * from Pesanan where kode_pembayaran = '";
    }//GEN-LAST:event_cbPembayaranActionPerformed

    private void cbPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPegawaiActionPerformed
        cariKueri = "select * from Pesanan where no_pegawai = '";
    }//GEN-LAST:event_cbPegawaiActionPerformed

    private void cbTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTotalActionPerformed
        cariKueri = "select * from Pesanan where total = '";
    }//GEN-LAST:event_cbTotalActionPerformed

    private void cbPengambilanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPengambilanActionPerformed
        cariKueri = "select * from Pesanan where jenis_pengambilan = '";
    }//GEN-LAST:event_cbPengambilanActionPerformed

    private void cbPengantarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPengantarActionPerformed
        cariKueri = "select * from Pesanan where username_pengantar = '";
    }//GEN-LAST:event_cbPengantarActionPerformed

    private void tblPesananKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPesananKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP) {
            try {
                int baris = tblPesanan.getSelectedRow();
                String username = tblPesanan.getValueAt(baris, 0).toString();
                tfIdPesanan.setText(username);
                primaryKeyNow = username;

                String noTelp = tblPesanan.getValueAt(baris, 1).toString();
                tfPembeli.setText(noTelp);

                String password = tblPesanan.getValueAt(baris, 2).toString();
                tfKodePembayaran.setText(password);

                String namaDepan = tblPesanan.getValueAt(baris, 3).toString();
                tfPegawai.setText(namaDepan);

                String namaAkhir = tblPesanan.getValueAt(baris, 4).toString();
                tfTotal.setText(namaAkhir);

                String date = tblPesanan.getValueAt(baris, 7).toString();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date2;
                try {
                    date2 = formatter.parse(date);
                    DateChooserTglPemesanan.setDate(date2);
                } catch (ParseException ex) {
                    Logger.getLogger(KasirFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                String us = tblPesanan.getValueAt(baris, 5).toString();

                if (us.equalsIgnoreCase("Takeaway")) {
                    cbTakeAway.setSelected(true);
                } else {
                    cbDelivery.setSelected(true);
                }

                String gaji = tblPesanan.getValueAt(baris, 6).toString();
                tfPengantar.setText(gaji);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_tblPesananKeyReleased

    private void tblPesananCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPesananCariKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP) {
            try {
                int baris = tblPesananCari.getSelectedRow();
                String username = tblPesananCari.getValueAt(baris, 0).toString();
                tfIdPesanan.setText(username);
                primaryKeyNow = username;

                String noTelp = tblPesananCari.getValueAt(baris, 1).toString();
                tfPembeli.setText(noTelp);

                String password = tblPesananCari.getValueAt(baris, 2).toString();
                tfKodePembayaran.setText(password);

                String namaDepan = tblPesananCari.getValueAt(baris, 3).toString();
                tfPegawai.setText(namaDepan);

                String namaAkhir = tblPesananCari.getValueAt(baris, 4).toString();
                tfTotal.setText(namaAkhir);

                String date = tblPesananCari.getValueAt(baris, 7).toString();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date2;
                try {
                    date2 = formatter.parse(date);
                    DateChooserTglPemesanan.setDate(date2);
                } catch (ParseException ex) {
                    Logger.getLogger(KasirFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                String us = tblPesananCari.getValueAt(baris, 5).toString();
                if (us.equalsIgnoreCase("Takeaway")) {
                    cbTakeAway.setSelected(true);
                } else {
                    cbDelivery.setSelected(true);
                }

                String gaji = tblPesananCari.getValueAt(baris, 6).toString();
                tfPengantar.setText(gaji);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_tblPesananCariKeyReleased

    void klik() {
        cbIdPesanan.doClick();
        cbDelivery.doClick();
    }

    String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return "";
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
                    PesananFrame konek = new PesananFrame();
                    konek.setVisible(true);
                    konek.tampilkanData();
                    konek.klik();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooserTglPemesanan;
    private javax.swing.JButton btnCabangFrameKembali;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.ButtonGroup btnGCari;
    private javax.swing.ButtonGroup btnGPengambilan;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahData;
    private javax.swing.JCheckBox cbDelivery;
    private javax.swing.JCheckBox cbIdPesanan;
    private javax.swing.JCheckBox cbPegawai;
    private javax.swing.JCheckBox cbPembayaran;
    private javax.swing.JCheckBox cbPembeli;
    private javax.swing.JCheckBox cbPengambilan;
    private javax.swing.JCheckBox cbPengantar;
    private javax.swing.JCheckBox cbTakeAway;
    private javax.swing.JCheckBox cbTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTable tblPesanan;
    private javax.swing.JTable tblPesananCari;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfIdPesanan;
    private javax.swing.JTextField tfKodePembayaran;
    private javax.swing.JTextField tfPegawai;
    private javax.swing.JTextField tfPembeli;
    private javax.swing.JTextField tfPengantar;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
