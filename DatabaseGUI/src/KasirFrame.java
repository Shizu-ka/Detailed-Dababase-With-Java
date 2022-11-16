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
public class KasirFrame extends javax.swing.JFrame {

    public KasirFrame() {
        initComponents();
    }

    private static Connection conn;
    private static String primaryKeyNow = "";

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
            KasirFrame.conn = DriverManager.getConnection(connectURL, sqlUser, sqlPassword);

        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Connect to database successful!!");
    }

    void tampilkanData() throws ClassNotFoundException, SQLException {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No Pegawai");
        model.addColumn("No Telp");
        model.addColumn("Password");
        model.addColumn("Nama Depan");
        model.addColumn("Nama Tengah");
        model.addColumn("Nama Akhir");
        model.addColumn("Tgl Lahir");
        model.addColumn("Username");
        model.addColumn("Gaji");
        model.addColumn("Nama Cabang");

        connect();
        int no = 1;
        Statement st = conn.createStatement();
        String cth = "select * from Kasir";
        String cth2 = "select nama_cabang from Cabang";
        ResultSet resultSet = st.executeQuery(cth);
        while (resultSet.next()) {
            model.addRow(new Object[]{resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getDate(7), resultSet.getString(8), resultSet.getInt(9),resultSet.getString(10)});
        }
        tblKasir.setModel(model);
        ResultSet resultSet2 = st.executeQuery(cth2);
        while (resultSet2.next()) {
            cbCabang.addItem(resultSet2.getString(1));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCabangFrameKembali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfNoPegawai = new javax.swing.JTextField();
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
        tfUsername = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfGaji = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKasir = new javax.swing.JTable();
        btnTambahData = new javax.swing.JButton();
        DateChooserTglLahir = new com.toedter.calendar.JDateChooser();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        tfPassword = new javax.swing.JPasswordField();
        cbSee = new javax.swing.JCheckBox();
        cbCabang = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cabang");

        btnCabangFrameKembali.setText("Kembali");
        btnCabangFrameKembali.setToolTipText("");
        btnCabangFrameKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCabangFrameKembaliActionPerformed(evt);
            }
        });

        jLabel1.setText("No Pegawai");

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

        jLabel8.setText("Username");

        tfUsername.setEditable(false);

        jLabel9.setText("Gaji");

        tfGaji.setEditable(false);

        jLabel10.setText("Cabang");

        tblKasir.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKasirMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKasir);

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

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel12.setText("Masukkan username yang ingin dicari");

        tfPassword.setEditable(false);

        cbSee.setText("See");
        cbSee.setBorder(null);
        cbSee.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/eye.png"))); // NOI18N
        cbSee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfNamaAkhir, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DateChooserTglLahir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                    .addComponent(tfGaji, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbCabang, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfUsername, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnCari)
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE))
                                    .addComponent(tfNoTelp)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(tfPassword)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbSee))
                                    .addComponent(tfNamaDepan)
                                    .addComponent(tfNamaTengah)
                                    .addComponent(tfNoPegawai))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(745, 745, 745)
                                .addComponent(btnCabangFrameKembali))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTambahData)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)
                        .addGap(296, 296, 296))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfNoPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSee))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfNamaDepan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfNamaTengah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfNamaAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(DateChooserTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tfGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbCabang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambahData)
                    .addComponent(btnSimpan)
                    .addComponent(btnReset)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus))
                .addGap(7, 7, 7)
                .addComponent(btnCabangFrameKembali)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCabangFrameKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCabangFrameKembaliActionPerformed
        MainFrame frame1 = new MainFrame();
        frame1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCabangFrameKembaliActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        String temp = tfNoPegawai.getText();
        if (temp.replaceAll("\\s", "").equals("")) {
            JOptionPane.showMessageDialog(new PembeliFrame(), "Error");
            btnReset.doClick();
        }
        else {
            connect();
            try {
                Statement st = conn.createStatement();
                String cth2 = "select * from Kasir where no_pegawai = '" + temp + "'";
                String cth = "delete from Kasir where "
                             + "no_pegawai = '" + temp +"'";
                ResultSet resultSet = st.executeQuery(cth2);
                //kalau username nya tidak exist
                if (!resultSet.isBeforeFirst()) {
                        JOptionPane.showMessageDialog(new PembeliFrame(), "Tidak Ada Hasil");
                    }
                else {
                    st.executeQuery(cth);
                    JOptionPane.showMessageDialog(new PembeliFrame(), "Data Berhasil Di Hapus");
                }
            } catch (SQLException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(new PembeliFrame(), "Data Berhasil Di Hapus");
            }
                try {
                    KasirFrame konek = new KasirFrame();
                    konek.setVisible(true);
                    konek.tampilkanData();
                    this.dispose();
                    tfNoPegawai.setText(temp);
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
        
        tfNoPegawai.setEditable(false);
        tfNoTelp.setEditable(true);
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
        String tempPrimaryKey = tfNoPegawai.getText();
        if (temp.replaceAll("\\s", "").equals("")) {
            JOptionPane.showMessageDialog(new KasirFrame(), "Error");
            btnReset.doClick();
        }
        else {
            connect();
            try {
                Statement st = conn.createStatement();
                char[] pwc = tfPassword.getPassword();
                String pw="";
                for(char s : pwc) {
                    pw += String.valueOf(s);
                }
                Date date = DateChooserTglLahir.getDate();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                String cth = "update Kasir set "
                               + "username='" + tfUsername.getText()+"'"
                               + ", no_telp='" + tfNoTelp.getText()+"'"
                               + ", password= HASHBYTES('SHA2_512', '"+ pw+"')"
                               + ", nama_depan='" + tfNamaDepan.getText()+"'"
                               + ", nama_tengah='" + tfNamaTengah.getText()+"'"
                               + ", nama_belakang='" + tfNamaAkhir.getText()+"'"
                               + ", tanggal_lahir='" + sqlDate+"'"
                               + ", nama_cabang='" + cbCabang.getSelectedItem() + "'"
                               + ", gaji=" + tfGaji.getText()
                               + " where no_pegawai='" + temp+"'";
                st.executeQuery(cth);
                                    JOptionPane.showMessageDialog(new KasirFrame(), "Data Berhasil Di Simpan");
            } catch (SQLException e) {
                System.out.println(e);
                                    JOptionPane.showMessageDialog(new KasirFrame(), "Data Berhasil Di Simpan");
            }
                try {
                    KasirFrame konek = new KasirFrame();
                    konek.setVisible(true);
                    konek.tampilkanData();
                    this.dispose();
                    if (!temp.equals(tempPrimaryKey)) {
                        konek.tfUsername.setText(tempPrimaryKey);
                        konek.tfUsername.setText(tempPrimaryKey);
                    }
                    else {
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
                    KasirFrame konek = new KasirFrame();
                    konek.setVisible(true);
                    konek.tampilkanData();
                    this.dispose();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(CabangFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblKasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKasirMouseClicked
        int baris = tblKasir.rowAtPoint(evt.getPoint());
        String username = tblKasir.getValueAt(baris, 0).toString();
        tfNoPegawai.setText(username);
        primaryKeyNow = username;

        String noTelp = tblKasir.getValueAt(baris, 1).toString();
        tfNoTelp.setText(noTelp);

        String password = tblKasir.getValueAt(baris, 2).toString();
        tfPassword.setText(password);

        String namaDepan = tblKasir.getValueAt(baris, 3).toString();
        tfNamaDepan.setText(namaDepan);

        var obj = tblKasir.getValueAt(baris, 4);
        if (obj != null) {
            String namaTengah = tblKasir.getValueAt(baris, 4).toString();
            tfNamaTengah.setText(namaTengah);
        } else {
            String namaTengah = "";
            tfNamaTengah.setText(namaTengah);
        }

        String namaAkhir = tblKasir.getValueAt(baris, 5).toString();
        tfNamaAkhir.setText(namaAkhir);

        String date = tblKasir.getValueAt(baris, 6).toString();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date2;
        try {
            date2 = formatter.parse(date);
            DateChooserTglLahir.setDate(date2);
        } catch (ParseException ex) {
            Logger.getLogger(KasirFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        String us = tblKasir.getValueAt(baris, 7).toString();
        tfUsername.setText(us);

        String gaji = tblKasir.getValueAt(baris, 8).toString();
        tfGaji.setText(gaji);

        String kota = tblKasir.getValueAt(baris, 9).toString();
        cbCabang.setSelectedItem(kota);
    }//GEN-LAST:event_tblKasirMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String temp = tfNoPegawai.getText();
        if (temp.replaceAll("\\s", "").equals("")) {
            JOptionPane.showMessageDialog(new KasirFrame(), "Input Kosong");
        } else {
            primaryKeyNow = tfNoPegawai.getText();
            connect();
            try {
                Statement st = conn.createStatement();
                String cth = "select * from Kasir where no_pegawai = '" + temp + "'";
                ResultSet resultSet = st.executeQuery(cth);
                if (!resultSet.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(new KasirFrame(), "Tidak Ada Hasil");
                    tfNoPegawai.setText(temp);
                } else {
                    while (resultSet.next()) {

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
                            Logger.getLogger(KasirFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        tfUsername.setText(resultSet.getString(8));
                        tfGaji.setText(resultSet.getString(9));
                        cbCabang.setSelectedItem(resultSet.getString(10));
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
        tfNoPegawai.setText(temp);
            connect();
            try {
                Statement st = conn.createStatement();
                char[] pwc = tfPassword.getPassword();
                String pw="";
                for(char s : pwc) {
                    pw += String.valueOf(s);
                }
                Date date = DateChooserTglLahir.getDate();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                String cth = "insert into Kasir values("
                               + "'" + tfNoTelp.getText()+"'"
                               + ", HASHBYTES('SHA2_512', '" + pw +"')"
                               + ", '" + tfNamaDepan.getText()+"'"
                               + ", '" + tfNamaTengah.getText()+"'"
                               + ", '" + tfNamaAkhir.getText()+"'"
                               + ", '" + sqlDate+"'"
                               + ", '" + tfUsername.getText()+"'"
                               + ", '" + tfGaji.getText()+"'"
                               + ", '" + cbCabang.getSelectedItem() +"'"
                               + ")";
                st.executeQuery(cth);
                JOptionPane.showMessageDialog(new KasirFrame(), "Data Berhasil Di Simpan");
            } catch (SQLException e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(new KasirFrame(), "Data Berhasil Di Simpan");
            }
                try {
                    KasirFrame konek = new KasirFrame();
                    konek.setVisible(true);
                    konek.tampilkanData();
                    this.dispose();
                    konek.tfUsername.setText(temp);
                    konek.tfUsername.setText(temp);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(KasirFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(KasirFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_btnTambahDataActionPerformed

    private void cbSeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSeeActionPerformed
        if(cbSee.isSelected()) tfPassword.setEchoChar((char)0);
        else tfPassword.setEchoChar('*');
    }//GEN-LAST:event_cbSeeActionPerformed

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
                    KasirFrame konek = new KasirFrame();
                    konek.setVisible(true);
                    konek.tampilkanData();
                } catch (ClassNotFoundException | SQLException ex) {
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
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahData;
    private javax.swing.JComboBox<String> cbCabang;
    private javax.swing.JCheckBox cbSee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKasir;
    private javax.swing.JTextField tfGaji;
    private javax.swing.JTextField tfNamaAkhir;
    private javax.swing.JTextField tfNamaDepan;
    private javax.swing.JTextField tfNamaTengah;
    private javax.swing.JTextField tfNoPegawai;
    private javax.swing.JTextField tfNoTelp;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}