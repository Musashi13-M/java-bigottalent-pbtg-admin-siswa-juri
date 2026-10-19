package form;

import Koneksi.koneksi;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormJuri extends javax.swing.JFrame {
    DefaultTableModel model;
    int idLoginJuri;
    
public FormJuri(int idUser) {
    initComponents();
    setLocationRelativeTo(null);
    this.idLoginJuri = idUser;
    loadDataPeserta();
    }

public void loadDataPeserta() {
        model = new DefaultTableModel();
        model.addColumn("ID Daftar");
        model.addColumn("Nama Siswa");
        model.addColumn("Mata Lomba");
        model.addColumn("Status Pendaftaran");
        tblPeserta2.setModel(model);
        
try {
            Connection c = koneksi.configDB();
            Statement s = c.createStatement();
            // Menampilkan data peserta yang mendaftar
            String sql = "SELECT pendaftaran.id, users.username, lomba.nama_lomba, pendaftaran.status " +
                         "FROM pendaftaran " +
                         "JOIN users ON pendaftaran.user_id = users.id " +
                         "JOIN lomba ON pendaftaran.lomba_id = lomba.id";
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {
                model.addRow(new Object[]{
                    r.getString("id"),
                    r.getString("username"),
                    r.getString("nama_lomba"),
                    r.getString("status")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data peserta: " + e.getMessage());
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeserta2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtNilai = new javax.swing.JTextField();
        cmbStatusPeserta = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCatatan = new javax.swing.JTextArea();
        btnSimpanPenilaian = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PANEL JURI - BIGotTalent");

        tblPeserta2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPeserta2);

        jLabel2.setText("Nilai");

        txtNilai.setText("jTextField1");

        cmbStatusPeserta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lolos", "Tidak Lolos" }));

        txtCatatan.setColumns(20);
        txtCatatan.setRows(5);
        jScrollPane3.setViewportView(txtCatatan);

        btnSimpanPenilaian.setText("Simpan Penilaian");
        btnSimpanPenilaian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanPenilaianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbStatusPeserta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(12, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btnSimpanPenilaian)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cmbStatusPeserta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnSimpanPenilaian)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanPenilaianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanPenilaianActionPerformed
        int baris = tblPeserta2.getSelectedRow();
        if (baris == -1) {
            JOptionPane.showMessageDialog(this, "Pilih peserta di tabel terlebih dahulu!");
            return;
        }

        String idPendaftaran = model.getValueAt(baris, 0).toString();
        String nilai = txtNilai.getText();
        String statusSeleksi = cmbStatusPeserta.getSelectedItem().toString();
        String catatan = txtCatatan.getText();

        if (nilai.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nilai tidak boleh kosong!");
            return;
        }

        try {
            Connection c = koneksi.configDB();
            
            // 1. Simpan ke tabel penilaian
            String sqlPenilaian = "INSERT INTO penilaian (pendaftaran_id, juri_id, nilai, status_seleksi, catatan) VALUES ('" 
                    + idPendaftaran + "', '" + idLoginJuri + "', '" + nilai + "', '" + statusSeleksi + "', '" + catatan + "')";
            Statement s = c.createStatement();
            s.executeUpdate(sqlPenilaian);

            // 2. Otomatis update status di tabel pendaftaran agar siswa bisa lihat hasilnya
            String statusBaru = "Seleksi Juri: " + statusSeleksi;
            String sqlUpdate = "UPDATE pendaftaran SET status = '" + statusBaru + "' WHERE id = '" + idPendaftaran + "'";
            s.executeUpdate(sqlUpdate);

            JOptionPane.showMessageDialog(this, "Penilaian berhasil disimpan!");
            
            // Bersihkan form input
            txtNilai.setText("");
            txtCatatan.setText("");
            loadDataPeserta();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan penilaian: " + e.getMessage());
        }
    
    }//GEN-LAST:event_btnSimpanPenilaianActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimpanPenilaian;
    private javax.swing.JComboBox<String> cmbStatusPeserta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblPeserta2;
    private javax.swing.JTextArea txtCatatan;
    private javax.swing.JTextField txtNilai;
    // End of variables declaration//GEN-END:variables
}