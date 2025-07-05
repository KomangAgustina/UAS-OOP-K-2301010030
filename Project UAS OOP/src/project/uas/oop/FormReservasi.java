package project.uas.oop;

//package project.uas.oop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static project.uas.oop.dbkoneksi.koneksi;
/**
 *
 * @author agustina trisnadewi
 */
public class FormReservasi extends javax.swing.JFrame {
    String ednama = "";
    DefaultTableModel TR = new DefaultTableModel();
    /**
     * Creates new form FormReservasi
     */
    public FormReservasi() throws SQLException {
        initComponents();
        TTR.setModel(TR);
        TR.addColumn("Nama");
        TR.addColumn("Tgl Check In");
        TR.addColumn("Tgl Check Out");
        TR.addColumn("Jumlah Orang");
        TR.addColumn("Tipe Villa");
              
        this.dtReservasiList();   
        fieldisEnabled(false);
   
        cmdTambah.setEnabled(true);
        cmdTutup.setEnabled(true);
        cmdUpdate.setEnabled(false);
        cmdHapus.setEnabled(false);
    }
    
    private void fieldisEnabled(boolean opsi){
        txtNama.setEditable(opsi);
        dateCheckin.setEnabled(opsi);
        dateCheckout.setEnabled(opsi);
        txtJumlahOrang.setEditable(opsi);
        cmbTipeVilla.setEnabled(opsi);
    }
    
    private void tombolisEnabled(boolean opsi){
        cmdTambah.setEnabled(opsi);
        cmdUpdate.setEnabled(opsi);
        cmdHapus.setEnabled(opsi);
        cmdTutup.setEnabled(opsi);
    }
    
    private void resetForm(){
        txtNama.setText("");
        dateCheckin.setDate(null);
        dateCheckout.setDate(null);
        txtJumlahOrang.setText("");
        cmbTipeVilla.setSelectedIndex(0);
        cmdHapus.setEnabled(true); 
    }
    
