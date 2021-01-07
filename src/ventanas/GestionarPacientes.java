
package ventanas;
//Librerias 
import java.sql.*;
import clases.Conexion;
//Librerias para ingresar imagenes en interfaces
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author xSpectra
 */
public class GestionarPacientes extends javax.swing.JFrame {

    //Declaracion de variables *****77****
    String user;
    public static int IDcliente_update = 0;//Variable que permite que enviemos datos entre interfaces
    DefaultTableModel model = new DefaultTableModel();//Es lo que nos permite generar el click en la tabla y establece algun tipo de comunicacion con los datos que se muestren dentro de la tabla
    //Constructor
    public GestionarPacientes() {
        initComponents();
        user = Login.user;
        //AGREGAR LOS METODOS QUE NOS REFUERZAN EL DISEñO
        setTitle("Capturista - Sesion de " + user);
        setSize(630, 330);
        setResizable(false);//no modifiquen la ventana
        setLocationRelativeTo(null);//se quede estatica la ventana de la interfaz 
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//metodo para Matar procesos de segundo plano, cuando sea cerrada la interfaz, el programa dejara de ejecutar en su totalidad
        //Agregar imagen de fondo del Administrador y se crea un objeto de la clase ImageIcon
        ImageIcon wallpaper = new ImageIcon("src/images/fondoGris.jpg");//Aqui le ponemos la ruta de las imagenes (el packete)
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_wallpaper.getWidth(), jLabel_wallpaper.getHeight(), Image.SCALE_DEFAULT));//Esta linea nos permite que la imagen se adapte a las dimenciones del Label
        jLabel_wallpaper.setIcon(icono);//Aqui ya le pasamos la imagen al Label (configurada con las anteriores lineas de codigo) respecto a sus dimenciones
        this.repaint();//Esta linea de codigo es para asegurar que la imagen se refleje en el Jlabel, asegurar que se este aplicando.
        
        //*****78******
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select id_paciente, nombre_paciente, mail_paciente, tel_paciente, dir_paciente, ultima_modificacion from pacientes");
            ResultSet rs = pst.executeQuery();
            //Trabajando con la tabla del diseño, el JTable_pacientes!!
            jTable_pacientes = new JTable(model);
            jScrollPane1.setViewportView(jTable_pacientes);//Aqui se ingresa la tabla pacientes dentro de el ScrollPane
            model.addColumn(" ");
            model.addColumn("Nombre");
            model.addColumn("M@ail");
            model.addColumn("Telefono");
            model.addColumn("Direccion");
            model.addColumn("Modificado por");
            
            while(rs.next()){
                Object [] fila = new Object[6];//Creando un array 
                //Llenando el array con la informacion de los pacientes
            }
        } catch(SQLException e) {
            System.out.println("Error en el llenado de la tabla.");
        }

    }
    //Poner el metodo que cambia el icono de nuestra interfaz del lado superior izquierda y de la barra de tareas
    //Se salio del constructor y estas lineas son para cambiar el icono de la interfaz del login (icono superior derecha de la interfaz) incluso en la barra de tareas tambien cambia
    //Sobre-escribimos el metodo de Image
    @Override
    public Image getIconImage() {//este es el metodo que se sobre-escribira, y con el getIcon se obtendra la imagen que se desea.
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }
    //Image es: La clase
    //retValue es: Un objeto de la clase Image,  ese metodo GUARDA (toda esa linea de codigo) la imagen en una variable "retValue"
    //Toolkit es: kit de herramientas
    //el metodo getDefaultToolkit es: Un metodo que obtiene el kit de herramientas (por default)
    //.getImage es: es un metodo que obtendra la imagen
    //ClassLoader es: Tiene el metodo para pedir el recurso al sistema, osea la imagen seleccionada al sistema (el login)
    //.getSystemResource es: un Metodo *****77****

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_pacientes = new javax.swing.JTable();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pacientes registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jTable_pacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(jTable_pacientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 180));

        jLabel_footer.setText("Creado por Oswaldo Parrilla ");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, -1));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GestionarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarPacientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_pacientes;
    // End of variables declaration//GEN-END:variables
}
