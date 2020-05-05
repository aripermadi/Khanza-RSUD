package inventory;
import keuangan.Jurnal;
import keuangan.*;
import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import simrskhanza.DlgPenanggungJawab;

public class DlgPenggunaObat extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private Connection koneksi=koneksiDB.condb();
    private Jurnal jur=new Jurnal();
    private PreparedStatement psbarang,pspasien;
    private ResultSet rsbarang,rspasien; 
    private Dimension screen=Toolkit.getDefaultToolkit().getScreenSize(); 
    private DlgBarang barang=new DlgBarang(null,false);
    private DlgPenanggungJawab penjab=new DlgPenanggungJawab(null,false);
    private int i=0,a=0;
    private double jmlobat=0;

    /** Creates new form DlgProgramStudi
     * @param parent
     * @param modal */
    public DlgPenggunaObat(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        Object[] row={"Kode Barang","Nama Barang","Alamat","Dokter","Ruangan","Jml","Cara Bayar","Status","Asal Obat"};
        tabMode=new DefaultTableModel(null,row){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbDokter.setModel(tabMode);

        tbDokter.setPreferredScrollableViewportSize(new Dimension(800,800));
        tbDokter.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0;i < 8; i++) {
            TableColumn column = tbDokter.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(75);
            }else if(i==1){
                column.setPreferredWidth(550);
            }else if(i==2){
                column.setPreferredWidth(100);
            }else if(i==3){
                column.setPreferredWidth(80);
            }else if(i==4){
                column.setPreferredWidth(80);
            }else if(i==5){
                column.setPreferredWidth(80);
            }else if(i==6){
                column.setPreferredWidth(80);
            }else if(i==7){
                column.setPreferredWidth(80);
            
            }
        }
        tbDokter.setDefaultRenderer(Object.class, new WarnaTable());   
        
        kdbarang.setDocument(new batasInput((byte)15).getKata(kdbarang));
                
        barang.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {;}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if(barang.getTable().getSelectedRow()!= -1){                   
                    kdbarang.setText(barang.getTable().getValueAt(barang.getTable().getSelectedRow(),1).toString());
                    nmbarang.setText(barang.getTable().getValueAt(barang.getTable().getSelectedRow(),2).toString());
                    prosesCari();
                }     
                kdbarang.requestFocus();                
            }
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
        
        barang.getTable().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    barang.dispose();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        
        kdpenjab.setDocument(new batasInput((byte)8).getKata(kdpenjab));
                
        penjab.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if(penjab.getTable().getSelectedRow()!= -1){
                    kdpenjab.setText(penjab.getTable().getValueAt(penjab.getTable().getSelectedRow(),1).toString());
                    nmpenjab.setText(penjab.getTable().getValueAt(penjab.getTable().getSelectedRow(),2).toString());
                    prosesCari();
                }      
                kdpenjab.requestFocus();
            }
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {penjab.emptTeks();}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });   
        
        penjab.getTable().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    penjab.dispose();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        
     
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalFrame1 = new widget.InternalFrame();
        scrollPane1 = new widget.ScrollPane();
        tbDokter = new widget.Table();
        panelisi4 = new widget.panelisi();
        label11 = new widget.Label();
        Tgl1 = new widget.Tanggal();
        label18 = new widget.Label();
        Tgl2 = new widget.Tanggal();
        label17 = new widget.Label();
        kdbarang = new widget.TextBox();
        nmbarang = new widget.TextBox();
        btnBangsal = new widget.Button();
        BtnCari = new widget.Button();
        label19 = new widget.Label();
        kdpenjab = new widget.TextBox();
        nmpenjab = new widget.TextBox();
        BtnSeek2 = new widget.Button();
        BtnCari1 = new widget.Button();
        panelisi1 = new widget.panelisi();
        BtnAll = new widget.Button();
        BtnPrint = new widget.Button();
        label9 = new widget.Label();
        BtnKeluar = new widget.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Daftar Pengguna Obat/Alkes/BHP Resep ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(100, 80, 80))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        scrollPane1.setName("scrollPane1"); // NOI18N
        scrollPane1.setOpaque(true);

        tbDokter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbDokter.setToolTipText("");
        tbDokter.setName("tbDokter"); // NOI18N
        scrollPane1.setViewportView(tbDokter);

        internalFrame1.add(scrollPane1, java.awt.BorderLayout.CENTER);

        panelisi4.setName("panelisi4"); // NOI18N
        panelisi4.setPreferredSize(new java.awt.Dimension(100, 44));
        panelisi4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        label11.setText("Tgl.Beri Obat :");
        label11.setName("label11"); // NOI18N
        label11.setPreferredSize(new java.awt.Dimension(75, 23));
        panelisi4.add(label11);

        Tgl1.setEditable(false);
        Tgl1.setDisplayFormat("dd-MM-yyyy");
        Tgl1.setName("Tgl1"); // NOI18N
        Tgl1.setPreferredSize(new java.awt.Dimension(100, 23));
        Tgl1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Tgl1KeyPressed(evt);
            }
        });
        panelisi4.add(Tgl1);

        label18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label18.setText("s.d.");
        label18.setName("label18"); // NOI18N
        label18.setPreferredSize(new java.awt.Dimension(30, 23));
        panelisi4.add(label18);

        Tgl2.setEditable(false);
        Tgl2.setDisplayFormat("dd-MM-yyyy");
        Tgl2.setName("Tgl2"); // NOI18N
        Tgl2.setPreferredSize(new java.awt.Dimension(100, 23));
        Tgl2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Tgl2KeyPressed(evt);
            }
        });
        panelisi4.add(Tgl2);

        label17.setText("Obat/Alkes/BHP :");
        label17.setName("label17"); // NOI18N
        label17.setPreferredSize(new java.awt.Dimension(90, 23));
        panelisi4.add(label17);

        kdbarang.setName("kdbarang"); // NOI18N
        kdbarang.setPreferredSize(new java.awt.Dimension(70, 23));
        kdbarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdbarangKeyPressed(evt);
            }
        });
        panelisi4.add(kdbarang);

        nmbarang.setEditable(false);
        nmbarang.setName("nmbarang"); // NOI18N
        nmbarang.setPreferredSize(new java.awt.Dimension(203, 23));
        panelisi4.add(nmbarang);

        btnBangsal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnBangsal.setMnemonic('3');
        btnBangsal.setToolTipText("Alt+3");
        btnBangsal.setName("btnBangsal"); // NOI18N
        btnBangsal.setPreferredSize(new java.awt.Dimension(28, 23));
        btnBangsal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBangsalActionPerformed(evt);
            }
        });
        btnBangsal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBangsalKeyPressed(evt);
            }
        });
        panelisi4.add(btnBangsal);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('2');
        BtnCari.setToolTipText("Alt+2");
        BtnCari.setName("BtnCari"); // NOI18N
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelisi4.add(BtnCari);

        label19.setText("Cara Bayar :");
        label19.setName("label19"); // NOI18N
        label19.setPreferredSize(new java.awt.Dimension(75, 23));
        panelisi4.add(label19);

        kdpenjab.setName("kdpenjab"); // NOI18N
        kdpenjab.setPreferredSize(new java.awt.Dimension(70, 23));
        kdpenjab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdpenjabKeyPressed(evt);
            }
        });
        panelisi4.add(kdpenjab);

        nmpenjab.setEditable(false);
        nmpenjab.setName("nmpenjab"); // NOI18N
        nmpenjab.setPreferredSize(new java.awt.Dimension(199, 23));
        panelisi4.add(nmpenjab);

        BtnSeek2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnSeek2.setMnemonic('3');
        BtnSeek2.setToolTipText("Alt+3");
        BtnSeek2.setName("BtnSeek2"); // NOI18N
        BtnSeek2.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnSeek2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeek2ActionPerformed(evt);
            }
        });
        BtnSeek2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSeek2KeyPressed(evt);
            }
        });
        panelisi4.add(BtnSeek2);

        BtnCari1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari1.setMnemonic('2');
        BtnCari1.setToolTipText("Alt+2");
        BtnCari1.setName("BtnCari1"); // NOI18N
        BtnCari1.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCari1ActionPerformed(evt);
            }
        });
        BtnCari1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCari1KeyPressed(evt);
            }
        });
        panelisi4.add(BtnCari1);

        internalFrame1.add(panelisi4, java.awt.BorderLayout.PAGE_START);

        panelisi1.setName("panelisi1"); // NOI18N
        panelisi1.setPreferredSize(new java.awt.Dimension(100, 56));
        panelisi1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('M');
        BtnAll.setText("Semua");
        BtnAll.setToolTipText("Alt+M");
        BtnAll.setName("BtnAll"); // NOI18N
        BtnAll.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllActionPerformed(evt);
            }
        });
        BtnAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAllKeyPressed(evt);
            }
        });
        panelisi1.add(BtnAll);

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelisi1.add(BtnPrint);

        label9.setName("label9"); // NOI18N
        label9.setPreferredSize(new java.awt.Dimension(460, 30));
        panelisi1.add(label9);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelisi1.add(BtnKeluar);

        internalFrame1.add(panelisi1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*
private void KdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TKdKeyPressed
    Valid.pindah(evt,BtnCari,Nm);
}//GEN-LAST:event_TKdKeyPressed
*/

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            //TCari.requestFocus();
        }else if(tabMode.getRowCount()!=0){
            Sequel.AutoComitFalse();
            Sequel.queryu("truncate table temporary");
            int row=tabMode.getRowCount();
            for(int r=0;r<row;r++){  
                Sequel.menyimpan("temporary","'0','"+
                                tabMode.getValueAt(r,0).toString().replaceAll("'","`")+"','"+
                                tabMode.getValueAt(r,1).toString().replaceAll("'","`")+"','"+
                                tabMode.getValueAt(r,2).toString().replaceAll("'","`")+"','"+
                                tabMode.getValueAt(r,3).toString().replaceAll("'","`")+"','"+
                                tabMode.getValueAt(r,4).toString().replaceAll("'","`")+"','"+
                                tabMode.getValueAt(r,5).toString().replaceAll("'","`")+"','"+
                                
                                
                                tabMode.getValueAt(r,6).toString().replaceAll("'","`")+"','','','','','','','','','','','','','','','','','','','','','','','','','','','','','',''","Rekap Obat Perdokter Bangsal"); 
            }
            Sequel.AutoComitTrue();
            Map<String, Object> param = new HashMap<>();
                param.put("namars",akses.getnamars());
                param.put("alamatrs",akses.getalamatrs());
                param.put("kotars",akses.getkabupatenrs());
                param.put("propinsirs",akses.getpropinsirs());
                param.put("kontakrs",akses.getkontakrs());
                param.put("emailrs",akses.getemailrs());   
                param.put("logo",Sequel.cariGambar("select logo from setting")); 
            Valid.MyReportqry("rptPenggunaObat.jasper","report","[ Data Pengguna Obat Resep ]",
                "select no, temp1, temp2, temp3, temp4, temp5, temp6, temp7, temp8, temp9, temp10, temp11, temp12, temp13, temp14 from temporary order by no asc",param);
        }
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt,BtnAll,BtnKeluar);
        }
    }//GEN-LAST:event_BtnPrintKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnPrint,Tgl1);}
    }//GEN-LAST:event_BtnKeluarKeyPressed

    private void kdbarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdbarangKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            Sequel.cariIsi("select nm_poli from poliklinik where kd_poli=?", nmbarang,kdbarang.getText()); 
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            Sequel.cariIsi("select nm_poli from poliklinik where kd_poli=?", nmbarang,kdbarang.getText()); 
            Tgl2.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Sequel.cariIsi("select nm_poli from poliklinik where kd_poli=?", nmbarang,kdbarang.getText()); 
            BtnAll.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_UP){
            btnBangsalActionPerformed(null);
        }
    }//GEN-LAST:event_kdbarangKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        kdbarang.setText("");
        nmbarang.setText("");
        kdpenjab.setText("");
        nmpenjab.setText("");
        prosesCari();
    }//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnAllActionPerformed(null);
        }else{
            Valid.pindah(evt, kdbarang, BtnPrint);
        }
    }//GEN-LAST:event_BtnAllKeyPressed

