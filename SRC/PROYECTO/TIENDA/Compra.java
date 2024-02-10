
//Importa las clases y librerias necesarias
package proyecto.tienda;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Almacenamiento.Cliente;
import Almacenamiento.Articulo;
import Almacenamiento.Compras;
import static Almacenamiento.Contenedor_clientes.*;
import static Almacenamiento.Contenedor_articulos.*;
import static Almacenamiento.Contenedor_compras.*;



public class Compra extends javax.swing.JFrame {
    //Atributos
    private DefaultTableModel modCom; //Modelo de la tabla de compras llamada modCom
    int Contador = 0; //Contador tabla compras
    public static int cont=1; //Contador de factura
    public static int Encontrado; //Referencia de posicion cliente
    public static int EncontradoArt; //Referencia de posicion Articulo
    public static int comArt=0; //Contador de articulos no encontrados
    
    public Compra() {
        //Inicializa componentes
        initComponents();
        //Metodo
        CargarInicio();
    }
    //Metodo que busca el cliente por codigo
    public Cliente Buscar()
        {
        Cliente C = null; //Referencia de cliente sin valor
        long cod = Long.parseLong(JOptionPane.showInputDialog("Codigo del Cliente")); //Cuadro de dialogo que captura el codigo del cliente
  
            for (int i = 0; i<cc.size(); i++) //Recorre el contenedor de clientes
                {
                C = (Cliente)cc.get(i);//Localiza y llama datos de cliente con referencia C
                if(cod == C.getCodigo() ) //Si encuentra el codigo recibido en la lista entonces...
                    {
                    outCod.setText(String.valueOf(cod)); //Asigna y muestra en pantalla
                    txtNombre.setText(C.getNombre());
                    txtDireccion.setText(C.getDireccion());
                    outTel.setText(C.getTelefono());
                    Encontrado = i; //Asigna la posicion
                    outCod.setEnabled(true); //Habilita botones y espacios de texto
                    txtNombre.setEnabled(true);
                    txtDireccion.setEnabled(true);
                    outTel.setEnabled(true);
                    btnLimpiar.setEnabled(true);
                    btnRegistrar.setEnabled(true);
                    btnListarClientes.setEnabled(true);
                    btnNuevo.setEnabled(true);
                    btnEliminar.setEnabled(true);
                    btnBuscar.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Busqueda Finalizada"); //Cuadro de texto con mensaje
                    break; //Termina el metodo
                    }
                else
                    {
                    C = null; //Deja sin valor a C
                    }
                }
            return C;    //Retorna C
    }
    //Metodo que busca el articulo por codigo
    public Articulo BuscarArt()
        {
        Articulo A = null;  //Referencia de articulo sin valor
        long codArt = Long.parseLong(JOptionPane.showInputDialog("Codigo del articulo")); //Cuadro de dialogo que captura el codigo del cliente
        {
            for (int i = 0; i<ca.size(); i++) //Recorre el contenedor de articulos
                {
                A = (Articulo)ca.get(i); //Localiza y llama datos de articulo con referencia A
                if(codArt == A.getCodigoArt() ) //Si encuentra el codigo recibido en la lista entonces...
                    {
                    txtcodArt.setText(String.valueOf(codArt));
                    txtNombArt.setText(A.getNombre());
                    txtDescripArt.setText(A.getDescrip());
                    txtStock.setText(A.getStock());
                    txtPrecio.setText(A.getPrecio());
                    EncontradoArt= i; //Asigna la posicion
                    txtcodArt.setEnabled(true);
                    txtNombArt.setEnabled(true);
                    txtDescripArt.setEnabled(true);
                    txtStock.setEnabled(true);
                    txtPrecio.setEnabled(true);
                    btnBuscarArt.setEnabled(true);
                    btnNuevoArt.setEnabled(true);
                    btnRegistrarArt.setEnabled(true);
                    btnListarArt.setEnabled(true);
                    btnEliminarArt.setEnabled(true);
                    btnAgregarCarrito.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Busqueda Finalizada");
                    break;
                    }
                else
                    {
                    A = null; //Deja sin valor a A
                    }
                }
            return A; //Retorna A
        }      
    }
    //Comprueba si el codigo del cliente ya existe
    public Cliente verificar(){
    Cliente C = null;//Referencia clase cliente con valor nulo
        long cod = Long.parseLong(outCod.getText().trim());//asigna un auxiliar
        
            for (int i = 0; i<cc.size(); i++)
            {
                C = (Cliente)cc.get(i);//Localiza y llama datos de cliente con referencia C en posicion i
                if(cod == C.getCodigo()){// compara si el codigo ingresado existe en la lista
                    
                    btnRegistrar.setEnabled(false);// si no existe, no puede registrar
                }else{
                    C = null;//Da valor nulo a C
                }
                
            }
        return C;//Retorna
    }
    //Verifica si el codigo del articulo ya existe el la lsita de articulos
    public Articulo verificarArt(){
    Articulo A = null;//referencia la calse articulo con valor nulo 
        long codArt = Long.parseLong(txtcodArt.getText().trim());//captura el codigo ingrasado con un auxiliar
        {
            for (int i = 0; i<ca.size(); i++)//recorre el contenedor de articulos
            {
                A = (Articulo)ca.get(i); //Localiza y llama datos de articulo con referencia A en posicion i
                if(codArt == A.getCodigoArt()){ // compara si el codigo ingresado existe en la lista
                    btnRegistrarArt.setEnabled(false);// si no existe, no puede registrar
                }else{
                    A = null;//asiga a A valor nulo
                }
                
            }
        return A;//retorna A
        }
    }
    //Desactiva botones y cuadros de texto
    void Guardado()
        {      
        outCod.setEnabled(false);
        txtNombre.setEnabled(false);
        txtDireccion.setEnabled(false);
        outTel.setEnabled(false);  
        btnBuscar.setEnabled(true);
        btnNuevo.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnRegistrar.setEnabled(false);
        btnListarClientes.setEnabled(true);
       
        }
        //Desactiva botones y cuadros de texto
    void GuardarArt()
    {   
        btnEliminarArt.setEnabled(false);
        btnAgregarCarrito.setEnabled(true);
        btnFacturar.setEnabled(true);
        btnLimpCom.setEnabled(true);
        txtcodArt.setEnabled(false);
        txtNombArt.setEnabled(false);
        txtDescripArt.setEnabled(false);
        txtStock.setEnabled(false);
        txtPrecio.setEnabled(false);
        btnBuscarArt.setEnabled(true);
        btnNuevoArt.setEnabled(true);
        btnRegistrarArt.setEnabled(false);
        btnListarArt.setEnabled(true);
    }
    //Asigna espacios en blano para los cuadros de texto de Articulo
    void limpiarArt()
    {
        txtcodArt.setText("");
        txtNombArt.setText("");
        txtDescripArt.setText("");
        txtStock.setText("");
        txtPrecio.setText("");
    }
       //Asigna espacios en blano para los cuadros de texto de Cliente
    void limpiar()
        {
        outCod.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        outTel.setText("");
        }
    //carga valores iniciales en botones y cuadros de texto para el programa
     void CargarInicio()
        {
        if(cc.isEmpty() && ca.isEmpty())//Si los contenedores de articulo y clientes estan vacios...
            {
            outCod.setEnabled(false);
            txtNombre.setEnabled(false);
            txtDireccion.setEnabled(false);
            outTel.setEnabled(false);
            btnBuscar.setEnabled(false);
            btnRegistrar.setEnabled(false);
            btnNuevo.setEnabled(true);//Solo activa nuevo
            btnListarClientes.setEnabled(false);
            btnLimpiar.setEnabled(false);
            btnEliminar.setEnabled(false);
            txtNombArt.setEnabled(false);
            txtDescripArt.setEnabled(false);
            txtStock.setEnabled(false);
            txtPrecio.setEnabled(false);
            btnBuscarArt.setEnabled(false);
            btnNuevoArt.setEnabled(true);
            btnRegistrarArt.setEnabled(false);
            btnListarArt.setEnabled(false);
            btnEliminarArt.setEnabled(false);
            btnLimpiarArt.setEnabled(false);
            txtcodArt.setEnabled(false);
            btnAgregarCarrito.setEnabled(false);
            btnFacturar.setEnabled(false);
            btnLimpCom.setEnabled(false);
            }
        else if (!cc.isEmpty() && !ca.isEmpty())//Si los contenedores de articulo y clientes NO estan vacios...
            {
            //activa todos los botones y cuadros de texto
            txtcodArt.setEnabled(true);
            btnLimpiarArt.setEnabled(true);
            btnEliminarArt.setEnabled(true);
            txtNombArt.setEnabled(true);
            txtDescripArt.setEnabled(true);
            txtStock.setEnabled(true);
            txtPrecio.setEnabled(true);
            btnBuscarArt.setEnabled(true);
            btnNuevoArt.setEnabled(true);
            btnRegistrarArt.setEnabled(true);
            btnListarArt.setEnabled(true);
            outCod.setEnabled(true);
            btnNuevo.setEnabled(true);
            btnBuscar.setEnabled(true);
            btnRegistrar.setEnabled(true);
            btnListarClientes.setEnabled(true);
            btnLimpiar.setEnabled(true);
            btnAgregarCarrito.setEnabled(true);
            btnFacturar.setEnabled(true);
            btnLimpCom.setEnabled(true);
            }
        
        }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        outCod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        outTel = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnAgregarCarrito = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnListarClientes = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbArticulos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtcodArt = new javax.swing.JTextField();
        txtNombArt = new javax.swing.JTextField();
        txtDescripArt = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnLimpiarArt = new javax.swing.JButton();
        btnRegistrarArt = new javax.swing.JButton();
        btnListarArt = new javax.swing.JButton();
        btnEliminarArt = new javax.swing.JButton();
        btnNuevoArt = new javax.swing.JButton();
        btnBuscarArt = new javax.swing.JButton();
        btnFacturar = new javax.swing.JButton();
        btnLimpCom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setBackground(new java.awt.Color(255, 204, 204));
        jLabel1.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("TIENDA DE ABARROTES LOS ANDES");

