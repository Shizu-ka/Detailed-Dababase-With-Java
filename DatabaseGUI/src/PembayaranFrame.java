
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class PembayaranFrame extends javax.swing.JFrame {

    public PembayaranFrame() {
        initComponents();
    }

    private static Connection conn;
    private static String primaryKeyNow = "";
    private String cariKueri = "";
    private String setTable = "select * from Pembayaran";

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
            PembayaranFrame.conn = DriverManager.getConnection(connectURL, sqlUser, sqlPassword);

        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Connect to database successful!!");
    }

    void tampilkanData() throws ClassNotFoundException, SQLException {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Pembayaran");
        model.addColumn("Metode Pembayaran");
        model.addColumn("Total");
        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("Kode Pembayaran");
        model2.addColumn("Metode Pembayaran");
        model2.addColumn("Total");

        connect();
        int no = 1;
        Statement st = conn.createStatement();
        String cth = "select * from Pembayaran";
        ResultSet resultSet = st.executeQuery(cth);
        while (resultSet.next()) {
            model.addRow(new Object[]{resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)});
        }
        tblPembayaran.setModel(model);

        resultSet = st.executeQuery(setTable);
        while (resultSet.next()) {
            model2.addRow(new Object[]{resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)});
        }
        tblPembayaranCari.setModel(model2);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGCari = new javax.swing.ButtonGroup();
        btnGMetodePembayaran = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnCabangFrameKembali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfKodePembayaran = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPembayaran = new javax.swing.JTable();
        btnTambahData = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        cbQris = new javax.swing.JCheckBox();
        cbCash = new javax.swing.JCheckBox();
        cbBca = new javax.swing.JCheckBox();
        cbBni = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        btnCari = new javax.swing.JButton();
        tfCari = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPembayaranCari = new javax.swing.JTable();
        cbKodePembayaran = new javax.swing.JCheckBox();
        cbMetodePembayaran = new javax.swing.JCheckBox();
        cbHarga = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pembayaran");

        btnCabangFrameKembali.setText("Kembali");
        btnCabangFrameKembali.setToolTipText("");
        btnCabangFrameKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCabangFrameKembaliActionPerformed(evt);
            }
        });

        jLabel1.setText("Kode Pembayaran");

        jLabel2.setText("Metode Pembayaran");

        jLabel3.setText("Total");

        tfTotal.setEditable(false);
        tfTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfTotalKeyPressed(evt);
            }
        });

        tblPembayaran.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPembayaranMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPembayaran);

        btnTambahData.setText("Tambah Data");
        btnTambahData.setEnabled(false);
        btnTambahData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahDataActionPerformed(evt);
            }
        });

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

        btnGMetodePembayaran.add(cbQris);
        cbQris.setText("Qris");
        cbQris.setEnabled(false);

        btnGMetodePembayaran.add(cbCash);
        cbCash.setText("Cash");
        cbCash.setEnabled(false);

        btnGMetodePembayaran.add(cbBca);
        cbBca.setText("BCA");
        cbBca.setEnabled(false);

        btnGMetodePembayaran.add(cbBni);
        cbBni.setText("BNI");
        cbBni.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfKodePembayaran, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addComponent(tfTotal))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbQris, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCash, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbBca, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbBni, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTambahData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset)
                        .addGap(43, 43, 43)))
                .addGap(108, 108, 108))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(409, Short.MAX_VALUE)
                    .addComponent(btnCabangFrameKembali)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfKodePembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbQris)
                    .addComponent(cbCash)
                    .addComponent(cbBca)
                    .addComponent(cbBni))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambahData)
                    .addComponent(btnHapus)
                    .addComponent(btnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnSimpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(568, Short.MAX_VALUE)
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

        tblPembayaranCari.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPembayaranCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPembayaranCariMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPembayaranCari);

        btnGCari.add(cbKodePembayaran);
        cbKodePembayaran.setText("Kode Pembayaran");
        cbKodePembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKodePembayaranActionPerformed(evt);
            }
        });

        btnGCari.add(cbMetodePembayaran);
        cbMetodePembayaran.setText("Metode Pembayaran");
        cbMetodePembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMetodePembayaranActionPerformed(evt);
            }
        });

        btnGCari.add(cbHarga);
        cbHarga.setText("Harga");
        cbHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHargaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbKodePembayaran)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMetodePembayaran)
                                .addGap(4, 4, 4)
                                .addComponent(cbHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCari)
                            .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCari)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKodePembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMetodePembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
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
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
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

    private void btnTambahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahDataActionPerformed
        String temp = "";
        tfKodePembayaran.setText(temp);
        connect();
        try {
            Statement st = conn.createStatement();
            String cth = "insert into Pembayaran values('"
                    + getSelectedButtonText(btnGMetodePembayaran) + "'"
                    + ", " + tfTotal.getText()
                    + ")";

            boolean gotResults = st.execute(cth);
            ResultSet rs = null;
            if (!gotResults) {
                System.out.println("No results returned");
            } else {
                rs = st.getResultSet();
            }
            JOptionPane.showMessageDialog(new MenuFrame(), "Data Berhasil Di Simpan");
//            ResultSet resultSet = st.executeQuery(cth);
//            resultSet = st.getResultSet();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new MenuFrame(), e);
        }
        try {
            PembayaranFrame konek = new PembayaranFrame();
            konek.setVisible(true);
            konek.tampilkanData();
            this.dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTambahDataActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        btnHapus.setEnabled(true);
        btnTambahData.setEnabled(true);
        btnSimpan.setEnabled(true);

        tfKodePembayaran.setEditable(false);
        cbQris.setEnabled(true);
        cbCash.setEnabled(true);
        cbBca.setEnabled(true);
        cbBni.setEnabled(true);
        tfTotal.setEditable(true);

    }//GEN-LAST:event_btnEditActionPerformed

    private void tblPembayaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPembayaranMouseClicked
        int baris = tblPembayaran.rowAtPoint(evt.getPoint());
        String Idmenu = tblPembayaran.getValueAt(baris, 0).toString();
        tfKodePembayaran.setText(Idmenu);
        primaryKeyNow = Idmenu;

        String nm = tblPembayaran.getValueAt(baris, 1).toString();
        switch (nm.toLowerCase()) {
            case "qris" ->
                cbQris.setSelected(true);
            case "cash" ->
                cbCash.setSelected(true);
            case "bca" ->
                cbBca.setSelected(true);
            case "bni" ->
                cbBni.setSelected(true);
        }

        String harga = tblPembayaran.getValueAt(baris, 2).toString();
        tfTotal.setText(harga);
    }//GEN-LAST:event_tblPembayaranMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String temp = tfCari.getText();
        if (temp.replaceAll("\\s", "").equals("")) {
            JOptionPane.showMessageDialog(new CabangFrame(), "Input Kosong");
        } else {
            connect();
            try {
                Statement st = conn.createStatement();
                String cth = this.cariKueri + temp + "'";
                setTable = cth;
                try {
                    tampilkanData();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PembeliFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                ResultSet resultSet = st.executeQuery(cth);
                if (!resultSet.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(new CabangFrame(), "Tidak Ada Hasil");
                    tfCari.setText(temp);
                } else {
                    while (resultSet.next()) {
                        tfKodePembayaran.setText(resultSet.getString(1));
                        String us = resultSet.getString(2);
                        switch (us.toLowerCase()) {
                            case "qris" ->
                                cbQris.setSelected(true);
                            case "cash" ->
                                cbCash.setSelected(true);
                            case "bca" ->
                                cbBca.setSelected(true);
                            case "bni" ->
                                cbBni.setSelected(true);
                        }
                        tfTotal.setText(resultSet.getString(3));
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new MenuFrame(), e);
            }
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String temp = primaryKeyNow;
        if (temp.replaceAll("\\s", "").equals("")) {
            JOptionPane.showMessageDialog(new CabangFrame(), "Error");
            btnReset.doClick();
        } else {
            connect();
            try {
                Statement st = conn.createStatement();
                String cth = "update Pembayaran set "
                        + "metode_pemabayaran='" + getSelectedButtonText(btnGMetodePembayaran) + "'"
                        + ", harga=" + tfTotal.getText()
                        + " where kode_pembayaran='" + temp + "'";
                boolean gotResults = st.execute(cth);
                ResultSet rs = null;
                if (!gotResults) {
                    System.out.println("No results returned");
                } else {
                    rs = st.getResultSet();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new CabangFrame(), e);
            }
            try {
                MenuFrame konek = new MenuFrame();
                konek.setVisible(true);
                konek.tampilkanData();
                this.dispose();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        try {
            MenuFrame konek = new MenuFrame();
            konek.setVisible(true);
            konek.tampilkanData();
            konek.klik();
            this.dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        String temp = tfKodePembayaran.getText();
        if (temp.replaceAll("\\s", "").equals("")) {
            JOptionPane.showMessageDialog(new CabangFrame(), "Error");
            btnReset.doClick();
        } else {
            connect();
            try {
                Statement st = conn.createStatement();
                String cth2 = "select * from Menu where id_menu = '" + temp + "'";
                String cth = "delete from Menu where "
                        + "id_menu = '" + temp + "'";
                ResultSet resultSet = st.executeQuery(cth2);
                if (!resultSet.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(new CabangFrame(), "Tidak Ada Hasil");
                } else {
                    boolean gotResults = st.execute(cth);
                    ResultSet rs = null;
                    if (!gotResults) {
                        System.out.println("No results returned");
                    } else {
                        rs = st.getResultSet();
                    }
                    JOptionPane.showMessageDialog(new CabangFrame(), "Data Berhasil Di Hapus");
                }
            } catch (SQLException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(new CabangFrame(), e);
            }
            try {
                MenuFrame konek = new MenuFrame();
                konek.setVisible(true);
                konek.tampilkanData();
                this.dispose();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void cbKodePembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKodePembayaranActionPerformed
        primaryKeyNow = tfCari.getText();
        cariKueri = "select * from Menu where id_menu = '";
    }//GEN-LAST:event_cbKodePembayaranActionPerformed

    private void cbMetodePembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMetodePembayaranActionPerformed
        cariKueri = "select * from Menu where nama_menu = '";
    }//GEN-LAST:event_cbMetodePembayaranActionPerformed

    private void cbHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHargaActionPerformed
        cariKueri = "select * from Menu where harga = '";
    }//GEN-LAST:event_cbHargaActionPerformed

    private void tblPembayaranCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPembayaranCariMouseClicked
        int baris = tblPembayaranCari.rowAtPoint(evt.getPoint());
        String Idmenu = tblPembayaranCari.getValueAt(baris, 0).toString();
        tfKodePembayaran.setText(Idmenu);
        primaryKeyNow = Idmenu;

        String nm = tblPembayaran.getValueAt(baris, 1).toString();
        tfMetodePembayaran.setText(nm);

        String harga = tblPembayaran.getValueAt(baris, 2).toString();
        tfTotal.setText(harga);
    }//GEN-LAST:event_tblPembayaranCariMouseClicked

    private void tfTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTotalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnTambahData.doClick();
        }
    }//GEN-LAST:event_tfTotalKeyPressed

    void klik() {
        cbKodePembayaran.doClick();
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
                    PembayaranFrame konek = new PembayaranFrame();
                    konek.setVisible(true);
                    konek.tampilkanData();
                    konek.klik();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCabangFrameKembali;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.ButtonGroup btnGCari;
    private javax.swing.ButtonGroup btnGMetodePembayaran;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahData;
    private javax.swing.JCheckBox cbBca;
    private javax.swing.JCheckBox cbBni;
    private javax.swing.JCheckBox cbCash;
    private javax.swing.JCheckBox cbHarga;
    private javax.swing.JCheckBox cbKodePembayaran;
    private javax.swing.JCheckBox cbMetodePembayaran;
    private javax.swing.JCheckBox cbQris;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblPembayaran;
    private javax.swing.JTable tblPembayaranCari;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfKodePembayaran;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables

}
