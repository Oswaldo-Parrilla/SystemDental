package ventanas;
//Librerias
import java.sql.*;
import clases.Conexion;
import java.awt.Color;
//Librerias para fondo de imagenes
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashSet;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * @author xSpectra
 */
public class InformacionUsuario extends javax.swing.JFrame {
    
    //Declarando variables globales
    String user = "", user_update = "";
    int ID; 

    //CONSTRUCTOR
    public InformacionUsuario() { //*************#68*******************
        initComponents();
        user = Login.user;//recuperar el nombre de usuario que se introducen en el login
        user_update = GestionarUsuarios.user_update;//mandamos a llamar a la variable user_update que se encuentra en la clase gestionarUsuarios que tiene como valor donde se le dio click al usuario y se la asignamos a la variable local de esta interfaz
        setSize(630,450);//Establecer las dimenciones de la interfaz usuario
        setResizable(false);//Evita que el usuario mueva las dimensiones de la interfaz
        setTitle("Informacion de Usuarios - Sesion de " + user);//El titulo en la parte superior de Jframe concatenado con el usuario que inicio sesion.
        setLocationRelativeTo(null);//Que se centre la ventana cuando se ejecute el programa
         //metodo para Matar procesos de segundo plano, cuando sea cerrada la interfaz, el seguira ejecutandose y evitara cerrar todo el programa
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//Metodo que evita que se ejecute en segundo plano aunque la interfaz haya sido cerrada el programa sigue corriendo.
        
        //Agregar imagen de fondo del Administrador y se crea un objeto de la clase ImageIcon
        ImageIcon wallpaper = new ImageIcon("src/images/fondoGris.jpg");//Aqui le ponemos la ruta de las imagenes (el packete)
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(), jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));//Esta linea nos permite que la imagen se adapte a las dimenciones del Label
        jLabel_Wallpaper.setIcon(icono);//Aqui ya le pasamos la imagen al Label (configurada con las anteriores lineas de codigo) respecto a sus dimenciones
        this.repaint();//Esta linea de codigo es para asegurar que la imagen se refleje en el Jlabel, asegurar que se este aplicando.
        
        jLabel_Titulo.setText("Informacion del usuario: " + user_update);
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from usuarios where username = '" + user_update + "' ");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) { //metodo para saber si se encontro una coincidencia en la DB
                ID = rs.getInt("id_usuario");
                txt_nombre.setText(rs.getString("nombre_usuario"));
                txt_mail.setText(rs.getString("email"));
                txt_telefono.setText(rs.getString("telefono"));
                txt_username.setText(rs.getString("username"));
                txt_RegistradoPor.setText(rs.getString("registrado_por"));
                cmb_niveles.setSelectedItem(rs.getString("tipo_nivel"));
                cmb_status.setSelectedItem(rs.getString("status"));
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al cargar usuario. " + e);
            JOptionPane.showMessageDialog(null, "!!Error al cargar!!, contacte al Administrador.");
        }
    }
    
    //Poner el metodo que cambia el icono de nuestra interfaz del lado superior izquierda y de la barra de tareas
    //Se salio del constructor y estas lineas son para cambiar el icono de la interfaz del login (icono superior derecha de la interfaz) incluso en la barra de tareas tambien cambia
    //Sobre-escribimos el metodo de Image
    @Override
    public Image getIconImage(){//este es el metodo que se sobre-escribira, y con el getIcon se obtendra la imagen que se desea.
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
        //Image es: La clase
        //retValue es: Un objeto de la clase Image,  ese metodo GUARDA (toda esa linea de codigo) la imagen en una variable "retValue"
        //Toolkit es: kit de herramientas
        //el metodo getDefaultToolkit es: Un metodo que obtiene el kit de herramientas (por default)
        //.getImage es: es un metodo que obtendra la imagen
        //ClassLoader es: Tiene el metodo para pedir el recurso al sistema, osea la imagen seleccionada al sistema (el login)
        //.getSystemResource es: un Metodo ************#68***************
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_Nombre1 = new javax.swing.JLabel();
        jLabel_Nombre2 = new javax.swing.JLabel();
        jLabel_Nombre3 = new javax.swing.JLabel();
        jLabel_Nombre4 = new javax.swing.JLabel();
        jLabel_Nombre5 = new javax.swing.JLabel();
        jLabel_Nombre6 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_mail = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_RegistradoPor = new javax.swing.JTextField();
        cmb_status = new javax.swing.JComboBox<>();
        cmb_niveles = new javax.swing.JComboBox<>();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_RestaurarPass = new javax.swing.JButton();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Informacion del Usuario");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel_Nombre1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre1.setText("email:");
        getContentPane().add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel_Nombre2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Telefono:");
        getContentPane().add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel_Nombre3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setText("Permisos de:");
        getContentPane().add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel_Nombre4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Username:");
        getContentPane().add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        jLabel_Nombre5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre5.setText("status:");
        getContentPane().add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        jLabel_Nombre6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel_Nombre6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre6.setText("Registrado por:");
        getContentPane().add(jLabel_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_mail.setBackground(new java.awt.Color(153, 153, 255));
        txt_mail.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_mail.setForeground(new java.awt.Color(255, 255, 255));
        txt_mail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        txt_telefono.setBackground(new java.awt.Color(153, 153, 255));
        txt_telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        txt_username.setBackground(new java.awt.Color(153, 153, 255));
        txt_username.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        txt_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_username.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 210, -1));

        txt_RegistradoPor.setBackground(new java.awt.Color(153, 153, 255));
        txt_RegistradoPor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_RegistradoPor.setForeground(new java.awt.Color(255, 255, 255));
        txt_RegistradoPor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_RegistradoPor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_RegistradoPor.setEnabled(false);
        getContentPane().add(txt_RegistradoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 210, -1));

        cmb_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(cmb_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        cmb_niveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Doctor" }));
        getContentPane().add(cmb_niveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jButton_Actualizar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setText("Actualizar Usuario");
        jButton_Actualizar.setBorder(null);
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 210, 35));

        jButton_RestaurarPass.setBackground(new java.awt.Color(153, 153, 255));
        jButton_RestaurarPass.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_RestaurarPass.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RestaurarPass.setText("Restaurar Password");
        jButton_RestaurarPass.setBorder(null);
        jButton_RestaurarPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RestaurarPassActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RestaurarPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 210, 35));

        jLabel_footer.setText("Creado por Oswaldo Parrilla");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, -1));

        jLabel_Wallpaper.setForeground(new java.awt.Color(204, 204, 255));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed
        //****#69**** Codigo que se ejcuatara al presionar el boton
        int permisos_cmb, status_cmb, validacion = 0;
        String nombre, mail, telefono, username, pass, permisos_string= "", status_string = "";
        
        mail = txt_mail.getText().trim();
        username = txt_username.getText().trim();
        nombre = txt_nombre.getText().trim();
        telefono = txt_telefono.getText().trim();
        permisos_cmb = cmb_niveles.getSelectedIndex() + 1;
        status_cmb = cmb_status.getSelectedIndex() + 1; 
        
        //Validacion de campos vacios
        if(mail.equals("")) {
            txt_mail.setBackground(Color.red);
            validacion ++; 
        }
        if(username.equals("")) {
            txt_username.setBackground(Color.red);
            validacion ++; 
        }  
        if(nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion ++; 
        }
        if(telefono.equals("")) {
            txt_telefono.setBackground(Color.red);
            validacion ++; 
        }
        
        //Esto ejecutara si el campo no esta vacio, que todos esten llenos, y guardara la actualizacion correctamente.
        if(validacion == 0) {
            if(permisos_cmb == 1) {
                permisos_string = "Administrador";
            } 
            else if(permisos_cmb == 2) {
                permisos_string = "Capturista";
            }
            else if(permisos_cmb == 3) {
                permisos_string = "Doctor";
            }
            
            if(status_cmb == 1){
                status_string = "Activo";
            }
            else if(status_cmb == 2) {
                permisos_string = "Inactivo";
            } //****#69****
            //****#70****
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(//Esta instruccion verifica que no existan nombres de usuario similares antes de introducirlos a la base de datos
                    "Select username from usuarios where username = '" + username + "' and not id_usuario = '" + ID +"' ");//En esta linea compara todos los registros de la base de datos excepto con el que estamos modificando
                ResultSet rs = pst.executeQuery();
                if(rs.next()){//Entonces si al darle click al boton se encuentre un username que no este disponible entonces...
                    txt_username.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Nombre de usuario '" + username + "' no disponible.");
                    cn.close();
                }else {//si si existe disponibilidad para el nombre de usuario que queremos utilizar
                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                    "update usuarios set nombre_usuario=?, email=?, telefono=?, username=?, tipo_nivel=?, status=? "
                            + "where id_usuario = '" +ID + "' ");
                    pst2.setString(1, nombre);
                    pst2.setString(2, mail);
                    pst2.setString(3, telefono);
                    pst2.setString(4, username);
                    pst2.setString(5, permisos_string);
                    pst2.setString(6, status_string);
                    
                    pst2.executeUpdate();
                    cn2.close();                
                    txt_username.setBackground(Color.green);
                    JOptionPane.showMessageDialog(null, "Modificacion existosa.");
                }
            }catch (SQLException e) {
                System.err.println("Error al actualizar." + e);
            }//****#70****
            
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
        }
    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void jButton_RestaurarPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RestaurarPassActionPerformed
        // CODIGO PARA DARLE EVENTO AL BOTON RESTAURAR PASSWORD
        RestaurarPassword restaurarPassword = new RestaurarPassword();
        restaurarPassword.setVisible(true);
    }//GEN-LAST:event_jButton_RestaurarPassActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_niveles;
    private javax.swing.JComboBox<String> cmb_status;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_RestaurarPass;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre1;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JLabel jLabel_Nombre6;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JTextField txt_RegistradoPor;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