        jLabel2.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Nombre:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 102, 51));
        jLabel3.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Codigo:");

        outCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outCodActionPerformed(evt);
            }
        });
        outCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                outCodKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("Direccion:");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("Telefono:");

        outTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outTelActionPerformed(evt);
            }
        });
        outTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                outTelKeyTyped(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnAgregarCarrito.setText("Agregar Articulo");
        btnAgregarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCarritoActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnListarClientes.setText("Listar Clientes");
        btnListarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarClientesActionPerformed(evt);
            }
        });

        tbArticulos.setForeground(new java.awt.Color(153, 51, 0));
        tbArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ARTICULO", "CANTIDAD", "PRECIO", "TOTAL CON IVA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbArticulos.setSelectionBackground(new java.awt.Color(0, 102, 102));
        jScrollPane2.setViewportView(tbArticulos);

        jLabel6.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Codigo:");

        jLabel7.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("CLIENTES");

        jLabel8.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("PRODUCTOS");

        jLabel9.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Nombre:");

        jLabel10.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("Descripcion:");

        jLabel11.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("Stock:");

        jLabel12.setFont(new java.awt.Font("Aharoni", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("Precio:");

        txtcodArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodArtActionPerformed(evt);
            }
        });
        txtcodArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodArtKeyTyped(evt);
            }
        });

        txtNombArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombArtActionPerformed(evt);
            }
        });
        txtNombArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombArtKeyTyped(evt);
            }
        });

        txtDescripArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripArtActionPerformed(evt);
            }
        });
        txtDescripArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripArtKeyTyped(evt);
            }
        });

        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        btnLimpiarArt.setText("Limpiar");
        btnLimpiarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarArtActionPerformed(evt);
            }
        });

        btnRegistrarArt.setText("Registar");
        btnRegistrarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarArtActionPerformed(evt);
            }
        });

        btnListarArt.setText("Listar productos");
        btnListarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarArtActionPerformed(evt);
            }
        });

        btnEliminarArt.setText("Eliminar");
        btnEliminarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarArtActionPerformed(evt);
            }
        });

        btnNuevoArt.setText("Nuevo");
        btnNuevoArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoArtActionPerformed(evt);
            }
        });

        btnBuscarArt.setText("Buscar");
        btnBuscarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarArtActionPerformed(evt);
            }
        });

        btnFacturar.setText("Facturar");
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });

        btnLimpCom.setText("Limpiar Compra");
        btnLimpCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpComActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnListarArt)
                                .addGap(27, 27, 27)
                                .addComponent(btnEliminarArt))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(170, 170, 170)
                                    .addComponent(btnLimpiarArt)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBuscarArt))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel6)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(4, 4, 4)
                                                    .addComponent(jLabel12)))
                                            .addGap(33, 33, 33))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel11)
                                                .addComponent(jLabel10))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtcodArt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPrecio)
                                        .addComponent(txtStock)
                                        .addComponent(txtDescripArt)
                                        .addComponent(txtNombArt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnNuevoArt)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrarArt)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnListarClientes)
                                        .addGap(24, 24, 24)
                                        .addComponent(btnEliminar))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel2)
                                            .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(outCod, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(btnRegistrar)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(btnLimpiar)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btnBuscar))
                                                .addComponent(outTel, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                                .addComponent(txtDireccion)
                                                .addComponent(txtNombre)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3))
                                .addGap(264, 264, 264)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLimpCom)
                        .addGap(31, 31, 31)
                        .addComponent(btnAgregarCarrito)
                        .addGap(18, 18, 18)
                        .addComponent(btnFacturar)))
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(outCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnNuevo)
                            .addComponent(btnBuscar)
                            .addComponent(btnLimpiar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar)
                            .addComponent(btnListarClientes))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtcodArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripArt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevoArt)
                            .addComponent(btnRegistrarArt)
                            .addComponent(btnLimpiarArt)
                            .addComponent(btnBuscarArt)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregarCarrito)
                        .addComponent(btnFacturar)
                        .addComponent(btnLimpCom)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarArt)
                    .addComponent(btnEliminarArt))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void outTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outTelActionPerformed

    private void outCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outCodActionPerformed

    private void btnListarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarClientesActionPerformed
        Tabla_clientes tc = new Tabla_clientes();//crea objeto tabla con referencia tc
        tc.setVisible(true);//muestra la tabla tc
        Cliente C;//referencia Cliente
        tc.Cargar();//carga llamando metodo de la clase del objeto tc
        for (int i=0; i<cc.size(); i++)//recorre contenedor de clientes
            {
            C = (Cliente)cc.get(i);//localiza los datos de contenedor segun posicion
            tc.Mostrar(C);//metodo de Tabla_clientes
            }
        
    }//GEN-LAST:event_btnListarClientesActionPerformed
    //Crea nuevo cliente
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
       
        limpiar();//llama metodo limpiar
        if(cc.isEmpty())//si contenedor de clientes vacio...
        {
            //Activa o desactiva cuadros de texto y botones segun convenga
            outCod.setEnabled(true);
            txtNombre.setEnabled(true);
            txtDireccion.setEnabled(true);
            outTel.setEnabled(true);
            btnBuscar.setEnabled(false);
            btnRegistrar.setEnabled(true);
            btnNuevo.setEnabled(false);
            btnListarClientes.setEnabled(true);
            btnLimpiar.setEnabled(true);
            btnEliminar.setEnabled(false);
        }
        else//caso contrario a que contenedor de clientes contenga algo...
        {
            //Activa o desactiva cuadros de texto y botones segun convenga
            outCod.setEnabled(true);
            txtNombre.setEnabled(true);
            txtDireccion.setEnabled(true);
            outTel.setEnabled(true);
            btnBuscar.setEnabled(true);
            btnRegistrar.setEnabled(true);
            btnNuevo.setEnabled(false);
            btnListarClientes.setEnabled(true);
            btnLimpiar.setEnabled(true);
            btnEliminar.setEnabled(false);
        }
    }//GEN-LAST:event_btnNuevoActionPerformed
    //Elimina un cliente de la lista luego de buscar
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //crea cuadro de confirmacion
        long confirmar = JOptionPane.showConfirmDialog(this,"Seguro Que Desea Borrar El Registro","",JOptionPane.YES_NO_OPTION );
        //
        if(confirmar == JOptionPane.YES_OPTION)//si es confirmado...
            {
            cc.remove(Encontrado);//remueve la posicion guardada luego de buscar
            limpiar();//llama metodo limpiar
            Guardado();//llama metodo guardar
            JOptionPane.showMessageDialog(null, "Registro Eliminado Con Exito");//Mensaje de confirmacion al eliminar
            }
        else//Si no desea eliminar
            {
            JOptionPane.showMessageDialog(null, "Eliminacion Cancelada");//Mensaje de negacion al eliminar
            }
    }//GEN-LAST:event_btnEliminarActionPerformed
    //Registra clientes nuevos
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(verificar() == null)//al verificar si existe codigo...
            {
            long cod = Long.parseLong(outCod.getText().trim());//utiliza auxiliar para obtener codigo
            //Llama los valores ingresados y los asigna a auxiliares
            String nom = txtNombre.getText().trim();
            String dir = txtDireccion.getText().trim();
            String tel = outTel.getText().trim();
            //Crea objeto tipo Cliente con los auxiliares(datos en pantalla)
            Cliente C = new Cliente(cod, nom,dir , tel);
            cc.add(C);//agrega a la lista lo que tiene C
            JOptionPane.showMessageDialog(null, "Registro Guardado Con Exito");//confirmacion de registro
            limpiar();//llama metodo limpiar
            Guardado();//llama metodo guardado
            }else{//Si ya existe el codigo en la lista
            
            JOptionPane.showMessageDialog(null, "Codigo Ya Existe");//Notificacion de que el codigo ya existe
        }
           
    }//GEN-LAST:event_btnRegistrarActionPerformed
    //Accion de boton limpiar
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();//llama metodo limpiar        
        if(cc.isEmpty())//si ccontenedor de clientes esta vacio...
            {
            //habilita y desabilita cuadros de texto y botones segun convenga
            outCod.setEnabled(false);
            txtNombre.setEnabled(false);
            txtDireccion.setEnabled(false);
            outTel.setEnabled(false);
            btnBuscar.setEnabled(false);
            btnRegistrar.setEnabled(false);
            btnNuevo.setEnabled(true);
            btnListarClientes.setEnabled(false);
            btnLimpiar.setEnabled(false);
            btnEliminar.setEnabled(false);
            
            }
        else//si ccontenedor de clientes NO esta vacio..
            {
            //habilita y desabilita cuadros de texto y botones segun convenga
            outCod.setEnabled(false);
            txtNombre.setEnabled(false);
            txtDireccion.setEnabled(false);
            outTel.setEnabled(false);
            btnBuscar.setEnabled(true);
            btnRegistrar.setEnabled(false);
            btnNuevo.setEnabled(true);
            btnListarClientes.setEnabled(false);
            btnLimpiar.setEnabled(false);
            btnEliminar.setEnabled(false);
            }
    }//GEN-LAST:event_btnLimpiarActionPerformed
    //Busca un codigo en contenedor de Clientes
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(Buscar() == null)//LLama metodo buscar y si es nulo...
            {
            JOptionPane.showMessageDialog(null, "Usuario No Existe");//Notifica si no existe usuario
            }
    }//GEN-LAST:event_btnBuscarActionPerformed
    //Agrega articulos al carrito
    private void btnAgregarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCarritoActionPerformed
        comArt=0; // cuenta la cantidad de veces que no encontro el articulo
        Articulo A = null;//referencia con A, Articulo
        long codArt = Long.parseLong(JOptionPane.showInputDialog("Codigo del articulo"));//Pide codigo de articulo a añadir
        for (int i = 0; i<ca.size(); i++){
             A = (Articulo)ca.get(i);//Asigna a A lo que contiene la lista en una posicion especifica
              if(codArt == A.getCodigoArt()){//si encuentra el codigo del articulo continua
                //llama lo que tiene A y lo asigna a auxiliares
                String nomb = A.getNombre();
                String prec = A.getPrecio();
                String Cantidad = JOptionPane.showInputDialog("CANTIDAD");//Pide cantidad
                if(Integer.parseInt(Cantidad) < Integer.parseInt(A.getStock())){//valida la cantidad no sea mayor a stock
                    
                    Compras Co = new Compras(nomb,Cantidad, prec);//crea objeto Co para dar valor a compras
                    cco.add(Co);//agrega lo que contiene Co a compras
                    JOptionPane.showMessageDialog(null, "Añadido al carrito");//notifica que se agrego al carrito
                    limpiarArt();//llamar limpiar para articulo
                    GuardarArt();//llamar guardar para articulo
                    tbArticulos.setVisible(true);//muestra la tabla

                    Compras COM;//referencia COmpras    
                    String data[][] = {};//modelo de filas vacio
                    String columna[] = {"ARTICULO","CANTIDAD","PRECIO","TOTAL CON IVA"};//modelo de columnas
                    modCom = new DefaultTableModel(data,columna);//asiga el modelo a modCOm
                    tbArticulos.setModel(modCom);//A tabla le da modelo que contiene modCom

                    for (int j=0; j<cco.size(); j++)//recorre contenedor de compras
                    { 

                        COM = (Compras)cco.get(j);//llama lo que tiene compras en posiscion j
                        modCom.insertRow(Contador,new Object[]{}); //INSERTA FILA EN TIEMPO DE EJECUCION
                        modCom.setValueAt(COM.getNombre(), Contador, 0);  // ACTUALIZA LA CELDA CON EL VALOR DE CAMPO OBTENIDO
                        modCom.setValueAt(COM.getCantidad(), Contador, 1);    
                        modCom.setValueAt(COM.getPrecio(), Contador, 2);
                        modCom.setValueAt(COM.getPrecioIva(),Contador,3);
                        Contador++; 
                    }
                    Contador = 0;//reinicia el valor de contador
                }else{
                    JOptionPane.showMessageDialog(null, "Cantidad sobrepasa el stock del producto");//Notifica que se sobrepaso un limite
                }
                
            }else{
            comArt++;// El contador avanza
            }
        }
        if(comArt==ca.size()){ 
            //Si el valor final de comArt es igual al valor del tamaño del contenedor de clientes entonces...
            JOptionPane.showMessageDialog(null, "Articulo no existe");// Notifica que el cliente buscado no existe
        }
    }//GEN-LAST:event_btnAgregarCarritoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed
    
    //Elimina un articulo luego de seleccionarlo en la busqueda
    private void btnEliminarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarArtActionPerformed
        //crea cuadro de confirmacion
        long confir = JOptionPane.showConfirmDialog(this,"Seguro Que Desea Borrar El Registro","",JOptionPane.YES_NO_OPTION );
        if(confir == JOptionPane.YES_OPTION)//Si es confirmado...
            {
            ca.remove(EncontradoArt); //remueve la posicion guardada luego de buscar
            limpiarArt(); //Llama metodo limpiar
            GuardarArt(); // Llama metodo guardar
            JOptionPane.showMessageDialog(null, "Registro Eliminado Con Exito");//Notifica que se elimino el registro
            }
        else
            {
            JOptionPane.showMessageDialog(null, "Eliminacion Cancelada"); //Notifica que se cancelo la eliminacion
            }
    }//GEN-LAST:event_btnEliminarArtActionPerformed
    
    //Registra articulos nuevos
    private void btnRegistrarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarArtActionPerformed
        
        if(verificarArt() == null){ // AL verficar si existe codigo del articulo...
        long codi = Long.parseLong(txtcodArt.getText().trim()); //utiliza auxiliar para obtener codigo
        //Llama los valores ingresados y los asigna a auxiliares
            String nomb = txtNombArt.getText().trim();
            String desc = txtDescripArt.getText().trim();
            String stoc = txtStock.getText().trim();
            String prec = txtPrecio.getText().trim();
        //Crea objeto tipo Articulo con los auxiliares(datos en pantalla)
        Articulo A = new Articulo(codi, nomb,desc , stoc, prec);
        ca.add(A);//agrega a la lista lo que tiene A
        JOptionPane.showMessageDialog(null, "Registro Guardado Con Exito"); //Notifica exito al registrar un articulo
        
        limpiarArt();//Llama al metodo limpiar
        GuardarArt();//Llama al metodo guardar
        }else{
            JOptionPane.showMessageDialog(null, "Codigo Ya Existe"); //Notifica que el codigo ya existe
        }
        
    }//GEN-LAST:event_btnRegistrarArtActionPerformed

    //Accion de boton limpiar
    private void btnLimpiarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarArtActionPerformed
        limpiarArt(); //Llama metodo limpiar
        if(ca.isEmpty()) //si contenedor de articulos esta vacio...
            {
            //Habilita botones y campos de texto de acuerdo a conveniencia
            txtcodArt.setEnabled(false);
            txtNombArt.setEnabled(false);
            txtDescripArt.setEnabled(false);
            txtStock.setEnabled(false);
            txtPrecio.setEnabled(false);
            btnBuscarArt.setEnabled(true);
            btnNuevoArt.setEnabled(true);
            btnRegistrarArt.setEnabled(false);
            btnListarArt.setEnabled(false);
            btnLimpiarArt.setEnabled(false);
            
            }
        else // Si el contenedor de articulos NO esta vacio entonces...
            {
            //Habilita botones y campos de texto de acuerdo a conveniencia
            txtcodArt.setEnabled(false);
            txtNombArt.setEnabled(false);
            txtDescripArt.setEnabled(false);
            txtStock.setEnabled(false);
            txtPrecio.setEnabled(false);
            btnBuscarArt.setEnabled(true);
            btnNuevoArt.setEnabled(true);
            btnEliminarArt.setEnabled(false);
            btnRegistrarArt.setEnabled(false);
            btnListarArt.setEnabled(false);
            }
    }//GEN-LAST:event_btnLimpiarArtActionPerformed
    
    //Accion boton Nuevo Articulo
    private void btnNuevoArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoArtActionPerformed
        limpiarArt(); //Llama al metodo LimpiarArt
        if(ca.isEmpty()) //Si contenedor de articulos esta vacio entonces...
        {
            //Habilita botones y campos de texto segun convenga
            txtcodArt.setEnabled(true);
            txtNombArt.setEnabled(true);
            txtDescripArt.setEnabled(true);
            txtStock.setEnabled(true);
            txtPrecio.setEnabled(true);
            btnBuscarArt.setEnabled(false);
            btnNuevoArt.setEnabled(false);
            btnRegistrarArt.setEnabled(true);
            btnListarArt.setEnabled(true);
            btnLimpiarArt.setEnabled(true);
            
        }
        else //Si contenedor de articulos NO esta vacio entonces...
        {
            //Habilita botones y campos de texto segun convenga
            txtcodArt.setEnabled(true);
            txtNombArt.setEnabled(true);
            txtDescripArt.setEnabled(true);
            txtStock.setEnabled(true);
            txtPrecio.setEnabled(true);
            btnBuscarArt.setEnabled(false);
            btnNuevoArt.setEnabled(false);
            btnRegistrarArt.setEnabled(true);
            btnListarArt.setEnabled(true);
            btnLimpiarArt.setEnabled(true);
        }
    }//GEN-LAST:event_btnNuevoArtActionPerformed

    //Accion listrar articulos
    private void btnListarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarArtActionPerformed
       Tabla_Articulos ta = new Tabla_Articulos(); //Crea un objeto Tabla_Articulos llamado ta
        ta.setVisible(true); //Hace visible tabla ta
        Articulo A; //Referencia de Articulo
        ta.CargarArt(); //carga llamando metodo de la clase del objeto ta
        for (int i=0; i<ca.size(); i++) //Recorre contendeor de articulos
            {
            A = (Articulo)ca.get(i); //localiza los datos de contenedor segun posicion
            ta.Mostrar(A); //Metodo de Tabla_Articulos
            }
        
    }//GEN-LAST:event_btnListarArtActionPerformed

    //Boton Buscar articulos
    private void btnBuscarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArtActionPerformed
        if(BuscarArt() == null) //LLama metodo buscarArt y si es nulo...
            {
            JOptionPane.showMessageDialog(null, "Articulo No Existe"); //Notifica que el articulo no existe
            }
    }//GEN-LAST:event_btnBuscarArtActionPerformed

    private void txtcodArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodArtActionPerformed

    // Boton facturar
    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed
         Factura F = new Factura(); //Crea un objeto de la clase Factura llamado F
         F.Facturar(); //Llama al metodo Facturar() con referencia al objeto F
         F.setVisible(true); // Hace visible la factura
               
    }//GEN-LAST:event_btnFacturarActionPerformed

  
    private void txtDescripArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripArtActionPerformed

    //Boton limpia registro de articulos comprados
    private void btnLimpComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpComActionPerformed
        //Genera ventana de confirmacion para borrar registro
        long confirmarBor = JOptionPane.showConfirmDialog(this,"Seguro Que Desea Borrar El Registro","",JOptionPane.YES_NO_OPTION );
        if(confirmarBor == JOptionPane.YES_OPTION) // Si la respuesta es afirmativa....
            {
                for(int i=0;i<=cco.size();i++){ //Recorre contenedor de compras
                    cco.remove(i); //Remueve lo que contiene el contenedor de compras en la posicion asignada
                }
                tbArticulos.setVisible(true); //Hace visible la tabla de Articulos
               
                Compras COM; //Referencia clase Compras
                String data[][] = {}; //Modelo en blanco de las filas
                String columna[] = {"ARTICULO","CANTIDAD","PRECIO","TOTAL CON IVA"};
                modCom = new DefaultTableModel(data,columna); //Asigna a modCom (tabla modelo creada) lo que tiene data y columna
                tbArticulos.setModel(modCom); // Le asigna a tbarticulos (nombre de la tabla) el modelo anterioremente establecido

                for (int j=0; j<cco.size(); j++)
                { 
              
                    COM = (Compras)cco.get(j);
                    modCom.insertRow(Contador,new Object[]{}); //INSERTA FILA EN TIEMPO DE EJECUCION
                    modCom.setValueAt(COM.getNombre(), Contador, 0);  // ACTUALIZA LA CELDA CON EL VALOR DE CAMPO OBTENIDO
                    modCom.setValueAt(COM.getCantidad(), Contador, 1);    
                    modCom.setValueAt(COM.getPrecio(), Contador, 2);
                    modCom.setValueAt(COM.getPrecioIva(),Contador,3);
                    Contador++;//a contador le suma 1 para agregar otra fila
                }
                Contador = 0;//pone contador en ceros para cuando eliminen otra vez
            JOptionPane.showMessageDialog(null, "Compras Eliminadas Con Exito");//Notifica las compras eliminadas
            }
        else// si la confirmacion es nula
            {
            JOptionPane.showMessageDialog(null, "Eliminacion Cancelada");//cancela la eliminacion
            }
    }//GEN-LAST:event_btnLimpComActionPerformed

    private void outCodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outCodKeyTyped
        //comprobar si el valor ingresado es numerico
        char c = evt.getKeyChar();
        if((c<'0') || (c>'9')){
            evt.consume();//si no es numerico no recibe valores 
        }
    }//GEN-LAST:event_outCodKeyTyped

    private void outTelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_outTelKeyTyped
        //comprobar si el valor ingresado es numerico
        char c = evt.getKeyChar();
        if((c<'0') || (c>'9')){
            evt.consume();//si no es numerico no recibe valores 
        }
    }//GEN-LAST:event_outTelKeyTyped

    private void txtcodArtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodArtKeyTyped
       //comprobar si el valor ingresado es numerico
        char c = evt.getKeyChar();
        if((c<'0') || (c>'9')){
            evt.consume();//si no es numerico no recibe valores 
        }
    }//GEN-LAST:event_txtcodArtKeyTyped

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        //comprobar si el valor ingresado es numerico
        char c = evt.getKeyChar();
        if((c<'0') || (c>'9')){
            evt.consume();//si no es numerico no recibe valores 
        }
    }//GEN-LAST:event_txtStockKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        //comprobar si el valor ingresado es numerico
        char c = evt.getKeyChar();
        if((c<'0') || (c>'9')){
            evt.consume();//si no es numerico no recibe valores 
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        //valida el campo de texto para solo ingrasar letras y espacios
        char c = evt.getKeyChar();
        if((c!='ñ')&&(c<97 || c>122)&&(c!=32)){
            evt.consume();//Si no son letras o espacios NO los captura
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNombArtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombArtKeyTyped
        //valida el campo de texto para solo ingrasar letras y espacios
        char c = evt.getKeyChar();
        if((c!='ñ')&&(c<97 || c>122)&&(c!=32)){
            evt.consume();//Si no son letras o espacios NO los captura
        }
    }//GEN-LAST:event_txtNombArtKeyTyped

    private void txtDescripArtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripArtKeyTyped
        //valida el campo de texto para solo ingrasar letras y espacios
        char c = evt.getKeyChar();
        if((c!='ñ')&&(c<97 || c>122)&&(c!=32)){
            evt.consume();//Si no son letras o espacios NO los captura
        }
    }//GEN-LAST:event_txtDescripArtKeyTyped

    private void txtNombArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombArtActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compra().setVisible(true);
            
         
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCarrito;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarArt;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarArt;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btnLimpCom;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiarArt;
    private javax.swing.JButton btnListarArt;
    private javax.swing.JButton btnListarClientes;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevoArt;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrarArt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField outCod;
    private javax.swing.JTextField outTel;
    private javax.swing.JTable tbArticulos;
    private javax.swing.JTextField txtDescripArt;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombArt;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtcodArt;
    // End of variables declaration//GEN-END:variables

}
