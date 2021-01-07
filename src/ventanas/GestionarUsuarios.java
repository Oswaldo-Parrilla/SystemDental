/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

//INCLUYENDO LIBRERIAS 
import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xSpectra
 */
public class GestionarUsuarios extends javax.swing.JFrame {

    //DECLARANDO VARIABLES
    String user;
    public static String user_update = "";// esta variable permite mandar datos entre interfaces, y nos ayudara a saber cual es el usuario que se trata de consultar desde la interfaz de table que estamos diseñando
    DefaultTableModel model = new DefaultTableModel();//Este objeto nos va a permitir a todos los metodos necesarios(Del default) para modificar datos en su interior ya sea filas o columnas etc...

    //Constructor
    public GestionarUsuarios() {
        initComponents();
        user = Login.user;

        //AGREGAR LOS METODOS QUE NOS REFUERZAN EL DISEñO
        setTitle("Usuarios registrados - Sesion de " + user);
        setSize(630, 330);
        setResizable(false);//no modifiquen la ventana
        setLocationRelativeTo(null);//se quede estatica la ventana de la interfaz 
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//metodo para Matar procesos de segundo plano, cuando sea cerrada la interfaz, el programa dejara de ejecutar en su totalidad

        //Agregar imagen de fondo del Administrador y se crea un objeto de la clase ImageIcon
        ImageIcon wallpaper = new ImageIcon("src/images/fondoGris.jpg");//Aqui le ponemos la ruta de las imagenes (el packete)
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));//Esta linea nos permite que la imagen se adapte a las dimenciones del Label
        jLabel_Wallpaper.setIcon(icono);//Aqui ya le pasamos la imagen al Label (configurada con las anteriores lineas de codigo) respecto a sus dimenciones
        this.repaint();//Esta linea de codigo es para asegurar que la imagen se refleje en el Jlabel, asegurar que se este aplicando.

        //-64-  CONSULTAS A LA BASE DE DATOS Y LLENADO DE LA TABLA DE LA GESTION DE USUARIOS
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select id_usuario, nombre_usuario, username, tipo_nivel, status from usuarios");//Consulta en la DB 
            ResultSet rs = pst.executeQuery();

            jTable_usuarios = new JTable(model);//Meter los datos en la tabla (SE COLOCA UN JTABLE DENTRO DE UN JSCROLL CON EL FIN DE SI EXITEN MAS USUARIOS QUE SALGAN DE LA INTERFAZ, GENERE UN SCROLL PARA DESLIZAR)
            jScrollPane1.setViewportView(jTable_usuarios);

            model.addColumn(" ");//Asignar el nombre a cada columna
            model.addColumn("Nombre");
            model.addColumn("Username");
            model.addColumn("Permisos");
            model.addColumn("Status");

            //Crear una estructura repetitiva para empezar a llenar la tabla con los datos que vamos encontrando LAS FILAS
            while (rs.next()) {
                Object[] fila = new Object[5];//Declarar un vector de tipo objet con valor 5, porque son 5 columnas
                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);//Vaciando lo que vaya encontrando en la DB dependiendo en la posicion donde se encuentre "fila" y el i+1 es porque se empiece desde 1 y no 0 en los indices
                }
                model.addRow(fila);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar la tabla." + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar informacion, !Contacte al administrador!");
        }

        //-65- CREANDO UN EVENTO: obtener la informacion  que el usuario quiera requerir a la hora de solicitar el campo de la tabla que pertenece a gestionarUsuarios
        jTable_usuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_usuarios.rowAtPoint(e.getPoint());//Seleccionaremos primero la fila
                int colum_point = 2;//Luego seleccionaremos la columna

                //Creamos un if para que nuestro programa sepa que tiene que hacer para cuando se haya obtenido la fila y la columna
                if (fila_point > -1) {//partiendo desde 0 no puede haber filas menores a 0
                    user_update = (String) model.getValueAt(fila_point, colum_point);
                    InformacionUsuario informacion_usuario = new InformacionUsuario();
                    informacion_usuario.setVisible(true);//Aqui se abrira nuestra interfaz **InformacionUsuario**
                }

            }
        });

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
    //.getSystemResource es: un Metodo

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_usuarios = new javax.swing.JTable();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuarios registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jTable_usuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_usuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 180));

        jLabel_footer.setText("Creado por Oswaldo Parrilla ");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

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
            java.util.logging.Logger.getLogger(GestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_usuarios;
    // End of variables declaration//GEN-END:variables
}
