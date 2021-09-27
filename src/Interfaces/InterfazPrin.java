/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Codigo.*;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Element;

/**
 *
 * @author Atxel Rico
 */
public class InterfazPrin extends javax.swing.JFrame {
    private DefaultTableModel m;
    private static JTextArea lines;
    /**
     * Creates new form InterfazPrin
     */
    public InterfazPrin() {
        initComponents();
        //Personalizacion de la tabla
        m=(DefaultTableModel) tblSimbolos.getModel();
        tblSimbolos.setModel(m);
        tblSimbolos.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        tblSimbolos.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        tblSimbolos.getTableHeader().setForeground(Color.white);
        //Contador de lineas
        lines = new JTextArea("1");
        lines.setBackground(new Color(0,153,204));
        lines.setForeground(Color.white);
        lines.setEditable(false);
        
        txtEntrada.getDocument().addDocumentListener(new DocumentListener() {
        public String getText() {
            int caretPosition = txtEntrada.getDocument().getLength();
            Element root = txtEntrada.getDocument().getDefaultRootElement();
            String text = "1" + System.getProperty("line.separator");
               for(int i = 2; i < root.getElementIndex(caretPosition) + 2; i++) {
                  text += i + System.getProperty("line.separator");
               }
            return text;
         }
         @Override
         public void changedUpdate(DocumentEvent de) {
            lines.setText(getText());
         }
         @Override
         public void insertUpdate(DocumentEvent de) {
            lines.setText(getText());
         }
         @Override
         public void removeUpdate(DocumentEvent de) {
            lines.setText(getText());
         }
      });
        jScrollPane1.getViewport().add(txtEntrada);
        jScrollPane1.setRowHeaderView(lines);

        
        txtEntrada.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                JTextArea editArea = (JTextArea)e.getSource();
                int linenum = 1;
                int columnnum = 1;

                try {
                    int caretpos = editArea.getCaretPosition();
                    linenum = editArea.getLineOfOffset(caretpos);
                    
                    columnnum = caretpos - editArea.getLineStartOffset(linenum);
                    linenum += 1; 
                }
                catch(Exception ex) { }

                // Once we know the position of the line and the column, pass it to a helper function for updating the status bar.
                updateStatus(linenum, columnnum);
            }
        });
        updateStatus(1,1);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextArea();
        btnAnaliza = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSimbolos = new javax.swing.JTable();
        status = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        txtEntrada.setColumns(20);
        txtEntrada.setRows(5);
        txtEntrada.setCaretColor(new java.awt.Color(0, 153, 255));
        jScrollPane1.setViewportView(txtEntrada);

        btnAnaliza.setBackground(new java.awt.Color(255, 255, 255));
        btnAnaliza.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnAnaliza.setForeground(new java.awt.Color(0, 153, 204));
        btnAnaliza.setText("Compilar");
        btnAnaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizaActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane2.setViewportView(txtResultado);

        jLabel1.setText("Errores");

        tblSimbolos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Componente", "Linea"
            }
        ));
        jScrollPane3.setViewportView(tblSimbolos);

        status.setEditable(false);
        status.setBackground(new java.awt.Color(0, 153, 204));
        status.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        status.setForeground(new java.awt.Color(255, 255, 255));

        jMenuBar1.setBackground(new java.awt.Color(0, 153, 204));

        jMenu1.setText("Archivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tablas de símbolos");

        jMenuItem1.setText("Tabla fija");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Tabla de identificadores");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ayuda");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(status, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAnaliza, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnaliza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void updateStatus(int linenumber, int columnnumber) {
        status.setText("Linea: " + linenumber + " Columna: " + columnnumber);
    }
    
    private void btnAnalizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizaActionPerformed
        
        txtResultado.setText("");
        m.setRowCount(0);
        //JFileChooser chooser = new JFileChooser();
        //chooser.showOpenDialog(null);
        
        //File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
        
        File archivo = new File("archivo.txt");
        PrintWriter escribir;
        try {
            escribir = new PrintWriter(archivo);
            escribir.print(txtEntrada.getText());
            escribir.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InterfazPrin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Reader lector = new BufferedReader(new FileReader("archivo.txt"));
            Lexer lexer = new Lexer(lector);
            while (true) {
                Tokens tokens = lexer.yylex();
                if (tokens == null) {
                    txtResultado.append("Fin del programa");
                    return;
                } 
                switch (tokens) {
                    case ERROR:
                        //resultado += "Simbolo no definido\n";
                        break;
                    default:
                        m.addRow(new Object[]{lexer.yytext(),tokens,lexer.yyline+1});
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InterfazPrin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InterfazPrin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String st = txtEntrada.getText();
        Sintax si = new Sintax();
        //si = new Sintax(new Codigo.LexerCup(new String));
        
    }//GEN-LAST:event_btnAnalizaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        TablaFija tb=new TablaFija();
        tb.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        TablaIdentificadores tab=new TablaIdentificadores();
        tab.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazPrin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPrin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPrin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPrin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazPrin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnaliza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField status;
    public static javax.swing.JTable tblSimbolos;
    public static javax.swing.JTextArea txtEntrada;
    public static javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}