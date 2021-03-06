/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plutonium;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import me.vighnesh.api.virustotal.VirusTotalAPI;
import me.vighnesh.api.virustotal.dao.FileScan;
import me.vighnesh.api.virustotal.dao.FileScanMetaData;
import me.vighnesh.api.virustotal.dao.FileScanReport;

/**
 *
 * @author Maneesha
 */
public class MainFrame extends javax.swing.JFrame {

    private VirusTotalAPI virusTotal = VirusTotalAPI.configure("22d6d1276f41a1ceacea3aec207ae5957d6e0f400d31a7fa64494eea09de05a0");
    private static Thread scanThread;

    private static final JFileChooser fc = new JFileChooser();
    private static final JFileChooser fc2 = new JFileChooser();

    private static String filepath = "";
    private static String filepath_vt = "";
    private static String malware = "";
    private static String scan_ID = "";
    private static Set<String> malwareHashes;

    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);

        //get Operating System
        OS_lbl.setText("OS name: " + System.getProperty("os.name") + " | version: " + System.getProperty("os.version") + " | architecture: " + System.getProperty("os.arch"));

        virusScanResults.setVisible(Boolean.FALSE);
        virus_total_scan_panel.setVisible(Boolean.FALSE);
        scan_pane.setVisible(false);
        report_pane.setVisible(false);
        delete_lbl.setVisible(false);
        delete_background.setVisible(false);
        delete_file.setVisible(false);
        scan_res_scroll_pane.setVisible(false);
        
        //select folders
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc2.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        malwareHashes = new HashSet<String>();

        try {

            File f = new File("VirusShare_00001.md5.txt");
            BufferedReader reader = new BufferedReader(new FileReader(f));
            //StringBuffer stringBuffer = new StringBuffer();

            String line;
            while ((line = reader.readLine()) != null) {
                //line = line.replace("\n", "").replace("\r", "");
                malwareHashes.add(line);
            }
            reader.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        minimize = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        title_name = new java.awt.Label();
        OS_lbl = new javax.swing.JLabel();
        title_logo = new javax.swing.JLabel();
        title_background = new javax.swing.JLabel();
        virus_total_panel = new javax.swing.JPanel();
        virus_total_logo = new javax.swing.JLabel();
        virus_total_title = new javax.swing.JLabel();
        virus_scan_panel = new javax.swing.JPanel();
        virusScan = new javax.swing.JLabel();
        virusScan_title = new javax.swing.JLabel();
        horizontal_lbl = new javax.swing.JLabel();
        angle45 = new javax.swing.JLabel();
        virus_total_scan_panel = new javax.swing.JPanel();
        subtitle_VT = new javax.swing.JLabel();
        vt_path = new javax.swing.JLabel();
        upload_file = new javax.swing.JLabel();
        upload_background = new javax.swing.JLabel();
        select_file_vt = new javax.swing.JLabel();
        select_file_background_vt = new javax.swing.JLabel();
        report_file = new javax.swing.JLabel();
        report_file_background = new javax.swing.JLabel();
        report_pane = new javax.swing.JScrollPane();
        report_table = new javax.swing.JTable();
        scan_pane = new javax.swing.JScrollPane();
        scan_table = new javax.swing.JTable();
        virusScanResults = new javax.swing.JPanel();
        subTitle1 = new javax.swing.JLabel();
        select_file = new javax.swing.JLabel();
        select_file_background = new javax.swing.JLabel();
        path = new javax.swing.JLabel();
        scan_file = new javax.swing.JLabel();
        scan_background = new javax.swing.JLabel();
        delete_lbl = new javax.swing.JLabel();
        delete_file = new javax.swing.JLabel();
        delete_background = new javax.swing.JLabel();
        scan_res_scroll_pane = new javax.swing.JScrollPane();
        scan_result_table = new javax.swing.JTable();
        home_panel = new javax.swing.JPanel();
        home_main_logo = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 475));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(800, 475));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/minimize32.png"))); // NOI18N
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        getContentPane().add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 30, 30));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/close32.png"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, 30));

        title_name.setBackground(new java.awt.Color(0, 0, 0));
        title_name.setFont(new java.awt.Font("Raleway SemiBold", 0, 36)); // NOI18N
        title_name.setForeground(new java.awt.Color(0, 255, 255));
        title_name.setText("Plutonium");
        getContentPane().add(title_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 180, 50));

        OS_lbl.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        OS_lbl.setForeground(new java.awt.Color(0, 204, 204));
        OS_lbl.setText("Operating System");
        getContentPane().add(OS_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 430, 30));

        title_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/main-logo32.png"))); // NOI18N
        getContentPane().add(title_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 50));

        title_background.setFont(new java.awt.Font("Raleway SemiBold", 0, 36)); // NOI18N
        title_background.setForeground(new java.awt.Color(0, 204, 204));
        title_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/title_background.png"))); // NOI18N
        getContentPane().add(title_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 70));

        virus_total_panel.setBackground(new java.awt.Color(0, 0, 0));
        virus_total_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                virus_total_panelMouseClicked(evt);
            }
        });
        virus_total_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        virus_total_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/virus-total48.png"))); // NOI18N
        virus_total_panel.add(virus_total_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 50));

        virus_total_title.setFont(new java.awt.Font("Raleway SemiBold", 0, 16)); // NOI18N
        virus_total_title.setForeground(new java.awt.Color(0, 255, 255));
        virus_total_title.setText("Virus Total");
        virus_total_panel.add(virus_total_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, -1));

        getContentPane().add(virus_total_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 100, 80));

        virus_scan_panel.setBackground(new java.awt.Color(0, 0, 0));
        virus_scan_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                virus_scan_panelMouseClicked(evt);
            }
        });
        virus_scan_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        virusScan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/scan32.png"))); // NOI18N
        virus_scan_panel.add(virusScan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 40));

        virusScan_title.setFont(new java.awt.Font("Raleway SemiBold", 0, 16)); // NOI18N
        virusScan_title.setForeground(new java.awt.Color(0, 255, 255));
        virusScan_title.setText("Virus Scan");
        virus_scan_panel.add(virusScan_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, -1));

        getContentPane().add(virus_scan_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 100, 80));

        horizontal_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/horizontal-pane.png"))); // NOI18N
        getContentPane().add(horizontal_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 150, 490));

        angle45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/angle45.png"))); // NOI18N
        getContentPane().add(angle45, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        virus_total_scan_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        subtitle_VT.setFont(new java.awt.Font("Raleway SemiBold", 0, 16)); // NOI18N
        subtitle_VT.setText("Select a File to Scan");
        virus_total_scan_panel.add(subtitle_VT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        vt_path.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        vt_path.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        vt_path.setEnabled(false);
        virus_total_scan_panel.add(vt_path, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 340, 30));

        upload_file.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        upload_file.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/upload32.png"))); // NOI18N
        upload_file.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        upload_file.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                upload_fileMouseClicked(evt);
            }
        });
        virus_total_scan_panel.add(upload_file, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 40, 30));

        upload_background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        upload_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/title_background.png"))); // NOI18N
        upload_background.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        virus_total_scan_panel.add(upload_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 55, 40, 40));

        select_file_vt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        select_file_vt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/open_folder32.png"))); // NOI18N
        select_file_vt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        select_file_vt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                select_file_vtMouseClicked(evt);
            }
        });
        virus_total_scan_panel.add(select_file_vt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 40, 30));

        select_file_background_vt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        select_file_background_vt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/title_background.png"))); // NOI18N
        select_file_background_vt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        virus_total_scan_panel.add(select_file_background_vt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 55, 40, 40));

        report_file.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        report_file.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/report32.png"))); // NOI18N
        report_file.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        report_file.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                report_fileMouseClicked(evt);
            }
        });
        virus_total_scan_panel.add(report_file, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 40, 30));

        report_file_background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        report_file_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/title_background.png"))); // NOI18N
        report_file_background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        virus_total_scan_panel.add(report_file_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 55, 40, 40));

        report_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Scanner", "Report"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        report_pane.setViewportView(report_table);

        virus_total_scan_panel.add(report_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 550, 250));

        scan_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "key", "value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scan_pane.setViewportView(scan_table);

        virus_total_scan_panel.add(scan_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 550, 170));

        getContentPane().add(virus_total_scan_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 660, 450));

        virusScanResults.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        subTitle1.setFont(new java.awt.Font("Raleway SemiBold", 0, 16)); // NOI18N
        subTitle1.setText("Select Folder To Scan");
        virusScanResults.add(subTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        select_file.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        select_file.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/open_folder32.png"))); // NOI18N
        select_file.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        select_file.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                select_fileMouseClicked(evt);
            }
        });
        virusScanResults.add(select_file, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 40, 30));

        select_file_background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        select_file_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/title_background.png"))); // NOI18N
        select_file_background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        virusScanResults.add(select_file_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 55, 40, 40));

        path.setFont(new java.awt.Font("Raleway SemiBold", 0, 13)); // NOI18N
        path.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        path.setEnabled(false);
        virusScanResults.add(path, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 340, 30));

        scan_file.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scan_file.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/scan32_2.png"))); // NOI18N
        scan_file.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scan_file.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scan_fileMouseClicked(evt);
            }
        });
        virusScanResults.add(scan_file, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 40, 30));

        scan_background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scan_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/title_background.png"))); // NOI18N
        scan_background.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        virusScanResults.add(scan_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 55, 40, 40));

        delete_lbl.setFont(new java.awt.Font("Raleway SemiBold", 0, 16)); // NOI18N
        delete_lbl.setText("Take Action on Infected Files");
        virusScanResults.add(delete_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 375, 240, -1));

        delete_file.setForeground(new java.awt.Color(0, 255, 255));
        delete_file.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete_file.setText("Delete");
        delete_file.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_fileMouseClicked(evt);
            }
        });
        virusScanResults.add(delete_file, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 80, 10));

        delete_background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/title_background.png"))); // NOI18N
        delete_background.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        virusScanResults.add(delete_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 375, 80, 20));

        scan_result_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "", "Malware files"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scan_res_scroll_pane.setViewportView(scan_result_table);

        virusScanResults.add(scan_res_scroll_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 620, 210));

        getContentPane().add(virusScanResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 670, 450));

        home_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_main_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plutonium/images/main-logo128.png"))); // NOI18N
        home_panel.add(home_main_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 140, 140));

        lbl1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl1.setText("This software uses a MD5 Hash Registry to detect malware. It will only tell you if the MD5 matches");
        lbl1.setToolTipText("");
        lbl1.setAlignmentY(0.0F);
        home_panel.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        lbl2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2.setText("a previously submitted file that was determined to be malware.");
        lbl2.setAlignmentY(0.0F);
        home_panel.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, -1, -1));

        getContentPane().add(home_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 660, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

    private void virus_scan_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_virus_scan_panelMouseClicked
        virusScanResults.setVisible(true);
        home_panel.setVisible(false);
        virus_total_scan_panel.setVisible(false);
    }//GEN-LAST:event_virus_scan_panelMouseClicked

    private void select_fileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_select_fileMouseClicked
        delete_lbl.setVisible(false);
        delete_background.setVisible(false);
        delete_file.setVisible(false);
        scan_res_scroll_pane.setVisible(false);
        int returnValue = fc.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            filepath = file.getAbsolutePath();
            System.out.println(filepath);
            path.setText(filepath);
        }
    }//GEN-LAST:event_select_fileMouseClicked

    private void scan_fileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scan_fileMouseClicked
        delete_lbl.setVisible(false);
        delete_background.setVisible(false);
        delete_file.setVisible(false);
        scan_res_scroll_pane.setVisible(false);
        malware = "";
        DefaultTableModel model = (DefaultTableModel) scan_result_table.getModel();
        model.setRowCount(0);
        scanThread = new Thread() {
            DefaultTableModel model = (DefaultTableModel) scan_result_table.getModel();
            private int count = 0;

            void RecursivePrint(File[] arr, int index, int level) {
                // terminate condition
                if (index == arr.length) {
                    return;
                }
                // tabs for internal levels
                for (int i = 0; i < level; i++) {
                    System.out.print("\t");
                }
                // for files
                if (arr[index].isFile()) {
                    System.out.println(arr[index].getName());
                    String path = arr[index].getAbsolutePath();
                    //lbl_path.setText(path);
                    String hash = MD5CheckSum.getMD5HashOfFile(path);
                    System.out.println(hash);
                    if (malwareHashes.contains(hash)) {
                        count++;
                        malware += path + "\n";
                        //System.out.println(hash);
                        model.addRow(new Object[]{count, false, path});
                    }
                } // for sub-directories
                else if (arr[index].isDirectory()) {
                    System.out.println("[" + arr[index].getName() + "]");
                    // recursion for sub-directories
                    RecursivePrint(arr[index].listFiles(), 0, level + 1);
                }
                // recursion for main directory
                RecursivePrint(arr, ++index, level);
            }

            public void run() {
                File maindir = new File(filepath);
                if (maindir.exists() && maindir.isDirectory()) {
                    // array for files and sub-directories 
                    // of directory pointed by maindir
                    File arr[] = maindir.listFiles();

                    System.out.println("**********************************************");
                    System.out.println("Files from main directory : " + maindir);
                    System.out.println("**********************************************");
                    // Calling recursive method
                    RecursivePrint(arr, 0, 0);
                }
                if (model.getRowCount() > 0) {
                    delete_lbl.setVisible(true);
                    delete_background.setVisible(true);
                    delete_file.setVisible(true);
                    scan_res_scroll_pane.setVisible(true);
                }
            }
        };
        scanThread.start();
    }//GEN-LAST:event_scan_fileMouseClicked

    private void virus_total_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_virus_total_panelMouseClicked
        virus_total_scan_panel.setVisible(true);
        virusScanResults.setVisible(false);
        home_panel.setVisible(false);
    }//GEN-LAST:event_virus_total_panelMouseClicked

    private void upload_fileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upload_fileMouseClicked
       new Thread(){
            public void run() {
                try {
                    scan_pane.setVisible(false);
                    report_pane.setVisible(false);
                    DefaultTableModel model = (DefaultTableModel)scan_table.getModel();
                    
                    File file = new File(filepath_vt);
                    FileScanMetaData scanFile = virusTotal.scanFile(file);
                    
                    System.out.println("---SCAN META DATA---");
   
                    System.out.println("MD5 : " + scanFile.getMD5());
                    model.addRow(new Object[]{"MD5", scanFile.getMD5()});
                    model.addRow(new Object[]{"SH-1", scanFile.getSHA1()});
                    model.addRow(new Object[]{"SHA-256", scanFile.getSHA256()});
                    model.addRow(new Object[]{"Permalink", scanFile.getPermalink()});
                    model.addRow(new Object[]{"Resource", scanFile.getResource()});
                    model.addRow(new Object[]{"Scan Id", scanFile.getScanId()});
                    model.addRow(new Object[]{"Response Code", scanFile.getResponseCode()});
                    model.addRow(new Object[]{"Verbose Message", scanFile.getVerboseMessage()});
                    
                    scan_ID = scanFile.getScanId();
                    
                    scan_pane.setVisible(true);
                    
                    //model.addRow(new Object[]{count, false, path});
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }.start();
    }//GEN-LAST:event_upload_fileMouseClicked

    private void select_file_vtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_select_file_vtMouseClicked
        int returnValue = fc2.showOpenDialog(this);
        
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fc2.getSelectedFile();
            filepath_vt = file.getAbsolutePath();
            System.out.println(filepath_vt);
            vt_path.setText(filepath_vt);
        }
    }//GEN-LAST:event_select_file_vtMouseClicked

    private void report_fileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_fileMouseClicked
        new Thread(){
            public void run(){
                scan_pane.setVisible(false);
                report_pane.setVisible(false);
                
                DefaultTableModel model = (DefaultTableModel)report_table.getModel();
                
                String fileId = "1947b44cc6f64e565d8a4215bc655315";//scan_ID;
                
                FileScanReport fileReport = virusTotal.getFileReport(fileId);
                Map scans = fileReport.getScans();
                int count = 0;
                scans.keySet().stream().forEach((scan) -> {
                    
                    FileScan report = (FileScan) scans.get(scan);
                    String str_report = "";
                    
                    if (report.isDetected()) {
                       str_report += report.getMalware();
                    } else {
                        str_report += "No Virus Detected";
                    }
                    model.addRow(new Object[]{scan, str_report});
                });

                report_pane.setVisible(true);

            }
        }.start();
    }//GEN-LAST:event_report_fileMouseClicked

    private void delete_fileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_fileMouseClicked
        DefaultTableModel model = (DefaultTableModel)scan_result_table.getModel();
        for (int row = 0; row < model.getRowCount(); row++) {
            if((boolean)model.getValueAt(row, 1) == true){
                System.out.println(model.getValueAt(row, 2));
                File f = new File((String)model.getValueAt(row, 2));
                f.delete();
                model.removeRow(row);
                for(int r = 0; r < model.getRowCount(); r++){
                    model.setValueAt(r+1, r, 0);
                }
            }  
        }
        
    }//GEN-LAST:event_delete_fileMouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel OS_lbl;
    private javax.swing.JLabel angle45;
    private javax.swing.JLabel delete_background;
    private javax.swing.JLabel delete_file;
    private javax.swing.JLabel delete_lbl;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel home_main_logo;
    private javax.swing.JPanel home_panel;
    private javax.swing.JLabel horizontal_lbl;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel minimize;
    private javax.swing.JLabel path;
    private javax.swing.JLabel report_file;
    private javax.swing.JLabel report_file_background;
    private javax.swing.JScrollPane report_pane;
    private javax.swing.JTable report_table;
    private javax.swing.JLabel scan_background;
    private javax.swing.JLabel scan_file;
    private javax.swing.JScrollPane scan_pane;
    private javax.swing.JScrollPane scan_res_scroll_pane;
    private javax.swing.JTable scan_result_table;
    private javax.swing.JTable scan_table;
    private javax.swing.JLabel select_file;
    private javax.swing.JLabel select_file_background;
    private javax.swing.JLabel select_file_background_vt;
    private javax.swing.JLabel select_file_vt;
    private javax.swing.JLabel subTitle1;
    private javax.swing.JLabel subtitle_VT;
    private javax.swing.JLabel title_background;
    private javax.swing.JLabel title_logo;
    private java.awt.Label title_name;
    private javax.swing.JLabel upload_background;
    private javax.swing.JLabel upload_file;
    private javax.swing.JLabel virusScan;
    private javax.swing.JPanel virusScanResults;
    private javax.swing.JLabel virusScan_title;
    private javax.swing.JPanel virus_scan_panel;
    private javax.swing.JLabel virus_total_logo;
    private javax.swing.JPanel virus_total_panel;
    private javax.swing.JPanel virus_total_scan_panel;
    private javax.swing.JLabel virus_total_title;
    private javax.swing.JLabel vt_path;
    // End of variables declaration//GEN-END:variables
}