    /*CURD*/
    /*Menambahkan Data Baru*/
    private void storeData() throws SQLException{
        if (dateCheckin.getDate() == null || dateCheckout.getDate() == null) {
        JOptionPane.showMessageDialog(this, "Tanggal check-in dan check-out harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
        return;}
        
        String nama = txtNama.getText();
        String checkin = new SimpleDateFormat("yyyy-MM-dd").format(dateCheckin.getDate());
        String checkout = new SimpleDateFormat("yyyy-MM-dd").format(dateCheckout.getDate());
        String jumlahorang = txtJumlahOrang.getText();
        String tipevilla = cmbTipeVilla.getSelectedItem().toString();
  
        Connection cnn = koneksi();
        PreparedStatement PS = cnn.prepareStatement("INSERT INTO reservasi(nama, checkin, checkout, jumlahorang, tipevilla) VALUES (?, ?, ?, ?, ?)");
        PS.setString(1, nama);
        PS.setString(2, checkin);
        PS.setString(3, checkout);
        PS.setString(4, jumlahorang);
        PS.setString(5, tipevilla);
        PS.executeUpdate();
    }
    /*Mengubah data yang ada*/
    private void updateData() throws SQLException{
        String nama = txtNama.getText();
        String checkin = new SimpleDateFormat("yyyy-MM-dd").format(dateCheckin.getDate());
        String checkout = new SimpleDateFormat("yyyy-MM-dd").format(dateCheckout.getDate());        String jumlahorang = txtJumlahOrang.getText();
        String tipevilla = cmbTipeVilla.getSelectedItem().toString();
        
        Connection cnn = koneksi();
        PreparedStatement PS = cnn.prepareStatement("UPDATE reservasi SET nama=?, checkin=?, checkout=?, jumlahorang=?, tipevilla=? WHERE nama=?;");        
        PS.setString(1, nama);
        PS.setString(2, checkin);
        PS.setString(3, checkout);
        PS.setString(4, jumlahorang);
        PS.setString(5, tipevilla);
        PS.setString(6, this.ednama);
        PS.executeUpdate();
    }
    /*Hapus Data teman*/
    private void destroyData() throws SQLException{
        String nama = txtNama.getText();
        Connection cnn = koneksi();
        PreparedStatement PS = cnn.prepareStatement("DELETE FROM reservasi WHERE nama=?;");
        PS.setString(1, nama);
        PS.executeUpdate();
    }
      private void dtReservasiList() throws SQLException{
        Connection cnn = koneksi();
        
        PreparedStatement PS = cnn.prepareStatement("SELECT * FROM reservasi;");
        ResultSet RS = PS.executeQuery();
        
        TR.getDataVector().removeAllElements();
        TR.fireTableDataChanged();
        
        while( RS.next() ){
            Object[] dta = new Object[5];
                dta[0] = RS.getString("nama");
                dta[1] = RS.getString("checkin");
                dta[2] = RS.getString("checkout");
                dta[3] = RS.getString("jumlahorang");
                dta[4] = RS.getString("tipevilla");
            
            TR.addRow(dta);
        } 
    }
    /*CURD*/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmdTambah = new javax.swing.JButton();
        cmdUpdate = new javax.swing.JButton();
        cmdTutup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TTR = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtJumlahOrang = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmdHapus = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        dateCheckin = new com.toedter.calendar.JDateChooser();
        dateCheckout = new com.toedter.calendar.JDateChooser();
        cmbTipeVilla = new javax.swing.JComboBox<>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Jumlah Orang");

        jLabel5.setText("Tipe Villa");

        cmdTambah.setText("Tambah");
        cmdTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTambahActionPerformed(evt);
            }
        });

        cmdUpdate.setText("Update");
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });

        cmdTutup.setText("Tutup");
        cmdTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTutupActionPerformed(evt);
            }
        });

        TTR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama", "Tanggal Check In", "Tanggal Check Out", "Jumlah Orang", "Tipe Villa"
            }
        ));
        TTR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TTRMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TTR);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Tabel Reservasi");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Form Reservasi");

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        txtJumlahOrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahOrangActionPerformed(evt);
            }
        });

        jLabel1.setText("Nama");

        jLabel2.setText("Tanggal Check-In");

        cmdHapus.setText("Hapus");
        cmdHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHapusActionPerformed(evt);
            }
        });

        jLabel3.setText("Tanggal Check Out");

        cmbTipeVilla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Standard", "Deluxe", "Suite", "Premium" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtJumlahOrang)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cmdTambah)
                            .addGap(18, 18, 18)
                            .addComponent(cmdUpdate)
                            .addGap(18, 18, 18)
                            .addComponent(cmdHapus)
                            .addGap(18, 18, 18)
                            .addComponent(cmdTutup)))
                    .addComponent(txtNama)
                    .addComponent(dateCheckin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateCheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbTipeVilla, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(219, 219, 219))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtJumlahOrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTipeVilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdTambah)
                            .addComponent(cmdUpdate)
                            .addComponent(cmdTutup)
                            .addComponent(cmdHapus)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTambahActionPerformed
        if (cmdTambah.getText().equals("Tambah")) {
        // Mode Tambah: aktifkan form, ubah tombol menjadi Simpan
        tombolisEnabled(false);
        cmdTambah.setText("Simpan");
        cmdTutup.setText("Batal");
        resetForm();
        fieldisEnabled(true);
        cmdTambah.setEnabled(true);
        cmdTutup.setEnabled(true);
    } else {
        // Mode Simpan: simpan data baru
        try {
            storeData();
            dtReservasiList();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan.");
        } catch (SQLException ex) {
            Logger.getLogger(FormReservasi.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        // Kembali ke mode awal
        cmdTambah.setText("Tambah");
        cmdTutup.setText("Tutup");
        fieldisEnabled(false);
        resetForm();
        tombolisEnabled(true);
        cmdUpdate.setEnabled(false);
        cmdHapus.setEnabled(false);
    }
    }//GEN-LAST:event_cmdTambahActionPerformed

    private void cmdTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTutupActionPerformed
         if(cmdTutup.getText().equals("Tutup")){
            int jopsi = JOptionPane.showOptionDialog(this, 
                    "Yakin akan Menutup Aplikasi?", 
                    "Konfirmasi Tutup Aplikasi", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, null, null);
            if(jopsi == JOptionPane.YES_OPTION ){
                System.exit(0);
            }
        }else{
            resetForm();
            fieldisEnabled(false);
            cmdTambah.setText("Tambah");
            cmdTutup.setText("Tutup");
            cmdUpdate.setText("Ubah");
            cmdTambah.setEnabled(true);
            cmdUpdate.setEnabled(false);
        }
    }//GEN-LAST:event_cmdTutupActionPerformed
    
                 
  
    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void txtJumlahOrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahOrangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahOrangActionPerformed

    private void TTRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TTRMouseClicked
        int row = TTR.getSelectedRow();
    try {
        txtNama.setText(TTR.getValueAt(row, 0).toString());
        dateCheckin.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(TTR.getValueAt(row, 1).toString()));
        dateCheckout.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(TTR.getValueAt(row, 2).toString()));
        txtJumlahOrang.setText(TTR.getValueAt(row, 3).toString());
        cmbTipeVilla.setSelectedItem(TTR.getValueAt(row, 4).toString());

        cmdUpdate.setEnabled(true);
        cmdHapus.setEnabled(true);
        fieldisEnabled(true);

    } catch (ParseException e) {
        Logger.getLogger(FormReservasi.class.getName()).log(Level.SEVERE, null, e);
    }
    }//GEN-LAST:event_TTRMouseClicked

    private void cmdHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHapusActionPerformed
        int selectedRow = TTR.getSelectedRow(); // pastikan baris dipilih

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus dari tabel terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    } 
    String isNAMA = txtNama.getText();
        int jopsi = JOptionPane.showOptionDialog(this,
                "Yakin mau menghapus data "+isNAMA+"?", 
                "Konfirmasi Hapus Data", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, null, null);
        
         if (jopsi == JOptionPane.YES_OPTION) {
        try {
            destroyData();          // hapus dari database
            dtReservasiList();     // refresh tabel
            resetForm();           // kosongkan input
            fieldisEnabled(false); // nonaktifkan input kembali
            cmdUpdate.setEnabled(false);
            cmdHapus.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
        } catch (SQLException ex) {
            Logger.getLogger(FormReservasi.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data!", "Error", JOptionPane.ERROR_MESSAGE);
        }}
    }//GEN-LAST:event_cmdHapusActionPerformed
    
    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
    if(cmdUpdate.getText().equals("Ubah")){
    cmdUpdate.setText("Simpan");
    cmdTutup.setText("Batal");
    tombolisEnabled(false);
    cmdUpdate.setEnabled(true);
    cmdTutup.setEnabled(true);
    fieldisEnabled(true);
    this.ednama = txtNama.getText();
    } else {
    try {
        updateData();
        dtReservasiList();
        JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException ex) {
        Logger.getLogger(FormReservasi.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memperbarui data.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    cmdUpdate.setText("Ubah");
    cmdTutup.setText("Tutup");
    cmdTambah.setEnabled(true);
    cmdHapus.setEnabled(true);
}
  
    }//GEN-LAST:event_cmdUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(FormReservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormReservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormReservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormReservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormReservasi().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FormReservasi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TTR;
    private javax.swing.JComboBox<String> cmbTipeVilla;
    private javax.swing.JButton cmdHapus;
    private javax.swing.JButton cmdTambah;
    private javax.swing.JButton cmdTutup;
    private javax.swing.JButton cmdUpdate;
    private com.toedter.calendar.JDateChooser dateCheckin;
    private com.toedter.calendar.JDateChooser dateCheckout;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtJumlahOrang;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables

}
