
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RAHUL
 */
public class Deletemovie extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame5
     */
    public Deletemovie() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(739, 522));
        setMinimumSize(new java.awt.Dimension(739, 522));
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(230, 270, 110, 33);

        jLabel1.setFont(new java.awt.Font("Bradley Hand ITC", 0, 36)); // NOI18N
        jLabel1.setText("Movie");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(350, 120, 108, 46);

        jTextField1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(360, 190, 191, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "cid", "no of ticket", "seat type", "movie name", "timing", "payment"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 330, 610, 120);

        jButton3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton3.setText("DISPLAY");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(370, 270, 116, 33);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setText("Enter Room No:-");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(200, 190, 150, 24);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 51));
        jLabel4.setText("Main menu");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(600, 270, 90, 24);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sunbird lilongwe review3.jpg"))); // NOI18N
        jLabel3.setText("next");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 730, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
       String rno=(jTextField1.getText());
        try{
            Class.forName("java.sql.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dhruv","root","bsms");
            Statement stmt= con.createStatement();
            String query= "select* from movie where room_no="+rno+";";
            ResultSet rs = stmt.executeQuery(query);
           
            while(rs.next()){
                String i,n,s,d,p,m;
                i= rs.getString("room_no");
                d= rs.getString("movie");
                n= rs.getString("noti");
                s= rs.getString("timing");
                p= rs.getString("cost");
                m= rs.getString("seat");
              
              model.addRow(new Object[]{i,n,m,d,s,p});
            }
            stmt.close();
            con.close();
            rs.close();
        }catch(Exception e){JOptionPane.showMessageDialog(null,e.getMessage());}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         int room_no=Integer.parseInt(jTextField1.getText());
        try{
            Class.forName("java.sql.Driver");
             try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dhruv","root","bsms")) {
                 Statement stmt= con.createStatement();
                 String query= "delete from movie where room_no="+room_no+";";
                 stmt.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"record deletd");
                 stmt.close();
             }
           
        }catch(Exception e){JOptionPane.showMessageDialog(null,e.getMessage());}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
         Task ca=new Task();
      ca.setVisible(true);
      dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(Deletemovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Deletemovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Deletemovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Deletemovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Deletemovie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
