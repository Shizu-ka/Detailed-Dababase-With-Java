
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class KeranjangBelanjaFrame extends javax.swing.JFrame {

    public KeranjangBelanjaFrame() {
        initComponents();
    }

    private static Connection conn;
    private static String primaryKeyNow = "";
    private String cariKueri = "";
    private String setTable = "select * from KeranjangBelanja";

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
            KeranjangBelanjaFrame.conn = DriverManager.getConnection(connectURL, sqlUser, sqlPassword);

        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Connect to database successful!!");
    }

    void tampilkanData() throws ClassNotFoundException, SQLException {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Username Pembeli");
        model.addColumn("ID Menu");
        model.addColumn("Kuantitas");
        model.addColumn("Total");
        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("Username Pembeli");
        model2.addColumn("ID Menu");
        model2.addColumn("Kuantitas");
        model2.addColumn("Total");

        connect();
        int no = 1;
        Statement st = conn.createStatement();
        String cth = "select * from KeranjangBelanja";
        ResultSet resultSet = st.executeQuery(cth);
        while (resultSet.next()) {
            model.addRow(new Object[]{resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4)});
        }
        tblKeranjangBelanja.setModel(model);
        resultSet = st.executeQuery(setTable);
        while (resultSet.next()) {
            model2.addRow(new Object[]{resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4)});
        }
        tblKeranjangBelanjaCari.setModel(model2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGCari = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnCabangFrameKembali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfUsernamePembeli = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfIdMenu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfKuantitas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKeranjangBelanja = new javax.swing.JTable();
        btnTambahData = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        tfTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCari = new javax.swing.JButton();
        tfCari = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKeranjangBelanjaCari = new javax.swing.JTable();
        cbUsernamePembeli = new javax.swing.JCheckBox();
        cbIdMenu = new javax.swing.JCheckBox();
        cbKuantitas = new javax.swing.JCheckBox();
        cbTotal = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cabang");

        btnCabangFrameKembali.setText("Kembali");
        btnCabangFrameKembali.setToolTipText("");
        btnCabangFrameKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCabangFrameKembaliActionPerformed(evt);
            }
        });

        jLabel1.setText("Username Pembeli");

        tfUsernamePembeli.setEditable(false);

        jLabel2.setText("ID Menu");

        tfIdMenu.setEditable(false);
        tfIdMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdMenuActionPerformed(evt);
            }
        });

        jLabel3.setText("Kuantitas");

        tfKuantitas.setEditable(false);
        tfKuantitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKuantitasActionPerformed(evt);
            }
        });
        tfKuantitas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfKuantitasKeyPressed(evt);
            }
        });

        tblKeranjangBelanja.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKeranjangBelanja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKeranjangBelanjaMouseClicked(evt);
            }
        });
        tblKeranjangBelanja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblKeranjangBelanjaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblKeranjangBelanja);

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

        tfTotal.setEditable(false);
        tfTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTotalActionPerformed(evt);
            }
        });
        tfTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfTotalKeyPressed(evt);
            }
        });

        jLabel4.setText("Total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGap(113, 113, 113))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfIdMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(tfUsernamePembeli)
                    .addComponent(tfKuantitas)
                    .addComponent(tfTotal))
                .addGap(21, 21, 21))
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
                    .addComponent(tfUsernamePembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfIdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfKuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambahData)
                    .addComponent(btnHapus)
                    .addComponent(btnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnSimpan))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
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

        tblKeranjangBelanjaCari.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKeranjangBelanjaCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKeranjangBelanjaCariMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblKeranjangBelanjaCari);

        btnGCari.add(cbUsernamePembeli);
        cbUsernamePembeli.setText("Username Pembeli");
        cbUsernamePembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUsernamePembeliActionPerformed(evt);
            }
        });

        btnGCari.add(cbIdMenu);
        cbIdMenu.setText("ID Menu");
        cbIdMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIdMenuActionPerformed(evt);
            }
        });

        btnGCari.add(cbKuantitas);
        cbKuantitas.setText("Kuantitas");
        cbKuantitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKuantitasActionPerformed(evt);
            }
        });

        btnGCari.add(cbTotal);
        cbTotal.setText("Total");
        cbTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCari)
                            .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(cbUsernamePembeli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbIdMenu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbKuantitas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTotal)
                        .addGap(79, 79, 79))))
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
                    .addComponent(cbUsernamePembeli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbIdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbKuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        tfUsernamePembeli.setText(temp);
        connect();
        try {
            Statement st = conn.createStatement();
            String cth = "insert into KeranjangBelanja values('"
                    + tfUsernamePembeli.getText() + "'"
                    + ", " + tfIdMenu.getText()
                    + ", " + tfKuantitas.getText()
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
            KeranjangBelanjaFrame konek = new KeranjangBelanjaFrame();
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

        tfTotal.setEditable(true);
        tfUsernamePembeli.setEditable(true);
        tfIdMenu.setEditable(true);
        tfKuantitas.setEditable(true);

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String temp = tfCari.getText();
        if (temp.replaceAll("\\s", "").equals("")) {
            JOptionPane.showMessageDialog(new KeranjangBelanjaFrame(), "Input Kosong");
        } else {
            connect();
            try {
                Statement st = conn.createStatement();
                String cth = this.cariKueri + temp + "'";
                setTable = cth;
                try {
                    tampilkanData();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(KeranjangBelanjaFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                ResultSet resultSet = st.executeQuery(cth);
                if (!resultSet.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(new KeranjangBelanjaFrame(), "Tidak Ada Hasil");
                    tfCari.setText(temp);
                } else {
                    while (resultSet.next()) {
                        tfUsernamePembeli.setText(resultSet.getString(1));
                        tfIdMenu.setText(resultSet.getString(2));
                        tfKuantitas.setText(resultSet.getString(3));
                        tfTotal.setText(resultSet.getString(4));
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new KeranjangBelanjaFrame(), e);
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
                String cth = "update KeranjangBelanja set "
                        + "username_pembeli='" + tfIdMenu.getText() + "'"
                        + ", id_menu=" + tfKuantitas.getText()
                        + ", kuantitas='" + tfKuantitas.getText() + "'"
                        + ", total='" + tfTotal.getText() + "'"
                        + " where username_pembeli='" + temp + "'";
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
                KeranjangBelanjaFrame konek = new KeranjangBelanjaFrame();
                konek.setVisible(true);
                konek.tampilkanData();
                this.dispose();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        try {
            KeranjangBelanjaFrame konek = new KeranjangBelanjaFrame();
            konek.setVisible(true);
            konek.tampilkanData();
            konek.klik();
            this.dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        String temp = tfUsernamePembeli.getText();
        if (temp.replaceAll("\\s", "").equals("")) {
            JOptionPane.showMessageDialog(new KeranjangBelanjaFrame(), "Error");
        } else {
            connect();
            try {
                Statement st = conn.createStatement();
                String cth2 = "select * from KeranjangBelanja where username_pembeli = '" + temp + "'";
                String cth = "delete from KeranjangBelanja where "
                        + "username_pembeli = '" + temp + "'";
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
                KeranjangBelanjaFrame konek = new KeranjangBelanjaFrame();
                konek.setVisible(true);
                konek.tampilkanData();
                this.dispose();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void cbUsernamePembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUsernamePembeliActionPerformed
        primaryKeyNow = tfCari.getText();
        cariKueri = "select * from KeranjangBelanja where username_pembeli = '";
    }//GEN-LAST:event_cbUsernamePembeliActionPerformed

    private void cbIdMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIdMenuActionPerformed
        cariKueri = "select * from KeranjangBelanja where id_menu = '";
    }//GEN-LAST:event_cbIdMenuActionPerformed

    private void cbKuantitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKuantitasActionPerformed
        cariKueri = "select * from KeranjangBelanja where kuantitas = '";
    }//GEN-LAST:event_cbKuantitasActionPerformed

    private void tblKeranjangBelanjaCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKeranjangBelanjaCariMouseClicked
        int baris = tblKeranjangBelanjaCari.rowAtPoint(evt.getPoint());
        String Idmenu = tblKeranjangBelanjaCari.getValueAt(baris, 0).toString();
        tfUsernamePembeli.setText(Idmenu);
        primaryKeyNow = Idmenu;

        String nm = tblKeranjangBelanjaCari.getValueAt(baris, 1).toString();
        tfIdMenu.setText(nm);

        String harga = tblKeranjangBelanjaCari.getValueAt(baris, 2).toString();
        tfKuantitas.setText(harga);
        
        String total = tblKeranjangBelanjaCari.getValueAt(baris, 3).toString();
        tfTotal.setText(harga);
    }//GEN-LAST:event_tblKeranjangBelanjaCariMouseClicked

    private void tfIdMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdMenuActionPerformed

    }//GEN-LAST:event_tfIdMenuActionPerformed

    private void tfKuantitasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfKuantitasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnTambahData.doClick();
        }
    }//GEN-LAST:event_tfKuantitasKeyPressed

    private void tfKuantitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKuantitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfKuantitasActionPerformed

    private void tblKeranjangBelanjaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeranjangBelanjaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP) {
            try {
                int baris = tblKeranjangBelanja.getSelectedRow();
                System.out.println(baris);
                String Idmenu = tblKeranjangBelanja.getValueAt(baris, 0).toString();
                tfUsernamePembeli.setText(Idmenu);
                primaryKeyNow = Idmenu;

                String nm = tblKeranjangBelanja.getValueAt(baris, 1).toString();
                tfIdMenu.setText(nm);

                String harga = tblKeranjangBelanja.getValueAt(baris, 2).toString();
                tfKuantitas.setText(harga);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_tblKeranjangBelanjaKeyReleased

    private void tfTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTotalActionPerformed

    private void tfTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTotalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTotalKeyPressed

    private void cbTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTotalActionPerformed
        cariKueri = "select * from KeranjangBelanja where total = '";
    }//GEN-LAST:event_cbTotalActionPerformed

    private void tblKeranjangBelanjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKeranjangBelanjaMouseClicked
        int baris = tblKeranjangBelanja.rowAtPoint(evt.getPoint());
        String Idmenu = tblKeranjangBelanja.getValueAt(baris, 0).toString();
        tfUsernamePembeli.setText(Idmenu);
        primaryKeyNow = Idmenu;

        String nm = tblKeranjangBelanja.getValueAt(baris, 1).toString();
        tfIdMenu.setText(nm);

        String harga = tblKeranjangBelanja.getValueAt(baris, 2).toString();
        tfKuantitas.setText(harga);
        
        String total = tblKeranjangBelanja.getValueAt(baris, 3).toString();
        tfTotal.setText(harga);
    }//GEN-LAST:event_tblKeranjangBelanjaMouseClicked

//    @Override
//    public void actionPerformed(ActionEvent event) {
//        
//    }
    void klik() {
        cbUsernamePembeli.doClick();
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
                    KeranjangBelanjaFrame konek = new KeranjangBelanjaFrame();
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
    private javax.swing.JButton btnCabangFrameKembali;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.ButtonGroup btnGCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahData;
    private javax.swing.JCheckBox cbIdMenu;
    private javax.swing.JCheckBox cbKuantitas;
    private javax.swing.JCheckBox cbTotal;
    private javax.swing.JCheckBox cbUsernamePembeli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblKeranjangBelanja;
    private javax.swing.JTable tblKeranjangBelanjaCari;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfIdMenu;
    private javax.swing.JTextField tfKuantitas;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JTextField tfUsernamePembeli;
    // End of variables declaration//GEN-END:variables

}