private void btnBangsalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBangsalActionPerformed
        barang.isCek();
        barang.emptTeks();        
        barang.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        barang.setLocationRelativeTo(internalFrame1);
        barang.setAlwaysOnTop(false);
        barang.setVisible(true);
}//GEN-LAST:event_btnBangsalActionPerformed

private void btnBangsalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBangsalKeyPressed
   //Valid.pindah(evt,DTPCari2,TCari);
}//GEN-LAST:event_btnBangsalKeyPressed

private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        prosesCari();
}//GEN-LAST:event_BtnCariActionPerformed

private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }else{
            Valid.pindah(evt, kdbarang, BtnAll);
        }
}//GEN-LAST:event_BtnCariKeyPressed

    private void Tgl1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tgl1KeyPressed
        Valid.pindah(evt, BtnKeluar,Tgl2);
    }//GEN-LAST:event_Tgl1KeyPressed

    private void Tgl2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tgl2KeyPressed
        Valid.pindah(evt,Tgl1,kdbarang);
    }//GEN-LAST:event_Tgl2KeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        prosesCari();
    }//GEN-LAST:event_formWindowOpened

    private void kdpenjabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdpenjabKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            Sequel.cariIsi("select png_jawab from penjab where kd_pj=?", nmpenjab,kdpenjab.getText());
        }else if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Sequel.cariIsi("select png_jawab from penjab where kd_pj=?", nmpenjab,kdpenjab.getText());
            BtnAll.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            Sequel.cariIsi("select png_jawab from penjab where kd_pj=?", nmpenjab,kdpenjab.getText());
            Tgl2.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_UP){
            BtnSeek2ActionPerformed(null);
        }
    }//GEN-LAST:event_kdpenjabKeyPressed

    private void BtnSeek2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeek2ActionPerformed
        penjab.isCek();
        penjab.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        penjab.setLocationRelativeTo(internalFrame1);
        penjab.setAlwaysOnTop(false);
        penjab.setVisible(true);
    }//GEN-LAST:event_BtnSeek2ActionPerformed

    private void BtnSeek2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSeek2KeyPressed
        //Valid.pindah(evt,DTPCari2,TCari);
    }//GEN-LAST:event_BtnSeek2KeyPressed

    private void BtnCari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCari1ActionPerformed
        prosesCari();
    }//GEN-LAST:event_BtnCari1ActionPerformed

    private void BtnCari1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCari1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }else{
            Valid.pindah(evt, kdpenjab, BtnAll);
        }
    }//GEN-LAST:event_BtnCari1KeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgPenggunaObat dialog = new DlgPenggunaObat(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnAll;
    private widget.Button BtnCari;
    private widget.Button BtnCari1;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.Button BtnSeek2;
    private widget.Tanggal Tgl1;
    private widget.Tanggal Tgl2;
    private widget.Button btnBangsal;
    private widget.InternalFrame internalFrame1;
    private widget.TextBox kdbarang;
    private widget.TextBox kdpenjab;
    private widget.Label label11;
    private widget.Label label17;
    private widget.Label label18;
    private widget.Label label19;
    private widget.Label label9;
    private widget.TextBox nmbarang;
    private widget.TextBox nmpenjab;
    private widget.panelisi panelisi1;
    private widget.panelisi panelisi4;
    private widget.ScrollPane scrollPane1;
    private widget.Table tbDokter;
    // End of variables declaration//GEN-END:variables

    private void prosesCari() {            
        try{   
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); 
            Valid.tabelKosong(tabMode); 
            psbarang=koneksi.prepareStatement(
                "select kode_brng,nama_brng,kode_sat from databarang where "+
                "databarang.status='1' and kode_brng like ? order by nama_brng");
            try {
                psbarang.setString(1,"%"+kdbarang.getText().trim()+"%"); 
                rsbarang=psbarang.executeQuery();
                i=1;
                while(rsbarang.next()){
                    tabMode.addRow(new Object[]{rsbarang.getString("kode_brng"),rsbarang.getString("nama_brng"),"","","",rsbarang.getString("kode_sat"),""});
                    pspasien=koneksi.prepareStatement(
                        "select detail_pemberian_obat.tgl_perawatan,detail_pemberian_obat.jam,"+
                        "detail_pemberian_obat.no_rawat,reg_periksa.no_rkm_medis,pasien.nm_pasien,pasien.alamat, "
                        + "if(detail_pemberian_obat.status='Ralan',(select nm_dokter from dokter where dokter.kd_dokter=reg_periksa.kd_dokter),(select dokter.nm_dokter from dpjp_ranap inner join reg_periksa inner join dokter on dpjp_ranap.kd_dokter=reg_periksa.kd_dokter and reg_periksa.kd_dokter=dokter.kd_dokter where dpjp_ranap.no_rawat=detail_pemberian_obat.no_rawat limit 1 )) as dokter,"+
                        "if(detail_pemberian_obat.status='Ralan',(select nm_poli from poliklinik where poliklinik.kd_poli=reg_periksa.kd_poli),(select bangsal.nm_bangsal from kamar_inap inner join kamar inner join bangsal on kamar_inap.kd_kamar=kamar.kd_kamar and kamar.kd_bangsal=bangsal.kd_bangsal where kamar_inap.no_rawat=detail_pemberian_obat.no_rawat limit 1 )) as ruangan,detail_pemberian_obat.jml,penjab.png_jawab,detail_pemberian_obat.status,bangsal.nm_bangsal from detail_pemberian_obat inner join "+
                        "reg_periksa inner join pasien inner join databarang inner join penjab inner join dokter inner join bangsal "+
                        "on detail_pemberian_obat.no_rawat=reg_periksa.no_rawat "+
                        "and reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                        "and reg_periksa.kd_pj=penjab.kd_pj "+
                                "and reg_periksa.kd_dokter=dokter.kd_dokter "+
                                "and detail_pemberian_obat.kd_bangsal=bangsal.kd_bangsal "+
                        "and detail_pemberian_obat.kode_brng=databarang.kode_brng "+
                        "where detail_pemberian_obat.tgl_perawatan between ? and ? and "+
                        "detail_pemberian_obat.kode_brng=? and reg_periksa.kd_pj like ? order by detail_pemberian_obat.tgl_perawatan,detail_pemberian_obat.jam");
                    try {
                        pspasien.setString(1,Valid.SetTgl(Tgl1.getSelectedItem()+""));
                        pspasien.setString(2,Valid.SetTgl(Tgl2.getSelectedItem()+""));
                        pspasien.setString(3,rsbarang.getString("kode_brng"));
                        pspasien.setString(4,"%"+kdpenjab.getText().trim()+"%");
                        rspasien=pspasien.executeQuery();
                        i=1;
                        jmlobat=0;
                        while(rspasien.next()){
                            tabMode.addRow(new Object[]{
                                "",i+". "+rspasien.getString("tgl_perawatan")+" "+rspasien.getString("jam")+"  "+
                                rspasien.getString("no_rawat")+"  "+rspasien.getString("no_rkm_medis")+"  "+rspasien.getString("nm_pasien"),rspasien.getString("alamat"),rspasien.getString("dokter"),rspasien.getString("ruangan"),
                                rspasien.getDouble("jml"),rspasien.getString("png_jawab"),rspasien.getString("status"),rspasien.getString("nm_bangsal")
                            });
                            jmlobat=jmlobat+rspasien.getDouble("jml");
                            i++;
                        }
                        if(jmlobat>0){
                            tabMode.addRow(new Object[]{
                                "","Jumlah Obat : "," ","","",jmlobat,""});
                        }
                    } catch (Exception e) {
                        System.out.println("Notif 2 : "+e);
                    } finally{
                        if(rspasien!=null){
                            rspasien.close();
                        }
                        if(pspasien!=null){
                            pspasien.close();
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rsbarang!=null){
                    rsbarang.close();
                }
                if(psbarang!=null){
                    psbarang.close();
                }
            }                
            this.setCursor(Cursor.getDefaultCursor());             
        }catch(Exception e){
            System.out.println("Catatan  "+e);
        }
        
    }
    
    
    public void isCek(){
        //BtnPrint.setEnabled(akses.getobat_per_kamar());
    }
    
}
