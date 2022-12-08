
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
public class PengantarFrame extends javax.swing.JFrame {

    public PengantarFrame() {
        initComponents();
    }

    private static Connection conn;
    private static String primaryKeyNow = "";
    private String cariKueri = "";
    private String setTable = "select * from Pengantar";

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
            PengantarFrame.conn = DriverManager.getConnection(connectURL, sqlUser, sqlPassword);

        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Connect to database successful!!");
    }

    void tampilkanData() throws ClassNotFoundException, SQLException {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Username");
        model.addColumn("No Plat");
        model.addColumn("No Telp");
        model.addColumn("Password");
        model.addColumn("Nama Depan");
        model.addColumn("Nama Tengah");
        model.addColumn("Nama Akhir");
        model.addColumn("Gaji");
        model.addColumn("Nama Cabang");

        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("Username");
        model2.addColumn("No Plat");
        model2.addColumn("No Telp");
        model2.addColumn("Password");
        model2.addColumn("Nama Depan");
        model2.addColumn("Nama Tengah");
        model2.addColumn("Nama Akhir");
        model2.addColumn("Gaji");
        model2.addColumn("Nama Cabang");

        connect();
        int no = 1;
        Statement st = conn.createStatement();
        String cth = "select * from Pengantar";
        String cth2 = "select nama_cabang from Cabang";
        ResultSet resultSet = st.executeQuery(cth);
        while (resultSet.next()) {
            model.addRow(new Object[]{resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getString(9)});
        }
        tblPengantar.setModel(model);
        ResultSet resultSet2 = st.executeQuery(cth2);
        while (resultSet2.next()) {
            cbCabang.addItem(resultSet2.getString(1));
        }
        resultSet = st.executeQuery(setTable);
        while (resultSet.next()) {
            model2.addRow(new Object[]{resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getString(9)});
        }
        tblPengantarCari.setModel(model2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGCari = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnCabangFrameKembali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfNoTelp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfNoPol = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfNamaDepan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfNamaTengah = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfNamaAkhir = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfGaji = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPengantar = new javax.swing.JTable();
        btnTambahData = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        tfPassword = new javax.swing.JPasswordField();
        cbSee = new javax.swing.JCheckBox();
        cbCabang = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnCari = new javax.swing.JButton();
        tfCari = new javax.swing.JTextField();
        cbUsername = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPengantarCari = new javax.swing.JTable();
        cbNamaDepan = new javax.swing.JCheckBox();
        cbNoTelp = new javax.swing.JCheckBox();
        cbNoPlat = new javax.swing.JCheckBox();
        cbNamaCabang = new javax.swing.JCheckBox();
        cbGaji = new javax.swing.JCheckBox();
        cbNamaBelakang = new javax.swing.JCheckBox();

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

        jLabel1.setText("Username");

        tfNoTelp.setEditable(false);

        jLabel2.setText("No Plat");

        tfNoPol.setEditable(false);

        jLabel3.setText("Password");

        jLabel4.setText("Nama Depan");

        tfNamaDepan.setEditable(false);

        jLabel5.setText("Nama Tengah");

        tfNamaTengah.setEditable(false);

        jLabel6.setText("Nama Akhir");

        tfNamaAkhir.setEditable(false);

        jLabel8.setText("No Telp");

        tfUsername.setEditable(false);

        jLabel9.setText("Gaji");

        tfGaji.setEditable(false);

        jLabel10.setText("Cabang");

        tblPengantar.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPengantar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPengantarMouseClicked(evt);
            }
        });
        tblPengantar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPengantarKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblPengantar);

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

        tfPassword.setEditable(false);

        cbSee.setText("See");
        cbSee.setBorder(null);
        cbSee.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/eye.png"))); // NOI18N
        cbSee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSeeActionPerformed(evt);
            }
        });

        cbCabang.setEditable(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNamaTengah))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCabang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfGaji)
                            .addComponent(tfNamaDepan)
                            .addComponent(tfUsername)
                            .addComponent(tfNamaAkhir, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                            .addComponent(tfNoPol)
                            .addComponent(tfNoTelp, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbSee)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(864, 864, 864))
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
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNoPol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbCabang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(235, Short.MAX_VALUE))
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

        btnGCari.add(cbUsername);
        cbUsername.setText("Username");
        cbUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUsernameActionPerformed(evt);
            }
        });

        tblPengantarCari.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPengantarCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPengantarCariMouseClicked(evt);
            }
        });
        tblPengantarCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPengantarCariKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblPengantarCari);

        btnGCari.add(cbNamaDepan);
        cbNamaDepan.setText("Nama Depan");
        cbNamaDepan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNamaDepanActionPerformed(evt);
            }
        });

        btnGCari.add(cbNoTelp);
        cbNoTelp.setText("No Telp");
        cbNoTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNoTelpActionPerformed(evt);
            }
        });

        btnGCari.add(cbNoPlat);
        cbNoPlat.setText("No Plat");
        cbNoPlat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNoPlatActionPerformed(evt);
            }
        });

        btnGCari.add(cbNamaCabang);
        cbNamaCabang.setText("Nama Cabang");
        cbNamaCabang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNamaCabangActionPerformed(evt);
            }
        });

        btnGCari.add(cbGaji);
        cbGaji.setText("Gaji");
        cbGaji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGajiActionPerformed(evt);
            }
        });

        btnGCari.add(cbNamaBelakang);
        cbNamaBelakang.setText("Nama Belakang");
        cbNamaBelakang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNamaBelakangActionPerformed(evt);
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
                                .addComponent(cbNoPlat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbUsername))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbNamaDepan)
                                .addComponent(cbNamaCabang))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbGaji)
                                .addComponent(cbNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(cbNamaBelakang))
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
                    .addComponent(cbUsername)
                    .addComponent(cbNamaDepan)
                    .addComponent(cbNoTelp))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbNoPlat)
                    .addComponent(cbNamaCabang)
                    .addComponent(cbGaji))
                .addGap(18, 18, 18)
                .addComponent(cbNamaBelakang)
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
        this.dispose();
    }//GEN-LAST:event_btnCabangFrameKembaliActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        String temp = tfUsername.getText();
        if (temp.replaceAll("\\s", "").equals("")) {
            JOptionPane.showMessageDialog(new PembeliFrame(), "Error");
        } else {
            connect();
            try {
                Statement st = conn.createStatement();
                String cth2 = "select * from Pengantar where username = '" + temp + "'";
                String cth = "delete from Pengantar where "
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
                JOptionPane.showMessageDialog(new PengantarFrame(), e);
            }
            try {
                PengantarFrame konek = new PengantarFrame();
                konek.setVisible(true);
                konek.tampilkanData();
                this.dispose();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        btnSimpan.setEnabled(true);
        btnTambahData.setEnabled(true);
        btnHapus.setEnabled(true);

        tfNoTelp.setEditable(true);
        tfUsername.setEditable(true);
        tfNoPol.setEditable(true);
        tfPassword.setEditable(true);
        tfNamaDepan.setEditable(true);
        tfNamaTengah.setEditable(true);
        tfNamaAkhir.setEditable(true);
        tfUsername.setEditable(true);
        tfGaji.setEditable(true);
        cbCabang.setEditable(true);

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String temp = primaryKeyNow;
        String tempPrimaryKey = tfNoTelp.getText();
        if (temp.replaceAll("\\s", "").equals("")) {
            JOptionPane.showMessageDialog(new PengantarFrame(), "Error");
        } else {
            connect();
            try {
                Statement st = conn.createStatement();
                char[] pwc = tfPassword.getPassword();
                String pw = "";
                for (char s : pwc) {
                    pw += String.valueOf(s);
                }
                String cth = "update Pengantar set "
                        + "username='" + tfUsername.getText() + "'"
                        + ", no_pol='" + tfNoPol.getText() + "'"
                        + ", no_telp='" + tfNoTelp.getText() + "'"
                        + ", password= HASHBYTES('SHA2_512', '" + pw + "')"
                        + ", nama_depan='" + tfNamaDepan.getText() + "'"
                        + ", nama_tengah='" + tfNamaTengah.getText() + "'"
                        + ", nama_belakang='" + tfNamaAkhir.getText() + "'"
                        + ", nama_cabang='" + cbCabang.getSelectedItem() + "'"
                        + ", gaji=" + tfGaji.getText()
                        + " where username='" + temp + "'";
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
                PengantarFrame konek = new PengantarFrame();
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
            PengantarFrame konek = new PengantarFrame();
            konek.setVisible(true);
            konek.tampilkanData();
            konek.klik();
            this.dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblPengantarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPengantarMouseClicked
        int baris = tblPengantar.rowAtPoint(evt.getPoint());
        String username = tblPengantar.getValueAt(baris, 0).toString();
        tfUsername.setText(username);
        primaryKeyNow = username;

        String noPol = tblPengantar.getValueAt(baris, 1).toString();
        tfNoPol.setText(noPol);

        String noTelp = tblPengantar.getValueAt(baris, 2).toString();
        tfNoTelp.setText(noTelp);

        String password = tblPengantar.getValueAt(baris, 3).toString();
        tfPassword.setText(password);

        String namaDepan = tblPengantar.getValueAt(baris, 4).toString();
        tfNamaDepan.setText(namaDepan);

        var obj = tblPengantar.getValueAt(baris, 5);
        if (obj != null) {
            String namaTengah = tblPengantar.getValueAt(baris, 4).toString();
            tfNamaTengah.setText(namaTengah);
        } else {
            String namaTengah = "";
            tfNamaTengah.setText(namaTengah);
        }

        String namaAkhir = tblPengantar.getValueAt(baris, 6).toString();
        tfNamaAkhir.setText(namaAkhir);

        String gaji = tblPengantar.getValueAt(baris, 7).toString();
        tfGaji.setText(gaji);

        String kota = tblPengantar.getValueAt(baris, 8).toString();
        cbCabang.setSelectedItem(kota);
    }//GEN-LAST:event_tblPengantarMouseClicked

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
                    Logger.getLogger(KasirFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                ResultSet resultSet = st.executeQuery(cth);
                if (!resultSet.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(new KasirFrame(), "Tidak Ada Hasil");
                    tfCari.setText(temp);
                } else {
                    while (resultSet.next()) {
                        tfUsername.setText(resultSet.getString(1));
                        tfNoPol.setText(resultSet.getString(2));
                        tfNoTelp.setText(resultSet.getString(3));
                        tfPassword.setText(resultSet.getString(4));
                        tfNamaDepan.setText(resultSet.getString(5));
                        tfNamaTengah.setText(resultSet.getString(6));
                        tfNamaAkhir.setText(resultSet.getString(7));
                        tfGaji.setText(resultSet.getString(8));
                        cbCabang.setSelectedItem(resultSet.getString(9));
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new PengantarFrame(), e);
            }
        }
    }

    /*
    private void btnTambahDataActionPerformed() {
    }//GEN-LAST:event_btnCariActionPerformed
*/
    private void btnTambahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahDataActionPerformed
        String temp = "";
        tfNoTelp.setText(temp);
        connect();
        try {
            Statement st = conn.createStatement();
            char[] pwc = tfPassword.getPassword();
            String pw = "";
            for (char s : pwc) {
                pw += String.valueOf(s);
            }
            String cth = "insert into Pengantar values("
                    + "'" + tfUsername.getText() + "'"
                    + ", '" + tfNoPol.getText() + "'"
                    + ", '" + tfNoTelp.getText() + "'"
                    + ", HASHBYTES('SHA2_512', '" + pw + "')"
                    + ", '" + tfNamaDepan.getText() + "'"
                    + ", '" + tfNamaTengah.getText() + "'"
                    + ", '" + tfNamaAkhir.getText() + "'"
                    + ", '" + tfGaji.getText() + "'"
                    + ", '" + cbCabang.getSelectedItem() + "'"
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
            PengantarFrame konek = new PengantarFrame();
            konek.setVisible(true);
            konek.tampilkanData();
            this.dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(KasirFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTambahDataActionPerformed

    private void cbSeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSeeActionPerformed
        if (cbSee.isSelected()) {
            tfPassword.setEchoChar((char) 0);
        } else {
            tfPassword.setEchoChar('*');
        }
        cariKueri = "select * from Kasir where no_pegawai = '";
    }//GEN-LAST:event_cbSeeActionPerformed

    private void tblPengantarCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPengantarCariMouseClicked
        int baris = tblPengantarCari.rowAtPoint(evt.getPoint());
        String username = tblPengantarCari.getValueAt(baris, 0).toString();
        tfUsername.setText(username);
        primaryKeyNow = username;

        String noPol = tblPengantarCari.getValueAt(baris, 1).toString();
        tfNoPol.setText(noPol);

        String noTelp = tblPengantarCari.getValueAt(baris, 2).toString();
        tfNoTelp.setText(noTelp);

        String password = tblPengantarCari.getValueAt(baris, 3).toString();
        tfPassword.setText(password);

        String namaDepan = tblPengantarCari.getValueAt(baris, 4).toString();
        tfNamaDepan.setText(namaDepan);

        var obj = tblPengantarCari.getValueAt(baris, 5);
        if (obj != null) {
            String namaTengah = tblPengantarCari.getValueAt(baris, 4).toString();
            tfNamaTengah.setText(namaTengah);
        } else {
            String namaTengah = "";
            tfNamaTengah.setText(namaTengah);
        }

        String namaAkhir = tblPengantarCari.getValueAt(baris, 6).toString();
        tfNamaAkhir.setText(namaAkhir);

        String gaji = tblPengantarCari.getValueAt(baris, 7).toString();
        tfGaji.setText(gaji);

        String kota = tblPengantarCari.getValueAt(baris, 8).toString();
        cbCabang.setSelectedItem(kota);
    }//GEN-LAST:event_tblPengantarCariMouseClicked

    private void cbUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUsernameActionPerformed
        primaryKeyNow = tfCari.getText();
        cariKueri = "select * from Pengantar where username = '";
    }//GEN-LAST:event_cbUsernameActionPerformed

    private void cbNamaDepanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNamaDepanActionPerformed
        cariKueri = "select * from Pengantar where nama_depan = '";
    }//GEN-LAST:event_cbNamaDepanActionPerformed

    private void cbNoTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNoTelpActionPerformed
        cariKueri = "select * from Pengantar where no_telp = '";
    }//GEN-LAST:event_cbNoTelpActionPerformed

    private void cbNoPlatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNoPlatActionPerformed
        cariKueri = "select * from Pengantar where no_pol = '";
    }//GEN-LAST:event_cbNoPlatActionPerformed

    private void cbNamaCabangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNamaCabangActionPerformed
        cariKueri = "select * from Pengantar where nama_cabang = '";
    }//GEN-LAST:event_cbNamaCabangActionPerformed

    private void cbGajiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGajiActionPerformed
        cariKueri = "select * from Pengantar where gaji = '";
    }//GEN-LAST:event_cbGajiActionPerformed

    private void cbNamaBelakangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNamaBelakangActionPerformed
        cariKueri = "select * from Pengantar where nama_belakang = '";
    }//GEN-LAST:event_cbNamaBelakangActionPerformed

    private void tblPengantarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPengantarKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP) {
            try {
                int baris = tblPengantar.getSelectedRow();
                String username = tblPengantar.getValueAt(baris, 0).toString();
                tfUsername.setText(username);
                primaryKeyNow = username;

                String noPol = tblPengantar.getValueAt(baris, 1).toString();
                tfNoPol.setText(noPol);

                String noTelp = tblPengantar.getValueAt(baris, 2).toString();
                tfNoTelp.setText(noTelp);

                String password = tblPengantar.getValueAt(baris, 3).toString();
                tfPassword.setText(password);

                String namaDepan = tblPengantar.getValueAt(baris, 4).toString();
                tfNamaDepan.setText(namaDepan);

                var obj = tblPengantar.getValueAt(baris, 5);
                if (obj != null) {
                    String namaTengah = tblPengantar.getValueAt(baris, 4).toString();
                    tfNamaTengah.setText(namaTengah);
                } else {
                    String namaTengah = "";
                    tfNamaTengah.setText(namaTengah);
                }

                String namaAkhir = tblPengantar.getValueAt(baris, 6).toString();
                tfNamaAkhir.setText(namaAkhir);

                String gaji = tblPengantar.getValueAt(baris, 7).toString();
                tfGaji.setText(gaji);

                String kota = tblPengantar.getValueAt(baris, 8).toString();
                cbCabang.setSelectedItem(kota);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_tblPengantarKeyReleased

    private void tblPengantarCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPengantarCariKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP) {
            try {
                int baris = tblPengantarCari.getSelectedRow();
                String username = tblPengantarCari.getValueAt(baris, 0).toString();
                tfUsername.setText(username);
                primaryKeyNow = username;

                String noPol = tblPengantarCari.getValueAt(baris, 1).toString();
                tfNoPol.setText(noPol);

                String noTelp = tblPengantarCari.getValueAt(baris, 2).toString();
                tfNoTelp.setText(noTelp);

                String password = tblPengantarCari.getValueAt(baris, 3).toString();
                tfPassword.setText(password);

                String namaDepan = tblPengantarCari.getValueAt(baris, 4).toString();
                tfNamaDepan.setText(namaDepan);

                var obj = tblPengantarCari.getValueAt(baris, 5);
                if (obj != null) {
                    String namaTengah = tblPengantarCari.getValueAt(baris, 4).toString();
                    tfNamaTengah.setText(namaTengah);
                } else {
                    String namaTengah = "";
                    tfNamaTengah.setText(namaTengah);
                }

                String namaAkhir = tblPengantarCari.getValueAt(baris, 6).toString();
                tfNamaAkhir.setText(namaAkhir);

                String gaji = tblPengantarCari.getValueAt(baris, 7).toString();
                tfGaji.setText(gaji);

                String kota = tblPengantarCari.getValueAt(baris, 8).toString();
                cbCabang.setSelectedItem(kota);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_tblPengantarCariKeyReleased

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
                    PengantarFrame konek = new PengantarFrame();
                    konek.setVisible(true);
                    konek.tampilkanData();
                    konek.klik();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(PengantarFrame.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JComboBox<String> cbCabang;
    private javax.swing.JCheckBox cbGaji;
    private javax.swing.JCheckBox cbNamaBelakang;
    private javax.swing.JCheckBox cbNamaCabang;
    private javax.swing.JCheckBox cbNamaDepan;
    private javax.swing.JCheckBox cbNoPlat;
    private javax.swing.JCheckBox cbNoTelp;
    private javax.swing.JCheckBox cbSee;
    private javax.swing.JCheckBox cbUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblPengantar;
    private javax.swing.JTable tblPengantarCari;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfGaji;
    private javax.swing.JTextField tfNamaAkhir;
    private javax.swing.JTextField tfNamaDepan;
    private javax.swing.JTextField tfNamaTengah;
    private javax.swing.JTextField tfNoPol;
    private javax.swing.JTextField tfNoTelp;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
